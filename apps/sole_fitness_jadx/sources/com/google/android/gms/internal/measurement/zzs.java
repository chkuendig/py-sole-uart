package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@20.0.0 */
/* loaded from: classes2.dex */
final class zzs extends zzai {
    final boolean zza;
    final boolean zzb;
    final /* synthetic */ zzt zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzs(zzt zztVar, boolean z, boolean z2) {
        super("log");
        this.zzc = zztVar;
        this.zza = z;
        this.zzb = z2;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0083  */
    @Override // com.google.android.gms.internal.measurement.zzai
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzap zza(zzg zzgVar, List<zzap> list) {
        int i;
        zzh.zzi("log", 1, list);
        if (list.size() == 1) {
            this.zzc.zza.zza(3, zzgVar.zzb(list.get(0)).zzi(), Collections.emptyList(), this.zza, this.zzb);
            return zzf;
        }
        int iZzb = zzh.zzb(zzgVar.zzb(list.get(0)).zzh().doubleValue());
        int i2 = 3;
        if (iZzb != 2) {
            if (iZzb == 3) {
                i = 1;
            } else if (iZzb == 5) {
                i = 5;
            } else if (iZzb == 6) {
                i = 2;
            }
            String strZzi = zzgVar.zzb(list.get(1)).zzi();
            if (list.size() != 2) {
                this.zzc.zza.zza(i, strZzi, Collections.emptyList(), this.zza, this.zzb);
                return zzf;
            }
            ArrayList arrayList = new ArrayList();
            for (int i3 = 2; i3 < Math.min(list.size(), 5); i3++) {
                arrayList.add(zzgVar.zzb(list.get(i3)).zzi());
            }
            this.zzc.zza.zza(i, strZzi, arrayList, this.zza, this.zzb);
            return zzf;
        }
        i2 = 4;
        i = i2;
        String strZzi2 = zzgVar.zzb(list.get(1)).zzi();
        if (list.size() != 2) {
        }
    }
}
