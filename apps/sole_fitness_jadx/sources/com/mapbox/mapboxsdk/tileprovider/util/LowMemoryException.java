package com.mapbox.mapboxsdk.tileprovider.util;

/* loaded from: classes2.dex */
public final class LowMemoryException extends Exception {
    private static final long serialVersionUID = 146526524087765134L;

    public LowMemoryException(String str) {
        super(str);
    }

    public LowMemoryException(Throwable th) {
        super(th);
    }
}
