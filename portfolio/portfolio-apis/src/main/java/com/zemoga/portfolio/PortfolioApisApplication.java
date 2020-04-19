package com.zemoga.portfolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = {"com.zemoga.portfolio"})
public class PortfolioApisApplication {
	public static void main(String[] args) {
		SpringApplication.run(PortfolioApisApplication.class, args);
	}
}