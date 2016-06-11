package edu.csula.vkc.third.apps;

/*
 * 
 PUT /car
 {
     "mappings" : {
         "vehicle" : {
             "properties" : {
                 "id" : {
                     "type" : "long",
                     "index" : "not_analyzed"
                 },
                 "makeName" : {
                     "type" : "string",
                     "index" : "not_analyzed"
                 },
                 "modelName" : {
                     "type" : "string",
                     "index" : "not_analyzed"
                 },
                  "vehicleName" : {
                     "type" : "string",
                     "index" : "not_analyzed"
                 },
                 "year": {
                     "type": "date"
                 },
                 "noOfDoors" : {
                     "type" : "integer",
                     "index" : "not_analyzed"
                 },
                 "vehicleType" : {
                     "type" : "string",
                     "index" : "not_analyzed"
                 },
                 "noOfCylinder" : {
                     "type" : "integer",
                     "index" : "not_analyzed"
                 },
                 "transmission" : {
                     "type" : "string",
                     "index" : "not_analyzed"
                 },
                 "driveSystem" : {
                     "type" : "string",
                     "index" : "not_analyzed"
                 },
                 "fuelType" : {
                     "type" : "string",
                     "index" : "not_analyzed"
                 },
                 "trim" : {
                     "type" : "string",
                     "index" : "not_analyzed"
                 },
                "originalPrice" : {
                     "type" : "integer",
                     "index" : "not_analyzed"
                 },
                     "milage" : {
                         "properties":{
                     "highway" : {
                         "type" : "double",
                         "index" : "not_analyzed"
                     },
                     "city" : {
                         "type" : "double",
                         "index" : "not_analyzed"
                     }
                 }
             },
             "detail" : {
                      "properties" : {
                 "detailId" : {
                     "type" : "string",
                     "index" : "not_analyzed"
                 },
                 "salePrice" : {
                     "type" : "integer",
                     "index" : "not_analyzed"
                 },
                 "milesRun" : {
                     "type" : "integer",
                     "index" : "not_analyzed"
                 },
                  "source" : {
                     "type" : "string",
                     "index" : "not_analyzed"
                 },
                 "yearsOld" : {
                     "type" : "integer",
                     "index" : "not_analyzed"
                 }
             }
          }
         }
         
     }
    }
 
 }
 * 
 * 
 */

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
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

public class JsonToElasticSearch {

	private final static String indexName = "car";
	private final static String typeName = "vehicle";

	public static void main(String[] args) throws URISyntaxException, IOException {
		Node node = nodeBuilder().settings(
				Settings.builder().put("cluster.name", "elastic-vehicle").put("path.home", "elasticsearch-data"))
				.node();
		Client client = node.client();

		/**
		 *
		 *
		 * INSERT data to elastic search
		 */

		// as usual process to connect to data source, we will need to set up
		// node and client// to read CSV file from the resource folder

		File dir = new File("C:/Users/chitt_000/Documents/data-science-2016/companydata/");
		File[] directoryListing = dir.listFiles();
		if (directoryListing != null) {
			for (File jsonFile : directoryListing) {

				// String fname =
				// "C:/Users/vidus/Documents/data-science-2016/bmw.json";
				// File jsonFile = new File(fname);
				
				//System.out.println(jsonFile.getName());

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
				}).setBulkActions(10).setBulkSize(new ByteSizeValue(1, ByteSizeUnit.GB))
						.setFlushInterval(TimeValue.timeValueSeconds(5)).setConcurrentRequests(1)
						.setBackoffPolicy(BackoffPolicy.exponentialBackoff(TimeValue.timeValueMillis(100), 3)).build();

				try {
					JsonParser parser = new JsonParser();
					Object obj = parser.parse(new FileReader(jsonFile));
					JsonArray arrayFile = (JsonArray) obj;

					for (int i = 0; i < arrayFile.size(); i++) {

						JsonObject objCurrent = (JsonObject) arrayFile.get(i);
						if ((Integer.parseInt(objCurrent.get("minOriginalPrice").toString().trim()) != 0)
								&& (Integer.parseInt(objCurrent.get("maxOriginalPrice").toString().trim()) != 0)) {
							System.out.println(arrayFile.get(i).toString());

							bulkProcessor.add(new IndexRequest(indexName, typeName, objCurrent.get("id").getAsString())
									.source(arrayFile.get(i).toString()));
						}
					}
					// System.out.println(arrayFile.toString());
				} catch (Exception e) {
					e.printStackTrace();
				}

				/**
				 * Structured search
				 */

				/**
				 * AGGREGATION
				 */
				// SearchResponse sr = node.client().prepareSearch(indexName)
				// .setTypes(typeName)
				// .setQuery(QueryBuilders.matchAllQuery())
				// .addAggregation(
				// AggregationBuilders.terms("stateAgg").field("makeName")
				// .size(Integer.MAX_VALUE)
				// )
				// .execute().actionGet();
				//
				// // Get your facet results
				// Terms agg1 = sr.getAggregations().get("stateAgg");
				//
				// for (Terms.Bucket bucket: agg1.getBuckets()) {
				// System.out.println(bucket.getKey() + ": " +
				// bucket.getDocCount());
				// }
			}
		}
	}
}
