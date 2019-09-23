package com.abc.services.fi.model;

import java.util.List;

public class ServiceDef {
	
	public ServiceDef(String url, String method, List<Integer> errors, String contentType, String acceptContent) {
		super();
		this.url = url;
		this.method = method;
		this.errors = errors;
		this.contentType = contentType;
		this.acceptContent = acceptContent;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public List<Integer> getErrors() {
		return errors;
	}
	public void setErrors(List<Integer> errors) {
		this.errors = errors;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public String getAcceptContent() {
		return acceptContent;
	}
	public void setAcceptContent(String acceptContent) {
		this.acceptContent = acceptContent;
	}
	private String url;
	private String method;
	private List<Integer> errors;
	private String contentType;
	private String acceptContent;

}
