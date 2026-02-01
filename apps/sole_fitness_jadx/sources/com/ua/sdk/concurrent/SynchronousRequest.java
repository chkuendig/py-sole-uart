package com.ua.sdk.concurrent;

import com.ua.sdk.Request;

/* loaded from: classes2.dex */
public class SynchronousRequest implements Request {
    public static final SynchronousRequest INSTANCE = new SynchronousRequest();

    @Override // com.ua.sdk.Request
    public boolean cancel() {
        return false;
    }

    @Override // com.ua.sdk.Request
    public boolean isAsynchronous() {
        return false;
    }

    @Override // com.ua.sdk.Request
    public boolean isCanceled() {
        return false;
    }

    private SynchronousRequest() {
    }
}
