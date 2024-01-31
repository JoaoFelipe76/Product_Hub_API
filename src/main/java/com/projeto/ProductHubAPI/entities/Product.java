package com.projeto.ProductHubAPI.entities;

import com.projeto.ProductHubAPI.dto.RequestProductDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "product")
@Entity(name = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "price_in_cents")
	private Integer price_in_cents;

	@Column(name = "active")
	private Boolean active;

	public Product(RequestProductDTO requestProductDTO) {
		this.name = requestProductDTO.getName();
		this.price_in_cents = requestProductDTO.getPrice_in_cents();
		this.active = true;
	}

}
