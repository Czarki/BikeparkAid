package pl.czrmjd.bikeparkaid;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.*;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI provideOpenApi() {
        return new OpenAPI()
            .info(getApiInfo());
    }

    @Bean
    public GroupedOpenApi provideGroupedOpenApi() {
        return GroupedOpenApi.builder()
            .group("swagger")
            .pathsToMatch("/**")
            .build();
    }

    private Info getApiInfo() {
        License license = new License();
        license.setName("Apache License Version 2.0");
        license.setUrl("https://www.apache.org/licenses/LICENSE-2.0");
        Contact contact = new Contact();

        return new Info()
            .title("Api documentation")
            .description("")
            .license(license)
            .version("1.0")
            .contact(contact)
            .termsOfService("");
    }
}


