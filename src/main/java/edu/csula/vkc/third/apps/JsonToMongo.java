package edu.csula.vkc.third.apps;

import java.io.File;
import java.io.FileReader;
import java.util.Collection;
import java.util.List;

import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import edu.csula.vkc.third.models.Vehicle;

public class JsonToMongo {
	public static void main(String[] args) {

		MongoClient mongoClient = null;
		MongoDatabase database;
		MongoCollection<Document> collection;

		try {

			// establish database connection to MongoDB
			mongoClient = new MongoClient();

			// select `bd-example` as testing database
			database = mongoClient.getDatabase("vehicles");

			// select collection by name `tweets`
			collection = database.getCollection("collection");
			List<Document> documents = Lists.newArrayList();

			// For Each json File.
			File dir = new File("C:/Users/chitt_000/Documents/data-science-2016/CarData/");
			File[] directoryListing = dir.listFiles();
			if (directoryListing != null) {
				for (File jsonFile : directoryListing) {

					JsonParser parser = new JsonParser();
					Object obj = parser.parse(new FileReader(jsonFile));
					JsonArray arrayFile = (JsonArray) obj;

					Collection<Vehicle> vehicles = Lists.newArrayList();
					ObjectMapper mapper = new ObjectMapper();

					// for each record, we will insert data into Elastic Search
					// parser.forEach(record -> {
					for (int i = 0; i < arrayFile.size(); i++) {
						// cleaning up dirty data which doesn't have time or
						// temperature
						JsonObject objCurrent = (JsonObject) arrayFile.get(i);
						if ((Integer.parseInt(objCurrent.get("minOriginalPrice").toString().trim()) != 0)
								&& (Integer.parseInt(objCurrent.get("maxOriginalPrice").toString().trim()) != 0)) {

							Vehicle temp = mapper.readValue(objCurrent.toString(), Vehicle.class);
							vehicles.add(temp);
						}
					}

					for (Vehicle veh : vehicles) {
						documents.add(Document.parse(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(veh)));
					}
				}
			}
			collection.insertMany(documents);
		} catch (

		Exception e) {
			System.out.println(e.toString());

		} finally {
			mongoClient.close();
		}
		System.out.println("We are done! Yay!");
	}

}
