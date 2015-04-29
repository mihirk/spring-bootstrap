package org.revenge.search.service;

import com.thinkaurelius.titan.core.TitanGraph;
import com.thinkaurelius.titan.core.TitanGraphQuery;
import com.thinkaurelius.titan.core.TitanTransaction;
import com.thinkaurelius.titan.core.attribute.Text;
import com.tinkerpop.blueprints.Vertex;
import org.revenge.search.mapper.ObjectVertexMapper;
import org.revenge.search.model.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EntityService {

    private final ApplicationContext applicationContext;
    private TitanGraph titanGraph;
    private final ObjectVertexMapper<Entity> entityVertexMapper;

    @Autowired
    public EntityService(TitanGraph titanGraph, ApplicationContext applicationContext) {
        this.titanGraph = titanGraph;
        entityVertexMapper = new ObjectVertexMapper<>();
        this.applicationContext = applicationContext;
    }

    public Entity create(Entity entity) throws IllegalAccessException {
        entity.setUuid(UUID.randomUUID().toString());
        TitanTransaction titanTransaction = titanGraph.newTransaction();
        Vertex vertex = entityVertexMapper.toVertex(titanTransaction.addVertex(null), entity);
        entity = entityVertexMapper.toObject(vertex, entity);
        titanTransaction.commit();
        return entity;
    }

    public List<Entity> get(String name) throws IllegalAccessException {
        List<Entity> entities = new ArrayList<>();
        TitanTransaction titanTransaction = titanGraph.newTransaction();
        TitanGraphQuery searchResults = titanTransaction.query().has("name", Text.CONTAINS_PREFIX, name);
        Iterable<Vertex> vertices = searchResults.vertices();
        for (Vertex vertex : vertices) {
            entities.add(entityVertexMapper.toObject(vertex, new Entity()));
        }
        titanTransaction.commit();
        return entities;
    }

    public void deleteAll() {
        TitanTransaction titanTransaction = titanGraph.newTransaction();
        Iterable<Vertex> vertices = titanTransaction.getVertices();
        for (Vertex vertex : vertices) {
            vertex.remove();
        }
        titanTransaction.commit();
    }
}
