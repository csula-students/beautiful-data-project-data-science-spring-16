package edu.csula.vkc.third.apps;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import com.google.common.collect.Lists;
import edu.csula.vkc.services.TrueCarService;
import edu.csula.vkc.third.models.Details;
import edu.csula.vkc.third.models.Vehicle;
import edu.csula.vkc.third.util.GenericSource;
import edu.csula.vkc.third.util.VehicleCollector;

public class TheOne {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		List<Vehicle> listVehicals = Lists.newArrayList();

		// Sources
		GenericSource genericSource = new GenericSource();
		VehicleCollector collector = new VehicleCollector();
		
		while(genericSource.hasNext()){
			listVehicals = genericSource.next();
			Collection<Vehicle> cleanedVehicals = collector.mungee(listVehicals);
			collector.save(cleanedVehicals);
		}
	}
}
