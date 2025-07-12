package br.com.postechfiap.reposicao_estoque;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableFeignClients(basePackages = "br.com.postechfiap.reposicao_estoque")
public class ReposicaoEstoqueApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReposicaoEstoqueApplication.class, args);
	}

}
