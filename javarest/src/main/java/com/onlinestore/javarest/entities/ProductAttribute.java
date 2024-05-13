package com.onlinestore.javarest.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ProductAttribute {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productAttributeId;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	@ManyToOne
	@JoinColumn(name = "attribute_option_id")
	private AttributeOption attributeOption;

	public Integer getProductAttributeId() {
		return productAttributeId;
	}

	public void setProductAttributeId(Integer productAttributeId) {
		this.productAttributeId = productAttributeId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public AttributeOption getAttributeOption() {
		return attributeOption;
	}

	public void setAttributeOption(AttributeOption attributeOption) {
		this.attributeOption = attributeOption;
	}
}