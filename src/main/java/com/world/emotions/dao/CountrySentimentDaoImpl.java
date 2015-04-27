package com.world.emotions.dao;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.MySQLConnection;
import com.mysql.jdbc.Statement;

import com.world.emotions.resources.CountrySentiment;

public class CountrySentimentDaoImpl {

	private static Connection connection;
	
	public CountrySentimentDaoImpl()
	{
		connection = (Connection) demo.sqlConnection.MySQLConnection.getConnection();
	}
	
	public List<CountrySentiment> getAvgScore()
	{
		List<CountrySentiment> sentiments = new ArrayList<CountrySentiment>();
		try
		{
			int count = 0;
			Statement statement = (Statement) connection.createStatement();
			ResultSet rs = statement.executeQuery("select avg(score) as avgscore from sentiment_score");
			while(rs.next())
			{
				CountrySentiment countrySentiment = new CountrySentiment();
				countrySentiment.setId(count++);
				countrySentiment.setScore(rs.getInt("avgscore"));
				sentiments.add(countrySentiment);
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return sentiments;
	}
	
}
