package com.world.emotions.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.world.emotions.resources.TagTweets;
import com.world.emotions.resources.Tweets;
import com.world.emotions.util.MySQLConnection;

public class TagTweetsDAOImpl implements TagTweetsDAO {

	@Override
	public TagTweets getTweetsforTag(String tag) {
		Connection conn = null;
		TagTweets t = new TagTweets();
		int d = -1;
		ArrayList<Tweets> twt = new ArrayList<Tweets>();

		try {
			conn = MySQLConnection.getConnection();

			String query = "select * from tweets where "
					+ "hashtag_id=(select id from trends where lower(hashtag) LIKE lower(?)) order by timestamp limit 50";

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
