package org.scribe.exceptions;

/* loaded from: classes2.dex */
public class OAuthException extends RuntimeException {
    private static final long serialVersionUID = 1;

    public OAuthException(String str, Exception exc) {
        super(str, exc);
    }

    public OAuthException(String str) {
        super(str, null);
    }
}
