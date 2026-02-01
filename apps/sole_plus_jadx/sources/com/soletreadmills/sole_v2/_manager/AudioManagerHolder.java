package com.soletreadmills.sole_v2._manager;

import android.content.Context;
import com.android.SdkConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AudioPlayerManager.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/soletreadmills/sole_v2/_manager/AudioManagerHolder;", "", "()V", "_audioManager", "Lcom/soletreadmills/sole_v2/_manager/AudioPlayerManager;", "get", "initialize", "", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "release", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AudioManagerHolder {
    private static AudioPlayerManager _audioManager;
    public static final AudioManagerHolder INSTANCE = new AudioManagerHolder();
    public static final int $stable = 8;

    private AudioManagerHolder() {
    }

    public final void initialize(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (_audioManager == null) {
            Context applicationContext = context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            _audioManager = new AudioPlayerManager(applicationContext);
        }
    }

    public final AudioPlayerManager get() {
        return _audioManager;
    }

    public final void release() {
        AudioPlayerManager audioPlayerManager = _audioManager;
        if (audioPlayerManager != null) {
            audioPlayerManager.release();
        }
        _audioManager = null;
    }
}
