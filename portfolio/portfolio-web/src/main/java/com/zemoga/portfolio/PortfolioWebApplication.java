package com.zemoga.portfolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = {"com.zemoga.portfolio"})
public class PortfolioWebApplication {
	public static void main(String[] args) {
		SpringApplication.run(PortfolioWebApplication.class, args);
	}
}
