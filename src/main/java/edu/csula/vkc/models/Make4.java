package edu.csula.vkc.models;

import java.util.List;

public class Make4 {
	private long id;
	private long make_id;
	private String make;
	private String source;
	private List<Model3> modelList;
	
	public Make4() {
		super();
	}

	public Make4(long id, long make_id, String make, String source, List<Model3> modelList) {
		super();
		this.id = id;
		this.make_id = make_id;
		this.make = make;
		this.source = source;
		this.modelList = modelList;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getMake_id() {
		return make_id;
	}

	public void setMake_id(long make_id) {
		this.make_id = make_id;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public List<Model3> getModelList() {
		return modelList;
	}

	public void setModelList(List<Model3> modelList) {
		this.modelList = modelList;
	}

	
	
	
	
	
	
}
