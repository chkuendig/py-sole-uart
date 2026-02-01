package com.google.android.gms.internal.mlkit_vision_text_common;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import java.io.UnsupportedEncodingException;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.1.0 */
/* loaded from: classes4.dex */
public final class zzuf implements zztr {
    private final zzow zza;
    private zzsr zzb = new zzsr();
    private final int zzc;

    private zzuf(zzow zzowVar, int i) {
        this.zza = zzowVar;
        zzuo.zza();
        this.zzc = i;
    }

    public static zztr zzf(zzow zzowVar) {
        return new zzuf(zzowVar, 0);
    }

    public static zztr zzg(zzow zzowVar, int i) {
        return new zzuf(zzowVar, 1);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_common.zztr
    public final int zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_common.zztr
    public final zztr zzb(zzov zzovVar) {
        this.zza.zzf(zzovVar);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_common.zztr
    public final zztr zzc(zzsr zzsrVar) {
        this.zzb = zzsrVar;
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_common.zztr
    public final String zzd() {
        zzst zzstVarZzf = this.zza.zzj().zzf();
        return (zzstVarZzf == null || zzy.zzb(zzstVarZzf.zzk())) ? "NA" : (String) Preconditions.checkNotNull(zzstVarZzf.zzk());
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_common.zztr
    public final byte[] zze(int i, boolean z) {
        this.zzb.zzf(Boolean.valueOf(1 == (i ^ 1)));
        this.zzb.zze(false);
        this.zza.zzi(this.zzb.zzm());
        try {
            zzuo.zza();
            if (i == 0) {
                return new JsonDataEncoderBuilder().configureWith(zzmq.zza).ignoreNullValues(true).build().encode(this.zza.zzj()).getBytes("utf-8");
            }
            zzoy zzoyVarZzj = this.zza.zzj();
            zzdb zzdbVar = new zzdb();
            zzmq.zza.configure(zzdbVar);
            return zzdbVar.zza().zza(zzoyVarZzj);
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedOperationException("Failed to covert logging to UTF-8 byte array", e);
        }
    }
}
