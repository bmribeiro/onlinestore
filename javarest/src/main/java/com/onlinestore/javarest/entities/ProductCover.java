package com.onlinestore.javarest.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ProductCover {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer imageId;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private String imageFilename;

    private Integer imageOrder;

    private Boolean isAlbumCover;

	public Integer getImageId() {
		return imageId;
	}

	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
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

	public Boolean getIsAlbumCover() {
		return isAlbumCover;
	}

	public void setIsAlbumCover(Boolean isAlbumCover) {
		this.isAlbumCover = isAlbumCover;
	}

}