package com.android.prefs;

import com.android.utils.EnvironmentProvider;
import com.android.utils.StdLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidLocationsSingleton.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/android/prefs/AndroidLocationsSingleton;", "Lcom/android/prefs/AbstractAndroidLocations;", "()V", "common"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class AndroidLocationsSingleton extends AbstractAndroidLocations {
    public static final AndroidLocationsSingleton INSTANCE = new AndroidLocationsSingleton();

    /* JADX WARN: Illegal instructions before constructor call */
    private AndroidLocationsSingleton() {
        EnvironmentProvider.DirectEnvironmentProvider DIRECT = EnvironmentProvider.DIRECT;
        Intrinsics.checkNotNullExpressionValue(DIRECT, "DIRECT");
        super(DIRECT, new StdLogger(StdLogger.Level.VERBOSE), true);
    }
}
