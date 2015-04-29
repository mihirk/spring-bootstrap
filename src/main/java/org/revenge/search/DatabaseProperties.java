package org.revenge.search;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component("databaseProperties")
@PropertySource("classpath:database.properties")
public class DatabaseProperties {
    @Value("${host}")
    private String host;

    @Value("${port}")
    private Integer port;

    public String getHost() {
        return host;
    }

    public Integer getPort() {
        return port;
    }
}
