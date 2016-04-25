package edu.csula.vkc.models;

import java.util.List;

public class Years6 {
	private long year_id;
	private String year;
	private List<Styles6> styles;

	public Years6() {
		super();
	}

	public Years6(long year_id, String year, List<Styles6> styles) {
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

	public List<Styles6> getStyles() {
		return styles;
	}

	public void setStyles(List<Styles6> styles) {
		this.styles = styles;
	}

}
