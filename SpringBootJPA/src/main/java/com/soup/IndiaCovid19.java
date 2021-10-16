package com.soup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.model.CovidData;
import com.model.CovidDataStateWise;

public class IndiaCovid19 {

	public static CovidData getCovidDetails() {
		CovidData covid = new CovidData();
		List<CovidDataStateWise> covidStateData = new ArrayList<CovidDataStateWise>();
		CovidDataStateWise covidDataStateWise = null;
		try {
			// Here we create a document object and use JSoup to fetch the website
			Document doc = Jsoup.connect("https://www.mygov.in/covid-19").get();

			// With the document fetched, we use JSoup's title() method to fetch the title
			System.out.printf("Title: %s\n", doc.title());
			if (doc != null)
				covid.setTitle(doc.title());
			Elements repositories = doc.getElementsByClass("information_row");

			for (Element repository : repositories) {

				String infoTitle = repository.getElementsByClass("info_title").text();
				covid.setCovidInfoDate(infoTitle);
				System.out.println("infoTitle:" + infoTitle.toString());

				Elements iblock_active_case = repository.getElementsByClass("iblock active-case");
				if (iblock_active_case != null && iblock_active_case.size() > 0) {
					for (Element cases : iblock_active_case) {
						System.out.println(cases.getElementsByClass("icount").text() + ":"
								+ cases.getElementsByClass("info_label").text());
						covid.setActiveCases(cases.getElementsByClass("icount").text());
					}
				}

				Elements iblock_discharge = repository.getElementsByClass("iblock discharge");
				if (iblock_discharge != null && iblock_discharge.size() > 0) {
					for (Element cases : iblock_discharge) {
						System.out.println(cases.getElementsByClass("icount").text() + ":"
								+ cases.getElementsByClass("info_label").text());
						covid.setDischargedCases(cases.getElementsByClass("icount").text());
					}
				}
				Elements iblock_death_case = repository.getElementsByClass("iblock death_case");
				if (iblock_death_case != null && iblock_death_case.size() > 0) {
					for (Element cases : iblock_death_case) {
						System.out.println(cases.getElementsByClass("icount").text() + ":"
								+ cases.getElementsByClass("info_label").text());
						covid.setDeaths(cases.getElementsByClass("icount").text());
					}
				}
				Elements iblock_migared_case = repository.getElementsByClass("iblock migared_case");
				if (iblock_migared_case != null && iblock_migared_case.size() > 0) {
					for (Element cases : iblock_migared_case) {
						System.out.println(cases.getElementsByClass("icount").text() + ":"
								+ cases.getElementsByClass("info_label").text());
						covid.setMigrated(cases.getElementsByClass("icount").text());
					}
				}
			}

			Elements stateWiseData = doc.getElementsByClass("state_record");
			for (Element stateData : stateWiseData) {
				Elements blockWiseData = stateData.getElementsByClass("d_block");
				for (Element blockData : blockWiseData) {
					covidDataStateWise = new CovidDataStateWise();
					String stateName = blockData.getElementsByClass("location_name").text();
					covidDataStateWise.setStateName(stateName);
					String confirmCases = blockData.getElementsByClass("corona_confirm").text();
					covidDataStateWise.setConfirmCases(confirmCases);
					String coronaRecovered = blockData.getElementsByClass("corona_recovered").text();
					covidDataStateWise.setRecovered(coronaRecovered);
					String coronaDeceased = blockData.getElementsByClass("corona_deceased").text();
					covidDataStateWise.setDeceased(coronaDeceased);
					System.out.println("stateName:" + stateName + "\n corona_confirm: " + confirmCases
							+ "\n corona_recovered: " + coronaRecovered + "\n corona_deceased:" + coronaDeceased);
					System.out.println("..........");
					covidStateData.add(covidDataStateWise);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return covid;

	}

	public static void main(String[] args) {
		getCovidDetails();
	}
}
