package org.revenge.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RevengeSearchConfiguration {
    @Autowired
    private RevengeSearchProperties applicationProperties;

    @Bean
    public String titanGraph() {
        return "";
    }
}
