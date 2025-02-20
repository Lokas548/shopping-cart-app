package com.mironov.shopping.dto;

import com.mironov.shopping.entity.CartEntity;
import com.mironov.shopping.entity.CartItemEntity;

import java.util.List;

public class CartDTO {
    private Long cartId;
    private List<CartItemDTO> cartItems;

    public CartDTO() {
    }

    public CartDTO(Long cartId, List<CartItemDTO> cartItems) {
        this.cartId = cartId;
        this.cartItems = cartItems;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public List<CartItemDTO> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItemDTO> cartItems) {
        this.cartItems = cartItems;
    }


    public class CartItemDTO{
        private  Long cartId;
        private  Long itemId;
        private Long cartItemId;
        private Long productId;
        private int quantity;

        public CartItemDTO() {
        }

        public CartItemDTO(Long cartId, Long itemId, Long productId, Integer quantity) {
            this.cartId = cartId;
            this.itemId = itemId;
            this.productId = productId;
            this.quantity = quantity;
        }

        public CartItemDTO(Long cartItemId, Long productId, int quantity) {
            this.cartItemId = cartItemId;
            this.productId = productId;
            this.quantity = quantity;
        }

        public Long getCartItemId() {
            return cartItemId;
        }

        public void setCartItemId(Long cartItemId) {
            this.cartItemId = cartItemId;
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
}


