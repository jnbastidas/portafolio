package com.zemoga.portfolio.model;

import java.io.Serializable;
import java.util.List;

public class PortfolioModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String TABLE_NAME = "portfolio";
	
	public static final String ID = "idportfolio";
	public static final String DESCRIPTION = "description";
	public static final String IMAGE_URL = "image_url";
	public static final String TWITTER_USER_NAME = "twitter_user_name";
	public static final String TITTLE = "title";
	
	private Long id;
	private String description;	
	private String imageUrl;
	private String twitterUserName;	
	private String title;
	
	private List<Tweet> tweets;
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getTwitterUserName() {
		return twitterUserName;
	}

	public void setTwitterUserName(String twitterUserName) {
		this.twitterUserName = twitterUserName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Tweet> getTweets() {
		return tweets;
	}

	public void setTweets(List<Tweet> tweets) {
		this.tweets = tweets;
	}
	
	
}