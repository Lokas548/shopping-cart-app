package com.mironov.shopping.controller;

import com.mironov.shopping.dto.CartDTO;
import com.mironov.shopping.dto.CartRequestDTO;
import com.mironov.shopping.entity.CartEntity;
import com.mironov.shopping.entity.CartItemEntity;
import com.mironov.shopping.entity.ProductEntity;
import com.mironov.shopping.entity.UserEntity;
import com.mironov.shopping.repository.CartRepository;
import com.mironov.shopping.sevice.CartService;
import com.mironov.shopping.sevice.ProductService;
import com.mironov.shopping.sevice.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;

@RestController
@RequestMapping("/api/user")

public class UserController {
    private final UserService userService;
    private final CartService cartService;
    private final ProductService productService;

    public UserController(UserService userService, CartService cartService, ProductService productService){
        this.userService = userService;
        this.cartService = cartService;
        this.productService = productService;
    }

    @PostMapping("/add")
    @Tag(name = "Добавить пользователя")
    public ResponseEntity addNewUser(@RequestBody UserEntity userEntity){
        userService.addUser(userEntity);
        cartService.createCartForUser(userEntity.getUserId());

        return ResponseEntity.ok().body("Пользователь добавлен");
    }

    @PostMapping("/add-product")
    @Tag(name = "Добавить товар в корзину")
    public CartItemEntity addProductToCart(@RequestBody CartRequestDTO cartRequest){
        UserEntity user = userService.getUserById(cartRequest.getUserId());
        ProductEntity product= productService.getProductById(cartRequest.getProductId());
        return cartService.addProductsToCart(user,product,cartRequest.getQuantity());
    }

    @GetMapping("/get-all")
    @Tag(name = "Показать всех пользователей")
    public List<UserEntity> showAllUsers(){
        return userService.getAllUsers();
    }

    //Debug
    @GetMapping("/get-all-carts")
    @Tag(name = "Показать все корзины")
    public List<CartEntity> showAllCarts(){
        return cartService.getCarts();
    }

    //Debug
    @GetMapping("/get-cart")
    @Tag(name = "Получить корзину пользователя")
    public CartEntity showCart(@RequestParam(name = "userId") Long id){
        return cartService.getUserCart(userService.getUserById(id));
    }
}
