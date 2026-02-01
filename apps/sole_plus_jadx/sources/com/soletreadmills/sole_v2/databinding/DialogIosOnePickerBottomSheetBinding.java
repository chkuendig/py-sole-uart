package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.soletreadmills.sole_v2.R;
import com.weigan.loopview.LoopView;

/* loaded from: classes5.dex */
public abstract class DialogIosOnePickerBottomSheetBinding extends ViewDataBinding {
    public final ConstraintLayout CLTitle;
    public final AppCompatButton apply;
    public final ImageView close;
    public final ImageView imageView16;
    public final LoopView loop;
    public final TextView title;

    protected DialogIosOnePickerBottomSheetBinding(Object _bindingComponent, View _root, int _localFieldCount, ConstraintLayout CLTitle, AppCompatButton apply, ImageView close, ImageView imageView16, LoopView loop, TextView title) {
        super(_bindingComponent, _root, _localFieldCount);
        this.CLTitle = CLTitle;
        this.apply = apply;
        this.close = close;
        this.imageView16 = imageView16;
        this.loop = loop;
        this.title = title;
    }

    public static DialogIosOnePickerBottomSheetBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogIosOnePickerBottomSheetBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DialogIosOnePickerBottomSheetBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_ios_one_picker_bottom_sheet, root, attachToRoot, component);
    }

    public static DialogIosOnePickerBottomSheetBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogIosOnePickerBottomSheetBinding inflate(LayoutInflater inflater, Object component) {
        return (DialogIosOnePickerBottomSheetBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_ios_one_picker_bottom_sheet, null, false, component);
    }

    public static DialogIosOnePickerBottomSheetBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogIosOnePickerBottomSheetBinding bind(View view, Object component) {
        return (DialogIosOnePickerBottomSheetBinding) bind(component, view, R.layout.dialog_ios_one_picker_bottom_sheet);
    }
}
