package com.google.android.gms.internal.wearable;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
public abstract class zzbh implements Iterable, Serializable {
    private static final Comparator zza;
    public static final zzbh zzb = new zzbe(zzco.zzd);
    private static final zzbg zzd;
    private int zzc = 0;

    static {
        int i = zzat.zza;
        zzd = new zzbg(null);
        zza = new zzaz();
    }

    zzbh() {
    }

    public static zzbh zzm(byte[] bArr, int i, int i2) {
        zzk(i, i + i2, bArr.length);
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return new zzbe(bArr2);
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int iZzf = this.zzc;
        if (iZzf == 0) {
            int iZzd = zzd();
            iZzf = zzf(iZzd, 0, iZzd);
            if (iZzf == 0) {
                iZzf = 1;
            }
            this.zzc = iZzf;
        }
        return iZzf;
    }

    @Override // java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new zzay(this);
    }

    public final String toString() {
        return String.format(Locale.ROOT, "<ByteString@%s size=%d contents=\"%s\">", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(zzd()), zzd() <= 50 ? zzen.zza(this) : zzen.zza(zzg(0, 47)).concat("..."));
    }

    public abstract byte zza(int i);

    abstract byte zzb(int i);

    public abstract int zzd();

    protected abstract void zze(byte[] bArr, int i, int i2, int i3);

    protected abstract int zzf(int i, int i2, int i3);

    public abstract zzbh zzg(int i, int i2);

    protected abstract String zzh(Charset charset);

    abstract void zzi(zzax zzaxVar) throws IOException;

    public abstract boolean zzj();

    protected final int zzl() {
        return this.zzc;
    }

    public final String zzn(Charset charset) {
        return zzd() == 0 ? "" : zzh(charset);
    }

    public final byte[] zzo() {
        int iZzd = zzd();
        if (iZzd == 0) {
            return zzco.zzd;
        }
        byte[] bArr = new byte[iZzd];
        zze(bArr, 0, 0, iZzd);
        return bArr;
    }

    static int zzk(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + i + " < 0");
        }
        if (i2 < i) {
            throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i + ", " + i2);
        }
        throw new IndexOutOfBoundsException("End index: " + i2 + " >= " + i3);
    }
}
