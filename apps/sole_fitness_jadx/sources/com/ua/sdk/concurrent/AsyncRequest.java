package com.ua.sdk.concurrent;

import com.ua.sdk.Request;
import com.ua.sdk.UaException;
import java.util.concurrent.Future;

/* loaded from: classes2.dex */
public abstract class AsyncRequest<T> implements Request {
    boolean canceled = false;
    boolean done = false;
    Future<?> future = null;

    @Override // com.ua.sdk.Request
    public boolean isAsynchronous() {
        return false;
    }

    abstract void onDone(T t, UaException uaException);

    @Override // com.ua.sdk.Request
    public synchronized boolean cancel() {
        if (this.done) {
            return false;
        }
        Future<?> future = this.future;
        if (future != null) {
            future.cancel(true);
        }
        this.canceled = true;
        onDone(null, new UaException(UaException.Code.CANCELED));
        return true;
    }

    @Override // com.ua.sdk.Request
    public boolean isCanceled() {
        return this.canceled;
    }

    public synchronized void setFuture(Future<?> future) {
        this.future = future;
        if (this.canceled) {
            future.cancel(true);
        }
    }

    public synchronized void done(T t, UaException uaException) {
        if (!this.canceled) {
            onDone(t, uaException);
            this.done = true;
        }
    }
}
