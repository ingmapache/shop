package com.mapache.shop.App.Product.Commands;

import java.math.BigDecimal;
import java.util.List;

public class CreateProductCommand {
    private Long sellerId;
    private String productName;
    private String productBrand;
    private Long categoryId;
    private String productDescription;
    private String productCurrency;
    private BigDecimal productPrice;
    private int productStock;
    private int productLowStockQuantity;
    private List<String> productImages;

    public CreateProductCommand(
            Long incSellerId,
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
        sellerId = incSellerId;
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

    public Long getSellerId() {
        return sellerId;
    }

    public List<String> getProductImages() {
        return productImages;
    }

    public int getProductLowStockQuantity() {
        return productLowStockQuantity;
    }

    public int getProductStock() {
        return productStock;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public String getProductCurrency() {
        return productCurrency;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public String getProductName() {
        return productName;
    }
}
