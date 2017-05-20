package com.prover.prover;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication(scanBasePackages={"com.prover.prover"})
public class ProverApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProverApplication.class, args);
	}
}
