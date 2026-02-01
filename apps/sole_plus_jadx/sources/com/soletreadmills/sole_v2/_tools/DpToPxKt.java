package com.soletreadmills.sole_v2._tools;

import android.content.Context;
import com.android.SdkConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: dpToPx.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"dpToPx", "", SdkConstants.UNIT_DP, SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "app_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DpToPxKt {
    public static final int dpToPx(int i, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return (int) (i * context.getResources().getDisplayMetrics().density);
    }
}
