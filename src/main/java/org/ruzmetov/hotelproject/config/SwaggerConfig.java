package org.ruzmetov.hotelproject.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import java.util.List;

public class SwaggerConfig { // http://localhost:8080/swagger-ui/index.html

    @Bean
    public GroupedOpenApi infoServiceApi() {
        return GroupedOpenApi.builder()
                .group("info-service")
                .pathsToMatch("/customer/**", "/event/**", "/payment/**", "/reservation/**", "/room/**", "/service/**")
                .build();
    }

    @Bean
    public OpenAPI customOpenApi(@Value("${app.description}") String appDescription,
                                 @Value("${app.version}") String appVersion,
                                 @Value("${app.server.url}") String serverUrl,
                                 @Value("${app.server.stage}") String stage) {
        return new OpenAPI()
                .info(new Info().title("Info service API")
                        .version(appVersion)
                        .description(appDescription))
                .servers(List.of(new Server()
                        .url(serverUrl)
                        .description(stage)));
    }

}
