package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzig;
import com.google.android.gms.internal.measurement.zzih;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.0.0 */
/* loaded from: classes2.dex */
public abstract class zzig<MessageType extends zzih<MessageType, BuilderType>, BuilderType extends zzig<MessageType, BuilderType>> implements zzlb {
    @Override // 
    public abstract BuilderType zzaq();

    protected abstract BuilderType zzar(MessageType messagetype);

    public BuilderType zzas(byte[] bArr, int i, int i2) throws zzkh {
        throw null;
    }

    public BuilderType zzat(byte[] bArr, int i, int i2, zzjj zzjjVar) throws zzkh {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzlb
    public final /* bridge */ /* synthetic */ zzlb zzau(zzlc zzlcVar) {
        if (zzbL().getClass().isInstance(zzlcVar)) {
            return zzar((zzih) zzlcVar);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }

    @Override // com.google.android.gms.internal.measurement.zzlb
    public final /* synthetic */ zzlb zzav(byte[] bArr) throws zzkh {
        return zzas(bArr, 0, bArr.length);
    }

    @Override // com.google.android.gms.internal.measurement.zzlb
    public final /* synthetic */ zzlb zzaw(byte[] bArr, zzjj zzjjVar) throws zzkh {
        return zzat(bArr, 0, bArr.length, zzjjVar);
    }
}
