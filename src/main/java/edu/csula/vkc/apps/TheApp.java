package edu.csula.vkc.apps;

import java.util.Collection;

import edu.csula.datascience.acquisition.Collector;
import edu.csula.vkc.models.Make;
import edu.csula.vkc.util.CSVSource;
import edu.csula.vkc.util.DummySource;
import edu.csula.vkc.util.EdmundsSource;
import edu.csula.vkc.util.GenericCollector;
import edu.csula.vkc.util.LemonSource;

public class TheApp {
	public static void main(String[] args) throws Exception {

		// Sources
		EdmundsSource edmundsSource = new EdmundsSource();
		LemonSource lemonSource = new LemonSource();
		CSVSource csvSource = new CSVSource();

		GenericCollector collector = new GenericCollector();

		// Collection<Make> edmundsData = edmundsSource.getData();
		// Collection<Make> cleanedEdmundsData = collector.mungee(edmundsData);
		// collector.save(cleanedEdmundsData);
		//
		 Collection<Make> lemonData = lemonSource.getData();
		 Collection<Make> cleanedLemonData = collector.mungee(lemonData);
		 collector.save(cleanedLemonData);
		
		// if(csvSource.hasNext()){
		// Collection<Make> csvData = csvSource.next();
		// Collection<Make> cleanedCSVData = collector.mungee(csvData);
		// collector.save(cleanedCSVData);
		// }

		DummySource dummySource = new DummySource(Long.MAX_VALUE);

		if (dummySource.hasNext()) {
			Collection<Make> dummyData = dummySource.next();
			Collection<Make> cleanedDummyData = collector.mungee(dummyData);
			collector.save(cleanedDummyData);
		}

	}
}
