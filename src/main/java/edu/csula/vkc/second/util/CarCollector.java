package edu.csula.vkc.second.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.bson.Document;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import edu.csula.datascience.acquisition.Collector;
import edu.csula.vkc.third.models.Vehicle;

public class CarCollector implements Collector<Vehicle, Vehicle> {

	MongoClient mongoClient;
	MongoDatabase database;
	MongoCollection<Document> collection;

	public CarCollector() {
		super();
	}

	@Override
	public Collection<Vehicle> mungee(Collection<Vehicle> makesList) {

		List<Vehicle> makesdataListToRemove = new ArrayList<Vehicle>();

		makesList.removeAll(makesdataListToRemove);
		System.out.println(makesList.size());

		return makesList;
	}

	@Override
	public void save(Collection<Vehicle> data) {
		try {

			// establish database connection to MongoDB
			mongoClient = new MongoClient();

			//Database Name.
			database = mongoClient.getDatabase("bd-example");

			//Collection Name.
			collection = database.getCollection("test");

			ObjectMapper mapper = new ObjectMapper();

			for (Vehicle vehicle : data) {
				collection
						.insertOne(Document.parse(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(vehicle)));
			}

		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}
