package com.google.android.gms.internal.wearable;

import com.google.android.gms.internal.wearable.zzcd;
import com.google.android.gms.internal.wearable.zzcg;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
public class zzcd<MessageType extends zzcg<MessageType, BuilderType>, BuilderType extends zzcd<MessageType, BuilderType>> extends zzaq<MessageType, BuilderType> {
    protected zzcg zza;
    private final zzcg zzb;

    protected zzcd(MessageType messagetype) {
        this.zzb = messagetype;
        if (messagetype.zzaf()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        this.zza = messagetype.zzP();
    }

    @Override // com.google.android.gms.internal.wearable.zzdo
    public final /* bridge */ /* synthetic */ zzdn zzag() {
        throw null;
    }

    @Override // com.google.android.gms.internal.wearable.zzaq
    /* renamed from: zzp, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final zzcd zzo() {
        zzcd zzcdVar = (zzcd) this.zzb.zzG(5, null, null);
        zzcdVar.zza = zzs();
        return zzcdVar;
    }

    public final MessageType zzq() {
        MessageType messagetype = (MessageType) zzs();
        if (messagetype.zzae()) {
            return messagetype;
        }
        throw new zzeo(messagetype);
    }

    @Override // com.google.android.gms.internal.wearable.zzdm
    /* renamed from: zzr, reason: merged with bridge method [inline-methods] */
    public MessageType zzs() {
        if (!this.zza.zzaf()) {
            return (MessageType) this.zza;
        }
        this.zza.zzZ();
        return (MessageType) this.zza;
    }

    protected final void zzu() {
        if (this.zza.zzaf()) {
            return;
        }
        zzv();
    }

    protected void zzv() {
        zzcg zzcgVarZzP = this.zzb.zzP();
        zzdv.zza().zzb(zzcgVarZzP.getClass()).zzg(zzcgVarZzP, this.zza);
        this.zza = zzcgVarZzP;
    }
}
