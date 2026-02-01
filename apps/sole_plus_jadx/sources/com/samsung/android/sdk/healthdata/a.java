package com.samsung.android.sdk.healthdata;

import com.samsung.android.sdk.healthdata.HealthResultHolder;

/* compiled from: HealthDataStore.java */
/* loaded from: classes5.dex */
class a implements HealthResultHolder.ResultListener<HealthResultHolder.BaseResult> {
    final /* synthetic */ IHealth a;
    final /* synthetic */ HealthDataStore b;

    a(HealthDataStore healthDataStore, IHealth iHealth) {
        this.b = healthDataStore;
        this.a = iHealth;
    }

    @Override // com.samsung.android.sdk.healthdata.HealthResultHolder.ResultListener
    public void onResult(HealthResultHolder.BaseResult baseResult) {
        if (baseResult.getStatus() != 1) {
            this.b.d.sendEmptyMessage(7);
            return;
        }
        this.b.c = this.a;
        this.b.d.sendEmptyMessage(-1);
    }
}
