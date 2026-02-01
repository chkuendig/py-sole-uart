package com.google.android.gms.internal.measurement;

import androidx.camera.video.AudioStats;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement@@22.0.2 */
/* loaded from: classes4.dex */
public final class zzas implements zzaq, Iterable<zzaq> {
    private final String zza;

    public final int hashCode() {
        return this.zza.hashCode();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0316  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x03c7  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0458  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x04a2  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x04b6  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x04cc  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x052e  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0542  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0593  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x05aa  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x05e3  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x0629  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x063f  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x0649  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c6 A[PHI: r19
      0x00c6: PHI (r19v21 char) = 
      (r19v0 char)
      (r19v0 char)
      (r19v5 char)
      (r19v0 char)
      (r19v6 char)
      (r19v0 char)
      (r19v7 char)
      (r19v0 char)
      (r19v8 char)
      (r19v0 char)
      (r19v9 char)
      (r19v0 char)
      (r19v10 char)
      (r19v0 char)
      (r19v11 char)
      (r19v0 char)
      (r19v12 char)
      (r19v0 char)
      (r19v13 char)
      (r19v0 char)
      (r19v14 char)
      (r19v0 char)
      (r19v15 char)
      (r19v0 char)
      (r19v16 char)
      (r19v0 char)
      (r19v17 char)
     binds: [B:42:0x00c3, B:95:0x0151, B:97:0x0155, B:91:0x0145, B:93:0x0149, B:87:0x013b, B:89:0x013e, B:83:0x0131, B:85:0x0134, B:79:0x0127, B:81:0x012a, B:75:0x011d, B:77:0x0120, B:71:0x0113, B:73:0x0116, B:67:0x0106, B:69:0x0109, B:63:0x00fc, B:65:0x00ff, B:59:0x00f2, B:61:0x00f5, B:55:0x00e8, B:57:0x00eb, B:51:0x00de, B:53:0x00e1, B:47:0x00d4, B:49:0x00d7] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00c8 A[PHI: r4 r19
      0x00c8: PHI (r4v49 java.lang.String) = (r4v5 java.lang.String), (r4v6 java.lang.String), (r4v50 java.lang.String) binds: [B:103:0x0170, B:99:0x015f, B:43:0x00c6] A[DONT_GENERATE, DONT_INLINE]
      0x00c8: PHI (r19v20 char) = (r19v0 char), (r19v0 char), (r19v21 char) binds: [B:103:0x0170, B:99:0x015f, B:43:0x00c6] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0159  */
    @Override // com.google.android.gms.internal.measurement.zzaq
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.internal.measurement.zzaq zza(java.lang.String r21, com.google.android.gms.internal.measurement.zzh r22, java.util.List<com.google.android.gms.internal.measurement.zzaq> r23) {
        /*
            Method dump skipped, instructions count: 1786
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzas.zza(java.lang.String, com.google.android.gms.internal.measurement.zzh, java.util.List):com.google.android.gms.internal.measurement.zzaq");
    }

    @Override // com.google.android.gms.internal.measurement.zzaq
    public final zzaq zzc() {
        return new zzas(this.zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzaq
    public final Boolean zzd() {
        return Boolean.valueOf(!this.zza.isEmpty());
    }

    @Override // com.google.android.gms.internal.measurement.zzaq
    public final Double zze() {
        if (this.zza.isEmpty()) {
            return Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
        }
        try {
            return Double.valueOf(this.zza);
        } catch (NumberFormatException unused) {
            return Double.valueOf(Double.NaN);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzaq
    public final String zzf() {
        return this.zza;
    }

    public final String toString() {
        return "\"" + this.zza + "\"";
    }

    @Override // com.google.android.gms.internal.measurement.zzaq
    public final Iterator<zzaq> zzh() {
        return new zzav(this);
    }

    @Override // java.lang.Iterable
    public final Iterator<zzaq> iterator() {
        return new zzau(this);
    }

    public zzas(String str) {
        if (str == null) {
            throw new IllegalArgumentException("StringValue cannot be null.");
        }
        this.zza = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzas) {
            return this.zza.equals(((zzas) obj).zza);
        }
        return false;
    }
}
