package edu.csula.vkc.models;

import java.util.ArrayList;
import java.util.List;

public class trim {
int trim_id;
String trim;

public trim(){
	super();
}

public trim(int trim_id, String trim) {
	super();
	this.trim_id = trim_id;
	this.trim = trim;
}

public int getTrim_id() {
	return trim_id;
}

public void setTrim_id(int trim_id) {
	this.trim_id = trim_id;
}

public String getTrim() {
	return trim;
}

public void setTrim(String trim) {
	this.trim = trim;
}




}