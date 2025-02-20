package com.mironov.shopping.sevice;

import com.mironov.shopping.dto.SearchFilterDTO;
import com.mironov.shopping.entity.ProductEntity;
import com.mironov.shopping.repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.DateTimeException;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    private class Validation{
        public static boolean onAddProductValidation(ProductEntity productEntity){
            return productEntity.getName() == null ||
                    productEntity.getName() == "" ||
                    productEntity.getPrice() <= 0 ||
                    productEntity.getCategory().isEmpty();
        }
    }

    public ResponseEntity addProduct(ProductEntity productEntity){

        if(Validation.onAddProductValidation(productEntity)){
            return ResponseEntity.badRequest().body("Не корректные данныые");
        }
        try {
            productRepository.save(productEntity);
            return ResponseEntity.ok().body("Продукт добавлен");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка при добавлении продукта: ");
        }
    }

    public List<ProductEntity> allProducts(){
        return (List<ProductEntity>) productRepository.findAll();
    }

    public List<ProductEntity> allCategoryProducts(String category){
        return (List<ProductEntity>) productRepository.findByCategory(category);
    }

    public List<ProductEntity> allProductsByFilters(SearchFilterDTO searchFilterDTO) {
        if(searchFilterDTO.getCategory() != null && !searchFilterDTO.getCategory().isEmpty()) {
            Double minPrice = searchFilterDTO.getMinPrice();
            Double maxPrice = searchFilterDTO.getMaxPrice();

            // Проверяем, что maxPrice и minPrice не равны null перед вызовом isNaN()
            if (maxPrice != null && minPrice != null && !maxPrice.isNaN() && !minPrice.isNaN()) {
                return productRepository.findByCategoryMinPriceAndMaxPrice(searchFilterDTO.getCategory(), minPrice, maxPrice);
            }
            if (maxPrice != null && minPrice == null) {
                return productRepository.findByCategoryAndMaxPrice(searchFilterDTO.getCategory(), maxPrice);
            }
            if (maxPrice == null && minPrice != null) {
                return productRepository.findByCategoryAndMinPrice(searchFilterDTO.getCategory(), minPrice);
            } else {
                return productRepository.findByCategory(searchFilterDTO.getCategory());
            }
        } else {
            Double minPrice = searchFilterDTO.getMinPrice();
            Double maxPrice = searchFilterDTO.getMaxPrice();

            if (minPrice == null && maxPrice != null) {
                return productRepository.findByMaxPrice(maxPrice);
            }
            if (minPrice != null && maxPrice == null) {
                return productRepository.findByMinPrice(minPrice);
            }
            if (minPrice != null && maxPrice != null) {
                return productRepository.findByMinPriceAndMaxPrice(minPrice, maxPrice);
            }
        }
        return List.of();
    }

    public ProductEntity getProductById(Long id){
        return productRepository.findById(id).orElseThrow(() -> new DateTimeException("Не удалось получить продукт"));
    }




}

