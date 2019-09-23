package com.abc.services.fi.gw.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.abc.services.fi.model.EndPoints;
import com.abc.services.fi.model.FinancialInstitute;

@FeignClient(name = "fi-service")
public interface FIClient {
	
	@GetMapping("/fi/{id}")
	public FinancialInstitute findById(@PathVariable("id") Long id);
	
	@GetMapping("/fi/{fiID}/endpoints")
	public EndPoints getEndPoints(@PathVariable("fiID") Long fiID);
}
