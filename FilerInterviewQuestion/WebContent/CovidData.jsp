<%@page import="java.util.Date"%><% pageContext.setAttribute("noLogin","1"); %>
<%@ include file="startInclude.jsp" %>

<%@page import="com.ipssi.gen.utils.Misc"%>
<%@page import="java.util.List" %>

<%

String action = request.getParameter("action");
String url = request.getParameter("url");
if(action.equalsIgnoreCase("getCovidDetails")){

	CovidData covid = new CovidData();
	List<CovidDataStateWise> covidStateData = new ArrayList<CovidDataStateWise>();
	CovidDataStateWise covidDataStateWise = null;
	try {
		// Here we create a document object and use JSoup to fetch the website
		String url = "https://www.mygov.in/covid-19";
		Document doc = Jsoup.connect(url).get();

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
		int i = 0;
		for (Element stateData : stateWiseData) {
			Elements blockWiseData = stateData.getElementsByClass("d_block");
			for (Element blockData : blockWiseData) {
				if (i == 0) {
					i++;
					continue;
				}
				covidDataStateWise = new CovidDataStateWise();
				covidDataStateWise.setId(i++);
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
			covid.setStateWiseData(covidStateData);
		}
	} catch (IOException e) {
		e.printStackTrace();
	}
	return covid;


}else if(action.equalsIgnoreCase("getCovidDetailsNew")){

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

//		Elements stateWiseData = doc.getElementsByClass("state_record");
//		   Document stateWiseData = Jsoup.parse(new File(url), "utf-8"); 
//				doc.getElements("starepositorieste-covid-data");
//		   String stateWiseData = doc.html();
//		   Document docs = Jsoup.parse(stateWiseData, "utf-8"); 
//		Elements stateWiseData = stateWiseData.getElementsById("state_record");
//		Elements elems = divTag.getElementsByTag("<thead>");
//		 Element divTag = doc.getElementById("mydiv"); 	
		Element tableID = doc.getElementById("state-covid-data");// tbleID
		Element table = tableID.select("table").get(0); // select the first table.
		Elements rows = table.select("tr");
		int count = 1;
		for (int i = 1; i < rows.size(); i++) {
			covidDataStateWise = new CovidDataStateWise();
			Element row = rows.get(i);
			Elements cols = row.select("td");
			covidDataStateWise.setId(count++);
			covidDataStateWise.setStateName(cols.get(0).text());
			covidDataStateWise.setConfirmCases(cols.get(1).text());
			covidDataStateWise.setRecovered(cols.get(2).text());
			covidDataStateWise.setDeceased(cols.get(3).text());
			System.out.println(" id: " + covidDataStateWise.getId() + "\n stateName: "
					+ covidDataStateWise.getStateName() + "\n corona_confirm: "
					+ covidDataStateWise.getConfirmCases() + "\n corona_recovered: "
					+ covidDataStateWise.getRecovered() + "\n corona_deceased:" + covidDataStateWise.getDeceased());
			System.out.println("..........");
			covidStateData.add(covidDataStateWise);
		}
		covid.setStateWiseData(covidStateData);
	} catch (IOException e) {
		e.printStackTrace();
	}
	return covid;


}else if(action.equalsIgnoreCase("getCovidDetailsByUrl")){

	// TODO Auto-generated method stub
	Document doc = null;
	try {
		if (path != null) {
			doc = Jsoup.connect(path).get();
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return doc != null ? doc.html() : null;

}else if(action.equalsIgnoreCase("getCovidDetailsByUrlWithClassName")){

	// TODO Auto-generated method stub
	String returnVal = null;
	Elements repositories = null;
	Document doc = null;
	try {
		if (path != null) {
			doc = Jsoup.connect(path).get();
		}
		if (className != null) {
			repositories = doc.getElementsByClass(className);
		}
		returnVal = repositories != null ? repositories.html() : null;
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	return returnVal;

}
else if(action.equalsIgnoreCase("getCovidDetailsByDocHTmlWithClassName")){

	// TODO Auto-generated method stub
	String returnVal = null;
	Document doc = null;
	Elements repositories = null;
	if (docHtml != null) {
		doc = Jsoup.parse(docHtml);
	}
	if (className != null) {
		repositories = doc.getElementsByClass(className);
	}
	returnVal = repositories != null ? repositories.html() : null;
	return returnVal;

}
else if(action.equalsIgnoreCase("getCovidDetailsByUrlWithTableId")){

	// TODO Auto-generated method stub
	String returnVal = null;
	Document doc = null;
	Element tableData = null;
	try {
		if (path != null) {
			doc = Jsoup.connect(path).get();
		}

		if (tableId != null) {
			tableData = doc.getElementById(tableId);
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	returnVal = tableData != null ? tableData.html() : null;

	return returnVal;

}
else if(action.equalsIgnoreCase("getCovidDetailsByDocHtmlWithTableId")){

	// TODO Auto-generated method stub
	String returnVal = null;
	Document doc = null;
	Element tableData = null;
	if (docHtml != null) {
		doc = Jsoup.parse(docHtml);
	}
	if (tableId != null) {
		tableData = doc.getElementById(tableId);
	}
	returnVal = tableData != null ? tableData.html() : null;
	return returnVal;

}

%>
<%

class CovidDataStateWise {
	private int id;
	private String stateName;
	private String confirmCases;
	private String recovered;
	private String deceased;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


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

%>
<% 
class CovidData {
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

%>

