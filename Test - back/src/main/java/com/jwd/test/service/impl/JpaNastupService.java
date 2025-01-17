package com.jwd.test.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.jwd.test.model.Festival;
import com.jwd.test.model.Izvodjac;
import com.jwd.test.model.Nastup;
import com.jwd.test.repository.FestivalRepository;
import com.jwd.test.repository.IzvodjacRepository;
import com.jwd.test.repository.NastupRepository;
import com.jwd.test.service.IzvodjacService;
import com.jwd.test.service.NastupService;

import net.bytebuddy.asm.Advice.Return;

@Service
public class JpaNastupService implements NastupService{

	@Autowired
	NastupRepository nastupRepository;
	
	@Autowired
	FestivalRepository festivalRepository;

	
	@Override
	public Nastup findOne(Long id) {
		Optional<Nastup> nastup=nastupRepository.findById(id);
		
		if(nastup.isPresent())
			return nastup.get();
		return null;
	}

	@Override
	public Nastup save(Nastup nastup) {
		
		
		Izvodjac i = provera(nastup.getIzvodjac().getDrzavaPorekla(), nastup.getFestival().getId());
		
		if(i!=null)
			return nastupRepository.save(nastup);
		else
			 throw new IllegalStateException("Na istom festivalu ne mogu nastupati dva izvodjaca iz iste drzave !"); 
	}

	@Override
	public Nastup update(Nastup nastup) {
		return nastupRepository.save(nastup);
	}

	@Override
	public Nastup delete(Long id) {
		Optional<Nastup> nastup=nastupRepository.findById(id);
		if(nastup.isPresent()) {
			nastupRepository.deleteById(id); 
			return nastup.get();
		}
		return null;
	}


	@Override
	public Page<Nastup> search(Long izvodjacId, Long festivalId, int pageNo) {
		return nastupRepository.search(izvodjacId, festivalId, PageRequest.of(pageNo, 4));
	}

	@Override
	public Izvodjac provera(String drzava, Long festivalId) {
		
		List<Nastup> nastupi=nastupRepository.findAll();
		
		for(Nastup n:nastupi) {
			if(n.getFestival().getId()==festivalId && n.getIzvodjac().getDrzavaPorekla().equals(drzava))
				return null;
		}
		
		return new Izvodjac();
	}
	
	

	
	
	
	
	
	
	

	
	
	

	
	

	

	

}
