package com.mapache.shop.Domain.Product;

import java.util.Objects;

public class ReviewRating {

    private final int value;

    public ReviewRating(int rating)
    {
        if(rating < 1 || rating > 5)
        {
            throw new IllegalArgumentException("Rating can only go from 1 to 5");
        }

        this.value = rating;
    }

    public int getValue()
    {
        return value;
    }

    public boolean isMax() {
        return value == 5;
    }

    public boolean isMin() {
        return value == 1;
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
        if(!(o instanceof  ReviewRating rating)) return false;

        return Objects.equals(value,rating.value);
    }

    @Override
    public String toString()
    {
        return value + " stars";
    }
}
