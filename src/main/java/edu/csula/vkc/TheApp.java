package edu.csula.vkc;

import java.util.Collection;
import edu.csula.vkc.models.Basic;

public class TheApp {
	public static void main(String[] args) {
		
        EdmundsSource source = new EdmundsSource();
        GenericCollector collector = new GenericCollector();

            Collection<Basic> basic = source.getData();
            System.out.println("Hello 1");
            Collection<Basic> cleanedTweets = collector.mungee(basic);
            collector.save(cleanedTweets);
        
    }
}
