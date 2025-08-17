package com.mapache.shop.Domain.Product;

import com.mapache.shop.Domain.Shared.Image;
import java.util.Objects;
import java.util.Optional;

public class Review {

    private final Long id;
    private final ReviewRating reviewRating;
    private final ReviewText reviewText;
    private final Image reviewImage;

    public Review(Long id, ReviewRating reviewRating, ReviewText reviewText, Image reviewImage) {
        this.id = Objects.requireNonNull(id, "Id cannot be null when loading from DB");
        this.reviewRating = Objects.requireNonNull(reviewRating, "Rating cannot be null");
        this.reviewText = Objects.requireNonNull(reviewText, "Review text cannot be null");
        this.reviewImage = reviewImage;
    }

    public Review(ReviewRating reviewRating, ReviewText reviewText, Image reviewImage) {
        this.id = null;
        this.reviewRating = Objects.requireNonNull(reviewRating, "Rating cannot be null");
        this.reviewText = Objects.requireNonNull(reviewText, "Review text cannot be null");
        this.reviewImage = reviewImage;
    }

    public Long getId() {
        return id;
    }

    public ReviewRating getRating() {
        return reviewRating;
    }

    public ReviewText getReviewText() {
        return reviewText;
    }

    public Optional<Image> getReviewImage() {
        return Optional.ofNullable(reviewImage);
    }

    @Override
    public int hashCode() {
        return (id != null)
                ? Objects.hash(id)
                : Objects.hash(reviewRating, reviewText);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Review review)) return false;

        if (id != null && review.id != null) {
            return Objects.equals(id, review.id);
        }

        return Objects.equals(reviewRating, review.reviewRating)
                && Objects.equals(reviewText, review.reviewText);
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", rating=" + reviewRating +
                ", text=" + reviewText +
                ", hasImage=" + reviewImage +
                '}';
    }
}
