package com.world.emotions.util;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class MySQLConnection {

	private static Connection connection;



	private static String URL = "jdbc:mysql://cmpe239.ckihmrqdoc0a.us-west-1.rds.amazonaws.com:3306/tweetdb";
	private static String user = "cmpe239user";
	private static String password = "Newuser123";

	public static Connection getConnection() {
		if (connection == null) {
			connection = createConnection();
		}
		return connection;
	}

	private static Connection createConnection() {
		Connection connection;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = (Connection) DriverManager.getConnection(URL, user, password);

		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return null;
		}
		return connection;
	}



}
