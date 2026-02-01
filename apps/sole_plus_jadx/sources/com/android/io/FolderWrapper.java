package com.android.io;

import java.io.File;

/* loaded from: classes3.dex */
public class FolderWrapper extends File implements IAbstractFolder {
    private static final long serialVersionUID = 1;

    public FolderWrapper(String pathname) {
        super(pathname);
    }

    @Override // com.android.io.IAbstractFolder
    public IAbstractFile getFile(String name) {
        return new FileWrapper(this, name);
    }

    @Override // com.android.io.IAbstractResource
    public String getOsLocation() {
        return getAbsolutePath();
    }

    @Override // java.io.File, com.android.io.IAbstractResource
    public boolean exists() {
        return isDirectory();
    }
}
