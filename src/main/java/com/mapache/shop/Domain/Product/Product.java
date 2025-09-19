package com.mapache.shop.Domain.Product;

import com.mapache.shop.Domain.Brand.Brand;
import com.mapache.shop.Domain.Category.Category;
import com.mapache.shop.Domain.Product.Events.LowStockEvent;
import com.mapache.shop.Domain.Product.Events.OutOfStockEvent;
import com.mapache.shop.Domain.Shared.DomainEvent;
import com.mapache.shop.Domain.Shared.Image;
import com.mapache.shop.Domain.Shared.Money;

import java.util.*;

public class Product {
    private final Long id;
    private final Long sellerId;
    private ProductName productName;
    private Brand productBrand;
    private ProductDescription productDescription;
    private Money productPrice;
    private ProductStock productStock;
    private List<Image> productImages;
    private Category productCategory;

    private final  List<DomainEvent> domainEvents = new ArrayList<>();

    public Product(
            Long incSellerId,
            ProductName incproductName,
            Brand incProductBrand,
            Category incCategory,
            ProductDescription incProductDescription,
            Money incProductPrice,
            ProductStock incStock,
            List<Image> incProductImages)
    {
        this.id = null;
        this.sellerId = Objects.requireNonNull(incSellerId, "Seller id cannot be null.");
        if (incSellerId <= 0) throw new IllegalArgumentException("Seller id must be greater than 0.");

        this.productName = Objects.requireNonNull(incproductName, "Product name cannot be null");
        this.productBrand = Objects.requireNonNull(incProductBrand, "Product brand cannot be null.");
        this.productCategory = Objects.requireNonNull(incCategory, "Product category cannot be null.");
        this.productDescription = Objects.requireNonNull(incProductDescription, "Product description cannot be null");
        this.productPrice = Objects.requireNonNull(incProductPrice, "Product price cannot be null.");
        this.productStock = Objects.requireNonNull(incStock, "Product stock cannot be null.");
        this.productImages = Objects.requireNonNull(incProductImages, "Product must have at least one picture.");
    }

    public Product(
            Long incId,
            Long incSellerId,
            ProductName incProductName,
            Brand incProductBrand,
            Category incCategory,
            ProductDescription incProductDescription,
            Money incProductPrice,
            ProductStock incStock,
            List<Image> incProductImages
    ) {
        this.id = Objects.requireNonNull(incId, "Id cannot be null");
        if (incId <= 0) throw new IllegalArgumentException("Id must be greater than 0.");

        this.sellerId = Objects.requireNonNull(incSellerId, "Seller id cannot be null.");
        if (incSellerId <= 0) throw new IllegalArgumentException("Seller id must be greater than 0.");

        this.productName = Objects.requireNonNull(incProductName, "Product name cannot be null");
        this.productBrand = Objects.requireNonNull(incProductBrand, "Product brand cannot be null.");
        this.productCategory = Objects.requireNonNull(incCategory, "Product category cannot be null.");
        this.productDescription = Objects.requireNonNull(incProductDescription, "Product description cannot be null");
        this.productPrice = Objects.requireNonNull(incProductPrice, "Product price cannot be null.");
        this.productImages = Objects.requireNonNull(incProductImages, "Product images cannot be null.");
        this.productStock = Objects.requireNonNull(incStock, "Product stock cannot be null.");

        if (incProductImages.isEmpty()) {
            throw new IllegalArgumentException("Product must have at least one picture.");
        }
    }

    public Optional<Long> getId() {
        return Optional.ofNullable(id);
    }

    public ProductName getProductName()
    {
        return productName;
    }

    public Brand getProductBrand()
    {
        return productBrand;
    }

    public Category getProductCategory()
    {
        return productCategory;
    }

    public ProductDescription getProductDescription()
    {
        return productDescription;
    }

    public Money getProductPrice()
    {
        return productPrice;
    }

    public List<Image> getProductImages()
    {
        return List.copyOf(productImages);
    }

    public ProductStock getProductStock()
    {
        return productStock;
    }

    public void addStock(ProductStock stockToAdd)
    {
        productStock = productStock.add(stockToAdd);
    }

    public void removeStock(ProductStock stockToRemove, Long sellerId)
    {
        productStock = productStock.remove(stockToRemove);

        if(productStock.getQuantity() == 0)
        {
            domainEvents.add(new OutOfStockEvent(sellerId, id, productName));
        } else if (productStock.getQuantity() <= productStock.getLowStockQuantity())
        {
            domainEvents.add(new LowStockEvent(id,productName, sellerId, productStock));
        }
    }

    public void renameProduct(ProductName newProductName)
    {
        productName = Objects.requireNonNull(newProductName, "New product name cannot be null.");;
    }

    public void updateProductBrand(Brand newBrand)
    {
        productBrand = Objects.requireNonNull(newBrand, "New product brand cannot be null.");
    }

    public void updateProductCategory(Category newCategory)
    {
        productCategory = Objects.requireNonNull(newCategory, "New category cannot be null.");
    }

    public void updateProductPrice(Money newPrice)
    {
        productPrice = Objects.requireNonNull(newPrice, "New product price cannot be null.");
    }

    public void updateProductDescription(ProductDescription newDescription)
    {
        productDescription = Objects.requireNonNull(newDescription, "New description cannot be null.");
    }

    public void addImage(Image newImage)
    {
        Objects.requireNonNull(newImage, "Image to add cannot be null.");
        productImages.add(newImage);
    }

    public void removeImage(Image imageToRemove)
    {
        Objects.requireNonNull(imageToRemove);

        if(!productImages.contains(imageToRemove)) throw new IllegalArgumentException("Image to remove was not found in selected product.");

        productImages.remove(imageToRemove);
    }

    protected void addDomainEvent(DomainEvent event) {
        domainEvents.add(event);
    }

    public List<DomainEvent> pullDomainEvents()
    {
        List<DomainEvent> eventsToPublish = Collections.unmodifiableList(domainEvents);
        domainEvents.clear();

        return eventsToPublish;
    }
}
