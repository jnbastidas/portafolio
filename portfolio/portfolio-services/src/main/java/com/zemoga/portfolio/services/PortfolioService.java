package com.zemoga.portfolio.services;

import java.util.List;
import java.util.Optional;

import com.zemoga.portfolio.model.PortfolioModel;

public interface PortfolioService {
	Optional<PortfolioModel> findById(Long id);
	
	List<PortfolioModel> filter(PortfolioModel filter);
	
	int upate(PortfolioModel portfolioModel);
}
