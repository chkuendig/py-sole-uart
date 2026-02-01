package com.google.android.gms.internal.wearable;

import java.io.IOException;
import java.nio.charset.Charset;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
class zzbe extends zzbd {
    protected final byte[] zza;

    zzbe(byte[] bArr) {
        bArr.getClass();
        this.zza = bArr;
    }

    @Override // com.google.android.gms.internal.wearable.zzbh
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzbh) || zzd() != ((zzbh) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (!(obj instanceof zzbe)) {
            return obj.equals(this);
        }
        zzbe zzbeVar = (zzbe) obj;
        int iZzl = zzl();
        int iZzl2 = zzbeVar.zzl();
        if (iZzl != 0 && iZzl2 != 0 && iZzl != iZzl2) {
            return false;
        }
        int iZzd = zzd();
        if (iZzd > zzbeVar.zzd()) {
            throw new IllegalArgumentException("Length too large: " + iZzd + zzd());
        }
        if (iZzd > zzbeVar.zzd()) {
            throw new IllegalArgumentException("Ran off end of other: 0, " + iZzd + ", " + zzbeVar.zzd());
        }
        if (!(zzbeVar instanceof zzbe)) {
            return zzbeVar.zzg(0, iZzd).equals(zzg(0, iZzd));
        }
        byte[] bArr = this.zza;
        byte[] bArr2 = zzbeVar.zza;
        zzbeVar.zzc();
        int i = 0;
        int i2 = 0;
        while (i < iZzd) {
            if (bArr[i] != bArr2[i2]) {
                return false;
            }
            i++;
            i2++;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.wearable.zzbh
    public byte zza(int i) {
        return this.zza[i];
    }

    @Override // com.google.android.gms.internal.wearable.zzbh
    byte zzb(int i) {
        return this.zza[i];
    }

    protected int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.wearable.zzbh
    public int zzd() {
        return this.zza.length;
    }

    @Override // com.google.android.gms.internal.wearable.zzbh
    protected void zze(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zza, 0, bArr, 0, i3);
    }

    @Override // com.google.android.gms.internal.wearable.zzbh
    protected final int zzf(int i, int i2, int i3) {
        return zzco.zzb(i, this.zza, 0, i3);
    }

    @Override // com.google.android.gms.internal.wearable.zzbh
    public final zzbh zzg(int i, int i2) {
        int iZzk = zzk(0, i2, zzd());
        return iZzk == 0 ? zzbh.zzb : new zzbb(this.zza, 0, iZzk);
    }

    @Override // com.google.android.gms.internal.wearable.zzbh
    protected final String zzh(Charset charset) {
        return new String(this.zza, 0, zzd(), charset);
    }

    @Override // com.google.android.gms.internal.wearable.zzbh
    final void zzi(zzax zzaxVar) throws IOException {
        ((zzbm) zzaxVar).zzc(this.zza, 0, zzd());
    }

    @Override // com.google.android.gms.internal.wearable.zzbh
    public final boolean zzj() {
        return zzfe.zze(this.zza, 0, zzd());
    }
}
