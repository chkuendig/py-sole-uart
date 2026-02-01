package com.sun.jna.platform.win32.COM;

import com.sun.jna.platform.win32.Variant;

/* loaded from: classes4.dex */
public interface IEnumVariant extends IUnknown {
    IEnumVariant Clone();

    Variant.VARIANT[] Next(int i);

    void Reset();

    void Skip(int i);
}
