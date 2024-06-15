package io.github.alancs7.mongodb.domain.repository;

import io.github.alancs7.mongodb.domain.model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {
}
