package com.google.android.gms.common.api;

import com.google.android.gms.common.Feature;

/* compiled from: com.google.android.gms:play-services-basement@@18.9.0 */
/* loaded from: classes4.dex */
public final class UnsupportedApiCallException extends UnsupportedOperationException {
    private final Feature zza;

    public UnsupportedApiCallException(Feature feature) {
        this.zza = feature;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String strValueOf = String.valueOf(this.zza);
        String.valueOf(strValueOf);
        return "Missing ".concat(String.valueOf(strValueOf));
    }
}
