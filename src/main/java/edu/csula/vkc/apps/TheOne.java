package edu.csula.vkc.apps;

import java.util.Collection;
import java.util.List;
import com.google.common.collect.Lists;
import edu.csula.vkc.models.Vehicle;
import edu.csula.vkc.util.GenericSource;
import edu.csula.vkc.util.VehicleCollector;

public class TheOne {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		List<Vehicle> listVehicals = Lists.newArrayList();

		// Sources
		GenericSource genericSource = new GenericSource();
		VehicleCollector collector = new VehicleCollector();
		
		//Testing call to Microsoft page.
		//MicrosoftService.getPrice("bugatti", "Veyron", "1999");
		
		while(genericSource.hasNext()){
			listVehicals = genericSource.next();
			Collection<Vehicle> cleanedVehicals = collector.mungee(listVehicals);
			collector.save(cleanedVehicals);
		}
	}
}
