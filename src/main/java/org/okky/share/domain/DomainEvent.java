package org.okky.share.domain;

import org.okky.share.util.JsonUtil;

import static java.lang.System.currentTimeMillis;

public abstract class DomainEvent {
    protected long publishedOn = currentTimeMillis();

    @Override
    public String toString() {
        return JsonUtil.toPrettyJson(this);
    }
}
