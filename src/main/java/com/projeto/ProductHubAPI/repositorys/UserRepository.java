package com.projeto.ProductHubAPI.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.projeto.ProductHubAPI.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	UserDetails findUserByLogin(String login);
	

}
