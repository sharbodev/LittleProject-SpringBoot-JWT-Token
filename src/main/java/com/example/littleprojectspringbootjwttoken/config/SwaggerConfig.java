package com.example.littleprojectspringbootjwttoken.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .components(new Components().addSecuritySchemes("Bearer token", key()))
                .info(new Info().title("Bobur").description("Write by:sharbodev"))
                .security(List.of(new SecurityRequirement().addList("Bearer token")));
    }

    private SecurityScheme key() {
        return new SecurityScheme()
                .name("Authorization")
                .description("Jwt put token")
                .in(SecurityScheme.In.HEADER)
                .type(SecurityScheme.Type.HTTP)
                .scheme("Bearer");
    }
}
