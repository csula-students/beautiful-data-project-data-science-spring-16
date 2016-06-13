package edu.csula.vkc.third.apps;

import static org.elasticsearch.node.NodeBuilder.nodeBuilder;

import java.io.IOException;
import java.util.Collection;

import org.bson.Document;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.node.Node;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import edu.csula.vkc.third.models.Vehicle;
import io.searchbox.action.BulkableAction;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;
import io.searchbox.core.Bulk;
import io.searchbox.core.Index;

public class MongoToAmazon {

	private final static String indexName = "bd-car";
	private final static String typeName = "Vehicle";

	// establish database connection to MongoDB
	static MongoClient mongoClient;
	static MongoDatabase database;
	static MongoCollection<Document> collection;

	public static void main(String[] args) {

		String awsAddress = "1";
		JestClientFactory factory = new JestClientFactory();
		factory.setHttpClientConfig(new HttpClientConfig.Builder(awsAddress).multiThreaded(true).build());
		JestClient client = factory.getObject();
		mongoClient = new MongoClient();
		database = mongoClient.getDatabase("vehicles");
		collection = database.getCollection("collection");
		FindIterable<Document> cursor = null;

		Collection<Vehicle> lstVehicles = Lists.newArrayList();
		ObjectMapper mapper = new ObjectMapper();

		int count = 0;

		try {
			cursor = collection.find();

			for (Document doc : cursor) {

				doc.remove("_id");

				Vehicle vehicle = mapper.readValue(doc.toJson(), Vehicle.class);

				System.out.println(doc.toString());

				if (count < 10) {
					lstVehicles.add(vehicle);
					count++;
				} else {
					try {
						Collection<BulkableAction> actions = Lists.newArrayList();
						lstVehicles.stream().forEach(tmp -> {
							actions.add(new Index.Builder(tmp).build());
						});
						Bulk.Builder bulk = new Bulk.Builder().defaultIndex(indexName).defaultType(typeName)
								.addAction(actions);
						client.execute(bulk.build());
						count = 0;
						lstVehicles = Lists.newArrayList();
						System.out.println("Inserted 10 documents to cloud");
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}

			Collection<BulkableAction> actions = Lists.newArrayList();
			lstVehicles.stream().forEach(tmp -> {
				actions.add(new Index.Builder(tmp).build());
			});
			Bulk.Builder bulk = new Bulk.Builder().defaultIndex(indexName).defaultType(typeName).addAction(actions);
			client.execute(bulk.build());

		} catch (

		Exception e) {
			e.printStackTrace();
		}

		System.out.println("We are done! Yay!");
	}

}
