package com.github.gzuliyujiang.wheelpicker.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.github.gzuliyujiang.wheelpicker.R;
import com.github.gzuliyujiang.wheelpicker.contract.DateFormatter;
import com.github.gzuliyujiang.wheelpicker.contract.OnDateSelectedListener;
import com.github.gzuliyujiang.wheelpicker.entity.DateEntity;
import com.github.gzuliyujiang.wheelpicker.impl.SimpleDateFormatter;
import com.github.gzuliyujiang.wheelview.contract.WheelFormatter;
import com.github.gzuliyujiang.wheelview.widget.NumberWheelView;
import com.github.gzuliyujiang.wheelview.widget.WheelView;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class DateWheelLayout extends BaseWheelLayout {
    private TextView dayLabelView;
    private NumberWheelView dayWheelView;
    private DateEntity endValue;
    private TextView monthLabelView;
    private NumberWheelView monthWheelView;
    private OnDateSelectedListener onDateSelectedListener;
    private Integer selectedDay;
    private Integer selectedMonth;
    private Integer selectedYear;
    private DateEntity startValue;
    private TextView yearLabelView;
    private NumberWheelView yearWheelView;

    public DateWheelLayout(Context context) {
        super(context);
    }

    public DateWheelLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DateWheelLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public DateWheelLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout
    protected int provideLayoutRes() {
        return R.layout.wheel_picker_date;
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout
    protected int[] provideStyleableRes() {
        return R.styleable.DateWheelLayout;
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout
    protected List<WheelView> provideWheelViews() {
        return Arrays.asList(this.yearWheelView, this.monthWheelView, this.dayWheelView);
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout
    protected void onInit(Context context) {
        this.yearWheelView = (NumberWheelView) findViewById(R.id.wheel_picker_date_year_wheel);
        this.monthWheelView = (NumberWheelView) findViewById(R.id.wheel_picker_date_month_wheel);
        this.dayWheelView = (NumberWheelView) findViewById(R.id.wheel_picker_date_day_wheel);
        this.yearLabelView = (TextView) findViewById(R.id.wheel_picker_date_year_label);
        this.monthLabelView = (TextView) findViewById(R.id.wheel_picker_date_month_label);
        this.dayLabelView = (TextView) findViewById(R.id.wheel_picker_date_day_label);
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout
    protected void onAttributeSet(Context context, TypedArray typedArray) {
        float f = context.getResources().getDisplayMetrics().density;
        setTextSize(typedArray.getDimensionPixelSize(R.styleable.DateWheelLayout_wheel_itemTextSize, (int) (context.getResources().getDisplayMetrics().scaledDensity * 15.0f)));
        setVisibleItemCount(typedArray.getInt(R.styleable.DateWheelLayout_wheel_visibleItemCount, 5));
        setSameWidthEnabled(typedArray.getBoolean(R.styleable.DateWheelLayout_wheel_sameWidthEnabled, false));
        setMaxWidthText(typedArray.getString(R.styleable.DateWheelLayout_wheel_maxWidthText));
        setSelectedTextColor(typedArray.getColor(R.styleable.DateWheelLayout_wheel_itemTextColorSelected, ViewCompat.MEASURED_STATE_MASK));
        setTextColor(typedArray.getColor(R.styleable.DateWheelLayout_wheel_itemTextColor, -7829368));
        setItemSpace(typedArray.getDimensionPixelSize(R.styleable.DateWheelLayout_wheel_itemSpace, (int) (20.0f * f)));
        setCyclicEnabled(typedArray.getBoolean(R.styleable.DateWheelLayout_wheel_cyclicEnabled, false));
        setIndicatorEnabled(typedArray.getBoolean(R.styleable.DateWheelLayout_wheel_indicatorEnabled, false));
        setIndicatorColor(typedArray.getColor(R.styleable.DateWheelLayout_wheel_indicatorColor, -3552823));
        float f2 = f * 1.0f;
        setIndicatorSize(typedArray.getDimension(R.styleable.DateWheelLayout_wheel_indicatorSize, f2));
        setCurvedIndicatorSpace(typedArray.getDimensionPixelSize(R.styleable.DateWheelLayout_wheel_curvedIndicatorSpace, (int) f2));
        setCurtainEnabled(typedArray.getBoolean(R.styleable.DateWheelLayout_wheel_curtainEnabled, false));
        setCurtainColor(typedArray.getColor(R.styleable.DateWheelLayout_wheel_curtainColor, -1996488705));
        setCurtainRadius(typedArray.getDimension(R.styleable.DateWheelLayout_wheel_curtainRadius, 0.0f));
        setAtmosphericEnabled(typedArray.getBoolean(R.styleable.DateWheelLayout_wheel_atmosphericEnabled, false));
        setCurvedEnabled(typedArray.getBoolean(R.styleable.DateWheelLayout_wheel_curvedEnabled, false));
        setCurvedMaxAngle(typedArray.getInteger(R.styleable.DateWheelLayout_wheel_curvedMaxAngle, 90));
        setTextAlign(typedArray.getInt(R.styleable.DateWheelLayout_wheel_itemTextAlign, 0));
        setDateMode(typedArray.getInt(R.styleable.DateWheelLayout_wheel_dateMode, 0));
        setDateLabel(typedArray.getString(R.styleable.DateWheelLayout_wheel_yearLabel), typedArray.getString(R.styleable.DateWheelLayout_wheel_monthLabel), typedArray.getString(R.styleable.DateWheelLayout_wheel_dayLabel));
        setDateFormatter(new SimpleDateFormatter());
        setRange(DateEntity.today(), DateEntity.yearOnFuture(30), DateEntity.today());
    }

    @Override // com.github.gzuliyujiang.wheelview.contract.OnWheelChangedListener
    public void onWheelSelected(WheelView wheelView, int i) {
        int id = wheelView.getId();
        if (id == R.id.wheel_picker_date_year_wheel) {
            Integer num = (Integer) this.yearWheelView.getItem(i);
            this.selectedYear = num;
            this.selectedMonth = null;
            this.selectedDay = null;
            changeMonth(num.intValue());
            dateSelectedCallback();
            return;
        }
        if (id == R.id.wheel_picker_date_month_wheel) {
            this.selectedMonth = (Integer) this.monthWheelView.getItem(i);
            this.selectedDay = null;
            changeDay(this.selectedYear.intValue(), this.selectedMonth.intValue());
            dateSelectedCallback();
            return;
        }
        if (id == R.id.wheel_picker_date_day_wheel) {
            this.selectedDay = (Integer) this.dayWheelView.getItem(i);
            dateSelectedCallback();
        }
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout, com.github.gzuliyujiang.wheelview.contract.OnWheelChangedListener
    public void onWheelScrollStateChanged(WheelView wheelView, int i) {
        int id = wheelView.getId();
        if (id == R.id.wheel_picker_date_year_wheel) {
            this.monthWheelView.setEnabled(i == 0);
            this.dayWheelView.setEnabled(i == 0);
        } else if (id == R.id.wheel_picker_date_month_wheel) {
            this.yearWheelView.setEnabled(i == 0);
            this.dayWheelView.setEnabled(i == 0);
        } else if (id == R.id.wheel_picker_date_day_wheel) {
            this.yearWheelView.setEnabled(i == 0);
            this.monthWheelView.setEnabled(i == 0);
        }
    }

    private void dateSelectedCallback() {
        if (this.onDateSelectedListener == null) {
            return;
        }
        this.dayWheelView.post(new Runnable() { // from class: com.github.gzuliyujiang.wheelpicker.widget.DateWheelLayout.1
            @Override // java.lang.Runnable
            public void run() {
                DateWheelLayout.this.onDateSelectedListener.onDateSelected(DateWheelLayout.this.selectedYear.intValue(), DateWheelLayout.this.selectedMonth.intValue(), DateWheelLayout.this.selectedDay.intValue());
            }
        });
    }

    public void setDateMode(int i) {
        this.yearWheelView.setVisibility(0);
        this.yearLabelView.setVisibility(0);
        this.monthWheelView.setVisibility(0);
        this.monthLabelView.setVisibility(0);
        this.dayWheelView.setVisibility(0);
        this.dayLabelView.setVisibility(0);
        if (i == -1) {
            this.yearWheelView.setVisibility(8);
            this.yearLabelView.setVisibility(8);
            this.monthWheelView.setVisibility(8);
            this.monthLabelView.setVisibility(8);
            this.dayWheelView.setVisibility(8);
            this.dayLabelView.setVisibility(8);
            return;
        }
        if (i == 2) {
            this.yearWheelView.setVisibility(8);
            this.yearLabelView.setVisibility(8);
        } else if (i == 1) {
            this.dayWheelView.setVisibility(8);
            this.dayLabelView.setVisibility(8);
        }
    }

    public void setRange(DateEntity dateEntity, DateEntity dateEntity2) {
        setRange(dateEntity, dateEntity2, null);
    }

    public void setRange(DateEntity dateEntity, DateEntity dateEntity2, DateEntity dateEntity3) {
        if (dateEntity == null) {
            dateEntity = DateEntity.today();
        }
        if (dateEntity2 == null) {
            dateEntity2 = DateEntity.yearOnFuture(30);
        }
        if (dateEntity2.toTimeInMillis() < dateEntity.toTimeInMillis()) {
            throw new IllegalArgumentException("Ensure the start date is less than the end date");
        }
        this.startValue = dateEntity;
        this.endValue = dateEntity2;
        if (dateEntity3 != null) {
            this.selectedYear = Integer.valueOf(dateEntity3.getYear());
            this.selectedMonth = Integer.valueOf(dateEntity3.getMonth());
            this.selectedDay = Integer.valueOf(dateEntity3.getDay());
        }
        changeYear();
    }

    public void setDefaultValue(DateEntity dateEntity) {
        setRange(this.startValue, this.endValue, dateEntity);
    }

    public void setDateFormatter(final DateFormatter dateFormatter) {
        if (dateFormatter == null) {
            return;
        }
        this.yearWheelView.setFormatter(new WheelFormatter() { // from class: com.github.gzuliyujiang.wheelpicker.widget.DateWheelLayout.2
            @Override // com.github.gzuliyujiang.wheelview.contract.WheelFormatter
            public String formatItem(Object obj) {
                return dateFormatter.formatYear(((Integer) obj).intValue());
            }
        });
        this.monthWheelView.setFormatter(new WheelFormatter() { // from class: com.github.gzuliyujiang.wheelpicker.widget.DateWheelLayout.3
            @Override // com.github.gzuliyujiang.wheelview.contract.WheelFormatter
            public String formatItem(Object obj) {
                return dateFormatter.formatMonth(((Integer) obj).intValue());
            }
        });
        this.dayWheelView.setFormatter(new WheelFormatter() { // from class: com.github.gzuliyujiang.wheelpicker.widget.DateWheelLayout.4
            @Override // com.github.gzuliyujiang.wheelview.contract.WheelFormatter
            public String formatItem(Object obj) {
                return dateFormatter.formatDay(((Integer) obj).intValue());
            }
        });
    }

    public void setDateLabel(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        this.yearLabelView.setText(charSequence);
        this.monthLabelView.setText(charSequence2);
        this.dayLabelView.setText(charSequence3);
    }

    public void setOnDateSelectedListener(OnDateSelectedListener onDateSelectedListener) {
        this.onDateSelectedListener = onDateSelectedListener;
    }

    public final DateEntity getStartValue() {
        return this.startValue;
    }

    public final DateEntity getEndValue() {
        return this.endValue;
    }

    public final NumberWheelView getYearWheelView() {
        return this.yearWheelView;
    }

    public final NumberWheelView getMonthWheelView() {
        return this.monthWheelView;
    }

    public final NumberWheelView getDayWheelView() {
        return this.dayWheelView;
    }

    public final TextView getYearLabelView() {
        return this.yearLabelView;
    }

    public final TextView getMonthLabelView() {
        return this.monthLabelView;
    }

    public final TextView getDayLabelView() {
        return this.dayLabelView;
    }

    public final int getSelectedYear() {
        return ((Integer) this.yearWheelView.getCurrentItem()).intValue();
    }

    public final int getSelectedMonth() {
        return ((Integer) this.monthWheelView.getCurrentItem()).intValue();
    }

    public final int getSelectedDay() {
        return ((Integer) this.dayWheelView.getCurrentItem()).intValue();
    }

    private void changeYear() {
        int iMin = Math.min(this.startValue.getYear(), this.endValue.getYear());
        int iMax = Math.max(this.startValue.getYear(), this.endValue.getYear());
        if (this.selectedYear == null) {
            this.selectedYear = Integer.valueOf(iMin);
        }
        this.yearWheelView.setRange(iMin, iMax, 1);
        this.yearWheelView.setDefaultValue(this.selectedYear);
        changeMonth(this.selectedYear.intValue());
    }

    private void changeMonth(int i) {
        int month;
        if (this.startValue.getYear() == this.endValue.getYear()) {
            month = Math.min(this.startValue.getMonth(), this.endValue.getMonth());
            month = Math.max(this.startValue.getMonth(), this.endValue.getMonth());
        } else if (i == this.startValue.getYear()) {
            month = this.startValue.getMonth();
        } else {
            month = i == this.endValue.getYear() ? this.endValue.getMonth() : 12;
            month = 1;
        }
        if (this.selectedMonth == null) {
            this.selectedMonth = Integer.valueOf(month);
        }
        this.monthWheelView.setRange(month, month, 1);
        this.monthWheelView.setDefaultValue(this.selectedMonth);
        changeDay(i, this.selectedMonth.intValue());
    }

    private void changeDay(int i, int i2) {
        int totalDaysInMonth;
        int day;
        if (i == this.startValue.getYear() && i2 == this.startValue.getMonth() && i == this.endValue.getYear() && i2 == this.endValue.getMonth()) {
            day = this.startValue.getDay();
            totalDaysInMonth = this.endValue.getDay();
        } else if (i == this.startValue.getYear() && i2 == this.startValue.getMonth()) {
            int day2 = this.startValue.getDay();
            totalDaysInMonth = getTotalDaysInMonth(i, i2);
            day = day2;
        } else {
            if (i == this.endValue.getYear() && i2 == this.endValue.getMonth()) {
                totalDaysInMonth = this.endValue.getDay();
            } else {
                totalDaysInMonth = getTotalDaysInMonth(i, i2);
            }
            day = 1;
        }
        if (this.selectedDay == null) {
            this.selectedDay = Integer.valueOf(day);
        }
        this.dayWheelView.setRange(day, totalDaysInMonth, 1);
        this.dayWheelView.setDefaultValue(this.selectedDay);
    }

    private int getTotalDaysInMonth(int i, int i2) {
        boolean z = true;
        if (i2 == 1) {
            return 31;
        }
        if (i2 != 2) {
            return (i2 == 3 || i2 == 5 || i2 == 10 || i2 == 12 || i2 == 7 || i2 == 8) ? 31 : 30;
        }
        if (i <= 0) {
            return 29;
        }
        if ((i % 4 != 0 || i % 100 == 0) && i % 400 != 0) {
            z = false;
        }
        return z ? 29 : 28;
    }
}
