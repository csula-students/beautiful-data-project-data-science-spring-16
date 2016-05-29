package edu.csula.vkc.apps;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import org.elasticsearch.action.bulk.*;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.unit.ByteSizeUnit;
import org.elasticsearch.common.unit.ByteSizeValue;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.node.Node;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.elasticsearch.node.NodeBuilder.nodeBuilder;

public class ElasticSearch {

	private final static String indexName = "car";
	private final static String typeName = "Vehicle";

	public static void main(String[] args) throws URISyntaxException, IOException {
		Node node = nodeBuilder()
				.settings(Settings.builder().put("cluster.name", "chittaksh").put("path.home", "elasticsearch-data"))
				.node();
		Client client = node.client();

		/**
		 *
		 *
		 * INSERT data to elastic search
		 */

		// as usual process to connect to data source, we will need to set up
		// node and client// to read CSV file from the resource folder
		String fname = "C:/Users/chitt_000/Documents/data-science-2016/audi.json";
		File jsonFile = new File(fname);

		// create bulk processor
		BulkProcessor bulkProcessor = BulkProcessor.builder(client, new BulkProcessor.Listener() {
			@Override
			public void beforeBulk(long executionId, BulkRequest request) {
			}

			@Override
			public void afterBulk(long executionId, BulkRequest request, BulkResponse response) {
			}

			@Override
			public void afterBulk(long executionId, BulkRequest request, Throwable failure) {
				System.out.println("Facing error while importing data to elastic search");
				failure.printStackTrace();
			}
		}).setBulkActions(10000).setBulkSize(new ByteSizeValue(1, ByteSizeUnit.GB))
				.setFlushInterval(TimeValue.timeValueSeconds(5)).setConcurrentRequests(1)
				.setBackoffPolicy(BackoffPolicy.exponentialBackoff(TimeValue.timeValueMillis(100), 3)).build();

		// Gson library for sending json to elastic search
		Gson gson = new Gson();

		try {
			// after reading the csv file, we will use CSVParser to parse
			// through
			// the csv files
			JsonParser parser = new JsonParser();
			Object obj = parser.parse(new FileReader(jsonFile));
			JsonArray arrayFile = (JsonArray) obj;
			
			for(int i = 0; i <arrayFile.size(); i++){
				System.out.println(arrayFile.get(i).toString()); // This statement is printing that..
				
				bulkProcessor.add(new IndexRequest(indexName, typeName)
                        .source(gson.toJson(arrayFile.get(i)))
                    );
			}

			// System.out.println(arrayFile.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}

		/**
		 * Structured search
		 */
	}
}
