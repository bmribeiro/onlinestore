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
@Table(name = "user_details")
public class UserDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_details_id")
	private Integer userDetailsId;

	@Column(name = "user_nif")
	private String userNif;

	@Column(name = "user_phone")
	private String userPhone;

	@Column(name = "user_phone_token")
	private String userPhoneToken;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	public Integer getUserDetailsId() {
		return userDetailsId;
	}

	public void setUserDetailsId(Integer userDetailsId) {
		this.userDetailsId = userDetailsId;
	}

	public String getUserNif() {
		return userNif;
	}

	public void setUserNif(String userNif) {
		this.userNif = userNif;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "UserDetail [userDetailsId=" + userDetailsId + ", userNif=" + userNif + ", userPhone=" + userPhone
				+ ", userPhoneToken=" + userPhoneToken + ", user=" + user + "]";
	}
}