package org.revenge.search;

import com.aerospike.client.AerospikeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import(DatabaseProperties.class)
@Configuration
public class DatabaseConfiguration {
    @Autowired
    private DatabaseProperties databaseProperties;

    @Bean
    public AerospikeClient dbClient() {
        AerospikeClient aerospikeClient = new AerospikeClient(databaseProperties.getDatabaseHost(), databaseProperties.getDatabasePort());
        return aerospikeClient;
    }
}
