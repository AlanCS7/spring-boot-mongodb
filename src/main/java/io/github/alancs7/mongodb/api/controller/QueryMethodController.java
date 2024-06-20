package io.github.alancs7.mongodb.api.controller;

import io.github.alancs7.mongodb.domain.model.Product;
import io.github.alancs7.mongodb.domain.service.QueryMethodService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/method-queries")
@RequiredArgsConstructor
public class QueryMethodController {

    private final QueryMethodService queryMethodService;

    @GetMapping("/search/is")
    public ResponseEntity<List<Product>> searchByName(@RequestParam("name") String name) {
        return ResponseEntity.ok(queryMethodService.searchByName(name));
    }

    @GetMapping("/search/starts-with")
    public ResponseEntity<List<Product>> searchByNameStartsWith(@RequestParam("name") String name) {
        return ResponseEntity.ok(queryMethodService.searchByNameStartingWith(name));
    }

    @GetMapping("/search/ends-with")
    public ResponseEntity<List<Product>> searchByNameEndsWith(@RequestParam("name") String name) {
        return ResponseEntity.ok(queryMethodService.searchByNameEndingWith(name));
    }

    @GetMapping("/search/containing")
    public ResponseEntity<List<Product>> searchByNameContaining(@RequestParam("name") String name) {
        return ResponseEntity.ok(queryMethodService.searchByNameContaining(name));
    }

    @GetMapping("/search/lt")
    public ResponseEntity<List<Product>> searchByPriceLt(@RequestParam("price") BigDecimal price) {
        return ResponseEntity.ok(queryMethodService.searchByPriceLt(price));
    }

    @GetMapping("/search/gt")
    public ResponseEntity<List<Product>> searchByPriceGt(@RequestParam("price") BigDecimal price) {
        return ResponseEntity.ok(queryMethodService.searchByPriceGt(price));
    }

    @GetMapping("/search/between")
    public ResponseEntity<List<Product>> searchByPriceBetween(@RequestParam("from") BigDecimal from,
                                                              @RequestParam("to") BigDecimal to) {
        return ResponseEntity.ok(queryMethodService.searchByPriceBetween(from, to));
    }

    @GetMapping("/sort/asc")
    public ResponseEntity<List<Product>> sortAscByField(@RequestParam("name") String name) {
        return ResponseEntity.ok(queryMethodService.searchAndSortAsc(name));
    }

    @GetMapping("/sort-page")
    public ResponseEntity<List<Product>> sortAndPageByField(
            @RequestParam("name") String name,
            @RequestParam(value = "page-number", required = false, defaultValue = "0") int pageNumber,
            @RequestParam(value = "size", required = false, defaultValue = "2") int size
    ) {
        return ResponseEntity.ok(queryMethodService.sortAndPageByField(name, pageNumber, size));
    }
}
