package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.0.0 */
/* loaded from: classes2.dex */
final class zzji {
    private final Object zza;
    private final int zzb;

    zzji(Object obj, int i) {
        this.zza = obj;
        this.zzb = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzji)) {
            return false;
        }
        zzji zzjiVar = (zzji) obj;
        return this.zza == zzjiVar.zza && this.zzb == zzjiVar.zzb;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.zza) * 65535) + this.zzb;
    }
}
