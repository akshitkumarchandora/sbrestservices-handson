package com.cognizant.springlearn.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.exception.CountryNotFoundException;
@Service
public class CountryService {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(CountryService.class);
	public Country getCountry(String code)throws CountryNotFoundException
	{
		LOGGER.info("Inside getCountry Service");
		Country countryfnd=null;
		ApplicationContext context=new ClassPathXmlApplicationContext("country.xml");
		List<Country> countries=(List<Country>)context.getBean("countryList");
		LOGGER.info("END");
		for(Country c:countries)
		{
			if(c.getCode().equalsIgnoreCase(code))
				{
				countryfnd=c;
				break;
				}
		}
		if(countryfnd==null)
			throw new CountryNotFoundException("No Country Found");
		else
			return countryfnd;
		
	}
}
