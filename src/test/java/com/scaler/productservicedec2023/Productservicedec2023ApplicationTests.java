package com.scaler.productservicedec2023;

import com.scaler.productservicedec2023.models.Category;
import com.scaler.productservicedec2023.models.Product;
import com.scaler.productservicedec2023.repositories.CategoryRepository;
import com.scaler.productservicedec2023.repositories.ProductRepository;
import com.scaler.productservicedec2023.repositories.projections.ProductWithIdAndTitle;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import java.beans.Transient;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class Productservicedec2023ApplicationTests {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void contextLoads() {
    }


    @Test
    @Transactional
    @Commit
    void testQueries() {
        productRepository.findByTitleContaining("Danish");
        //  productRepository.deleteByTitle("Danish");


       List<ProductWithIdAndTitle> products = productRepository.somethingsomething(252L);

       for(ProductWithIdAndTitle product :products) {
           System.out.println(product.getId());
           System.out.println(product.getTitle());
       }

       List<ProductWithIdAndTitle> products1 = productRepository.somesome2(252L);

       Optional<Category> category = categoryRepository.findById(102L);

       if(true) {
           System.out.println("Getting Products");
           Category category1 = category.get();
           List<Product> products2 = category1.getProducts();
           products2.get(0).getImageUrl();
       }

    }
}