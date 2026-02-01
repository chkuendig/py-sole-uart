package com.dyaco.sole.custom;

import com.dyaco.sole.fragment.calendar.CalendarWeekTitleView;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes.dex */
public class CalendarUtils implements Cloneable {
    public static final String DAY_DATE_FORMAT = "EEE. MM/dd/yyyy";
    private static final String MONTH_DATE_FORMAT = "MMM yyyy";
    public static final String SQL_DATE_FORMAT = "yyyy-MM-dd";
    public static final String SQL_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final int TYPE_DAY = 0;
    public static final int TYPE_MONTH = 2;
    public static final int TYPE_TOTAL_TO_DATE = 4;
    public static final int TYPE_WEEK = 1;
    public static final int TYPE_YEAR = 3;
    public static final String WEEK_DATE_FORMAT = "MMM dd";
    private static final String YEAR_DATE_FORMAT = "yyyy";
    private Calendar currentDate = Calendar.getInstance();
    private SimpleDateFormat sdf;
    private int type;

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public CalendarUtils m37clone() {
        try {
            return (CalendarUtils) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public static String getCalendarFormat(Date date, String str) {
        return new SimpleDateFormat(str).format(date);
    }

    public void setCalendarType(boolean z, int i) {
        if (z) {
            this.currentDate = Calendar.getInstance();
        }
        this.type = i;
        if (i == 0) {
            this.sdf = new SimpleDateFormat(DAY_DATE_FORMAT);
            return;
        }
        if (i == 1) {
            this.sdf = new SimpleDateFormat(WEEK_DATE_FORMAT);
        } else if (i == 2) {
            this.sdf = new SimpleDateFormat(MONTH_DATE_FORMAT);
        } else {
            if (i != 3) {
                return;
            }
            this.sdf = new SimpleDateFormat(YEAR_DATE_FORMAT);
        }
    }

    public int getCalendarType() {
        return this.type;
    }

    public String getNowDayCalendarForSQL() {
        return new SimpleDateFormat(SQL_DATE_FORMAT, Locale.US).format(this.currentDate.getTime());
    }

    public String getNowWeekCalendarForSQL() {
        return CalendarWeekTitleView.getFirstDayOfWeek(this.currentDate, SQL_DATE_FORMAT) + "&" + CalendarWeekTitleView.getLastDayOfWeek(this.currentDate, SQL_DATE_FORMAT);
    }

    public String getNowMonthCalendarForSQL(Date date) {
        return new SimpleDateFormat(SQL_DATE_FORMAT, Locale.US).format(date);
    }

    public String getNowCalendar() {
        String str = this.sdf.format(this.currentDate.getTime());
        if (this.type != 1) {
            return str;
        }
        return CalendarWeekTitleView.getFirstDayOfWeek(this.currentDate, WEEK_DATE_FORMAT) + " - " + CalendarWeekTitleView.getLastDayOfWeek(this.currentDate, WEEK_DATE_FORMAT);
    }

    public String changeCalendarFormat(int i) {
        int i2 = this.type;
        int i3 = 2;
        if (i2 == 0) {
            i3 = 5;
        } else if (i2 == 1) {
            i3 = 4;
        } else if (i2 != 2) {
            if (i2 != 3) {
                return "";
            }
            i3 = 1;
        }
        this.currentDate.add(i3, i);
        return getNowCalendar();
    }

    public Calendar getCalendar() {
        return this.currentDate;
    }

    public void setCalendar(Calendar calendar) {
        this.currentDate = calendar;
    }
}
