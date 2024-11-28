package com.scaler.productservicedec2023.controller;

import com.scaler.productservicedec2023.exceptions.ProductNotExistsException;
import com.scaler.productservicedec2023.models.Product;
import com.scaler.productservicedec2023.repositories.ProductRepository;
import com.scaler.productservicedec2023.services.ProductService;
import com.scaler.productservicedec2023.services.SelfProductService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductControllerTest {

     @Autowired
     private ProductController productController;

               @MockBean
              private SelfProductService productService;

               @MockBean
               private ProductRepository productRepository;

          @Test
         void testProductsSameAsService(){
              // arrange

              List<Product> products = new ArrayList<>();

               Product p1 = new Product();
               p1.setTitle("iPhone 15");
               products.add(p1);

              Product p2 = new Product();
              p2.setTitle("iPhone 15 Pro");
              products.add(p2);

              Product p3 = new Product();
              p3.setTitle("iPhone 15 Pro Max");
              products.add(p3);

              List<Product> productsToPass = new ArrayList<>();

              for(Product p: products){
                  Product p111 = new Product();
                  p111.setTitle(p.getTitle());
                  productsToPass.add(p111);
              }


              when ( productService.getAllProducts()).
                      thenReturn( productsToPass );

            // act
             ResponseEntity <List<Product>> response = productController.getAllProducts();


             // assert

              List<Product> productsInResponse = response.getBody();
              assertEquals(products.size(), productsInResponse.size());

              for(int i=0 ; i<productsInResponse.size(); ++i){
                  assertEquals(products.get(i).getTitle() ,
                          productsInResponse.get(i).getTitle());
              }

         }

         @Test
         void testNonExistingProductThrowsException() throws ProductNotExistsException {

                  // arrange
              when( productRepository.findById(10L) ).
                      thenReturn(Optional.empty());

              when( productService.getSingleProduct(any())
              ).thenCallRealMethod();




              // act
             assertThrows(ProductNotExistsException.class,
                     () ->  productController.getSingleProduct(10L));




         }

}