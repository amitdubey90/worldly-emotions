package com.world.emotions.dao;



import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.world.emotions.resources.TagTweets;
import com.world.emotions.util.MySQLConnection;

public class TagTweetsDAOImpl implements TagTweetsDAO {

	@Override
	public TagTweets getTweetsforTag(String tag) {
		Connection conn = null;
		TagTweets t= null;

		try {
			conn=MySQLConnection.getConnection();

			String query="select * from trends where hashtag=?";


			PreparedStatement command = (PreparedStatement) conn.prepareStatement(query);
		    command.setString(1, tag);
			ResultSet rs= command.executeQuery();
			
			
			while(rs.next()){
				long d=rs.getLong("id");	
			}
			
			// need to extract tweets based on above id.
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return t;

	}



}
