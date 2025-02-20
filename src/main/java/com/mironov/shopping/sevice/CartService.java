package com.mironov.shopping.sevice;


import com.mironov.shopping.dto.CartDTO;
import com.mironov.shopping.entity.CartEntity;
import com.mironov.shopping.entity.CartItemEntity;
import com.mironov.shopping.entity.ProductEntity;
import com.mironov.shopping.entity.UserEntity;
import com.mironov.shopping.repository.CartItemRepository;
import com.mironov.shopping.repository.CartRepository;
import com.mironov.shopping.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class CartService {
    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final CartItemRepository cartItemRepository;

    public CartService(CartRepository cartRepository,UserRepository userRepository,CartItemRepository cartItemRepository) {
        this.cartRepository = cartRepository;
        this.userRepository = userRepository;
        this.cartItemRepository = cartItemRepository;
    }

    public CartEntity createCartForUser(Long userId){
        UserEntity user = userRepository.findById(userId).orElseThrow(()
                -> new RuntimeException("user not found"));

        CartEntity cart = new CartEntity();
        cart.setUser(user);
        cart.setCartItems(new HashSet<>());

        return cartRepository.save(cart);
    }

    //Debug
    public List<CartEntity> getCarts(){
        return cartRepository.findAll();
    }

    public CartEntity getUserCart(UserEntity user){
        return cartRepository.findByUserId(user);
    }

    public CartItemEntity addProductsToCart(UserEntity user, ProductEntity productId, int quantity){
        CartEntity cart = getUserCart(user);
        return cartItemRepository.save(new CartItemEntity(cart,productId,quantity));
    }
}
