package com.onlinestore.javarest.entities;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "product_item_image")
public class ProductItemImage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_item_image_id")
	private Integer productItemImageId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "product_item_id", nullable = false)
	@JsonBackReference
	private ProductItem productItem;

	@Column(name = "image_filename", length = 400)
	private String imageFilename;

	@Column(name = "image_order")
	private Integer imageOrder;

	@Column(name = "is_item_cover")
	private boolean isItemCover;

	@Transient
	private String imageBase64;

	@Transient
	private byte[] image;

	public ProductItemImage() {
		super();
	}

	public ProductItem getProductItem() {
		return productItem;
	}

	public Integer getProductItemImageId() {
		return productItemImageId;
	}

	public void setProductItemImageId(Integer productItemImageId) {
		this.productItemImageId = productItemImageId;
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

	public Integer getImageOrder() {
		return imageOrder;
	}

	public void setImageOrder(Integer imageOrder) {
		this.imageOrder = imageOrder;
	}

	public boolean isItemCover() {
		return isItemCover;
	}

	public void setItemCover(boolean isItemCover) {
		this.isItemCover = isItemCover;
	}

	public String getImageBase64() {
		return imageBase64;
	}

	public void setImageBase64(String imageBase64) {
		this.imageBase64 = imageBase64;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "ProductItemImage [productItemImageId=" + productItemImageId + ", productItem=" + productItem
				+ ", imageFilename=" + imageFilename + ", imageOrder=" + imageOrder + ", isItemCover=" + isItemCover
				+ ", imageBase64=" + imageBase64 + ", image=" + Arrays.toString(image) + "]";
	}
}
