package com.ghost.supermarket.pojo;

public class Product {
	 private double productCode; //��Ʒ����
	 private String productName; //��Ʒ����
	 private double deliveryPrice; //���۶�����ۣ�
	 private double saleroom; //ʵ�����۶�
	 private Double salesAmount;//��������
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
