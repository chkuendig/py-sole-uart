package com.ua.sdk.concurrent;

import com.ua.sdk.ResetPasswordCallback;
import com.ua.sdk.UaException;

/* loaded from: classes2.dex */
public class ResetPasswordRequest extends AsyncRequest<Void> {
    private final ResetPasswordCallback callback;

    public ResetPasswordRequest(ResetPasswordCallback resetPasswordCallback) {
        this.callback = resetPasswordCallback;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.ua.sdk.concurrent.AsyncRequest
    public void onDone(Void r1, UaException uaException) {
        EntityEventHandler.callOnResetPassword(uaException, this.callback);
    }
}
