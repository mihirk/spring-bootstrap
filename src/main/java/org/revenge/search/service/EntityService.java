package org.revenge.search.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.LimitFilterBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.revenge.search.DatabaseProperties;
import org.revenge.search.model.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.elasticsearch.index.query.FilterBuilders.limitFilter;
import static org.elasticsearch.index.query.QueryBuilders.matchPhrasePrefixQuery;

@Service
public class EntityService {

    private final Client client;
    private final ObjectMapper mapper;
    private final String indexName;
    public static final String ENTITY = "ENTITY";

    @Autowired
    public EntityService(Client databaseClient, DatabaseProperties databaseProperties) {
        this.client = databaseClient;
        mapper = new ObjectMapper();
        indexName = databaseProperties.getIndex();
    }

    public Entity create(Entity entity) throws Exception {
        IndexRequest indexRequest = new IndexRequest(indexName, ENTITY, entity.getName())
                .source(entity.json());
        UpdateRequest updateRequest = new UpdateRequest(indexName, ENTITY, entity.getName())
                .doc(entity.json())
                .upsert(indexRequest);
        UpdateResponse updateResponse = client
                .update(updateRequest)
                .get();
        return new Entity(client.prepareGet(indexName, ENTITY, updateResponse.getId())
                .setOperationThreaded(false)
                .execute()
                .actionGet()
                .getSourceAsString());
    }

    public List<Entity> search(String term) throws IOException {
        List<Entity> entities = new ArrayList<>();
        MatchQueryBuilder search = matchPhrasePrefixQuery(ENTITY.concat(".name"), term)
                .boost(2.0f);
        LimitFilterBuilder limit = limitFilter(10);
        SearchResponse searchResponse = client.prepareSearch(indexName)
                .setTypes(ENTITY)
                .setQuery(search)
                .setPostFilter(limit)
                .execute()
                .actionGet();
        for (SearchHit hit : searchResponse.getHits()) {
            entities.add(new Entity(hit.getSourceAsString()));
        }
        return entities;
    }
}
