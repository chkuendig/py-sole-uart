package com.android.utils;

import java.io.IOException;

/* loaded from: classes3.dex */
public interface IReaderLogger extends ILogger {
    int readLine(byte[] inputBuffer) throws IOException;
}
