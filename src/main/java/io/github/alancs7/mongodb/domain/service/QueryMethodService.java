package io.github.alancs7.mongodb.domain.service;

import io.github.alancs7.mongodb.domain.model.Product;
import io.github.alancs7.mongodb.domain.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QueryMethodService {

    private final ProductRepository productRepository;

    public List<Product> searchByName(String name) {
        return productRepository.findAllByNameIgnoreCase(name);
    }

    public List<Product> searchByNameStartingWith(String name) {
        return productRepository.findAllByNameStartingWithIgnoreCase(name);
    }

    public List<Product> searchByNameEndingWith(String name) {
        return productRepository.findAllByNameEndingWithIgnoreCase(name);
    }

    public List<Product> searchByNameContaining(String name) {
        return productRepository.findAllByNameContainingIgnoreCase(name);
    }

    public List<Product> searchByPriceLt(BigDecimal price) {
        return productRepository.findAllByPriceLessThan(price);
    }

    public List<Product> searchByPriceGt(BigDecimal price) {
        return productRepository.findAllByPriceGreaterThan(price);
    }

    public List<Product> searchByPriceBetween(BigDecimal from, BigDecimal to) {
        return productRepository.findAllByPriceBetween(from, to);
    }

    public List<Product> searchAndSortAsc(String name) {
        return productRepository.findAllByNameContainingIgnoreCaseOrderByPrice(name);
    }

    public List<Product> sortAndPageByField(String name, int pageNumber, int size) {
        Pageable page = PageRequest.of(pageNumber, size);
        return productRepository.findAllByNameContainingIgnoreCaseOrderByPrice(name, page);
    }
}
