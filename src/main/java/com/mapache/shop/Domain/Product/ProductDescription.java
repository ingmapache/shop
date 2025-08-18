package com.mapache.shop.Domain.Product;

import java.util.Objects;

public class ProductDescription {

    private final String value;

    private static final int MIN_LENGTH = 50;
    private static final int MAX_LENGTH = 1000;

    public ProductDescription(String description) {
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("Product description cannot be null or empty");
        }

        String normalized = description.trim();

        if (normalized.length() < MIN_LENGTH) {
            throw new IllegalArgumentException("Product description must be at least " + MIN_LENGTH + " characters long");
        }

        if (normalized.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("Product description must not exceed " + MAX_LENGTH + " characters");
        }

        this.value = normalized;
    }

    public String getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductDescription that)) return false;
        return Objects.equals(value, that.value);
    }

    @Override
    public String toString() {
        return value;
    }
}
