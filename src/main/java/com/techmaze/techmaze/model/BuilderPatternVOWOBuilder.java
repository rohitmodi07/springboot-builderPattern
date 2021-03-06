package com.techmaze.techmaze.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BuilderPatternVOWOBuilder {
	
	private String name;
	private List<Country> country;
	private String countryOrigin;

}