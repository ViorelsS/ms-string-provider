package it.deda.academy.microservizi.controller;

import it.deda.academy.microservizi.config.CustomConfigurationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StringController {

    @Autowired
    CustomConfigurationProperties customConfigurationProperties;


    @RequestMapping("/string")
    public String getString() {
        System.out.println("\n\n" + customConfigurationProperties.getProperty1() + "\n\n");
        return customConfigurationProperties.getProperty1() + " " + customConfigurationProperties.getProperty2();
    }
}
