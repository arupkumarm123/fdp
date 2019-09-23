package com.abc.services.fi.model;

public class FinancialInstitute {

	private Long id;
	private String name;
	private String address;
	private IntegrationType intMethod;
	private AuthType authType;
	
	public FinancialInstitute(String name, String address, IntegrationType intMethod, AuthType authType) {
		super();
		this.name = name;
		this.address = address;
		this.intMethod = intMethod;
		this.authType = authType;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public IntegrationType getIntMethod() {
		return intMethod;
	}
	public void setIntMethod(IntegrationType intMethod) {
		this.intMethod = intMethod;
	}
	public AuthType getAuthType() {
		return authType;
	}
	public void setAuthType(AuthType authType) {
		this.authType = authType;
	}

}
