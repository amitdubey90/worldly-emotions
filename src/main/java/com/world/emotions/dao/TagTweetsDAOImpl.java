package com.world.emotions.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.world.emotions.resources.TagTweets;
import com.world.emotions.resources.Tweets;
import com.world.emotions.util.MySQLConnection;
import com.world.emotions.util.TweetSentiment;

public class TagTweetsDAOImpl implements TagTweetsDAO {

	@Override
	public TagTweets getTweetsforTag(String tag) {
		Connection conn = null;
		TagTweets t = new TagTweets();
		int d = -1;
		ArrayList<Tweets> twt = new ArrayList<Tweets>();

		try {
			conn = MySQLConnection.getConnection();

			String query = "select t.text,t.tweet_id,t.profile_img_url,t.user_name,s.score from tweets t, sentiment_score s where "
					+ "hashtag_id=(select id from trends where lower(hashtag) LIKE lower(?)) and t.tweet_id=s.tweet_id order by timestamp limit 50";
			
			/*String query = "select t.tweet_id, t.text, s.score
					   FROM
					      tweets t,
					      sentiment_score s
					   WHERE
					      t.hashtag_id = (SELECT 
					              id
					          FROM
					              trends
					          WHERE
					              LOWER(hashtag) LIKE LOWER('%Baltimore%'))
					           and t.tweet_id = s.tweet_id   
					   order by timestamp desc limit 50";
*/
			PreparedStatement command = conn.prepareStatement(query);
			command.setString(1, "%" + tag + "%");
			ResultSet rs = command.executeQuery();

			while (rs.next()) {

				Tweets obj = new Tweets();
				// System.out.println(rs.getString("text"));
				obj.setTweet_Text(rs.getString("text"));
				obj.setTweet_Id(rs.getLong("tweet_id"));
				obj.setUrl(rs.getString("profile_img_url"));
				obj.setUser(rs.getString("user_name"));
				
				int temp=(int) Math.round((rs.getDouble("score")));
				
				System.out.println("temp  : "+ temp);
				if(TweetSentiment.NEGATIVE.getStatusCode()==temp)
				{
					System.out.println("negative : "+TweetSentiment.NEGATIVE);
					obj.setSentiment(TweetSentiment.NEGATIVE);
				}
				else if (TweetSentiment.NEUTRAL.getStatusCode()==temp){
					System.out.println("neutral : "+TweetSentiment.NEUTRAL);
					obj.setSentiment(TweetSentiment.NEUTRAL);
				}
				else if(TweetSentiment.POSITIVE.getStatusCode()==temp)
				{
					System.out.println("positive : "+TweetSentiment.POSITIVE);
					obj.setSentiment(TweetSentiment.POSITIVE);
				}
				else if(TweetSentiment.VERYPOSITIVE.getStatusCode()==temp)
				{
					System.out.println("very positive : "+TweetSentiment.VERYPOSITIVE);
					obj.setSentiment(TweetSentiment.VERYPOSITIVE);

				}

				twt.add(obj);
			}

			t.setTweet(twt);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return t;

	}

}
