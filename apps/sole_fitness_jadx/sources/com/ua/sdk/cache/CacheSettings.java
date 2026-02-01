package com.ua.sdk.cache;

import com.ua.sdk.internal.Precondition;

/* loaded from: classes2.dex */
public class CacheSettings {
    private final CachePolicy mDefaultPolicy;
    private final long mMaxCacheAge;

    public CacheSettings(CachePolicy cachePolicy, long j) {
        this.mDefaultPolicy = (CachePolicy) Precondition.isNotNull(cachePolicy);
        this.mMaxCacheAge = j;
    }

    public long getMaxCacheAge() {
        return this.mMaxCacheAge;
    }

    public CachePolicy getDefaultCachePolicy() {
        return this.mDefaultPolicy;
    }
}
