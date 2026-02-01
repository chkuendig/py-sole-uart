package com.ua.sdk.internal;

import com.ua.sdk.UaException;
import java.io.InputStream;

/* loaded from: classes2.dex */
public interface JsonParser<T> {
    T parse(InputStream inputStream) throws UaException;
}
