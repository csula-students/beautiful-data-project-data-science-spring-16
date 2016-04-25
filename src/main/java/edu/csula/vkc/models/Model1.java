package edu.csula.vkc.models;

import java.util.List;

public class Model1 {
	private long model_id;
	private String model;
	private List<Years1> year;
	
	public Model1() {
		super();
	}

	public Model1(long model_id, String model, List<Years1> year) {
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

	public List<Years1> getYear() {
		return year;
	}

	public void setYear(List<Years1> year) {
		this.year = year;
	}
	
	

}
