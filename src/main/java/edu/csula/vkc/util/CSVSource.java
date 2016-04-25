package edu.csula.vkc.util;

import java.util.Collection;

import edu.csula.datascience.acquisition.Source;
import edu.csula.vkc.models.Make;

public class CSVSource implements Source<Make>{

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection<Make> next() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
