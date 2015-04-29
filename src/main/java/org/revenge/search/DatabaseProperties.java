package org.revenge.search;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component("databaseProperties")
@PropertySource("classpath:database.properties")
public class DatabaseProperties {
    @Value("${index}")
    private String index;

    public String getIndex() {
        return index;
    }
}
