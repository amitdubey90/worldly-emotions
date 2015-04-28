package com.world.emotions.controller;

import java.awt.PageAttributes.MediaType;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.world.emotions.dao.CountrySentimentDaoImpl;
import com.world.emotions.resources.CountrySentiment;

@RestController
public class CountrySentimentController {

	private static int nextId;
	private static Map<Integer, CountrySentiment> map;
	
	static int count=1;
		
	@RequestMapping(value="/getscore",method=RequestMethod.GET, headers="Accept=application/json")
	public ResponseEntity<List<CountrySentiment>> getSentiments()
	{
		//Collection<CountrySentiment> countrySentiments = map.values();
		CountrySentimentDaoImpl impl = new CountrySentimentDaoImpl();
		List<CountrySentiment> countrySentiments = impl.getAvgScore();
		return new ResponseEntity<List<CountrySentiment>>(countrySentiments,HttpStatus.OK);
		
		
	}
	
}
