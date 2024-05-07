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
@Table(name = "mbPostResponse")
public class MbPostResponse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mbPostResponse_id")
	private Integer mbPostResponseId;

	@Column(name = "Amount")
	private Double amount;

	@Column(name = "Entity")
	private String entity;

	@Column(name = "ExpiryDate")
	private String expiryDate;

	@Column(name = "Message")
	private String message;

	@Column(name = "OrderId")
	private String orderId;

	@Column(name = "Reference")
	private String reference;

	@Column(name = "RequestId")
	private String requestId;

	@Column(name = "Status")
	private String status;

	@ManyToOne
	@JoinColumn(name = "mbPostRequest_id")
	private MbPostRequest mbPostRequest;

	public Integer getMbPostResponseId() {
		return mbPostResponseId;
	}

	public void setMbPostResponseId(Integer mbPostResponseId) {
		this.mbPostResponseId = mbPostResponseId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public MbPostRequest getMbPostRequest() {
		return mbPostRequest;
	}

	public void setMbPostRequest(MbPostRequest mbPostRequest) {
		this.mbPostRequest = mbPostRequest;
	}

}
