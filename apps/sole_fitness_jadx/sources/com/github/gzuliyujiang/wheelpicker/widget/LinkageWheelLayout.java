package com.github.gzuliyujiang.wheelpicker.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.github.gzuliyujiang.wheelpicker.R;
import com.github.gzuliyujiang.wheelpicker.contract.LinkageProvider;
import com.github.gzuliyujiang.wheelpicker.contract.OnLinkageSelectedListener;
import com.github.gzuliyujiang.wheelview.contract.WheelFormatter;
import com.github.gzuliyujiang.wheelview.widget.WheelView;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class LinkageWheelLayout extends BaseWheelLayout {
    private LinkageProvider dataProvider;
    private int firstIndex;
    private TextView firstLabelView;
    private Object firstValue;
    private WheelView firstWheelView;
    private ProgressBar loadingView;
    private OnLinkageSelectedListener onLinkageSelectedListener;
    private int secondIndex;
    private TextView secondLabelView;
    private Object secondValue;
    private WheelView secondWheelView;
    private int thirdIndex;
    private TextView thirdLabelView;
    private Object thirdValue;
    private WheelView thirdWheelView;

    public LinkageWheelLayout(Context context) {
        super(context);
    }

    public LinkageWheelLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LinkageWheelLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public LinkageWheelLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout
    protected int provideLayoutRes() {
        return R.layout.wheel_picker_linkage;
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout
    protected int[] provideStyleableRes() {
        return R.styleable.LinkageWheelLayout;
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout
    protected List<WheelView> provideWheelViews() {
        return Arrays.asList(this.firstWheelView, this.secondWheelView, this.thirdWheelView);
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout
    protected void onInit(Context context) {
        this.firstWheelView = (WheelView) findViewById(R.id.wheel_picker_linkage_first_wheel);
        this.secondWheelView = (WheelView) findViewById(R.id.wheel_picker_linkage_second_wheel);
        this.thirdWheelView = (WheelView) findViewById(R.id.wheel_picker_linkage_third_wheel);
        this.firstLabelView = (TextView) findViewById(R.id.wheel_picker_linkage_first_label);
        this.secondLabelView = (TextView) findViewById(R.id.wheel_picker_linkage_second_label);
        this.thirdLabelView = (TextView) findViewById(R.id.wheel_picker_linkage_third_label);
        this.loadingView = (ProgressBar) findViewById(R.id.wheel_picker_linkage_loading);
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout
    protected void onAttributeSet(Context context, TypedArray typedArray) {
        float f = context.getResources().getDisplayMetrics().density;
        setTextSize(typedArray.getDimensionPixelSize(R.styleable.LinkageWheelLayout_wheel_itemTextSize, (int) (context.getResources().getDisplayMetrics().scaledDensity * 15.0f)));
        setVisibleItemCount(typedArray.getInt(R.styleable.LinkageWheelLayout_wheel_visibleItemCount, 5));
        setSameWidthEnabled(typedArray.getBoolean(R.styleable.LinkageWheelLayout_wheel_sameWidthEnabled, false));
        setMaxWidthText(typedArray.getString(R.styleable.LinkageWheelLayout_wheel_maxWidthText));
        setSelectedTextColor(typedArray.getColor(R.styleable.LinkageWheelLayout_wheel_itemTextColorSelected, ViewCompat.MEASURED_STATE_MASK));
        setTextColor(typedArray.getColor(R.styleable.LinkageWheelLayout_wheel_itemTextColor, -7829368));
        setItemSpace(typedArray.getDimensionPixelSize(R.styleable.LinkageWheelLayout_wheel_itemSpace, (int) (20.0f * f)));
        setCyclicEnabled(typedArray.getBoolean(R.styleable.LinkageWheelLayout_wheel_cyclicEnabled, false));
        setIndicatorEnabled(typedArray.getBoolean(R.styleable.LinkageWheelLayout_wheel_indicatorEnabled, false));
        setIndicatorColor(typedArray.getColor(R.styleable.LinkageWheelLayout_wheel_indicatorColor, -3552823));
        float f2 = f * 1.0f;
        setIndicatorSize(typedArray.getDimension(R.styleable.LinkageWheelLayout_wheel_indicatorSize, f2));
        setCurvedIndicatorSpace(typedArray.getDimensionPixelSize(R.styleable.LinkageWheelLayout_wheel_curvedIndicatorSpace, (int) f2));
        setCurtainEnabled(typedArray.getBoolean(R.styleable.LinkageWheelLayout_wheel_curtainEnabled, false));
        setCurtainColor(typedArray.getColor(R.styleable.LinkageWheelLayout_wheel_curtainColor, -1996488705));
        setCurtainRadius(typedArray.getDimension(R.styleable.LinkageWheelLayout_wheel_curtainRadius, 0.0f));
        setAtmosphericEnabled(typedArray.getBoolean(R.styleable.LinkageWheelLayout_wheel_atmosphericEnabled, false));
        setCurvedEnabled(typedArray.getBoolean(R.styleable.LinkageWheelLayout_wheel_curvedEnabled, false));
        setCurvedMaxAngle(typedArray.getInteger(R.styleable.LinkageWheelLayout_wheel_curvedMaxAngle, 90));
        setTextAlign(typedArray.getInt(R.styleable.LinkageWheelLayout_wheel_itemTextAlign, 0));
        setFirstVisible(typedArray.getBoolean(R.styleable.LinkageWheelLayout_wheel_firstVisible, true));
        setThirdVisible(typedArray.getBoolean(R.styleable.LinkageWheelLayout_wheel_thirdVisible, true));
        setLabel(typedArray.getString(R.styleable.LinkageWheelLayout_wheel_firstLabel), typedArray.getString(R.styleable.LinkageWheelLayout_wheel_secondLabel), typedArray.getString(R.styleable.LinkageWheelLayout_wheel_thirdLabel));
    }

    @Override // com.github.gzuliyujiang.wheelview.contract.OnWheelChangedListener
    public void onWheelSelected(WheelView wheelView, int i) {
        int id = wheelView.getId();
        if (id == R.id.wheel_picker_linkage_first_wheel) {
            this.firstIndex = i;
            this.secondIndex = 0;
            this.thirdIndex = 0;
            changeSecondData();
            changeThirdData();
            selectedCallback();
            return;
        }
        if (id == R.id.wheel_picker_linkage_second_wheel) {
            this.secondIndex = i;
            this.thirdIndex = 0;
            changeThirdData();
            selectedCallback();
            return;
        }
        if (id == R.id.wheel_picker_linkage_third_wheel) {
            this.thirdIndex = i;
            selectedCallback();
        }
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout, com.github.gzuliyujiang.wheelview.contract.OnWheelChangedListener
    public void onWheelScrollStateChanged(WheelView wheelView, int i) {
        int id = wheelView.getId();
        if (id == R.id.wheel_picker_linkage_first_wheel) {
            this.secondWheelView.setEnabled(i == 0);
            this.thirdWheelView.setEnabled(i == 0);
        } else if (id == R.id.wheel_picker_linkage_second_wheel) {
            this.firstWheelView.setEnabled(i == 0);
            this.thirdWheelView.setEnabled(i == 0);
        } else if (id == R.id.wheel_picker_linkage_third_wheel) {
            this.firstWheelView.setEnabled(i == 0);
            this.secondWheelView.setEnabled(i == 0);
        }
    }

    public void setData(LinkageProvider linkageProvider) {
        setFirstVisible(linkageProvider.firstLevelVisible());
        setThirdVisible(linkageProvider.thirdLevelVisible());
        Object obj = this.firstValue;
        if (obj != null) {
            this.firstIndex = linkageProvider.findFirstIndex(obj);
        }
        Object obj2 = this.secondValue;
        if (obj2 != null) {
            this.secondIndex = linkageProvider.findSecondIndex(this.firstIndex, obj2);
        }
        Object obj3 = this.thirdValue;
        if (obj3 != null) {
            this.thirdIndex = linkageProvider.findThirdIndex(this.firstIndex, this.secondIndex, obj3);
        }
        this.dataProvider = linkageProvider;
        changeFirstData();
        changeSecondData();
        changeThirdData();
    }

    public void setDefaultValue(Object obj, Object obj2, Object obj3) {
        LinkageProvider linkageProvider = this.dataProvider;
        if (linkageProvider != null) {
            int iFindFirstIndex = linkageProvider.findFirstIndex(obj);
            this.firstIndex = iFindFirstIndex;
            int iFindSecondIndex = this.dataProvider.findSecondIndex(iFindFirstIndex, obj2);
            this.secondIndex = iFindSecondIndex;
            this.thirdIndex = this.dataProvider.findThirdIndex(this.firstIndex, iFindSecondIndex, obj3);
            changeFirstData();
            changeSecondData();
            changeThirdData();
            return;
        }
        this.firstValue = obj;
        this.secondValue = obj2;
        this.thirdValue = obj3;
    }

    public void setFormatter(WheelFormatter wheelFormatter, WheelFormatter wheelFormatter2, WheelFormatter wheelFormatter3) {
        this.firstWheelView.setFormatter(wheelFormatter);
        this.secondWheelView.setFormatter(wheelFormatter2);
        this.thirdWheelView.setFormatter(wheelFormatter3);
    }

    public void setLabel(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        this.firstLabelView.setText(charSequence);
        this.secondLabelView.setText(charSequence2);
        this.thirdLabelView.setText(charSequence3);
    }

    public void showLoading() {
        this.loadingView.setVisibility(0);
    }

    public void hideLoading() {
        this.loadingView.setVisibility(8);
    }

    public void setOnLinkageSelectedListener(OnLinkageSelectedListener onLinkageSelectedListener) {
        this.onLinkageSelectedListener = onLinkageSelectedListener;
    }

    public void setFirstVisible(boolean z) {
        if (z) {
            this.firstWheelView.setVisibility(0);
            this.firstLabelView.setVisibility(0);
        } else {
            this.firstWheelView.setVisibility(8);
            this.firstLabelView.setVisibility(8);
        }
    }

    public void setThirdVisible(boolean z) {
        if (z) {
            this.thirdWheelView.setVisibility(0);
            this.thirdLabelView.setVisibility(0);
        } else {
            this.thirdWheelView.setVisibility(8);
            this.thirdLabelView.setVisibility(8);
        }
    }

    private void selectedCallback() {
        if (this.onLinkageSelectedListener == null) {
            return;
        }
        this.thirdWheelView.post(new Runnable() { // from class: com.github.gzuliyujiang.wheelpicker.widget.LinkageWheelLayout.1
            @Override // java.lang.Runnable
            public void run() {
                LinkageWheelLayout.this.onLinkageSelectedListener.onLinkageSelected(LinkageWheelLayout.this.firstWheelView.getCurrentItem(), LinkageWheelLayout.this.secondWheelView.getCurrentItem(), LinkageWheelLayout.this.thirdWheelView.getCurrentItem());
            }
        });
    }

    private void changeFirstData() {
        this.firstWheelView.setData(this.dataProvider.provideFirstData());
        this.firstWheelView.setDefaultPosition(this.firstIndex);
    }

    private void changeSecondData() {
        this.secondWheelView.setData(this.dataProvider.linkageSecondData(this.firstIndex));
        this.secondWheelView.setDefaultPosition(this.secondIndex);
    }

    private void changeThirdData() {
        if (this.dataProvider.thirdLevelVisible()) {
            this.thirdWheelView.setData(this.dataProvider.linkageThirdData(this.firstIndex, this.secondIndex));
            this.thirdWheelView.setDefaultPosition(this.thirdIndex);
        }
    }

    public final WheelView getFirstWheelView() {
        return this.firstWheelView;
    }

    public final WheelView getSecondWheelView() {
        return this.secondWheelView;
    }

    public final WheelView getThirdWheelView() {
        return this.thirdWheelView;
    }

    public final TextView getFirstLabelView() {
        return this.firstLabelView;
    }

    public final TextView getSecondLabelView() {
        return this.secondLabelView;
    }

    public final TextView getThirdLabelView() {
        return this.thirdLabelView;
    }

    public final ProgressBar getLoadingView() {
        return this.loadingView;
    }
}
