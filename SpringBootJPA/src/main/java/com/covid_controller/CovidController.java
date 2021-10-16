package com.covid_controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.CovidData;
import com.soup.IndiaCovid19;

@RestController
@RequestMapping("/covid")
public class CovidController {

@PostMapping("/indiaCovidData")
	public CovidData getCovidData() {
		CovidData covidData = IndiaCovid19.getCovidDetails();
		return covidData;
	}	
}
