package edu.csula.vkc.services;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class TrueCarService1 {

	public static int getListing(String makeName, String modelName) {

		int price = 0;
		try {

			String urlString = "https://www.truecar.com/used-cars-for-sale/listings/"
					+ makeName.replace(" ", "-").toLowerCase() + "/" + modelName.replace(" ", "-").toLowerCase() + "/";

			System.out.println(urlString);
			Document doc = Jsoup.connect(urlString).timeout(7000).get();

			Elements link = doc.getElementsByClass("vdp-link");

			for (Element elem : link) {
				if (elem.hasText() && elem.text().equals("View Details")) {
					System.out.println(elem);
					
					System.out.println(elem.toString().substring(elem.toString().indexOf("listing")+8, elem.toString().indexOf("/", elem.toString().indexOf("listing")+8)));
				}
			}
				
			

			// System.out.println(strName.text());
			// if (strPrice.text().lastIndexOf("$") != -1) {
			// price = Integer.parseInt(
			// strPrice.text().substring(strPrice.text().lastIndexOf("$")).replace("$",
			// "").replace(",", ""));
			// }
			// System.out.println(price);
		} catch (

		Exception e) {
			System.out.print("Source : True Car Service ");
			System.out.println(e.toString());
			return 0;
		}
		return price;
	}

}
