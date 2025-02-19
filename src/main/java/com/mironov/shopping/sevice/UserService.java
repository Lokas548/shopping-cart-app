package com.mironov.shopping.sevice;

import com.mironov.shopping.entity.UserEntity;
import com.mironov.shopping.exception.DatabaseBadResponseException;
import com.mironov.shopping.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public ResponseEntity addUser(UserEntity userEntity){
        try{
            userRepository.save(userEntity);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Не удалось добавить пользователя");
        }
        return ResponseEntity.ok("Пользователь добавлен");
    }

    public List<UserEntity> getAllUsers(){
        try {
            return userRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }
}
