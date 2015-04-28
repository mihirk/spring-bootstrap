package org.revenge.search;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class RevengeSearchProperties {
    @Value("${db.host}")
    private String databaseHost;

    @Value("${db.port}")
    private Integer databasePort;

    public String getDatabaseHost() {
        return databaseHost;
    }

    public Integer getDatabasePort() {
        return databasePort;
    }
}
