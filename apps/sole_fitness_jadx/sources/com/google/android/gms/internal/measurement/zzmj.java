package com.google.android.gms.internal.measurement;

import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.0.0 */
/* loaded from: classes2.dex */
final class zzmj extends zzmk {
    zzmj(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.gms.internal.measurement.zzmk
    public final double zza(Object obj, long j) {
        return Double.longBitsToDouble(zzk(obj, j));
    }

    @Override // com.google.android.gms.internal.measurement.zzmk
    public final float zzb(Object obj, long j) {
        return Float.intBitsToFloat(zzj(obj, j));
    }

    /* JADX WARN: Failed to inline method: com.google.android.gms.internal.measurement.zzml.zzk(java.lang.Object, long, boolean):void */
    /* JADX WARN: Failed to inline method: com.google.android.gms.internal.measurement.zzml.zzl(java.lang.Object, long, boolean):void */
    /* JADX WARN: Unknown register number '(r5v0 'z' boolean)' in method call: com.google.android.gms.internal.measurement.zzml.zzk(java.lang.Object, long, boolean):void */
    /* JADX WARN: Unknown register number '(r5v0 'z' boolean)' in method call: com.google.android.gms.internal.measurement.zzml.zzl(java.lang.Object, long, boolean):void */
    @Override // com.google.android.gms.internal.measurement.zzmk
    public final void zzc(Object obj, long j, boolean z) {
        if (zzml.zzb) {
            zzml.zzk(obj, j, z);
        } else {
            zzml.zzl(obj, j, z);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzmk
    public final void zzd(Object obj, long j, byte b) {
        if (zzml.zzb) {
            zzml.zzD(obj, j, b);
        } else {
            zzml.zzE(obj, j, b);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzmk
    public final void zze(Object obj, long j, double d) {
        zzo(obj, j, Double.doubleToLongBits(d));
    }

    @Override // com.google.android.gms.internal.measurement.zzmk
    public final void zzf(Object obj, long j, float f) {
        zzn(obj, j, Float.floatToIntBits(f));
    }

    @Override // com.google.android.gms.internal.measurement.zzmk
    public final boolean zzg(Object obj, long j) {
        return zzml.zzb ? zzml.zzt(obj, j) : zzml.zzu(obj, j);
    }
}
