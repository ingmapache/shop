package com.mapache.shop.Domain.Product;

import java.util.Objects;

public class ProductStock {
    private final int quantity;

    public ProductStock (Integer incStock)
    {
        Objects.requireNonNull(incStock, "Stock cannot be null.");

        if(incStock < 1) throw new IllegalArgumentException("Stock cannot be negative or have a value of less than 1.");
        this.quantity = incStock;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public ProductStock add(ProductStock stockToAdd)
    {
        Objects.requireNonNull(stockToAdd, "Stock to add cannot be null.");
        if(stockToAdd.getQuantity() < 1) throw new IllegalArgumentException("Stock to add must have quantity of at least 1.");

        return new ProductStock(quantity + stockToAdd.getQuantity());
    }

    public ProductStock remove(ProductStock stockToRemove)
    {
        Objects.requireNonNull(stockToRemove, "Stock to remove cannot be null.");
        if(stockToRemove.getQuantity() < 1) throw new IllegalArgumentException("Stock to remove must have quantity of at least 1.");
        if(quantity - stockToRemove.getQuantity() < 0) throw new IllegalArgumentException("There is not enough stock to remove requested quantity.");

        return new ProductStock(quantity - stockToRemove.getQuantity());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(quantity);
    }

    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(!(o instanceof ProductStock stock)) return false;

        return Objects.equals(quantity, stock.quantity);
    }

    @Override
    public String toString() {
        return String.valueOf(quantity);
    }
}
