package com.github.gzuliyujiang.wheelpicker;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import com.github.gzuliyujiang.dialog.ModalDialog;
import com.github.gzuliyujiang.wheelpicker.contract.OnNumberPickedListener;
import com.github.gzuliyujiang.wheelpicker.widget.NumberWheelLayout;
import com.github.gzuliyujiang.wheelview.contract.WheelFormatter;
import com.github.gzuliyujiang.wheelview.widget.WheelView;

/* loaded from: classes.dex */
public class NumberPicker extends ModalDialog {
    private OnNumberPickedListener onNumberPickedListener;
    protected NumberWheelLayout wheelLayout;

    @Override // com.github.gzuliyujiang.dialog.ModalDialog
    protected void onCancel() {
    }

    public NumberPicker(Activity activity) {
        super(activity);
    }

    public NumberPicker(Activity activity, int i) {
        super(activity, i);
    }

    @Override // com.github.gzuliyujiang.dialog.ModalDialog
    protected View createBodyView() {
        NumberWheelLayout numberWheelLayout = new NumberWheelLayout(this.activity);
        this.wheelLayout = numberWheelLayout;
        return numberWheelLayout;
    }

    @Override // com.github.gzuliyujiang.dialog.ModalDialog
    protected void onOk() {
        if (this.onNumberPickedListener != null) {
            this.onNumberPickedListener.onNumberPicked(this.wheelLayout.getWheelView().getCurrentPosition(), (Number) this.wheelLayout.getWheelView().getCurrentItem());
        }
    }

    public void setFormatter(WheelFormatter wheelFormatter) {
        this.wheelLayout.getWheelView().setFormatter(wheelFormatter);
    }

    public void setRange(int i, int i2, int i3) {
        this.wheelLayout.setRange(i, i2, i3);
    }

    public void setRange(float f, float f2, float f3) {
        this.wheelLayout.setRange(f, f2, f3);
    }

    public void setDefaultValue(Object obj) {
        this.wheelLayout.setDefaultValue(obj);
    }

    public void setDefaultPosition(int i) {
        this.wheelLayout.setDefaultPosition(i);
    }

    public final void setOnNumberPickedListener(OnNumberPickedListener onNumberPickedListener) {
        this.onNumberPickedListener = onNumberPickedListener;
    }

    public final NumberWheelLayout getWheelLayout() {
        return this.wheelLayout;
    }

    public final WheelView getWheelView() {
        return this.wheelLayout.getWheelView();
    }

    public final TextView getLabelView() {
        return this.wheelLayout.getLabelView();
    }
}
