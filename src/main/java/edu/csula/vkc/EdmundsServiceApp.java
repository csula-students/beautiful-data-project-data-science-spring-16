package edu.csula.vkc;

import com.mashape.unirest.http.JsonNode;

public class EdmundsServiceApp {

	public static void main(String[] args) {

		JsonNode carMakes = EdmundsService.getMakes();

		System.out.println("Makes response-->" + carMakes);

		JsonNode carModelsandYears = EdmundsService.getModelandYear();

		System.out.println("Models and Years response-->" + carModelsandYears);
	}

}
