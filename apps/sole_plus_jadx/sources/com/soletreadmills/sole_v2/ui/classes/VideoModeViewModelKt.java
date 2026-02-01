package com.soletreadmills.sole_v2.ui.classes;

import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: VideoModeViewModel.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"formattedTime", "", "", "app_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VideoModeViewModelKt {
    public static final String formattedTime(int i) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(Locale.US, "%d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i / 60), Integer.valueOf(i % 60)}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }
}
