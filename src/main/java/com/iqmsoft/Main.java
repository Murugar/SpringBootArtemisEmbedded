
package com.iqmsoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan("com.iqmsoft")
@EnableScheduling
public class Main {

	public static void main(String[] args) throws Exception {
		System.out.println("Creating bean factory...");

		SpringApplication.run(Main.class, args);

		System.out.println("Listening..."); 
		
	}
}
