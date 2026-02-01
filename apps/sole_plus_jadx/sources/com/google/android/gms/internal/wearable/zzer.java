package com.google.android.gms.internal.wearable;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
final class zzer extends zzep {
    zzer() {
    }

    @Override // com.google.android.gms.internal.wearable.zzep
    final /* synthetic */ int zza(Object obj) {
        return ((zzeq) obj).zza();
    }

    @Override // com.google.android.gms.internal.wearable.zzep
    final /* synthetic */ int zzb(Object obj) {
        return ((zzeq) obj).zzb();
    }

    @Override // com.google.android.gms.internal.wearable.zzep
    final /* bridge */ /* synthetic */ Object zzc(Object obj) {
        zzcg zzcgVar = (zzcg) obj;
        zzeq zzeqVar = zzcgVar.zzc;
        if (zzeqVar != zzeq.zzc()) {
            return zzeqVar;
        }
        zzeq zzeqVarZzf = zzeq.zzf();
        zzcgVar.zzc = zzeqVarZzf;
        return zzeqVarZzf;
    }

    @Override // com.google.android.gms.internal.wearable.zzep
    final /* synthetic */ Object zzd(Object obj) {
        return ((zzcg) obj).zzc;
    }

    @Override // com.google.android.gms.internal.wearable.zzep
    final /* bridge */ /* synthetic */ Object zze(Object obj, Object obj2) {
        if (zzeq.zzc().equals(obj2)) {
            return obj;
        }
        if (zzeq.zzc().equals(obj)) {
            return zzeq.zze((zzeq) obj, (zzeq) obj2);
        }
        ((zzeq) obj).zzd((zzeq) obj2);
        return obj;
    }

    @Override // com.google.android.gms.internal.wearable.zzep
    final /* bridge */ /* synthetic */ void zzf(Object obj, int i, long j) {
        ((zzeq) obj).zzj(i << 3, Long.valueOf(j));
    }

    @Override // com.google.android.gms.internal.wearable.zzep
    final void zzg(Object obj) {
        ((zzcg) obj).zzc.zzh();
    }

    @Override // com.google.android.gms.internal.wearable.zzep
    final /* synthetic */ void zzh(Object obj, Object obj2) {
        ((zzcg) obj).zzc = (zzeq) obj2;
    }

    @Override // com.google.android.gms.internal.wearable.zzep
    final /* synthetic */ void zzi(Object obj, zzfh zzfhVar) throws IOException {
        ((zzeq) obj).zzk(zzfhVar);
    }
}
