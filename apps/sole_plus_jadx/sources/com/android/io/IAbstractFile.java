package com.android.io;

import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes3.dex */
public interface IAbstractFile extends IAbstractResource {
    InputStream getContents() throws StreamException;

    OutputStream getOutputStream() throws StreamException;

    void setContents(InputStream source) throws StreamException;
}
