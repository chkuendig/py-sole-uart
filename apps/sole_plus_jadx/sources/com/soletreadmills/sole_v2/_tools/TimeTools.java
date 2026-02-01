package com.soletreadmills.sole_v2._tools;

import android.content.Context;
import android.text.format.DateFormat;
import android.util.Log;
import com.android.SdkConstants;
import com.blankj.utilcode.constant.CacheConstants;
import com.blankj.utilcode.constant.TimeConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.soletreadmills.sole_v2.AppConfig;
import com.soletreadmills.sole_v2.R;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import timber.log.Timber;

/* compiled from: TimeTools.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006J\u001f\u0010\f\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0013J)\u0010\u0014\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0017J\u000e\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\tJ\u000e\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\tJ\u000e\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0006J\u0016\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001fJ\u0010\u0010!\u001a\u00020\u00062\b\u0010\"\u001a\u0004\u0018\u00010\u0006J\u0018\u0010#\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\t2\b\b\u0002\u0010%\u001a\u00020\u0006J\u0016\u0010&\u001a\u00020\u00062\u0006\u0010'\u001a\u00020(2\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010)\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tJ\u0015\u0010*\u001a\u00020\u00062\b\u0010+\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010,J\u0015\u0010-\u001a\u00020\u00062\b\u0010+\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010,J\u0010\u0010.\u001a\u00020\u00062\b\u0010\"\u001a\u0004\u0018\u00010\u0006J\u0010\u0010/\u001a\u0004\u0018\u00010\u00062\u0006\u00100\u001a\u00020\u0006J\u0010\u00101\u001a\u00020\u00062\b\u0010\"\u001a\u0004\u0018\u00010\u0006J\u0010\u00102\u001a\u00020\u00062\b\u0010\"\u001a\u0004\u0018\u00010\u0006J\u0010\u00103\u001a\u00020\u00062\b\u0010\"\u001a\u0004\u0018\u00010\u0006J\u0015\u00104\u001a\u00020\u00062\b\u0010$\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u00105J\u000e\u00106\u001a\u0002072\u0006\u0010'\u001a\u00020(J\u0010\u00108\u001a\u00020\u00062\u0006\u0010'\u001a\u00020(H\u0002J\u0016\u00109\u001a\u00020\t2\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020;J\u0006\u0010=\u001a\u00020\u0006J\u0016\u0010>\u001a\u00020\u000f2\u0006\u0010?\u001a\u00020\u00062\u0006\u0010@\u001a\u00020\u0006J\u0010\u0010A\u001a\u00020\u00062\b\u0010\"\u001a\u0004\u0018\u00010\u0006J\u0018\u0010B\u001a\u00020\u00062\u0006\u0010C\u001a\u00020\t2\b\b\u0002\u0010D\u001a\u00020\u000fJ\u0018\u0010E\u001a\u00020\u00062\u0006\u0010C\u001a\u00020\t2\b\b\u0002\u0010D\u001a\u00020\u000fJ\u000e\u0010F\u001a\u00020\u00062\u0006\u0010C\u001a\u00020\tJ\u0016\u0010G\u001a\u00020\u00062\u0006\u0010'\u001a\u00020(2\u0006\u0010H\u001a\u00020\u0006J\u000e\u0010I\u001a\u00020\u00062\u0006\u0010J\u001a\u00020\t¨\u0006K"}, d2 = {"Lcom/soletreadmills/sole_v2/_tools/TimeTools;", "", "()V", "calculateTimeZoneOffsetMillis", "", "originalTimeZoneId", "", "targetTimeZoneId", "startTimeMillis", "", "convertDateISOToDisplayFormat", "isoDate", "convertDateISOToTimestamp", "dateString", "isAdjustSameTimezone", "", "(Ljava/lang/String;Z)Ljava/lang/Long;", "convertOffsetMillisToHours", "offsetMillis", "", "convertStringDateToTimestamp", "stringTime", "formatter", "(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/Long;", "convertTimestampToStringDate", SDKConstants.PARAM_DEBUG_MESSAGE_TIMESTAMP, "convertTimestampToStringDateISO", "convertUtcToLocalDateOnly", "utcString", "differentDaysByMillisecond", "date1", "Ljava/util/Date;", "date2", "formatDate", "input", "formatDateTime", "timeMillis", "pattern", "formatOffsetTime", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "formatOffsetTime02", "formatTime", "duration", "(Ljava/lang/Integer;)Ljava/lang/String;", "formatTime02", "formatToTime02", "formatToTime03", "inputDate", "formatToTime04", "formatToTime05", "formatToTime06", "formatToTimeByTimeMillis05", "(Ljava/lang/Long;)Ljava/lang/String;", "getLocalizedDateFormatter", "Ljava/time/format/DateTimeFormatter;", "getLocalizedDateFormatterPattern", "getMinutes", "first", "Ljava/time/ZonedDateTime;", "second", "getNowDateTime", "isFirstDateEarly", "startDate", "endDate", "parseLocalizedDateToYMD", "secToTime", "timeSec", "isHourDisplay", "secToTime02", "secToTime03", "toDisplayDate", "dateTimeString", "unitFormat", "i", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TimeTools {
    public static final int $stable = 0;
    public static final TimeTools INSTANCE = new TimeTools();

    public final double convertOffsetMillisToHours(int offsetMillis) {
        double d = 60;
        return ((offsetMillis / 1000.0d) / d) / d;
    }

    private TimeTools() {
    }

    public static /* synthetic */ String secToTime$default(TimeTools timeTools, long j, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return timeTools.secToTime(j, z);
    }

    public final synchronized String secToTime(long timeSec, boolean isHourDisplay) {
        String str;
        String str2;
        if (timeSec <= 0) {
            if (isHourDisplay) {
                str2 = "00:00:00";
            } else {
                str2 = "00:00";
            }
            return str2;
        }
        long j = 60;
        long j2 = timeSec / j;
        if (j2 < 60) {
            long j3 = timeSec % j;
            if (isHourDisplay) {
                str = "00:" + unitFormat(j2) + ':' + unitFormat(j3);
            } else {
                str = "" + unitFormat(j2) + ':' + unitFormat(j3);
            }
        } else {
            long j4 = j2 / j;
            long j5 = j2 % j;
            str = unitFormat(j4) + ':' + unitFormat(j5) + ':' + unitFormat((timeSec - (CacheConstants.HOUR * j4)) - (j * j5));
        }
        return str;
    }

    public static /* synthetic */ String secToTime02$default(TimeTools timeTools, long j, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return timeTools.secToTime02(j, z);
    }

    public final synchronized String secToTime02(long timeSec, boolean isHourDisplay) {
        String str;
        String str2;
        if (timeSec <= 0) {
            if (isHourDisplay) {
                str2 = "0:00:00";
            } else {
                str2 = "0:00";
            }
            return str2;
        }
        long j = 60;
        long j2 = timeSec / j;
        if (j2 < 60) {
            long j3 = timeSec % j;
            if (isHourDisplay) {
                str = "0:" + unitFormat(j2) + ':' + unitFormat(j3);
            } else {
                str = "" + j2 + ':' + unitFormat(j3);
            }
        } else {
            long j4 = j2 / j;
            long j5 = j2 % j;
            str = j4 + ':' + unitFormat(j5) + ':' + unitFormat((timeSec - (CacheConstants.HOUR * j4)) - (j * j5));
        }
        return str;
    }

    public final synchronized String secToTime03(long timeSec) {
        String str;
        if (timeSec <= 0) {
            str = "0:00";
        } else {
            long j = 60;
            str = "" + (timeSec / j) + ':' + unitFormat(timeSec % j);
        }
        return str;
    }

    public final String formatTime(Integer duration) {
        int i;
        int i2;
        if (duration == null) {
            return "0";
        }
        int iIntValue = duration.intValue();
        int i3 = 0;
        if (iIntValue > 60) {
            i = iIntValue / 60;
            int i4 = iIntValue % 60;
        } else {
            i = 0;
        }
        if (i > 60) {
            i2 = i / 60;
            i %= 60;
        } else {
            i2 = 0;
        }
        if (i2 > 24) {
            i3 = i2 / 24;
            i2 %= 24;
        }
        if (i3 != 0) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format(Locale.US, "%sd%sh%sm", Arrays.copyOf(new Object[]{Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(i)}, 3));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            return str;
        }
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        String str2 = String.format(Locale.US, "%sh%smin", Arrays.copyOf(new Object[]{Integer.valueOf(i2), Integer.valueOf(i)}, 2));
        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
        return str2;
    }

    public final String formatTime02(Integer duration) {
        if (duration == null) {
            return "00:00";
        }
        int iIntValue = duration.intValue() / 60;
        int iIntValue2 = duration.intValue() % 60;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(Locale.US, "%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(iIntValue), Integer.valueOf(iIntValue2)}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public final synchronized String unitFormat(long i) {
        return ((0 > i || i >= 10) ? new StringBuilder("").append(i) : new StringBuilder("0").append(i)).toString();
    }

    public final String getNowDateTime() {
        String str = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public final int differentDaysByMillisecond(Date date1, Date date2) {
        Intrinsics.checkNotNullParameter(date1, "date1");
        Intrinsics.checkNotNullParameter(date2, "date2");
        return (int) ((date2.getTime() - date1.getTime()) / TimeConstants.DAY);
    }

    public final long getMinutes(ZonedDateTime first, ZonedDateTime second) {
        Intrinsics.checkNotNullParameter(first, "first");
        Intrinsics.checkNotNullParameter(second, "second");
        long j = 60;
        return (second.toInstant().getEpochSecond() / j) - (first.toInstant().getEpochSecond() / j);
    }

    public final String formatDate(String input) {
        String str = input;
        if (str == null || str.length() == 0) {
            return SdkConstants.RES_QUALIFIER_SEP;
        }
        DateTimeFormatter dateTimeFormatterOfPattern = DateTimeFormatter.ofPattern(AppConfig.PATTERN_DATE_TIME, Locale.ENGLISH);
        String str2 = LocalDateTime.parse(str, dateTimeFormatterOfPattern).format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(Locale.getDefault()));
        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
        return str2;
    }

    public final String formatToTime02(String input) {
        String str = input;
        if (str == null || str.length() == 0) {
            return SdkConstants.RES_QUALIFIER_SEP;
        }
        DateTimeFormatter dateTimeFormatterOfPattern = DateTimeFormatter.ofPattern(AppConfig.PATTERN_DATE_TIME, Locale.ENGLISH);
        String str2 = LocalDateTime.parse(str, dateTimeFormatterOfPattern).format(DateTimeFormatter.ofPattern("hh:mm a", Locale.ENGLISH));
        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
        return str2;
    }

    public final String formatToTime03(String inputDate) {
        Intrinsics.checkNotNullParameter(inputDate, "inputDate");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy", Locale.US);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("MMM dd, yyyy", Locale.US);
        try {
            Date date = simpleDateFormat.parse(inputDate);
            Intrinsics.checkNotNull(date);
            return simpleDateFormat2.format(date);
        } catch (Exception unused) {
            return null;
        }
    }

    public final String formatToTime04(String input) {
        String str = input;
        if (str == null || str.length() == 0) {
            return SdkConstants.RES_QUALIFIER_SEP;
        }
        DateTimeFormatter dateTimeFormatterOfPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
        String str2 = LocalDate.parse(str, dateTimeFormatterOfPattern).format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(Locale.getDefault()));
        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
        return str2;
    }

    public final String formatToTime05(String input) {
        String str = input;
        if (str == null || str.length() == 0) {
            return SdkConstants.RES_QUALIFIER_SEP;
        }
        DateTimeFormatter dateTimeFormatterOfPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
        String str2 = LocalDate.parse(str, dateTimeFormatterOfPattern).format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(Locale.getDefault()));
        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
        return str2;
    }

    public final String formatToTimeByTimeMillis05(Long timeMillis) {
        if (timeMillis == null || timeMillis.longValue() <= 0) {
            return SdkConstants.RES_QUALIFIER_SEP;
        }
        try {
            String str = Instant.ofEpochMilli(timeMillis.longValue()).atZone(ZoneId.systemDefault()).toLocalDate().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(Locale.getDefault()));
            Intrinsics.checkNotNull(str);
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return SdkConstants.RES_QUALIFIER_SEP;
        }
    }

    public final String formatToTime06(String input) {
        String str = input;
        if (str == null || str.length() == 0) {
            return SdkConstants.RES_QUALIFIER_SEP;
        }
        DateTimeFormatter dateTimeFormatterOfPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
        String str2 = LocalDate.parse(str, dateTimeFormatterOfPattern).format(DateTimeFormatter.ofPattern("MM/dd", Locale.ENGLISH));
        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
        return str2;
    }

    public static /* synthetic */ String formatDateTime$default(TimeTools timeTools, long j, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "MMM d yyyy";
        }
        return timeTools.formatDateTime(j, str);
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [java.time.LocalDateTime] */
    public final String formatDateTime(long timeMillis, String pattern) {
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        try {
            String str = Instant.ofEpochMilli(timeMillis).atZone(ZoneId.systemDefault()).toLocalDateTime().format(DateTimeFormatter.ofPattern(pattern, Locale.ENGLISH));
            Intrinsics.checkNotNull(str);
            return str;
        } catch (Exception unused) {
            return "-:-";
        }
    }

    public final String convertTimestampToStringDateISO(long timestamp) {
        String str = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(Long.valueOf(timestamp));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public static /* synthetic */ Long convertDateISOToTimestamp$default(TimeTools timeTools, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return timeTools.convertDateISOToTimestamp(str, z);
    }

    public final Long convertDateISOToTimestamp(String dateString, boolean isAdjustSameTimezone) {
        Intrinsics.checkNotNullParameter(dateString, "dateString");
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            if (isAdjustSameTimezone) {
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            }
            Date date = simpleDateFormat.parse(dateString);
            if (date != null) {
                return Long.valueOf(date.getTime());
            }
            return null;
        } catch (Exception e) {
            Timber.INSTANCE.e(e, "Parse error for ISO date=" + dateString, new Object[0]);
            return null;
        }
    }

    public final String convertTimestampToStringDate(long timestamp) {
        String str = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).format(Long.valueOf(timestamp));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public static /* synthetic */ Long convertStringDateToTimestamp$default(TimeTools timeTools, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "dd/MM/yyyy";
        }
        if ((i & 4) != 0) {
            z = false;
        }
        return timeTools.convertStringDateToTimestamp(str, str2, z);
    }

    public final Long convertStringDateToTimestamp(String stringTime, String formatter, boolean isAdjustSameTimezone) {
        Intrinsics.checkNotNullParameter(stringTime, "stringTime");
        Intrinsics.checkNotNullParameter(formatter, "formatter");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatter, Locale.ENGLISH);
        if (isAdjustSameTimezone) {
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        }
        try {
            Date date = simpleDateFormat.parse(stringTime);
            if (date != null) {
                return Long.valueOf(date.getTime());
            }
            return null;
        } catch (Exception unused) {
            Timber.INSTANCE.d("Stack: " + Log.getStackTraceString(new Throwable()), new Object[0]);
            Timber.INSTANCE.d("stringTime: " + stringTime, new Object[0]);
            Timber.INSTANCE.d("formatter: " + formatter, new Object[0]);
            return null;
        }
    }

    public final String convertDateISOToDisplayFormat(String isoDate) {
        Intrinsics.checkNotNullParameter(isoDate, "isoDate");
        try {
            String str = LocalDate.parse(isoDate, DateTimeFormatter.ofPattern("yyyy-MM-dd")).format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(Locale.getDefault()));
            Intrinsics.checkNotNull(str);
            return str;
        } catch (Exception e) {
            Timber.INSTANCE.e("Date conversion error: " + e.getMessage(), new Object[0]);
            return isoDate;
        }
    }

    public final boolean isFirstDateEarly(String startDate, String endDate) {
        Intrinsics.checkNotNullParameter(startDate, "startDate");
        Intrinsics.checkNotNullParameter(endDate, "endDate");
        Long lConvertStringDateToTimestamp$default = convertStringDateToTimestamp$default(this, startDate, null, false, 6, null);
        Long lConvertStringDateToTimestamp$default2 = convertStringDateToTimestamp$default(this, endDate, null, false, 6, null);
        if (lConvertStringDateToTimestamp$default == null || lConvertStringDateToTimestamp$default2 == null) {
            return false;
        }
        return Instant.ofEpochMilli(lConvertStringDateToTimestamp$default.longValue()).isBefore(Instant.ofEpochMilli(lConvertStringDateToTimestamp$default2.longValue()));
    }

    public final double calculateTimeZoneOffsetMillis(String originalTimeZoneId, String targetTimeZoneId, long startTimeMillis) {
        Intrinsics.checkNotNullParameter(originalTimeZoneId, "originalTimeZoneId");
        Intrinsics.checkNotNullParameter(targetTimeZoneId, "targetTimeZoneId");
        TimeZone timeZone = TimeZone.getTimeZone(originalTimeZoneId);
        TimeZone timeZone2 = TimeZone.getTimeZone(targetTimeZoneId);
        return convertOffsetMillisToHours(timeZone2.getOffset(startTimeMillis) - timeZone.getOffset(startTimeMillis));
    }

    public final String formatOffsetTime(Context context, long startTimeMillis) {
        Intrinsics.checkNotNullParameter(context, "context");
        String string = context.getString(R.string.locale_code);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        if (Intrinsics.areEqual(string, "zh_tw")) {
            string = "zh-Hant-TW";
        } else if (Intrinsics.areEqual(string, "zh_cn")) {
            string = "zh-Hans-CN";
        }
        String str = DateTimeFormatter.ofPattern("h:mm a, " + getLocalizedDateFormatterPattern(context), Locale.forLanguageTag(string)).format(Instant.ofEpochMilli(startTimeMillis).atZone(ZoneId.systemDefault()).toLocalDateTime());
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public final DateTimeFormatter getLocalizedDateFormatter(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String string = context.getString(R.string.locale_code);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        if (Intrinsics.areEqual(string, "zh_tw")) {
            string = "zh-Hant-TW";
        } else if (Intrinsics.areEqual(string, "zh_cn")) {
            string = "zh-Hans-CN";
        }
        DateTimeFormatter dateTimeFormatterOfPattern = DateTimeFormatter.ofPattern(getLocalizedDateFormatterPattern(context), Locale.forLanguageTag(string));
        Intrinsics.checkNotNullExpressionValue(dateTimeFormatterOfPattern, "ofPattern(...)");
        return dateTimeFormatterOfPattern;
    }

    private final String getLocalizedDateFormatterPattern(Context context) {
        String string = context.getString(R.string.locale_code);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        int iHashCode = string.hashCode();
        if (iHashCode != 3201) {
            if (iHashCode != 3246) {
                if (iHashCode != 3276) {
                    if (iHashCode != 3383) {
                        if (iHashCode != 3651) {
                            if (iHashCode != 115862300) {
                                if (iHashCode == 115862836 && string.equals("zh_tw")) {
                                    return "yyyy年M月d日";
                                }
                            } else if (string.equals("zh_cn")) {
                                return "yyyy年M月d日";
                            }
                        } else if (string.equals("ru")) {
                            return "d MMM yyyy 'г.'";
                        }
                    } else if (string.equals("ja")) {
                        return "yyyy年M月d日";
                    }
                } else if (string.equals("fr")) {
                    return "d MMM yyyy";
                }
            } else if (string.equals("es")) {
                return "d MMM yyyy";
            }
        } else if (string.equals("de")) {
            return "dd.MM.yyyy";
        }
        return "MMM d, yyyy";
    }

    public final String formatOffsetTime02(long startTimeMillis) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("h:mm a", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getDefault());
        String str = simpleDateFormat.format(new Date(startTimeMillis));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public final String toDisplayDate(Context context, String dateTimeString) {
        String string;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dateTimeString, "dateTimeString");
        try {
            Date date = new SimpleDateFormat(AppConfig.PATTERN_DATE_TIME, Locale.getDefault()).parse(dateTimeString);
            if (date == null) {
                return dateTimeString;
            }
            Date date2 = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date2);
            calendar.set(11, 0);
            calendar.set(12, 0);
            calendar.set(13, 0);
            calendar.set(14, 0);
            Date time = calendar.getTime();
            calendar.add(5, -1);
            Date time2 = calendar.getTime();
            if (date.getTime() >= time.getTime()) {
                string = context.getString(R.string.today);
            } else if (date.getTime() >= time2.getTime()) {
                string = context.getString(R.string.yesterday);
            } else {
                Locale locale = Locale.getDefault();
                string = new SimpleDateFormat(DateFormat.getBestDateTimePattern(locale, "MMMd"), locale).format(date);
            }
            Intrinsics.checkNotNull(string);
            return string;
        } catch (Exception unused) {
            return dateTimeString;
        }
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [java.time.ZonedDateTime] */
    public final String convertUtcToLocalDateOnly(String utcString) {
        Intrinsics.checkNotNullParameter(utcString, "utcString");
        String str = DateTimeFormatter.ofPattern("MM/dd/yyyy").format(LocalDateTime.parse(utcString, DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm")).atZone(ZoneId.of("UTC")).withZoneSameInstant(ZoneId.systemDefault()));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public final String parseLocalizedDateToYMD(String input) {
        String str = input;
        if (str == null || str.length() == 0) {
            return SdkConstants.RES_QUALIFIER_SEP;
        }
        try {
            String str2 = input;
            String str3 = LocalDate.parse(str2, DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(Locale.getDefault())).format(DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH));
            Intrinsics.checkNotNull(str3);
            return str3;
        } catch (Exception unused) {
            return SdkConstants.RES_QUALIFIER_SEP;
        }
    }
}
