package com.google.mlkit.vision.text.internal;

import com.google.android.gms.internal.mlkit_vision_text_common.zzun;
import com.google.mlkit.common.sdkinternal.ExecutorSelector;
import com.google.mlkit.vision.text.TextRecognizer;
import com.google.mlkit.vision.text.TextRecognizerOptionsInterface;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.1.0 */
/* loaded from: classes5.dex */
public final class zzo {
    private final zzp zza;
    private final ExecutorSelector zzb;

    zzo(zzp zzpVar, ExecutorSelector executorSelector) {
        this.zza = zzpVar;
        this.zzb = executorSelector;
    }

    public final TextRecognizer zza(TextRecognizerOptionsInterface textRecognizerOptionsInterface) {
        return new zzn((TextRecognizerTaskWithResource) this.zza.get(textRecognizerOptionsInterface), this.zzb.getExecutorToUse(textRecognizerOptionsInterface.getExecutor()), zzun.zzb(textRecognizerOptionsInterface.getLoggingLibraryName()), textRecognizerOptionsInterface);
    }
}
