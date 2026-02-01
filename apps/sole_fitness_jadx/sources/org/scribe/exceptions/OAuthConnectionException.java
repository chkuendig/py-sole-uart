package org.scribe.exceptions;

/* loaded from: classes2.dex */
public class OAuthConnectionException extends OAuthException {
    private static final String MSG = "There was a problem while creating a connection to the remote service.";

    public OAuthConnectionException(Exception exc) {
        super(MSG, exc);
    }
}
