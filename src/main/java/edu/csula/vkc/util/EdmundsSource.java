package edu.csula.vkc.util;

import java.time.Year;
import java.util.Collection;
import java.util.List;

import javax.swing.ListModel;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.common.collect.Lists;
import com.mashape.unirest.http.JsonNode;
import com.mongodb.util.JSON;
import com.sun.media.jfxmediaimpl.MarkerStateListener;

import edu.csula.datascience.acquisition.Source;
import edu.csula.vkc.models.CarMetadata;
import edu.csula.vkc.models.MPG;
import edu.csula.vkc.models.Make;
import edu.csula.vkc.models.Model;
import edu.csula.vkc.models.Price;
import edu.csula.vkc.models.Styles;
import edu.csula.vkc.models.Years;
import edu.csula.vkc.services.EdmundsService;

public class EdmundsSource implements Source<CarMetadata>{

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Collection<CarMetadata> next() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Make> getData() throws Exception{
		
		EdmundsService edmundsService = new EdmundsService();
		List<Make> listMake = Lists.newArrayList();
		JsonNode carMakes =  edmundsService.getMakes();
		
		JSONArray arrayMakes = (JSONArray) carMakes.getObject().get("makes");
		
		//System.out.println(test);
		//System.out.println(arrayMakes);
		
		//Code for Make Retival
		for(int i =0; i<arrayMakes.length();i++){
			JSONObject jsonMake = arrayMakes.getJSONObject(i);
			Make make = new Make();
			
			make.setMake(jsonMake.getString("niceName"));
			make.setMake_id(jsonMake.getLong("id"));
			make.setSource("Edmunds");
			
			//System.out.println(make.getMake_id());
			//System.out.println(make.getMake());
			
			JSONArray arrayModels = jsonMake.getJSONArray("models");
			List<Model> listModels = Lists.newArrayList();
			
			//Code to retrive Models from Make.
			for(int j=0;j<arrayModels.length();j++){
				JSONObject jsonModel = arrayModels.getJSONObject(j);
				
				Model model = new Model();
				
				//model.setModel_id(jsonModel.getLong("id"));
				model.setModel(jsonModel.getString("name"));
			
				//System.out.println(model.getModel_id());
				//System.out.println(model.getModel());
				
				JSONArray arrayYears = jsonModel.getJSONArray("years");
				List<Years> listYears = Lists.newArrayList();
				
				//Code for getting Years form Make>Models.
				for(int k=0;k<arrayYears.length();k++){
					JSONObject jsonYear = arrayYears.getJSONObject(k);
					
					Years year = new Years();
					
					year.setYear_id(jsonYear.getLong("id"));
					year.setYear(jsonYear.get("year").toString());
					
					JsonNode carDetails = edmundsService.getCarDetails(make.getMake(), model.getModel(), year.getYear());
					System.out.println(make.getMake() + " " + make.getMake() +" " +year.getYear());
					

					JSONArray arrayStyles = (JSONArray) carDetails.getObject().get("styles");
					List<Styles> listStyles = Lists.newArrayList();
					
					for(int l=0;l<arrayStyles.length();l++){
						JSONObject jsonStyle = arrayStyles.getJSONObject(l);
						Styles style = new Styles();
						
						MPG mpg = new MPG();
						Price price = new Price();
						
						style.setDriveSystem(jsonStyle.has("drivenWheels") ? jsonStyle.getString("drivenWheels"): null);						
						style.setNumOfDoors(jsonStyle.has("numOfDoors") ? jsonStyle.getInt("numOfDoors"): null);
						style.setTrim(jsonStyle.has("trim")? jsonStyle.getString("trim"):null);
						style.setName(jsonStyle.has("name")? jsonStyle.getString("name"):null);
						style.setStyleId(jsonStyle.has("id")? jsonStyle.getLong("id"):null);
						style.setMpg(mpg);
						
						listStyles.add(style);
						Thread.sleep(50);
					}
					
					listYears.add(year);
				}
				
				model.setYear(listYears);
				listModels.add(model);
			}
			
			make.setModelList(listModels);
			
			listMake.add(make);
		}

		
		
		return null;
	}
	
}
