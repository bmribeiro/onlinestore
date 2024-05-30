package com.onlinestore.javarest.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class ProductCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_category_id")
	private Integer productCategoryId;

	@Column(name = "category_name")
	private String categoryName;

	@Column(name = "category_description")
	private String categoryDescription;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "size_category_id")
	private SizeCategory sizeCategory;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "parent_product_category_id")
	private ProductCategory parentProductCategory;

	@OneToMany(mappedBy = "productCategory", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonManagedReference
	private List<CategoryImage> categoryImages;

	public ProductCategory() {
		super();
	}

	public Integer getProductCategoryId() {
		return productCategoryId;
	}

	public void setProductCategoryId(Integer productCategoryId) {
		this.productCategoryId = productCategoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	public SizeCategory getSizeCategory() {
		return sizeCategory;
	}

	public void setSizeCategory(SizeCategory sizeCategory) {
		this.sizeCategory = sizeCategory;
	}

	public ProductCategory getParentProductCategory() {
		return parentProductCategory;
	}

	public void setParentProductCategory(ProductCategory parentProductCategory) {
		this.parentProductCategory = parentProductCategory;
	}

	public List<CategoryImage> getCategoryImages() {
		return categoryImages;
	}

	public void setCategoryImages(List<CategoryImage> categoryImages) {
		this.categoryImages = categoryImages;
	}

	@Override
	public String toString() {
		return "ProductCategory [productCategoryId=" + productCategoryId + ", categoryName=" + categoryName
				+ ", categoryDescription=" + categoryDescription + ", sizeCategory=" + sizeCategory
				+ ", parentProductCategory=" + parentProductCategory + ", categoryImages=" + categoryImages + "]";
	}

	
}