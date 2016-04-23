package edu.csula.vkc;

import java.util.Collection;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import edu.csula.datascience.acquisition.*;
import edu.csula.vkc.models.Basic;

public class GenericCollector implements Collector<Basic, Basic>{
	
	MongoClient mongoClient;
    MongoDatabase database;
    MongoCollection<Document> collection;
    
    public GenericCollector() {
    	
    	// establish database connection to MongoDB
        mongoClient = new MongoClient();
        // select `bd-example` as testing database
        database = mongoClient.getDatabase("bd-example");

        // select collection by name `tweets`
        collection = database.getCollection("tweets");
	}

	@Override
	public Collection<Basic> mungee(Collection<Basic> src) {
		
		// Add code to filter the data received
		
		return src;
	}

	@Override
	public void save(Collection<Basic> data) {
		
		//Code to save to the Database.
		
	}

}
