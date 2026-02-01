package com.soletreadmills.sole_v2._data.classes;

import android.content.Context;
import com.android.SdkConstants;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ClassesData.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\f\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u00020\u0005¨\u0006\u0006"}, d2 = {"localize", "", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "toYMDFormat", "", "app_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ClassesDataKt {
    public static final String localize(String str, Context context) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        String lowerCase = str.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        int identifier = context.getResources().getIdentifier(lowerCase, "string", context.getPackageName());
        if (identifier == 0) {
            return str;
        }
        String string = context.getString(identifier);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    public static final String toYMDFormat(long j) {
        try {
            Date date = new Date(j);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd", Locale.getDefault());
            simpleDateFormat.setTimeZone(TimeZone.getDefault());
            return simpleDateFormat.format(date);
        } catch (Exception unused) {
            return null;
        }
    }
}
