package com.world.emotions.resources;

import com.world.emotions.util.TweetSentiment;

public class CountryScore {
	
	String country;
	double  score;
	TweetSentiment sentiment;
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public TweetSentiment getSentiment() {
		return sentiment;
	}
	public void setSentiment(TweetSentiment sentiment) {
		this.sentiment = sentiment;
	}
	

}
