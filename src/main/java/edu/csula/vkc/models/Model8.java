package edu.csula.vkc.models;

import java.util.List;

public class Model8 {
	private long model_id;
	private String model;
	private List<Years8> year;
	
	public Model8() {
		super();
	}

	public Model8(long model_id, String model, List<Years8> year) {
		super();
		this.model_id = model_id;
		this.model = model;
		this.year = year;
	}

	public long getModel_id() {
		return model_id;
	}

	public void setModel_id(long model_id) {
		this.model_id = model_id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public List<Years8> getYear() {
		return year;
	}

	public void setYear(List<Years8> year) {
		this.year = year;
	}
	
	

}
