package com.scaler.productservicedec2023.services;

import com.scaler.productservicedec2023.Dto.FakeStoreProductDto;
import com.scaler.productservicedec2023.exceptions.ProductNotExistsException;
import com.scaler.productservicedec2023.models.Category;
import com.scaler.productservicedec2023.models.Product;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



@Service ("fakeStoreProductService")
public class FakeStoreProductService implements ProductService {

    private RestTemplate restTemplate;

    @Autowired
   public FakeStoreProductService(RestTemplate restTemplate){

        this.restTemplate =restTemplate;
    }

    private Product convertFakeStoreProductToProduct(FakeStoreProductDto fakeStoreProduct){
        Product product = new Product();

        product.setTitle(fakeStoreProduct.getTitle());
        product.setId(fakeStoreProduct.getId());
        product.setPrice(fakeStoreProduct.getPrice());
        product.setDescription(fakeStoreProduct.getDescription());
        product.setImageUrl(fakeStoreProduct.getImage());
        product.setCategory(new Category());
        // for MANY TO MANY --  product.setCategory(new ArrayList<>());
        // Category category = new Category();
       // Category.setName (fakeStoreProduct.getCategory());
      //  product.getCategory().add(category);
        product.getCategory().setName(fakeStoreProduct.getCategory());

        return product;

    }


    @Override
    public Product getSingleProduct(Long id) throws ProductNotExistsException {

       // int a = 1 / 0;
    //    throw new RuntimeException("Something stupid has happened ");

      FakeStoreProductDto productDto =  restTemplate.getForObject("https://fakestoreapi.com/products/" + id ,
                   FakeStoreProductDto.class);

          if(productDto == null){
              throw new  ProductNotExistsException(
                      "Product with id: " + id + "doesn't exist." );
          }

        return convertFakeStoreProductToProduct(productDto);
    }

    @Override
    public List<Product> getAllProducts() {

     //   List<FakeStoreProductDto> response = restTemplate.getForObject("https://fakestoreapi.com/products",
       //         List<FakeStoreProductDto>.class
    //    );

        FakeStoreProductDto[] response = restTemplate.getForObject("https://fakestoreapi.com/products",
                FakeStoreProductDto[].class
        );


     List<Product>answer = new ArrayList<>();

     for(FakeStoreProductDto dto: response) {
         answer.add(convertFakeStoreProductToProduct(dto));
     }

        return answer;
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product replaceProduct(Long id, Product product) {

        RequestCallback requestCallback = restTemplate.httpEntityCallback(new FakeStoreProductDto(), FakeStoreProductDto.class);
        HttpMessageConverterExtractor<FakeStoreProductDto> responseExtractor =
                new HttpMessageConverterExtractor<>(FakeStoreProductDto.class, restTemplate.getMessageConverters());
       FakeStoreProductDto response = restTemplate.execute( "https://fakestoreapi.com/products" + id , HttpMethod.PUT, requestCallback, responseExtractor );

       return convertFakeStoreProductToProduct(response);
       //  new org.springframework.http.HttpMethod("Danish");

    }

    @Override
    public Product addNewProduct(Product product) {
        return null;
    }

    @Override
    public boolean deleteProduct(Long id) {
        return false;
    }
}
