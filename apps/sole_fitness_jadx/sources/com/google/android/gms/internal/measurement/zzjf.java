package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.0.0 */
/* loaded from: classes2.dex */
final class zzjf {
    private final zzje zza;

    private zzjf(zzje zzjeVar) {
        zzkf.zzf(zzjeVar, "output");
        this.zza = zzjeVar;
        zzjeVar.zza = this;
    }

    public static zzjf zza(zzje zzjeVar) {
        zzjf zzjfVar = zzjeVar.zza;
        return zzjfVar != null ? zzjfVar : new zzjf(zzjeVar);
    }

    public final void zzA(int i, int i2) throws IOException {
        this.zza.zzp(i, (i2 >> 31) ^ (i2 + i2));
    }

    public final void zzC(int i, long j) throws IOException {
        this.zza.zzr(i, (j >> 63) ^ (j + j));
    }

    @Deprecated
    public final void zzE(int i) throws IOException {
        this.zza.zzo(i, 3);
    }

    public final void zzF(int i, String str) throws IOException {
        this.zza.zzm(i, str);
    }

    public final void zzG(int i, List<String> list) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzkm)) {
            while (i2 < list.size()) {
                this.zza.zzm(i, list.get(i2));
                i2++;
            }
            return;
        }
        zzkm zzkmVar = (zzkm) list;
        while (i2 < list.size()) {
            Object objZzf = zzkmVar.zzf(i2);
            if (objZzf instanceof String) {
                this.zza.zzm(i, (String) objZzf);
            } else {
                this.zza.zze(i, (zzix) objZzf);
            }
            i2++;
        }
    }

    public final void zzH(int i, int i2) throws IOException {
        this.zza.zzp(i, i2);
    }

    public final void zzJ(int i, long j) throws IOException {
        this.zza.zzr(i, j);
    }

    public final void zzb(int i, boolean z) throws IOException {
        this.zza.zzd(i, z);
    }

    public final void zzd(int i, zzix zzixVar) throws IOException {
        this.zza.zze(i, zzixVar);
    }

    public final void zze(int i, List<zzix> list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.zza.zze(i, list.get(i2));
        }
    }

    public final void zzf(int i, double d) throws IOException {
        this.zza.zzh(i, Double.doubleToRawLongBits(d));
    }

    @Deprecated
    public final void zzh(int i) throws IOException {
        this.zza.zzo(i, 4);
    }

    public final void zzi(int i, int i2) throws IOException {
        this.zza.zzj(i, i2);
    }

    public final void zzk(int i, int i2) throws IOException {
        this.zza.zzf(i, i2);
    }

    public final void zzm(int i, long j) throws IOException {
        this.zza.zzh(i, j);
    }

    public final void zzo(int i, float f) throws IOException {
        this.zza.zzf(i, Float.floatToRawIntBits(f));
    }

    public final void zzq(int i, Object obj, zzln zzlnVar) throws IOException {
        zzje zzjeVar = this.zza;
        zzjeVar.zzo(i, 3);
        zzlnVar.zzm((zzlc) obj, zzjeVar.zza);
        zzjeVar.zzo(i, 4);
    }

    public final void zzr(int i, int i2) throws IOException {
        this.zza.zzj(i, i2);
    }

    public final void zzt(int i, long j) throws IOException {
        this.zza.zzr(i, j);
    }

    public final void zzv(int i, Object obj, zzln zzlnVar) throws IOException {
        zzlc zzlcVar = (zzlc) obj;
        zzjc zzjcVar = (zzjc) this.zza;
        zzjcVar.zzq((i << 3) | 2);
        zzih zzihVar = (zzih) zzlcVar;
        int iZzbo = zzihVar.zzbo();
        if (iZzbo == -1) {
            iZzbo = zzlnVar.zza(zzihVar);
            zzihVar.zzbr(iZzbo);
        }
        zzjcVar.zzq(iZzbo);
        zzlnVar.zzm(zzlcVar, zzjcVar.zza);
    }

    public final void zzw(int i, int i2) throws IOException {
        this.zza.zzf(i, i2);
    }

    public final void zzy(int i, long j) throws IOException {
        this.zza.zzh(i, j);
    }

    public final void zzB(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                zzje zzjeVar = this.zza;
                int iIntValue = list.get(i2).intValue();
                zzjeVar.zzp(i, (iIntValue >> 31) ^ (iIntValue + iIntValue));
                i2++;
            }
            return;
        }
        this.zza.zzo(i, 2);
        int iZzA = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            int iIntValue2 = list.get(i3).intValue();
            iZzA += zzje.zzA((iIntValue2 >> 31) ^ (iIntValue2 + iIntValue2));
        }
        this.zza.zzq(iZzA);
        while (i2 < list.size()) {
            zzje zzjeVar2 = this.zza;
            int iIntValue3 = list.get(i2).intValue();
            zzjeVar2.zzq((iIntValue3 >> 31) ^ (iIntValue3 + iIntValue3));
            i2++;
        }
    }

    public final void zzD(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                zzje zzjeVar = this.zza;
                long jLongValue = list.get(i2).longValue();
                zzjeVar.zzr(i, (jLongValue >> 63) ^ (jLongValue + jLongValue));
                i2++;
            }
            return;
        }
        this.zza.zzo(i, 2);
        int iZzB = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            long jLongValue2 = list.get(i3).longValue();
            iZzB += zzje.zzB((jLongValue2 >> 63) ^ (jLongValue2 + jLongValue2));
        }
        this.zza.zzq(iZzB);
        while (i2 < list.size()) {
            zzje zzjeVar2 = this.zza;
            long jLongValue3 = list.get(i2).longValue();
            zzjeVar2.zzs((jLongValue3 >> 63) ^ (jLongValue3 + jLongValue3));
            i2++;
        }
    }

    public final void zzI(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzp(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        this.zza.zzo(i, 2);
        int iZzA = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzA += zzje.zzA(list.get(i3).intValue());
        }
        this.zza.zzq(iZzA);
        while (i2 < list.size()) {
            this.zza.zzq(list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzK(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzr(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        this.zza.zzo(i, 2);
        int iZzB = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzB += zzje.zzB(list.get(i3).longValue());
        }
        this.zza.zzq(iZzB);
        while (i2 < list.size()) {
            this.zza.zzs(list.get(i2).longValue());
            i2++;
        }
    }

    public final void zzc(int i, List<Boolean> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzd(i, list.get(i2).booleanValue());
                i2++;
            }
            return;
        }
        this.zza.zzo(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            list.get(i4).booleanValue();
            i3++;
        }
        this.zza.zzq(i3);
        while (i2 < list.size()) {
            this.zza.zzb(list.get(i2).booleanValue() ? (byte) 1 : (byte) 0);
            i2++;
        }
    }

    public final void zzj(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzj(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        this.zza.zzo(i, 2);
        int iZzv = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzv += zzje.zzv(list.get(i3).intValue());
        }
        this.zza.zzq(iZzv);
        while (i2 < list.size()) {
            this.zza.zzk(list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzl(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzf(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        this.zza.zzo(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            list.get(i4).intValue();
            i3 += 4;
        }
        this.zza.zzq(i3);
        while (i2 < list.size()) {
            this.zza.zzg(list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzn(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzh(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        this.zza.zzo(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            list.get(i4).longValue();
            i3 += 8;
        }
        this.zza.zzq(i3);
        while (i2 < list.size()) {
            this.zza.zzi(list.get(i2).longValue());
            i2++;
        }
    }

    public final void zzs(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzj(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        this.zza.zzo(i, 2);
        int iZzv = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzv += zzje.zzv(list.get(i3).intValue());
        }
        this.zza.zzq(iZzv);
        while (i2 < list.size()) {
            this.zza.zzk(list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzu(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzr(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        this.zza.zzo(i, 2);
        int iZzB = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzB += zzje.zzB(list.get(i3).longValue());
        }
        this.zza.zzq(iZzB);
        while (i2 < list.size()) {
            this.zza.zzs(list.get(i2).longValue());
            i2++;
        }
    }

    public final void zzx(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzf(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        this.zza.zzo(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            list.get(i4).intValue();
            i3 += 4;
        }
        this.zza.zzq(i3);
        while (i2 < list.size()) {
            this.zza.zzg(list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzz(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzh(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        this.zza.zzo(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            list.get(i4).longValue();
            i3 += 8;
        }
        this.zza.zzq(i3);
        while (i2 < list.size()) {
            this.zza.zzi(list.get(i2).longValue());
            i2++;
        }
    }

    public final void zzg(int i, List<Double> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzh(i, Double.doubleToRawLongBits(list.get(i2).doubleValue()));
                i2++;
            }
            return;
        }
        this.zza.zzo(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            list.get(i4).doubleValue();
            i3 += 8;
        }
        this.zza.zzq(i3);
        while (i2 < list.size()) {
            this.zza.zzi(Double.doubleToRawLongBits(list.get(i2).doubleValue()));
            i2++;
        }
    }

    public final void zzp(int i, List<Float> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzf(i, Float.floatToRawIntBits(list.get(i2).floatValue()));
                i2++;
            }
            return;
        }
        this.zza.zzo(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            list.get(i4).floatValue();
            i3 += 4;
        }
        this.zza.zzq(i3);
        while (i2 < list.size()) {
            this.zza.zzg(Float.floatToRawIntBits(list.get(i2).floatValue()));
            i2++;
        }
    }
}
