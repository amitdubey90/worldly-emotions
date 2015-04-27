package com.world.emotions.Main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan
@EnableAutoConfiguration
@Configuration
public class Application {

	public static void main(String[] args) {
		
	    //System.out.println("connection status : "+MySQLConnection.getConnection());
		//TagTweetsDAOImpl t= new TagTweetsDAOImpl();
		//t.getTweetsforTag("#UFC186");
	    
	    //CountryTrendsDAOImpl c=new CountryTrendsDAOImpl();
	   // c.getCountryTrends("USA");
		
	
		 SpringApplication.run(Application.class, args);

		
	}

}