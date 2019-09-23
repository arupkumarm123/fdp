package com.abc.services.fi.model;

public class EndPoint {
	
	EndPointType endPointType;
	IntegrationType type;
	ServiceDef serviceDef;
	
	public EndPoint(EndPointType endPointType , IntegrationType type, ServiceDef serviceDef) {
		super();
		this.type = type;
		this.serviceDef = serviceDef;
		this.endPointType = endPointType;
	}
	public EndPointType getEndPointType() {
		return endPointType;
	}
	public void setEndPointType(EndPointType endPointType) {
		this.endPointType = endPointType;
	}
	public IntegrationType getType() {
		return type;
	}
	public void setType(IntegrationType type) {
		this.type = type;
	}
	public ServiceDef getServiceDef() {
		return serviceDef;
	}
	public void setServiceDef(ServiceDef serviceDef) {
		this.serviceDef = serviceDef;
	}

}
