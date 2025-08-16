package com.mapache.shop.Domain.Category;

import java.util.Objects;

public class CategoryName {

    private final String value;
    private static final String regex = "^[A-Za-zÁÉÍÓÚáéíóúÑñ ]{3,50}$";


    public CategoryName(String categoryName)
    {
        if(categoryName == null || categoryName.isBlank())
        {
            throw new IllegalArgumentException("Category name cant be null or empty");
        }
        if(!categoryName.matches(regex))
        {
            throw new IllegalArgumentException("Category name must contain only letters and spaces, max 50 characters, minimum 3.");
        }

        this.value = categoryName;
    }

    public String getName()
    {
        return value;
    }

    @Override
    public String toString()
    {
        return value;
    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode(value);
    }

    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(!(o instanceof CategoryName categoryName)) return false;

        return Objects.equals(value, categoryName.value);
    }
}
