package com.github.gzuliyujiang.wheelpicker.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.github.gzuliyujiang.wheelpicker.R;
import com.github.gzuliyujiang.wheelpicker.contract.DateFormatter;
import com.github.gzuliyujiang.wheelpicker.contract.OnDatimeSelectedListener;
import com.github.gzuliyujiang.wheelpicker.contract.TimeFormatter;
import com.github.gzuliyujiang.wheelpicker.entity.DatimeEntity;
import com.github.gzuliyujiang.wheelpicker.impl.SimpleDateFormatter;
import com.github.gzuliyujiang.wheelpicker.impl.SimpleTimeFormatter;
import com.github.gzuliyujiang.wheelview.widget.NumberWheelView;
import com.github.gzuliyujiang.wheelview.widget.WheelView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class DatimeWheelLayout extends BaseWheelLayout {
    private DateWheelLayout dateWheelLayout;
    private DatimeEntity endValue;
    private OnDatimeSelectedListener onDatimeSelectedListener;
    private DatimeEntity startValue;
    private TimeWheelLayout timeWheelLayout;

    public DatimeWheelLayout(Context context) {
        super(context);
    }

    public DatimeWheelLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DatimeWheelLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public DatimeWheelLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout
    protected int provideLayoutRes() {
        return R.layout.wheel_picker_datime;
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout
    protected int[] provideStyleableRes() {
        return R.styleable.DatimeWheelLayout;
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout
    protected List<WheelView> provideWheelViews() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.dateWheelLayout.provideWheelViews());
        arrayList.addAll(this.timeWheelLayout.provideWheelViews());
        return arrayList;
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout
    protected void onInit(Context context) {
        this.dateWheelLayout = (DateWheelLayout) findViewById(R.id.wheel_picker_date_wheel);
        this.timeWheelLayout = (TimeWheelLayout) findViewById(R.id.wheel_picker_time_wheel);
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout
    protected void onAttributeSet(Context context, TypedArray typedArray) {
        float f = context.getResources().getDisplayMetrics().density;
        setTextSize(typedArray.getDimensionPixelSize(R.styleable.DatimeWheelLayout_wheel_itemTextSize, (int) (context.getResources().getDisplayMetrics().scaledDensity * 15.0f)));
        setVisibleItemCount(typedArray.getInt(R.styleable.DatimeWheelLayout_wheel_visibleItemCount, 5));
        setSameWidthEnabled(typedArray.getBoolean(R.styleable.DatimeWheelLayout_wheel_sameWidthEnabled, false));
        setMaxWidthText(typedArray.getString(R.styleable.DatimeWheelLayout_wheel_maxWidthText));
        setSelectedTextColor(typedArray.getColor(R.styleable.DatimeWheelLayout_wheel_itemTextColorSelected, ViewCompat.MEASURED_STATE_MASK));
        setTextColor(typedArray.getColor(R.styleable.DatimeWheelLayout_wheel_itemTextColor, -7829368));
        setItemSpace(typedArray.getDimensionPixelSize(R.styleable.DatimeWheelLayout_wheel_itemSpace, (int) (20.0f * f)));
        setCyclicEnabled(typedArray.getBoolean(R.styleable.DatimeWheelLayout_wheel_cyclicEnabled, false));
        setIndicatorEnabled(typedArray.getBoolean(R.styleable.DatimeWheelLayout_wheel_indicatorEnabled, false));
        setIndicatorColor(typedArray.getColor(R.styleable.DatimeWheelLayout_wheel_indicatorColor, -3552823));
        float f2 = f * 1.0f;
        setIndicatorSize(typedArray.getDimension(R.styleable.DatimeWheelLayout_wheel_indicatorSize, f2));
        setCurvedIndicatorSpace(typedArray.getDimensionPixelSize(R.styleable.DatimeWheelLayout_wheel_curvedIndicatorSpace, (int) f2));
        setCurtainEnabled(typedArray.getBoolean(R.styleable.DatimeWheelLayout_wheel_curtainEnabled, false));
        setCurtainColor(typedArray.getColor(R.styleable.DatimeWheelLayout_wheel_curtainColor, -1996488705));
        setCurtainRadius(typedArray.getDimension(R.styleable.DatimeWheelLayout_wheel_curtainRadius, 0.0f));
        setAtmosphericEnabled(typedArray.getBoolean(R.styleable.DatimeWheelLayout_wheel_atmosphericEnabled, false));
        setCurvedEnabled(typedArray.getBoolean(R.styleable.DatimeWheelLayout_wheel_curvedEnabled, false));
        setCurvedMaxAngle(typedArray.getInteger(R.styleable.DatimeWheelLayout_wheel_curvedMaxAngle, 90));
        setTextAlign(typedArray.getInt(R.styleable.DatimeWheelLayout_wheel_itemTextAlign, 0));
        setDateMode(typedArray.getInt(R.styleable.DatimeWheelLayout_wheel_dateMode, 0));
        setTimeMode(typedArray.getInt(R.styleable.DatimeWheelLayout_wheel_timeMode, 0));
        setDateLabel(typedArray.getString(R.styleable.DatimeWheelLayout_wheel_yearLabel), typedArray.getString(R.styleable.DatimeWheelLayout_wheel_monthLabel), typedArray.getString(R.styleable.DatimeWheelLayout_wheel_dayLabel));
        setTimeLabel(typedArray.getString(R.styleable.DatimeWheelLayout_wheel_hourLabel), typedArray.getString(R.styleable.DatimeWheelLayout_wheel_minuteLabel), typedArray.getString(R.styleable.DatimeWheelLayout_wheel_secondLabel));
        setDateFormatter(new SimpleDateFormatter());
        setTimeFormatter(new SimpleTimeFormatter(this.timeWheelLayout));
        setRange(DatimeEntity.now(), DatimeEntity.yearOnFuture(30), DatimeEntity.now());
    }

    @Override // com.github.gzuliyujiang.wheelview.contract.OnWheelChangedListener
    public void onWheelSelected(WheelView wheelView, int i) {
        this.dateWheelLayout.onWheelSelected(wheelView, i);
        this.timeWheelLayout.onWheelSelected(wheelView, i);
        if (this.onDatimeSelectedListener == null) {
            return;
        }
        this.timeWheelLayout.post(new Runnable() { // from class: com.github.gzuliyujiang.wheelpicker.widget.DatimeWheelLayout.1
            @Override // java.lang.Runnable
            public void run() {
                DatimeWheelLayout.this.onDatimeSelectedListener.onDatimeSelected(DatimeWheelLayout.this.dateWheelLayout.getSelectedYear(), DatimeWheelLayout.this.dateWheelLayout.getSelectedMonth(), DatimeWheelLayout.this.dateWheelLayout.getSelectedDay(), DatimeWheelLayout.this.timeWheelLayout.getSelectedHour(), DatimeWheelLayout.this.timeWheelLayout.getSelectedMinute(), DatimeWheelLayout.this.timeWheelLayout.getSelectedSecond());
            }
        });
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout, com.github.gzuliyujiang.wheelview.contract.OnWheelChangedListener
    public void onWheelScrolled(WheelView wheelView, int i) {
        this.dateWheelLayout.onWheelScrolled(wheelView, i);
        this.timeWheelLayout.onWheelScrolled(wheelView, i);
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout, com.github.gzuliyujiang.wheelview.contract.OnWheelChangedListener
    public void onWheelScrollStateChanged(WheelView wheelView, int i) {
        this.dateWheelLayout.onWheelScrollStateChanged(wheelView, i);
        this.timeWheelLayout.onWheelScrollStateChanged(wheelView, i);
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout, com.github.gzuliyujiang.wheelview.contract.OnWheelChangedListener
    public void onWheelLoopFinished(WheelView wheelView) {
        this.dateWheelLayout.onWheelLoopFinished(wheelView);
        this.timeWheelLayout.onWheelLoopFinished(wheelView);
    }

    public void setDateMode(int i) {
        this.dateWheelLayout.setDateMode(i);
    }

    public void setTimeMode(int i) {
        this.timeWheelLayout.setTimeMode(i);
    }

    public void setRange(DatimeEntity datimeEntity, DatimeEntity datimeEntity2) {
        setRange(datimeEntity, datimeEntity2, null);
    }

    public void setRange(DatimeEntity datimeEntity, DatimeEntity datimeEntity2, DatimeEntity datimeEntity3) {
        if (datimeEntity == null) {
            datimeEntity = DatimeEntity.now();
        }
        if (datimeEntity2 == null) {
            datimeEntity2 = DatimeEntity.yearOnFuture(10);
        }
        if (datimeEntity3 == null) {
            datimeEntity3 = datimeEntity;
        }
        this.dateWheelLayout.setRange(datimeEntity.getDate(), datimeEntity2.getDate(), datimeEntity3.getDate());
        this.timeWheelLayout.setRange(null, null, datimeEntity3.getTime());
        this.startValue = datimeEntity;
        this.endValue = datimeEntity2;
    }

    public void setDefaultValue(DatimeEntity datimeEntity) {
        if (datimeEntity == null) {
            datimeEntity = DatimeEntity.now();
        }
        this.dateWheelLayout.setDefaultValue(datimeEntity.getDate());
        this.timeWheelLayout.setDefaultValue(datimeEntity.getTime());
    }

    public void setDateFormatter(DateFormatter dateFormatter) {
        this.dateWheelLayout.setDateFormatter(dateFormatter);
    }

    public void setTimeFormatter(TimeFormatter timeFormatter) {
        this.timeWheelLayout.setTimeFormatter(timeFormatter);
    }

    public void setDateLabel(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        this.dateWheelLayout.setDateLabel(charSequence, charSequence2, charSequence3);
    }

    public void setTimeLabel(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        this.timeWheelLayout.setTimeLabel(charSequence, charSequence2, charSequence3);
    }

    public void setOnDatimeSelectedListener(OnDatimeSelectedListener onDatimeSelectedListener) {
        this.onDatimeSelectedListener = onDatimeSelectedListener;
    }

    public final DatimeEntity getStartValue() {
        return this.startValue;
    }

    public final DatimeEntity getEndValue() {
        return this.endValue;
    }

    public final DateWheelLayout getDateWheelLayout() {
        return this.dateWheelLayout;
    }

    public final TimeWheelLayout getTimeWheelLayout() {
        return this.timeWheelLayout;
    }

    public final NumberWheelView getYearWheelView() {
        return this.dateWheelLayout.getYearWheelView();
    }

    public final NumberWheelView getMonthWheelView() {
        return this.dateWheelLayout.getMonthWheelView();
    }

    public final NumberWheelView getDayWheelView() {
        return this.dateWheelLayout.getDayWheelView();
    }

    public final NumberWheelView getHourWheelView() {
        return this.timeWheelLayout.getHourWheelView();
    }

    public final NumberWheelView getMinuteWheelView() {
        return this.timeWheelLayout.getMinuteWheelView();
    }

    public final NumberWheelView getSecondWheelView() {
        return this.timeWheelLayout.getSecondWheelView();
    }

    public final WheelView getMeridiemWheelView() {
        return this.timeWheelLayout.getMeridiemWheelView();
    }

    public final TextView getYearLabelView() {
        return this.dateWheelLayout.getYearLabelView();
    }

    public final TextView getMonthLabelView() {
        return this.dateWheelLayout.getMonthLabelView();
    }

    public final TextView getDayLabelView() {
        return this.dateWheelLayout.getDayLabelView();
    }

    public final TextView getHourLabelView() {
        return this.timeWheelLayout.getHourLabelView();
    }

    public final TextView getMinuteLabelView() {
        return this.timeWheelLayout.getMinuteLabelView();
    }

    public final TextView getSecondLabelView() {
        return this.timeWheelLayout.getSecondLabelView();
    }

    public final int getSelectedYear() {
        return this.dateWheelLayout.getSelectedYear();
    }

    public final int getSelectedMonth() {
        return this.dateWheelLayout.getSelectedMonth();
    }

    public final int getSelectedDay() {
        return this.dateWheelLayout.getSelectedDay();
    }

    public final int getSelectedHour() {
        return this.timeWheelLayout.getSelectedHour();
    }

    public final int getSelectedMinute() {
        return this.timeWheelLayout.getSelectedMinute();
    }

    public final int getSelectedSecond() {
        return this.timeWheelLayout.getSelectedSecond();
    }
}
