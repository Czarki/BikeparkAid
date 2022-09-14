package pl.czrmjd.bikeparkaid;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@NoArgsConstructor
@Configuration
public class AppConfiguration {
    @Value("${emailHost}")
    private String emailHost;

    @Value("${emailPort}")
    private Integer emailPort;

    @Value("${emailUsername}")
    private String emailUsername;

    @Value("${emailPassword}")
    private String emailPassword;
}
