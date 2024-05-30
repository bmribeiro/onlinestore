package com.onlinestore.javarest.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "category_image")
public class CategoryImage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_image_id")
	private Integer categoryImageId;

	@ManyToOne
	@JoinColumn(name = "product_category_id")
	@JsonBackReference
	private ProductCategory productCategory;

	@Column(name = "image_filename")
	private String imageFilename;

	@Column(name = "image_order")
	private Integer imageOrder;

	@Column(name = "is_album_cover")
	private boolean isAlbumCover;

	@Transient
	private String imageBase64;

	public CategoryImage() {
		super();
	}

	public Integer getCategoryImageId() {
		return categoryImageId;
	}

	public void setCategoryImageId(Integer categoryImageId) {
		this.categoryImageId = categoryImageId;
	}

	public ProductCategory getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}

	public String getImageFilename() {
		return imageFilename;
	}

	public void setImageFilename(String imageFilename) {
		this.imageFilename = imageFilename;
	}

	public Integer getImageOrder() {
		return imageOrder;
	}

	public void setImageOrder(Integer imageOrder) {
		this.imageOrder = imageOrder;
	}

	public boolean isAlbumCover() {
		return isAlbumCover;
	}

	public void setAlbumCover(boolean isAlbumCover) {
		this.isAlbumCover = isAlbumCover;
	}

	public String getImageBase64() {
		return imageBase64;
	}

	public void setImageBase64(String imageBase64) {
		this.imageBase64 = imageBase64;
	}

	@Override
	public String toString() {
		return "CategoryImage [categoryImageId=" + categoryImageId + ", productCategory=" + productCategory
				+ ", imageFilename=" + imageFilename + ", imageOrder=" + imageOrder + ", isAlbumCover=" + isAlbumCover
				+ ", imageBase64=" + imageBase64 + "]";
	}
}
