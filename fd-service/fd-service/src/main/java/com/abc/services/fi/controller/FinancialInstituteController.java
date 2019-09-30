package com.abc.services.fi.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abc.services.fi.model.EndPoint;
import com.abc.services.fi.model.EndPoints;
import com.abc.services.fi.model.FinancialInstitute;
import com.abc.services.fi.repository.EndpointRepository;
import com.abc.services.fi.repository.FinancialInstituteRepository;

@RestController
public class FinancialInstituteController {

	private static final Logger LOGGER = LoggerFactory.getLogger(FinancialInstituteController.class);
	
	@Autowired
	EndpointRepository endPointRepositrory;
	
	@Autowired
	FinancialInstituteRepository fiRepositroy;
	
	@PostMapping("/fi")
	public FinancialInstitute add(@RequestBody FinancialInstitute fi) {
		LOGGER.info("Fi add: {}", fi);
		return fiRepositroy.add(fi);
	}
	
	@PatchMapping("/fi/{id}")
	public FinancialInstitute update(@PathVariable("id") Long fiID , @RequestBody FinancialInstitute fi) {
		LOGGER.info("FI updated {}" , fi);
		return fiRepositroy.update(fiID , fi);
	}
	
	@GetMapping("/fi") 
	public List<FinancialInstitute> get() {
		LOGGER.info("Fi get:");
		return fiRepositroy.findAll();
	}

	@GetMapping("/fi/{id}")
	public FinancialInstitute findById(@PathVariable("id") Long id) {
		LOGGER.info("Fi find: id={}", id);
		return fiRepositroy.findById(id);
	}
	
	@PostMapping("/fi/{id}/endpoints")
	public EndPoints addEndPoints(@PathVariable("id")Long fiID ,@RequestBody EndPoints endPoints) {
		FinancialInstitute fi = findById(fiID);
		
		if (fi == null) {
			return null;
		}
		return endPointRepositrory.addEndPoints(endPoints.getFiID(), endPoints.getName(), endPoints.getDesc());
	}
	
	@GetMapping("/fi/{fiID}/endpoints")
	public EndPoints getEndPoints(@PathVariable("fiID") Long fiID) {
		FinancialInstitute fi = findById(fiID);
	
		if (fi == null) {
			return null;
		}
		return endPointRepositrory.findEndpointsByFiID(fiID);
	}
	
	
	
	@PostMapping("/fi/{fiID}/endpoints/{operation}")
	public EndPoint addEndPoint(@PathVariable("fiID") Long fiID , @PathVariable String operation,
			@RequestBody EndPoint endPoint) {
		
	    FinancialInstitute fi = findById(fiID);
		if (fi == null) {
			return null;
		}
		
		EndPoints  endPoints = getEndPoints(fiID);
		if (endPoints == null) {
			return null;
		}
		
		if (endPoints.getEndpoints() == null) {
			List<EndPoint> ep = new ArrayList<>();
			endPoints.setEndpoints(ep);
		}
		endPoints.getEndpoints().add(endPoint);
		
		return endPoint;
		
	}
	
}
