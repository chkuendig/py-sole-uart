package com.facebook;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.facebook.internal.FacebookDialogFragment;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.internal.logging.dumpsys.EndToEndDumpsysHelper;
import com.facebook.login.LoginFragment;
import com.facebook.referrals.ReferralFragment;
import com.facebook.share.internal.DeviceShareDialogFragment;
import com.facebook.share.model.ShareContent;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public class FacebookActivity extends FragmentActivity {
    private static String FRAGMENT_TAG = "SingleFragment";
    public static String PASS_THROUGH_CANCEL_ACTION = "PassThrough";
    private static final String TAG = "com.facebook.FacebookActivity";
    private Fragment singleFragment;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (!FacebookSdk.isInitialized()) {
            Utility.logd(TAG, "Facebook SDK not initialized. Make sure you call sdkInitialize inside your Application's onCreate method.");
            FacebookSdk.sdkInitialize(getApplicationContext());
        }
        setContentView(com.facebook.common.R.layout.com_facebook_activity_layout);
        if (PASS_THROUGH_CANCEL_ACTION.equals(intent.getAction())) {
            handlePassThroughError();
        } else {
            this.singleFragment = getFragment();
        }
    }

    protected Fragment getFragment() {
        Intent intent = getIntent();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Fragment fragmentFindFragmentByTag = supportFragmentManager.findFragmentByTag(FRAGMENT_TAG);
        if (fragmentFindFragmentByTag != null) {
            return fragmentFindFragmentByTag;
        }
        if (FacebookDialogFragment.TAG.equals(intent.getAction())) {
            FacebookDialogFragment facebookDialogFragment = new FacebookDialogFragment();
            facebookDialogFragment.setRetainInstance(true);
            facebookDialogFragment.show(supportFragmentManager, FRAGMENT_TAG);
            return facebookDialogFragment;
        }
        if (DeviceShareDialogFragment.TAG.equals(intent.getAction())) {
            DeviceShareDialogFragment deviceShareDialogFragment = new DeviceShareDialogFragment();
            deviceShareDialogFragment.setRetainInstance(true);
            deviceShareDialogFragment.setShareContent((ShareContent) intent.getParcelableExtra(FirebaseAnalytics.Param.CONTENT));
            deviceShareDialogFragment.show(supportFragmentManager, FRAGMENT_TAG);
            return deviceShareDialogFragment;
        }
        if (ReferralFragment.TAG.equals(intent.getAction())) {
            ReferralFragment referralFragment = new ReferralFragment();
            referralFragment.setRetainInstance(true);
            supportFragmentManager.beginTransaction().add(com.facebook.common.R.id.com_facebook_fragment_container, referralFragment, FRAGMENT_TAG).commit();
            return referralFragment;
        }
        LoginFragment loginFragment = new LoginFragment();
        loginFragment.setRetainInstance(true);
        supportFragmentManager.beginTransaction().add(com.facebook.common.R.id.com_facebook_fragment_container, loginFragment, FRAGMENT_TAG).commit();
        return loginFragment;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Fragment fragment = this.singleFragment;
        if (fragment != null) {
            fragment.onConfigurationChanged(configuration);
        }
    }

    public Fragment getCurrentFragment() {
        return this.singleFragment;
    }

    private void handlePassThroughError() {
        setResult(0, NativeProtocol.createProtocolResultIntent(getIntent(), null, NativeProtocol.getExceptionFromErrorData(NativeProtocol.getMethodArgumentsFromIntent(getIntent()))));
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            if (EndToEndDumpsysHelper.maybeDump(str, printWriter, strArr)) {
                return;
            }
            super.dump(str, fileDescriptor, printWriter, strArr);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }
}
