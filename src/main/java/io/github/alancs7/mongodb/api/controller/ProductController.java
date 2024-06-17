package io.github.alancs7.mongodb.api.controller;

import io.github.alancs7.mongodb.domain.model.Product;
import io.github.alancs7.mongodb.domain.service.ProductService;
import io.github.alancs7.mongodb.domain.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final SearchService searchService;

    @PostMapping
    public ResponseEntity<String> save(@RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(product));
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable String id) {
        return ResponseEntity.ok(productService.findById(id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        productService.delete(id);
    }

    @GetMapping("/search/is")
    public ResponseEntity<List<Product>> searchByName(@RequestParam("name") String name) {
        return ResponseEntity.ok(searchService.searchByName(name));
    }

    @GetMapping("/search/starts-with")
    public ResponseEntity<List<Product>> searchByNameStartsWith(@RequestParam("name") String name) {
        return ResponseEntity.ok(searchService.searchByNameStartingWith(name));
    }

    @GetMapping("/search/ends-with")
    public ResponseEntity<List<Product>> searchByNameEndsWith(@RequestParam("name") String name) {
        return ResponseEntity.ok(searchService.searchByNameEndingWith(name));
    }

    @GetMapping("/search/lt")
    public ResponseEntity<List<Product>> searchByPriceLt(@RequestParam("price") BigDecimal price) {
        return ResponseEntity.ok(searchService.searchByPriceLt(price));
    }

    @GetMapping("/search/gt")
    public ResponseEntity<List<Product>> searchByPriceGt(@RequestParam("price") BigDecimal price) {
        return ResponseEntity.ok(searchService.searchByPriceGt(price));
    }

    @GetMapping("/sort/asc")
    public ResponseEntity<List<Product>> sortAscByField(@RequestParam("field") String field) {
        return ResponseEntity.ok(searchService.sortAscByField(field));
    }

    @GetMapping("/sort/desc")
    public ResponseEntity<List<Product>> sortDescByField(@RequestParam("field") String field) {
        return ResponseEntity.ok(searchService.sortDescByField(field));
    }

    @GetMapping("/sort-page")
    public ResponseEntity<List<Product>> sortAndPageByField(@RequestParam("field") String field) {
        return ResponseEntity.ok(searchService.sortAndPageByField(field));
    }
}
