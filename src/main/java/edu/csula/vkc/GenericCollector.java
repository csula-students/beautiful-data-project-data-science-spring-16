package edu.csula.vkc;

import java.util.Collection;
import com.mashape.unirest.http.JsonNode;

import edu.csula.datascience.acquisition.*;
import edu.csula.vkc.models.Basic;

public class GenericCollector implements Collector<Basic, JsonNode>{

	@Override
	public Collection<Basic> mungee(Collection<JsonNode> src) {
		
		return null;
	}

	@Override
	public void save(Collection<Basic> data) {
		
		
	}

}
