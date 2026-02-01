package com.facebook.referrals;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.facebook.CallbackManager;
import com.facebook.FacebookActivity;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: classes.dex */
public class ReferralManager {
    private static volatile ReferralManager instance;
    private ReferralLogger logger;

    ReferralManager() {
        Validate.sdkInitialized();
    }

    public static ReferralManager getInstance() {
        if (instance == null) {
            synchronized (ReferralManager.class) {
                if (instance == null) {
                    instance = new ReferralManager();
                }
            }
        }
        return instance;
    }

    public void startReferral(Activity activity) throws JSONException {
        startReferralImpl(new ActivityStartActivityDelegate(activity));
    }

    public void startReferral(Fragment fragment) throws JSONException {
        startReferralImpl(new FragmentStartActivityDelegate(new FragmentWrapper(fragment)));
    }

    public void startReferral(android.app.Fragment fragment) throws JSONException {
        startReferralImpl(new FragmentStartActivityDelegate(new FragmentWrapper(fragment)));
    }

    public void startReferral(FragmentWrapper fragmentWrapper) throws JSONException {
        startReferralImpl(new FragmentStartActivityDelegate(fragmentWrapper));
    }

    public void registerCallback(CallbackManager callbackManager, final FacebookCallback<ReferralResult> facebookCallback) {
        if (!(callbackManager instanceof CallbackManagerImpl)) {
            throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
        }
        ((CallbackManagerImpl) callbackManager).registerCallback(ReferralClient.getReferralRequestCode(), new CallbackManagerImpl.Callback() { // from class: com.facebook.referrals.ReferralManager.1
            @Override // com.facebook.internal.CallbackManagerImpl.Callback
            public boolean onActivityResult(int i, Intent intent) {
                return ReferralManager.this.onActivityResult(i, intent, facebookCallback);
            }
        });
    }

    private void startReferralImpl(StartActivityDelegate startActivityDelegate) throws JSONException {
        ReferralLogger logger = getLogger(startActivityDelegate.getActivityContext());
        if (logger != null) {
            logger.logStartReferral();
        }
        if (tryFacebookActivity(startActivityDelegate)) {
            return;
        }
        FacebookException facebookException = new FacebookException("Failed to open Referral dialog: FacebookActivity could not be started. Please make sure you added FacebookActivity to the AndroidManifest.");
        if (logger != null) {
            logger.logError(facebookException);
            throw facebookException;
        }
        throw facebookException;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    boolean onActivityResult(int i, Intent intent, FacebookCallback<ReferralResult> facebookCallback) {
        FacebookException facebookException;
        FacebookException facebookException2;
        ReferralResult referralResult;
        if (i != -1 || intent == null) {
            if (i == 0) {
                if (intent == null || intent.getExtras() == null || !intent.getExtras().containsKey("error_message")) {
                    facebookException2 = null;
                    referralResult = null;
                } else {
                    facebookException = new FacebookException(intent.getExtras().getString("error_message"));
                }
            } else {
                facebookException = new FacebookException("Unexpected call to ReferralManager.onActivityResult");
            }
            facebookException2 = facebookException;
            referralResult = null;
        } else {
            try {
                if (intent.getExtras() != null && intent.getExtras().containsKey("fb_referral_codes")) {
                    referralResult = new ReferralResult(Utility.convertJSONArrayToList(new JSONArray(intent.getExtras().getString("fb_referral_codes"))));
                    facebookException2 = null;
                }
            } catch (JSONException unused) {
                facebookException2 = new FacebookException("Unable to parse referral codes from response");
            }
        }
        ReferralLogger logger = getLogger(null);
        if (logger != null) {
            if (referralResult != null) {
                logger.logSuccess();
            } else if (facebookException2 != null) {
                logger.logError(facebookException2);
            } else {
                logger.logCancel();
            }
        }
        if (referralResult != null) {
            facebookCallback.onSuccess(referralResult);
            return true;
        }
        if (facebookException2 != null) {
            facebookCallback.onError(facebookException2);
            return true;
        }
        facebookCallback.onCancel();
        return true;
    }

    private boolean tryFacebookActivity(StartActivityDelegate startActivityDelegate) {
        Intent intent = new Intent();
        intent.setClass(FacebookSdk.getApplicationContext(), FacebookActivity.class);
        intent.setAction(ReferralFragment.TAG);
        if (!resolveIntent(intent)) {
            return false;
        }
        try {
            startActivityDelegate.startActivityForResult(intent, CallbackManagerImpl.RequestCodeOffset.Referral.toRequestCode());
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        }
    }

    private ReferralLogger getLogger(Context context) {
        if (context == null) {
            context = FacebookSdk.getApplicationContext();
        }
        if (context == null) {
            return null;
        }
        if (this.logger == null) {
            this.logger = new ReferralLogger(context, FacebookSdk.getApplicationId());
        }
        return this.logger;
    }

    private static boolean resolveIntent(Intent intent) {
        return FacebookSdk.getApplicationContext().getPackageManager().resolveActivity(intent, 0) != null;
    }

    private static class ActivityStartActivityDelegate implements StartActivityDelegate {
        private final Activity activity;

        ActivityStartActivityDelegate(Activity activity) {
            Validate.notNull(activity, "activity");
            this.activity = activity;
        }

        @Override // com.facebook.referrals.StartActivityDelegate
        public void startActivityForResult(Intent intent, int i) {
            this.activity.startActivityForResult(intent, i);
        }

        @Override // com.facebook.referrals.StartActivityDelegate
        public Activity getActivityContext() {
            return this.activity;
        }
    }

    private static class FragmentStartActivityDelegate implements StartActivityDelegate {
        private final FragmentWrapper fragment;

        FragmentStartActivityDelegate(FragmentWrapper fragmentWrapper) {
            Validate.notNull(fragmentWrapper, "fragment");
            this.fragment = fragmentWrapper;
        }

        @Override // com.facebook.referrals.StartActivityDelegate
        public void startActivityForResult(Intent intent, int i) {
            this.fragment.startActivityForResult(intent, i);
        }

        @Override // com.facebook.referrals.StartActivityDelegate
        public Activity getActivityContext() {
            return this.fragment.getActivity();
        }
    }
}
