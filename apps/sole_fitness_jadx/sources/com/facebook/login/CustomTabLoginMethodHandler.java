package com.facebook.login;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.AccessTokenSource;
import com.facebook.CustomTabMainActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.FacebookServiceException;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.CustomTab;
import com.facebook.internal.CustomTabUtils;
import com.facebook.internal.InstagramCustomTab;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.login.LoginClient;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class CustomTabLoginMethodHandler extends WebLoginMethodHandler {
    private static final int API_EC_DIALOG_CANCEL = 4201;
    private static final int CHALLENGE_LENGTH = 20;
    public static final Parcelable.Creator<CustomTabLoginMethodHandler> CREATOR = new Parcelable.Creator() { // from class: com.facebook.login.CustomTabLoginMethodHandler.1
        @Override // android.os.Parcelable.Creator
        public CustomTabLoginMethodHandler createFromParcel(Parcel parcel) {
            return new CustomTabLoginMethodHandler(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public CustomTabLoginMethodHandler[] newArray(int i) {
            return new CustomTabLoginMethodHandler[i];
        }
    };
    private static final int CUSTOM_TAB_REQUEST_CODE = 1;
    public static final String OAUTH_DIALOG = "oauth";
    public static boolean calledThroughLoggedOutAppSwitch = false;
    private String currentPackage;
    private String expectedChallenge;
    private String validRedirectURI;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.facebook.login.LoginMethodHandler
    String getNameForLogging() {
        return "custom_tab";
    }

    @Override // com.facebook.login.WebLoginMethodHandler
    protected String getSSODevice() {
        return "chrome_custom_tab";
    }

    @Override // com.facebook.login.LoginMethodHandler
    public /* bridge */ /* synthetic */ boolean shouldKeepTrackOfMultipleIntents() {
        return super.shouldKeepTrackOfMultipleIntents();
    }

    CustomTabLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
        this.validRedirectURI = "";
        this.expectedChallenge = Utility.generateRandomString(20);
        calledThroughLoggedOutAppSwitch = false;
        this.validRedirectURI = CustomTabUtils.getValidRedirectURI(getDeveloperDefinedRedirectURI());
    }

    @Override // com.facebook.login.WebLoginMethodHandler
    AccessTokenSource getTokenSource() {
        return AccessTokenSource.CHROME_CUSTOM_TAB;
    }

    private String getDeveloperDefinedRedirectURI() {
        return super.getRedirectUrl();
    }

    @Override // com.facebook.login.WebLoginMethodHandler
    protected String getRedirectUrl() {
        return this.validRedirectURI;
    }

    @Override // com.facebook.login.LoginMethodHandler
    int tryAuthorize(LoginClient.Request request) {
        if (getRedirectUrl().isEmpty()) {
            return 0;
        }
        Bundle bundleAddExtraParameters = addExtraParameters(getParameters(request), request);
        if (calledThroughLoggedOutAppSwitch) {
            bundleAddExtraParameters.putString(ServerProtocol.DIALOG_PARAM_CCT_OVER_LOGGED_OUT_APP_SWITCH, AppEventsConstants.EVENT_PARAM_VALUE_YES);
        }
        if (FacebookSdk.hasCustomTabsPrefetching) {
            if (request.isInstagramLogin()) {
                CustomTabPrefetchHelper.mayLaunchUrl(InstagramCustomTab.getURIForAction(OAUTH_DIALOG, bundleAddExtraParameters));
            } else {
                CustomTabPrefetchHelper.mayLaunchUrl(CustomTab.getURIForAction(OAUTH_DIALOG, bundleAddExtraParameters));
            }
        }
        Intent intent = new Intent(this.loginClient.getActivity(), (Class<?>) CustomTabMainActivity.class);
        intent.putExtra(CustomTabMainActivity.EXTRA_ACTION, OAUTH_DIALOG);
        intent.putExtra(CustomTabMainActivity.EXTRA_PARAMS, bundleAddExtraParameters);
        intent.putExtra(CustomTabMainActivity.EXTRA_CHROME_PACKAGE, getChromePackage());
        intent.putExtra(CustomTabMainActivity.EXTRA_TARGET_APP, request.getLoginTargetApp().getTargetApp());
        this.loginClient.getFragment().startActivityForResult(intent, 1);
        return 1;
    }

    private String getChromePackage() {
        String str = this.currentPackage;
        if (str != null) {
            return str;
        }
        String chromePackage = CustomTabUtils.getChromePackage();
        this.currentPackage = chromePackage;
        return chromePackage;
    }

    @Override // com.facebook.login.LoginMethodHandler
    boolean onActivityResult(int i, int i2, Intent intent) throws NumberFormatException {
        if (intent != null && intent.getBooleanExtra(CustomTabMainActivity.NO_ACTIVITY_EXCEPTION, false)) {
            return super.onActivityResult(i, i2, intent);
        }
        if (i != 1) {
            return super.onActivityResult(i, i2, intent);
        }
        LoginClient.Request pendingRequest = this.loginClient.getPendingRequest();
        if (i2 == -1) {
            onCustomTabComplete(intent.getStringExtra(CustomTabMainActivity.EXTRA_URL), pendingRequest);
            return true;
        }
        super.onComplete(pendingRequest, null, new FacebookOperationCanceledException());
        return false;
    }

    private void onCustomTabComplete(String str, LoginClient.Request request) throws NumberFormatException {
        int i;
        if (str != null) {
            if (str.startsWith(Validate.CUSTOM_TAB_REDIRECT_URI_PREFIX) || str.startsWith(super.getRedirectUrl())) {
                Uri uri = Uri.parse(str);
                Bundle urlQueryString = Utility.parseUrlQueryString(uri.getQuery());
                urlQueryString.putAll(Utility.parseUrlQueryString(uri.getFragment()));
                if (!validateChallengeParam(urlQueryString)) {
                    super.onComplete(request, null, new FacebookException("Invalid state parameter"));
                    return;
                }
                String string = urlQueryString.getString("error");
                if (string == null) {
                    string = urlQueryString.getString("error_type");
                }
                String string2 = urlQueryString.getString("error_msg");
                if (string2 == null) {
                    string2 = urlQueryString.getString("error_message");
                }
                if (string2 == null) {
                    string2 = urlQueryString.getString(NativeProtocol.BRIDGE_ARG_ERROR_DESCRIPTION);
                }
                String string3 = urlQueryString.getString("error_code");
                if (Utility.isNullOrEmpty(string3)) {
                    i = -1;
                } else {
                    try {
                        i = Integer.parseInt(string3);
                    } catch (NumberFormatException unused) {
                    }
                }
                if (Utility.isNullOrEmpty(string) && Utility.isNullOrEmpty(string2) && i == -1) {
                    super.onComplete(request, urlQueryString, null);
                    return;
                }
                if (string != null && (string.equals("access_denied") || string.equals("OAuthAccessDeniedException"))) {
                    super.onComplete(request, null, new FacebookOperationCanceledException());
                } else if (i == 4201) {
                    super.onComplete(request, null, new FacebookOperationCanceledException());
                } else {
                    super.onComplete(request, null, new FacebookServiceException(new FacebookRequestError(i, string, string2), string2));
                }
            }
        }
    }

    @Override // com.facebook.login.LoginMethodHandler
    protected void putChallengeParam(JSONObject jSONObject) throws JSONException {
        jSONObject.put("7_challenge", this.expectedChallenge);
    }

    private boolean validateChallengeParam(Bundle bundle) {
        try {
            String string = bundle.getString(ServerProtocol.DIALOG_PARAM_STATE);
            if (string == null) {
                return false;
            }
            return new JSONObject(string).getString("7_challenge").equals(this.expectedChallenge);
        } catch (JSONException unused) {
            return false;
        }
    }

    CustomTabLoginMethodHandler(Parcel parcel) {
        super(parcel);
        this.validRedirectURI = "";
        this.expectedChallenge = parcel.readString();
    }

    @Override // com.facebook.login.LoginMethodHandler, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.expectedChallenge);
    }
}
