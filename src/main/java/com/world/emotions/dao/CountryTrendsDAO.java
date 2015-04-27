package com.world.emotions.dao;

import java.util.List;

import com.world.emotions.resources.CountryTrends;
import com.world.emotions.resources.TrendsScore;

public interface CountryTrendsDAO {
	public List<TrendsScore> getTrendsForCountry(String countryName);

	public CountryTrends getCountryTrends(String country_name);

}
