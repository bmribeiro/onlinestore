package com.onlinestore.javarest.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductImage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "image_id")
	private Integer imageId;

	@ManyToOne
	@JoinColumn(name = "product_item_id", nullable = false)
	private ProductItem productItem;

	@Column(name = "image_filename", length = 400)
	private String imageFilename;

	@Transient
	private String imageBytes;

	// Getters and Setters

	public Integer getImageId() {
		return imageId;
	}

	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}

	public ProductItem getProductItem() {
		return productItem;
	}

	public void setProductItem(ProductItem productItem) {
		this.productItem = productItem;
	}

	public String getImageFilename() {
		return imageFilename;
	}

	public void setImageFilename(String imageFilename) {
		this.imageFilename = imageFilename;
	}

	public String getImageBytes() {
		return imageBytes;
	}

	public void setImageBytes(String imageBytes) {
		this.imageBytes = imageBytes;
	}

}
