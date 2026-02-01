package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.0.0 */
/* loaded from: classes2.dex */
public final class zzpg implements zzpf {
    public static final zzhu<Boolean> zza;
    public static final zzhu<Boolean> zzb;

    static {
        zzhr zzhrVar = new zzhr(zzhk.zza("com.google.android.gms.measurement"));
        zza = zzhrVar.zze("measurement.module.pixie.ees", true);
        zzb = zzhrVar.zze("measurement.module.pixie.fix_array", true);
    }

    @Override // com.google.android.gms.internal.measurement.zzpf
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzpf
    public final boolean zzb() {
        return zza.zzb().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpf
    public final boolean zzc() {
        return zzb.zzb().booleanValue();
    }
}
