package com.github.gzuliyujiang.dialog;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import com.dyaco.sole.R2;
import com.facebook.appevents.codeless.internal.Constants;

/* loaded from: classes.dex */
public abstract class BottomDialog extends BaseDialog {
    protected View maskView;

    protected boolean enableMaskView() {
        return true;
    }

    public BottomDialog(Activity activity) {
        super(activity, R.style.DialogTheme_Sheet);
    }

    public BottomDialog(Activity activity, int i) {
        super(activity, i);
    }

    @Override // com.github.gzuliyujiang.dialog.BaseDialog
    public void onInit(Bundle bundle) {
        super.onInit(bundle);
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        setWidth(this.activity.getResources().getDisplayMetrics().widthPixels);
        setGravity(80);
    }

    @Override // com.github.gzuliyujiang.dialog.BaseDialog, android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
        super.onShow(dialogInterface);
        if (enableMaskView()) {
            addMaskView();
        }
    }

    protected void addMaskView() {
        try {
            getWindow().setDimAmount(0.0f);
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.width = -1;
            Point point = new Point();
            this.activity.getWindowManager().getDefaultDisplay().getRealSize(point);
            layoutParams.height = point.y - this.activity.getResources().getDimensionPixelSize(this.activity.getResources().getIdentifier("navigation_bar_height", "dimen", Constants.PLATFORM));
            layoutParams.gravity = 48;
            if (Build.VERSION.SDK_INT >= 28) {
                layoutParams.layoutInDisplayCutoutMode = 1;
            }
            layoutParams.systemUiVisibility = R2.dimen.display_link_content_width;
            layoutParams.type = 1000;
            layoutParams.format = -3;
            layoutParams.token = this.activity.getWindow().getDecorView().getWindowToken();
            layoutParams.softInputMode = 18;
            View view = new View(this.activity);
            this.maskView = view;
            view.setBackgroundColor(2130706432);
            this.maskView.setFitsSystemWindows(false);
            this.maskView.setOnKeyListener(new View.OnKeyListener() { // from class: com.github.gzuliyujiang.dialog.BottomDialog$$ExternalSyntheticLambda0
                @Override // android.view.View.OnKeyListener
                public final boolean onKey(View view2, int i, KeyEvent keyEvent) {
                    return this.f$0.m42lambda$addMaskView$0$comgithubgzuliyujiangdialogBottomDialog(view2, i, keyEvent);
                }
            });
            this.activity.getWindowManager().addView(this.maskView, layoutParams);
            DialogLog.print("dialog add mask view");
        } catch (Exception e) {
            DialogLog.print(e);
        }
    }

    /* renamed from: lambda$addMaskView$0$com-github-gzuliyujiang-dialog-BottomDialog, reason: not valid java name */
    /* synthetic */ boolean m42lambda$addMaskView$0$comgithubgzuliyujiangdialogBottomDialog(View view, int i, KeyEvent keyEvent) {
        if (i != 4) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // com.github.gzuliyujiang.dialog.BaseDialog, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        removeMaskView();
        super.onDismiss(dialogInterface);
    }

    protected void removeMaskView() {
        if (this.maskView == null) {
            DialogLog.print("mask view is null");
            return;
        }
        try {
            this.activity.getWindowManager().removeViewImmediate(this.maskView);
            DialogLog.print("dialog remove mask view");
        } catch (Exception e) {
            DialogLog.print(e);
        }
    }
}
