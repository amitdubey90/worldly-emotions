package com.world.emotions.resources;

import com.world.emotions.util.TweetSentiment;

public class TrendsScore {
	
	String hashtag;
	//TODO We dont need int. We require double.. Please reomove the int field and use the double field
	int score;
	TweetSentiment sentiment;
	
	double sentimentScore;
	
	public double getSentimentScore() {
		return sentimentScore;
	}
	public void setSentimentScore(double sentimentScore) {
		this.sentimentScore = sentimentScore;
	}
	public String getHashtag() {
		return hashtag;
	}
	public void setHashtag(String hashtag) {
		this.hashtag = hashtag;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public TweetSentiment getSentiment() {
		return sentiment;
	}
	public void setSentiment(TweetSentiment sentiment) {
		this.sentiment = sentiment;
	}
	

}
