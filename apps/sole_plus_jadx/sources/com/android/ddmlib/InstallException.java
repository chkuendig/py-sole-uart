package com.android.ddmlib;

/* loaded from: classes3.dex */
public class InstallException extends CanceledException {
    private static final long serialVersionUID = 1;
    private String errorCode;

    public InstallException(Throwable cause) {
        super(cause.getMessage(), cause);
    }

    public InstallException(String message) {
        super(message);
    }

    public InstallException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public InstallException(String message, Throwable cause) {
        super(message, cause);
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    @Override // com.android.ddmlib.CanceledException
    public boolean wasCanceled() {
        Throwable cause = getCause();
        return (cause instanceof SyncException) && ((SyncException) cause).wasCanceled();
    }
}
