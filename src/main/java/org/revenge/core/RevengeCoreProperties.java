package org.revenge.core;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class RevengeCoreProperties {
    @Value("${titan.config}")
    private String titanConfig;

    public String getTitanConfig() {
        return "/" + titanConfig;
    }
}
