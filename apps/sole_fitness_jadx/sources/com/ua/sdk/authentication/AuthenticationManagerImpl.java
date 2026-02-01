package com.ua.sdk.authentication;

import android.content.SharedPreferences;
import android.os.SystemClock;
import com.ua.sdk.NetworkError;
import com.ua.sdk.Request;
import com.ua.sdk.Ua;
import com.ua.sdk.UaException;
import com.ua.sdk.UaLog;
import com.ua.sdk.authentication.AuthenticationManager;
import com.ua.sdk.concurrent.LoginRequest;
import com.ua.sdk.internal.Precondition;
import java.net.URLConnection;
import java.util.concurrent.ExecutorService;

/* loaded from: classes2.dex */
public class AuthenticationManagerImpl implements AuthenticationManager {
    protected static final String PREF_ACCESS_TOKEN = "mmdk_oauth2_access_token";
    protected static final String PREF_PREFIX = "mmdk_";
    protected static final String PREF_REFRESH_TIME = "mmdk_oauth2_refresh_time";
    protected static final String PREF_REFRESH_TOKEN = "mmdk_oauth2_refresh_token";
    protected static final int TIMEOUT_DELTA = 1200000;
    protected AuthenticationService authService;
    protected ExecutorService executorService;
    protected OAuth2Credentials oAuth2Credentials;
    private long refreshNanos = Long.MIN_VALUE;
    protected SharedPreferences sharedPrefs;

    public void init(AuthenticationService authenticationService, ExecutorService executorService, SharedPreferences sharedPreferences) {
        this.authService = (AuthenticationService) Precondition.isNotNull(authenticationService);
        this.executorService = (ExecutorService) Precondition.isNotNull(executorService);
        this.sharedPrefs = (SharedPreferences) Precondition.isNotNull(sharedPreferences);
        String string = sharedPreferences.getString(PREF_ACCESS_TOKEN, null);
        if (string != null) {
            String string2 = sharedPreferences.getString(PREF_REFRESH_TOKEN, null);
            long j = sharedPreferences.getLong(PREF_REFRESH_TIME, 0L);
            OAuth2CredentialsImpl oAuth2CredentialsImpl = new OAuth2CredentialsImpl();
            this.oAuth2Credentials = oAuth2CredentialsImpl;
            oAuth2CredentialsImpl.setAccessToken(string);
            this.oAuth2Credentials.setRefreshToken(string2);
            this.oAuth2Credentials.setExpiresAt(Long.valueOf(j));
        }
    }

    @Override // com.ua.sdk.authentication.AuthenticationManager
    public synchronized void refreshToken(long j) throws UaException {
        if (!isAuthenticated()) {
            UaLog.error("Can't refresh Oauth2Credentials, not authenticated.");
            throw new UaException(UaException.Code.NOT_AUTHENTICATED);
        }
        if (j > this.refreshNanos) {
            try {
                try {
                    OAuth2Credentials oAuth2CredentialsRefreshAuthentication = this.authService.refreshAuthentication(this.oAuth2Credentials);
                    this.refreshNanos = SystemClock.elapsedRealtime();
                    setOAuth2Credentials(oAuth2CredentialsRefreshAuthentication);
                    UaLog.debug("Oauth2Credentials have been refreshed");
                } catch (NetworkError e) {
                    if (e.getResponseCode() == 401) {
                        UaLog.error("Failed to refresh Oauth2Credentials.", (Throwable) e);
                    }
                    onLogout();
                    throw e;
                }
            } catch (UaException e2) {
                UaLog.error("Failed to refresh Oauth2Credentials.", (Throwable) e2);
                throw e2;
            }
        } else {
            UaLog.debug("Oauth2Credentials were already refreshed. Not refreshing again.");
        }
    }

