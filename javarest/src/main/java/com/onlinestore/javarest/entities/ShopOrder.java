package com.onlinestore.javarest.entities;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "shop_order")
public class ShopOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "shop_order_id")
	private Integer shopOrderId;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@Column(name = "order_date", nullable = false)
	private Date orderDate;

	@ManyToOne
	@JoinColumn(name = "payment_method_id", nullable = false)
	private UserPaymentMethod paymentMethod;

	@ManyToOne
	@JoinColumn(name = "shipping_address", nullable = false)
	private Address shippingAddress;

	@ManyToOne
	@JoinColumn(name = "shipping_method", nullable = false)
	private ShippingMethod shippingMethod;

	@Column(name = "order_total", nullable = false)
	private BigDecimal orderTotal;

	@ManyToOne
	@JoinColumn(name = "order_status", nullable = false)
	private OrderStatus orderStatus;

	public Integer getShopOrderId() {
		return shopOrderId;
	}

	public void setShopOrderId(Integer shopOrderId) {
		this.shopOrderId = shopOrderId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public UserPaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(UserPaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public ShippingMethod getShippingMethod() {
		return shippingMethod;
	}

	public void setShippingMethod(ShippingMethod shippingMethod) {
		this.shippingMethod = shippingMethod;
	}

	public BigDecimal getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(BigDecimal orderTotal) {
		this.orderTotal = orderTotal;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

}