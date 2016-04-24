package edu.csula.vkc.models;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class make {
	long vehicle_id;
	long make_id;
	String make;
	String source;
	List<Year> year;
	List<model> modelList;
	
	public make() {
		super();
	}

	
	public make(long vehicle_id, long make_id, String make, String source, List<Year> year, List<model> modelList,
			long price) {
		super();
		this.vehicle_id = vehicle_id;
		this.make_id = make_id;
		this.make = make;
		this.source = source;
		this.year = year;
		this.modelList = modelList;
	}



	public List<Year> getYear() {
		return year;
	}



	public void setYear(List<Year> year) {
		this.year = year;
	}

	public long getVehicle_id() {
		return vehicle_id;
	}

	public void setVehicle_id(long vehicle_id) {
		this.vehicle_id = vehicle_id;
	}

	public long getMake_id() {
		return make_id;
	}

	public void setMake_id(long make_id) {
		this.make_id = make_id;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public void setMake_id(int make_id) {
		this.make_id = make_id;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public List<model> getModelList() {
		return modelList;
	}

	public void setModelList(List<model> modelList) {
		this.modelList = modelList;
	}

}
