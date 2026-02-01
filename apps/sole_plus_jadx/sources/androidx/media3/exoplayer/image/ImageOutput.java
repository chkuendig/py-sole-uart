package androidx.media3.exoplayer.image;

import android.graphics.Bitmap;

/* loaded from: classes3.dex */
public interface ImageOutput {
    void onDisabled();

    void onImageAvailable(long j, Bitmap bitmap);
}
