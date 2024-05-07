package com.onlinestore.javarest.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_billing")
public class UserBilling {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_billing_id")
	private Integer userBillingId;

	@Column(name = "user_billing_name", nullable = false)
	private String userBillingName;

	@Column(name = "user_billing_nif", nullable = false)
	private String userBillingNif;

	@Column(name = "user_billing_phone", nullable = false)
	private String userBillingPhone;

	public Integer getUserBillingId() {
		return userBillingId;
	}

	public void setUserBillingId(Integer userBillingId) {
		this.userBillingId = userBillingId;
	}

	public String getUserBillingName() {
		return userBillingName;
	}

	public void setUserBillingName(String userBillingName) {
		this.userBillingName = userBillingName;
	}

	public String getUserBillingNif() {
		return userBillingNif;
	}

	public void setUserBillingNif(String userBillingNif) {
		this.userBillingNif = userBillingNif;
	}

	public String getUserBillingPhone() {
		return userBillingPhone;
	}

	public void setUserBillingPhone(String userBillingPhone) {
		this.userBillingPhone = userBillingPhone;
	}

}