package com.caixa.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.caixa.demo.dto.PhysicalDTO;
import com.caixa.demo.patterns.DepositPublisherObserver;

@SpringBootApplication
public class CaixaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CaixaApplication.class, args);
		PhysicalDTO personPhysical = new PhysicalDTO();
		DepositPublisherObserver depositPublisherObserver = new DepositPublisherObserver();
		depositPublisherObserver.subscribe(personPhysical);
	}

}
