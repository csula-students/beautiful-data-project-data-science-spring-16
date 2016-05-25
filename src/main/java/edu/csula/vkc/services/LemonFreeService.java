package edu.csula.vkc.services;

import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class LemonFreeService {

	static String keyKuntal = "07859aa5804ac8c1425bdb703ca961ed";
	static String keyChitta = "93fa1b00fac63ed8fc0317294736f57f";
	// static String keyVidus = "gfjuzyug6ajpxeejf9tdse48";

	static String strMake;
	static String strModel;
	static JsonNode responseListings;

	static int round = 0;

	public static JsonNode getMakes() {

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

	public static JsonNode getModelsByMakeID(long id) {

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

	public static JsonNode getListingsbyMakeAndModel(String makeName, String modelName) {

		JsonNode responseListingsbyMakeAndModel = null;
		try {

			if (makeName == strMake && modelName == strModel) {
				responseListingsbyMakeAndModel = responseListings;
			} else {
				//System.out.println("Lemon Free Service : Query Fired");
				// System.out.println("http://api.lemonfree.com/v2/listings/?make="+makeName+"&model="+modelName+"&format=json&key=07859aa5804ac8c1425bdb703ca961ed");
				responseListingsbyMakeAndModel = Unirest.get("http://api.lemonfree.com/v2/listings/?make=" + makeName
						+ "&model=" + modelName + "&format=json&key=" + getKey()).asJson().getBody();
				
				strMake = makeName;
				strModel = modelName;
				responseListings = responseListingsbyMakeAndModel;
			}
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return responseListingsbyMakeAndModel;
	}

}
