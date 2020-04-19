
package com.zemoga.portfolio.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.social.ApiException;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Service;

import com.zemoga.portfolio.model.PortfolioModel;
import com.zemoga.portfolio.model.Tweet;
import com.zemoga.portfolio.persistence.PortfolioRepository;
import com.zemoga.portfolio.services.PortfolioService;

@Service
@Qualifier("defaultPortfolioServiceImpl")
public class DefaultPortfolioServiceImpl implements PortfolioService {

	@Autowired
	@Qualifier("defaultPortfolioRepositoryImpl")
	private PortfolioRepository portfolioRepository;
	
	@Autowired
	private Twitter twitter;
	
	@Override
	public Optional<PortfolioModel> findById(Long id) {
		Optional<PortfolioModel> optPortfolioModel = portfolioRepository.findById(id);
		
		if(optPortfolioModel.isPresent()) {
			PortfolioModel portfolioModel = optPortfolioModel.get();
			List<Tweet> fiveLasttweets = this.getTweetsByUser(portfolioModel.getTwitterUserName());
			portfolioModel.setTweets(fiveLasttweets);
		}
		
		return optPortfolioModel;
	}

	@Override
	public List<PortfolioModel> filter(PortfolioModel filter) {
		return this.portfolioRepository.filter(filter);
	}
	
	private List<Tweet> getTweetsByUser(String twitterUserName) {
		List<Tweet> fiveLasttweets = new ArrayList<>();
		
		try {
			List<org.springframework.social.twitter.api.Tweet> tweets = twitter.timelineOperations().getUserTimeline(twitterUserName);
			
			tweets.stream().limit(5).forEach(tw -> {
				Tweet tweet = new Tweet();
				tweet.setId(tw.getId());
				tweet.setDescription(tw.getText());
				tweet.setTitle(tw.getCreatedAt().toString());
				
				fiveLasttweets.add(tweet);
			});
		} catch (ApiException e) {
			// TODO: handle exception, in this case log a warn with the exception message
		}
		
		return fiveLasttweets;
	}

	@Override
	public int upate(PortfolioModel portfolioModel) {
		return this.portfolioRepository.upate(portfolioModel);
	}
}
