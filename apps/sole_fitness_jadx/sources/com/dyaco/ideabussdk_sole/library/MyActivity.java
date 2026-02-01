package com.dyaco.ideabussdk_sole.library;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.DisplayMetrics;
import com.dyaco.ideabussdk_sole.R;
import com.ideabus.library.CustomVariable;

/* loaded from: classes.dex */
public abstract class MyActivity extends Activity {
    public static final String TAG = "MyActivity";
    private MyActivity activity;
    private Dialog dialog;
    private ProgressDialog loadDialog;

    protected abstract void findViews();

    protected abstract void initFragments();

    protected abstract void initParams();

    protected abstract void setListeners();

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.activity = this;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        CustomVariable.density = displayMetrics.density;
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        if (i2 > i) {
            CustomVariable.screenWidth = i2;
            CustomVariable.screenHeight = i;
        } else {
            CustomVariable.screenWidth = i;
            CustomVariable.screenHeight = i2;
        }
        CustomVariable.screenScale = CustomVariable.screenWidth / CustomVariable.screenHeight;
        CustomVariable.isLongScreen = ((double) CustomVariable.screenScale) >= 1.5d;
        String str = TAG;
        MyVariable.printLog("d", str, "screenWidth = " + CustomVariable.screenWidth);
        MyVariable.printLog("d", str, "screenHeight = " + CustomVariable.screenHeight);
        MyVariable.printLog("d", str, "scale = " + CustomVariable.screenScale);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        cancelAlert();
    }

    public void showBaseAlert(final int i, final int i2, final boolean z, final String str, final DialogInterface.OnClickListener onClickListener) {
        if (isDestroyed()) {
            return;
        }
        runOnUiThread(new Runnable() { // from class: com.dyaco.ideabussdk_sole.library.MyActivity.1
            @Override // java.lang.Runnable
            public void run() {
                MyActivity.this.cancelAlert();
                MyActivity.this.dialog = new AlertDialog.Builder(MyActivity.this.activity).setTitle(i).setMessage(str).setCancelable(z).setNegativeButton(i2, onClickListener).create();
                MyActivity.this.dialog.show();
            }
        });
    }

    public void showBaseAlert(int i, int i2, boolean z, int i3, DialogInterface.OnClickListener onClickListener) {
        showBaseAlert(i, i2, z, getString(i3), onClickListener);
    }

    public void showBaseAlert(final int i, final boolean z, final String str, final DialogInterface.OnClickListener onClickListener) {
        if (isDestroyed()) {
            return;
        }
        runOnUiThread(new Runnable() { // from class: com.dyaco.ideabussdk_sole.library.MyActivity.2
            @Override // java.lang.Runnable
            public void run() {
                MyActivity.this.cancelAlert();
                MyActivity.this.dialog = new AlertDialog.Builder(MyActivity.this.activity).setMessage(str).setCancelable(z).setNegativeButton(i, onClickListener).create();
                MyActivity.this.dialog.show();
            }
        });
    }

    public void showBaseAlert(int i, boolean z, int i2, DialogInterface.OnClickListener onClickListener) {
        showBaseAlert(i, z, getString(i2), onClickListener);
    }

    public void cancelAlert() {
        Dialog dialog = this.dialog;
        if (dialog != null) {
            dialog.dismiss();
            this.dialog = null;
        }
    }

    public boolean isPackageInstalled(String str) throws PackageManager.NameNotFoundException {
        try {
            getPackageManager().getPackageInfo(str, 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public void showLoadDialog(final String str) {
        ProgressDialog progressDialog = this.loadDialog;
        if (progressDialog == null || !progressDialog.isShowing()) {
            closeLoadDialog();
            runOnUiThread(new Runnable() { // from class: com.dyaco.ideabussdk_sole.library.MyActivity.3
                @Override // java.lang.Runnable
                public void run() {
                    MyActivity.this.loadDialog = new ProgressDialog(MyActivity.this, R.style.myDialog);
                    MyActivity.this.loadDialog = new ProgressDialog(MyActivity.this);
                    if (str != null) {
                        MyActivity.this.loadDialog.setMessage(str);
                    } else {
                        MyActivity.this.loadDialog.setMessage("Loading...");
                    }
                    MyActivity.this.loadDialog.setCancelable(false);
                    MyActivity.this.loadDialog.setCanceledOnTouchOutside(false);
                    MyActivity.this.loadDialog.show();
                }
            });
        }
    }

    public void closeLoadDialog() {
        runOnUiThread(new Runnable() { // from class: com.dyaco.ideabussdk_sole.library.MyActivity.4
            @Override // java.lang.Runnable
            public void run() {
                if (MyActivity.this.loadDialog == null || !MyActivity.this.loadDialog.isShowing()) {
                    return;
                }
                MyActivity.this.loadDialog.dismiss();
            }
        });
    }
}
