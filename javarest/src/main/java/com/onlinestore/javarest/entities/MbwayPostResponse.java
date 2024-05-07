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
@Table(name = "mbwayPostResponse")
public class MbwayPostResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mbwayPostResponse_id")
    private Integer mbwayPostResponseId;

    @Column(name = "amount")
    private String amount;

    @Column(name = "message")
    private String message;

    @Column(name = "orderId")
    private String orderId;

    @Column(name = "requestId")
    private String requestId;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "mbwayPostRequest_id")
    private MbwayPostRequest mbwayPostRequest;

	public Integer getMbwayPostResponseId() {
		return mbwayPostResponseId;
	}

	public void setMbwayPostResponseId(Integer mbwayPostResponseId) {
		this.mbwayPostResponseId = mbwayPostResponseId;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
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

	public MbwayPostRequest getMbwayPostRequest() {
		return mbwayPostRequest;
	}

	public void setMbwayPostRequest(MbwayPostRequest mbwayPostRequest) {
		this.mbwayPostRequest = mbwayPostRequest;
	}

}