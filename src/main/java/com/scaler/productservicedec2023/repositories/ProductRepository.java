package com.scaler.productservicedec2023.repositories;

import com.scaler.productservicedec2023.models.Category;
import com.scaler.productservicedec2023.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository
   extends JpaRepository<Product,Long> {

    List<Product> findByTitleContaining(String word);

    long deleteByTitle(String title);

    List<Product>findByTitleAndDescription(String title, String description);

    List<Product>findByPriceBetween(double startRange , double endRange);

    List<Product>findByCategory(Category category);

    Product findByIdAndCategoryOrderByTitle(Long id, Category category);

    List<Product>findByCategory_Id(Long id);

   Optional<Product> findById(Long id);

   Product save(Product product);
}
