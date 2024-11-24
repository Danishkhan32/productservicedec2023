package com.scaler.productservicedec2023.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class Product extends BaseModel{
    private String title;
    private Double price;
    @ManyToOne (fetch = FetchType.LAZY , cascade = {CascadeType.PERSIST , CascadeType.MERGE})
    private Category category;
    @Lob
    private String description;
    private String imageUrl;

     private int numberOfSales;

    // public static ProductDto to Dto() {
    //
    //  }

}
