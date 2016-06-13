package edu.csula.vkc.second.models;

import java.util.List;

public class Years {
	private long year_id;
	private String year;
	private List<Styles> styles;
	
	public Years(){
		super();
	}

	public Years(long year_id, String year, List<Styles> styles) {
		super();
		this.year_id = year_id;
		this.year = year;
		this.styles = styles;
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

	public List<Styles> getStyles() {
		return styles;
	}

	public void setStyles(List<Styles> styles) {
		this.styles = styles;
	}

}
