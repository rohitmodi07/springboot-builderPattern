package com.techmaze.techmaze.connector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.techmaze.techmaze.model.BuilderPatternVO;
import com.techmaze.techmaze.model.BuilderPatternVOWOBuilder;

@Component
public class BuilderPatternConnector {

	private RestTemplate restTemplate = new RestTemplate();
	private String nationalityUrl;
	
	@Autowired
	public BuilderPatternConnector(String nationalityUrl) {
		this.nationalityUrl = nationalityUrl;
	}
	
	public BuilderPatternVO getCountryNameBasedOnPersonName(String personName) throws Exception {
		
		try {
			
		    String countryFinderUrl = UriComponentsBuilder.fromHttpUrl(nationalityUrl)
		    		.queryParam("name", personName).build().toString();
            System.out.println(" countryFinderUrl is  ::::: "+countryFinderUrl);
            
            BuilderPatternVO builderPatternVO =  restTemplate.getForObject(countryFinderUrl, BuilderPatternVO.class);
            
            System.out.println("The builderPatternVO is :::: "+builderPatternVO);
			
			return builderPatternVO;
			
		} catch (RestClientException e) {
			throw new RestClientException("Exception occurred while fetching nationality "+ e.getMessage());
		}
	}
	
    public BuilderPatternVOWOBuilder getCountryNameBasedOnPersonNameWOBuilder(String personName) throws Exception {
		
		try {
			
		    String countryFinderUrl = UriComponentsBuilder.fromHttpUrl(nationalityUrl)
		    		.queryParam("name", personName).build().toString();
            System.out.println(" countryFinderUrl is  ::::: "+countryFinderUrl);
            
            BuilderPatternVOWOBuilder builderPatternVO =  restTemplate.getForObject(countryFinderUrl, BuilderPatternVOWOBuilder.class);
            
            System.out.println("The BuilderPatternVOWOBuilder is :::: "+builderPatternVO);
			
			return builderPatternVO;
			
		} catch (RestClientException e) {
			throw new RestClientException("Exception occurred while fetching nationality "+ e.getMessage());
		}
	 }
	
}
