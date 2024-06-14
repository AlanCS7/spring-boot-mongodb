package io.github.alancs7.mongodb;

import io.github.alancs7.mongodb.domain.model.Product;
import io.github.alancs7.mongodb.domain.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MongodbApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongodbApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ProductRepository repository) {
        return args -> {
            Product product = Product.builder()
                    .name("Iphone 15 Pro Max")
                    .description("The best and powerful smartphone")
                    .build();

            repository.insert(product);
        };
    }
}
