package edu.csula.vkc.services;

import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

import edu.csula.vkc.second.util.WriteToJson;

public class EdmundsService {

	static WriteToJson writer = new WriteToJson();

	static String keyKuntal = "9czdpmae3rqxgx27hp5p9qt5";
	static String keyKuntal2 = "qe3x5dhwfdvk3be6887pkjgm";
	static String keyKuntal3 = "ppak4b6p4mmz5nc3hnfa539n";
	static String keyChitta = "uwdpgeujhycxxbrfubjmk8jr";
	static String keyVidus = "gfjuzyug6ajpxeejf9tdse48";

	static int round = 0;

	public static JsonNode getMakes() {

		JsonNode responseMake = null;
		try {
			responseMake = Unirest.get("http://api.edmunds.com/api/vehicle/v2/makes?fmt=json&api_key=" + getKey())
					.asJson().getBody();
		} catch (Exception e) {
			System.out.print("Source : Edmunds Service");
			System.out.println(e.toString());
		}

		return responseMake;
	}

	public static JsonNode getCarDetails(String strMake, String strModel, String strYear) {

		JsonNode responseCarDetails = null;
		try {
			responseCarDetails = Unirest.get("https://api.edmunds.com/api/vehicle/v2/" + strMake + "/" + strModel + "/"
					+ strYear + "/styles?fmt=json&api_key=" + getKey() + "&view=full").asJson().getBody();
		} catch (Exception e) {
			System.out.print("Source : Edmunds Service");
			System.out.println(e.toString());
		}

		return responseCarDetails;
	}

	private static String getKey() {

		String useKey = "";
		int intMod = round % 5;

		switch (intMod) {
		case 0:
			useKey = keyKuntal;
			break;
		case 1:
			useKey = keyKuntal2;
			break;
		case 2:
			useKey = keyKuntal3;
			break;
		case 3:
			useKey = keyChitta;
			break;
		case 4:
			useKey = keyVidus;
			break;
		}

		round++;
		return useKey;
	}
}
