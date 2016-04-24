package edu.csula.vkc.apps;

import com.mashape.unirest.http.JsonNode;

import edu.csula.vkc.services.EdmundsService;

public class EdmundsServiceApp {

	public static void main(String[] args) {

		JsonNode carMakes = EdmundsService.getMakes();

		System.out.println("Makes response-->" + carMakes);

		JsonNode carModelsandYears = EdmundsService.getModelandYear();

		System.out.println("Models and Years response-->" + carModelsandYears);
		
		JsonNode carStyleID = EdmundsService.getStyleID();

		System.out.println("Car Style ID response-->" + carStyleID);
		
		JsonNode carTCOPrice = EdmundsService.getTCOPrice();

		System.out.println("Car TCO Price response-->" + carTCOPrice);
		

	}

}
