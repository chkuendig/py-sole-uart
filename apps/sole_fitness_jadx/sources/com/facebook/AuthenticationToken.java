package com.facebook;

import android.os.Parcel;
import android.os.Parcelable;
import com.dyaco.sole.R2;
import com.facebook.internal.Validate;
import com.facebook.internal.security.OidcSecurityUtil;
import java.io.IOException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.lang3.ClassUtils;

/* compiled from: AuthenticationToken.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 &2\u00020\u0001:\u0001&B\u0017\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005B\u000f\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0096\u0002J\b\u0010\u001c\u001a\u00020\u0017H\u0016J(\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u0003H\u0002J\u0018\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0017H\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000e¨\u0006'"}, d2 = {"Lcom/facebook/AuthenticationToken;", "Landroid/os/Parcelable;", "token", "", "expectedNonce", "(Ljava/lang/String;Ljava/lang/String;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "claims", "Lcom/facebook/AuthenticationTokenClaims;", "getClaims", "()Lcom/facebook/AuthenticationTokenClaims;", "getExpectedNonce", "()Ljava/lang/String;", "header", "Lcom/facebook/AuthenticationTokenHeader;", "getHeader", "()Lcom/facebook/AuthenticationTokenHeader;", "signature", "getSignature", "getToken", "describeContents", "", "equals", "", "other", "", "hashCode", "isValidSignature", "headerString", "claimsString", "sigString", "kid", "writeToParcel", "", "dest", "flags", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AuthenticationToken implements Parcelable {
    public static final String AUTHENTICATION_TOKEN_KEY = "id_token";
    private final AuthenticationTokenClaims claims;
    private final String expectedNonce;
    private final AuthenticationTokenHeader header;
    private final String signature;
    private final String token;
    public static final Parcelable.Creator<AuthenticationToken> CREATOR = new Parcelable.Creator<AuthenticationToken>() { // from class: com.facebook.AuthenticationToken$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AuthenticationToken createFromParcel(Parcel source) {
            Intrinsics.checkNotNullParameter(source, "source");
            return new AuthenticationToken(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AuthenticationToken[] newArray(int size) {
            return new AuthenticationToken[size];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String getToken() {
        return this.token;
    }

    public final String getExpectedNonce() {
        return this.expectedNonce;
    }

    public final AuthenticationTokenHeader getHeader() {
        return this.header;
    }

    public final AuthenticationTokenClaims getClaims() {
        return this.claims;
    }

    public final String getSignature() {
        return this.signature;
    }

    public AuthenticationToken(String token, String expectedNonce) {
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(expectedNonce, "expectedNonce");
        Validate.notEmpty(token, "token");
        Validate.notEmpty(expectedNonce, "expectedNonce");
        List listSplit$default = StringsKt.split$default((CharSequence) token, new String[]{"."}, false, 0, 6, (Object) null);
        if (!(listSplit$default.size() == 3)) {
            throw new IllegalArgumentException("Invalid IdToken string".toString());
        }
        String str = (String) listSplit$default.get(0);
        String str2 = (String) listSplit$default.get(1);
        String str3 = (String) listSplit$default.get(2);
        this.token = token;
        this.expectedNonce = expectedNonce;
        AuthenticationTokenHeader authenticationTokenHeader = new AuthenticationTokenHeader(str);
        this.header = authenticationTokenHeader;
        this.claims = new AuthenticationTokenClaims(str2, expectedNonce);
        if (!isValidSignature(str, str2, str3, authenticationTokenHeader.getKid())) {
            throw new IllegalArgumentException("Invalid Signature".toString());
        }
        this.signature = str3;
    }

    public AuthenticationToken(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String string = parcel.readString();
        Validate.notNullOrEmpty(string, "token");
        if (string != null) {
            this.token = string;
            String string2 = parcel.readString();
            Validate.notNull(string2, "expectedNonce");
            if (string2 != null) {
                this.expectedNonce = string2;
                List listSplit$default = StringsKt.split$default((CharSequence) string, new String[]{"."}, false, 0, 6, (Object) null);
                this.header = new AuthenticationTokenHeader((String) listSplit$default.get(0));
                this.claims = new AuthenticationTokenClaims((String) listSplit$default.get(1), string2);
                this.signature = (String) listSplit$default.get(2);
                return;
            }
            throw new IllegalStateException("Required value was null.".toString());
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof AuthenticationToken) {
            return Intrinsics.areEqual(this.token, ((AuthenticationToken) other).token);
        }
        return false;
    }

    public int hashCode() {
        return R2.attr.quantizeMotionSteps + this.token.hashCode();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.token);
        dest.writeString(this.expectedNonce);
    }

    private final boolean isValidSignature(String headerString, String claimsString, String sigString, String kid) {
        try {
            String rawKeyFromEndPoint = OidcSecurityUtil.getRawKeyFromEndPoint(kid);
            if (rawKeyFromEndPoint != null) {
                return OidcSecurityUtil.verify(OidcSecurityUtil.getPublicKeyFromString(rawKeyFromEndPoint), headerString + ClassUtils.PACKAGE_SEPARATOR_CHAR + claimsString, sigString);
            }
        } catch (IOException | InvalidKeySpecException unused) {
        }
        return false;
    }
}
