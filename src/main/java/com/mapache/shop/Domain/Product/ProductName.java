package com.mapache.shop.Domain.Product;

import java.util.Objects;

public class ProductName {

    private final String value;
    private static final String regex = "^[A-Za-zÁÉÍÓÚáéíóúÑñ ]{3,75}$";


    public ProductName(String productName)
    {
        if(productName == null || productName.isBlank())
        {
            throw new IllegalArgumentException("Category name cant be null or empty");
        }
        if(!productName.matches(regex))
        {
            throw new IllegalArgumentException("Category name must contain only letters and spaces, max 50 characters, minimum 3.");
        }

        this.value = productName;
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
        if(!(o instanceof ProductName productName)) return false;

        return Objects.equals(value, productName.value);
    }
}
