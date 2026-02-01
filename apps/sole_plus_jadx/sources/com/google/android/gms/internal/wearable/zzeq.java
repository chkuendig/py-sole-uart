package com.google.android.gms.internal.wearable;

import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
public final class zzeq {
    private static final zzeq zza = new zzeq(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzeq() {
        this(0, new int[8], new Object[8], true);
    }

    private zzeq(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zze = -1;
        this.zzb = i;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z;
    }

    public static zzeq zzc() {
        return zza;
    }

    static zzeq zze(zzeq zzeqVar, zzeq zzeqVar2) {
        int i = zzeqVar.zzb + zzeqVar2.zzb;
        int[] iArrCopyOf = Arrays.copyOf(zzeqVar.zzc, i);
        System.arraycopy(zzeqVar2.zzc, 0, iArrCopyOf, zzeqVar.zzb, zzeqVar2.zzb);
        Object[] objArrCopyOf = Arrays.copyOf(zzeqVar.zzd, i);
        System.arraycopy(zzeqVar2.zzd, 0, objArrCopyOf, zzeqVar.zzb, zzeqVar2.zzb);
        return new zzeq(i, iArrCopyOf, objArrCopyOf, true);
    }

    static zzeq zzf() {
        return new zzeq(0, new int[8], new Object[8], true);
    }

    private final void zzl(int i) {
        int[] iArr = this.zzc;
        if (i > iArr.length) {
            int i2 = this.zzb;
            int i3 = i2 + (i2 / 2);
            if (i3 >= i) {
                i = i3;
            }
            if (i < 8) {
                i = 8;
            }
            this.zzc = Arrays.copyOf(iArr, i);
            this.zzd = Arrays.copyOf(this.zzd, i);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzeq)) {
            return false;
        }
        zzeq zzeqVar = (zzeq) obj;
        int i = this.zzb;
        if (i == zzeqVar.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzeqVar.zzc;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzeqVar.zzd;
                    int i3 = this.zzb;
                    for (int i4 = 0; i4 < i3; i4++) {
                        if (objArr[i4].equals(objArr2[i4])) {
                        }
                    }
                    return true;
                }
                if (iArr[i2] != iArr2[i2]) {
                    break;
                }
                i2++;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzb;
        int i2 = i + 527;
        int[] iArr = this.zzc;
        int iHashCode = 17;
        int i3 = 17;
        for (int i4 = 0; i4 < i; i4++) {
            i3 = (i3 * 31) + iArr[i4];
        }
        int i5 = (i2 * 31) + i3;
        Object[] objArr = this.zzd;
        int i6 = this.zzb;
        for (int i7 = 0; i7 < i6; i7++) {
            iHashCode = (iHashCode * 31) + objArr[i7].hashCode();
        }
        return (i5 * 31) + iHashCode;
    }

    public final int zza() {
        int iZzy;
        int iZzx;
        int iZzx2;
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.zzb; i3++) {
            int i4 = this.zzc[i3];
            int i5 = i4 >>> 3;
            int i6 = i4 & 7;
            if (i6 != 0) {
                if (i6 == 1) {
                    ((Long) this.zzd[i3]).longValue();
                    iZzx2 = zzbp.zzx(i5 << 3) + 8;
                } else if (i6 == 2) {
                    zzbh zzbhVar = (zzbh) this.zzd[i3];
                    int i7 = zzbp.zzb;
                    int iZzd = zzbhVar.zzd();
                    iZzx2 = zzbp.zzx(i5 << 3) + zzbp.zzx(iZzd) + iZzd;
                } else if (i6 == 3) {
                    int i8 = i5 << 3;
                    int i9 = zzbp.zzb;
                    iZzy = ((zzeq) this.zzd[i3]).zza();
                    int iZzx3 = zzbp.zzx(i8);
                    iZzx = iZzx3 + iZzx3;
                } else {
                    if (i6 != 5) {
                        throw new IllegalStateException(zzcq.zza());
                    }
                    ((Integer) this.zzd[i3]).intValue();
                    iZzx2 = zzbp.zzx(i5 << 3) + 4;
                }
                i2 += iZzx2;
            } else {
                int i10 = i5 << 3;
                iZzy = zzbp.zzy(((Long) this.zzd[i3]).longValue());
                iZzx = zzbp.zzx(i10);
            }
            iZzx2 = iZzx + iZzy;
            i2 += iZzx2;
        }
        this.zze = i2;
        return i2;
    }

    public final int zzb() {
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int iZzx = 0;
        for (int i2 = 0; i2 < this.zzb; i2++) {
            int i3 = this.zzc[i2] >>> 3;
            zzbh zzbhVar = (zzbh) this.zzd[i2];
            int i4 = zzbp.zzb;
            int iZzd = zzbhVar.zzd();
            int iZzx2 = zzbp.zzx(iZzd) + iZzd;
            int iZzx3 = zzbp.zzx(16);
            int iZzx4 = zzbp.zzx(i3);
            int iZzx5 = zzbp.zzx(8);
            iZzx += iZzx5 + iZzx5 + iZzx3 + iZzx4 + zzbp.zzx(24) + iZzx2;
        }
        this.zze = iZzx;
        return iZzx;
    }

    final zzeq zzd(zzeq zzeqVar) {
        if (zzeqVar.equals(zza)) {
            return this;
        }
        zzg();
        int i = this.zzb + zzeqVar.zzb;
        zzl(i);
        System.arraycopy(zzeqVar.zzc, 0, this.zzc, this.zzb, zzeqVar.zzb);
        System.arraycopy(zzeqVar.zzd, 0, this.zzd, this.zzb, zzeqVar.zzb);
        this.zzb = i;
        return this;
    }

    final void zzg() {
        if (!this.zzf) {
            throw new UnsupportedOperationException();
        }
    }

    public final void zzh() {
        if (this.zzf) {
            this.zzf = false;
        }
    }

    final void zzi(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzdp.zzb(sb, i, String.valueOf(this.zzc[i2] >>> 3), this.zzd[i2]);
        }
    }

    final void zzj(int i, Object obj) {
        zzg();
        zzl(this.zzb + 1);
        int[] iArr = this.zzc;
        int i2 = this.zzb;
        iArr[i2] = i;
        this.zzd[i2] = obj;
        this.zzb = i2 + 1;
    }

    public final void zzk(zzfh zzfhVar) throws IOException {
        if (this.zzb != 0) {
            for (int i = 0; i < this.zzb; i++) {
                int i2 = this.zzc[i];
                Object obj = this.zzd[i];
                int i3 = i2 & 7;
                int i4 = i2 >>> 3;
                if (i3 == 0) {
                    zzfhVar.zzt(i4, ((Long) obj).longValue());
                } else if (i3 == 1) {
                    zzfhVar.zzm(i4, ((Long) obj).longValue());
                } else if (i3 == 2) {
                    zzfhVar.zzd(i4, (zzbh) obj);
                } else if (i3 == 3) {
                    zzfhVar.zzE(i4);
                    ((zzeq) obj).zzk(zzfhVar);
                    zzfhVar.zzh(i4);
                } else {
                    if (i3 != 5) {
                        throw new RuntimeException(zzcq.zza());
                    }
                    zzfhVar.zzk(i4, ((Integer) obj).intValue());
                }
            }
        }
    }
}
