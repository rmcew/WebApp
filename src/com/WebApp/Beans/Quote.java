package com.WebApp.Beans;
import java.util.Date;

public class Quote {
	private int clientId;
	private double gallonsRequested;
	private Date deliveryDate;
	private Date requestDate;
	private String deliveryAddress;
	private String deliveryCity;
	private String deliveryState;
	private String deliveryZip;
	private String deliveryContactName;
	private String deliveryContactPhone;
	private String deliveryContactEmail;
	private double suggestedPrice;
	private double totalAmountDue;
	
	public int getClientId() {
		return clientId;
	}
	public double getGallonsRequested() {
		return gallonsRequested;
	}
	public Date getDeliveryDate() {
		return deliveryDate;
	}
	public Date getRequestDate() {
		return requestDate;
	}
	public String getDeliveryAddress() {
		return deliveryAddress;
	}
	public String getDeliveryCity() {
		return deliveryCity;
	}
	public String getDeliveryState() {
		return deliveryState;
	}
	public String getDeliveryZip() {
		return deliveryZip;
	}	
	public String getDeliveryContactName() {
		return deliveryContactName;
	}
	public String getDeliveryContactPhone() {
		return deliveryContactPhone;
	}
	public String getDeliveryContactEmail() {
		return deliveryContactEmail;
	}
	public double getSuggestedPrice() {
		return suggestedPrice;
	}
	public double getTotalAmountDue() {
		return totalAmountDue;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public void setGallonsRequested(double gallonsRequested) {
		this.gallonsRequested = gallonsRequested;
	}
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}
	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	public void setDeliveryCity(String deliveryCity) {
		this.deliveryCity = deliveryCity;
	}
	public void setDeliveryState(String deliveryState) {
		this.deliveryState = deliveryState;
	}	
	public void setDeliveryZip(String deliveryZip) {
		this.deliveryZip = deliveryZip;
	}	
	public void setDeliveryContactName(String deliveryContactName) {
		this.deliveryContactName = deliveryContactName;
	}
	public void setDeliveryContactPhone(String deliveryContactPhone) {
		this.deliveryContactPhone = deliveryContactPhone;
	}
	public void setDeliveryContactEmail(String deliveryContactEmail) {
		this.deliveryContactEmail = deliveryContactEmail;
	}
	public void setSuggestedPrice(double suggestedPrice) {
		this.suggestedPrice = suggestedPrice;
	}
	public void setTotalAmountDue(double totalAmountDue) {
		this.totalAmountDue = totalAmountDue;
	}
	/*
	public Quote(int clientId, double gallonsRequested, Date deliveryDate, Date requestDate, String deliveryAddress, String deliveryCity, String deliveryState, String deliveryZip,
			String deliveryContactName, String deliveryContactPhone, String deliveryContactEmail, double suggestedPrice,
			double totalAmountDue) {
		super();
		this.clientId = clientId;
		this.gallonsRequested = gallonsRequested;
		this.deliveryDate = deliveryDate;
		this.requestDate = requestDate;
		this.deliveryAddress = deliveryAddress;
		this.deliveryCity = deliveryCity;
		this.deliveryState = deliveryState;
		this.deliveryZip = deliveryZip;
		this.deliveryContactName = deliveryContactName;
		this.deliveryContactPhone = deliveryContactPhone;
		this.deliveryContactEmail = deliveryContactEmail;
		this.suggestedPrice = suggestedPrice;
		this.totalAmountDue = totalAmountDue;
	}
	*/
	
}
