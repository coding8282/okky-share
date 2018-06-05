package org.okky.share.domain;

public interface DomainEventBus {
    void fire(DomainEvent event);
}
