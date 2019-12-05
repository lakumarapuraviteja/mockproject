package com.cognizant.smartshopservice.model;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "product")
public class Product {
	@Id
	@Column(name = "product_code")
	String productCode;
	@Column(name = "product_name")
	String productName;
	@Column(name = "product_brand")
	String productBrand;
	@Column(name = "rate_per_quantity")
	int rate;
	@Column(name = "stock_count")
	int stockCount;
	@Column(name = "add_date")
	Date addDate;
	@Column(name = "aisle")
	String aisle;
	@Column(name = "shelf")
	String shelf;
	@Column(name = "date_of_manufacture")
	Date manufactureDate;
	@Column(name = "date_of_expiry")
	Date expiryDate;
	@Column(name = "product_image")
	String image;
	@Column(name = "product_type")
	String productType;
	@Column(name = "product_type_image")
	String productTypeImage;

	
	  @OneToMany(mappedBy="product",fetch = FetchType.EAGER,cascade =CascadeType.ALL)  
	  @JsonIgnore private Set<Bill> billList;
	 
	 public Set<Bill> getBillList() { return billList; } public void
	setBillList(Set<Bill> billList) { this.billList = billList; }
	 
	public String getProductTypeImage() {
		return productTypeImage;
	}

	public void setProductTypeImage(String productTypeImage) {
		this.productTypeImage = productTypeImage;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductBrand() {
		return productBrand;
	}

	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public int getStockCount() {
		return stockCount;
	}

	public void setStockCount(int stockCount) {
		this.stockCount = stockCount;
	}

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public String getAisle() {
		return aisle;
	}

	public void setAisle(String aisle) {
		this.aisle = aisle;
	}

	public String getShelf() {
		return shelf;
	}

	public void setShelf(String shelf) {
		this.shelf = shelf;
	}

	public Date getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	@Override
	public String toString() {
		return "Product [productCode=" + productCode + ", productName=" + productName + ", productBrand=" + productBrand
				+ ", rate=" + rate + ", stockCount=" + stockCount + ", addDate=" + addDate + ", aisle=" + aisle
				+ ", shelf=" + shelf + ", manufactureDate=" + manufactureDate + ", expiryDate=" + expiryDate
				+ ", image=" + image + ", productType=" + productType + ", productTypeImage=" + productTypeImage + "]";
	}

}
