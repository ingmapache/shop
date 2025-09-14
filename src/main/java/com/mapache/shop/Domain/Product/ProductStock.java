package com.mapache.shop.Domain.Product;

import java.util.Objects;

public class ProductStock {
    private final int quantity;
    private final int lowStockQuantity;

    public ProductStock (Integer incStock, Integer incLowStockQuantity)
    {
        Objects.requireNonNull(incStock, "Stock cannot be null.");
        Objects.requireNonNull(incLowStockQuantity, "Low stock quantity cannot be null.");

        if(incStock < 1) throw new IllegalArgumentException("Stock cannot be negative or have a value of less than 1.");
        if(incLowStockQuantity < 0) throw new IllegalArgumentException("Low stock quantity cannot have a negative value.");

        this.quantity = incStock;
        this.lowStockQuantity = incLowStockQuantity;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public int getLowStockQuantity()
    {
        return lowStockQuantity;
    }

    public ProductStock add(ProductStock stockToAdd)
    {
        Objects.requireNonNull(stockToAdd, "Stock to add cannot be null.");
        if(stockToAdd.getQuantity() < 1) throw new IllegalArgumentException("Stock to add must have quantity of at least 1.");

        return new ProductStock(quantity + stockToAdd.getQuantity(), lowStockQuantity);
    }

    public ProductStock remove(ProductStock stockToRemove)
    {
        Objects.requireNonNull(stockToRemove, "Stock to remove cannot be null.");
        if(stockToRemove.getQuantity() < 1) throw new IllegalArgumentException("Stock to remove must have quantity of at least 1.");
        if(quantity - stockToRemove.getQuantity() < 0) throw new IllegalArgumentException("There is not enough stock to remove requested quantity.");

        return new ProductStock(quantity - stockToRemove.getQuantity(), lowStockQuantity);
    }

    public ProductStock updateLowStockQuantity(Integer incLowStockQuantity)
    {
        Objects.requireNonNull(incLowStockQuantity, "Quantity cannot be null.");
        if(incLowStockQuantity < 0) throw new IllegalArgumentException("Low stock quantity cannot be null or negative.");

        return new ProductStock(quantity, incLowStockQuantity);
    }

    public boolean isLow() {
        return quantity <= lowStockQuantity;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(quantity, lowStockQuantity);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductStock stock)) return false;
        return quantity == stock.quantity &&
                lowStockQuantity == stock.lowStockQuantity;
    }

    @Override
    public String toString() {
        return String.format("Stock: %d (Low stock threshold: %d)", quantity, lowStockQuantity);
    }
}
