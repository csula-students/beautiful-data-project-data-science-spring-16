package edu.csula.vkc.models;

import java.util.List;

public class Model2 {
	private long model_id;
	private String model;
	private List<Years2> year;
	
	public Model2() {
		super();
	}

	public Model2(long model_id, String model, List<Years2> year) {
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

	public List<Years2> getYear() {
		return year;
	}

	public void setYear(List<Years2> year) {
		this.year = year;
	}
	
	

}
