package com.mironov.shopping.controller;

import com.mironov.shopping.entity.UserEntity;
import com.mironov.shopping.sevice.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")

public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/add")
    @Tag(name = "Добавить пользователя")
    public ResponseEntity addNewUser(@RequestBody UserEntity userEntity){
        return userService.addUser(userEntity);
    }

    @GetMapping("/get-all")
    @Tag(name = "Показать всех пользователей")
    public List<UserEntity> showAllUsers(){
        return userService.getAllUsers();
    }
}
