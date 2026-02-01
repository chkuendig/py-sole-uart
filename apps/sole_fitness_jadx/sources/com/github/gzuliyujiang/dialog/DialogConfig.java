package com.github.gzuliyujiang.dialog;

/* loaded from: classes.dex */
public final class DialogConfig {
    private static DialogColor dialogColor = new DialogColor();
    private static int dialogStyle;

    private DialogConfig() {
    }

    public static void setDialogStyle(int i) {
        dialogStyle = i;
    }

    public static int getDialogStyle() {
        return dialogStyle;
    }

    public static void setDialogColor(DialogColor dialogColor2) {
        dialogColor = dialogColor2;
    }

    public static DialogColor getDialogColor() {
        if (dialogColor == null) {
            dialogColor = new DialogColor();
        }
        return dialogColor;
    }
}
