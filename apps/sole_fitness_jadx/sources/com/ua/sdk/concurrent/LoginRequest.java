package com.ua.sdk.concurrent;

import com.ua.sdk.Ua;
import com.ua.sdk.UaException;
import com.ua.sdk.user.User;

/* loaded from: classes2.dex */
public class LoginRequest extends AsyncRequest<User> {
    private final Ua.LoginCallback callback;

    public LoginRequest(Ua.LoginCallback loginCallback) {
        this.callback = loginCallback;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.ua.sdk.concurrent.AsyncRequest
    public void onDone(User user, UaException uaException) {
        EntityEventHandler.callOnLogin(user, uaException, this.callback);
    }
}
