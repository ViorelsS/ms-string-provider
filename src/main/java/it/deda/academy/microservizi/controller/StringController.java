package it.deda.academy.microservizi.controller;

import it.deda.academy.microservizi.clients.StringTransformerClient;
import it.deda.academy.microservizi.config.CustomConfigurationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.context.scope.refresh.RefreshScopeRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RefreshScope
public class StringController {

    @Autowired
    CustomConfigurationProperties customConfigurationProperties;

    @Autowired
    StringTransformerClient stringTransformerClient;

    public void onEvent() {
        System.out.println();
    }

    @RequestMapping("/string")
    @EventListener({ApplicationReadyEvent.class, RefreshScopeRefreshedEvent.class})
    public Map<String, String> getString() {
        Map<String, String> response = new HashMap<>();
        String propertiesString = customConfigurationProperties.getProperty1() + " " + customConfigurationProperties.getProperty2();
        response.put("properties", propertiesString);
        response.put("serverPort", customConfigurationProperties.getServerPort());

        String transformedString = stringTransformerClient.transformString(propertiesString);
        response.put("transformedProperties", transformedString);

        return response;
    }

}
