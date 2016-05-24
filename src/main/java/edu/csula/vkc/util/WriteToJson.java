package edu.csula.vkc.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.csula.vkc.models.Make;
import edu.csula.vkc.models.Vehicle;

public class WriteToJson {

	private static String location = "C:\\Users\\chitt_000\\Documents\\";
	private static String folderForData = "data-science-2016\\";
	//private static String fileName = "name"+ (new Date()).toString() +".json";

	//Old method to write a file by makes.
	public boolean writeNewFile(String serviceName, Collection<Make> make) {

		try {

			File f = new File(location + folderForData + serviceName + ".json");

			if (f.exists()) {
				// Do Nothing
				System.out.println("File already exists.");
			} else {
				f.createNewFile();
				System.out.println("File Created.");
			}

			ObjectMapper mapper = new ObjectMapper();

			// System.out.println(make.get(0).getModelList().get(0).getModel().toString());

			FileWriter file = new FileWriter(location + folderForData + serviceName + ".json");
			file.write(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(make));
			file.flush();
			file.close();

			return true;

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	//Old method to write a file by make and model name.
	public boolean writeNewFile(String serviceName, String modelName, Collection<Make> make) {
		try {
			File f = new File(location + folderForData + serviceName + "." + modelName + ".json");

			if (f.exists()) {
				// Do Nothing
				System.out.println("File already exists.");
			} else {
				f.createNewFile();
				System.out.println("File Created.");
			}

			ObjectMapper mapper = new ObjectMapper();

			// System.out.println(make.get(0).getModelList().get(0).getModel().toString());

			FileWriter file = new FileWriter(location + folderForData + serviceName + "." + modelName + ".json");
			file.write(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(make));
			file.flush();
			file.close();

			return true;

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	//New Method to write a file by make and model
	public boolean writeNewVehicleFile(String makeName, String modelName, Collection<Vehicle> vehicle) {
		try {
			File f = new File(location + folderForData + makeName + "." + modelName + ".json");

			if (f.exists()) {
				// Do Nothing
				System.out.println("File already exists.");
			} else {
				f.createNewFile();
				System.out.println("File Created.");
			}

			ObjectMapper mapper = new ObjectMapper();

			// System.out.println(make.get(0).getModelList().get(0).getModel().toString());

			FileWriter file = new FileWriter(location + folderForData + makeName + "." + modelName + ".json");
			file.write(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(vehicle));
			file.flush();
			file.close();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	//New Method to write a file by make
	public boolean writeNewVehicleFile(String makeName, Collection<Vehicle> vehicle) {
		try {
			File f = new File(location + folderForData + makeName + ".json");

			if (f.exists()) {
				// Do Nothing
				System.out.println("File already exists.");
			} else {
				f.createNewFile();
				System.out.println("File Created.");
			}

			ObjectMapper mapper = new ObjectMapper();

			// System.out.println(make.get(0).getModelList().get(0).getModel().toString());

			FileWriter file = new FileWriter(location + folderForData + makeName + ".json");
			file.write(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(vehicle));
			file.flush();
			file.close();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
