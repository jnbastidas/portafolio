package com.zemoga.portfolio.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.impl.TwitterTemplate;

@Configuration
@ComponentScan(basePackages = "com.zemoga.portfolio")
@PropertySource(value = { "classpath:module.properties" })
public class ServicesModuleConfig {
	@Autowired
    private Environment env;
 
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(this.env.getRequiredProperty("spring.datasource.driver-class-name"));
        dataSource.setUrl(this.env.getRequiredProperty("spring.datasource.url"));
        dataSource.setUsername(this.env.getRequiredProperty("spring.datasource.username"));
        dataSource.setPassword(this.env.getRequiredProperty("spring.datasource.password"));
        return dataSource;
    }
 
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.setResultsMapCaseInsensitive(true);
        return jdbcTemplate;
    }
    
    @Bean
    public Twitter getTwitterTemplate() {
        String consumerKey = this.env.getProperty("twitter.api.key");
        String consumerSecret = this.env.getProperty("twitter.api.secret.key");
        String accessToken = this.env.getProperty("twitter.access.token");
        String accessTokenSecret = this.env.getProperty("twitter.access.token.secret");
        
        TwitterTemplate twitterTemplate = new TwitterTemplate(consumerKey, consumerSecret, accessToken, accessTokenSecret);
        
        return twitterTemplate;
     }
}
