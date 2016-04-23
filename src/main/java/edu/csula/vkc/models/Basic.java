package edu.csula.vkc.models;

public class Basic {
	int vehicle_id;
	String make_name;
	String make_nickname;
	String model_name;
	String model_nickname;
	int year;
	int style_id;
	String style_name;
	String submodel_body;
	String submodel_modelname;
	String style_trim;
	long true_market_value;
	
	public Basic(){
		super();
	}
	
	public Basic(int vehicle_id, String make_name, String make_nickname, String model_name, String model_nickname,
			int year, int style_id, String style_name, String submodel_body, String submodel_modelname,
			String style_trim, long true_market_value) {
		super();
		this.vehicle_id = vehicle_id;
		this.make_name = make_name;
		this.make_nickname = make_nickname;
		this.model_name = model_name;
		this.model_nickname = model_nickname;
		this.year = year;
		this.style_id = style_id;
		this.style_name = style_name;
		this.submodel_body = submodel_body;
		this.submodel_modelname = submodel_modelname;
		this.style_trim = style_trim;
		this.true_market_value = true_market_value;
	}
	
	public int getVehicle_id() {
		return vehicle_id;
	}
	
	public void setVehicle_id(int vehicle_id) {
		this.vehicle_id = vehicle_id;
	}
	
	public String getMake_name() {
		return make_name;
	}
	
	public void setMake_name(String make_name) {
		this.make_name = make_name;
	}
	
	public String getMake_nickname() {
		return make_nickname;
	}
	
	public void setMake_nickname(String make_nickname) {
		this.make_nickname = make_nickname;
	}
	
	public String getModel_name() {
		return model_name;
	}
	
	public void setModel_name(String model_name) {
		this.model_name = model_name;
	}
	
	public String getModel_nickname() {
		return model_nickname;
	}
	
	public void setModel_nickname(String model_nickname) {
		this.model_nickname = model_nickname;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public int getStyle_id() {
		return style_id;
	}
	
	public void setStyle_id(int style_id) {
		this.style_id = style_id;
	}
	
	public String getStyle_name() {
		return style_name;
	}
	
	public void setStyle_name(String style_name) {
		this.style_name = style_name;
	}
	
	public String getSubmodel_body() {
		return submodel_body;
	}
	
	public void setSubmodel_body(String submodel_body) {
		this.submodel_body = submodel_body;
	}
	
	public String getSubmodel_modelname() {
		return submodel_modelname;
	}
	
	public void setSubmodel_modelname(String submodel_modelname) {
		this.submodel_modelname = submodel_modelname;
	}
	
	public String getStyle_trim() {
		return style_trim;
	}
	
	public void setStyle_trim(String style_trim) {
		this.style_trim = style_trim;
	}
	
	public long getTrue_market_value() {
		return true_market_value;
	}
	
	public void setTrue_market_value(long true_market_value) {
		this.true_market_value = true_market_value;
	}

}
