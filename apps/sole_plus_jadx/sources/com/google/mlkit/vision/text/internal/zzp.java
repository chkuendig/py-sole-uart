package com.google.mlkit.vision.text.internal;

import android.content.Context;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.internal.mlkit_vision_text_common.zzuc;
import com.google.android.gms.internal.mlkit_vision_text_common.zzun;
import com.google.mlkit.common.sdkinternal.LazyInstanceMap;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.vision.text.TextRecognizerOptionsInterface;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.1.0 */
/* loaded from: classes5.dex */
public final class zzp extends LazyInstanceMap {
    private final MlKitContext zza;

    public zzp(MlKitContext mlKitContext) {
        this.zza = mlKitContext;
    }

    @Override // com.google.mlkit.common.sdkinternal.LazyInstanceMap
    protected final /* bridge */ /* synthetic */ Object create(Object obj) {
        TextRecognizerOptionsInterface textRecognizerOptionsInterface = (TextRecognizerOptionsInterface) obj;
        zzuc zzucVarZzb = zzun.zzb(textRecognizerOptionsInterface.getLoggingLibraryName());
        Context applicationContext = this.zza.getApplicationContext();
        return new TextRecognizerTaskWithResource(zzucVarZzb, (GoogleApiAvailabilityLight.getInstance().getApkVersion(applicationContext) >= 204700000 || textRecognizerOptionsInterface.getIsThickClient()) ? new zzd(applicationContext, textRecognizerOptionsInterface, zzucVarZzb) : new zze(applicationContext), textRecognizerOptionsInterface);
    }
}
