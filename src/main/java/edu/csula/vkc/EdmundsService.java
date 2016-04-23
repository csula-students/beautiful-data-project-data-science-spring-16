package edu.csula.vkc;

import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class EdmundsService {

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

}
