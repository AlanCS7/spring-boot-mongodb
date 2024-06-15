package io.github.alancs7.mongodb.domain.service;

import io.github.alancs7.mongodb.domain.model.Product;
import io.github.alancs7.mongodb.domain.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    public String save(Product product) {
        return repository.save(product).getId();
    }

    public Product findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));
    }

    public List<Product> findAll() {
        return repository.findAll();
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

}
