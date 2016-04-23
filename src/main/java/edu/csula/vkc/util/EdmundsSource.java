package edu.csula.vkc.util;

import java.util.Collection;
import java.util.List;

import com.google.common.collect.Lists;

import edu.csula.datascience.acquisition.Source;
import edu.csula.vkc.models.CarMetadata;

public class EdmundsSource implements Source<CarMetadata>{
	
	public List<CarMetadata> getData(){
		
		System.out.println("the one.");
		
		List<CarMetadata> carMetadatas = Lists.newArrayList();
		
		CarMetadata carMetadata = new CarMetadata();
		
		carMetadata.setMake_name("Chittaksh");
		carMetadata.setMake_nickname("chitta");
		carMetadata.setModel_name("Car");
		carMetadata.setModel_nickname("ca");
		carMetadata.setStyle_id(100);
		
		carMetadatas.add(carMetadata);
		carMetadata = new CarMetadata();
		
		carMetadata.setMake_name("Kuntal");
		carMetadata.setMake_nickname("kun");
		carMetadata.setModel_name("Truck");
		carMetadata.setModel_nickname("tr");
		carMetadata.setStyle_id(101);
		
		carMetadatas.add(carMetadata);
		carMetadata = new CarMetadata();
		
		carMetadata.setMake_name("Vidushi");
		carMetadata.setMake_nickname("vidus");
		carMetadata.setModel_name("Tracktor");
		carMetadata.setModel_nickname("track");
		carMetadata.setStyle_id(102);
		
		carMetadatas.add(carMetadata);
		
		return carMetadatas;
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection<CarMetadata> next() {
		// TODO Auto-generated method stub
		return null;
	}

}
