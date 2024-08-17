package com.projeto.ProductHubAPI.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class RequestProductDTO {
	
	private String id;
	
	@NonNull
	private String name;
	
	@NonNull
	private Integer price;
	

}
