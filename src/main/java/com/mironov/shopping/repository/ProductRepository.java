package com.mironov.shopping.repository;

import com.mironov.shopping.entity.ProductEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Long> {

    // Поиск по категории
    List<ProductEntity> findByCategory(String category);

    // Поиск по минимальной цене
    @Query("SELECT p FROM ProductEntity p WHERE p.price >= :minPrice")
    List<ProductEntity> findByMinPrice(@Param("minPrice") double minPrice);

    // Поиск по максимальной цене
    @Query("SELECT p FROM ProductEntity p WHERE p.price <= :maxPrice")
    List<ProductEntity> findByMaxPrice(@Param("maxPrice") double maxPrice);

    // Поиск по минимальной и максимальной цене
    @Query("SELECT p FROM ProductEntity p WHERE p.price >= :minPrice AND p.price <= :maxPrice")
    List<ProductEntity> findByMinPriceAndMaxPrice(@Param("minPrice") double minPrice, @Param("maxPrice") double maxPrice);

    // Поиск по категории и минимальной цене
    @Query("SELECT p FROM ProductEntity p WHERE p.category = :category AND p.price >= :minPrice")
    List<ProductEntity> findByCategoryAndMinPrice(@Param("category") String category, @Param("minPrice") double minPrice);

    // Поиск по категории и максимальной цене
    @Query("SELECT p FROM ProductEntity p WHERE p.category = :category AND p.price < :maxPrice")
    List<ProductEntity> findByCategoryAndMaxPrice(@Param("category") String category, @Param("maxPrice") double maxPrice);

    // Поиск по категории, минимальной и максимальной цене
    @Query("SELECT p FROM ProductEntity p WHERE p.category = :category AND p.price >= :minPrice AND p.price < :maxPrice")
    List<ProductEntity> findByCategoryMinPriceAndMaxPrice(@Param("category") String category,
                                                          @Param("minPrice") double minPrice,
                                                          @Param("maxPrice") double maxPrice);
}

