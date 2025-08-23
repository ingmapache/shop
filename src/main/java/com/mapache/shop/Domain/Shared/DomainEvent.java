package com.mapache.shop.Domain.Shared;

public interface DomainEvent {

    java.time.LocalDateTime ocurredAt();
    String eventType();
}
