package com.mapache.shop.Domain.Shared;

import java.math.BigDecimal;
import java.util.Objects;

public class Money {

    private final BigDecimal amount;
    private final String currency;

    public Money(BigDecimal incomingAmount, String incomingCurrency){
        if(incomingAmount == null)
        {
            throw new IllegalArgumentException("Amount cant be null.");
        }
        if(incomingAmount.compareTo(BigDecimal.ZERO) < 0)
        {
            throw new IllegalArgumentException("Amount cant be negative.");
        }
        if(incomingCurrency == null || incomingCurrency.isBlank())
        {
            throw new IllegalArgumentException("Currency cannot be null.");
        }
        this.amount = incomingAmount;
        this.currency = incomingCurrency;
    }

    public Money add(Money other)
    {
        validateSameCurrency(other);
        return new Money(this.amount.add(other.amount), this.currency);
    }

    public Money subtract(Money other)
    {
        validateSameCurrency(other);
        return new Money(this.amount.subtract(other.amount), this.currency);
    }

    public Money multiply(BigDecimal factor)
    {
        return new Money(this.amount.multiply(factor), this.currency);
    }

    private void validateSameCurrency(Money other)
    {
        if(!this.currency.equals(other.currency))
            throw new IllegalArgumentException("Currencies are not the same.");
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if(!(o instanceof Money money)) return false;

        return amount.compareTo(money.amount) == 0 &&
                Objects.equals(currency, money.currency);
    }

    @Override
    public String toString()
    {
        return amount + " " + currency;
    }
}
