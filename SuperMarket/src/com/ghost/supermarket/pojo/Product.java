package com.ghost.supermarket.pojo;

public class Product {
	 private double productCode; //商品编码
	 private String productName; //商品编码
	 private double deliveryPrice; //销售额（供货价）
	 private double saleroom; //实际销售额
	 private Double salesAmount;//销售数量
	public double getProductCode() {
		return productCode;
	}
	public void setProductCode(double productCode) {
		this.productCode = productCode;
	}
	public double getDeliveryPrice() {
		return deliveryPrice;
	}
	public void setDeliveryPrice(double deliveryPrice) {
		this.deliveryPrice = deliveryPrice;
	}
	public double getSaleroom() {
		return saleroom;
	}
	public void setSaleroom(double saleroom) {
		this.saleroom = saleroom;
	}
	public Double getSalesAmount() {
		return salesAmount;
	}
	public void setSalesAmount(Double salesAmount) {
		this.salesAmount = salesAmount;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	
	 
}
