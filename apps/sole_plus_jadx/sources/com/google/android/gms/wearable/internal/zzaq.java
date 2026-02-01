package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.CapabilityClient;
import com.google.android.gms.wearable.CapabilityInfo;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
final class zzaq implements CapabilityClient.OnCapabilityChangedListener {
    final CapabilityClient.OnCapabilityChangedListener zza;
    final String zzb;

    zzaq(CapabilityClient.OnCapabilityChangedListener onCapabilityChangedListener, String str) {
        this.zza = onCapabilityChangedListener;
        this.zzb = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzaq zzaqVar = (zzaq) obj;
        if (this.zza.equals(zzaqVar.zza)) {
            return this.zzb.equals(zzaqVar.zzb);
        }
        return false;
    }

    public final int hashCode() {
        return (this.zza.hashCode() * 31) + this.zzb.hashCode();
    }

    @Override // com.google.android.gms.wearable.CapabilityClient.OnCapabilityChangedListener, com.google.android.gms.wearable.CapabilityApi.CapabilityListener
    public final void onCapabilityChanged(CapabilityInfo capabilityInfo) {
        this.zza.onCapabilityChanged(capabilityInfo);
    }
}
