package edu.csula.vkc.services;

import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class LemonFreeService {

	static String keyKuntal = "07859aa5804ac8c1425bdb703ca961ed";
	static String keyChitta = "93fa1b00fac63ed8fc0317294736f57f";
	// static String keyVidus = "gfjuzyug6ajpxeejf9tdse48";

	static int round = 0;

	public JsonNode getMakes() {

		JsonNode responseMake = null;
		try {
			responseMake = Unirest.get("http://api.lemonfree.com/v2/makes/?format=json&key=" + getKey()).asJson()
					.getBody();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return responseMake;
	}

	public JsonNode getModelsByMakeID(long id) {

		JsonNode responseModelsByMakeID = null;
		try {
			responseModelsByMakeID = Unirest
					.get("http://api.lemonfree.com/v2/models/?make_id=" + id + "&format=json&key=" + getKey()).asJson()
					.getBody();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return responseModelsByMakeID;
	}

	private static String getKey() {

		String useKey = "";
		int intMod = round % 2;

		switch (intMod) {
		case 0:
			useKey = keyKuntal;
			break;
		case 1:
			useKey = keyChitta;
			break;
		}

		round++;
		return useKey;
	}

	// public static JsonNode getTrimsByMakeandModel() {
	//
	// JsonNode responseTrimsByMakeandModel = null;
	// try {
	// responseTrimsByMakeandModel = Unirest
	// .get("http://api.lemonfree.com/v2/trims/?make=Chevrolet&model=Cavalier&format=json&key=07859aa5804ac8c1425bdb703ca961ed")
	// .asJson().getBody();
	// } catch (UnirestException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// return responseTrimsByMakeandModel;
	// }
	//
	// public static JsonNode getYearsByMakeandModel() {
	//
	// JsonNode responseYearsByMakeandModel = null;
	// try {
	// responseYearsByMakeandModel = Unirest
	// .get("http://api.lemonfree.com/v2/years/?make=Nissan&model=Altima&format=json&key=07859aa5804ac8c1425bdb703ca961ed")
	// .asJson().getBody();
	// } catch (UnirestException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// return responseYearsByMakeandModel;
	// }
	//
	// public static JsonNode getPricesByMake() {
	//
	// JsonNode responsePricesByMake = null;
	// try {
	// responsePricesByMake = Unirest
	// .get("http://api.lemonfree.com/v2/prices/?make=Oldsmobile&format=json&key=07859aa5804ac8c1425bdb703ca961ed")
	// .asJson().getBody();
	// } catch (UnirestException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// return responsePricesByMake;
	// }
	//
	// public static JsonNode getLocations() {
	//
	// JsonNode responseLocations = null;
	// try {
	// responseLocations = Unirest
	// .get("http://api.lemonfree.com/v2/locations/?format=json&key=07859aa5804ac8c1425bdb703ca961ed")
	// .asJson().getBody();
	// } catch (UnirestException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// return responseLocations;
	// }
	//
	// public static JsonNode getLocationsbyMake() {
	//
	// JsonNode responseLocationsbyMake = null;
	// try {
	// responseLocationsbyMake = Unirest
	// .get("http://api.lemonfree.com/v2/locations/?make=Toyota&format=json&key=07859aa5804ac8c1425bdb703ca961ed")
	// .asJson().getBody();
	// } catch (UnirestException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// return responseLocationsbyMake;
	// }

	public JsonNode getListingsbyMakeAndModel(String makeName, String modelName) {

		JsonNode responseListingsbyMakeAndModel = null;
		try {
			// System.out.println("http://api.lemonfree.com/v2/listings/?make="+makeName+"&model="+modelName+"&format=json&key=07859aa5804ac8c1425bdb703ca961ed");
			responseListingsbyMakeAndModel = Unirest.get("http://api.lemonfree.com/v2/listings/?make=" + makeName
					+ "&model=" + modelName + "&format=json&key=" + getKey()).asJson().getBody();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return responseListingsbyMakeAndModel;
	}

}
