package com.example.products.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductDTO(@NotBlank String name, @NotNull Integer price_in_cents) {
}
