package com.projeto.ProductHubAPI.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.ProductHubAPI.dto.AutenticationDTO;
import com.projeto.ProductHubAPI.dto.LoginResponseDTO;
import com.projeto.ProductHubAPI.dto.RegisterDTO;
import com.projeto.ProductHubAPI.entities.User;
import com.projeto.ProductHubAPI.repositorys.UserRepository;
import com.projeto.ProductHubAPI.services.TokenService;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private TokenService tokenService;

	@PostMapping("/login")
	public ResponseEntity login(@RequestBody @Validated AutenticationDTO data) {

		var usernamePassword = new UsernamePasswordAuthenticationToken(data.getLogin(), data.getPassword());
		var auth = this.authenticationManager.authenticate(usernamePassword);

		var token = tokenService.generateToken((User) auth.getPrincipal());

		return ResponseEntity.ok(new LoginResponseDTO(token));

	}

	@PostMapping("/register")
	public ResponseEntity register(@RequestBody @Validated RegisterDTO data) {
		if (this.userRepository.findUserByLogin(data.getLogin()) != null)
			return ResponseEntity.badRequest().build();

		String encryptedPassword = new BCryptPasswordEncoder().encode(data.getPassword());
		User newUser = new User(data.getLogin(), encryptedPassword, data.getRole());

		this.userRepository.save(newUser);

		return ResponseEntity.ok().build();
	}

}
