package com.squareup.otto;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

/* loaded from: classes2.dex */
class EventProducer {
    private final int hashCode;
    private final Method method;
    final Object target;
    private boolean valid = true;

    EventProducer(Object obj, Method method) {
        Objects.requireNonNull(obj, "EventProducer target cannot be null.");
        Objects.requireNonNull(method, "EventProducer method cannot be null.");
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

    public Object produceEvent() throws InvocationTargetException {
        if (!this.valid) {
            throw new IllegalStateException(toString() + " has been invalidated and can no longer produce events.");
        }
        try {
            return this.method.invoke(this.target, new Object[0]);
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
        return "[EventProducer " + this.method + "]";
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
        EventProducer eventProducer = (EventProducer) obj;
        return this.method.equals(eventProducer.method) && this.target == eventProducer.target;
    }
}
