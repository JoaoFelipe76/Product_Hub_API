package com.projeto.ProductHubAPI.dto;

import com.projeto.ProductHubAPI.enums.UserRole;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterDTO {

	private String login;

	private String password;
	
	private UserRole role;

}
