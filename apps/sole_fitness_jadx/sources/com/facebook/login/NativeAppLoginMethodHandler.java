package com.facebook.login;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.login.LoginClient;

/* loaded from: classes.dex */
abstract class NativeAppLoginMethodHandler extends LoginMethodHandler {
    @Override // com.facebook.login.LoginMethodHandler
    abstract int tryAuthorize(LoginClient.Request request);

    NativeAppLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
    }

    NativeAppLoginMethodHandler(Parcel parcel) {
        super(parcel);
    }

    public AccessTokenSource getTokenSource() {
        return AccessTokenSource.FACEBOOK_APPLICATION_WEB;
    }

    @Override // com.facebook.login.LoginMethodHandler
    boolean onActivityResult(int i, int i2, Intent intent) {
        LoginClient.Request pendingRequest = this.loginClient.getPendingRequest();
        if (intent == null) {
            completeLogin(LoginClient.Result.createCancelResult(pendingRequest, "Operation canceled"));
        } else if (i2 == 0) {
            handleResultCancel(pendingRequest, intent);
        } else {
            if (i2 != -1) {
                completeLogin(LoginClient.Result.createErrorResult(pendingRequest, "Unexpected resultCode from authorization.", null));
            } else {
                Bundle extras = intent.getExtras();
                if (extras == null) {
                    completeLogin(LoginClient.Result.createErrorResult(pendingRequest, "Unexpected null from returned authorization data.", null));
                    return true;
                }
                String error = getError(extras);
                String string = extras.get("error_code") != null ? extras.get("error_code").toString() : null;
                String errorMessage = getErrorMessage(extras);
                String string2 = extras.getString("e2e");
                if (!Utility.isNullOrEmpty(string2)) {
                    logWebLoginCompleted(string2);
                }
                if (error == null && string == null && errorMessage == null) {
                    handleResultOk(pendingRequest, extras);
                } else {
                    handleResultError(pendingRequest, error, errorMessage, string);
                }
            }
        }
        return true;
    }

    private void completeLogin(LoginClient.Result result) {
        if (result != null) {
            this.loginClient.completeAndValidate(result);
        } else {
            this.loginClient.tryNextHandler();
        }
    }

    protected void handleResultError(LoginClient.Request request, String str, String str2, String str3) {
        if (str != null && str.equals("logged_out")) {
            CustomTabLoginMethodHandler.calledThroughLoggedOutAppSwitch = true;
            completeLogin(null);
        } else if (ServerProtocol.getErrorsProxyAuthDisabled().contains(str)) {
            completeLogin(null);
        } else if (ServerProtocol.getErrorsUserCanceled().contains(str)) {
            completeLogin(LoginClient.Result.createCancelResult(request, null));
        } else {
            completeLogin(LoginClient.Result.createErrorResult(request, str, str2, str3));
        }
    }

    protected void handleResultOk(LoginClient.Request request, Bundle bundle) {
        try {
            completeLogin(LoginClient.Result.createCompositeTokenResult(request, createAccessTokenFromWebBundle(request.getPermissions(), bundle, getTokenSource(), request.getApplicationId()), createAuthenticationTokenFromWebBundle(bundle, request.getNonce())));
        } catch (FacebookException e) {
            completeLogin(LoginClient.Result.createErrorResult(request, null, e.getMessage()));
        }
    }

    protected void handleResultCancel(LoginClient.Request request, Intent intent) {
        Bundle extras = intent.getExtras();
        String error = getError(extras);
        String string = extras.get("error_code") != null ? extras.get("error_code").toString() : null;
        if (ServerProtocol.getErrorConnectionFailure().equals(string)) {
            completeLogin(LoginClient.Result.createErrorResult(request, error, getErrorMessage(extras), string));
        }
        completeLogin(LoginClient.Result.createCancelResult(request, error));
    }

    protected String getError(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        String string = bundle.getString("error");
        return string == null ? bundle.getString("error_type") : string;
    }

    protected String getErrorMessage(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        String string = bundle.getString("error_message");
        return string == null ? bundle.getString(NativeProtocol.BRIDGE_ARG_ERROR_DESCRIPTION) : string;
    }

    protected boolean tryIntent(Intent intent, int i) {
        if (intent == null) {
            return false;
        }
        try {
            this.loginClient.getFragment().startActivityForResult(intent, i);
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        }
    }
}
