package io.github.alancs7.mongodb;

import io.github.alancs7.mongodb.domain.model.Category;
import io.github.alancs7.mongodb.domain.model.Product;
import io.github.alancs7.mongodb.domain.repository.CategoryRepository;
import io.github.alancs7.mongodb.domain.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class MongodbApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongodbApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ProductRepository repository,
                                               CategoryRepository categoryRepository) {
        return args -> {
            var category = Category.builder()
                    .name("Electronics")
                    .description("Electronic items")
                    .build();

            var category1 = Category.builder()
                    .name("Cellphones")
                    .description("Cellphones items")
                    .build();

            categoryRepository.saveAll(List.of(category, category1));

            var product = Product.builder()
                    .name("Iphone 15 Pro Max")
                    .description("The best and powerful smartphone")
                    .build();

//            repository.insert(product);
        };
    }
}
