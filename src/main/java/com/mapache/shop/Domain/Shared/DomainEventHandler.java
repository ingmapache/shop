package com.mapache.shop.Domain.Shared;

public interface DomainEventHandler<T extends DomainEvent> {

    void handle(T event);
}
