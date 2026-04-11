package cg.example.Product.Order.DTO;

import jakarta.validation.constraints.Min;

public class OrderResponse {
    private int orderId;
    private String userName;
    private String productName;
    @Min( value = 1 , message = "Quantity must be greater than 0")
    private int quantity;
    private double totalPrice;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public OrderResponse(int orderId, String userName, String productName, int quantity, double totalPrice) {
		super();
		this.orderId = orderId;
		this.userName = userName;
		this.productName = productName;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
	}
	public OrderResponse() {
	}
    
}
