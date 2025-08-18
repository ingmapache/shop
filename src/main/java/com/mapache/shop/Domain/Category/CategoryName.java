package com.mapache.shop.Domain.Category;

import java.util.Objects;

public class CategoryName {

    private final String value;
    private static final String REGEX = "^[A-Za-zÁÉÍÓÚáéíóúÑñ ]{3,50}$";

    public CategoryName(String categoryName) {
        if (categoryName == null || categoryName.isBlank()) {
            throw new IllegalArgumentException("Category name cannot be null or empty");
        }

        String normalized = categoryName.trim();

        if (!normalized.matches(REGEX)) {
            throw new IllegalArgumentException(
                    "Category name must contain only letters and spaces, between 3 and 50 characters."
            );
        }

        this.value = normalized;
    }

    public String getName() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CategoryName that)) return false;
        return Objects.equals(value, that.value);
    }
}
