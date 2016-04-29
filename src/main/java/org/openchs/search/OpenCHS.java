package org.openchs.search;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@Import({DatabaseConfiguration.class, ServletConfiguration.class})
@ComponentScan("org.openchs.search")
@SpringBootApplication
public class OpenCHS extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(OpenCHS.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(OpenCHS.class, args);
    }
}
