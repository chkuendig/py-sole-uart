package com.android.io;

/* loaded from: classes3.dex */
public class StreamException extends Exception {
    private static final long serialVersionUID = 1;
    private final Error mError;
    private final IAbstractFile mFile;

    public enum Error {
        DEFAULT,
        OUTOFSYNC,
        FILENOTFOUND
    }

    public StreamException(Exception e, IAbstractFile file) {
        this(e, file, Error.DEFAULT);
    }

    public StreamException(Exception e, IAbstractFile file, Error error) {
        super(e);
        this.mFile = file;
        this.mError = error;
    }

    public Error getError() {
        return this.mError;
    }

    public IAbstractFile getFile() {
        return this.mFile;
    }
}
