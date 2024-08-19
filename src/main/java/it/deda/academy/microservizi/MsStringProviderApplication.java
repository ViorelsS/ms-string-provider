package it.deda.academy.microservizi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "it.deda.academy.microservizi.clients")
public class MsStringProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsStringProviderApplication.class, args);
	}

}
