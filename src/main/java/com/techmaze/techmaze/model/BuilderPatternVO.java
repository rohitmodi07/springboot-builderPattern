package com.techmaze.techmaze.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class BuilderPatternVO {
	
	private String name;
	private List<Country> country;
	private String countryOrigin;

}