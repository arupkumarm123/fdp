package com.abc.services.fi.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.abc.services.fi.model.FinancialInstitute;

public class FinancialInstituteRepository {

	private List<FinancialInstitute> fis = new ArrayList<>();
	
	public FinancialInstitute add(FinancialInstitute fi) {
		
		fi.setId((long) (fis.size()+1));
		fis.add(fi);
		return fi;
	}
	
	public FinancialInstitute findById(Long id) {
		Optional<FinancialInstitute> fi = fis.stream().filter(a -> a.getId().equals(id)).findFirst();
		if (fi.isPresent())
			return fi.get();
		else
			return null;
	}
	
	public List<FinancialInstitute> findAll() {
		return fis;
	}
	
}
