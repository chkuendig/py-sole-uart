package com.google.android.gms.internal.mlkit_vision_text_common;

import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.1.0 */
/* loaded from: classes4.dex */
final class zzlu implements ObjectEncoder {
    static final zzlu zza = new zzlu();

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("stageId");
        zzct zzctVar = new zzct();
        zzctVar.zza(1);
        builder.withProperty(zzctVar.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder(DeviceRequestsHelper.DEVICE_INFO_DEVICE);
        zzct zzctVar2 = new zzct();
        zzctVar2.zza(2);
        builder2.withProperty(zzctVar2.zzb()).build();
    }

    private zzlu() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        throw null;
    }
}
