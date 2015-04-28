package com.world.emotions.util;

public enum TweetSentiment {
	
	NEGATIVE(1), NEUTRAL(2), POSITIVE(3), VERYPOSITIVE(4);
	 
	private int sentimentValue;
 
	private TweetSentiment(int s) {
		sentimentValue = s;
	}
 
	public int getStatusCode() {
		return sentimentValue;
	}

	
}
