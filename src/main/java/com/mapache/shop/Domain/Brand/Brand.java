package com.mapache.shop.Domain.Brand;

import java.util.Objects;

public class Brand {

    private final Long id;
    private BrandName brandName;

    public Brand(Long incomingId, BrandName incomingBrandName)
    {
        if(incomingId == null || incomingId <= 0)
        {
            throw new IllegalArgumentException("Id is not valid");
        }

        if(incomingBrandName == null)
        {
            throw new IllegalArgumentException("Brand name cannot be null.");
        }

        this.id = incomingId;
        this.brandName = incomingBrandName;
    }

    public Brand(BrandName incomingBrandName)
    {

        if(incomingBrandName == null)
        {
            throw new IllegalArgumentException("Brand name cannot be null.");
        }

        this.id = null;
        this.brandName = incomingBrandName;
    }

    public BrandName getBrandName() {
        return brandName;
    }

    public Long getId()
    {
        return id;
    }

    public void renameBrand(BrandName incomingBrandName)
    {
        if(incomingBrandName == null)
        {
            throw new IllegalArgumentException("Brand name cannot be null.");
        }

        this.brandName = incomingBrandName;
    }

    @Override
    public int hashCode()
    {
        return (id != null) ? Objects.hash(id) : Objects.hash(brandName);
    }

    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(!(o instanceof Brand brand)) return false;

        if (id != null && brand.id != null) {
            return Objects.equals(id, brand.id);
        }

        return Objects.equals(brandName, brand.brandName);
    }

    @Override
    public String toString()
    {
        return "Brand{" +
                "id=" + id +
                ", name=" + brandName.getValue() +
                '}';
    }
}
