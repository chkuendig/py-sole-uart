package com.facebook;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.facebook.internal.CustomTab;
import com.facebook.internal.InstagramCustomTab;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.login.LoginTargetApp;

/* loaded from: classes.dex */
public class CustomTabMainActivity extends Activity {
    private BroadcastReceiver redirectReceiver;
    private boolean shouldCloseCustomTab = true;
    public static final String EXTRA_ACTION = "CustomTabMainActivity.extra_action";
    public static final String EXTRA_PARAMS = "CustomTabMainActivity.extra_params";
    public static final String EXTRA_CHROME_PACKAGE = "CustomTabMainActivity.extra_chromePackage";
    public static final String EXTRA_URL = "CustomTabMainActivity.extra_url";
    public static final String EXTRA_TARGET_APP = "CustomTabMainActivity.extra_targetApp";
    public static final String REFRESH_ACTION = "CustomTabMainActivity.action_refresh";
    public static final String NO_ACTIVITY_EXCEPTION = "CustomTabMainActivity.no_activity_exception";

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        CustomTab instagramCustomTab;
        super.onCreate(bundle);
        if (CustomTabActivity.CUSTOM_TAB_REDIRECT_ACTION.equals(getIntent().getAction())) {
            setResult(0);
            finish();
            return;
        }
        if (bundle == null) {
            String stringExtra = getIntent().getStringExtra(EXTRA_ACTION);
            Bundle bundleExtra = getIntent().getBundleExtra(EXTRA_PARAMS);
            String stringExtra2 = getIntent().getStringExtra(EXTRA_CHROME_PACKAGE);
            if (AnonymousClass2.$SwitchMap$com$facebook$login$LoginTargetApp[LoginTargetApp.fromString(getIntent().getStringExtra(EXTRA_TARGET_APP)).ordinal()] == 1) {
                instagramCustomTab = new InstagramCustomTab(stringExtra, bundleExtra);
            } else {
                instagramCustomTab = new CustomTab(stringExtra, bundleExtra);
            }
            boolean zOpenCustomTab = instagramCustomTab.openCustomTab(this, stringExtra2);
            this.shouldCloseCustomTab = false;
            if (!zOpenCustomTab) {
                setResult(0, getIntent().putExtra(NO_ACTIVITY_EXCEPTION, true));
                finish();
            } else {
                this.redirectReceiver = new BroadcastReceiver() { // from class: com.facebook.CustomTabMainActivity.1
                    @Override // android.content.BroadcastReceiver
                    public void onReceive(Context context, Intent intent) {
                        Intent intent2 = new Intent(CustomTabMainActivity.this, (Class<?>) CustomTabMainActivity.class);
                        intent2.setAction(CustomTabMainActivity.REFRESH_ACTION);
                        intent2.putExtra(CustomTabMainActivity.EXTRA_URL, intent.getStringExtra(CustomTabMainActivity.EXTRA_URL));
                        intent2.addFlags(603979776);
                        CustomTabMainActivity.this.startActivity(intent2);
                    }
                };
                LocalBroadcastManager.getInstance(this).registerReceiver(this.redirectReceiver, new IntentFilter(CustomTabActivity.CUSTOM_TAB_REDIRECT_ACTION));
            }
        }
    }

    /* renamed from: com.facebook.CustomTabMainActivity$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$login$LoginTargetApp;

        static {
            int[] iArr = new int[LoginTargetApp.values().length];
            $SwitchMap$com$facebook$login$LoginTargetApp = iArr;
            try {
                iArr[LoginTargetApp.INSTAGRAM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (REFRESH_ACTION.equals(intent.getAction())) {
            LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent(CustomTabActivity.DESTROY_ACTION));
            sendResult(-1, intent);
        } else if (CustomTabActivity.CUSTOM_TAB_REDIRECT_ACTION.equals(intent.getAction())) {
            sendResult(-1, intent);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.shouldCloseCustomTab) {
            sendResult(0, null);
        }
        this.shouldCloseCustomTab = true;
    }

    private void sendResult(int i, Intent intent) {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.redirectReceiver);
        if (intent != null) {
            String stringExtra = intent.getStringExtra(EXTRA_URL);
            Intent intentCreateProtocolResultIntent = NativeProtocol.createProtocolResultIntent(getIntent(), stringExtra != null ? parseResponseUri(stringExtra) : new Bundle(), null);
            if (intentCreateProtocolResultIntent != null) {
                intent = intentCreateProtocolResultIntent;
            }
            setResult(i, intent);
        } else {
            setResult(i, NativeProtocol.createProtocolResultIntent(getIntent(), null, null));
        }
        finish();
    }

    private static Bundle parseResponseUri(String str) {
        Uri uri = Uri.parse(str);
        Bundle urlQueryString = Utility.parseUrlQueryString(uri.getQuery());
        urlQueryString.putAll(Utility.parseUrlQueryString(uri.getFragment()));
        return urlQueryString;
    }
}
