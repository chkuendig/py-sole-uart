package com.google.common.util.concurrent.internal;

/* loaded from: classes5.dex */
public final class InternalFutures {
    public static Throwable tryInternalFastPathGetFailure(InternalFutureFailureAccess internalFutureFailureAccess) {
        return internalFutureFailureAccess.tryInternalFastPathGetFailure();
    }

    private InternalFutures() {
    }
}
