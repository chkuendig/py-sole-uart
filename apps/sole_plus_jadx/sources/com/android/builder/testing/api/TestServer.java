package com.android.builder.testing.api;

import java.io.File;

@Deprecated
/* loaded from: classes3.dex */
public abstract class TestServer {
    public abstract String getName();

    public abstract boolean isConfigured();

    public abstract void uploadApks(String str, File file, File file2);
}
