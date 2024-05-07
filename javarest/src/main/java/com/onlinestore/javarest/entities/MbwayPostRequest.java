package com.onlinestore.javarest.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "mbwayPostRequest")
public class MbwayPostRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mbwayPostRequest_id")
	private Integer mbwayPostRequestId;

	@Column(name = "orderId")
	private String orderId;

	@Column(name = "amount")
	private String amount;

	@Column(name = "mobileNumber")
	private String mobileNumber;

	@Column(name = "email")
	private String email;

	@Column(name = "description")
	private String description;

	@ManyToOne
	@JoinColumn(name = "user_payment_method_id")
	private UserPaymentMethod userPaymentMethod;

	public Integer getMbwayPostRequestId() {
		return mbwayPostRequestId;
	}

	public void setMbwayPostRequestId(Integer mbwayPostRequestId) {
		this.mbwayPostRequestId = mbwayPostRequestId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public UserPaymentMethod getUserPaymentMethod() {
		return userPaymentMethod;
	}

	public void setUserPaymentMethod(UserPaymentMethod userPaymentMethod) {
		this.userPaymentMethod = userPaymentMethod;
	}

}