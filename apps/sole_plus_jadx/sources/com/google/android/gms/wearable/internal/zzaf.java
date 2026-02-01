package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.CapabilityApi;
import com.google.android.gms.wearable.CapabilityInfo;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
final class zzaf implements CapabilityApi.CapabilityListener {
    final CapabilityApi.CapabilityListener zza;
    final String zzb;

    zzaf(CapabilityApi.CapabilityListener capabilityListener, String str) {
        this.zza = capabilityListener;
        this.zzb = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzaf zzafVar = (zzaf) obj;
        if (this.zza.equals(zzafVar.zza)) {
            return this.zzb.equals(zzafVar.zzb);
        }
        return false;
    }

    public final int hashCode() {
        return (this.zza.hashCode() * 31) + this.zzb.hashCode();
    }

    @Override // com.google.android.gms.wearable.CapabilityApi.CapabilityListener
    public final void onCapabilityChanged(CapabilityInfo capabilityInfo) {
        this.zza.onCapabilityChanged(capabilityInfo);
    }
}
