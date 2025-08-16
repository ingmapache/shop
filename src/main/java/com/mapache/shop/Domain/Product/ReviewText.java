package com.mapache.shop.Domain.Product;

import java.util.Objects;

public class ReviewText {

    private final String value;

    public ReviewText(String incomingText)
    {
        if(incomingText == null || incomingText.isBlank())
        {
            throw new IllegalArgumentException("Review cannot be null");
        }
        if(incomingText.length() < 50)
        {
            throw new IllegalArgumentException("Review must have at least a length of 50 characters.");
        }
        if (incomingText.length() > 1000) {
            throw new IllegalArgumentException("Review cannot exceed 1000 characters.");
        }


        this.value = incomingText;
    }

    public String getValue()
    {
        return value;
    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode(value);
    }

    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(!(o instanceof ReviewText review)) return false;

        return Objects.equals(value, review.value);
    }
}
