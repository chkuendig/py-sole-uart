package com.android;

import com.google.common.base.Preconditions;
import java.util.concurrent.CancellationException;

/* loaded from: classes3.dex */
public abstract class ProgressManagerAdapter {
    private static ProgressManagerAdapter ourInstance;

    protected abstract void doCheckCanceled();

    public static void checkCanceled() {
        ProgressManagerAdapter progressManagerAdapter = ourInstance;
        if (progressManagerAdapter != null) {
            progressManagerAdapter.doCheckCanceled();
        }
    }

    public static void throwIfCancellation(Throwable t) {
        ProgressManagerAdapter progressManagerAdapter = ourInstance;
        if (progressManagerAdapter == null) {
            throwIfCancellationException(t);
        } else {
            progressManagerAdapter.doThrowIfCancellation(t);
        }
    }

    protected void doThrowIfCancellation(Throwable t) {
        throwIfCancellationException(t);
    }

    private static void throwIfCancellationException(Throwable t) {
        if (t instanceof CancellationException) {
            throw ((CancellationException) t);
        }
    }

    protected static void setInstance(ProgressManagerAdapter instance) {
        Preconditions.checkState(ourInstance == null);
        ourInstance = instance;
    }
}
