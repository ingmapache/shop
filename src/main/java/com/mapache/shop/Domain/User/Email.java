package com.mapache.shop.Domain.User;

import java.util.Objects;

public class Email {

    private final String value;
    private static final String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

    public Email(String incomingEmail)
    {
        if(incomingEmail == null || incomingEmail.isBlank())
        {
            throw new IllegalArgumentException("Email cannot be null.");
        }
        if(incomingEmail.matches(regex))
        {
            throw new IllegalArgumentException("Invalid email format. Must be a valid address like user@example.com");
        }

        this.value = incomingEmail;
    }

    public String getValue()
    {
        return value;
    }

    @Override
    public String toString()
    {
        return value;
    }

    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(!(o instanceof Email email)) return false;

        return Objects.equals(value, email.value);
    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode(value);
    }
}
