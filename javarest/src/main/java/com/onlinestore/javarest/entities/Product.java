package com.onlinestore.javarest.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

    @ManyToOne
    @JoinColumn(name = "product_category_id")
    private ProductCategory productCategory;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    private String productName;

    private String productDescription;

    private String modelHeight;

    private String modelWearing;

    private String careInstructions;

    private String about;

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public ProductCategory getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getModelHeight() {
		return modelHeight;
	}

	public void setModelHeight(String modelHeight) {
		this.modelHeight = modelHeight;
	}

	public String getModelWearing() {
		return modelWearing;
	}

	public void setModelWearing(String modelWearing) {
		this.modelWearing = modelWearing;
	}

	public String getCareInstructions() {
		return careInstructions;
	}

	public void setCareInstructions(String careInstructions) {
		this.careInstructions = careInstructions;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

    
    
    
}