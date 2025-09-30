package com.mapache.shop.App.Product.Commands;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class UpdateProductCommand {

    private final Long productId;
    private final String productName;
    private final String productBrand;
    private final Long categoryId;
    private final String productDescription;
    private final String productCurrency;
    private final BigDecimal productPrice;
    private final int productStock;
    private final int productLowStockQuantity;
    private final List<String> productImages;

    public UpdateProductCommand(
            Long incProductId,
            String incProductName,
            String incProductBrand,
            Long incCategoryId,
            String incProductDescription,
            String incProductCurrency,
            BigDecimal incProductPrice,
            int incProductStock,
            int incProductLowStockQuantity,
            List<String> incProductImages)
    {
        productId = Objects.requireNonNull(incProductId, "Product id cannot be null.");
        productName = incProductName;
        productBrand = incProductBrand;
        categoryId = incCategoryId;
        productDescription = incProductDescription;
        productCurrency = incProductCurrency;
        productPrice = incProductPrice;
        productStock = incProductStock;
        productLowStockQuantity = incProductLowStockQuantity;
        productImages = incProductImages;

    }

    public Long getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public String getProductCurrency() {
        return productCurrency;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public int getProductStock() {
        return productStock;
    }

    public int getProductLowStockQuantity() {
        return productLowStockQuantity;
    }

    public List<String> getProductImages() {
        return productImages;
    }
}
