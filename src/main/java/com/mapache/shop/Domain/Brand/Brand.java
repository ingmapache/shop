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

    public BrandName getBrandName() {
        return brandName;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, brandName);
    }

    @Override
    public boolean equals(Object o)
    {

    }
}
