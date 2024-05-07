package com.onlinestore.javarest.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class AttributeOption {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer attributeOptionId;

	@ManyToOne
	@JoinColumn(name = "attribute_type_id")
	private AttributeType attributeType;

	private String attributeOptionName;

	public Integer getAttributeOptionId() {
		return attributeOptionId;
	}

	public void setAttributeOptionId(Integer attributeOptionId) {
		this.attributeOptionId = attributeOptionId;
	}

	public AttributeType getAttributeType() {
		return attributeType;
	}

	public void setAttributeType(AttributeType attributeType) {
		this.attributeType = attributeType;
	}

	public String getAttributeOptionName() {
		return attributeOptionName;
	}

	public void setAttributeOptionName(String attributeOptionName) {
		this.attributeOptionName = attributeOptionName;
	}

}