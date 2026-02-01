package com.samsung.android.sdk.internal.healthdata;

import com.samsung.android.sdk.healthdata.HealthResultHolder;
import com.samsung.android.sdk.healthdata.HealthResultHolder.BaseResult;

/* loaded from: classes5.dex */
public interface RemoteResultListener<T extends HealthResultHolder.BaseResult> {
    void onReceiveHealthResult(int i, T t);
}
