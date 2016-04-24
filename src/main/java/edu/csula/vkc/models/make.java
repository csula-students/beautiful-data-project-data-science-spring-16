package edu.csula.vkc.models;

import java.util.ArrayList;
import java.util.List;

public class make {
int make_id;
String make;
List<model> modelList= new ArrayList<>();
public make(){
	super();
}
public make(int make_id, String make, List<model> modelList) {
	super();
	this.make_id = make_id;
	this.make = make;
	this.modelList = modelList;
}
public int getMake_id() {
	return make_id;
}
public void setMake_id(int make_id) {
	this.make_id = make_id;
}
public String getMake() {
	return make;
}
public void setMake(String make) {
	this.make = make;
}
public List<model> getModelList() {
	return modelList;
}
public void setModelList(List<model> modelList) {
	this.modelList = modelList;
}



}
