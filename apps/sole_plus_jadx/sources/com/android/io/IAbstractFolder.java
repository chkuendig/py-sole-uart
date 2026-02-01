package com.android.io;

/* loaded from: classes3.dex */
public interface IAbstractFolder extends IAbstractResource {

    public interface FilenameFilter {
        boolean accept(IAbstractFolder dir, String name);
    }

    IAbstractFile getFile(String name);
}
