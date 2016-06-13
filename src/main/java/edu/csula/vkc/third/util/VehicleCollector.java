package edu.csula.vkc.third.util;

import java.util.Collection;
import java.util.List;
import org.bson.Document;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import edu.csula.datascience.acquisition.Collector;
import edu.csula.vkc.third.models.Vehicle;

public class VehicleCollector implements Collector<Vehicle, Vehicle> {

	MongoClient mongoClient;
	MongoDatabase database;
	MongoCollection<Document> collection;

	@Override
	public Collection<Vehicle> mungee(Collection<Vehicle> src) {
		List<Vehicle> listRemoveVehicle = Lists.newArrayList();

		System.out.println("Original Count : " + src.size());

		for (Vehicle vehicle : src) {
			if (vehicle.getMinOriginalPrice() == 0 || vehicle.getMaxOriginalPrice() == 0) {
				listRemoveVehicle.add(vehicle);
			}
		}

		src.removeAll(listRemoveVehicle);

		System.out.println("Mungee Count : " + src.size());

		return src;
	}

	@Override
	public void save(Collection<Vehicle> data) {
		try {
			// establish database connection to MongoDB
			mongoClient = new MongoClient();

			// select `bd-example` as testing database
			database = mongoClient.getDatabase("vehicles");

			// select collection by name `tweets`
			collection = database.getCollection("collection");

			ObjectMapper mapper = new ObjectMapper();

			List<Document> documents = Lists.newArrayList();

			for (Vehicle veh : data) {
				documents.add(Document.parse(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(veh)));
			}

			collection.insertMany(documents);

		} catch (Exception e) {
			System.out.println(e.toString());

		} finally {
			mongoClient.close();
		}
	}

}
