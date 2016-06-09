package edu.csula.vkc.services;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class TrueCarService {

	public static int getListing(String makeName, String modelName) {

		int price = 0;
		try {

			String firstURL = "https://www.truecar.com/used-cars-for-sale/listings/"
					+ makeName.replace(" ", "-").toLowerCase() + "/" + modelName.replace(" ", "-").toLowerCase() + "/";

			// System.out.println(urlString);
			Document docu = Jsoup.connect(firstURL).timeout(7000).get();
			Elements pages = docu.getElementsByClass("pagination");
			Elements links = pages.select("a[href]");
			// System.out.println(links);
			//System.out.println(links.last().attr("data-page-index"));
			int noPages = Integer.parseInt(links.last().attr("data-page-index"));

			for (int i = 1; i <= noPages; i++) {

				String urlString = "https://www.truecar.com/used-cars-for-sale/listings/"
						+ makeName.replace(" ", "-").toLowerCase() + "/" + modelName.replace(" ", "-").toLowerCase()
						+ "/?page="+i;

				// System.out.println(urlString);
				Document doc = Jsoup.connect(urlString).timeout(7000).get();

				Elements strYear = doc.getElementsByClass("vdp-link");

				for (Element element : strYear) {
					if (element.hasText() && !element.text().equals("View Details")) {
						// System.out.println(element.text().substring(0, 4));
						element.text().substring(0, 4);
					}
				}

				Elements strVehicleInfo = doc.getElementsByClass("vehicle-info");

				// System.out.println(strVehicleInfo);
				for (Element element : strVehicleInfo) {
					if (element.text().contains("miles")) {
						//System.out.println(element.text().substring(0, element.text().indexOf("miles")).replace("Mileage:", "").replace(",", "").trim());
						element.text().substring(0, element.text().indexOf("miles")).replace("Mileage:", "")
								.replace(",", "").trim();
					}
				}

				Elements strPrices = doc.getElementsByClass("price");

				for (Element element : strPrices) {
					if (element.hasText())
						// System.out.println(element.text().replace("$",
						// "").replace(",", "").trim());
						element.text().replace("$", "").replace(",", "").trim();
				}
				
				System.out.println(strYear.size());
				System.out.println(strPrices.size());
				System.out.println(strVehicleInfo.size());

			}
		} catch (

		Exception e) {
			System.out.print("Source : TrueCar Service");
			System.out.println(e.toString());
			return 0;
		}
		return price;
	}

}
