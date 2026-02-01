package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzjt;
import com.google.android.gms.internal.measurement.zzjx;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.0.0 */
/* loaded from: classes2.dex */
public class zzjt<MessageType extends zzjx<MessageType, BuilderType>, BuilderType extends zzjt<MessageType, BuilderType>> extends zzig<MessageType, BuilderType> {
    protected MessageType zza;
    protected boolean zzb = false;
    private final MessageType zzc;

    protected zzjt(MessageType messagetype) {
        this.zzc = messagetype;
        this.zza = (MessageType) messagetype.zzl(4, null, null);
    }

    private static final void zza(MessageType messagetype, MessageType messagetype2) {
        zzlk.zza().zzb(messagetype.getClass()).zzg(messagetype, messagetype2);
    }

    public final MessageType zzaA() {
        MessageType messagetype = (MessageType) zzaC();
        Boolean bool = Boolean.TRUE;
        boolean z = true;
        byte bByteValue = ((Byte) messagetype.zzl(1, null, null)).byteValue();
        if (bByteValue != 1) {
            if (bByteValue == 0) {
                z = false;
            } else {
                boolean zZzj = zzlk.zza().zzb(messagetype.getClass()).zzj(messagetype);
                messagetype.zzl(2, true != zZzj ? null : messagetype, null);
                z = zZzj;
            }
        }
        if (z) {
            return messagetype;
        }
        throw new zzma(messagetype);
    }

    @Override // com.google.android.gms.internal.measurement.zzlb
    /* renamed from: zzaB, reason: merged with bridge method [inline-methods] */
    public MessageType zzaC() {
        if (this.zzb) {
            return this.zza;
        }
        MessageType messagetype = this.zza;
        zzlk.zza().zzb(messagetype.getClass()).zzf(messagetype);
        this.zzb = true;
        return this.zza;
    }

    protected void zzaE() {
        MessageType messagetype = (MessageType) this.zza.zzl(4, null, null);
        zza(messagetype, this.zza);
        this.zza = messagetype;
    }

    @Override // com.google.android.gms.internal.measurement.zzig
    protected final /* synthetic */ zzig zzar(zzih zzihVar) {
        zzay((zzjx) zzihVar);
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.zzig
    public final /* bridge */ /* synthetic */ zzig zzas(byte[] bArr, int i, int i2) throws zzkh {
        zzaz(bArr, 0, i2, zzjj.zza());
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.zzig
    public final /* bridge */ /* synthetic */ zzig zzat(byte[] bArr, int i, int i2, zzjj zzjjVar) throws zzkh {
        zzaz(bArr, 0, i2, zzjjVar);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.zzig
    /* renamed from: zzax, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final BuilderType zzaq() {
        BuilderType buildertype = (BuilderType) this.zzc.zzl(5, null, null);
        buildertype.zzay(zzaC());
        return buildertype;
    }

    public final BuilderType zzay(MessageType messagetype) {
        if (this.zzb) {
            zzaE();
            this.zzb = false;
        }
        zza(this.zza, messagetype);
        return this;
    }

    public final BuilderType zzaz(byte[] bArr, int i, int i2, zzjj zzjjVar) throws zzkh {
        if (this.zzb) {
            zzaE();
            this.zzb = false;
        }
        try {
            zzlk.zza().zzb(this.zza.getClass()).zzh(this.zza, bArr, 0, i2, new zzik(zzjjVar));
            return this;
        } catch (zzkh e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException("Reading from byte array should not throw IOException.", e2);
        } catch (IndexOutOfBoundsException unused) {
            throw zzkh.zzf();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzld
    public final /* synthetic */ zzlc zzbL() {
        return this.zzc;
    }
}
