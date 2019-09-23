package com.abc.services.fi.gw.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.abc.services.fi.meta.MetaDef;


@FeignClient(name = "fi-service")
public interface MetadataClient {

	@GetMapping("/fi/{fiID}/metadata")
	public List<MetaDef> get(@PathVariable("fiID") Long fiID);

}
