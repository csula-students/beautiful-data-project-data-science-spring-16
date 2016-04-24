package edu.csula.vkc.services;

import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import edu.csula.vkc.util.WriteToJson;

public class EdmundsService {
	
	static WriteToJson writer = new WriteToJson();

	public static JsonNode getMakes() {

		JsonNode responseMake = null;
		try {
			responseMake = Unirest
					.get("http://api.edmunds.com/api/vehicle/v2/makes?fmt=json&api_key=9czdpmae3rqxgx27hp5p9qt5")
					.asJson().getBody();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return responseMake;
	}

	public static JsonNode getModelandYear() {

		JsonNode responseModelandYear = null;
		try {
			responseModelandYear = Unirest
					.get("https://api.edmunds.com/api/vehicle/v2/Acura/models?fmt=json&api_key=9czdpmae3rqxgx27hp5p9qt5")
					.asJson().getBody();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return responseModelandYear;
	}

	public static JsonNode getStyleID() {

		JsonNode responseStyleID = null;
		try {
			responseStyleID = Unirest
					.get("https://api.edmunds.com/api/vehicle/v2/lexus/rx350/2011/styles?fmt=json&api_key=9czdpmae3rqxgx27hp5p9qt5")
					.asJson().getBody();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return responseStyleID;
	}
	
	public static JsonNode getCarDetails() {

		JsonNode responseStyleID = null;
		try {
			responseStyleID = Unirest
					.get("https://api.edmunds.com/api/vehicle/v2/lexus/rx350/2011/styles?fmt=json&api_key=9czdpmae3rqxgx27hp5p9qt5&view=full")
					.asJson().getBody();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return responseStyleID;
	}
	
//	public static JsonNode getTCOPrice() {
//
//		JsonNode responseTCOPrice = null;
//		try {
//			responseTCOPrice = Unirest
//					// update the link
//					.get("&api_key=9czdpmae3rqxgx27hp5p9qt5").asJson().getBody();
//		} catch (UnirestException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return responseTCOPrice;
//	}

}
