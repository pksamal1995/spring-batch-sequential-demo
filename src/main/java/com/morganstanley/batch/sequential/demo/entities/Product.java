package com.morganstanley.batch.sequential.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table
@XmlRootElement(name = "product")
@XmlAccessorOrder(XmlAccessOrder.UNDEFINED)
@XmlAccessorType(XmlAccessType.FIELD)
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@XmlElement(name = "id")
	private Long id;
	@Column(name = "product_code")
	@XmlElement(name = "product-code")
	private String productCode;
	@Column(name = "product_type")
	@XmlElement(name = "product-type")
	private String productType;
	@XmlElement(name = "manufacturer")
	private String manufacturer;
	@XmlElement(name = "price")
	private Double price;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Product(String productCode, String productType, String manufacturer, Double price) {
		
		this.productCode = productCode;
		this.productType = productType;
		this.manufacturer = manufacturer;
		this.price = price;
	}
	public Product() {
		
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", productCode=" + productCode + ", productType=" + productType + ", manufacturer="
				+ manufacturer + ", price=" + price + "]";
	}
	
}
