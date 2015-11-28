package com.foodrus.bean;

import java.sql.Blob;

public class Category implements DomainBean {
	// *** serial number
	private static final long serialVersionUID = -4527552993807311995L;

	private Blob picture;
	private String desription;
	private String name;
	private int id;
	
	public Category() {
	}

	public Blob getPicture() {
		return picture;
	}

	public void setPicture(Blob picture) {
		this.picture = picture;
	}

	public String getDesription() {
		return desription;
	}

	public void setDesription(String desription) {
		this.desription = desription;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
