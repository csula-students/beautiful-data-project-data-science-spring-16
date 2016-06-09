package edu.csula.vkc.services;

import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import com.google.common.collect.Lists;
import edu.csula.vkc.third.models.Details;

public class TrueCarService {

	static String strMake = "";
	static String strModel = "";
	static List<Details> lstDetails = Lists.newArrayList();

	public static List<Details> getListing(String makeName, String modelName) {

		try {

			if (!makeName.equals(strMake) && !modelName.equals(strModel)) {

				// System.out.println("Executing If.");
				strMake = makeName;
				strModel = modelName;

				// Code if the request is being made for first time.
				String firstURL = "https://www.truecar.com/used-cars-for-sale/listings/"
						+ makeName.replace(" ", "-").toLowerCase() + "/" + modelName.replace(" ", "-").toLowerCase()
						+ "/";

				// System.out.println(firstURL);
				Document docu = Jsoup.connect(firstURL).timeout(7000).get();
				Elements pages = docu.getElementsByClass("pagination");
				Elements links = pages.select("a[href]");
				// System.out.println(links);
				// System.out.println(links.last().attr("data-page-index"));
				int noPages = Integer.parseInt(links.last().attr("data-page-index"));
				//System.out.println("Number of True car pages for this car : " + noPages);
				for (int i = 1; i <= noPages; i++) {

					String urlString = "https://www.truecar.com/used-cars-for-sale/listings/"
							+ makeName.replace(" ", "-").toLowerCase() + "/" + modelName.replace(" ", "-").toLowerCase()
							+ "/?page=" + i;

					// System.out.println(urlString);
					Document doc = Jsoup.connect(urlString).timeout(7000).get();

					Elements listings = doc.getElementsByClass("vehicle-card");

					for (Element element : listings) {

						Details details = new Details();
						details.setSource("TrueCar");

						Elements strYear = element.getElementsByClass("vdp-link");

						//System.out.println(strYear);
						for (Element elem : strYear) {
							if (elem.hasText() && !elem.text().equals("View Details")) {
								// System.out.println("Year : " + elem.text());
								details.setYearsOld(Integer.parseInt(elem.text().substring(0, 4)));
							}
						}

						Elements strVehicleInfo = element.getElementsByClass("vehicle-info");

						//System.out.println(strVehicleInfo);
						for (Element elem : strVehicleInfo) {
							if (elem.text().contains("miles")) {
								// System.out.println("Miles : " +
								// elem.text().substring(0,
								// elem.text().indexOf("miles"))
								// .replace("Mileage:", "").replace(",",
								// "").trim());
								details.setMilesRun(
										Integer.parseInt(elem.text().substring(0, elem.text().indexOf("miles"))
												.replace("Mileage:", "").replace(",", "").trim()));
							}
						}

						Elements strPrices = element.getElementsByClass("price");

						for (Element elem : strPrices) {
							if (elem.hasText())
								// System.out.println("Price : " +
								// elem.text().replace("$", "").replace(",",
								// "").trim());
								details.setSalePrice(
										Integer.parseInt(elem.text().replace("$", "").replace(",", "").trim()));
						}
						lstDetails.add(details);
					}
					// System.out.println(i);
					Thread.sleep(100);
				}
			} else {
				// Code if the request has been already made.
				// System.out.println("Executing else");
			}
		} catch (Exception e) {
			System.out.print("Source : TrueCar Service ");
			System.out.println(e.toString());
			return lstDetails;
		}
		return lstDetails;
	}

}
