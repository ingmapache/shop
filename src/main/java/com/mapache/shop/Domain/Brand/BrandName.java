package com.mapache.shop.Domain.Brand;

import java.util.Objects;

public class BrandName {

    private final String value;

    public BrandName(String name)
    {
        if(name == null || name.isBlank())
        {
            throw new IllegalArgumentException("Brand name cannot be null.");
        }

        if(name.length() < 2 || name.length() > 25)
        {
            throw  new IllegalArgumentException("Brand name must be between 2 and 25 characers.");
        }

        if (!name.matches("^[A-Za-zÁÉÍÓÚáéíóúÑñ0-9 ]+$")) {
            throw new IllegalArgumentException("Brand name contains invalid characters.");
        }

        this.value = name;
    }

    public String getValue()
    {
        return this.value;
    }

    @Override
    public String toString()
    {
        return this.value;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(value);
    }

    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(!(o instanceof BrandName name)) return false;

        return Objects.equals(value, name.value);
    }
}
