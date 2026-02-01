package com.github.gzuliyujiang.dialog;

import android.app.Activity;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;

/* loaded from: classes.dex */
public abstract class ModalDialog extends BottomDialog implements View.OnClickListener {
    protected View bodyView;
    protected TextView cancelView;
    protected View footerView;
    protected View headerView;
    protected TextView okView;
    protected TextView titleView;
    protected View topLineView;

    protected abstract View createBodyView();

    protected abstract void onCancel();

    protected abstract void onOk();

    public ModalDialog(Activity activity) {
        super(activity, DialogConfig.getDialogStyle() == 3 ? R.style.DialogTheme_Fade : R.style.DialogTheme_Sheet);
    }

    public ModalDialog(Activity activity, int i) {
        super(activity, i);
    }

    @Override // com.github.gzuliyujiang.dialog.BottomDialog, com.github.gzuliyujiang.dialog.BaseDialog
    public void onInit(Bundle bundle) {
        super.onInit(bundle);
        if (DialogConfig.getDialogStyle() == 3) {
            setWidth((int) (this.activity.getResources().getDisplayMetrics().widthPixels * 0.8f));
            setGravity(17);
        }
    }

    @Override // com.github.gzuliyujiang.dialog.BottomDialog
    protected boolean enableMaskView() {
        return DialogConfig.getDialogStyle() != 3;
    }

