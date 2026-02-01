package com.ideabus.library;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.DisplayMetrics;

/* loaded from: classes2.dex */
public class CustomActivity extends Activity {
    private static SharedPreferences.Editor edit;
    private static SharedPreferences spf;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initSpf();
        if (CustomVariable.density == 0.0f) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            CustomVariable.density = displayMetrics.density;
            CustomVariable.screenWidth = displayMetrics.widthPixels;
            CustomVariable.screenHeight = displayMetrics.heightPixels;
            int i = CustomVariable.screenWidth;
            int i2 = CustomVariable.screenHeight;
            if (i <= i2) {
                i2 = CustomVariable.screenWidth;
                i = i2;
            }
            CustomVariable.screenScale = i / i2;
            CustomVariable.isLongScreen = CustomVariable.screenScale >= 1.4f;
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    private void initSpf() {
        if (spf == null || edit == null) {
            SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("ting_color_data", 0);
            spf = sharedPreferences;
            edit = sharedPreferences.edit();
        }
    }

    public static void editPreInt(String str, int i) {
        SharedPreferences.Editor editor = edit;
        if (editor != null) {
            editor.putInt(str, i);
            edit.commit();
        }
    }

    public static int getPreInt(String str, int i) {
        SharedPreferences sharedPreferences = spf;
        if (sharedPreferences != null) {
            return sharedPreferences.getInt(str, i);
        }
        return 0;
    }

    public static void editPreFloat(String str, float f) {
        SharedPreferences.Editor editor = edit;
        if (editor != null) {
            editor.putFloat(str, f);
            edit.commit();
        }
    }

    public static float getPreFloat(String str, float f) {
        SharedPreferences sharedPreferences = spf;
        if (sharedPreferences != null) {
            return sharedPreferences.getFloat(str, f);
        }
        return 0.0f;
    }

    public static void editPreString(String str, String str2) {
        SharedPreferences.Editor editor = edit;
        if (editor != null) {
            editor.putString(str, str2);
            edit.commit();
        }
    }

    public static String getPreString(String str, String str2) {
        SharedPreferences sharedPreferences = spf;
        return sharedPreferences != null ? sharedPreferences.getString(str, str2) : "";
    }

    public static void editPreBoolean(String str, boolean z) {
        SharedPreferences.Editor editor = edit;
        if (editor != null) {
            editor.putBoolean(str, z);
            edit.commit();
        }
    }

    public static boolean getPreBoolean(String str, boolean z) {
        SharedPreferences sharedPreferences = spf;
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean(str, z);
        }
        return false;
    }
}
