package com.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.model.CovidData;
import com.soup.IndiaCovid19;


@RestController
public class ShoppingController {

	@Autowired
	private RestTemplate template;
	
	@GetMapping("/amazon-payment/{price}")		
	public String invokePaymentService(@PathVariable int price) {
//		String url="http://localhost:8888/payment-provider/payNow/" + price;
		String url="http://PAYMENT-SERVICE/payment-provider/payNow/"+price;
		return template.getForObject(url,String.class);
	}

@GetMapping("/indiaCovidData")
	public CovidData getCovidData() {
		CovidData covidData = IndiaCovid19.getCovidDetails();
		return covidData;
	}
@GetMapping("/indiaCovidDataNew")
public CovidData getCovidDataNew() {
	CovidData covidData = IndiaCovid19.getCovidDetailsNew();
	return covidData;
}

@PostMapping(value="/document")
public String getCovidDataNew(@RequestParam("url_path") String path) {
	String data = IndiaCovid19.getCovidDetails(path);
	return data;
}
}

