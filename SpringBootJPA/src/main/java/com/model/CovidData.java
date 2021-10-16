package com.model;

import java.util.List;

public class CovidData {
	private String title;
	private String covidInfoDate;
	private String activeCases;
	private String dischargedCases;
	private String deaths;
	private String migrated;
	List<CovidDataStateWise> stateWiseData;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCovidInfoDate() {
		return covidInfoDate;
	}
	public void setCovidInfoDate(String covidInfoDate) {
		this.covidInfoDate = covidInfoDate;
	}
	public String getActiveCases() {
		return activeCases;
	}
	public void setActiveCases(String activeCases) {
		this.activeCases = activeCases;
	}
	public String getDischargedCases() {
		return dischargedCases;
	}
	public void setDischargedCases(String dischargedCases) {
		this.dischargedCases = dischargedCases;
	}
	public String getDeaths() {
		return deaths;
	}
	public void setDeaths(String deaths) {
		this.deaths = deaths;
	}
	public String getMigrated() {
		return migrated;
	}
	public void setMigrated(String migrated) {
		this.migrated = migrated;
	}
	public List<CovidDataStateWise> getStateWiseData() {
		return stateWiseData;
	}
	public void setStateWiseData(List<CovidDataStateWise> stateWiseData) {
		this.stateWiseData = stateWiseData;
	}
	@Override
	public String toString() {
		return "CovidData [title=" + title + ", covidInfoDate=" + covidInfoDate + ", activeCases=" + activeCases
				+ ", dischargedCases=" + dischargedCases + ", deaths=" + deaths + ", migrated=" + migrated
				+ ", stateWiseData=" + stateWiseData + "]";
	}

	
}
