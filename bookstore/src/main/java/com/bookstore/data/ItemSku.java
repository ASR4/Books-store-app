package com.bookstore.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ItemSku {
	private String masterSKU;	
	private String product;
	private String type	;
	private String brand;	
	private String model;	
	private String 	description;
	private String inventory;
	private String price_CAD;	
	private String price_USD;	
	private String 	length;	
	private String 	width;	
	private String 	height;	
	private String 	weight;
	public String getMasterSKU() {
		return masterSKU;
	}
	public void setMasterSKU(String masterSKU) {
		this.masterSKU = masterSKU;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getInventory() {
		return inventory;
	}
	public void setInventory(String inventory) {
		this.inventory = inventory;
	}
	public String getPrice_CAD() {
		return price_CAD;
	}
	public void setPrice_CAD(String price_CAD) {
		this.price_CAD = price_CAD;
	}
	public String getPrice_USD() {
		return price_USD;
	}
	public void setPrice_USD(String price_USD) {
		this.price_USD = price_USD;
	}
	public String getLength() {
		return length;
	}
	public void setLength(String length) {
		this.length = length;
	}
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	
}
