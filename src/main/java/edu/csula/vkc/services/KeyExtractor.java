package edu.csula.vkc.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class KeyExtractor {
	static ArrayList<String> edmunds = new ArrayList<String>();
	static ArrayList<String> lemonfree = new ArrayList<String>();
	static boolean flag=false;
	public static void keys() throws FileNotFoundException{
		if(edmunds.size()==0){
		Scanner s = new Scanner(new File("C:/Users/vidus/Desktop/Vidushi/spring 2016/cs594 Big data/keys.txt"));
		while (s.hasNext()) {
			
			if(flag!=true)
				if(s.hasNext("lemonfree"))
				flag=true;
			
			if(flag==true)
				lemonfree.add(s.next());
			else
				edmunds.add(s.next());
				
		}
		
		edmunds.remove(0);
		lemonfree.remove(0);
			
		/*for (String edmund1 : edmunds) {
			System.out.println(edmund1);
		}
		for (String lemonfree1 : lemonfree) {
			System.out.println(lemonfree1);
		}*/
		s.close();
		}
	}

	static int indexEdmunds = 1;
	static int indexLemonFree = 1;

	public String getEdmundsKey() throws FileNotFoundException {
		keys();
		indexEdmunds = indexEdmunds%edmunds.size();
		return edmunds.get(indexEdmunds++);

	}
	
	public  String getLemonfreeKey() throws FileNotFoundException{
		keys();
		indexLemonFree=indexLemonFree%lemonfree.size();
		return lemonfree.get(indexLemonFree++);
		
	}

}
