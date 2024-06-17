package io.github.alancs7.mongodb.domain.service;

import io.github.alancs7.mongodb.domain.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

import static org.springframework.data.domain.Sort.Direction;
import static org.springframework.data.mongodb.core.query.Criteria.where;

@Service
@RequiredArgsConstructor
public class SearchService {

    private final MongoTemplate mongoTemplate;

    public List<Product> searchByName(String name) {
        var query = new Query();
        query.addCriteria(where("name").is(name));
        return mongoTemplate.find(query, Product.class);
    }

    public List<Product> searchByNameStartingWith(String name) {
        var query = new Query();
        query.addCriteria(where("name").regex("^" + name, "i"));
        return mongoTemplate.find(query, Product.class);
    }

    public List<Product> searchByNameEndingWith(String name) {
        var query = new Query();
        query.addCriteria(where("name").regex(name + "$", "i"));
        return mongoTemplate.find(query, Product.class);
    }

    public List<Product> searchByPriceLt(BigDecimal price) {
        var query = new Query();
        query.addCriteria(where("price").lt(price));
        return mongoTemplate.find(query, Product.class);
    }

    public List<Product> searchByPriceGt(BigDecimal price) {
        var query = new Query();
        query.addCriteria(where("price").gt(price));
        return mongoTemplate.find(query, Product.class);
    }

    public List<Product> sortAscByField(String fieldName) {
        var query = new Query();
        query.with(Sort.by(Direction.ASC, fieldName));
        return mongoTemplate.find(query, Product.class);
    }

    public List<Product> sortDescByField(String fieldName) {
        var query = new Query();
        query.with(Sort.by(Direction.DESC, fieldName));
        return mongoTemplate.find(query, Product.class);
    }

    public List<Product> sortAndPageByField(String fieldName) {
        var query = new Query();
        var pageable = PageRequest.of(0, 2, Sort.by(Direction.ASC, fieldName));
        query.with(pageable);
        return mongoTemplate.find(query, Product.class);
    }
}
