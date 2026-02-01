package com.github.gzuliyujiang.wheelpicker;

import android.app.Activity;
import android.view.View;
import com.github.gzuliyujiang.dialog.ModalDialog;
import com.github.gzuliyujiang.wheelpicker.contract.OnDatePickedListener;
import com.github.gzuliyujiang.wheelpicker.widget.DateWheelLayout;

/* loaded from: classes.dex */
public class DatePicker extends ModalDialog {
    private OnDatePickedListener onDatePickedListener;
    protected DateWheelLayout wheelLayout;

    @Override // com.github.gzuliyujiang.dialog.ModalDialog
    protected void onCancel() {
    }

    public DatePicker(Activity activity) {
        super(activity);
    }

    public DatePicker(Activity activity, int i) {
        super(activity, i);
    }

    @Override // com.github.gzuliyujiang.dialog.ModalDialog
    protected View createBodyView() {
        DateWheelLayout dateWheelLayout = new DateWheelLayout(this.activity);
        this.wheelLayout = dateWheelLayout;
        return dateWheelLayout;
    }

    @Override // com.github.gzuliyujiang.dialog.ModalDialog
    protected void onOk() {
        if (this.onDatePickedListener != null) {
            this.onDatePickedListener.onDatePicked(this.wheelLayout.getSelectedYear(), this.wheelLayout.getSelectedMonth(), this.wheelLayout.getSelectedDay());
        }
    }

    public void setOnDatePickedListener(OnDatePickedListener onDatePickedListener) {
        this.onDatePickedListener = onDatePickedListener;
    }

    public final DateWheelLayout getWheelLayout() {
        return this.wheelLayout;
    }
}
