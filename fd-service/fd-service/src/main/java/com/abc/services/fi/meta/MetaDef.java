package com.abc.services.fi.meta;

import java.util.HashMap;
import java.util.Map;

public class MetaDef {
	
	public long getFiID() {
		return fiID;
	}

	public void setFiID(long fiID) {
		this.fiID = fiID;
	}

	public Type getObjectType() {
		return objectType;
	}

	public void setObjectType(Type objectType) {
		this.objectType = objectType;
	}

	public Map<String, String> getFields() {
		return fields;
	}

	public void setFields(Map<String, String> fields) {
		this.fields = fields;
	}

	private long fiID;
	private Type objectType;
	private Map<String,String> fields;
	
	public MetaDef() {
		
	}
	
	public MetaDef(long fiID) {
		this.fiID  = fiID;
		fields = new HashMap<>();
	}
	
	public String addField(String customField , String field) {
		return fields.put(customField, field);	
	}
	
	public enum Type {
		Account("account"),
		Transaction("transaction");
		String name;
		Type(String name) {
			this.name = name;
		}
 	}
}
