package com.google.android.gms.internal.wearable;

import com.sun.jna.platform.win32.WinError;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
public final class zzco {
    static final Charset zza = Charset.forName("US-ASCII");
    static final Charset zzb = Charset.forName("UTF-8");
    static final Charset zzc = Charset.forName("ISO-8859-1");
    public static final byte[] zzd;
    public static final ByteBuffer zze;
    public static final zzbl zzf;

    static {
        byte[] bArr = new byte[0];
        zzd = bArr;
        zze = ByteBuffer.wrap(bArr);
        int i = zzbl.zza;
        zzbj zzbjVar = new zzbj(bArr, 0, 0, false, null);
        try {
            zzbjVar.zza(0);
            zzf = zzbjVar;
        } catch (zzcq e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static int zza(boolean z) {
        return z ? WinError.ERROR_NETWORK_UNREACHABLE : WinError.ERROR_RETRY;
    }

    static int zzb(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    static Object zzc(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException("messageType");
    }

    public static String zzd(byte[] bArr) {
        return new String(bArr, zzb);
    }
}
