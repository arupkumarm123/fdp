package com.abc.services.fi.model;

import java.util.List;

public class OFXServiceDef extends ServiceDef {

	public OFXServiceDef(String url, String method, List<Integer> errors, String contentType, String acceptContent) {
		super(url, method, errors, contentType, acceptContent);
	}

}
