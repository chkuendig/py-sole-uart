package com.android.prefs;

import androidx.exifinterface.media.ExifInterface;
import com.android.SdkConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: AbstractAndroidLocations.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001aN\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\u00012\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\tH\u0002¨\u0006\n"}, d2 = {"combineLocationValuesIntoMessage", "", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/android/prefs/LocationValue;", SdkConstants.FD_RES_VALUES, "", "prefix", "suffix", "modifier", "Lkotlin/Function1;", "common"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class AbstractAndroidLocationsKt {
    static /* synthetic */ String combineLocationValuesIntoMessage$default(List list, String str, String str2, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "";
        }
        if ((i & 4) != 0) {
            str2 = "";
        }
        if ((i & 8) != 0) {
            function1 = null;
        }
        return combineLocationValuesIntoMessage(list, str, str2, function1);
    }

    private static final <T extends LocationValue> String combineLocationValuesIntoMessage(List<? extends T> list, String str, String str2, Function1<? super T, String> function1) {
        StringBuffer stringBuffer = new StringBuffer(str);
        if (!list.isEmpty()) {
            stringBuffer.append('\n');
        }
        for (LocationValue locationValue : CollectionsKt.sorted(list)) {
            String str3 = "";
            if (function1 != null) {
                String strInvoke = function1.invoke(locationValue);
                String str4 = strInvoke == null ? null : "(" + strInvoke + ')';
                if (str4 != null) {
                    str3 = str4;
                }
            }
            stringBuffer.append("\n- " + locationValue.getPropertyName() + '(' + locationValue.getQueryType() + "): " + locationValue.getValue() + str3);
        }
        if (!StringsKt.isBlank(str2)) {
            stringBuffer.append(Intrinsics.stringPlus("\n\n", str2));
        }
        String string = stringBuffer.toString();
        Intrinsics.checkNotNullExpressionValue(string, "buffer.toString()");
        return string;
    }
}
