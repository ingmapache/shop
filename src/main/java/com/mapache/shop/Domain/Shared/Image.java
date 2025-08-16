package com.mapache.shop.Domain.Shared;

import java.util.Objects;
import java.util.regex.Pattern;

public class Image {

    private final String imageUrl;
    private final String alterText;
    private final String fileName;
    private static final Pattern URL_PATTERN = Pattern.compile("^(http|https)://.*$");
    private static final Pattern FILE_PATTERN = Pattern.compile("^[a-zA-Z0-9._-]+\\.(jpg|jpeg|png|webp)$");


    public Image(String imageUrl, String fileName, String alterText)
    {
        if(imageUrl == null || imageUrl.isBlank())
        {
            throw new IllegalArgumentException("Image URL cannot be null or blank.");
        }
        if (!URL_PATTERN.matcher(imageUrl).matches())
        {
            throw new IllegalArgumentException("Invalid image URL format.");
        }
        if (imageUrl.length() > 500)
        {
            throw new IllegalArgumentException("Image URL is too long.");
        }
        if(fileName == null || fileName.isBlank())
        {
            throw new IllegalArgumentException("Filename cannot be null or blank.");
        }
        if (fileName.length() > 50)
        {
            throw new IllegalArgumentException("File name must be 50 characters or less.");
        }
        if (!FILE_PATTERN.matcher(fileName).matches()) {
            throw new IllegalArgumentException("Invalid file name format. Allowed extensions: jpg, jpeg, png, webp");
        }
        if(alterText == null || alterText.isBlank())
        {
            throw new IllegalArgumentException("Alter text cannot be null or blank.");
        }
        if (alterText.length() > 50)
        {
            throw new IllegalArgumentException("Alter text must be 50 characters or less.");
        }

        this.imageUrl = imageUrl;
        this.alterText = alterText;
        this.fileName = fileName;
    }

    public String getUrl()
    {
        return imageUrl;
    }

    public String getFileName()
    {
        return fileName;
    }

    public String getAlterText()
    {
        return alterText;
    }

    @Override
    public int hashCode() {
        return Objects.hash(imageUrl, fileName, alterText);
    }

    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(!(o instanceof Image image)) return false;

        return Objects.equals(imageUrl, image.imageUrl)
                && Objects.equals(fileName, image.fileName)
                && Objects.equals(alterText, image.alterText);
    }

    @Override
    public String toString() {
        return "Image {" +
                "fileName='" + fileName + '\'' +
                ", url='" + imageUrl + '\'' +
                ", alterText='" + alterText + '\'' +
                '}';
    }
}
