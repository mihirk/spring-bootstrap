package org.revenge.core;

import com.thinkaurelius.titan.core.PropertyKey;
import com.thinkaurelius.titan.core.TitanFactory;
import com.thinkaurelius.titan.core.TitanGraph;
import com.thinkaurelius.titan.core.schema.Mapping;
import com.thinkaurelius.titan.core.schema.TitanGraphIndex;
import com.thinkaurelius.titan.core.schema.TitanManagement;
import com.tinkerpop.blueprints.Vertex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RevengeCoreConfiguration {
    @Autowired
    private RevengeCoreProperties applicationProperties;

    @Bean
    public TitanGraph titanGraph() {
        TitanGraph graph = TitanFactory.open(this.getClass().getResource(applicationProperties.getTitanConfig()).getPath());
        createIndices(graph);
        return graph;
    }

    private void createIndices(TitanGraph graph) {
        TitanManagement graphManagement = graph.getManagementSystem();
        String byName = "byName";
        String byUuid = "byUuid";
        TitanGraphIndex nameIndex = graphManagement.getGraphIndex(byName);
        TitanGraphIndex uuidIndex = graphManagement.getGraphIndex(byUuid);
        if (nameIndex == null) {
            PropertyKey name = graphManagement.makePropertyKey("name").dataType(String.class).make();
            graphManagement.buildIndex(byName, Vertex.class).addKey(name, Mapping.TEXTSTRING.getParameter()).buildMixedIndex("search");
        }
        if (uuidIndex == null) {
            PropertyKey uuid = graphManagement.makePropertyKey("uuid").dataType(String.class).make();
            graphManagement.buildIndex(byUuid, Vertex.class).addKey(uuid, Mapping.TEXTSTRING.getParameter()).buildMixedIndex("search");
        }
        graphManagement.commit();

    }
}
