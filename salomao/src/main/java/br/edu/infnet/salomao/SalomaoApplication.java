package br.edu.infnet.salomao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SalomaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalomaoApplication.class, args);
	}

}
