package com.soletreadmills.sole_v2._tools;

import android.content.Context;
import android.text.TextUtils;
import com.blankj.utilcode.constant.TimeConstants;
import com.soletreadmills.sole_v2.AppConfig;
import com.soletreadmills.sole_v2.R;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes5.dex */
public class CalendarTool {
    public static String getTime() {
        return new SimpleDateFormat(AppConfig.PATTERN_DATE_TIME, Locale.ENGLISH).format(new Date(System.currentTimeMillis()));
    }

    public static String getToday01() {
        return new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(new Date(System.currentTimeMillis()));
    }

    public static String getToday02() {
        return new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH).format(new Date(System.currentTimeMillis()));
    }

    public static String getTimeZone() {
        return TimeZone.getDefault().getDisplayName(false, 0);
    }

    public static String getTimeZoneId() {
        return TimeZone.getDefault().getID();
    }

    public static int getTimeZoneRawOffsetHour() {
        return TimeZone.getDefault().getRawOffset() / TimeConstants.HOUR;
    }

    public static Date getLastMonthDay(Calendar calendar) {
        calendar.set(5, calendar.getActualMaximum(5));
        return calendar.getTime();
    }

    public static int getWeekCalendarToInt(Calendar calendar) {
        return calendar.get(7) - 1;
    }

    public static Date getThisWeekMonday(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.setFirstDayOfWeek(2);
        calendar.add(5, calendar.getFirstDayOfWeek() - calendar.get(7));
        return calendar.getTime();
    }

    public static Date getThisWeekSunday(Date date) {
        Date thisWeekMonday = getThisWeekMonday(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(thisWeekMonday);
        calendar.add(5, 6);
        return calendar.getTime();
    }

    public static String getCalendarToTimeStr01(Calendar calendar) {
        return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.ENGLISH).format(calendar.getTime());
    }

    public static String getDateToTimeStr01(Date date) {
        return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.ENGLISH).format(date);
    }

    public static String getCalendarToTimeStr02(Calendar calendar) {
        return new SimpleDateFormat("yyyy/MM/dd HH:mm", Locale.ENGLISH).format(calendar.getTime());
    }

    public static String getDateToTimeStr02(Date date) {
        return new SimpleDateFormat("yyyy/MM/dd HH:mm", Locale.ENGLISH).format(date);
    }

    public static String getCalendarToTimeStr03(Calendar calendar) {
        return new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH).format(calendar.getTime());
    }

    public static String getDateToTimeStr03(Date date) {
        return new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH).format(date);
    }

    public static String getCalendarToTimeStr04(Calendar calendar) {
        return new SimpleDateFormat("HH:mm", Locale.ENGLISH).format(calendar.getTime());
    }

    public static String getDateToTimeStr04(Date date) {
        return new SimpleDateFormat("HH:mm", Locale.ENGLISH).format(date);
    }

    public static String getCalendarToDateStr01(Calendar calendar) {
        return new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(calendar.getTime());
    }

    public static String getDateToDateStr01(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(date);
    }

    public static String getCalendarToDateStr02(Calendar calendar) {
        return new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH).format(calendar.getTime());
    }

    public static String getDateToDateStr02(Date date) {
        return new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH).format(date);
    }

    public static String getCalendarToDateStr03(Calendar calendar) {
        return new SimpleDateFormat("yyyy", Locale.ENGLISH).format(calendar.getTime());
    }

    public static String getDateToDateStr03(Date date) {
        return new SimpleDateFormat("yyyy", Locale.ENGLISH).format(date);
    }

    public static String getCalendarToDateStr04(Calendar calendar) {
        return new SimpleDateFormat("MM/dd", Locale.ENGLISH).format(calendar.getTime());
    }

    public static String getDateToDateStr04(Date date) {
        return new SimpleDateFormat("MM/dd", Locale.ENGLISH).format(date);
    }

    public static String getCalendarToDateStr05(Calendar calendar) {
        return new SimpleDateFormat("MM", Locale.ENGLISH).format(calendar.getTime());
    }

    public static String getDateToDateStr05(Date date) {
        return new SimpleDateFormat("MM", Locale.ENGLISH).format(date);
    }

    public static String getCalendarToDateStr06(Calendar calendar) {
        return new SimpleDateFormat("dd", Locale.ENGLISH).format(calendar.getTime());
    }

    public static String getDateToDateStr06(Date date) {
        return new SimpleDateFormat("dd", Locale.ENGLISH).format(date);
    }

    public static String getCalendarToDateStr07(Calendar calendar) {
        return new SimpleDateFormat("yyyy/MM", Locale.ENGLISH).format(calendar.getTime());
    }

    public static String getDateToDateStr07(Date date) {
        return new SimpleDateFormat("yyyy/MM", Locale.ENGLISH).format(date);
    }

    public static String getCalendarToDateStr08(Calendar calendar) {
        return new SimpleDateFormat("MMM d, yyyy", Locale.ENGLISH).format(calendar.getTime());
    }

    public static String getDateToDateStr08(Date date) {
        return new SimpleDateFormat("MMM d, yyyy", Locale.ENGLISH).format(date);
    }

    public static String getCalendarToDateStr09(Calendar calendar) {
        return new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).format(calendar.getTime());
    }

    public static String getDateToDateStr09(Date date) {
        return new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).format(date);
    }

    public static String getCalendarToDateStr10(Calendar calendar) {
        return new SimpleDateFormat("EEEE hh:mm aa", Locale.ENGLISH).format(calendar.getTime());
    }

    public static String getDateToDateStr10(Date date) {
        return new SimpleDateFormat("EEEE\t\t\thh:mm aa", Locale.ENGLISH).format(date);
    }

    public static String getDateToDateStr10DefaultLocale(Date date) {
        return new SimpleDateFormat("EEEE\t\t\thh:mm aa", Locale.getDefault()).format(date);
    }

    public static String getCalendarToDateStr11(Calendar calendar) {
        return new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH).format(calendar.getTime());
    }

    public static String getDateToDateStr11(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
        if (date == null) {
            return "";
        }
        return simpleDateFormat.format(date);
    }

    public static String getCalendarToDateStr12(Calendar calendar) {
        return new SimpleDateFormat(AppConfig.PATTERN_DATE_TIME, Locale.ENGLISH).format(calendar.getTime());
    }

    public static String getDateToDateStr12(Date date) {
        return new SimpleDateFormat(AppConfig.PATTERN_DATE_TIME, Locale.ENGLISH).format(date);
    }

    public static String getCalendarToDateStr13(Calendar calendar) {
        return new SimpleDateFormat("MMM", Locale.ENGLISH).format(calendar.getTime());
    }

    public static String getDateToDateStr13(Date date) {
        return new SimpleDateFormat("MMM", Locale.ENGLISH).format(date);
    }

    public static int getAgeForBirthday(Calendar birthday) {
        Calendar calendar = Calendar.getInstance();
        int i = calendar.get(1) - birthday.get(1);
        if (calendar.get(2) == birthday.get(2)) {
            if (calendar.get(5) < birthday.get(5)) {
                return i;
            }
        } else if (calendar.get(2) <= birthday.get(2)) {
            return i;
        }
        return i + 1;
    }

    public static Date transformStrToDate(String dateStr) {
        Date date = null;
        if (TextUtils.isEmpty(dateStr)) {
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(AppConfig.PATTERN_DATE_TIME, Locale.ENGLISH);
        if (dateStr.contains(" ")) {
            try {
                date = simpleDateFormat.parse(dateStr);
            } catch (ParseException unused) {
            }
        }
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.ENGLISH);
        if (dateStr.contains(" ") && date == null) {
            try {
                date = simpleDateFormat2.parse(dateStr);
            } catch (ParseException unused2) {
            }
        }
        SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        if (date == null) {
            try {
                date = simpleDateFormat3.parse(dateStr);
            } catch (ParseException unused3) {
            }
        }
        SimpleDateFormat simpleDateFormat4 = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH);
        if (date != null) {
            return date;
        }
        try {
            return simpleDateFormat4.parse(dateStr);
        } catch (ParseException unused4) {
            return date;
        }
    }

    public static String getMonthText(int value, Context context) {
        if (value < 1 || value > 12) {
            return null;
        }
        switch (value) {
            case 1:
                return context.getString(R.string.january);
            case 2:
                return context.getString(R.string.february);
            case 3:
                return context.getString(R.string.march);
            case 4:
                return context.getString(R.string.april);
            case 5:
                return context.getString(R.string.may);
            case 6:
                return context.getString(R.string.june);
            case 7:
                return context.getString(R.string.july);
            case 8:
                return context.getString(R.string.august);
            case 9:
                return context.getString(R.string.september);
            case 10:
                return context.getString(R.string.october);
            case 11:
                return context.getString(R.string.november);
            case 12:
                return context.getString(R.string.december);
            default:
                return null;
        }
    }
}
