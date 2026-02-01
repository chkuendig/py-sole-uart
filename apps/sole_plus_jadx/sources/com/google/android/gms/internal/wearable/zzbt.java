package com.google.android.gms.internal.wearable;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
final class zzbt {
    private final Object zza;
    private final int zzb;

    zzbt(Object obj, int i) {
        this.zza = obj;
        this.zzb = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzbt)) {
            return false;
        }
        zzbt zzbtVar = (zzbt) obj;
        return this.zza == zzbtVar.zza && this.zzb == zzbtVar.zzb;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.zza) * 65535) + this.zzb;
    }
}
