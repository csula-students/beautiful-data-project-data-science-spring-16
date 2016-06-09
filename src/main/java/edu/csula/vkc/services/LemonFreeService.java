package edu.csula.vkc.services;

import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

public class LemonFreeService {

	static String strMake;
	static String strModel;
	static JsonNode responseListings;

	public static JsonNode getMakes() {

		JsonNode responseMake = null;
		try {
			responseMake = Unirest
					.get("http://api.lemonfree.com/v2/makes/?format=json&key=" + ServiceKeys.getLemonFreeKey()).asJson()
					.getBody();
		} catch (Exception e) {
			System.out.print("Source : LemonFree Service ");
			System.out.println(e.toString());
		}

		return responseMake;
	}

	public static JsonNode getModelsByMakeID(long id) {

		JsonNode responseModelsByMakeID = null;
		try {
			responseModelsByMakeID = Unirest.get("http://api.lemonfree.com/v2/models/?make_id=" + id
					+ "&format=json&key=" + ServiceKeys.getLemonFreeKey()).asJson().getBody();
		} catch (Exception e) {
			System.out.print("Source : LemonFree Service ");
			System.out.println(e.toString());
		}

		return responseModelsByMakeID;
	}

	public static JsonNode getListingsbyMakeAndModel(String makeName, String modelName) {

		JsonNode responseListingsbyMakeAndModel = null;
		try {

			if (makeName == strMake && modelName == strModel) {
				responseListingsbyMakeAndModel = responseListings;
			} else {
				//String str = ServiceKeys.getLemonFreeKey();
				// System.out.println(str);
				// System.out.println("http://api.lemonfree.com/v2/listings/?make="+makeName+"&model="+modelName+"&format=json&key=07859aa5804ac8c1425bdb703ca961ed");
				responseListingsbyMakeAndModel = Unirest.get("http://api.lemonfree.com/v2/listings/?make=" + makeName
						+ "&model=" + modelName + "&format=json&key=" + ServiceKeys.getLemonFreeKey()).asJson().getBody();

				strMake = makeName;
				strModel = modelName;
				responseListings = responseListingsbyMakeAndModel;
			}
		} catch (Exception e) {
			System.out.print("Source : LemonFree Service ");
			System.out.println(e.toString());
		}

		return responseListingsbyMakeAndModel;
	}
}
