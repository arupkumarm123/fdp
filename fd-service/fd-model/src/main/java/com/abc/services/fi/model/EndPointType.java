package com.abc.services.fi.model;

public enum EndPointType {
	
	LINK("link" , "User Account Linking"),
	UNLINK("link" , "User Account Unlinked"),
	TRANSACTION("transaction" , "Transaction Record"),
	STATEMENT("bank_statement", "Bank Statement"),
	TAX_STATEMENT("tax_statement", "Income tax statement");
	

	
	String description;
	String name;
	
	private EndPointType(String name , String description) {
		this.description = description;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	
}
