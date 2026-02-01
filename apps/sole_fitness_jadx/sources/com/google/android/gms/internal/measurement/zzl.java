package com.google.android.gms.internal.measurement;

import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@20.0.0 */
/* loaded from: classes2.dex */
public final class zzl extends zzam {
    private final zzab zzb;

    public zzl(zzab zzabVar) {
        this.zzb = zzabVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0051  */
    @Override // com.google.android.gms.internal.measurement.zzam, com.google.android.gms.internal.measurement.zzap
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzap zzbK(String str, zzg zzgVar, List<zzap> list) {
        char c;
        switch (str.hashCode()) {
            case 21624207:
                if (str.equals("getEventName")) {
                    c = 0;
                    break;
                } else {
                    c = 65535;
                    break;
                }
            case 45521504:
                if (str.equals("getTimestamp")) {
                    c = 3;
                    break;
                }
                break;
            case 146575578:
                if (str.equals("getParamValue")) {
                    c = 1;
                    break;
                }
                break;
            case 700587132:
                if (str.equals("getParams")) {
                    c = 2;
                    break;
                }
                break;
            case 920706790:
                if (str.equals("setParamValue")) {
                    c = 5;
                    break;
                }
                break;
            case 1570616835:
                if (str.equals("setEventName")) {
                    c = 4;
                    break;
                }
                break;
        }
        if (c == 0) {
            zzh.zzh("getEventName", 0, list);
            return new zzat(this.zzb.zzb().zzd());
        }
        if (c == 1) {
            zzh.zzh("getParamValue", 1, list);
            return zzi.zzb(this.zzb.zzb().zzc(zzgVar.zzb(list.get(0)).zzi()));
        }
        if (c == 2) {
            zzh.zzh("getParams", 0, list);
            Map<String, Object> mapZze = this.zzb.zzb().zze();
            zzam zzamVar = new zzam();
            for (String str2 : mapZze.keySet()) {
                zzamVar.zzr(str2, zzi.zzb(mapZze.get(str2)));
            }
            return zzamVar;
        }
        if (c == 3) {
            zzh.zzh("getTimestamp", 0, list);
            return new zzah(Double.valueOf(this.zzb.zzb().zza()));
        }
        if (c != 4) {
            if (c != 5) {
                return super.zzbK(str, zzgVar, list);
            }
            zzh.zzh("setParamValue", 2, list);
            String strZzi = zzgVar.zzb(list.get(0)).zzi();
            zzap zzapVarZzb = zzgVar.zzb(list.get(1));
            this.zzb.zzb().zzg(strZzi, zzh.zzf(zzapVarZzb));
            return zzapVarZzb;
        }
        zzh.zzh("setEventName", 1, list);
        zzap zzapVarZzb2 = zzgVar.zzb(list.get(0));
        if (zzf.equals(zzapVarZzb2) || zzg.equals(zzapVarZzb2)) {
            throw new IllegalArgumentException("Illegal event name");
        }
        this.zzb.zzb().zzf(zzapVarZzb2.zzi());
        return new zzat(zzapVarZzb2.zzi());
    }
}