    /* renamed from: com.ua.sdk.authentication.AuthenticationManagerImpl$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$ua$sdk$authentication$AuthenticationManager$AuthenticationType;

        static {
            int[] iArr = new int[AuthenticationManager.AuthenticationType.values().length];
            $SwitchMap$com$ua$sdk$authentication$AuthenticationManager$AuthenticationType = iArr;
            try {
                iArr[AuthenticationManager.AuthenticationType.USER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ua$sdk$authentication$AuthenticationManager$AuthenticationType[AuthenticationManager.AuthenticationType.CLIENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ua$sdk$authentication$AuthenticationManager$AuthenticationType[AuthenticationManager.AuthenticationType.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // com.ua.sdk.authentication.AuthenticationManager
    public void sign(URLConnection uRLConnection, AuthenticationManager.AuthenticationType authenticationType) throws UaException {
        if (authenticationType != null) {
            int i = AnonymousClass2.$SwitchMap$com$ua$sdk$authentication$AuthenticationManager$AuthenticationType[authenticationType.ordinal()];
            if (i == 1) {
                signAsUser(uRLConnection);
            } else {
                if (i != 2) {
                    return;
                }
                signAsClient(uRLConnection);
            }
        }
    }

    @Override // com.ua.sdk.authentication.AuthenticationManager
    public synchronized void signAsUser(URLConnection uRLConnection) throws UaException {
        Precondition.isAuthenticated(this);
        if (this.oAuth2Credentials != null) {
            refreshUserTokenIfNeeded();
            signConnection(this.oAuth2Credentials, uRLConnection);
        }
    }

    @Override // com.ua.sdk.authentication.AuthenticationManager
    public synchronized void signAsClient(URLConnection uRLConnection) throws UaException {
        signConnection(this.authService.authenticateClient(), uRLConnection);
    }

    private synchronized void signConnection(OAuth2Credentials oAuth2Credentials, URLConnection uRLConnection) {
        uRLConnection.setRequestProperty("Authorization", "Bearer " + oAuth2Credentials.getAccessToken());
    }

    private synchronized void refreshUserTokenIfNeeded() throws UaException {
        OAuth2Credentials oAuth2Credentials = this.oAuth2Credentials;
        if (oAuth2Credentials != null && oAuth2Credentials.getExpiresAt().longValue() - 1200000 <= System.currentTimeMillis()) {
            refreshToken(System.nanoTime());
        }
    }

    @Override // com.ua.sdk.authentication.AuthenticationManager
    public synchronized void login(String str) throws UaException {
        UaLog.debug("Attempting login with authorization code.");
        setOAuth2Credentials(this.authService.authenticateUser(str));
        UaLog.debug("Successfully logged in using authorization code.");
    }

    @Override // com.ua.sdk.authentication.AuthenticationManager
    public Request login(final String str, Ua.LoginCallback loginCallback) {
        final LoginRequest loginRequest = new LoginRequest(loginCallback);
        loginRequest.setFuture(this.executorService.submit(new Runnable() { // from class: com.ua.sdk.authentication.AuthenticationManagerImpl.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AuthenticationManagerImpl.this.login(str);
                    loginRequest.done(null, null);
                } catch (UaException e) {
                    AuthenticationManagerImpl.this.onLogout();
                    UaLog.error("Failed to log in with authorization code.", (Throwable) e);
                    loginRequest.done(null, e);
                }
            }
        }));
        return loginRequest;
    }

    @Override // com.ua.sdk.authentication.AuthenticationManager
    public boolean isAuthenticated() {
        return this.oAuth2Credentials != null;
    }

    @Override // com.ua.sdk.authentication.AuthenticationManager
    public synchronized void onLogout() {
        this.oAuth2Credentials = null;
        this.sharedPrefs.edit().remove(PREF_ACCESS_TOKEN).remove(PREF_REFRESH_TOKEN).remove(PREF_REFRESH_TIME).commit();
    }

    @Override // com.ua.sdk.authentication.AuthenticationManager
    public synchronized void setOAuth2Credentials(OAuth2Credentials oAuth2Credentials) {
        Precondition.isNotNull(oAuth2Credentials, "oAuth2Credentials");
        this.oAuth2Credentials = oAuth2Credentials;
        this.sharedPrefs.edit().putString(PREF_ACCESS_TOKEN, oAuth2Credentials.getAccessToken()).putString(PREF_REFRESH_TOKEN, oAuth2Credentials.getRefreshToken()).putLong(PREF_REFRESH_TIME, oAuth2Credentials.getExpiresAt().longValue()).commit();
    }

    @Override // com.ua.sdk.authentication.AuthenticationManager
    public OAuth2Credentials getOAuth2Credentials() {
        return this.oAuth2Credentials;
    }

    @Override // com.ua.sdk.authentication.AuthenticationManager
    public synchronized void requestUserAuthorization(String str) {
        this.authService.requestUserAuthorization(str);
    }

    @Override // com.ua.sdk.authentication.AuthenticationManager
    public synchronized String getUserAuthorizationUrl(String str) {
        return this.authService.getUserAuthorizationUrl(str);
    }
}
