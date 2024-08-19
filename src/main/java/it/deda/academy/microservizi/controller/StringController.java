package it.deda.academy.microservizi.controller;

import it.deda.academy.microservizi.config.CustomConfigurationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.context.scope.refresh.RefreshScopeRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class StringController {

    @Autowired
    CustomConfigurationProperties customConfigurationProperties;


   public void onEvent(){
       System.out.println();
   }

    @RequestMapping("/string")
    @EventListener({ApplicationReadyEvent.class, RefreshScopeRefreshedEvent.class})
    public String getString() {
        return customConfigurationProperties.getProperty1() + " " + customConfigurationProperties.getProperty2();
    }

}
