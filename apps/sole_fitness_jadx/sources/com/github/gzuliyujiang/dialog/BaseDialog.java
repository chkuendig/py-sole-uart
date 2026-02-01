package com.github.gzuliyujiang.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

/* loaded from: classes.dex */
public abstract class BaseDialog extends Dialog implements DialogInterface.OnShowListener, DialogInterface.OnDismissListener {
    public static final int MATCH_PARENT = -1;
    public static final int WRAP_CONTENT = -2;
    protected Activity activity;
    protected View contentView;

    protected abstract View createContentView();

    public BaseDialog(Activity activity) {
        this(activity, R.style.DialogTheme_Base);
    }

    public BaseDialog(Activity activity, int i) {
        super(activity, i);
        init(activity);
    }

    public final View getContentView() {
        return this.contentView;
    }

    private void init(Activity activity) {
        this.activity = activity;
        setOwnerActivity(activity);
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        super.setOnShowListener(this);
        super.setOnDismissListener(this);
        Window window = super.getWindow();
        if (window != null) {
            window.requestFeature(1);
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setLayout(activity.getResources().getDisplayMetrics().widthPixels, -2);
            window.setGravity(17);
            window.getDecorView().setPadding(0, 0, 0, 0);
        }
        onInit(null);
        if (Build.VERSION.SDK_INT >= 21) {
            super.create();
        } else {
            readyView();
        }
    }

    @Deprecated
    protected void onInit(Activity activity, Bundle bundle) {
        DialogLog.print("dialog onInit");
    }

    protected void onInit(Bundle bundle) {
        onInit(this.activity, bundle);
    }

    @Override // android.app.Dialog
    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        DialogLog.print("dialog onCreate");
        if (this.contentView == null) {
            readyView();
        }
    }

    private void readyView() {
        View viewCreateContentView = createContentView();
        this.contentView = viewCreateContentView;
        viewCreateContentView.setFocusable(true);
        this.contentView.setFocusableInTouchMode(true);
        setContentView(this.contentView);
        initView();
    }

    @Deprecated
    protected void initView(View view) {
        DialogLog.print("dialog initView");
    }

    protected void initView() {
        initView(this.contentView);
    }

    public final void disableCancel() {
        setCancelable(false);
        setCanceledOnTouchOutside(false);
    }

    public final void setBackgroundColor(int i) {
        setBackgroundColor(0, i);
    }

    public final void setBackgroundColor(int i, int i2) {
        setBackgroundColor(i, 20, i2);
    }

    public final void setBackgroundColor(int i, int i2, int i3) {
        Drawable colorDrawable;
        View view = this.contentView;
        if (view == null) {
            return;
        }
        float f = view.getResources().getDisplayMetrics().density * i2;
        this.contentView.setLayerType(1, null);
        if (i == 1) {
            ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{f, f, f, f, 0.0f, 0.0f, 0.0f, 0.0f}, null, null));
            shapeDrawable.setColorFilter(new PorterDuffColorFilter(i3, PorterDuff.Mode.SRC_IN));
            colorDrawable = shapeDrawable;
        } else if (i == 2) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(f);
            gradientDrawable.setColorFilter(new PorterDuffColorFilter(i3, PorterDuff.Mode.SRC_IN));
            colorDrawable = gradientDrawable;
        } else {
            colorDrawable = new ColorDrawable(i3);
        }
        this.contentView.setBackground(colorDrawable);
    }

    public final void setBackgroundResource(int i) {
        View view = this.contentView;
        if (view == null) {
            return;
        }
        view.setBackgroundResource(i);
    }

    public final void setBackgroundDrawable(Drawable drawable) {
        View view = this.contentView;
        if (view == null) {
            return;
        }
        view.setBackground(drawable);
    }

    public final void setLayout(int i, int i2) {
        getWindow().setLayout(i, i2);
    }

    public final void setWidth(int i) {
        getWindow().setLayout(i, getWindow().getAttributes().height);
    }

    public final void setHeight(int i) {
        getWindow().setLayout(getWindow().getAttributes().width, i);
    }

    public final void setGravity(int i) {
        getWindow().setGravity(i);
    }

    public final void setDimAmount(float f) {
        getWindow().setDimAmount(f);
    }

    public final void setAnimationStyle(int i) {
        getWindow().setWindowAnimations(i);
    }

    @Override // android.app.Dialog
    public void setOnShowListener(final DialogInterface.OnShowListener onShowListener) {
        if (onShowListener == null) {
            return;
        }
        super.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.github.gzuliyujiang.dialog.BaseDialog$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                BaseDialog.lambda$setOnShowListener$0(this, onShowListener, dialogInterface);
            }
        });
    }

    static /* synthetic */ void lambda$setOnShowListener$0(DialogInterface.OnShowListener onShowListener, DialogInterface.OnShowListener onShowListener2, DialogInterface dialogInterface) {
        onShowListener.onShow(dialogInterface);
        onShowListener2.onShow(dialogInterface);
    }

    @Override // android.app.Dialog
    public void setOnDismissListener(final DialogInterface.OnDismissListener onDismissListener) {
        if (onDismissListener == null) {
            return;
        }
        super.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.github.gzuliyujiang.dialog.BaseDialog$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                BaseDialog.lambda$setOnDismissListener$1(this, onDismissListener, dialogInterface);
            }
        });
    }

    static /* synthetic */ void lambda$setOnDismissListener$1(DialogInterface.OnDismissListener onDismissListener, DialogInterface.OnDismissListener onDismissListener2, DialogInterface dialogInterface) {
        onDismissListener.onDismiss(dialogInterface);
        onDismissListener2.onDismiss(dialogInterface);
    }

    @Override // android.app.Dialog
    public void show() {
        if (isShowing()) {
            return;
        }
        try {
            super.show();
            DialogLog.print("dialog show");
        } catch (Exception e) {
            DialogLog.print(e);
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (isShowing()) {
            try {
                super.dismiss();
                DialogLog.print("dialog dismiss");
            } catch (Exception e) {
                DialogLog.print(e);
            }
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        DialogLog.print("dialog attached to window");
        super.onAttachedToWindow();
        initData();
    }

    protected void initData() {
        DialogLog.print("dialog initData");
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        DialogLog.print("dialog detached from window");
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
        DialogLog.print("dialog onShow");
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        DialogLog.print("dialog onDismiss");
    }
}
