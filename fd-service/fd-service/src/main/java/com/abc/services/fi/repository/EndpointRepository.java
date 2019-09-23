package com.abc.services.fi.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.abc.services.fi.model.EndPoint;
import com.abc.services.fi.model.EndPoints;

public class EndpointRepository {

	private  List<EndPoints> endPoints = new ArrayList<>();
	
	public EndPoint addEndPoint(int fiId , EndPoint endPoint ) {
		
		Optional<EndPoints> fiEndpoints = endPoints.stream().filter(a -> a.getFiID()==fiId).findFirst();
		if (fiEndpoints.isPresent()) {
			 fiEndpoints.get().getEndpoints().add( endPoint);
		     return endPoint;
		}	
		else
			return null;
	}
	
	public EndPoints addEndPoints(long fiId, String name , String desc) {
		
		EndPoints fiEndPoints  = new EndPoints();
		fiEndPoints.setId(endPoints.size() + 1);
		fiEndPoints.setFiID(fiId);
		fiEndPoints.setName(name);
		fiEndPoints.setDesc(desc);
		endPoints.add(fiEndPoints);
		return fiEndPoints;
	}
	
	public EndPoints findEndpointsByFiID(long fiId) {
		Optional<EndPoints> fiEndpoints = endPoints.stream().filter(a -> a.getFiID() == fiId).findFirst();
		if (fiEndpoints.isPresent())
			return fiEndpoints.get();
		else
			return null;
	}
	
	public List<EndPoints> findAll() {
		return endPoints;
	}
	
}
