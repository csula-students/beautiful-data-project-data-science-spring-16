package edu.csula.vkc.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.bson.Document;

import com.google.common.collect.Lists;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import edu.csula.datascience.acquisition.*;
import edu.csula.vkc.models.CarMetadata;
import edu.csula.vkc.models.Make;

public class GenericCollector implements Collector<Make, Make> {

	MongoClient mongoClient;
	MongoDatabase database;
	MongoCollection<Document> collection;

	public GenericCollector() {
		super();
	}

	@Override
	public Collection<Make> mungee(Collection<Make> src) {

		// Add code to filter the data received

		return src;
	}

	@Override
	public void save(Collection<Make> data) {

		// establish database connection to MongoDB
		mongoClient = new MongoClient();

		// select `bd-example` as testing database
		database = mongoClient.getDatabase("bd-example");

		// select collection by name `tweets`
		collection = database.getCollection("test");

		List<Document> listDocuments = Lists.newArrayList();

		for (Make carMetadata : data) {

			Document document = new Document();

			//document.put("make_id", carMetadata.getMake_id());
			//document.put("make_name", carMetadata.getMake());
			//document.put("vehical_id", carMetadata.getVehicle_id());
			// document.put("model_nickname", carMetadata.getModel_name());
			// document.put("style_id", carMetadata.getStyle_id());

			listDocuments.add(document);
		}

		collection.insertMany(listDocuments);
	}

}
