package com.github.gzuliyujiang.wheelpicker.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.github.gzuliyujiang.wheelpicker.R;
import com.github.gzuliyujiang.wheelpicker.contract.OnTimeMeridiemSelectedListener;
import com.github.gzuliyujiang.wheelpicker.contract.OnTimeSelectedListener;
import com.github.gzuliyujiang.wheelpicker.contract.TimeFormatter;
import com.github.gzuliyujiang.wheelpicker.entity.TimeEntity;
import com.github.gzuliyujiang.wheelpicker.impl.SimpleTimeFormatter;
import com.github.gzuliyujiang.wheelview.contract.WheelFormatter;
import com.github.gzuliyujiang.wheelview.widget.NumberWheelView;
import com.github.gzuliyujiang.wheelview.widget.WheelView;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class TimeWheelLayout extends BaseWheelLayout {
    private TimeEntity endValue;
    private TextView hourLabelView;
    private NumberWheelView hourWheelView;
    private boolean isAnteMeridiem;
    private WheelView meridiemWheelView;
    private TextView minuteLabelView;
    private NumberWheelView minuteWheelView;
    private OnTimeMeridiemSelectedListener onTimeMeridiemSelectedListener;
    private OnTimeSelectedListener onTimeSelectedListener;
    private TextView secondLabelView;
    private NumberWheelView secondWheelView;
    private Integer selectedHour;
    private Integer selectedMinute;
    private Integer selectedSecond;
    private TimeEntity startValue;
    private int timeMode;

    public TimeWheelLayout(Context context) {
        super(context);
    }

    public TimeWheelLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TimeWheelLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public TimeWheelLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout
    protected int provideLayoutRes() {
        return R.layout.wheel_picker_time;
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout
    protected int[] provideStyleableRes() {
        return R.styleable.TimeWheelLayout;
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout
    protected List<WheelView> provideWheelViews() {
        return Arrays.asList(this.hourWheelView, this.minuteWheelView, this.secondWheelView, this.meridiemWheelView);
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout
    protected void onInit(Context context) {
        this.hourWheelView = (NumberWheelView) findViewById(R.id.wheel_picker_time_hour_wheel);
        this.minuteWheelView = (NumberWheelView) findViewById(R.id.wheel_picker_time_minute_wheel);
        this.secondWheelView = (NumberWheelView) findViewById(R.id.wheel_picker_time_second_wheel);
        this.hourLabelView = (TextView) findViewById(R.id.wheel_picker_time_hour_label);
        this.minuteLabelView = (TextView) findViewById(R.id.wheel_picker_time_minute_label);
        this.secondLabelView = (TextView) findViewById(R.id.wheel_picker_time_second_label);
        this.meridiemWheelView = (WheelView) findViewById(R.id.wheel_picker_time_meridiem_wheel);
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout
    protected void onAttributeSet(Context context, TypedArray typedArray) {
        float f = context.getResources().getDisplayMetrics().density;
        setTextSize(typedArray.getDimensionPixelSize(R.styleable.TimeWheelLayout_wheel_itemTextSize, (int) (context.getResources().getDisplayMetrics().scaledDensity * 15.0f)));
        setVisibleItemCount(typedArray.getInt(R.styleable.TimeWheelLayout_wheel_visibleItemCount, 5));
        setSameWidthEnabled(typedArray.getBoolean(R.styleable.TimeWheelLayout_wheel_sameWidthEnabled, false));
        setMaxWidthText(typedArray.getString(R.styleable.TimeWheelLayout_wheel_maxWidthText));
        setSelectedTextColor(typedArray.getColor(R.styleable.TimeWheelLayout_wheel_itemTextColorSelected, ViewCompat.MEASURED_STATE_MASK));
        setTextColor(typedArray.getColor(R.styleable.TimeWheelLayout_wheel_itemTextColor, -7829368));
        setItemSpace(typedArray.getDimensionPixelSize(R.styleable.TimeWheelLayout_wheel_itemSpace, (int) (20.0f * f)));
        setCyclicEnabled(typedArray.getBoolean(R.styleable.TimeWheelLayout_wheel_cyclicEnabled, false));
        setIndicatorEnabled(typedArray.getBoolean(R.styleable.TimeWheelLayout_wheel_indicatorEnabled, false));
        setIndicatorColor(typedArray.getColor(R.styleable.TimeWheelLayout_wheel_indicatorColor, -3552823));
        float f2 = f * 1.0f;
        setIndicatorSize(typedArray.getDimension(R.styleable.TimeWheelLayout_wheel_indicatorSize, f2));
        setCurvedIndicatorSpace(typedArray.getDimensionPixelSize(R.styleable.TimeWheelLayout_wheel_curvedIndicatorSpace, (int) f2));
        setCurtainEnabled(typedArray.getBoolean(R.styleable.TimeWheelLayout_wheel_curtainEnabled, false));
        setCurtainColor(typedArray.getColor(R.styleable.TimeWheelLayout_wheel_curtainColor, -1996488705));
        setCurtainRadius(typedArray.getDimension(R.styleable.TimeWheelLayout_wheel_curtainRadius, 0.0f));
        setAtmosphericEnabled(typedArray.getBoolean(R.styleable.TimeWheelLayout_wheel_atmosphericEnabled, false));
        setCurvedEnabled(typedArray.getBoolean(R.styleable.TimeWheelLayout_wheel_curvedEnabled, false));
        setCurvedMaxAngle(typedArray.getInteger(R.styleable.TimeWheelLayout_wheel_curvedMaxAngle, 90));
        setTextAlign(typedArray.getInt(R.styleable.TimeWheelLayout_wheel_itemTextAlign, 0));
        setTimeMode(typedArray.getInt(R.styleable.TimeWheelLayout_wheel_timeMode, 0));
        setTimeLabel(typedArray.getString(R.styleable.TimeWheelLayout_wheel_hourLabel), typedArray.getString(R.styleable.TimeWheelLayout_wheel_minuteLabel), typedArray.getString(R.styleable.TimeWheelLayout_wheel_secondLabel));
        setTimeFormatter(new SimpleTimeFormatter(this));
        setRange(TimeEntity.target(0, 0, 0), TimeEntity.target(23, 59, 59), TimeEntity.now());
    }

    @Override // com.github.gzuliyujiang.wheelview.contract.OnWheelChangedListener
    public void onWheelSelected(WheelView wheelView, int i) {
        int id = wheelView.getId();
        if (id == R.id.wheel_picker_time_hour_wheel) {
            Integer num = (Integer) this.hourWheelView.getItem(i);
            this.selectedHour = num;
            this.selectedMinute = null;
            this.selectedSecond = null;
            changeMinute(num.intValue());
            timeSelectedCallback();
            return;
        }
        if (id == R.id.wheel_picker_time_minute_wheel) {
            this.selectedMinute = (Integer) this.minuteWheelView.getItem(i);
            this.selectedSecond = null;
            changeSecond();
            timeSelectedCallback();
            return;
        }
        if (id == R.id.wheel_picker_time_second_wheel) {
            this.selectedSecond = (Integer) this.secondWheelView.getItem(i);
            timeSelectedCallback();
        }
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout, com.github.gzuliyujiang.wheelview.contract.OnWheelChangedListener
    public void onWheelScrollStateChanged(WheelView wheelView, int i) {
        int id = wheelView.getId();
        if (id == R.id.wheel_picker_time_hour_wheel) {
            this.minuteWheelView.setEnabled(i == 0);
            this.secondWheelView.setEnabled(i == 0);
        } else if (id == R.id.wheel_picker_time_minute_wheel) {
            this.hourWheelView.setEnabled(i == 0);
            this.secondWheelView.setEnabled(i == 0);
        } else if (id == R.id.wheel_picker_time_second_wheel) {
            this.hourWheelView.setEnabled(i == 0);
            this.minuteWheelView.setEnabled(i == 0);
        }
    }

    private void timeSelectedCallback() {
        if (this.onTimeSelectedListener != null) {
            this.secondWheelView.post(new Runnable() { // from class: com.github.gzuliyujiang.wheelpicker.widget.TimeWheelLayout.1
                @Override // java.lang.Runnable
                public void run() {
                    TimeWheelLayout.this.onTimeSelectedListener.onTimeSelected(TimeWheelLayout.this.selectedHour.intValue(), TimeWheelLayout.this.selectedMinute.intValue(), TimeWheelLayout.this.selectedSecond.intValue());
                }
            });
        }
        if (this.onTimeMeridiemSelectedListener != null) {
            this.secondWheelView.post(new Runnable() { // from class: com.github.gzuliyujiang.wheelpicker.widget.TimeWheelLayout.2
                @Override // java.lang.Runnable
                public void run() {
                    TimeWheelLayout.this.onTimeMeridiemSelectedListener.onTimeSelected(TimeWheelLayout.this.selectedHour.intValue(), TimeWheelLayout.this.selectedMinute.intValue(), TimeWheelLayout.this.selectedSecond.intValue(), TimeWheelLayout.this.isAnteMeridiem());
                }
            });
        }
    }

    public void setTimeMode(int i) {
        this.timeMode = i;
        this.hourWheelView.setVisibility(0);
        this.hourLabelView.setVisibility(0);
        this.minuteWheelView.setVisibility(0);
        this.minuteLabelView.setVisibility(0);
        this.secondWheelView.setVisibility(0);
        this.secondLabelView.setVisibility(0);
        this.meridiemWheelView.setVisibility(8);
        if (i == -1) {
            this.hourWheelView.setVisibility(8);
            this.hourLabelView.setVisibility(8);
            this.minuteWheelView.setVisibility(8);
            this.minuteLabelView.setVisibility(8);
            this.secondWheelView.setVisibility(8);
            this.secondLabelView.setVisibility(8);
            this.timeMode = i;
            return;
        }
        if (i == 2 || i == 0) {
            this.secondWheelView.setVisibility(8);
            this.secondLabelView.setVisibility(8);
        }
        if (isHour12Mode()) {
            this.meridiemWheelView.setVisibility(0);
            this.meridiemWheelView.setData(Arrays.asList("AM", "PM"));
        }
    }

    public boolean isHour12Mode() {
        int i = this.timeMode;
        return i == 2 || i == 3;
    }

    public void setRange(TimeEntity timeEntity, TimeEntity timeEntity2) {
        setRange(timeEntity, timeEntity2, null);
    }

    public void setRange(TimeEntity timeEntity, TimeEntity timeEntity2, TimeEntity timeEntity3) {
        if (timeEntity == null) {
            timeEntity = TimeEntity.target(isHour12Mode() ? 1 : 0, 0, 0);
        }
        if (timeEntity2 == null) {
            timeEntity2 = TimeEntity.target(isHour12Mode() ? 12 : 23, 59, 59);
        }
        if (timeEntity2.toTimeInMillis() < timeEntity.toTimeInMillis()) {
            throw new IllegalArgumentException("Ensure the start time is less than the time date");
        }
        this.startValue = timeEntity;
        this.endValue = timeEntity2;
        if (timeEntity3 != null) {
            this.isAnteMeridiem = timeEntity3.getHour() <= 12;
            timeEntity3.setHour(wrapHour(timeEntity3.getHour()));
            this.selectedHour = Integer.valueOf(timeEntity3.getHour());
            this.selectedMinute = Integer.valueOf(timeEntity3.getMinute());
            this.selectedSecond = Integer.valueOf(timeEntity3.getSecond());
        }
        changeHour();
        changeAnteMeridiem();
    }

    public void setDefaultValue(TimeEntity timeEntity) {
        setRange(this.startValue, this.endValue, timeEntity);
    }

    public void setTimeFormatter(final TimeFormatter timeFormatter) {
        if (timeFormatter == null) {
            return;
        }
        this.hourWheelView.setFormatter(new WheelFormatter() { // from class: com.github.gzuliyujiang.wheelpicker.widget.TimeWheelLayout.3
            @Override // com.github.gzuliyujiang.wheelview.contract.WheelFormatter
            public String formatItem(Object obj) {
                return timeFormatter.formatHour(((Integer) obj).intValue());
            }
        });
        this.minuteWheelView.setFormatter(new WheelFormatter() { // from class: com.github.gzuliyujiang.wheelpicker.widget.TimeWheelLayout.4
            @Override // com.github.gzuliyujiang.wheelview.contract.WheelFormatter
            public String formatItem(Object obj) {
                return timeFormatter.formatMinute(((Integer) obj).intValue());
            }
        });
        this.secondWheelView.setFormatter(new WheelFormatter() { // from class: com.github.gzuliyujiang.wheelpicker.widget.TimeWheelLayout.5
            @Override // com.github.gzuliyujiang.wheelview.contract.WheelFormatter
            public String formatItem(Object obj) {
                return timeFormatter.formatSecond(((Integer) obj).intValue());
            }
        });
    }

    public void setTimeLabel(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        this.hourLabelView.setText(charSequence);
        this.minuteLabelView.setText(charSequence2);
        this.secondLabelView.setText(charSequence3);
    }

    public void setOnTimeSelectedListener(OnTimeSelectedListener onTimeSelectedListener) {
        this.onTimeSelectedListener = onTimeSelectedListener;
    }

    public void setOnTimeMeridiemSelectedListener(OnTimeMeridiemSelectedListener onTimeMeridiemSelectedListener) {
        this.onTimeMeridiemSelectedListener = onTimeMeridiemSelectedListener;
    }

    public final TimeEntity getStartValue() {
        return this.startValue;
    }

    public final TimeEntity getEndValue() {
        return this.endValue;
    }

    public final NumberWheelView getHourWheelView() {
        return this.hourWheelView;
    }

    public final NumberWheelView getMinuteWheelView() {
        return this.minuteWheelView;
    }

    public final NumberWheelView getSecondWheelView() {
        return this.secondWheelView;
    }

    public final TextView getHourLabelView() {
        return this.hourLabelView;
    }

    public final TextView getMinuteLabelView() {
        return this.minuteLabelView;
    }

    public final TextView getSecondLabelView() {
        return this.secondLabelView;
    }

    public final WheelView getMeridiemWheelView() {
        return this.meridiemWheelView;
    }

    @Deprecated
    public final TextView getMeridiemLabelView() {
        throw new UnsupportedOperationException("Use getMeridiemWheelView instead");
    }

    public final int getSelectedHour() {
        return wrapHour(((Integer) this.hourWheelView.getCurrentItem()).intValue());
    }

    private int wrapHour(int i) {
        return (!isHour12Mode() || i <= 12) ? i : i - 12;
    }

    public final int getSelectedMinute() {
        return ((Integer) this.minuteWheelView.getCurrentItem()).intValue();
    }

    public final int getSelectedSecond() {
        int i = this.timeMode;
        if (i == 2 || i == 0) {
            return 0;
        }
        return ((Integer) this.secondWheelView.getCurrentItem()).intValue();
    }

    public final boolean isAnteMeridiem() {
        return this.meridiemWheelView.getCurrentItem().toString().equalsIgnoreCase("AM");
    }

    private void changeHour() {
        int iMin = Math.min(this.startValue.getHour(), this.endValue.getHour());
        int iMax = Math.max(this.startValue.getHour(), this.endValue.getHour());
        boolean zIsHour12Mode = isHour12Mode();
        int i = isHour12Mode() ? 12 : 23;
        int iMax2 = Math.max(zIsHour12Mode ? 1 : 0, iMin);
        int iMin2 = Math.min(i, iMax);
        if (this.selectedHour == null) {
            this.selectedHour = Integer.valueOf(iMax2);
        }
        this.hourWheelView.setRange(iMax2, iMin2, 1);
        this.hourWheelView.setDefaultValue(this.selectedHour);
        changeMinute(this.selectedHour.intValue());
    }

    private void changeMinute(int i) {
        int minute = 0;
        int minute2 = 59;
        if (i == this.startValue.getHour() && i == this.endValue.getHour()) {
            minute = this.startValue.getMinute();
            minute2 = this.endValue.getMinute();
        } else if (i == this.startValue.getHour()) {
            minute = this.startValue.getMinute();
        } else if (i == this.endValue.getHour()) {
            minute2 = this.endValue.getMinute();
        }
        if (this.selectedMinute == null) {
            this.selectedMinute = Integer.valueOf(minute);
        }
        this.minuteWheelView.setRange(minute, minute2, 1);
        this.minuteWheelView.setDefaultValue(this.selectedMinute);
        changeSecond();
    }

    private void changeSecond() {
        if (this.selectedSecond == null) {
            this.selectedSecond = 0;
        }
        this.secondWheelView.setRange(0, 59, 1);
        this.secondWheelView.setDefaultValue(this.selectedSecond);
    }

    private void changeAnteMeridiem() {
        this.meridiemWheelView.setDefaultValue(this.isAnteMeridiem ? "AM" : "PM");
    }
}
