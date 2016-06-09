package edu.csula.vkc.services;

public class ServiceKeys {

	// Edmunds Keys.
	static String keyEdmundsKuntal = "9czdpmae3rqxgx27hp5p9qt5";
	static String keyEdmundsKuntal2 = "qe3x5dhwfdvk3be6887pkjgm";
	static String keyEdmundsKuntal3 = "ppak4b6p4mmz5nc3hnfa539n";
	static String keyEdmundsChitta = "uwdpgeujhycxxbrfubjmk8jr";
	static String keyEdmundsVidus = "gfjuzyug6ajpxeejf9tdse48";

	// LemonFree Keys
	static String keyLemonFreeKuntal = "07859aa5804ac8c1425bdb703ca961ed";
	static String keyLemonFreeChitta = "93fa1b00fac63ed8fc0317294736f57f";
	// static String keyLemonFreeVidus = "gfjuzyug6ajpxeejf9tdse48";

	// CurrentRound for Keys.
	static int roundEdmunds = 0;
	static int roundLemonFree = 0;

	//Code to return Edmunds Key.
	public static String getEdmundsKey() {

		String useKey = "";
		int intMod = roundEdmunds % 5;

		switch (intMod) {
		case 0:
			useKey = keyEdmundsKuntal;
			break;
		case 1:
			useKey = keyEdmundsKuntal2;
			break;
		case 2:
			useKey = keyEdmundsKuntal3;
			break;
		case 3:
			useKey = keyEdmundsChitta;
			break;
		case 4:
			useKey = keyEdmundsVidus;
			break;
		}

		roundEdmunds++;
		return useKey;
	}

	//Code to return LemonFree Key.
	public static String getLemonFreeKey() {
		String useKey = "";
		int intMod = roundLemonFree % 2;

		switch (intMod) {
		case 0:
			useKey = keyLemonFreeKuntal;
			break;
		case 1:
			useKey = keyLemonFreeChitta;
			break;
		}

		roundLemonFree++;
		return useKey;
	}
}
