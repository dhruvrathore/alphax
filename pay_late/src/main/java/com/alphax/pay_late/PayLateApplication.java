package com.alphax.pay_late;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(value = "com.alphax", excludeFilters = @ComponentScan.Filter(SpringBootApplication.class))
public class PayLateApplication {

	public static void main(String[] args) {
		SpringApplication.run(PayLateApplication.class, args);
	}

}
