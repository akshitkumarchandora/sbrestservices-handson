package com.cognizant.springlearn.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.Country;
@Service
public class CountryService {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(CountryService.class);
	public Country getCountry(String code)
	{
		LOGGER.info("Inside getCountry Service");
		Country countryfnd=null;
		ApplicationContext context=new ClassPathXmlApplicationContext("country.xml");
		List<Country> countries=(List<Country>)context.getBean("countryList");
		LOGGER.info("END");
		for(Country c:countries)
		{
			if(c.getCode().equalsIgnoreCase(code))
				return c;
		}
		return null;
		
	}
}
