package com.android.utils;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StringHelperWindows.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¨\u0006\t"}, d2 = {"Lcom/android/utils/StringHelperWindows;", "", "()V", "splitCommandLine", "", "", "commandLine", "tokenizeCommandLineToEscaped", "tokenizeCommandLineToRaw", "common"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class StringHelperWindows {
    public static final StringHelperWindows INSTANCE = new StringHelperWindows();

    private StringHelperWindows() {
    }

    @JvmStatic
    public static final List<String> splitCommandLine(String commandLine) {
        Intrinsics.checkNotNullParameter(commandLine, "commandLine");
        ArrayList arrayListNewArrayList = Lists.newArrayList();
        Intrinsics.checkNotNullExpressionValue(arrayListNewArrayList, "newArrayList()");
        ArrayList arrayList = arrayListNewArrayList;
        int length = commandLine.length();
        int i = 0;
        int i2 = 0;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        while (i < length) {
            char cCharAt = commandLine.charAt(i);
            if (cCharAt != '\"' || z) {
                if (z) {
                    z = false;
                } else if (cCharAt == '\\') {
                    i++;
                    z = true;
                }
                if (z3) {
                    i++;
                    z3 = false;
                } else if (cCharAt == '^') {
                    i++;
                    z3 = true;
                } else {
                    if (!z2 && commandLine.charAt(i) == '&') {
                        String strSubstring = commandLine.substring(i2, i);
                        Intrinsics.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        arrayList.add(strSubstring);
                        int i3 = i + 1;
                        i = (commandLine.length() <= i3 || commandLine.charAt(i3) != '&') ? i3 : i + 2;
                        i2 = i;
                    }
                    i++;
                }
            } else {
                z2 = !z2;
                i++;
            }
        }
        if (i2 < length) {
            String strSubstring2 = commandLine.substring(i2);
            Intrinsics.checkNotNullExpressionValue(strSubstring2, "(this as java.lang.String).substring(startIndex)");
            arrayList.add(strSubstring2);
        }
        return arrayList;
    }

    @JvmStatic
    public static final List<String> tokenizeCommandLineToEscaped(String commandLine) {
        Intrinsics.checkNotNullParameter(commandLine, "commandLine");
        return new TokenizedCommandLine(commandLine, false, 2, null, 8, null).toTokenList();
    }

    @JvmStatic
    public static final List<String> tokenizeCommandLineToRaw(String commandLine) {
        Intrinsics.checkNotNullParameter(commandLine, "commandLine");
        return new TokenizedCommandLine(commandLine, true, 2, null, 8, null).toTokenList();
    }
}
