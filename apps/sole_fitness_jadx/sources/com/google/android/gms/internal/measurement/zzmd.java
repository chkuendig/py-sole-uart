package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.0.0 */
/* loaded from: classes2.dex */
final class zzmd extends zzmb<zzmc, zzmc> {
    zzmd() {
    }

    @Override // com.google.android.gms.internal.measurement.zzmb
    final /* synthetic */ int zza(zzmc zzmcVar) {
        return zzmcVar.zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzmb
    final /* synthetic */ int zzb(zzmc zzmcVar) {
        return zzmcVar.zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzmb
    final /* synthetic */ zzmc zzc(Object obj) {
        return ((zzjx) obj).zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzmb
    final /* bridge */ /* synthetic */ zzmc zzd(zzmc zzmcVar, zzmc zzmcVar2) {
        zzmc zzmcVar3 = zzmcVar2;
        return zzmcVar3.equals(zzmc.zzc()) ? zzmcVar : zzmc.zzd(zzmcVar, zzmcVar3);
    }

    @Override // com.google.android.gms.internal.measurement.zzmb
    final /* synthetic */ zzmc zze() {
        return zzmc.zze();
    }

    @Override // com.google.android.gms.internal.measurement.zzmb
    final /* bridge */ /* synthetic */ void zzf(zzmc zzmcVar, int i, long j) {
        zzmcVar.zzh(i << 3, Long.valueOf(j));
    }

    @Override // com.google.android.gms.internal.measurement.zzmb
    final void zzg(Object obj) {
        ((zzjx) obj).zzc.zzf();
    }

    @Override // com.google.android.gms.internal.measurement.zzmb
    final /* synthetic */ void zzh(Object obj, zzmc zzmcVar) {
        ((zzjx) obj).zzc = zzmcVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzmb
    final /* synthetic */ void zzi(zzmc zzmcVar, zzjf zzjfVar) throws IOException {
        zzmcVar.zzi(zzjfVar);
    }
}
