package com.projeto.ProductHubAPI.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class RequestProductDTO {
	
	private Long id;
	
	@NonNull
	private String name;
	
	@NonNull
	private Integer price_in_cents;
	

}
