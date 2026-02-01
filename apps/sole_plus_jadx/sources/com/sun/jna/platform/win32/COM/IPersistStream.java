package com.sun.jna.platform.win32.COM;

/* loaded from: classes4.dex */
public interface IPersistStream extends IPersist {
    void GetSizeMax();

    boolean IsDirty();

    void Load(IStream iStream);

    void Save(IStream iStream);
}
