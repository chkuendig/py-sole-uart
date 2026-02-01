package com.github.mikephil.charting.utils;

import android.content.res.Resources;
import android.graphics.Color;
import com.sun.jna.platform.win32.WinError;
import java.util.ArrayList;
import java.util.List;
import org.objectweb.asm.Opcodes;

/* loaded from: classes3.dex */
public class ColorTemplate {
    public static final int COLOR_NONE = 1122867;
    public static final int COLOR_SKIP = 1122868;
    public static final int[] LIBERTY_COLORS = {Color.rgb(207, 248, 246), Color.rgb(148, WinError.ERROR_LOCKED, WinError.ERROR_LOCKED), Color.rgb(136, 180, 187), Color.rgb(118, 174, Opcodes.DRETURN), Color.rgb(42, 109, 130)};
    public static final int[] JOYFUL_COLORS = {Color.rgb(WinError.ERROR_EXE_CANNOT_MODIFY_SIGNED_BINARY, 80, 138), Color.rgb(254, 149, 7), Color.rgb(254, 247, 120), Color.rgb(106, 167, 134), Color.rgb(53, 194, WinError.ERROR_INVALID_SIGNAL_NUMBER)};
    public static final int[] PASTEL_COLORS = {Color.rgb(64, 89, 128), Color.rgb(149, 165, 124), Color.rgb(WinError.ERROR_EXE_CANNOT_MODIFY_SIGNED_BINARY, Opcodes.INVOKESTATIC, 162), Color.rgb(191, 134, 134), Color.rgb(Opcodes.PUTSTATIC, 48, 80)};
    public static final int[] COLORFUL_COLORS = {Color.rgb(193, 37, 82), Color.rgb(255, 102, 0), Color.rgb(245, 199, 0), Color.rgb(106, 150, 31), Color.rgb(Opcodes.PUTSTATIC, 100, 53)};
    public static final int[] VORDIPLOM_COLORS = {Color.rgb(192, 255, 140), Color.rgb(255, 247, 140), Color.rgb(255, WinError.ERROR_META_EXPANSION_TOO_LONG, 140), Color.rgb(140, WinError.ERROR_MORE_DATA, 255), Color.rgb(255, 140, 157)};
    public static final int[] MATERIAL_COLORS = {rgb("#2ecc71"), rgb("#f1c40f"), rgb("#e74c3c"), rgb("#3498db")};

    public static int colorWithAlpha(int i, int i2) {
        return (i & 16777215) | ((i2 & 255) << 24);
    }

    public static int rgb(String str) {
        int i = (int) Long.parseLong(str.replace("#", ""), 16);
        return Color.rgb((i >> 16) & 255, (i >> 8) & 255, i & 255);
    }

    public static int getHoloBlue() {
        return Color.rgb(51, Opcodes.PUTFIELD, WinError.ERROR_PIPE_LOCAL);
    }

    public static List<Integer> createColors(Resources resources, int[] iArr) {
        ArrayList arrayList = new ArrayList();
        for (int i : iArr) {
            arrayList.add(Integer.valueOf(resources.getColor(i)));
        }
        return arrayList;
    }

    public static List<Integer> createColors(int[] iArr) {
        ArrayList arrayList = new ArrayList();
        for (int i : iArr) {
            arrayList.add(Integer.valueOf(i));
        }
        return arrayList;
    }
}
