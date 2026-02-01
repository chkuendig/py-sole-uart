package com.google.android.gms.internal.mlkit_vision_common;

import com.android.SdkConstants;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* compiled from: com.google.mlkit:vision-common@@17.3.0 */
/* loaded from: classes4.dex */
final class zzen implements ObjectEncoder {
    static final zzen zza = new zzen();
    private static final FieldDescriptor zzb;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder(SdkConstants.GRADLE_API_CONFIGURATION);
        zzae zzaeVar = new zzae();
        zzaeVar.zza(1);
        zzb = builder.withProperty(zzaeVar.zzb()).build();
    }

    private zzen() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        throw null;
    }
}
