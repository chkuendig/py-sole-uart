package com.dyaco.sole.custom_view;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.dyaco.sole.custom.Global;
import com.soletreadmills.sole.R;

/* loaded from: classes.dex */
public class ErrorDialog extends RelativeLayout implements View.OnClickListener {
    private LinearLayout appDownload;
    private LinearLayout close;
    private TextView downloadAppMsg;
    private TextView errorMessage;
    private LinearLayout helpCenter;
    private View v;

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public ErrorDialog(Context context) {
        super(context);
    }

    public ErrorDialog(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView(context);
    }

    private void initView(Context context) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.error_dialog, this);
        this.v = viewInflate;
        viewInflate.setOnClickListener(this);
        this.helpCenter = (LinearLayout) findViewById(R.id.helpCenter);
        this.close = (LinearLayout) findViewById(R.id.close);
        this.errorMessage = (TextView) findViewById(R.id.errorMessage);
        this.appDownload = (LinearLayout) this.v.findViewById(R.id.appDownload);
        this.downloadAppMsg = (TextView) this.v.findViewById(R.id.downloadAppMsg);
        int i = Global.BRAND;
        if (i == 0) {
            this.downloadAppMsg.setText(R.string.download_sole_plus_app_msg);
        } else if (i == 1) {
            this.downloadAppMsg.setText(R.string.download_spirit_plus_app_msg);
        } else if (i == 2) {
            this.downloadAppMsg.setText(R.string.download_xterra_plus_app_msg);
        } else if (i == 3) {
            this.downloadAppMsg.setText(R.string.download_fuel_plus_app_msg);
        }
        LinearLayout linearLayout = this.appDownload;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.dyaco.sole.custom_view.ErrorDialog.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    int i2 = Global.BRAND;
                    if (i2 == 0) {
                        intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.soletreadmills.sole_v2"));
                    } else if (i2 == 1) {
                        intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.soletreadmills.spirit_v2"));
                    } else if (i2 == 2) {
                        intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.soletreadmills.xterra_v2"));
                    } else if (i2 == 3) {
                        return;
                    }
                    intent.setPackage("com.android.vending");
                    view.getContext().startActivity(intent);
                }
            });
        }
    }

    public void initView(String str, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.errorMessage.setText(str);
        this.helpCenter.setOnClickListener(onClickListener);
        this.close.setOnClickListener(onClickListener2);
        if (checkInternet(this.v.getContext())) {
            return;
        }
        new AlertDialog.Builder(this.v.getContext()).setCancelable(false).setMessage(this.v.getContext().getString(R.string.internet_error)).setPositiveButton(this.v.getContext().getString(R.string.yes), (DialogInterface.OnClickListener) null).show();
    }

    public static boolean checkInternet(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public void setHelpCenter(View.OnClickListener onClickListener) {
        this.helpCenter.setOnClickListener(onClickListener);
    }

    public void setClose(View.OnClickListener onClickListener) {
        this.close.setOnClickListener(onClickListener);
    }

    public void setShowDownloadAppViews(final boolean z) {
        Runnable runnable = new Runnable() { // from class: com.dyaco.sole.custom_view.ErrorDialog.2
            @Override // java.lang.Runnable
            public void run() {
                ErrorDialog.this.appDownload.setVisibility(z ? 0 : 8);
                ErrorDialog.this.downloadAppMsg.setVisibility(z ? 0 : 8);
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
            return;
        }
        View view = this.v;
        if (view != null) {
            view.post(runnable);
        }
    }
}
