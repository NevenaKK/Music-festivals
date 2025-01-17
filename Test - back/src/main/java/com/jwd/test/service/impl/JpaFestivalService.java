package com.jwd.test.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwd.test.model.Festival;

import com.jwd.test.repository.FestivalRepository;
import com.jwd.test.service.FestivalService;

@Service
public class JpaFestivalService implements FestivalService{

	@Autowired
	FestivalRepository festivalRepository;
	
	@Override
	public List<Festival> findAll() {
		return festivalRepository.findAll();
		
	}

	@Override
	public Festival findOne(Long id) {
		
		Optional<Festival> festival=festivalRepository.findById(id);
		
		if(festival.isPresent())
			return festival.get();
		return null;
	}

	

}
