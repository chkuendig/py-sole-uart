package com.google.android.gms.internal.wearable;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
final class zzbb extends zzbe {
    private final int zzc;

    zzbb(byte[] bArr, int i, int i2) {
        super(bArr);
        zzk(0, i2, bArr.length);
        this.zzc = i2;
    }

    @Override // com.google.android.gms.internal.wearable.zzbe, com.google.android.gms.internal.wearable.zzbh
    final byte zzb(int i) {
        return this.zza[i];
    }

    @Override // com.google.android.gms.internal.wearable.zzbe
    protected final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.wearable.zzbe, com.google.android.gms.internal.wearable.zzbh
    public final int zzd() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.wearable.zzbe, com.google.android.gms.internal.wearable.zzbh
    protected final void zze(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zza, 0, bArr, 0, i3);
    }

    @Override // com.google.android.gms.internal.wearable.zzbe, com.google.android.gms.internal.wearable.zzbh
    public final byte zza(int i) {
        int i2 = this.zzc;
        if (((i2 - (i + 1)) | i) >= 0) {
            return this.zza[i];
        }
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException("Index < 0: " + i);
        }
        throw new ArrayIndexOutOfBoundsException("Index > length: " + i + ", " + i2);
    }
}
