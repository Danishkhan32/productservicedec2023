package com.scaler.productservicedec2023.services;

import com.scaler.productservicedec2023.exceptions.ProductNotExistsException;
import com.scaler.productservicedec2023.models.Product;

import java.util.List;

public interface ProductService {

    Product getSingleProduct(Long id) throws ProductNotExistsException;

    List<Product> getAllProducts();

    Product updateProduct(Long id, Product product);
    Product replaceProduct(Long id , Product product);

    Product addNewProduct(Product product);

    boolean deleteProduct(Long id);
}
