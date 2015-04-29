package org.revenge.search;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class RevengeSearchProperties {
    @Value("${titan.config}")
    private String titanConfig;

    public String getTitanConfig() {
        return "/" + titanConfig;
    }
}
