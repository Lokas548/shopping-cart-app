package com.mironov.shopping.dto;

import org.springframework.web.bind.annotation.PathVariable;

public class CartRequestDTO {
    private Long userId;
    private Long productId;
    private int quantity;

    public CartRequestDTO() {
    }

    public CartRequestDTO(Long userId, Long productId, Integer quantity) {
        this.userId = userId;
        this.productId = productId;
        this.quantity = (quantity != null && quantity > 0) ? quantity : 1;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
