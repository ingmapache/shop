package com.mapache.shop.Domain.Product;

import com.mapache.shop.Domain.Shared.Image;
import java.util.Objects;
import java.util.Optional;

public class Review {

    private final Long id;
    private final Long userId;
    private ReviewRating reviewRating;
    private ReviewText reviewText;
    private Image reviewImage;

    public Review(Long incId, Long incUserid, ReviewRating reviewRating, ReviewText reviewText, Image reviewImage) {
        this.id = Objects.requireNonNull(incId, "Id cannot be null when loading from DB");
        this.userId = Objects.requireNonNull(incUserid, "User id cannot be null.");
        this.reviewRating = Objects.requireNonNull(reviewRating, "Rating cannot be null");
        this.reviewText = Objects.requireNonNull(reviewText, "Review text cannot be null");
        this.reviewImage = reviewImage;
    }

    public Review(ReviewRating reviewRating, Long incUserid, ReviewText reviewText, Image reviewImage) {
        this.id = null;
        this.userId = Objects.requireNonNull(incUserid, "User id cannot be null.");
        this.reviewRating = Objects.requireNonNull(reviewRating, "Rating cannot be null");
        this.reviewText = Objects.requireNonNull(reviewText, "Review text cannot be null");
        this.reviewImage = reviewImage;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId(){
        return userId;
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

    public void updateRating(ReviewRating newRating)
    {
        if(newRating == null)
        {
            throw new IllegalArgumentException("New rating cannot be null.");
        }

        this.reviewRating = newRating;
    }

    public void updateReviewText(ReviewText newText)
    {
        if(newText == null)
        {
            throw new IllegalArgumentException("New text cannot be null.");
        }

        this.reviewText = newText;
    }

    public void updateImage(Image newImage)
    {
        this.reviewImage = newImage;
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
