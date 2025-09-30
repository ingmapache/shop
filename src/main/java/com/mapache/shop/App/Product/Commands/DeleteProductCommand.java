package com.mapache.shop.App.Product.Commands;

import java.util.Objects;

public class DeleteProductCommand {

    private final Long productId;
    private final String productName;

    public DeleteProductCommand(Long incProductId, String incProductName)
    {
        this.productId = Objects.requireNonNull(incProductId, "Product id cannot be null.");
        this.productName = Objects.requireNonNull(incProductName, "Product name cannot be null.");
    }

    public Long getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }
}
