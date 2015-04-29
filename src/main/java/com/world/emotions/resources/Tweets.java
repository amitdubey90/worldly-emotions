package com.world.emotions.resources;

import com.world.emotions.util.TweetSentiment;

public class Tweets {
	
	long tweet_Id;
	String tweet_Text;
	String  url;
	String user;
	TweetSentiment sentiment;
	
	public long getTweet_Id() {
		return tweet_Id;
	}
	public void setTweet_Id(long tweet_Id) {
		this.tweet_Id = tweet_Id;
	}
	public String getTweet_Text() {
		return tweet_Text;
	}
	public void setTweet_Text(String tweet_Text) {
		this.tweet_Text = tweet_Text;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public TweetSentiment getSentiment() {
		return sentiment;
	}
	public void setSentiment(TweetSentiment sentiment) {
		this.sentiment = sentiment;
	}
	

}
