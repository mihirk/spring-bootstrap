package org.revenge.core;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@Import(RevengeCoreConfiguration.class)
@ComponentScan("org.revenge.core")
@SpringBootApplication
public class RevengeCore extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(RevengeCore.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(RevengeCore.class, args);
    }
}