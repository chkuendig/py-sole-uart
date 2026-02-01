package com.ua.sdk.util;

/* loaded from: classes2.dex */
public class SystemTimeSource implements TimeSource {
    @Override // com.ua.sdk.util.TimeSource
    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }
}
