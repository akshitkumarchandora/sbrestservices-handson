package com.cognizant.springlearn.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.exception.CountryNotFoundException;
import com.cognizant.springlearn.service.CountryService;

@RestController
public class CountryController {
	private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);
	
	
	@Autowired
	private CountryService countryService;
	
	public CountryController() {
		super();
		LOGGER.info("Inside controller Constructor");
		
	}

	@RequestMapping(value="/country",method=RequestMethod.GET)
	public Country getCountryIndia() {
		LOGGER.info("Inside getCountryIndia");
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country in = (Country) context.getBean("in", Country.class);
		LOGGER.debug("{}", in.toString());
		LOGGER.info("END");
		return in;
	}

	@GetMapping("/countries")
	public List<Country> getAllCountries() {
		LOGGER.info("Inside getAllCountries");
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		@SuppressWarnings("unchecked")
		List<Country> list = (List<Country>) context.getBean("countryList");
		LOGGER.debug("Countries : {} ", list);
		LOGGER.info("END");
		return list;
	}
	
	@GetMapping("/countries/{code}")
	public Country getCountry(@PathVariable String code)throws CountryNotFoundException
	{
		LOGGER.info("INSIDE getCountry of Controller");
		LOGGER.debug(countryService.getCountry(code).toString());
		LOGGER.info("end");
		return countryService.getCountry(code);
	}

	@PostMapping("/countries")
	public Country addCountry(@Valid @RequestBody Country country) {
		LOGGER.info("START");
		// Create validator factory
       
		LOGGER.debug(country.toString());
        return country;
	}
	

}
