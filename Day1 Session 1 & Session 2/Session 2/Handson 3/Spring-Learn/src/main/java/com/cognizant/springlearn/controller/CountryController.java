package com.cognizant.springlearn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.SpringLearnApplication;

@RestController
public class CountryController {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
	
	@RequestMapping("/country")
	public Country getCountryIndia() {
		LOGGER.info("Inside getCountryIndia");
		ApplicationContext context=new ClassPathXmlApplicationContext("country.xml");
		Country in=(Country)context.getBean("in",Country.class);
		LOGGER.debug("{}",in.toString());
		return in;
	}
}
