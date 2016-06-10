package edu.csula.vkc.services;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class MicrosoftService {

	public static int getMaxPrice(String makeName, String modelName, String year) {

		int price = 0;
		try {
			
			String urlString = "http://www.msn.com/en-us/autos/" + makeName + "/" + modelName.replace(" ", "-") + "/" + year;
			
			//System.out.println(urlString);
			Document doc = Jsoup.connect(urlString).timeout(7000).get();

			Elements strPrice = doc.getElementsByClass("amy-msrp-price");

			// System.out.println(strPrice.text().substring(strPrice.text().lastIndexOf("$")).replace("$",
			// "").replace(",", ""));
			
			if (strPrice.text().lastIndexOf("$") != -1) {
				price = Integer.parseInt(
						strPrice.text().substring(strPrice.text().lastIndexOf("$")).replace("$", "").replace(",", ""));
			}
			// System.out.println(price);
		} catch (Exception e) {
			System.out.print("Source : Microsoft Service ");
			System.out.println(e.toString());
			return 0;
		}
		return price;
	}

	public static int getMinPrice(String makeName, String modelName, String year) {

		int price = 0;
		try {
			
			String urlString = "http://www.msn.com/en-us/autos/" + makeName + "/" + modelName.replace(" ", "-") + "/" + year;
			
			//System.out.println(urlString);
			Document doc = Jsoup.connect(urlString).timeout(7000).get();

			Elements strPrice = doc.getElementsByClass("amy-msrp-price");

			// System.out.println(strPrice.text().substring(strPrice.text().lastIndexOf("$")).replace("$",
			// "").replace(",", ""));
			
			if (strPrice.text().indexOf("$") != -1) {
				//System.out.println(strPrice.text().substring(strPrice.text().indexOf("$"), strPrice.text().indexOf("-")).replace("$", "").replace(",", "").trim());
				price = Integer.parseInt(
						strPrice.text().substring(strPrice.text().indexOf("$"), strPrice.text().indexOf("-")).replace("$", "").replace(",", "").trim());
			}
			// System.out.println(price);
		} catch (Exception e) {
			System.out.print("Source : Microsoft Service ");
			System.out.println(e.toString());
			return 0;
		}
		return price;
	}
}
