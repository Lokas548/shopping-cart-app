package com.mironov.shopping.dto;
import org.springframework.stereotype.Component;

@Component
public class SearchFilterDTO {
    private String category;
    private Double minPrice;
    private Double maxPrice;

    public SearchFilterDTO(String category, Double minPrice, Double maxPrice) {
        this.category = category;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

    public SearchFilterDTO() {
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Double minPrice) {
        this.minPrice = minPrice;
    }

    public Double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Double maxPrice) {
        this.maxPrice = maxPrice;
    }


}
