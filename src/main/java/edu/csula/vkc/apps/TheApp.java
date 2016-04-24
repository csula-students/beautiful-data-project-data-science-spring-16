package edu.csula.vkc.apps;

import java.util.Collection;

import edu.csula.vkc.models.CarMetadata;
import edu.csula.vkc.util.EdmundsSource;
import edu.csula.vkc.util.GenericCollector;

public class TheApp {
	public static void main(String[] args) {
		
        EdmundsSource source = new EdmundsSource();
        GenericCollector collector = new GenericCollector();

            Collection<CarMetadata> carMetadata = source.getData();
            System.out.println("Hello 1");
            Collection<CarMetadata> cleanedTweets = collector.mungee(carMetadata);
            collector.save(cleanedTweets);
        
    }
}
