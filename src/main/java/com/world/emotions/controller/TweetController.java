package com.world.emotions.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.world.emotions.dao.TagTweetsDAO;
import com.world.emotions.dao.TagTweetsDAOImpl;
import com.world.emotions.resources.CountryTrends;
import com.world.emotions.resources.CountryWiseTrendSentiment;
import com.world.emotions.resources.TagTweets;



@RestController
public class TweetController {
	
      TagTweetsDAO tt= new TagTweetsDAOImpl();
	
	@RequestMapping(value="/countrywisetrendsentiment", method=RequestMethod.GET)
	public ResponseEntity<CountryWiseTrendSentiment> getAllTrendSentiment( ){
		
		CountryWiseTrendSentiment c= new CountryWiseTrendSentiment();  // To be written
	
		return new ResponseEntity<CountryWiseTrendSentiment>(c, HttpStatus.OK);
		
	}
	
	
	@RequestMapping(value="/getcountrytrends/{country_name}", method=RequestMethod.GET)
	public ResponseEntity<CountryTrends> getTrendsForCountry(@PathVariable String country_name ){
		
		CountryTrends c= new CountryTrends();                          // To be written
	
		return new ResponseEntity<CountryTrends>(c, HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/gettweetsforhashtag/{hashtag}", method=RequestMethod.GET)
	public ResponseEntity<TagTweets> getTweetsForHashTag(@PathVariable String hashtag ){
		
		TagTweets c= tt.getTweetsforTag(hashtag);                               
	
		return new ResponseEntity<TagTweets>(c, HttpStatus.OK);
		
	}
	

}
