package com.onlinestore.javarest.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ProductVariation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productVariationId;

	@ManyToOne
	@JoinColumn(name = "product_item_id")
	private ProductItem productItem;

	@ManyToOne
	@JoinColumn(name = "size_id")
	private SizeOption size;

	private Integer qtyInStock;

	public Integer getProductVariationId() {
		return productVariationId;
	}

	public void setProductVariationId(Integer productVariationId) {
		this.productVariationId = productVariationId;
	}

	public ProductItem getProductItem() {
		return productItem;
	}

	public void setProductItem(ProductItem productItem) {
		this.productItem = productItem;
	}

	public SizeOption getSize() {
		return size;
	}

	public void setSize(SizeOption size) {
		this.size = size;
	}

	public Integer getQtyInStock() {
		return qtyInStock;
	}

	public void setQtyInStock(Integer qtyInStock) {
		this.qtyInStock = qtyInStock;
	}

}