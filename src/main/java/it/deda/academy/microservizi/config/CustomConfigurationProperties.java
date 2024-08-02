package it.deda.academy.microservizi.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "ms-string")
public class CustomConfigurationProperties {

    private String property1;
    private String property2;

}
