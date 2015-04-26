package com.world.emotions.Main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.world.emotions.dao.TagTweetsDAOImpl;
import com.world.emotions.util.MySQLConnection;

@EnableAutoConfiguration
@ComponentScan
@EnableAspectJAutoProxy
public class Application {

	public static void main(String[] args) {
		
	    System.out.println("connection status : "+MySQLConnection.getConnection());
		TagTweetsDAOImpl t= new TagTweetsDAOImpl();
		t.getTweetsforTag("#UFC186");
		//ApplicationContext ctx = SpringApplication.run(Application.class, args);

		
	}

}