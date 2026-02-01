package org.scribe.model;

import java.io.Serializable;
import org.scribe.utils.Preconditions;

/* loaded from: classes2.dex */
public class Token implements Serializable {
    private static final long serialVersionUID = 715000866082812683L;
    private final String rawResponse;
    private final String secret;
    private final String token;

    public Token(String str, String str2) {
        this(str, str2, null);
    }

    public Token(String str, String str2, String str3) {
        Preconditions.checkNotNull(str, "Token can't be null");
        Preconditions.checkNotNull(str2, "Secret can't be null");
        this.token = str;
        this.secret = str2;
        this.rawResponse = str3;
    }

    public String getToken() {
        return this.token;
    }

    public String getSecret() {
        return this.secret;
    }

    public String getRawResponse() {
        String str = this.rawResponse;
        if (str != null) {
            return str;
        }
        throw new IllegalStateException("This token object was not constructed by scribe and does not have a rawResponse");
    }

    public String toString() {
        return String.format("Token[%s , %s]", this.token, this.secret);
    }

    public boolean isEmpty() {
        return "".equals(this.token) && "".equals(this.secret);
    }

    public static Token empty() {
        return new Token("", "");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Token token = (Token) obj;
        return this.token.equals(token.token) && this.secret.equals(token.secret);
    }

    public int hashCode() {
        return (this.token.hashCode() * 31) + this.secret.hashCode();
    }
}
