package com.scaler.productservicedec2023.controller;

import com.scaler.productservicedec2023.models.Product;
import com.scaler.productservicedec2023.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }



   // private RestTemplate restTemplate;

 //   @Autowired
   // public ProductController(RestTemplate restTemplate){
 //       this.restTemplate =restTemplate;
 //   }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){

        ResponseEntity<List<Product>> response = new ResponseEntity<>(
                productService.getAllProducts(), HttpStatus.ACCEPTED
        );
        return response;
    }

    @GetMapping("/{id}")
    public Product getSingleProduct(@PathVariable("id") Long id) {

        return productService.getSingleProduct(id);
    }
    @PostMapping()
    public Product addNewProduct(@RequestBody Product product) {
         Product p = new Product();
         p.setTitle("A new product");
        return p;
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id , @RequestBody Product product) {

        return new Product();
    }

      @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product) {

        return new Product();
      }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id) {

    }
}
