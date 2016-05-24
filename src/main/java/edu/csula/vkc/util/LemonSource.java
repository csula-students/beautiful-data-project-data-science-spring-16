package edu.csula.vkc.util;

import java.util.Collection;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.common.collect.Lists;
import com.mashape.unirest.http.JsonNode;

import edu.csula.datascience.acquisition.Source;
import edu.csula.vkc.models.Make;
import edu.csula.vkc.models.Model;
import edu.csula.vkc.models.Price;
import edu.csula.vkc.models.Styles;
import edu.csula.vkc.models.Years;
import edu.csula.vkc.services.LemonFreeService;

public class LemonSource implements Source<Make> {

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Collection<Make> next() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Make> getData() throws InterruptedException {
		
		List<Make> listMake = Lists.newArrayList();
		JsonNode carMakes = LemonFreeService.getMakes();
		System.out.println("Hello Source");
		JSONArray arrayMakes = (JSONArray) carMakes.getObject().getJSONObject("response").getJSONArray("result");

		WriteToJson writer = new WriteToJson();

		// Code for Make Retival
		for (int i = 0; i < arrayMakes.length(); i++) {
			JSONObject jsonMake = arrayMakes.getJSONObject(i);
			Make make = new Make();
			List<Model> listModels = Lists.newArrayList();

			make.setMake(jsonMake.getString("make"));
			make.setMake_id(jsonMake.getLong("make_id"));
			make.setSource("LemonFree");

			System.out.println(make.getMake());

			JsonNode carModels = LemonFreeService.getModelsByMakeID(make.getMake_id());
			JSONArray arrayModels = (JSONArray) carModels.getObject().getJSONObject("response").getJSONArray("result");

			for (int j = 0; j < arrayModels.length(); j++) {
				JSONObject jsonModel = arrayModels.getJSONObject(j);
				Model model = new Model();

				model.setModel(jsonModel.getString("model"));
				model.setModel_id(jsonModel.getLong("model_id"));
				System.out.println("\t" + model.getModel());

				JsonNode carListing = LemonFreeService.getListingsbyMakeAndModel(make.getMake().trim().replaceAll(" ", "%20"), model.getModel().trim().replaceAll(" ", "%20"));
				
				if (carListing.getObject().getJSONObject("response").getInt("response_code")==0) {
					
					JSONArray arrayListing = (JSONArray) carListing.getObject().getJSONObject("response")
							.getJSONObject("result").getJSONArray("listings");
					
					List<Years> listYears = Lists.newArrayList();
					for (int k = 0; k < arrayListing.length(); k++) {
						JSONObject jsonListing = arrayListing.getJSONObject(k);
						Years year = new Years();
						year.setYear(jsonListing.has("year") ? jsonListing.getString("year") : null);

						Styles style = new Styles();
						style.setVehicalType(jsonListing.has("bodystyle") && !jsonListing.get("bodystyle").equals(null)
								? jsonListing.getString("bodystyle") : null);
						style.setTrim(jsonListing.has("trim")
								? jsonListing.get("trim").toString() : null);
						//System.out.println(jsonListing.has("trim")? jsonListing.get("trim"):null);
						style.setPrice(jsonListing.has("price") && !jsonListing.get("price").equals("")
								? new Price(Double.parseDouble(jsonListing.getString("price")), Double.parseDouble(jsonListing.getString("price")))
								: new Price());
						style.setMileage(jsonListing.has("mileage") && !jsonListing.isNull("mileage")
								&& !jsonListing.get("mileage").equals("") ? jsonListing.getLong("mileage") : 0);

						List<Styles> listStyles = Lists.newArrayList();
						listStyles.add(style);
						year.setStyles(listStyles);

						listYears.add(year);

						model.setYear(listYears);

						System.out.println("\t \t" + year.getYear());
					}
				}				
				
				listModels.add(model);
			}
			make.setModelList(listModels);
			listMake.add(make);
			writer.writeNewFile("LemonFree", make.getMake().trim().replaceAll(" ", "%20"), listMake);
		}

		writer.writeNewFile("LemonFree", listMake);
		
		return listMake;

	}

}
