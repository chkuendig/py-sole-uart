package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.wearable.DataItemBuffer;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
public final /* synthetic */ class zzdc implements PendingResultUtil.ResultConverter {
    public static final /* synthetic */ zzdc zza = new zzdc();

    private /* synthetic */ zzdc() {
    }

    @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
    public final Object convert(Result result) {
        return (DataItemBuffer) result;
    }
}
