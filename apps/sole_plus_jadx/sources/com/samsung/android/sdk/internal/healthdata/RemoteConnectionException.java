package com.samsung.android.sdk.internal.healthdata;

/* loaded from: classes5.dex */
public class RemoteConnectionException extends IllegalStateException {
    public RemoteConnectionException(Throwable th) {
        super("A remote-invocation error occurs on the connection", th);
    }

    public RemoteConnectionException(String str) {
        super(str);
    }
}
