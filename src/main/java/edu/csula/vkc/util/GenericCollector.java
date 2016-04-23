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

public class GenericCollector implements Collector<CarMetadata, CarMetadata> {

	MongoClient mongoClient;
	MongoDatabase database;
	MongoCollection<Document> collection;

	public GenericCollector() {

		// establish database connection to MongoDB
		mongoClient = new MongoClient();

		// select `bd-example` as testing database
		database = mongoClient.getDatabase("bd-example");

		// select collection by name `tweets`
		collection = database.getCollection("test");
	}

	@Override
	public Collection<CarMetadata> mungee(Collection<CarMetadata> src) {

		// Add code to filter the data received

		return src;
	}

	@Override
	public void save(Collection<CarMetadata> data) {
		
		List<Document> listDocuments = Lists.newArrayList();

		for (CarMetadata carMetadata : data) {

			Document document = new Document();

			document.put("make_name", carMetadata.getMake_name());
			document.put("make_nickname", carMetadata.getMake_nickname());
			document.put("model_name", carMetadata.getModel_name());
			document.put("model_nickname", carMetadata.getModel_name());
			document.put("style_id", carMetadata.getStyle_id());

			listDocuments.add(document);
		}
		
		collection.insertMany(listDocuments);
	}

}
