package com.google.android.gms.measurement.internal;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* compiled from: com.google.android.gms:play-services-measurement@@20.0.0 */
/* loaded from: classes2.dex */
public final class zzer extends zzki {
    public zzer(zzks zzksVar) {
        super(zzksVar);
    }

    public final boolean zza() {
        zzY();
        ConnectivityManager connectivityManager = (ConnectivityManager) this.zzs.zzau().getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = null;
        if (connectivityManager != null) {
            try {
                activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            } catch (SecurityException unused) {
            }
        }
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override // com.google.android.gms.measurement.internal.zzki
    protected final boolean zzb() {
        return false;
    }
}
