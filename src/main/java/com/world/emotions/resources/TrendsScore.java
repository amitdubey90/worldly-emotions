package com.world.emotions.resources;

public class TrendsScore {
	
	String hashtag;
	//TODO We dont need int. We require double.. Please reomove the int field and use the double field
	int score;
	String sentiment;
	
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
	public String getSentiment() {
		return sentiment;
	}
	public void setSentiment(String sentiment) {
		this.sentiment = sentiment;
	}

}
