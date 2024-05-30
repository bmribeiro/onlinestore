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
@Table(name = "mbPostRequest")
public class MbPostRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mbPostRequest_id")
	private Integer mbPostRequestId;

	@Column(name = "orderId")
	private String orderId;

	@Column(name = "amount")
	private Double amount;

	@Column(name = "description")
	private String description;

	@Column(name = "url")
	private String url;

	@Column(name = "clientCode")
	private String clientCode;

	@Column(name = "clientName")
	private String clientName;

	@Column(name = "clientEmail")
	private String clientEmail;

	@Column(name = "clientUsername")
	private String clientUsername;

	@Column(name = "clientPhone")
	private String clientPhone;

	@Column(name = "expiryDays")
	private Integer expiryDays;

	@ManyToOne
	@JoinColumn(name = "user_payment_method_id")
	private UserPaymentMethod userPaymentMethod;

	public Integer getMbPostRequestId() {
		return mbPostRequestId;
	}

	public void setMbPostRequestId(Integer mbPostRequestId) {
		this.mbPostRequestId = mbPostRequestId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getClientCode() {
		return clientCode;
	}

	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientEmail() {
		return clientEmail;
	}

	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}

	public String getClientUsername() {
		return clientUsername;
	}

	public void setClientUsername(String clientUsername) {
		this.clientUsername = clientUsername;
	}

	public String getClientPhone() {
		return clientPhone;
	}

	public void setClientPhone(String clientPhone) {
		this.clientPhone = clientPhone;
	}

	public Integer getExpiryDays() {
		return expiryDays;
	}

	public void setExpiryDays(Integer expiryDays) {
		this.expiryDays = expiryDays;
	}

	public UserPaymentMethod getUserPaymentMethod() {
		return userPaymentMethod;
	}

	public void setUserPaymentMethod(UserPaymentMethod userPaymentMethod) {
		this.userPaymentMethod = userPaymentMethod;
	}

	@Override
	public String toString() {
		return "MbPostRequest [mbPostRequestId=" + mbPostRequestId + ", orderId=" + orderId + ", amount=" + amount
				+ ", description=" + description + ", url=" + url + ", clientCode=" + clientCode + ", clientName="
				+ clientName + ", clientEmail=" + clientEmail + ", clientUsername=" + clientUsername + ", clientPhone="
				+ clientPhone + ", expiryDays=" + expiryDays + ", userPaymentMethod=" + userPaymentMethod + "]";
	}
}