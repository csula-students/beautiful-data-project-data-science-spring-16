package edu.csula.vkc.models;


import java.util.List;

public class Years {
	int year_id;
	Years year;
	List<Trim> trimList;
	
	
	public Years(int year_id, Years year, List<Trim> trimList) {
		super();
		this.year_id = year_id;
		this.year = year;
		this.trimList = trimList;
	}


	public int getYear_id() {
		return year_id;
	}


	public void setYear_id(int year_id) {
		this.year_id = year_id;
	}


	public Years getYear() {
		return year;
	}


	public void setYear(Years year) {
		this.year = year;
	}


	public List<Trim> getTrimList() {
		return trimList;
	}


	public void setTrimList(List<Trim> trimList) {
		this.trimList = trimList;
	}
	
	
	
	
	
}
