package com.facebook.internal.security;

import android.util.Base64;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;

/* compiled from: OidcSecurityUtil.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004H\u0007J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0007J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0007R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/facebook/internal/security/OidcSecurityUtil;", "", "()V", "OPENID_KEYS_URL_STRING", "", "getOPENID_KEYS_URL_STRING", "()Ljava/lang/String;", "SIGNATURE_ALGORITHM_SHA256", "getPublicKeyFromString", "Ljava/security/PublicKey;", SDKConstants.PARAM_KEY, "getRawKeyFromEndPoint", "kid", "verify", "", "publicKey", "data", "signature", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class OidcSecurityUtil {
    public static final OidcSecurityUtil INSTANCE = new OidcSecurityUtil();
    private static final String OPENID_KEYS_URL_STRING = "https://www.facebook.com/.well-known/oauth/openid/keys/";
    public static final String SIGNATURE_ALGORITHM_SHA256 = "SHA256withRSA";

    private OidcSecurityUtil() {
    }

    public final String getOPENID_KEYS_URL_STRING() {
        return OPENID_KEYS_URL_STRING;
    }

    @JvmStatic
    public static final String getRawKeyFromEndPoint(String kid) throws IOException {
        String strOptString;
        Intrinsics.checkNotNullParameter(kid, "kid");
        URLConnection uRLConnectionOpenConnection = new URL(OPENID_KEYS_URL_STRING).openConnection();
        Objects.requireNonNull(uRLConnectionOpenConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
        HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
        try {
            InputStream inputStream = httpURLConnection.getInputStream();
            Intrinsics.checkNotNullExpressionValue(inputStream, "connection.inputStream");
            Reader inputStreamReader = new InputStreamReader(inputStream, Charsets.UTF_8);
            strOptString = new JSONObject(TextStreamsKt.readText(inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192))).optString(kid);
        } catch (Exception unused) {
            strOptString = null;
        } catch (Throwable th) {
            httpURLConnection.disconnect();
            throw th;
        }
        httpURLConnection.disconnect();
        return strOptString;
    }

    @JvmStatic
    public static final PublicKey getPublicKeyFromString(String key) throws InvalidKeySpecException {
        Intrinsics.checkNotNullParameter(key, "key");
        byte[] bArrDecode = Base64.decode(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(key, StringUtils.LF, "", false, 4, (Object) null), "-----BEGIN PUBLIC KEY-----", "", false, 4, (Object) null), "-----END PUBLIC KEY-----", "", false, 4, (Object) null), 0);
        Intrinsics.checkNotNullExpressionValue(bArrDecode, "Base64.decode(pubKeyString, Base64.DEFAULT)");
        PublicKey publicKeyGeneratePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bArrDecode));
        Intrinsics.checkNotNullExpressionValue(publicKeyGeneratePublic, "kf.generatePublic(x509publicKey)");
        return publicKeyGeneratePublic;
    }

    @JvmStatic
    public static final boolean verify(PublicKey publicKey, String data, String signature) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        Intrinsics.checkNotNullParameter(publicKey, "publicKey");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(signature, "signature");
        try {
            Signature signature2 = Signature.getInstance(SIGNATURE_ALGORITHM_SHA256);
            signature2.initVerify(publicKey);
            byte[] bytes = data.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
            signature2.update(bytes);
            byte[] bArrDecode = Base64.decode(signature, 8);
            Intrinsics.checkNotNullExpressionValue(bArrDecode, "Base64.decode(signature, Base64.URL_SAFE)");
            return signature2.verify(bArrDecode);
        } catch (Exception unused) {
            return false;
        }
    }
}
