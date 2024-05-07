package com.onlinestore.javarest.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Colour {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer colourId;

	private String colourName;

	private String colourHex;

	public Integer getColourId() {
		return colourId;
	}

	public void setColourId(Integer colourId) {
		this.colourId = colourId;
	}

	public String getColourName() {
		return colourName;
	}

	public void setColourName(String colourName) {
		this.colourName = colourName;
	}

	public String getColourHex() {
		return colourHex;
	}

	public void setColourHex(String colourHex) {
		this.colourHex = colourHex;
	}

}
