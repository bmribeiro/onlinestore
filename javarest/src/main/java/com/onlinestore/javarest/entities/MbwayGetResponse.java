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
@Table(name = "mbwayGetResponse")
public class MbwayGetResponse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mbwayGetResponse_id")
	private Integer mbwayGetResponseId;

	@Column(name = "createdAt")
	private String createdAt;

	@Column(name = "message")
	private String message;

	@Column(name = "requestId")
	private String requestId;

	@Column(name = "status")
	private String status;

	@Column(name = "updateAt")
	private String updateAt;

	@ManyToOne
	@JoinColumn(name = "mbwayPostResponse_id")
	private MbwayPostResponse mbwayPostResponse;

	public Integer getMbwayGetResponseId() {
		return mbwayGetResponseId;
	}

	public void setMbwayGetResponseId(Integer mbwayGetResponseId) {
		this.mbwayGetResponseId = mbwayGetResponseId;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
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

	public String getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(String updateAt) {
		this.updateAt = updateAt;
	}

	public MbwayPostResponse getMbwayPostResponse() {
		return mbwayPostResponse;
	}

	public void setMbwayPostResponse(MbwayPostResponse mbwayPostResponse) {
		this.mbwayPostResponse = mbwayPostResponse;
	}

}