package com.android.ddmlib.internal.jdwp;

import com.android.ddmlib.TimeoutException;
import java.io.IOException;

/* loaded from: classes3.dex */
interface JdwpSocketHandler {
    void read() throws IOException, TimeoutException;

    void shutdown() throws IOException;
}
