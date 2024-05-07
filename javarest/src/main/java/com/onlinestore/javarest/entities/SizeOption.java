package com.onlinestore.javarest.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class SizeOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sizeId;

    private String sizeName;

    private Integer sortOrder;

    @ManyToOne
    @JoinColumn(name = "size_category_id")
    private SizeCategory sizeCategory;

	public Integer getSizeId() {
		return sizeId;
	}

	public void setSizeId(Integer sizeId) {
		this.sizeId = sizeId;
	}

	public String getSizeName() {
		return sizeName;
	}

	public void setSizeName(String sizeName) {
		this.sizeName = sizeName;
	}

	public Integer getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}

	public SizeCategory getSizeCategory() {
		return sizeCategory;
	}

	public void setSizeCategory(SizeCategory sizeCategory) {
		this.sizeCategory = sizeCategory;
	}

}