package com.onlinestore.javarest.entities;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productItemId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "product_id")
	private Product product;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "colour_id")
	private Colour colour;

	@Column(name = "original_price")
	private BigDecimal originalPrice;

	@Column(name = "sale_price")
	private BigDecimal salePrice;

	@Column(name = "product_code")
	private String productCode;

	@OneToMany(mappedBy = "productItem", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonManagedReference
	private List<ProductItemImage> productItemImages;

	public ProductItem() {
		super();
	}

	public Integer getProductItemId() {
		return productItemId;
	}

	public void setProductItemId(Integer productItemId) {
		this.productItemId = productItemId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Colour getColour() {
		return colour;
	}

	public void setColour(Colour colour) {
		this.colour = colour;
	}

	public BigDecimal getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(BigDecimal originalPrice) {
		this.originalPrice = originalPrice;
	}

	public BigDecimal getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public List<ProductItemImage> getProductItemImages() {
		return productItemImages;
	}

	public void setProductItemImages(List<ProductItemImage> productItemImages) {
		this.productItemImages = productItemImages;
	}

	@Override
	public String toString() {
		return "ProductItem [productItemId=" + productItemId + ", product=" + product + ", colour=" + colour
				+ ", originalPrice=" + originalPrice + ", salePrice=" + salePrice + ", productCode=" + productCode
				+ ", productItemImages=" + productItemImages + "]";
	}
}
