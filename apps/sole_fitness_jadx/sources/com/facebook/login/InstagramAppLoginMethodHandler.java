package com.facebook.login;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.AccessTokenSource;
import com.facebook.internal.NativeProtocol;
import com.facebook.login.LoginClient;

/* loaded from: classes.dex */
class InstagramAppLoginMethodHandler extends NativeAppLoginMethodHandler {
    public static final Parcelable.Creator<InstagramAppLoginMethodHandler> CREATOR = new Parcelable.Creator() { // from class: com.facebook.login.InstagramAppLoginMethodHandler.1
        @Override // android.os.Parcelable.Creator
        public InstagramAppLoginMethodHandler createFromParcel(Parcel parcel) {
            return new InstagramAppLoginMethodHandler(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public InstagramAppLoginMethodHandler[] newArray(int i) {
            return new InstagramAppLoginMethodHandler[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.facebook.login.LoginMethodHandler
    String getNameForLogging() {
        return "instagram_login";
    }

    InstagramAppLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
    }

    @Override // com.facebook.login.NativeAppLoginMethodHandler
    public AccessTokenSource getTokenSource() {
        return AccessTokenSource.INSTAGRAM_APPLICATION_WEB;
    }

    @Override // com.facebook.login.NativeAppLoginMethodHandler, com.facebook.login.LoginMethodHandler
    int tryAuthorize(LoginClient.Request request) {
        String e2e = LoginClient.getE2E();
        Intent intentCreateInstagramIntent = NativeProtocol.createInstagramIntent(this.loginClient.getActivity(), request.getApplicationId(), request.getPermissions(), e2e, request.isRerequest(), request.hasPublishPermission(), request.getDefaultAudience(), getClientState(request.getAuthId()), request.getAuthType(), request.getMessengerPageId(), request.getResetMessengerState(), request.isFamilyLogin(), request.shouldSkipAccountDeduplication());
        addLoggingExtra("e2e", e2e);
        return tryIntent(intentCreateInstagramIntent, LoginClient.getLoginRequestCode()) ? 1 : 0;
    }

    InstagramAppLoginMethodHandler(Parcel parcel) {
        super(parcel);
    }

    @Override // com.facebook.login.LoginMethodHandler, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }
}
