package com.zemoga.portfolio.persistence;

import java.util.List;
import java.util.Optional;

import com.zemoga.portfolio.model.PortfolioModel;

public interface PortfolioRepository {
	Optional<PortfolioModel> findById(Long id);
	
	List<PortfolioModel> filter(PortfolioModel filter);
	
	int upate(PortfolioModel portfolioModel);
}