package com;

import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class WebScrap {

	public static String getWebData() {
		String searchQuery = "Iphone 6s";
		String jsonString = "";
		WebClient client = new WebClient();
		client.getOptions().setCssEnabled(false);
		client.getOptions().setJavaScriptEnabled(false);
		try {
			String searchUrl = "https://newyork.craigslist.org/search/sss?sort=rel&query="
					+ URLEncoder.encode(searchQuery, "UTF-8");
			HtmlPage page = client.getPage(searchUrl);

			List<HtmlElement> items = page.getByXPath("//li[@class='result-row']");
			if (items.isEmpty()) {
				System.out.println("No items found !");
			} else {
//			for(HtmlElement item : items){
//			  HtmlAnchor itemAnchor = ((HtmlAnchor) item.getFirstByXPath(".//p[@class='result-info']/a"));
//
//			  HtmlElement spanPrice = ((HtmlElement) item.getFirstByXPath(".//a/span[@class='result-price']")) ;
//								
//			  String itemName = itemAnchor.asText();
//			  String itemUrl =  itemAnchor.getHrefAttribute();
//
//			  // It is possible that an item doesn't have any price
//			  String itemPrice = spanPrice == null ? "0.0" : spanPrice.asText() ;
//						
//			  System.out.println( String.format("Name : %s Url : %s Price : %s", itemName, itemPrice, itemUrl));
//			  }

				for (HtmlElement htmlItem : items) {
					HtmlAnchor itemAnchor = ((HtmlAnchor) htmlItem.getFirstByXPath(".//p[@class='result-info']/a"));

					HtmlElement spanPrice = ((HtmlElement) htmlItem
							.getFirstByXPath(".//a/span[@class='result-price']"));

					// It is possible that an item doesn't have any
					// price, we set the price to 0.0 in this case
					String itemPrice = spanPrice == null ? "0.0" : spanPrice.asText();

					Item item = new Item();

					item.setTitle(itemAnchor.asText());
					item.setUrl(searchUrl + itemAnchor.getHrefAttribute());

					item.setPrice(new BigDecimal(itemPrice.replace("$", "")));

					ObjectMapper mapper = new ObjectMapper();
					jsonString = mapper.writeValueAsString(item);

					System.out.println(jsonString);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonString;
	}

	public static void main(String str[]) {
//		getWebData();
	}
}
