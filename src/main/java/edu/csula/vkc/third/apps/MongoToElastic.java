package edu.csula.vkc.third.apps;

import static org.elasticsearch.node.NodeBuilder.nodeBuilder;

import org.bson.Document;
import org.elasticsearch.action.bulk.BackoffPolicy;
import org.elasticsearch.action.bulk.BulkProcessor;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.unit.ByteSizeUnit;
import org.elasticsearch.common.unit.ByteSizeValue;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.node.Node;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import edu.csula.vkc.third.models.Vehicle;

public class MongoToElastic {

	private final static String indexName = "car";
	private final static String typeName = "vehicle";

	// establish database connection to MongoDB
	static MongoClient mongoClient;
	static MongoDatabase database;
	static MongoCollection<Document> collection;

	public static void main(String[] args) {

		mongoClient = new MongoClient();
		database = mongoClient.getDatabase("vehicles");
		collection = database.getCollection("collection");
		FindIterable<Document> cursor = null;

		Node node = nodeBuilder().settings(
				Settings.builder().put("cluster.name", "elastic-vehicle").put("path.home", "elasticsearch-data"))
				.node();
		Client client = node.client();

		// create bulk processor
		BulkProcessor bulkProcessor = BulkProcessor.builder(client, new BulkProcessor.Listener() {
			@Override
			public void beforeBulk(long executionId, BulkRequest request) {
			}

			@Override
			public void afterBulk(long executionId, BulkRequest request, BulkResponse response) {
				System.out.println(executionId);
			}

			@Override
			public void afterBulk(long executionId, BulkRequest request, Throwable failure) {
				System.out.println("Facing error while importing data to elastic search");
				failure.printStackTrace();
			}
		}).setBulkActions(100).setBulkSize(new ByteSizeValue(1, ByteSizeUnit.GB))
				.setFlushInterval(TimeValue.timeValueSeconds(5)).setConcurrentRequests(1)
				.setBackoffPolicy(BackoffPolicy.exponentialBackoff(TimeValue.timeValueMillis(100), 3)).build();

		// Gson library for sending json to elastic search
		Gson gson = new Gson();

		try {

			cursor = collection.find();

			ObjectMapper mapper = new ObjectMapper();

			for (Document doc : cursor) {

				doc.remove("_id");

				Vehicle vehicle = mapper.readValue(doc.toJson(), Vehicle.class);

				System.out.println(doc.toString());
				// System.out.println(doc.toJson().toString());

				bulkProcessor.add(new IndexRequest(indexName, typeName, String.valueOf(vehicle.getId()))
						.source(gson.toJson(vehicle)));
			}
			// System.out.println(arrayFile.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
