package com.android.utils;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StringHelperPOSIX.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¨\u0006\t"}, d2 = {"Lcom/android/utils/StringHelperPOSIX;", "", "()V", "splitCommandLine", "", "", "commandLine", "tokenizeCommandLineToEscaped", "tokenizeCommandLineToRaw", "common"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class StringHelperPOSIX {
    public static final StringHelperPOSIX INSTANCE = new StringHelperPOSIX();

    private StringHelperPOSIX() {
    }

    @JvmStatic
    public static final List<String> splitCommandLine(String commandLine) {
        int i;
        Intrinsics.checkNotNullParameter(commandLine, "commandLine");
        ArrayList arrayListNewArrayList = Lists.newArrayList();
        Intrinsics.checkNotNullExpressionValue(arrayListNewArrayList, "newArrayList()");
        ArrayList arrayList = arrayListNewArrayList;
        int i2 = 0;
        int i3 = 0;
        boolean z = false;
        char c = 0;
        loop0: while (true) {
            char c2 = c;
            while (i2 < commandLine.length()) {
                char cCharAt = commandLine.charAt(i2);
                if (z) {
                    i2++;
                    z = false;
                } else if (cCharAt == '\\' && (c == 0 || c2 == '\"')) {
                    i2++;
                    z = true;
                } else if (c == 0 && (cCharAt == '\"' || cCharAt == '\'')) {
                    i2++;
                    c2 = cCharAt;
                    c = 1;
                } else if (c == 0 || cCharAt != c2) {
                    if (c == 0) {
                        int i4 = i2 + 1;
                        if (commandLine.length() > i4 && commandLine.charAt(i2) == '&' && commandLine.charAt(i4) == '&') {
                            i = 2;
                        } else {
                            i = commandLine.charAt(i2) == ';' ? 1 : 0;
                        }
                        if (i > 0) {
                            String strSubstring = commandLine.substring(i3, i2);
                            Intrinsics.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                            arrayList.add(strSubstring);
                            i2 += i;
                            i3 = i2;
                        }
                    }
                    i2++;
                }
            }
            i2++;
            c = 0;
        }
        if (i3 < commandLine.length()) {
            String strSubstring2 = commandLine.substring(i3);
            Intrinsics.checkNotNullExpressionValue(strSubstring2, "(this as java.lang.String).substring(startIndex)");
            arrayList.add(strSubstring2);
        }
        return arrayList;
    }

    @JvmStatic
    public static final List<String> tokenizeCommandLineToEscaped(String commandLine) {
        Intrinsics.checkNotNullParameter(commandLine, "commandLine");
        return new TokenizedCommandLine(commandLine, false, 1, null, 8, null).toTokenList();
    }

    @JvmStatic
    public static final List<String> tokenizeCommandLineToRaw(String commandLine) {
        Intrinsics.checkNotNullParameter(commandLine, "commandLine");
        return new TokenizedCommandLine(commandLine, true, 1, null, 8, null).toTokenList();
    }
}
