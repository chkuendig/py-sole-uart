package com.facebook.login;

import com.facebook.AccessToken;
import com.facebook.AuthenticationToken;
import java.util.Set;

/* loaded from: classes.dex */
public class LoginResult {
    private final AccessToken accessToken;
    private final AuthenticationToken authenticationToken;
    private final Set<String> recentlyDeniedPermissions;
    private final Set<String> recentlyGrantedPermissions;

    public LoginResult(AccessToken accessToken, Set<String> set, Set<String> set2) {
        this(accessToken, null, set, set2);
    }

    public LoginResult(AccessToken accessToken, AuthenticationToken authenticationToken, Set<String> set, Set<String> set2) {
        this.accessToken = accessToken;
        this.authenticationToken = authenticationToken;
        this.recentlyGrantedPermissions = set;
        this.recentlyDeniedPermissions = set2;
    }

    public AccessToken getAccessToken() {
        return this.accessToken;
    }

    public AuthenticationToken getAuthenticationToken() {
        return this.authenticationToken;
    }

    public Set<String> getRecentlyGrantedPermissions() {
        return this.recentlyGrantedPermissions;
    }

    public Set<String> getRecentlyDeniedPermissions() {
        return this.recentlyDeniedPermissions;
    }
}
