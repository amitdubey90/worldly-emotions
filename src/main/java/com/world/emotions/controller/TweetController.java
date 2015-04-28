package com.world.emotions.controller;

import java.util.List;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.world.emotions.dao.CountryTrendsDAO;
import com.world.emotions.dao.CountryTrendsDAOImpl;
import com.world.emotions.dao.TagTweetsDAO;
import com.world.emotions.dao.TagTweetsDAOImpl;
import com.world.emotions.resources.CountryTrends;
import com.world.emotions.resources.CountryWiseTrendSentiment;
import com.world.emotions.resources.TagTweets;
import com.world.emotions.resources.TrendsScore;




@RestController
@EnableAutoConfiguration
@ComponentScan
@RequestMapping("/api/v1/")
public class TweetController {
	
     public static  TagTweetsDAO tt= new TagTweetsDAOImpl();
     public static CountryTrendsDAO ct= new CountryTrendsDAOImpl();
	
	@RequestMapping(value="/countrywisetrendsentiment", method=RequestMethod.GET)
	public ResponseEntity<CountryWiseTrendSentiment> getAllTrendSentiment( ){
		
		CountryWiseTrendSentiment c= ct.getSentimentForCountry();  
	
		return new ResponseEntity<CountryWiseTrendSentiment>(c, HttpStatus.OK);
		
	}
	
	
	@RequestMapping(value="/getcountrytrends/{country_name}", method=RequestMethod.GET)
	public ResponseEntity<CountryTrends> getTrendsForCountry(@PathVariable String country_name ){
		
		System.out.println("received : "+country_name);
		
		List<TrendsScore> trends = ct.getTrendsForCountry(country_name);                          
		CountryTrends c = new CountryTrends();
		c.setTscore(trends);
		return new ResponseEntity<CountryTrends>(c, HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/gettweetsforhashtag/{hashtag}", method=RequestMethod.GET)
	public ResponseEntity<TagTweets> getTweetsForHashTag(@PathVariable String hashtag ){
		
		
		System.out.println("received : "+hashtag);
		TagTweets c= tt.getTweetsforTag(hashtag);
		
		
	
		return new ResponseEntity<TagTweets>(c, HttpStatus.OK);
		
	}
	

}
