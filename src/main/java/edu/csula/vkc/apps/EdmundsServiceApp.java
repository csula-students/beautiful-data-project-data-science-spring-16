package edu.csula.vkc.apps;

import com.mashape.unirest.http.JsonNode;
import edu.csula.vkc.services.EdmundsService;

public class EdmundsServiceApp {

	public static void main(String[] args) {

		JsonNode carMakes = EdmundsService.getMakes();

		System.out.println();
		
		
		
		
		System.out.println("getMakes response-->" + carMakes);
		
		/*
		 * 
		JsonNode carModelsandYears = EdmundsService.get;

		System.out.println("getModelandYear response-->" + carModelsandYears);

		JsonNode carStyleID = EdmundsService.getStyleID();

		System.out.println("getStyleID response-->" + carStyleID);
		
		// JsonNode carTCOPrice = EdmundsService.getTCOPrice();

		// System.out.println("Car TCO Price response-->" + carTCOPrice);

		JsonNode carDetailsByStyleID = EdmundsService.getCarDetailsByStyleID();

		System.out.println("getCarDetailsByStyleID response-->" + carDetailsByStyleID);

*/	}

}
