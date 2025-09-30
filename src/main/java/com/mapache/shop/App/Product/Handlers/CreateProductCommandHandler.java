package com.mapache.shop.App.Product.Handlers;

import com.mapache.shop.Domain.Product.Product;
import com.mapache.shop.Domain.Product.ProductFactory;
import com.mapache.shop.Domain.Product.ProductRepository;

public class CreateProductCommandHandler {
    private final ProductRepository repo;
    private final ProductFactory factory;

    public CreateProductCommandHandler(ProductRepository repo, ProductFactory factory)
    {
        this.repo = repo;
        this.factory = factory;
    }
}
