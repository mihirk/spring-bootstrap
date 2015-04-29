package org.revenge.search;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@Import({DatabaseConfiguration.class, ServletConfiguration.class})
@ComponentScan("org.revenge.search")
@SpringBootApplication
public class RevengeSearch extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(RevengeSearch.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(RevengeSearch.class, args);
    }
}