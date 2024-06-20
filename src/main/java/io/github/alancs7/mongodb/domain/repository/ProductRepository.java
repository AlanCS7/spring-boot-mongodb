package io.github.alancs7.mongodb.domain.repository;

import io.github.alancs7.mongodb.domain.model.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

    List<Product> findAllByNameIgnoreCase(String name);

    List<Product> findAllByNameStartingWithIgnoreCase(String name);

    List<Product> findAllByNameEndingWithIgnoreCase(String name);

    List<Product> findAllByNameContainingIgnoreCase(String name);

    List<Product> findAllByPriceLessThan(BigDecimal price);

    List<Product> findAllByPriceGreaterThan(BigDecimal price);

    List<Product> findAllByPriceBetween(BigDecimal from, BigDecimal to);

    List<Product> findAllByNameContainingIgnoreCaseOrderByPrice(String name);

    List<Product> findAllByNameContainingIgnoreCaseOrderByPrice(String name, Pageable pageable);

}
