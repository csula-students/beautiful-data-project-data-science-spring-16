package edu.csula.vkc.models;

import java.time.Year;
import java.util.List;

public class year {
	int year_id;
	Year year;
	List<trim> trimList;
	
	
	public year(int year_id, Year year, List<trim> trimList) {
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


	public Year getYear() {
		return year;
	}


	public void setYear(Year year) {
		this.year = year;
	}


	public List<trim> getTrimList() {
		return trimList;
	}


	public void setTrimList(List<trim> trimList) {
		this.trimList = trimList;
	}
	
	
	
	
	
}
