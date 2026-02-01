package com.dyaco.sole.notification;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Looper;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.widget.Toast;
import com.facebook.internal.AnalyticsEvents;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class ExampleUtil {
    public static final String KEY_APP_KEY = "JPUSH_APPKEY";
    private static final String MOBILE_NUMBER_CHARS = "^[+0-9][-0-9]{1,}$";
    public static final String PREFS_DAYS = "JPUSH_EXAMPLE_DAYS";
    public static final String PREFS_END_TIME = "PREFS_END_TIME";
    public static final String PREFS_NAME = "JPUSH_EXAMPLE";
    public static final String PREFS_START_TIME = "PREFS_START_TIME";

    public static String getDeviceId(Context context) {
        return "";
    }

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0 || str.trim().length() == 0;
    }

    public static boolean isValidMobileNumber(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        return Pattern.compile(MOBILE_NUMBER_CHARS).matcher(str).matches();
    }

    public static boolean isValidTagAndAlias(String str) {
        return Pattern.compile("^[一-龥0-9a-zA-Z_!@#$&*+=.|]+$").matcher(str).matches();
    }

    public static String getAppKey(Context context) throws PackageManager.NameNotFoundException {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            Bundle bundle = applicationInfo != null ? applicationInfo.metaData : null;
            if (bundle == null) {
                return null;
            }
            String string = bundle.getString(KEY_APP_KEY);
            if (string == null) {
                return null;
            }
            try {
                if (string.length() != 24) {
                    return null;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
            return string;
        } catch (PackageManager.NameNotFoundException unused2) {
            return null;
        }
    }

    public static String GetVersion(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        }
    }

    public static void showToast(final String str, final Context context) {
        new Thread(new Runnable() { // from class: com.dyaco.sole.notification.ExampleUtil.1
            @Override // java.lang.Runnable
            public void run() {
                Looper.prepare();
                Toast.makeText(context, str, 0).show();
                Looper.loop();
            }
        }).start();
    }

    public static boolean isConnected(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static String getImei(Context context, String str) {
        String deviceId;
        try {
            deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (Exception unused) {
            deviceId = null;
        }
        return isReadableASCII(deviceId) ? deviceId : str;
    }

    private static boolean isReadableASCII(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return false;
        }
        try {
            return Pattern.compile("[\\x20-\\x7E]+").matcher(charSequence).matches();
        } catch (Throwable unused) {
            return true;
        }
    }
}
