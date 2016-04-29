package org.openchs.search;

import org.elasticsearch.client.Client;
import org.elasticsearch.node.Node;
import org.elasticsearch.node.NodeBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PreDestroy;

@Configuration
public class DatabaseConfiguration {
    @Bean
    public Client databaseClient() {
        Node node = new NodeBuilder().local(true).node();
        return node.client();
    }

    @PreDestroy
    public void shutdownClient(){
        databaseClient().close();
    }
}
