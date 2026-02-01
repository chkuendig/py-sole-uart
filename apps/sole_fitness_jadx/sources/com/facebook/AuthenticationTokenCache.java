package com.facebook;

import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AuthenticationTokenCache.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\n\u001a\u00020\u000bJ\b\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0007R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/facebook/AuthenticationTokenCache;", "", "()V", "sharedPreferences", "Landroid/content/SharedPreferences;", "(Landroid/content/SharedPreferences;)V", "cachedAuthenticationToken", "Lcom/facebook/AuthenticationToken;", "getCachedAuthenticationToken", "()Lcom/facebook/AuthenticationToken;", "clear", "", "hasCachedAuthenticationToken", "", "load", "save", "authenticationToken", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AuthenticationTokenCache {
    public static final String CACHED_AUTHENTICATION_TOKEN_KEY = "com.facebook.AuthenticationManager.CachedAuthenticationToken";
    public static final String CACHED_AUTHENTICATION_TOKEN_NONCE_KEY = "com.facebook.AuthenticationManager.CachedAuthenticationTokenNonce";
    private final SharedPreferences sharedPreferences;

    public AuthenticationTokenCache(SharedPreferences sharedPreferences) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        this.sharedPreferences = sharedPreferences;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public AuthenticationTokenCache() {
        SharedPreferences sharedPreferences = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.AccessTokenManager.SharedPreferences", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "FacebookSdk.getApplicati…    Context.MODE_PRIVATE)");
        this(sharedPreferences);
    }

    public final AuthenticationToken load() {
        if (hasCachedAuthenticationToken()) {
            return getCachedAuthenticationToken();
        }
        return null;
    }

    public final void save(AuthenticationToken authenticationToken) {
        Intrinsics.checkNotNullParameter(authenticationToken, "authenticationToken");
        this.sharedPreferences.edit().putString(CACHED_AUTHENTICATION_TOKEN_KEY, authenticationToken.getToken()).putString(CACHED_AUTHENTICATION_TOKEN_NONCE_KEY, authenticationToken.getExpectedNonce()).apply();
    }

    public final void clear() {
        this.sharedPreferences.edit().remove(CACHED_AUTHENTICATION_TOKEN_KEY).apply();
        this.sharedPreferences.edit().remove(CACHED_AUTHENTICATION_TOKEN_NONCE_KEY).apply();
    }

    private final boolean hasCachedAuthenticationToken() {
        return this.sharedPreferences.contains(CACHED_AUTHENTICATION_TOKEN_KEY);
    }

    private final AuthenticationToken getCachedAuthenticationToken() {
        String string = this.sharedPreferences.getString(CACHED_AUTHENTICATION_TOKEN_KEY, null);
        String string2 = this.sharedPreferences.getString(CACHED_AUTHENTICATION_TOKEN_NONCE_KEY, null);
        String str = string;
        if (str == null || str.length() == 0) {
            return null;
        }
        String str2 = string2;
        if (str2 == null || str2.length() == 0) {
            return null;
        }
        try {
            return new AuthenticationToken(string, string2);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }
}
