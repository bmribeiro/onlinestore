package com.onlinestore.javarest.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SizeCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer categoryId;

	private String sizeCategoryName;

	public SizeCategory() {
	}

	public SizeCategory(String categoryName) {
		this.sizeCategoryName = categoryName;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getSizeCategoryName() {
		return sizeCategoryName;
	}

	public void setSizeCategoryName(String sizeCategoryName) {
		this.sizeCategoryName = sizeCategoryName;
	}

}
