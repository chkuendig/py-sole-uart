package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.wearable.DataApi;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
public final /* synthetic */ class zzdd implements PendingResultUtil.ResultConverter {
    public static final /* synthetic */ zzdd zza = new zzdd();

    private /* synthetic */ zzdd() {
    }

    @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
    public final Object convert(Result result) {
        return new zzdg((DataApi.GetFdForAssetResult) result);
    }
}
