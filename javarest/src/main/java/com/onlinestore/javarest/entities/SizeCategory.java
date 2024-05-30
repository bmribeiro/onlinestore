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
	@Column(name = "size_category_id")
	private Integer sizeCategoryId;

	@Column(name = "size_category_name")
	private String sizeCategoryName;

	public SizeCategory() {
	}

	public SizeCategory(String categoryName) {
		this.sizeCategoryName = categoryName;
	}

	public Integer getSizeCategoryId() {
		return sizeCategoryId;
	}

	public void setSizeCategoryId(Integer sizeCategoryId) {
		this.sizeCategoryId = sizeCategoryId;
	}

	public String getSizeCategoryName() {
		return sizeCategoryName;
	}

	public void setSizeCategoryName(String sizeCategoryName) {
		this.sizeCategoryName = sizeCategoryName;
	}

	@Override
	public String toString() {
		return "SizeCategory [sizeCategoryId=" + sizeCategoryId + ", sizeCategoryName=" + sizeCategoryName + "]";
	}
}