    @Override // com.github.gzuliyujiang.dialog.BaseDialog
    protected View createContentView() {
        LinearLayout linearLayout = new LinearLayout(this.activity);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        linearLayout.setPadding(0, 0, 0, 0);
        View viewCreateHeaderView = createHeaderView();
        this.headerView = viewCreateHeaderView;
        if (viewCreateHeaderView == null) {
            View view = new View(this.activity);
            this.headerView = view;
            view.setLayoutParams(new LinearLayout.LayoutParams(0, 0));
        }
        linearLayout.addView(this.headerView);
        View viewCreateTopLineView = createTopLineView();
        this.topLineView = viewCreateTopLineView;
        if (viewCreateTopLineView == null) {
            View view2 = new View(this.activity);
            this.topLineView = view2;
            view2.setLayoutParams(new LinearLayout.LayoutParams(0, 0));
        }
        linearLayout.addView(this.topLineView);
        View viewCreateBodyView = createBodyView();
        this.bodyView = viewCreateBodyView;
        linearLayout.addView(viewCreateBodyView, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        View viewCreateFooterView = createFooterView();
        this.footerView = viewCreateFooterView;
        if (viewCreateFooterView == null) {
            View view3 = new View(this.activity);
            this.footerView = view3;
            view3.setLayoutParams(new LinearLayout.LayoutParams(0, 0));
        }
        linearLayout.addView(this.footerView);
        return linearLayout;
    }

    protected View createHeaderView() {
        int dialogStyle = DialogConfig.getDialogStyle();
        if (dialogStyle == 1) {
            return View.inflate(this.activity, R.layout.dialog_header_style_1, null);
        }
        if (dialogStyle == 2) {
            return View.inflate(this.activity, R.layout.dialog_header_style_2, null);
        }
        if (dialogStyle == 3) {
            return View.inflate(this.activity, R.layout.dialog_header_style_3, null);
        }
        return View.inflate(this.activity, R.layout.dialog_header_style_default, null);
    }

    protected View createTopLineView() {
        if (DialogConfig.getDialogStyle() != 0) {
            return null;
        }
        View view = new View(this.activity);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) (this.activity.getResources().getDisplayMetrics().density * 1.0f)));
        view.setBackgroundColor(DialogConfig.getDialogColor().topLineColor());
        return view;
    }

    protected View createFooterView() {
        int dialogStyle = DialogConfig.getDialogStyle();
        if (dialogStyle == 1) {
            return View.inflate(this.activity, R.layout.dialog_footer_style_1, null);
        }
        if (dialogStyle == 2) {
            return View.inflate(this.activity, R.layout.dialog_footer_style_2, null);
        }
        if (dialogStyle != 3) {
            return null;
        }
        return View.inflate(this.activity, R.layout.dialog_footer_style_3, null);
    }

    @Override // com.github.gzuliyujiang.dialog.BaseDialog
    protected void initView() {
        super.initView();
        int iContentBackgroundColor = DialogConfig.getDialogColor().contentBackgroundColor();
        int dialogStyle = DialogConfig.getDialogStyle();
        if (dialogStyle == 1 || dialogStyle == 2) {
            setBackgroundColor(1, iContentBackgroundColor);
        } else if (dialogStyle == 3) {
            setBackgroundColor(2, iContentBackgroundColor);
        } else {
            setBackgroundColor(0, iContentBackgroundColor);
        }
        TextView textView = (TextView) this.contentView.findViewById(R.id.dialog_modal_cancel);
        this.cancelView = textView;
        if (textView == null) {
            throw new IllegalArgumentException("Cancel view id not found");
        }
        TextView textView2 = (TextView) this.contentView.findViewById(R.id.dialog_modal_title);
        this.titleView = textView2;
        if (textView2 == null) {
            throw new IllegalArgumentException("Title view id not found");
        }
        TextView textView3 = (TextView) this.contentView.findViewById(R.id.dialog_modal_ok);
        this.okView = textView3;
        if (textView3 == null) {
            throw new IllegalArgumentException("Ok view id not found");
        }
        this.titleView.setTextColor(DialogConfig.getDialogColor().titleTextColor());
        this.cancelView.setTextColor(DialogConfig.getDialogColor().cancelTextColor());
        this.okView.setTextColor(DialogConfig.getDialogColor().okTextColor());
        this.cancelView.setOnClickListener(this);
        this.okView.setOnClickListener(this);
        maybeBuildEllipseButton();
    }

    private void maybeBuildEllipseButton() {
        if (DialogConfig.getDialogStyle() == 1 || DialogConfig.getDialogStyle() == 2) {
            if (DialogConfig.getDialogStyle() == 2) {
                Drawable background = this.cancelView.getBackground();
                if (background != null) {
                    background.setColorFilter(new PorterDuffColorFilter(DialogConfig.getDialogColor().cancelEllipseColor(), PorterDuff.Mode.SRC_IN));
                    this.cancelView.setBackground(background);
                } else {
                    this.cancelView.setBackgroundResource(R.mipmap.dialog_close_icon);
                }
            } else {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setCornerRadius(this.okView.getResources().getDisplayMetrics().density * 999.0f);
                gradientDrawable.setColor(DialogConfig.getDialogColor().cancelEllipseColor());
                this.cancelView.setBackground(gradientDrawable);
                if (ColorUtils.calculateLuminance(DialogConfig.getDialogColor().cancelEllipseColor()) < 0.5d) {
                    this.cancelView.setTextColor(-1);
                } else {
                    this.cancelView.setTextColor(-10066330);
                }
            }
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setCornerRadius(this.okView.getResources().getDisplayMetrics().density * 999.0f);
            gradientDrawable2.setColor(DialogConfig.getDialogColor().okEllipseColor());
            this.okView.setBackground(gradientDrawable2);
            if (ColorUtils.calculateLuminance(DialogConfig.getDialogColor().okEllipseColor()) < 0.5d) {
                this.okView.setTextColor(-1);
            } else {
                this.okView.setTextColor(-13421773);
            }
        }
    }

    @Override // android.app.Dialog
    public void setTitle(final CharSequence charSequence) {
        TextView textView = this.titleView;
        if (textView != null) {
            textView.post(new Runnable() { // from class: com.github.gzuliyujiang.dialog.ModalDialog.1
                @Override // java.lang.Runnable
                public void run() {
                    ModalDialog.this.titleView.setText(charSequence);
                }
            });
        } else {
            super.setTitle(charSequence);
        }
    }

    @Override // android.app.Dialog
    public void setTitle(final int i) {
        TextView textView = this.titleView;
        if (textView != null) {
            textView.post(new Runnable() { // from class: com.github.gzuliyujiang.dialog.ModalDialog.2
                @Override // java.lang.Runnable
                public void run() {
                    ModalDialog.this.titleView.setText(i);
                }
            });
        } else {
            super.setTitle(i);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.dialog_modal_cancel) {
            DialogLog.print("cancel clicked");
            onCancel();
            dismiss();
        } else if (id == R.id.dialog_modal_ok) {
            DialogLog.print("ok clicked");
            onOk();
            dismiss();
        }
    }

    public final void setBodyWidth(int i) {
        ViewGroup.LayoutParams layoutParams = this.bodyView.getLayoutParams();
        int i2 = -2;
        if (i != -2 && i != -1) {
            i2 = (int) (this.bodyView.getResources().getDisplayMetrics().density * i);
        }
        layoutParams.width = i2;
        this.bodyView.setLayoutParams(layoutParams);
    }

    public final void setBodyHeight(int i) {
        ViewGroup.LayoutParams layoutParams = this.bodyView.getLayoutParams();
        int i2 = -2;
        if (i != -2 && i != -1) {
            i2 = (int) (this.bodyView.getResources().getDisplayMetrics().density * i);
        }
        layoutParams.height = i2;
        this.bodyView.setLayoutParams(layoutParams);
    }

    public final View getHeaderView() {
        if (this.headerView == null) {
            this.headerView = new View(this.activity);
        }
        return this.headerView;
    }

    public final View getTopLineView() {
        return this.topLineView;
    }

    public final View getBodyView() {
        return this.bodyView;
    }

    public final View getFooterView() {
        return this.footerView;
    }

    public final TextView getCancelView() {
        return this.cancelView;
    }

    public final TextView getTitleView() {
        return this.titleView;
    }

    public final TextView getOkView() {
        return this.okView;
    }
}
