package io.ktor.http;

import com.google.android.gms.actions.SearchIntents;
import io.ktor.http.Parameters;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* compiled from: Query.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a,\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b\u001a \u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0002\u001a \u0010\u000e\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\rH\u0002\u001a4\u0010\u000f\u001a\u00020\u0010*\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0002\u001a,\u0010\u0015\u001a\u00020\u0010*\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0002¨\u0006\u0016"}, d2 = {"parseQueryString", "Lio/ktor/http/Parameters;", SearchIntents.EXTRA_QUERY, "", "startIndex", "", "limit", "decode", "", "trimEnd", "start", "end", "text", "", "trimStart", "appendParam", "", "Lio/ktor/http/ParametersBuilder;", "nameIndex", "equalIndex", "endIndex", "parse", "ktor-http"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class QueryKt {
    public static /* synthetic */ Parameters parseQueryString$default(String str, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = 1000;
        }
        if ((i3 & 8) != 0) {
            z = true;
        }
        return parseQueryString(str, i, i2, z);
    }

    public static final Parameters parseQueryString(String query, int i, int i2, boolean z) {
        Intrinsics.checkNotNullParameter(query, "query");
        if (i > StringsKt.getLastIndex(query)) {
            return Parameters.INSTANCE.getEmpty();
        }
        Parameters.Companion companion = Parameters.INSTANCE;
        ParametersBuilder parametersBuilderParametersBuilder$default = ParametersKt.ParametersBuilder$default(0, 1, null);
        parse(parametersBuilderParametersBuilder$default, query, i, i2, z);
        return parametersBuilderParametersBuilder$default.build();
    }

    private static final void parse(ParametersBuilder parametersBuilder, String str, int i, int i2, boolean z) {
        int i3;
        int i4;
        int lastIndex = StringsKt.getLastIndex(str);
        int i5 = 0;
        if (i <= lastIndex) {
            int i6 = 0;
            i3 = i;
            int i7 = i3;
            i4 = -1;
            while (i6 != i2) {
                char cCharAt = str.charAt(i7);
                if (cCharAt == '&') {
                    appendParam(parametersBuilder, str, i3, i4, i7, z);
                    i6++;
                    i3 = i7 + 1;
                    i4 = -1;
                } else if (cCharAt == '=' && i4 == -1) {
                    i4 = i7;
                }
                if (i7 != lastIndex) {
                    i7++;
                } else {
                    i5 = i6;
                }
            }
            return;
        }
        i3 = i;
        i4 = -1;
        if (i5 == i2) {
            return;
        }
        appendParam(parametersBuilder, str, i3, i4, str.length(), z);
    }

    private static final void appendParam(ParametersBuilder parametersBuilder, String str, int i, int i2, int i3, boolean z) {
        String strSubstring;
        String strSubstring2;
        String strSubstring3;
        if (i2 == -1) {
            String str2 = str;
            int iTrimStart = trimStart(i, i3, str2);
            int iTrimEnd = trimEnd(iTrimStart, i3, str2);
            if (iTrimEnd > iTrimStart) {
                if (z) {
                    strSubstring3 = CodecsKt.decodeURLQueryComponent$default(str, iTrimStart, iTrimEnd, false, null, 12, null);
                } else {
                    strSubstring3 = str.substring(iTrimStart, iTrimEnd);
                    Intrinsics.checkNotNullExpressionValue(strSubstring3, "this as java.lang.String…ing(startIndex, endIndex)");
                }
                parametersBuilder.appendAll(strSubstring3, CollectionsKt.emptyList());
                return;
            }
            return;
        }
        String str3 = str;
        int iTrimStart2 = trimStart(i, i2, str3);
        int iTrimEnd2 = trimEnd(iTrimStart2, i2, str3);
        if (iTrimEnd2 > iTrimStart2) {
            if (z) {
                strSubstring = CodecsKt.decodeURLQueryComponent$default(str, iTrimStart2, iTrimEnd2, false, null, 12, null);
            } else {
                strSubstring = str.substring(iTrimStart2, iTrimEnd2);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            }
            int iTrimStart3 = trimStart(i2 + 1, i3, str3);
            int iTrimEnd3 = trimEnd(iTrimStart3, i3, str3);
            if (z) {
                strSubstring2 = CodecsKt.decodeURLQueryComponent$default(str, iTrimStart3, iTrimEnd3, true, null, 8, null);
            } else {
                strSubstring2 = str.substring(iTrimStart3, iTrimEnd3);
                Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
            }
            parametersBuilder.append(strSubstring, strSubstring2);
        }
    }

    private static final int trimEnd(int i, int i2, CharSequence charSequence) {
        while (i2 > i && CharsKt.isWhitespace(charSequence.charAt(i2 - 1))) {
            i2--;
        }
        return i2;
    }

    private static final int trimStart(int i, int i2, CharSequence charSequence) {
        while (i < i2 && CharsKt.isWhitespace(charSequence.charAt(i))) {
            i++;
        }
        return i;
    }
}
