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
@Table(name = "user_payment_phone")
public class UserPaymentPhone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer userPaymentPhoneid;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@Column(name = "user_phone", length = 20)
	private String userPhone;

	@Column(name = "user_phone_token", length = 20)
	private String userPhoneToken;


	public Integer getUserPaymentPhoneid() {
		return userPaymentPhoneid;
	}

	public void setUserPaymentPhoneid(Integer userPaymentPhoneid) {
		this.userPaymentPhoneid = userPaymentPhoneid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserPhoneToken() {
		return userPhoneToken;
	}

	public void setUserPhoneToken(String userPhoneToken) {
		this.userPhoneToken = userPhoneToken;
	}

	@Override
	public String toString() {
		return "UserPaymentPhone [userPaymentPhoneid=" + userPaymentPhoneid + ", user=" + user + ", userPhone="
				+ userPhone + ", userPhoneToken=" + userPhoneToken + "]";
	}
}