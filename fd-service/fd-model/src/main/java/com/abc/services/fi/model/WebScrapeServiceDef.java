package com.abc.services.fi.model;

import java.util.List;

public class WebScrapeServiceDef extends ServiceDef {
	
	public WebScrapeServiceDef(String url, String method, List<Integer> errors, String contentType,
			String acceptContent,String xPath) {
		super(url, method, errors, contentType, acceptContent);
		this.xPath  = xPath;
	}

	private String xPath;

}
