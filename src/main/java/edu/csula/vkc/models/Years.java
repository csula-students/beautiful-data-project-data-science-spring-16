package edu.csula.vkc.models;

import java.time.Year;
import java.util.List;

public class Years {
	long year_id;
	String year;
	List<Trim> trimList;
	
	public Years(){
		super();
	}

	public Years(long year_id, String year, List<Trim> trimList) {
		super();
		this.year_id = year_id;
		this.year = year;
		this.trimList = trimList;
	}

	public long getYear_id() {
		return year_id;
	}

	public void setYear_id(long year_id) {
		this.year_id = year_id;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public List<Trim> getTrimList() {
		return trimList;
	}

	public void setTrimList(List<Trim> trimList) {
		this.trimList = trimList;
	}

}
