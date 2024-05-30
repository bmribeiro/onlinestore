package com.onlinestore.javarest.entities;

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
@Table(name = "user_payment_method")
public class UserPaymentMethod {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_payment_method_id")
	private Integer userPaymentMethodId;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@ManyToOne
	@JoinColumn(name = "user_billing_id", nullable = false)
	private UserBilling userBilling;

	@ManyToOne
	@JoinColumn(name = "payment_type_id", nullable = false)
	private PaymentType paymentType;

	@Column(name = "expiry_date")
	private Date expiryDate;

	@Column(name = "is_default")
	private boolean isDefault;

	public Integer getUserPaymentMethodId() {
		return userPaymentMethodId;
	}

	public void setUserPaymentMethodId(Integer userPaymentMethodId) {
		this.userPaymentMethodId = userPaymentMethodId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserBilling getUserBilling() {
		return userBilling;
	}

	public void setUserBilling(UserBilling userBilling) {
		this.userBilling = userBilling;
	}

	public PaymentType getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public boolean getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(boolean isDefault) {
		this.isDefault = isDefault;
	}

	@Override
	public String toString() {
		return "UserPaymentMethod [userPaymentMethodId=" + userPaymentMethodId + ", user=" + user + ", userBilling="
				+ userBilling + ", paymentType=" + paymentType + ", expiryDate=" + expiryDate + ", isDefault="
				+ isDefault + "]";
	}
}