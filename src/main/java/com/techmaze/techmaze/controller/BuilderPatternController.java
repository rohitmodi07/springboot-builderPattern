package com.techmaze.techmaze.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techmaze.techmaze.model.BuilderPatternVO;
import com.techmaze.techmaze.model.BuilderPatternVOWOBuilder;
import com.techmaze.techmaze.service.BuilderPatternService;

@RestController
public class BuilderPatternController {
	
	@Autowired
	private BuilderPatternService builderPatternService;
	
	@GetMapping(value = "/nationality")
	public BuilderPatternVO getCountryNameBasedOnPersonName(@RequestParam("name") String personName) throws Exception {
		if(StringUtils.isEmpty(personName)) {
			return null;
		}
		try {
		
			return builderPatternService.getCountryNameBasedOnPersonName(personName);
			
		} catch (Exception e) {
			throw new Exception(" Exception occurred while fetching country name ");
		}
		 
	}
	
	@GetMapping(value = "/nationalityWO")
	public BuilderPatternVOWOBuilder getCountryNameBasedOnPersonNameWOBuilder(@RequestParam("name") String personName) throws Exception {
		if(StringUtils.isEmpty(personName)) {
			return null;
		}
		try {
		
			return builderPatternService.getCountryNameBasedOnPersonNameWOBuilder(personName);
			
		} catch (Exception e) {
			throw new Exception(" Exception occurred while fetching country name ");
		}
		 
	}

}
