package com.world.emotions.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.world.emotions.resources.CountryTrends;
import com.world.emotions.resources.TrendsScore;
import com.world.emotions.resources.Tweets;
import com.world.emotions.util.MySQLConnection;

public class CountryTrendsDAOImpl implements CountryTrendsDAO {

	@Override
	public CountryTrends getCountryTrends(String country_name) {
		// TODO Auto-generated method stub

		Connection conn = null;
		CountryTrends ct= new CountryTrends();
		ArrayList<TrendsScore> ts= new ArrayList<TrendsScore>();
		int woeid=-1;

		try {
			conn=MySQLConnection.getConnection();

			String query="select * from locations where location_name=?";


			PreparedStatement command = (PreparedStatement) conn.prepareStatement(query);
			command.setString(1, country_name);
			ResultSet rs= command.executeQuery();

			while(rs.next()){
				woeid=rs.getInt("woeid");	
			}

			System.out.println("USA : "+ woeid);

			command=(PreparedStatement) conn.prepareStatement("select * from trends where location_woeid=?");
			command.setInt(1, woeid);

			rs=command.executeQuery();

			while(rs.next()){

				TrendsScore obj= new TrendsScore();
				System.out.println(rs.getString("hashtag"));
				obj.setHashtag(rs.getString("hashtag"));

				int temp=getAvgSentimentForHashTag(rs.getInt("id"));
				System.out.println("avg sentiment : "+temp);
				
				obj.setScore(temp);
				
				// logic to make emotion string on the basis of temp value range
				 //obj.setSentiment(sentiment); // calculate sentiment on the basis of temp range


				ts.add(obj);
			}

			ct.setTscore(ts);




		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return ct;
	}



	public int getAvgSentimentForHashTag(int hashtag_id){
		System.out.println("hashtag id : "+ hashtag_id);

		int tweet_count=0;
		int sentiment_sum=0;
		Connection conn = null;
		int avg_sentiment=-1;


		try {
			conn=MySQLConnection.getConnection();

			
			PreparedStatement	command=(PreparedStatement) conn.prepareStatement("select * from tweets where hashtag_id=?");
			command.setInt(1, hashtag_id);
			ResultSet rs= command.executeQuery();


			while(rs.next()){
				Long tweet_id =rs.getLong("tweet_id");	
				System.out.println("tweet id : "+tweet_id);

				command=(PreparedStatement) conn.prepareStatement("select * from sentiment_score where tweet_id=?");
				command.setLong(1, tweet_id);
				 ResultSet rd= command.executeQuery();
				 
				 while(rd.next()){
					 sentiment_sum+=rs.getInt("score");
				 }
				 ++tweet_count;

			}

			System.out.println("sentiment sum : "+ tweet_count);
          avg_sentiment=sentiment_sum/tweet_count;



		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return avg_sentiment;
	}

}
