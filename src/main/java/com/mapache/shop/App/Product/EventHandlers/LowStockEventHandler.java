package com.mapache.shop.App.Product.EventHandlers;

import com.mapache.shop.Domain.Product.Events.LowStockEvent;
import com.mapache.shop.Domain.Shared.DomainEventHandler;

public class LowStockEventHandler implements DomainEventHandler<LowStockEvent> {


    @Override
    public void handle(LowStockEvent event) {

    }
}
