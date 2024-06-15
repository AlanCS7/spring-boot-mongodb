package io.github.alancs7.mongodb.api.dto;

import lombok.Builder;

@Builder
public record ProductDto(String name,
                         String description) {
}
