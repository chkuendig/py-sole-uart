package com.github.gzuliyujiang.wheelpicker;

import android.app.Activity;
import android.view.View;
import com.github.gzuliyujiang.wheelpicker.contract.LinkageProvider;
import com.github.gzuliyujiang.wheelpicker.contract.OnCarPlatePickedListener;
import com.github.gzuliyujiang.wheelpicker.contract.OnLinkagePickedListener;
import com.github.gzuliyujiang.wheelpicker.widget.CarPlateWheelLayout;

/* loaded from: classes.dex */
public class CarPlatePicker extends LinkagePicker {
    private OnCarPlatePickedListener onCarPlatePickedListener;

    public CarPlatePicker(Activity activity) {
        super(activity);
    }

    public CarPlatePicker(Activity activity, int i) {
        super(activity, i);
    }

    @Override // com.github.gzuliyujiang.wheelpicker.LinkagePicker
    @Deprecated
    public void setData(LinkageProvider linkageProvider) {
        throw new UnsupportedOperationException("Data already preset");
    }

    @Override // com.github.gzuliyujiang.wheelpicker.LinkagePicker
    @Deprecated
    public void setOnLinkagePickedListener(OnLinkagePickedListener onLinkagePickedListener) {
        throw new UnsupportedOperationException("Use setOnCarPlatePickedListener instead");
    }

    @Override // com.github.gzuliyujiang.wheelpicker.LinkagePicker, com.github.gzuliyujiang.dialog.ModalDialog
    protected View createBodyView() {
        this.wheelLayout = new CarPlateWheelLayout(this.activity);
        return this.wheelLayout;
    }

    @Override // com.github.gzuliyujiang.wheelpicker.LinkagePicker, com.github.gzuliyujiang.dialog.ModalDialog
    protected void onOk() {
        if (this.onCarPlatePickedListener != null) {
            this.onCarPlatePickedListener.onCarNumberPicked(this.wheelLayout.getFirstWheelView().getCurrentItem().toString(), this.wheelLayout.getSecondWheelView().getCurrentItem().toString());
        }
    }

    public void setOnCarPlatePickedListener(OnCarPlatePickedListener onCarPlatePickedListener) {
        this.onCarPlatePickedListener = onCarPlatePickedListener;
    }
}
