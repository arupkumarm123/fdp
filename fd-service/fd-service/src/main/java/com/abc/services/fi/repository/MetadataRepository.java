package com.abc.services.fi.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.abc.services.fi.meta.MetaDef;

public class MetadataRepository {
	
private  Map<Long,List<MetaDef>> fiMetaDefs = new HashMap<>();
	
	public MetaDef addMeta(long fiID , MetaDef metaDef ) {
		
		List<MetaDef> metaDefForFI =fiMetaDefs.get(fiID);
		
		if (metaDefForFI == null ) {
			metaDefForFI  = new ArrayList<>();
		}
		
		metaDefForFI.add(metaDef);
		fiMetaDefs.put(fiID, metaDefForFI);
		return metaDef;
	}
	
	public List<MetaDef> metaDefs(long fiID) {
		return fiMetaDefs.get(fiID);
	}

}
