package edu.csula.vkc.third.apps;

import com.google.common.collect.Lists;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.csula.vkc.third.models.Vehicle;
import io.searchbox.action.BulkableAction;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;
import io.searchbox.core.Bulk;
import io.searchbox.core.Index;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;

public class JsontoAmazon {

	public static void main(String[] args) {
		String indexName = "bd-car";
		String typeName = "vehicle";
		String awsAddress = "http://{{yourelasticsearchname.us-west-2.es.amazonaws.com}}/";
		JestClientFactory factory = new JestClientFactory();
		factory.setHttpClientConfig(new HttpClientConfig.Builder(awsAddress).multiThreaded(true).build());
		JestClient client = factory.getObject();

		try {

			// For Each json File.
			File dir = new File("C:/Users/chitt_000/Documents/data-science-2016/CarData/");
			File[] directoryListing = dir.listFiles();
			if (directoryListing != null) {
				for (File jsonFile : directoryListing) {

					JsonParser parser = new JsonParser();
					Object obj = parser.parse(new FileReader(jsonFile));
					JsonArray arrayFile = (JsonArray) obj;

					Collection<Vehicle> temperatures = Lists.newArrayList();
					ObjectMapper mapper = new ObjectMapper();

					int count = 0;

					// for each record, we will insert data into Elastic Search
					// parser.forEach(record -> {
					for (int i = 0; i < arrayFile.size(); i++) {
						// cleaning up dirty data which doesn't have time or
						// temperature
						JsonObject objCurrent = (JsonObject) arrayFile.get(i);
						if ((Integer.parseInt(objCurrent.get("minOriginalPrice").toString().trim()) != 0)
								&& (Integer.parseInt(objCurrent.get("maxOriginalPrice").toString().trim()) != 0)) {

							Vehicle temp = mapper.readValue(objCurrent.toString(), Vehicle.class);

							// System.out.println(objCurrent.toString());
							// System.out.println(temp.getMakeName());

							if (count < 10) {
								temperatures.add(temp);
								count++;
							} else {
								try {
									Collection<BulkableAction> actions = Lists.newArrayList();
									temperatures.stream().forEach(tmp -> {
										actions.add(new Index.Builder(tmp).build());
									});
									Bulk.Builder bulk = new Bulk.Builder().defaultIndex(indexName).defaultType(typeName)
											.addAction(actions);
									client.execute(bulk.build());
									count = 0;
									temperatures = Lists.newArrayList();
									System.out.println("Inserted 10 documents to cloud");
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
						}
					}

					Collection<BulkableAction> actions = Lists.newArrayList();
					temperatures.stream().forEach(tmp -> {
						actions.add(new Index.Builder(tmp).build());
					});
					Bulk.Builder bulk = new Bulk.Builder().defaultIndex(indexName).defaultType(typeName)
							.addAction(actions);
					client.execute(bulk.build());
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("We are done! Yay!");

	}

}
