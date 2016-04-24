package edu.csula.vkc.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.csula.vkc.models.Make;

public class WriteToJson {
	
	private String location = "C:\\Users\\chitt_000\\Documents\\";
	
	private String folderForData = "data-science-2016\\";

	public boolean writeNewFile(String serviceName, List<Make> make) {

		try {

			File f = new File(location + folderForData + serviceName +".json");
			
			if (f.exists())
			{
				//Do Nothing
				System.out.println("File already exists.");
		    }else{
		    	f.createNewFile();
		        System.out.println("File Created.");
		    }
			
			ObjectMapper mapper = new ObjectMapper();
			
			System.out.println(make.get(0).getModelList().get(0).getModel().toString());
			
			//System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(make));
			
			//JSONObject array = new JSONObject(data.toString());

			FileWriter file = new FileWriter(location + folderForData + serviceName +".json");
			file.write(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(make));
			file.flush();
			file.close();
			
			return true;

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
}
