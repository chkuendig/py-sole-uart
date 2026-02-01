package com.ua.sdk.internal;

import com.ua.sdk.UaException;
import java.io.OutputStream;

/* loaded from: classes2.dex */
public interface JsonWriter<T> {
    void write(T t, OutputStream outputStream) throws UaException;
}
