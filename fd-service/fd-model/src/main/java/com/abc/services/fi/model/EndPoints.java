package com.abc.services.fi.model;

import java.util.List;

public class EndPoints {
	

	private int id;
	
	private String name ;
	
	private String desc;
	
	private long fiID;
	
	private List<EndPoint> endpoints;
	
	
	public EndPoints() {
		
	}
	
	public EndPoints(int id, String name, String desc, int fiID, List<EndPoint> endpoints) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.fiID = fiID;
		this.endpoints = endpoints;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public long getFiID() {
		return fiID;
	}

	public void setFiID(long fiID) {
		this.fiID = fiID;
	}

	public List<EndPoint> getEndpoints() {
		return endpoints;
	}
	
	public void setEndpoints(List<EndPoint> endpoints) {
		this.endpoints = endpoints;
	}

}
