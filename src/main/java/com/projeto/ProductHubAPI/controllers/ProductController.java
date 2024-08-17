package com.projeto.ProductHubAPI.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.ProductHubAPI.dto.RequestProductDTO;
import com.projeto.ProductHubAPI.entities.Product;
import com.projeto.ProductHubAPI.repositorys.ProductRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	@GetMapping("/")
	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> allProducts = productRepository.findAllByActiveTrue();
		return ResponseEntity.ok(allProducts);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> getProduById(@PathVariable String id) {
		Product allProducts = productRepository.findFirstByActiveTrueAndId(id);
		return ResponseEntity.ok(allProducts);
	}

	@PostMapping("/")
	public ResponseEntity saveProduct(@RequestBody @Validated RequestProductDTO product) {

		Product salveProduct = productRepository.save(new Product(product));
		return ResponseEntity.ok(salveProduct);

	}

	@PutMapping("/")
	@Transactional
	public ResponseEntity updateProduct(@RequestBody @Validated RequestProductDTO product) {

		Optional<Product> productOptional = productRepository.findById(product.getId());

		if (productOptional.isPresent()) {

			Product productUpdate = productOptional.get();
			productUpdate.setName(product.getName());
			productUpdate.setPrice(product.getPrice());
			return ResponseEntity.ok(productUpdate);

		} else {

			throw new EntityNotFoundException();

		}

	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity deleteProduct(@PathVariable String id) {
		Optional<Product> productOptional = productRepository.findById(id);

		if (productOptional.isPresent()) {

			Product productDelete = productOptional.get();
			productDelete.setActive(false);
			return ResponseEntity.ok(productDelete);

		} else {

			throw new EntityNotFoundException();
		}
	}

}
