package com.cognizant.springlearn;

import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringLearnApplicationUnitTestings {
	
//	@LocalServerPort
//	int randomServerPort;
	
	@Test 
	public void testGetAllEmployeeSuccess()throws URISyntaxException {
		
		RestTemplate restTemplate=new RestTemplate();
		final String baseUrl="http://localhost:8080/employees";
		
		ResponseEntity<String> result= restTemplate.getForEntity(baseUrl, String.class);
		
		//Verify REquest Succeeds
		
		Assert.assertEquals(HttpStatus.OK,result.getStatusCode());
		Assert.assertEquals(true,result.getBody().contains("Purusham"));
	}
	
	@Test 
	public void testGetCorrectCountryCodeSuccess() {
		
		RestTemplate restTemplate=new RestTemplate();
		final String correctBaseUrl="http://localhost:8080/countries/in";
		final String incorrectBaseUrl="http://localhost:8080/countries/int";
		
		
		ResponseEntity<String> result= restTemplate.getForEntity(correctBaseUrl, String.class);
		ResponseEntity<String> result1= null;
		
		//Verify REquest Succeeds
		
		Assert.assertEquals(HttpStatus.OK,result.getStatusCode());
		Assert.assertEquals(true,result.getBody().contains("India"));
		try {
			result1=restTemplate.getForEntity(incorrectBaseUrl, String.class);
			Assert.fail();
		}
		catch(HttpClientErrorException e)
		{
			Assert.assertEquals(404,e.getRawStatusCode());
			//System.out.println(result1);
			//Assert.assertEquals(true,result1.getBody().contains("India"));
		}
		
	}
	
	@Test
	public void testAddCountry() {
		RestTemplate restTemplate=new RestTemplate();
		final String baseUrl="http://localhost:8080/countries/";
		Country country=new Country();
		country.setCode("np");
		country.setName("Nepal");
		ResponseEntity<String> result=null;
		
		HttpHeaders headers=new HttpHeaders();
		HttpEntity<Country> request = new HttpEntity<>(country,headers);
		
		try {
			result=restTemplate.postForEntity(baseUrl, request,String.class);
			//Assert.fail();
		}
		catch(HttpClientErrorException e) {
			Assert.assertEquals(400,e.getRawStatusCode());
		}
		
		Assert.assertEquals(HttpStatus.OK,result.getStatusCode());
	}

}
