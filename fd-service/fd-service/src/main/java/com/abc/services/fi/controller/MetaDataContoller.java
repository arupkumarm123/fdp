package com.abc.services.fi.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abc.services.fi.meta.MetaDef;
import com.abc.services.fi.repository.MetadataRepository;

@RestController
public class MetaDataContoller {

	private static final Logger LOGGER = LoggerFactory.getLogger(MetaDataContoller.class);
	
	@Autowired
	MetadataRepository metadataRepository;
	
	
	@PostMapping("/fi/{fiID}/metadata")
	public MetaDef add(@PathVariable("fiID") Long fiID, @RequestBody MetaDef meta) {
		LOGGER.info("MetaData add: {}", meta);
		return metadataRepository.addMeta(fiID, meta);
	}
	
	@GetMapping("/fi/{fiID}/metadata") 
	public List<MetaDef> get(@PathVariable("fiID") Long fiID) {
		LOGGER.info("Fi get: {}" , fiID);
		return metadataRepository.metaDefs(fiID);
	}
	
}
