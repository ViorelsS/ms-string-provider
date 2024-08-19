package it.deda.academy.microservizi.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

//TODO: spostare url dentro application-properties

@FeignClient(name = "ms-string-transformer", url = "${ms-string-transformer.url}")
public interface StringTransformerClient {

    @GetMapping("/")
    String transformString(@RequestParam String string);
}
