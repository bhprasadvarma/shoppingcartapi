package com.varma.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 
 * @author Varma
 *
 */
@SpringBootApplication
@ComponentScan(basePackages={"com.varma"})
public class CartApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CartApiApplication.class, args);
	}

}
