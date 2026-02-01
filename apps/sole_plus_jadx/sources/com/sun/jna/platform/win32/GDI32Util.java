package com.sun.jna.platform.win32;

import java.awt.image.DirectColorModel;

/* loaded from: classes4.dex */
public class GDI32Util {
    private static final int[] SCREENSHOT_BAND_MASKS;
    private static final DirectColorModel SCREENSHOT_COLOR_MODEL;

    static {
        DirectColorModel directColorModel = new DirectColorModel(24, Winspool.PRINTER_ENUM_ICONMASK, 65280, 255);
        SCREENSHOT_COLOR_MODEL = directColorModel;
        SCREENSHOT_BAND_MASKS = new int[]{directColorModel.getRedMask(), directColorModel.getGreenMask(), directColorModel.getBlueMask()};
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x027a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x027b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.awt.image.BufferedImage getScreenshot(com.sun.jna.platform.win32.WinDef.HWND r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 664
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.jna.platform.win32.GDI32Util.getScreenshot(com.sun.jna.platform.win32.WinDef$HWND):java.awt.image.BufferedImage");
    }
}
