package com.squareup.otto;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

/* loaded from: classes2.dex */
class EventHandler {
    private final int hashCode;
    private final Method method;
    private final Object target;
    private boolean valid = true;

    EventHandler(Object obj, Method method) {
        Objects.requireNonNull(obj, "EventHandler target cannot be null.");
        Objects.requireNonNull(method, "EventHandler method cannot be null.");
        this.target = obj;
        this.method = method;
        method.setAccessible(true);
        this.hashCode = ((method.hashCode() + 31) * 31) + obj.hashCode();
    }

    public boolean isValid() {
        return this.valid;
    }

    public void invalidate() {
        this.valid = false;
    }

    public void handleEvent(Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (!this.valid) {
            throw new IllegalStateException(toString() + " has been invalidated and can no longer handle events.");
        }
        try {
            this.method.invoke(this.target, obj);
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (InvocationTargetException e2) {
            if (e2.getCause() instanceof Error) {
                throw ((Error) e2.getCause());
            }
            throw e2;
        }
    }

    public String toString() {
        return "[EventHandler " + this.method + "]";
    }

    public int hashCode() {
        return this.hashCode;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        EventHandler eventHandler = (EventHandler) obj;
        return this.method.equals(eventHandler.method) && this.target == eventHandler.target;
    }
}
