package com.github.gzuliyujiang.wheelpicker;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import com.github.gzuliyujiang.dialog.ModalDialog;
import com.github.gzuliyujiang.wheelpicker.contract.OnOptionPickedListener;
import com.github.gzuliyujiang.wheelpicker.widget.OptionWheelLayout;
import com.github.gzuliyujiang.wheelview.widget.WheelView;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class OptionPicker extends ModalDialog {
    private List<?> data;
    private int defaultPosition;
    private Object defaultValue;
    private boolean initialized;
    private OnOptionPickedListener onOptionPickedListener;
    protected OptionWheelLayout wheelLayout;

    @Override // com.github.gzuliyujiang.dialog.ModalDialog
    protected void onCancel() {
    }

    protected List<?> provideData() {
        return null;
    }

    public OptionPicker(Activity activity) {
        super(activity);
        this.initialized = false;
        this.defaultPosition = -1;
    }

    public OptionPicker(Activity activity, int i) {
        super(activity, i);
        this.initialized = false;
        this.defaultPosition = -1;
    }

    @Override // com.github.gzuliyujiang.dialog.ModalDialog
    protected View createBodyView() {
        OptionWheelLayout optionWheelLayout = new OptionWheelLayout(this.activity);
        this.wheelLayout = optionWheelLayout;
        return optionWheelLayout;
    }

    @Override // com.github.gzuliyujiang.dialog.BaseDialog
    protected void initData() {
        super.initData();
        this.initialized = true;
        List<?> list = this.data;
        if (list == null || list.size() == 0) {
            this.data = provideData();
        }
        this.wheelLayout.setData(this.data);
        Object obj = this.defaultValue;
        if (obj != null) {
            this.wheelLayout.setDefaultValue(obj);
        }
        int i = this.defaultPosition;
        if (i != -1) {
            this.wheelLayout.setDefaultPosition(i);
        }
    }

    @Override // com.github.gzuliyujiang.dialog.ModalDialog
    protected void onOk() {
        if (this.onOptionPickedListener != null) {
            this.onOptionPickedListener.onOptionPicked(this.wheelLayout.getWheelView().getCurrentPosition(), this.wheelLayout.getWheelView().getCurrentItem());
        }
    }

    public final boolean isInitialized() {
        return this.initialized;
    }

    public void setData(Object... objArr) {
        setData(Arrays.asList(objArr));
    }

    public void setData(List<?> list) {
        this.data = list;
        if (this.initialized) {
            this.wheelLayout.setData(list);
        }
    }

    public void setDefaultValue(Object obj) {
        this.defaultValue = obj;
        if (this.initialized) {
            this.wheelLayout.setDefaultValue(obj);
        }
    }

    public void setDefaultPosition(int i) {
        this.defaultPosition = i;
        if (this.initialized) {
            this.wheelLayout.setDefaultPosition(i);
        }
    }

    public void setOnOptionPickedListener(OnOptionPickedListener onOptionPickedListener) {
        this.onOptionPickedListener = onOptionPickedListener;
    }

    public final OptionWheelLayout getWheelLayout() {
        return this.wheelLayout;
    }

    public final WheelView getWheelView() {
        return this.wheelLayout.getWheelView();
    }

    public final TextView getLabelView() {
        return this.wheelLayout.getLabelView();
    }
}
