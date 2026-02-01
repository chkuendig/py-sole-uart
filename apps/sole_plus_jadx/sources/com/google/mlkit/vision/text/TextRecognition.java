package com.google.mlkit.vision.text;

import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.vision.text.internal.zzo;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.1.0 */
/* loaded from: classes5.dex */
public class TextRecognition {
    private TextRecognition() {
    }

    public static TextRecognizer getClient(TextRecognizerOptionsInterface textRecognizerOptionsInterface) {
        return ((zzo) MlKitContext.getInstance().get(zzo.class)).zza(textRecognizerOptionsInterface);
    }
}
