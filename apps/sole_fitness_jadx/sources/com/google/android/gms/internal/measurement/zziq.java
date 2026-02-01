package com.google.android.gms.internal.measurement;

import java.util.Comparator;
import kotlin.UByte;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.0.0 */
/* loaded from: classes2.dex */
final class zziq implements Comparator<zzix> {
    zziq() {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzix zzixVar, zzix zzixVar2) {
        zzix zzixVar3 = zzixVar;
        zzix zzixVar4 = zzixVar2;
        zzio zzioVar = new zzio(zzixVar3);
        zzio zzioVar2 = new zzio(zzixVar4);
        while (zzioVar.hasNext() && zzioVar2.hasNext()) {
            int iZza = zzip.zza(zzioVar.zza() & UByte.MAX_VALUE, zzioVar2.zza() & UByte.MAX_VALUE);
            if (iZza != 0) {
                return iZza;
            }
        }
        return zzip.zza(zzixVar3.zzd(), zzixVar4.zzd());
    }
}
