package com.demo.rest;

public class Zoo {

	private int zooId;
	private String zooName;
	private String zooLocation;
	
	//create a default constructor
	public Zoo() {
		
	}
	public int getZooId() {
		return zooId;
	}
	public void setZooId(int zooId) {
		this.zooId = zooId;
	}
	public void setZooName(String zooName) {
		this.zooName = zooName;
	}
	public void setZooLocation(String zooLocation) {
		this.zooLocation = zooLocation;
	}
	public String getZooName() {
		return zooName;
	}
	public String getZooLocation() {
		return zooLocation;
	}

	// this method is used to fetch the value from the database
	@Override
	public String toString() {
		return "Zoo [zooId=" + zooId + ", zooName=" + zooName + ", zooLocation=" + zooLocation + "]";
	}
	
	

}
