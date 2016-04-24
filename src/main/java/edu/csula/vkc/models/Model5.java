package edu.csula.vkc.models;

import java.util.List;

public class Model5 {
	private long model_id;
	private String model;
	private List<Years5> year;
	
	public Model5() {
		super();
	}

	public Model5(long model_id, String model, List<Years5> year) {
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

	public List<Years5> getYear() {
		return year;
	}

	public void setYear(List<Years5> year) {
		this.year = year;
	}
	
	

}
