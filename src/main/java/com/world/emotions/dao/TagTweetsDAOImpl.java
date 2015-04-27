package com.world.emotions.dao;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.world.emotions.resources.TagTweets;
import com.world.emotions.resources.Tweets;
import com.world.emotions.util.MySQLConnection;

public class TagTweetsDAOImpl implements TagTweetsDAO {

	@Override
	public TagTweets getTweetsforTag(String tag) {
		Connection conn = null;
		TagTweets t= new TagTweets();
		int d=-1;
		ArrayList<Tweets> twt= new ArrayList<Tweets>();

		try {
			conn=MySQLConnection.getConnection();

			String query="select * from trends where hashtag=?";


			PreparedStatement command = (PreparedStatement) conn.prepareStatement(query);
		    command.setString(1, tag);
			ResultSet rs= command.executeQuery();
			
			
			while(rs.next()){
				 d=rs.getInt("id");	
			}
			
			// need to extract tweets based on above id.
			
			command=(PreparedStatement) conn.prepareStatement("select * from tweets where hashtag_id=?");
			command.setInt(1, d);
			
			rs=command.executeQuery();
			
			while(rs.next()){
				
				Tweets obj= new Tweets();
				System.out.println(rs.getString("text"));
				obj.setTweet_Text(rs.getString("text"));
				obj.setTweet_Id(rs.getLong("tweet_id"));
				obj.setUrl(rs.getString("profile_img_url"));
				obj.setUser(rs.getString("user_name"));
				
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
