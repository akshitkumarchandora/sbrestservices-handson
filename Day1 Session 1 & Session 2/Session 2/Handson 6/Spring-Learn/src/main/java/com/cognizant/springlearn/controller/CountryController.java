package com.cognizant.springlearn.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.SpringLearnApplication;
import com.cognizant.springlearn.exception.CountryNotFoundException;
import com.cognizant.springlearn.service.CountryService;

@RestController
public class CountryController {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
	
	@Autowired
	private CountryService countryService;
	
	@RequestMapping("/country")
	public Country getCountryIndia() {
		LOGGER.info("Inside getCountryIndia");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country in = (Country) context.getBean("in", Country.class);
		LOGGER.debug("{}", in.toString());
		LOGGER.info("END");
		return in;
	}

	@GetMapping("/countries")
	public List<Country> getAllCountries() {
		LOGGER.info("Inside getAllCountries");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		List<Country> list = (List<Country>) context.getBean("countryList");
		LOGGER.debug("Countries : {} ", list);
		LOGGER.info("END");
		return list;
	}
	
	@GetMapping("/countries/{code}")
	public Country getCountry(@PathVariable String code)throws CountryNotFoundException {
		LOGGER.info("INSIDE getCountry of Controller");
		LOGGER.debug(countryService.getCountry(code).toString());
		LOGGER.info("end");
		return countryService.getCountry(code);
	}
	

}
