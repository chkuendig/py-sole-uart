package com.github.gzuliyujiang.dialog;

import java.io.Serializable;

/* loaded from: classes.dex */
public class DialogColor implements Serializable {
    private int contentBackgroundColor = -1;
    private int topLineColor = -2236963;
    private int titleTextColor = -10066330;
    private int cancelTextColor = -13421773;
    private int okTextColor = -13421773;
    private int cancelEllipseColor = -723724;
    private int okEllipseColor = -16743937;

    public DialogColor contentBackgroundColor(int i) {
        this.contentBackgroundColor = i;
        return this;
    }

    public int contentBackgroundColor() {
        return this.contentBackgroundColor;
    }

    public DialogColor topLineColor(int i) {
        this.topLineColor = i;
        return this;
    }

    public int topLineColor() {
        return this.topLineColor;
    }

    public DialogColor titleTextColor(int i) {
        this.titleTextColor = i;
        return this;
    }

    public int titleTextColor() {
        return this.titleTextColor;
    }

    public DialogColor cancelTextColor(int i) {
        this.cancelTextColor = i;
        return this;
    }

    public int cancelTextColor() {
        return this.cancelTextColor;
    }

    public DialogColor okTextColor(int i) {
        this.okTextColor = i;
        return this;
    }

    public int okTextColor() {
        return this.okTextColor;
    }

    public DialogColor cancelEllipseColor(int i) {
        this.cancelEllipseColor = i;
        return this;
    }

    public int cancelEllipseColor() {
        return this.cancelEllipseColor;
    }

    public DialogColor okEllipseColor(int i) {
        this.okEllipseColor = i;
        return this;
    }

    public int okEllipseColor() {
        return this.okEllipseColor;
    }
}
