package edu.csula.vkc;

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
import edu.csula.vkc.models.Basic;

public class GenericCollector implements Collector<Basic, Basic> {

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
	public Collection<Basic> mungee(Collection<Basic> src) {

		// Add code to filter the data received

		return src;
	}

	@Override
	public void save(Collection<Basic> data) {
		
		List<Document> listDocuments = Lists.newArrayList();

		for (Basic basic : data) {

			Document document = new Document();

			document.put("make_name", basic.getMake_name());
			document.put("make_nickname", basic.getMake_nickname());
			document.put("model_name", basic.getModel_name());
			document.put("model_nickname", basic.getModel_name());
			document.put("style_id", basic.getStyle_id());

			listDocuments.add(document);
		}
		
		collection.insertMany(listDocuments);
	}

}
