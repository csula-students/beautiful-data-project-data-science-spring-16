package edu.csula.vkc.services;

public class ServiceKeys {

	// Edmunds Keys.
	static String keyEdmundsKuntal = "1";
	static String keyEdmundsKuntal2 = "2";
	static String keyEdmundsKuntal3 = "3";
	static String keyEdmundsChitta = "4";
	static String keyEdmundsVidus = "5";

	// LemonFree Keys
	static String keyLemonFreeKuntal = "6";
	static String keyLemonFreeChitta = "7";
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
