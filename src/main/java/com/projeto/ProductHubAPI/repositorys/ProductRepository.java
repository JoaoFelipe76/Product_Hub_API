package com.projeto.ProductHubAPI.repositorys;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.ProductHubAPI.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String>{
	
	List<Product> findAllByActiveTrue();
	
	Product findFirstByActiveTrueAndId(String id);
	
	Optional<Product> findById(String id);

}
