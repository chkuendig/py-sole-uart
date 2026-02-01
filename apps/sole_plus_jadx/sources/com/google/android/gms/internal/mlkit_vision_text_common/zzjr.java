package com.google.android.gms.internal.mlkit_vision_text_common;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.1.0 */
/* loaded from: classes4.dex */
final class zzjr implements ObjectEncoder {
    static final zzjr zza = new zzjr();

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("errorCode");
        zzct zzctVar = new zzct();
        zzctVar.zza(1);
        builder.withProperty(zzctVar.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("durationMs");
        zzct zzctVar2 = new zzct();
        zzctVar2.zza(2);
        builder2.withProperty(zzctVar2.zzb()).build();
    }

    private zzjr() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        throw null;
    }
}
