package com.mironov.shopping.repository;

import com.mironov.shopping.entity.CartItemEntity;
import org.springframework.data.repository.CrudRepository;

public interface CartItemRepository extends CrudRepository<CartItemEntity,Long> {
}
