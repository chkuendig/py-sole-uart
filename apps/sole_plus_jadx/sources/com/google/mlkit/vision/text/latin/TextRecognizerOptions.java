package com.google.mlkit.vision.text.latin;

import com.google.android.gms.common.internal.Objects;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import com.google.mlkit.vision.text.TextRecognizerOptionsInterface;
import com.google.mlkit.vision.text.internal.TextRecognizerOptionsUtils;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@19.0.1 */
/* loaded from: classes5.dex */
public class TextRecognizerOptions implements TextRecognizerOptionsInterface {
    public static final TextRecognizerOptions DEFAULT_OPTIONS = new Builder().build();
    private final Executor zzb;
    final AtomicReference zza = new AtomicReference();
    private final String zzc = "taser_tflite_gocrlatin_mbv2_scriptid_aksara_layout_gcn_mobile";

    /* compiled from: com.google.android.gms:play-services-mlkit-text-recognition@@19.0.1 */
    public static class Builder {
        private Executor zza;

        public TextRecognizerOptions build() {
            return new TextRecognizerOptions(this.zza, "taser_tflite_gocrlatin_mbv2_scriptid_aksara_layout_gcn_mobile");
        }

        public Builder setExecutor(Executor executor) {
            this.zza = executor;
            return this;
        }
    }

    public TextRecognizerOptions(Executor executor, String str) {
        this.zzb = executor;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof TextRecognizerOptions) {
            return Objects.equal(this.zzb, ((TextRecognizerOptions) obj).zzb);
        }
        return false;
    }

    @Override // com.google.mlkit.vision.text.TextRecognizerOptionsInterface
    public final String getConfigLabel() {
        return this.zzc;
    }

    @Override // com.google.mlkit.vision.text.TextRecognizerOptionsInterface
    public final Executor getExecutor() {
        return this.zzb;
    }

    @Override // com.google.mlkit.vision.text.TextRecognizerOptionsInterface
    public final boolean getIsThickClient() {
        return TextRecognizerOptionsUtils.isThickClient(this.zza, "com.google.mlkit.dynamite.text.latin");
    }

    @Override // com.google.mlkit.vision.text.TextRecognizerOptionsInterface
    public final String getLanguageHint() {
        return "en";
    }

    @Override // com.google.mlkit.vision.text.TextRecognizerOptionsInterface
    public final int getLoggingEventId() {
        return getIsThickClient() ? 24317 : 24306;
    }

    @Override // com.google.mlkit.vision.text.TextRecognizerOptionsInterface
    public final int getLoggingLanguageOption() {
        return 1;
    }

    @Override // com.google.mlkit.vision.text.TextRecognizerOptionsInterface
    public final String getLoggingLibraryName() {
        return true != getIsThickClient() ? "play-services-mlkit-text-recognition" : "text-recognition";
    }

    @Override // com.google.mlkit.vision.text.TextRecognizerOptionsInterface
    public final String getLoggingLibraryNameForOptionalModule() {
        return "optional-module-text-latin";
    }

    @Override // com.google.mlkit.vision.text.TextRecognizerOptionsInterface
    public final String getModuleId() {
        return true != getIsThickClient() ? OptionalModuleUtils.OCR_MODULE_ID : "com.google.mlkit.dynamite.text.latin";
    }

    public int hashCode() {
        return Objects.hashCode(this.zzb);
    }
}
