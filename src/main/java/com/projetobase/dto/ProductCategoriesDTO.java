package com.projetobase.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Length;

import com.projetobase.entities.Product;

public class ProductCategoriesDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotEmpty(message = "can't be empty")
	@Length(min = 3, max = 80, message = "length must be betwen 3 and 80")
	private String name;
	
	@NotEmpty(message = "can't be empty")
	@Length(min = 8, message = "length must be betwen 5 and 80")
	private String description;
	
	@Positive
	private double price;
	private String imgUrl;
	
	private List<CategoryDTO> categories = new ArrayList<>();
	
	public ProductCategoriesDTO() {
		// TODO Auto-generated constructor stub
	}

	public ProductCategoriesDTO(String name, String description, double price, String imgUrl,
			List<CategoryDTO> categories) {
		
		this.name = name;
		this.description = description;
		this.price = price;
		this.imgUrl = imgUrl;
		this.categories = categories;
	}
	
	public ProductCategoriesDTO(Product entity) {
		
		this.name = entity.getName();
		this.description = entity.getDescription();
		this.price = entity.getPrice();
		this.imgUrl = entity.getImgUrl();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public List<CategoryDTO> getCategories() {
		return categories;
	}
	
	public Product toEntity() {
		return new Product(null, name, description, price, imgUrl);
	}
}
