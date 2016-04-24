package edu.csula.vkc.apps;

import java.util.Collection;
import edu.csula.vkc.models.Make;
import edu.csula.vkc.util.EdmundsSource;
import edu.csula.vkc.util.GenericCollector;

public class TheApp {
	public static void main(String[] args) throws Exception {
		
        EdmundsSource source = new EdmundsSource();
        GenericCollector collector = new GenericCollector();        
 
        if(source.hasNext()){
            Collection<Make> carMetadata = source.getData();
            //System.out.println("Hello 1");
            Collection<Make> cleanedTweets = collector.mungee(carMetadata);
            //collector.save(cleanedTweets);
        }
    }
}
