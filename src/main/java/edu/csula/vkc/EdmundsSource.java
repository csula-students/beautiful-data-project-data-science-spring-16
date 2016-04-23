package edu.csula.vkc;

import java.util.Collection;
import java.util.List;

import com.google.common.collect.Lists;

import edu.csula.datascience.acquisition.Source;
import edu.csula.vkc.models.Basic;

public class EdmundsSource implements Source<Basic>{
	
	public List<Basic> getData(){
		
		System.out.println("the one.");
		
		List<Basic> basics = Lists.newArrayList();
		
		Basic basic = new Basic();
		
		basic.setMake_name("Chittaksh");
		basic.setMake_nickname("chitta");
		basic.setModel_name("Car");
		basic.setModel_nickname("ca");
		basic.setStyle_id(100);
		
		basics.add(basic);
		basic = new Basic();
		
		basic.setMake_name("Kuntal");
		basic.setMake_nickname("kun");
		basic.setModel_name("Truck");
		basic.setModel_nickname("tr");
		basic.setStyle_id(101);
		
		basics.add(basic);
		basic = new Basic();
		
		basic.setMake_name("Vidushi");
		basic.setMake_nickname("vidus");
		basic.setModel_name("Tracktor");
		basic.setModel_nickname("track");
		basic.setStyle_id(102);
		
		basics.add(basic);
		
		return basics;
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection<Basic> next() {
		// TODO Auto-generated method stub
		return null;
	}

}
