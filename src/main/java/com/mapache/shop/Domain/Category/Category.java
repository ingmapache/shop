package com.mapache.shop.Domain.Category;

import java.util.Objects;

public class Category {

    private final Long id;
    private final CategoryName name;

    public Category(CategoryName categoryName) {
        this.id = null;
        this.name = Objects.requireNonNull(categoryName, "Category name cannot be null");
    }

    public Category(Long id, CategoryName categoryName) {
        this.id = Objects.requireNonNull(id, "Category id cannot be null");
        this.name = Objects.requireNonNull(categoryName, "Category name cannot be null");
    }

    public Long getId() {
        return id;
    }

    public CategoryName getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category category)) return false;

        if (id != null && category.id != null) {
            return Objects.equals(id, category.id);
        }

        return Objects.equals(name, category.name);
    }

    @Override
    public int hashCode() {
        return (id != null) ? Objects.hash(id) : Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
}
