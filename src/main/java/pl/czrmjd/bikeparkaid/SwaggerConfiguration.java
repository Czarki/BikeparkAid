package pl.czrmjd.bikeparkaid;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket provideDocket() {
        //ctrl + p
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(new ApiInfo("Bikepark Aid Api Documentation", "description",
                "1.0", "", new Contact("Cezary Majda","",""), "", "",
                Collections.emptyList()));

    }
}


