package com.soletreadmills.sole_v2.ui.classes;

import android.content.Context;
import com.android.SdkConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ClassesDetailFragment.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a-\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007¢\u0006\u0002\u0010\b\u001a\u0012\u0010\t\u001a\u00020\n*\u00020\u000b2\u0006\u0010\f\u001a\u00020\n¨\u0006\r"}, d2 = {"CircleButton", "", "iconRes", "", "modifier", "Landroidx/compose/ui/Modifier;", SdkConstants.ATTR_ON_CLICK, "Lkotlin/Function0;", "(ILandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "localized", "", "Landroid/content/Context;", "key", "app_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ClassesDetailFragmentKt {
    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void CircleButton(final int r22, androidx.compose.ui.Modifier r23, final kotlin.jvm.functions.Function0<kotlin.Unit> r24, androidx.compose.runtime.Composer r25, final int r26, final int r27) {
        /*
            Method dump skipped, instructions count: 254
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ui.classes.ClassesDetailFragmentKt.CircleButton(int, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final String localized(Context context, String key) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        int identifier = context.getResources().getIdentifier(key, "string", context.getPackageName());
        if (identifier == 0) {
            return key;
        }
        String string = context.getString(identifier);
        Intrinsics.checkNotNull(string);
        return string;
    }
}
