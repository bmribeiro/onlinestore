package com.onlinestore.javarest.entities;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_line")
public class OrderLine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_line_id")
	private Integer orderLineId;

	@ManyToOne
	@JoinColumn(name = "product_item_id", nullable = false)
	private ProductItem productItem;

	@ManyToOne
	@JoinColumn(name = "order_id", nullable = false)
	private ShopOrder shopOrder;

	@Column(name = "qty", nullable = false)
	private Integer qty;

	@Column(name = "price", nullable = false)
	private BigDecimal price;

	public Integer getOrderLineId() {
		return orderLineId;
	}

	public void setOrderLineId(Integer orderLineId) {
		this.orderLineId = orderLineId;
	}

	public ProductItem getProductItem() {
		return productItem;
	}

	public void setProductItem(ProductItem productItem) {
		this.productItem = productItem;
	}

	public ShopOrder getShopOrder() {
		return shopOrder;
	}

	public void setShopOrder(ShopOrder shopOrder) {
		this.shopOrder = shopOrder;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "OrderLine [orderLineId=" + orderLineId + ", productItem=" + productItem + ", shopOrder=" + shopOrder
				+ ", qty=" + qty + ", price=" + price + "]";
	}
}
