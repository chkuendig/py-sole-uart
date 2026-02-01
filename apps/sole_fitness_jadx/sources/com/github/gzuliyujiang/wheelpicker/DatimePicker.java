package com.github.gzuliyujiang.wheelpicker;

import android.app.Activity;
import android.view.View;
import com.github.gzuliyujiang.dialog.ModalDialog;
import com.github.gzuliyujiang.wheelpicker.contract.OnDatimePickedListener;
import com.github.gzuliyujiang.wheelpicker.widget.DatimeWheelLayout;

/* loaded from: classes.dex */
public class DatimePicker extends ModalDialog {
    private OnDatimePickedListener onDatimePickedListener;
    protected DatimeWheelLayout wheelLayout;

    @Override // com.github.gzuliyujiang.dialog.ModalDialog
    protected void onCancel() {
    }

    public DatimePicker(Activity activity) {
        super(activity);
    }

    public DatimePicker(Activity activity, int i) {
        super(activity, i);
    }

    @Override // com.github.gzuliyujiang.dialog.ModalDialog
    protected View createBodyView() {
        DatimeWheelLayout datimeWheelLayout = new DatimeWheelLayout(this.activity);
        this.wheelLayout = datimeWheelLayout;
        return datimeWheelLayout;
    }

    @Override // com.github.gzuliyujiang.dialog.ModalDialog
    protected void onOk() {
        if (this.onDatimePickedListener != null) {
            this.onDatimePickedListener.onDatimePicked(this.wheelLayout.getSelectedYear(), this.wheelLayout.getSelectedMonth(), this.wheelLayout.getSelectedDay(), this.wheelLayout.getSelectedHour(), this.wheelLayout.getSelectedMinute(), this.wheelLayout.getSelectedSecond());
        }
    }

    public void setOnDatimePickedListener(OnDatimePickedListener onDatimePickedListener) {
        this.onDatimePickedListener = onDatimePickedListener;
    }

    public final DatimeWheelLayout getWheelLayout() {
        return this.wheelLayout;
    }
}
