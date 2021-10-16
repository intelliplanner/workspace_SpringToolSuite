package com.model;

public class CovidDataStateWise {
	private String stateName;
	private String confirmCases;
	private String recovered;
	private String deceased;
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public String getConfirmCases() {
		return confirmCases;
	}
	public void setConfirmCases(String confirmCases) {
		this.confirmCases = confirmCases;
	}
	public String getRecovered() {
		return recovered;
	}
	public void setRecovered(String recovered) {
		this.recovered = recovered;
	}
	public String getDeceased() {
		return deceased;
	}
	public void setDeceased(String deceased) {
		this.deceased = deceased;
	}

}
