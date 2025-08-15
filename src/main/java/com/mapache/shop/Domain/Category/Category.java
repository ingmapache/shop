package com.mapache.shop.Domain.Category;

import java.util.Objects;

public class Category {

    private Long id;
    private final CategoryName name;

    public Category(CategoryName categoryName)
    {
     if(categoryName == null)
     {
         throw new IllegalArgumentException("Category name cannot be null");
     }

     this.name = categoryName;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long incomingId)
    {
        this.id = incomingId;
    }

    public CategoryName getName()
    {
        return name;
    }

    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(!(o instanceof Category category)) return false;

        return Objects.equals(id, category.id) &&
                Objects.equals(name, category.name);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, name);
    }

    @Override
    public String toString()
    {
        return "Category{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
}
