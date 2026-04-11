package cg.example.Product.Order.DTO;

import jakarta.validation.constraints.Min;

public class OrderRequest {

    private Integer userId;

    private Integer productId;
    
    @Min(value = 1, message = "Quantity must be greater than 0")
    private Integer quantity;


    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }

    public Integer getProductId() { return productId; }
    public void setProductId(Integer productId) { this.productId = productId; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
}