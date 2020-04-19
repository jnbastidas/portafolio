package com.zemoga.portfolio.controller;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zemoga.portfolio.model.PortfolioModel;
import com.zemoga.portfolio.services.PortfolioService;

@Controller
@RequestMapping("/portfolio")
public class PortfolioController {
	
	@Autowired
	private PortfolioService portfolioService;
	
	@GetMapping
    public String welcome(Model model) {
		model.addAttribute("filter", new PortfolioModel());
        return "portfolio";
    }
	
	@GetMapping("/filter")
	public String filter(Model model, PortfolioModel filter) {
		if(!Objects.isNull(filter)) {
			List<PortfolioModel> portfolios = this.portfolioService.filter(filter);
			model.addAttribute("portfolios", portfolios);
		} else {
			filter = new PortfolioModel();
		}
		
		model.addAttribute("filter", filter);
		
		return "portfolio";
	}
	
	@GetMapping("/find-by-id")
	public String findById(Model model, Long id) {
		PortfolioModel portfolio = null;
		
		if(!Objects.isNull(id)) {
			Optional<PortfolioModel> portfolioModelOptional = this.portfolioService.findById(id);
			
			if(portfolioModelOptional.isPresent()) {
				portfolio = portfolioModelOptional.get();
			}
		}
		
		model.addAttribute("portfolio", portfolio);
		
		return "profile";
	}
}
