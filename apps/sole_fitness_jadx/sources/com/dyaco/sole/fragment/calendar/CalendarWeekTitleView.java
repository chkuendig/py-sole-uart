package com.dyaco.sole.fragment.calendar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.dyaco.sole.custom.CalendarUtils;
import com.dyaco.sole.custom.Global;
import com.facebook.appevents.AppEventsConstants;
import com.soletreadmills.sole.R;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* loaded from: classes.dex */
public class CalendarWeekTitleView extends View {
    private static final int DAYS_COUNT = 7;
    private final float LINE_LEFT_MARGIN;
    private Paint blueBoldPaint;
    private Context context;
    private Calendar currentDate;
    private int dayOneLengthTextWidth;
    private int dayTwoLengthTextWidth;
    private int nowDayIndex;
    private int[] nowWeeks;
    private Paint paint;
    private Resources res;
    private float timeTextSize;
    private float viewHeight;
    private float viewWidth;
    private int weekTextHeight;
    private int weekTextWidth;
    private int weekWidthSplit;
    private String[] weeks;

    public CalendarWeekTitleView(Context context) {
        super(context);
        Resources resources = getResources();
        this.res = resources;
        this.LINE_LEFT_MARGIN = resources.getDimension(R.dimen.calendar_week_margin_start);
        this.nowDayIndex = -1;
        this.context = context;
        init();
    }

    public CalendarWeekTitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Resources resources = getResources();
        this.res = resources;
        this.LINE_LEFT_MARGIN = resources.getDimension(R.dimen.calendar_week_margin_start);
        this.nowDayIndex = -1;
        this.context = context;
        init();
    }

    public CalendarWeekTitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Resources resources = getResources();
        this.res = resources;
        this.LINE_LEFT_MARGIN = resources.getDimension(R.dimen.calendar_week_margin_start);
        this.nowDayIndex = -1;
        this.context = context;
        init();
    }

    private void init() {
        String[] shortWeekdays = DateFormatSymbols.getInstance().getShortWeekdays();
        this.weeks = new String[7];
        for (int i = 1; i < shortWeekdays.length; i++) {
            this.weeks[i - 1] = shortWeekdays[i];
        }
        this.timeTextSize = Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.calendar_list_title_text_size), 0.8f);
        Paint paint = new Paint();
        this.paint = paint;
        paint.setStrokeWidth(2.0f);
        this.paint.setTextSize(this.timeTextSize);
        Paint paint2 = new Paint();
        this.blueBoldPaint = paint2;
        paint2.setTextSize(this.timeTextSize);
        int i2 = Global.BRAND;
        if (i2 == 0) {
            this.paint.setColor(this.res.getColor(R.color.light_gray));
            this.blueBoldPaint.setColor(this.res.getColor(R.color.display_number_blue));
            this.blueBoldPaint.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
        } else if (i2 == 1 || i2 == 2 || i2 == 3) {
            this.paint.setColor(this.res.getColor(R.color.black));
            this.blueBoldPaint.setColor(this.res.getColor(R.color.spirit_program_red));
        }
        Rect rect = new Rect();
        Paint paint3 = this.paint;
        String[] strArr = this.weeks;
        paint3.getTextBounds(strArr[0], 0, strArr[0].length(), rect);
        this.weekTextWidth = rect.width();
        this.weekTextHeight = rect.height();
        this.paint.getTextBounds(AppEventsConstants.EVENT_PARAM_VALUE_YES, 0, 1, rect);
        this.dayOneLengthTextWidth = rect.width();
        this.paint.getTextBounds("30", 0, 2, rect);
        this.dayTwoLengthTextWidth = rect.width();
    }

    private void getCanvasSize(Canvas canvas) {
        this.viewWidth = canvas.getWidth();
        this.viewHeight = canvas.getHeight();
        this.weekWidthSplit = (int) ((this.viewWidth - this.LINE_LEFT_MARGIN) / 8.0f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i;
        int i2;
        super.onDraw(canvas);
        if (this.viewWidth == 0.0f || this.viewHeight == 0.0f) {
            getCanvasSize(canvas);
        }
        int i3 = 0;
        while (true) {
            String[] strArr = this.weeks;
            if (i3 >= strArr.length) {
                return;
            }
            int i4 = i3 + 1;
            int i5 = ((int) (this.LINE_LEFT_MARGIN / 2.0f)) + (this.weekWidthSplit * i4);
            int i6 = this.weekTextWidth;
            int i7 = i5 - (i6 / 2);
            int i8 = this.nowWeeks[i3];
            if (i8 < 10) {
                i = i6 / 2;
                i2 = this.dayOneLengthTextWidth / 2;
            } else {
                i = i6 / 2;
                i2 = this.dayTwoLengthTextWidth / 2;
            }
            int i9 = i - i2;
            Paint paint = this.nowDayIndex == i3 ? this.blueBoldPaint : this.paint;
            canvas.drawText(strArr[i3], i7, this.weekTextHeight, paint);
            canvas.drawText(String.valueOf(i8), i7 + i9, (r2 * 2) + (this.weekTextHeight / 2.0f), paint);
            i3 = i4;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(i, (int) (this.weekTextHeight * 2.5f));
    }

    public void changeCalendar(Calendar calendar) throws NumberFormatException {
        this.currentDate = calendar;
        changeWeekCalendar();
    }

    public void changeWeekCalendar() throws NumberFormatException {
        String firstDayOfWeek = getFirstDayOfWeek(this.currentDate, CalendarUtils.WEEK_DATE_FORMAT);
        String lastDayOfWeek = getLastDayOfWeek(this.currentDate, CalendarUtils.WEEK_DATE_FORMAT);
        int i = Integer.parseInt(firstDayOfWeek.substring(firstDayOfWeek.length() - 2, firstDayOfWeek.length()));
        int i2 = Integer.parseInt(lastDayOfWeek.substring(lastDayOfWeek.length() - 2, lastDayOfWeek.length()));
        Calendar calendar = (Calendar) this.currentDate.clone();
        calendar.add(5, getFirstDay(this.currentDate));
        boolean z = false;
        int i3 = 0;
        while (i3 < 7) {
            i3++;
            calendar.add(5, 1);
        }
        Date date = new Date();
        Date time = calendar.getTime();
        int i4 = (i - 1) + (7 - i2);
        int[] iArr = new int[7];
        this.nowWeeks = iArr;
        for (int length = iArr.length - 1; length >= 0; length--) {
            if (!z) {
                if (date.getYear() == time.getYear() && date.getMonth() == time.getMonth() && date.getDate() == i2) {
                    this.nowDayIndex = length;
                    z = true;
                } else {
                    this.nowDayIndex = -1;
                }
            }
            this.nowWeeks[length] = i2;
            i2--;
            if (i2 - i < 0 && i2 <= 0) {
                calendar.add(2, -1);
                time = calendar.getTime();
                i2 = i4;
            }
        }
        Log.d("~~~~~~~~~", "nowDayIndex = " + this.nowDayIndex);
        invalidate();
    }

    private static int getFirstDay(Calendar calendar) {
        return 1 - calendar.get(7);
    }

    public static String getFirstDayOfWeek(Calendar calendar, String str) {
        Calendar calendar2 = (Calendar) calendar.clone();
        calendar2.add(5, getFirstDay(calendar));
        return new SimpleDateFormat(str).format(calendar2.getTime());
    }

    public static String getLastDayOfWeek(Calendar calendar, String str) {
        Calendar calendar2 = (Calendar) calendar.clone();
        calendar2.add(5, getFirstDay(calendar) + 6);
        return new SimpleDateFormat(str).format(calendar2.getTime());
    }
}
