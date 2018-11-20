package com.WebApp.Beans;

public class ClientInformation {
	private int clientId;
	private String name;
	private String address;
	private String phone;
	private String email;
	
	public int getClientId() {
		return clientId;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public String getPhone() {
		return phone;
	}
	public String getEmail() {
		return email;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
