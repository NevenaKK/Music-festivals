package com.jwd.test.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwd.test.model.Festival;
import com.jwd.test.service.FestivalService;
import com.jwd.test.support.FestivalToFestivalDto;
import com.jwd.test.web.dto.FestivalDTO;


@RestController
@RequestMapping(value = "/api/festivali", produces = MediaType.APPLICATION_JSON_VALUE)
public class FetsivalController {
	
	@Autowired
	FestivalService festivalService;
	
	@Autowired
	FestivalToFestivalDto toFestivalDto;

	@PreAuthorize("permitAll()")
	 @GetMapping
	    public ResponseEntity<List<FestivalDTO>> getAll(){
	    		
		 List<Festival> festivali=festivalService.findAll();

	     
	     return new ResponseEntity<>(toFestivalDto.convert(festivali),HttpStatus.OK);
	    	
	            
	    }
}
