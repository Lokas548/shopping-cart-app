package com.mironov.shopping.repository;

import com.mironov.shopping.dto.CartDTO;
import com.mironov.shopping.entity.CartEntity;
import com.mironov.shopping.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends CrudRepository<CartEntity,Long> {
    @Override
    List<CartEntity> findAll();

    @Query("SELECT c.id, ci.id, ci.product.id, ci.quantity " +
            "FROM CartEntity c JOIN c.cartItems ci WHERE c.user = :user")
    CartEntity findByUserId(@Param("user") UserEntity user);

}
