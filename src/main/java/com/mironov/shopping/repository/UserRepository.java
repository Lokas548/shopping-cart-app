package com.mironov.shopping.repository;

import com.mironov.shopping.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<UserEntity,Long> {
    @Override
    List<UserEntity> findAll();
}
