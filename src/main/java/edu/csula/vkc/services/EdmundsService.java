package edu.csula.vkc.services;

import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

import edu.csula.vkc.second.util.WriteToJson;

public class EdmundsService {

	static WriteToJson writer = new WriteToJson();

	public static JsonNode getMakes() {

		JsonNode responseMake = null;
		try {
			responseMake = Unirest.get("http://api.edmunds.com/api/vehicle/v2/makes?fmt=json&api_key=" + ServiceKeys.getEdmundsKey())
					.asJson().getBody();
		} catch (Exception e) {
			System.out.print("Source : Edmunds Service ");
			System.out.println(e.toString());
		}

		return responseMake;
	}

	public static JsonNode getCarDetails(String strMake, String strModel, String strYear) {

		JsonNode responseCarDetails = null;
		try {
			responseCarDetails = Unirest.get("https://api.edmunds.com/api/vehicle/v2/" + strMake + "/" + strModel + "/"
					+ strYear + "/styles?fmt=json&api_key=" + ServiceKeys.getEdmundsKey() + "&view=full").asJson().getBody();
		} catch (Exception e) {
			System.out.print("Source : Edmunds Service ");
			System.out.println(e.toString());
		}

		return responseCarDetails;
	}

}
