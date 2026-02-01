package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.0.0 */
/* loaded from: classes2.dex */
final class zzja extends zzam {
    final /* synthetic */ zzjo zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzja(zzjo zzjoVar, zzgq zzgqVar) {
        super(zzgqVar);
        this.zza = zzjoVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzam
    public final void zzc() {
        this.zza.zzs.zzay().zzk().zza("Tasks have been queued for a long time");
    }
}
