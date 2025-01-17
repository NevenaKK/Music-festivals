package com.jwd.test.service;

import org.springframework.data.domain.Page;

import com.jwd.test.model.Izvodjac;
import com.jwd.test.model.Nastup;

public interface NastupService {

	Nastup findOne(Long id);
	Nastup save(Nastup nastup);
	Nastup update(Nastup nastup);
	Nastup delete(Long id);
	
	Page<Nastup> search(Long izvodjacId,Long festivalId,int pageNo);
	
	Izvodjac provera (String drzava,Long festivalId);
	
	
	
	
}
