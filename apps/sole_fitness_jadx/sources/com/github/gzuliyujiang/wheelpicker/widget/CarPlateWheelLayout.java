package com.github.gzuliyujiang.wheelpicker.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.github.gzuliyujiang.wheelpicker.impl.CarPlateProvider;

/* loaded from: classes.dex */
public class CarPlateWheelLayout extends LinkageWheelLayout {
    private CarPlateProvider provider;

    public CarPlateWheelLayout(Context context) {
        super(context);
    }

    public CarPlateWheelLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CarPlateWheelLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public CarPlateWheelLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.LinkageWheelLayout, com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout
    protected void onInit(Context context) {
        super.onInit(context);
        CarPlateProvider carPlateProvider = new CarPlateProvider();
        this.provider = carPlateProvider;
        setData(carPlateProvider);
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.LinkageWheelLayout, com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout
    protected void onAttributeSet(Context context, TypedArray typedArray) {
        super.onAttributeSet(context, typedArray);
        setFirstVisible(this.provider.firstLevelVisible());
        setThirdVisible(this.provider.thirdLevelVisible());
    }
}
