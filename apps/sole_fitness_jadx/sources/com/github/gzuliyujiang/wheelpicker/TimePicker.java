package com.github.gzuliyujiang.wheelpicker;

import android.app.Activity;
import android.view.View;
import com.github.gzuliyujiang.dialog.ModalDialog;
import com.github.gzuliyujiang.wheelpicker.contract.OnTimeMeridiemPickedListener;
import com.github.gzuliyujiang.wheelpicker.contract.OnTimePickedListener;
import com.github.gzuliyujiang.wheelpicker.widget.TimeWheelLayout;

/* loaded from: classes.dex */
public class TimePicker extends ModalDialog {
    private OnTimeMeridiemPickedListener onTimeMeridiemPickedListener;
    private OnTimePickedListener onTimePickedListener;
    protected TimeWheelLayout wheelLayout;

    @Override // com.github.gzuliyujiang.dialog.ModalDialog
    protected void onCancel() {
    }

    public TimePicker(Activity activity) {
        super(activity);
    }

    public TimePicker(Activity activity, int i) {
        super(activity, i);
    }

    @Override // com.github.gzuliyujiang.dialog.ModalDialog
    protected View createBodyView() {
        TimeWheelLayout timeWheelLayout = new TimeWheelLayout(this.activity);
        this.wheelLayout = timeWheelLayout;
        return timeWheelLayout;
    }

    @Override // com.github.gzuliyujiang.dialog.ModalDialog
    protected void onOk() {
        int selectedHour = this.wheelLayout.getSelectedHour();
        int selectedMinute = this.wheelLayout.getSelectedMinute();
        int selectedSecond = this.wheelLayout.getSelectedSecond();
        OnTimePickedListener onTimePickedListener = this.onTimePickedListener;
        if (onTimePickedListener != null) {
            onTimePickedListener.onTimePicked(selectedHour, selectedMinute, selectedSecond);
        }
        OnTimeMeridiemPickedListener onTimeMeridiemPickedListener = this.onTimeMeridiemPickedListener;
        if (onTimeMeridiemPickedListener != null) {
            onTimeMeridiemPickedListener.onTimePicked(selectedHour, selectedMinute, selectedSecond, this.wheelLayout.isAnteMeridiem());
        }
    }

    public void setOnTimePickedListener(OnTimePickedListener onTimePickedListener) {
        this.onTimePickedListener = onTimePickedListener;
    }

    public void setOnTimeMeridiemPickedListener(OnTimeMeridiemPickedListener onTimeMeridiemPickedListener) {
        this.onTimeMeridiemPickedListener = onTimeMeridiemPickedListener;
    }

    public final TimeWheelLayout getWheelLayout() {
        return this.wheelLayout;
    }
}
