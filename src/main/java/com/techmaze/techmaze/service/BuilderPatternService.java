package com.techmaze.techmaze.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techmaze.techmaze.connector.BuilderPatternConnector;
import com.techmaze.techmaze.model.BuilderPatternVO;
import com.techmaze.techmaze.model.BuilderPatternVOWOBuilder;
import com.techmaze.techmaze.model.Country;

@Service
public class BuilderPatternService {
	
	private String COUNTRY_ORIGIN = "Others";
	private BuilderPatternConnector builderPatternConnector;
	
	@Autowired
	public BuilderPatternService(BuilderPatternConnector builderPatternConnector) {
		this.builderPatternConnector = builderPatternConnector;
	}
	
	public BuilderPatternVO getCountryNameBasedOnPersonName(String personName) throws Exception {
		BuilderPatternVO builderPatternVO =  builderPatternConnector.getCountryNameBasedOnPersonName(personName);
		
		for (Country country : builderPatternVO.getCountry()) {
			if("IN".equalsIgnoreCase(country.getCountry_id()) ) {
				COUNTRY_ORIGIN = "INDIA";
				break;
			}else if("US".equalsIgnoreCase(country.getCountry_id())) {
				COUNTRY_ORIGIN = "Unites States of America";
				break;
			}
			
		}
		
		/*
		 here we have used toBuilder initialized in model class and used here, the benefit of using this is, it keeps the values of
		 other parameters and update only those attributes which we update.
		 In the following code, we have set the value of countryOrigin in builderPatternVO object, what it internally does, it keeps 
		 other parameters values as it is and update or set the value of countryOrigin
		 This approach saves space, memory, time and provide clean code (when we have less attribute, setting attributes again is fine 
		 but if we have 10 or more attributes then this approach will really comes with boon)
		 */
		
		builderPatternVO = builderPatternVO.toBuilder()
				           .countryOrigin(COUNTRY_ORIGIN)
				           .build();
		
		System.out.println(" builder model ::::::: "+builderPatternVO);
		
		return builderPatternVO;
	}
	
	public BuilderPatternVOWOBuilder getCountryNameBasedOnPersonNameWOBuilder(String personName) throws Exception {
		BuilderPatternVOWOBuilder builderPatternVO =  builderPatternConnector.getCountryNameBasedOnPersonNameWOBuilder(personName);
		
		for (Country country : builderPatternVO.getCountry()) {
			if("IN".equalsIgnoreCase(country.getCountry_id()) ) {
				COUNTRY_ORIGIN = "INDIA";
				break;
			}else if("US".equalsIgnoreCase(country.getCountry_id())) {
				COUNTRY_ORIGIN = "Unites States of America";
				break;
			}
			
		}
		/*
		  When we write either of following code it will set only countryOrigin, rest of the parameters will set to null even  
		  other parameters of builderPatternVO object has values
		  
		  builderPatternVO = builderPatternVO.builder()
				           .countryOrigin(COUNTRY_ORIGIN)
				           .build();
				           
	      builderPatternVO = BuilderPatternVOWOBuilder.builder()
				           .countryOrigin(COUNTRY_ORIGIN)
				           .build();			           
				           
		  To overcome from this we have to set other parameters once again as below, which is perfectly fine in case of less 
		  attribute, but if we have more than 10 attributes, this task will be tedious, time consuming, repetitive and consume 
		  more space		           
		  
		 */
		
		
		builderPatternVO =  BuilderPatternVOWOBuilder.builder()
				           .countryOrigin(COUNTRY_ORIGIN)
				           .country(builderPatternVO.getCountry())
				           .name(builderPatternVO.getName())
				           .build();
		
		/*
		 * One more approach we can take but that also will not solve our problem
		 */
		
		System.out.println(" builder WO model ::::::: "+builderPatternVO);
		
		return builderPatternVO;
	}

}
