package com.soletreadmills.sole_v2._extension;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: StringExtensions.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"withHighlight", "Landroid/text/SpannableStringBuilder;", "", "color", "", "app_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class StringExtensionsKt {
    public static final SpannableStringBuilder withHighlight(String str, int i) {
        int iIndexOf$default;
        Intrinsics.checkNotNullParameter(str, "<this>");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
        for (int iIndexOf$default2 = StringsKt.indexOf$default((CharSequence) spannableStringBuilder2, "<highlight>", 0, false, 6, (Object) null); iIndexOf$default2 != -1 && (iIndexOf$default = StringsKt.indexOf$default((CharSequence) spannableStringBuilder2, "</highlight>", iIndexOf$default2, false, 4, (Object) null)) != -1; iIndexOf$default2 = StringsKt.indexOf$default((CharSequence) spannableStringBuilder2, "<highlight>", iIndexOf$default2, false, 4, (Object) null)) {
            spannableStringBuilder.delete(iIndexOf$default, "</highlight>".length() + iIndexOf$default);
            spannableStringBuilder.delete(iIndexOf$default2, "<highlight>".length() + iIndexOf$default2);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(i), iIndexOf$default2, iIndexOf$default - "<highlight>".length(), 33);
        }
        return spannableStringBuilder;
    }
}
