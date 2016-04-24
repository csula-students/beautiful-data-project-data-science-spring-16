package edu.csula.vkc.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonFactory;
import com.google.common.collect.Lists;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.ObjectMapper;
import com.mongodb.util.JSON;

public class WriteToJson {
	
	String location = "C:\\Users\\vidus\\Documents\\";
	
	String folderForData = "data-science-2016\\";

	public boolean writeNewFile(String serviceName, String dataType,JsonNode data) {

		try {

			File f = new File(location + folderForData + serviceName +"."+ dataType +".json");
			
			if (f.exists())
			{
				//Do Nothing
				System.out.println("File already exists.");
		    }else{
		    	f.createNewFile();
		        System.out.println("File Created.");
		    }
			
			//Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
			/*JsonFactory factory = new JsonFactory();
			ObjectMapper mapper = new ObjectMapper(factory);*/
			
			System.out.println(data.toString());
			
			//JSONObject array = new JSONObject(data.toString());

			FileWriter file = new FileWriter(location + folderForData + serviceName +"."+ dataType +".json");
			file.write(data.toString());
			file.flush();
			file.close();
			
			return true;

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
}
