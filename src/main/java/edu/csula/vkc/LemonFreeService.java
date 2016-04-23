package edu.csula.vkc;

import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class LemonFreeService {

	public static JsonNode getMakes() {

		JsonNode responseMake = null;
		try {
			responseMake = Unirest
					.get("http://api.lemonfree.com/v2/makes/?format=json&key=07859aa5804ac8c1425bdb703ca961ed").asJson()
					.getBody();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return responseMake;
	}

	public static JsonNode getModelsByMakeID() {

		JsonNode responseModelsByMakeID = null;
		try {
			responseModelsByMakeID = Unirest
					.get("http://api.lemonfree.com/v2/models/?make_id=11&format=json&key=07859aa5804ac8c1425bdb703ca961ed")
					.asJson().getBody();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return responseModelsByMakeID;
	}

	public static JsonNode getTrimsByMakeandModel() {

		JsonNode responseTrimsByMakeandModel = null;
		try {
			responseTrimsByMakeandModel = Unirest
					.get("http://api.lemonfree.com/v2/trims/?make=Chevrolet&model=Cavalier&format=json&key=07859aa5804ac8c1425bdb703ca961ed")
					.asJson().getBody();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return responseTrimsByMakeandModel;
	}

	public static JsonNode getYearsByMakeandModel() {

		JsonNode responseYearsByMakeandModel = null;
		try {
			responseYearsByMakeandModel = Unirest
					.get("http://api.lemonfree.com/v2/years/?make=Nissan&model=Altima&format=json&key=07859aa5804ac8c1425bdb703ca961ed")
					.asJson().getBody();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return responseYearsByMakeandModel;
	}

	public static JsonNode getPricesByMake() {

		JsonNode responsePricesByMake = null;
		try {
			responsePricesByMake = Unirest
					.get("http://api.lemonfree.com/v2/prices/?make=Oldsmobile&format=json&key=07859aa5804ac8c1425bdb703ca961ed")
					.asJson().getBody();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return responsePricesByMake;
	}

	public static JsonNode getLocations() {

		JsonNode responseLocations = null;
		try {
			responseLocations = Unirest
					.get("http://api.lemonfree.com/v2/locations/?format=json&key=07859aa5804ac8c1425bdb703ca961ed")
					.asJson().getBody();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return responseLocations;
	}

	public static JsonNode getLocationsbyMake() {

		JsonNode responseLocationsbyMake = null;
		try {
			responseLocationsbyMake = Unirest
					.get("http://api.lemonfree.com/v2/locations/?make=Toyota&format=json&key=07859aa5804ac8c1425bdb703ca961ed")
					.asJson().getBody();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return responseLocationsbyMake;
	}

	public static JsonNode getListingsbyMakeAndModel() {

		JsonNode responseListingsbyMakeAndModel = null;
		try {
			responseListingsbyMakeAndModel = Unirest
					.get("	http://api.lemonfree.com/v2/listings/?make=Toyota&model=Camry&format=json&key=07859aa5804ac8c1425bdb703ca961ed")
					.asJson().getBody();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return responseListingsbyMakeAndModel;
	}

}
