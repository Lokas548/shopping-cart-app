package com.mironov.shopping.controller;


import com.mironov.shopping.dto.SearchFilterDTO;
import com.mironov.shopping.entity.ProductEntity;
import com.mironov.shopping.sevice.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MainController {

    private final ProductService productService;

    public MainController(ProductService productService, SearchFilterDTO searchFilterDTO) {
        this.productService = productService;

    }

    @GetMapping("/")
    @Tag(name = "Тестовый запрос")
    public ResponseEntity Hello(){
        return ResponseEntity.ok().body("hello. server successfully boot");
    }



    @PostMapping("/add")
    @Tag(name = "Добавить новый товар")
    public ResponseEntity addNewProduct(@RequestBody ProductEntity productEntity){
        return productService.addProduct(productEntity);
    }

    @GetMapping("/products")
    @Tag(name = "Показать все продукты")
    public List<ProductEntity> getAllProducts(){
        return productService.allProducts();
    }

    @GetMapping("/products/{category}")
    @Tag(name = "Продукты по категории")
    public List<ProductEntity> getCategoryAllProducts(@PathVariable String category){
        return productService.allCategoryProducts(category);
    }

    @GetMapping("/products/")
    @Tag(name = "Поиск по фильтрам")
    public List<ProductEntity> getFilteredProducts(@RequestParam(required = false,defaultValue = "") String category,
                                                    @RequestParam(required = false,defaultValue = "") Double minPrice,
                                                    @RequestParam(required = false,defaultValue = "") Double maxPrice)
    {
        return productService.allProductsByFilters(new SearchFilterDTO(category,minPrice,maxPrice));
    }
}
