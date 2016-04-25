package edu.csula.vkc.models;

import java.util.List;

public class Years7 {
	private long year_id;
	private String year;
	private List<Styles7> styles;

	public Years7() {
		super();
	}

	public Years7(long year_id, String year, List<Styles7> styles) {
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

	public List<Styles7> getStyles() {
		return styles;
	}

	public void setStyles(List<Styles7> styles) {
		this.styles = styles;
	}

}
