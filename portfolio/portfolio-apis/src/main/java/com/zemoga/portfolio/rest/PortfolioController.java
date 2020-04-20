package com.zemoga.portfolio.rest;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zemoga.portfolio.model.PortfolioModel;
import com.zemoga.portfolio.services.PortfolioService;

@RestController
@RequestMapping("/portfolio")
public class PortfolioController {
	
	@Autowired
	private PortfolioService portfolioService;
	
	@GetMapping(value="/ping")
	public String ping() {
		return "pong";
	}
	
	@GetMapping(value="/{id}")
	public PortfolioModel findById(@PathVariable("id") Long id) {
		PortfolioModel portfolio = null;
		
		if(!Objects.isNull(id)) {
			Optional<PortfolioModel> portfolioModelOptional = this.portfolioService.findById(id);
			
			if(portfolioModelOptional.isPresent()) {
				portfolio = portfolioModelOptional.get();
			}
		}
		
		return portfolio;
	}
	
	@PutMapping(value = "/update")
	public String update(@RequestBody PortfolioModel portfolioModel) {
		int result = this.portfolioService.upate(portfolioModel);
		
		return result + " portfolios updated";
	}
}
