package org.scribe.exceptions;

/* loaded from: classes2.dex */
public class OAuthSignatureException extends OAuthException {
    private static final String MSG = "Error while signing string: %s";
    private static final long serialVersionUID = 1;

    public OAuthSignatureException(String str, Exception exc) {
        super(String.format(MSG, str), exc);
    }
}
