package com.poc.common.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerOpenAPIConfig {

    @Bean
    public OpenAPI poCOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Spring Security OAuth2 API")
                        .description("PoC Spring Security OAuth2")
                        .version("v0.0.1")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("Darvin Wiki Documentation")
                        .url("https://github.com/darvin-rakotomalala"));
    }

}
