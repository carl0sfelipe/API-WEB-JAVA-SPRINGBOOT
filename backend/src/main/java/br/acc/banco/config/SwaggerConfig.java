package br.acc.banco.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(new Info()
                .title("Banco API")
                .version("1.0.0.SNAPSHOT")
                .termsOfService("http://swagger.io/terms")
                .license(new License()
                        .name("Apache 2.0")
                        .url("http://springdoc.org")));
    }

}
