package com.jwd.test.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.jwd.test.model.Izvodjac;
import com.jwd.test.service.IzvodjacService;
import com.jwd.test.support.IzvodjacDtoToIzvodjac;
import com.jwd.test.support.IzvodjacToIzvodjacDto;

import com.jwd.test.web.dto.IzvodjacDTO;

@RestController
@RequestMapping(value = "/api/izvodjaci", produces = MediaType.APPLICATION_JSON_VALUE)
public class IzvodjacController {

	@Autowired
	IzvodjacService izvodjacService;
	
	@Autowired
	IzvodjacToIzvodjacDto toIzvodjacDto;
	
	@Autowired
	IzvodjacDtoToIzvodjac toIzvodjac;
	
	@PreAuthorize("permitAll()")
	 @GetMapping
	    public ResponseEntity<List<IzvodjacDTO>> getAll(){
	    		
		 List<Izvodjac> festivali=izvodjacService.findAll();

	     
	     return new ResponseEntity<>(toIzvodjacDto.convert(festivali),HttpStatus.OK);
	    	
	            
	    }
	 
    @PreAuthorize("hasRole('ROLE_ADMIN')")
	 @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	  public ResponseEntity<IzvodjacDTO> create (@Valid @RequestBody IzvodjacDTO izvodjacDTO){
		  
		  Izvodjac izvodjac=toIzvodjac.convert(izvodjacDTO);
		  Izvodjac sacuvaniIzvodjac=izvodjacService.save(izvodjac);
		  
		  
		  return new ResponseEntity<>(toIzvodjacDto.convert(sacuvaniIzvodjac),HttpStatus.CREATED);
		  
		  
	  }
}
