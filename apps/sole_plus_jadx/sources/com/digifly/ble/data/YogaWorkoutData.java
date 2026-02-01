package com.digifly.ble.data;

import com.google.gson.annotations.SerializedName;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* compiled from: YogaWorkoutData.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b)\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001Bg\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000fJ\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0006HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u00101\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u00102\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u00103\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u0011Jt\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u00105J\u0013\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u00109\u001a\u00020:J\b\u0010;\u001a\u0004\u0018\u00010<J\t\u0010=\u001a\u00020\u000bHÖ\u0001J\u000e\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020<J\t\u0010A\u001a\u00020\u0006HÖ\u0001R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R \u0010\t\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R \u0010\b\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0016\"\u0004\b'\u0010\u0018R\u001e\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b(\u0010\u0011\"\u0004\b)\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001e¨\u0006B"}, d2 = {"Lcom/digifly/ble/data/YogaWorkoutData;", "", "elapsedTime", "", "totalTimeLeft", "localDateTimeStr", "", "classId", "classType", "className", "heartRate", "", "totalCalories", "", "caloriesOfSec", "(JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Double;)V", "getCaloriesOfSec", "()Ljava/lang/Double;", "setCaloriesOfSec", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "getClassId", "()Ljava/lang/String;", "setClassId", "(Ljava/lang/String;)V", "getClassName", "setClassName", "getClassType", "setClassType", "getElapsedTime", "()J", "setElapsedTime", "(J)V", "getHeartRate", "()Ljava/lang/Integer;", "setHeartRate", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getLocalDateTimeStr", "setLocalDateTimeStr", "getTotalCalories", "setTotalCalories", "getTotalTimeLeft", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Double;)Lcom/digifly/ble/data/YogaWorkoutData;", "equals", "", "other", "getDate", "Ljava/util/Date;", "getUtcDateTime", "Ljava/time/ZonedDateTime;", "hashCode", "setUtcDateTime", "", "utcZonedDateTime", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class YogaWorkoutData {
    public static final int $stable = 8;
    private Double caloriesOfSec;

    @SerializedName("class_id")
    private String classId;

    @SerializedName("class_name")
    private String className;

    @SerializedName("class_type")
    private String classType;
    private long elapsedTime;
    private Integer heartRate;
    private String localDateTimeStr;
    private Double totalCalories;
    private final long totalTimeLeft;

    /* renamed from: component1, reason: from getter */
    public final long getElapsedTime() {
        return this.elapsedTime;
    }

    /* renamed from: component2, reason: from getter */
    public final long getTotalTimeLeft() {
        return this.totalTimeLeft;
    }

    /* renamed from: component3, reason: from getter */
    public final String getLocalDateTimeStr() {
        return this.localDateTimeStr;
    }

    /* renamed from: component4, reason: from getter */
    public final String getClassId() {
        return this.classId;
    }

    /* renamed from: component5, reason: from getter */
    public final String getClassType() {
        return this.classType;
    }

    /* renamed from: component6, reason: from getter */
    public final String getClassName() {
        return this.className;
    }

    /* renamed from: component7, reason: from getter */
    public final Integer getHeartRate() {
        return this.heartRate;
    }

    /* renamed from: component8, reason: from getter */
    public final Double getTotalCalories() {
        return this.totalCalories;
    }

    /* renamed from: component9, reason: from getter */
    public final Double getCaloriesOfSec() {
        return this.caloriesOfSec;
    }

    public final YogaWorkoutData copy(long elapsedTime, long totalTimeLeft, String localDateTimeStr, String classId, String classType, String className, Integer heartRate, Double totalCalories, Double caloriesOfSec) {
        Intrinsics.checkNotNullParameter(localDateTimeStr, "localDateTimeStr");
        return new YogaWorkoutData(elapsedTime, totalTimeLeft, localDateTimeStr, classId, classType, className, heartRate, totalCalories, caloriesOfSec);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof YogaWorkoutData)) {
            return false;
        }
        YogaWorkoutData yogaWorkoutData = (YogaWorkoutData) other;
        return this.elapsedTime == yogaWorkoutData.elapsedTime && this.totalTimeLeft == yogaWorkoutData.totalTimeLeft && Intrinsics.areEqual(this.localDateTimeStr, yogaWorkoutData.localDateTimeStr) && Intrinsics.areEqual(this.classId, yogaWorkoutData.classId) && Intrinsics.areEqual(this.classType, yogaWorkoutData.classType) && Intrinsics.areEqual(this.className, yogaWorkoutData.className) && Intrinsics.areEqual(this.heartRate, yogaWorkoutData.heartRate) && Intrinsics.areEqual((Object) this.totalCalories, (Object) yogaWorkoutData.totalCalories) && Intrinsics.areEqual((Object) this.caloriesOfSec, (Object) yogaWorkoutData.caloriesOfSec);
    }

    public int hashCode() {
        int iHashCode = ((((Long.hashCode(this.elapsedTime) * 31) + Long.hashCode(this.totalTimeLeft)) * 31) + this.localDateTimeStr.hashCode()) * 31;
        String str = this.classId;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.classType;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.className;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.heartRate;
        int iHashCode5 = (iHashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        Double d = this.totalCalories;
        int iHashCode6 = (iHashCode5 + (d == null ? 0 : d.hashCode())) * 31;
        Double d2 = this.caloriesOfSec;
        return iHashCode6 + (d2 != null ? d2.hashCode() : 0);
    }

    public String toString() {
        return "YogaWorkoutData(elapsedTime=" + this.elapsedTime + ", totalTimeLeft=" + this.totalTimeLeft + ", localDateTimeStr=" + this.localDateTimeStr + ", classId=" + this.classId + ", classType=" + this.classType + ", className=" + this.className + ", heartRate=" + this.heartRate + ", totalCalories=" + this.totalCalories + ", caloriesOfSec=" + this.caloriesOfSec + ')';
    }

    public YogaWorkoutData(long j, long j2, String localDateTimeStr, String str, String str2, String str3, Integer num, Double d, Double d2) {
        Intrinsics.checkNotNullParameter(localDateTimeStr, "localDateTimeStr");
        this.elapsedTime = j;
        this.totalTimeLeft = j2;
        this.localDateTimeStr = localDateTimeStr;
        this.classId = str;
        this.classType = str2;
        this.className = str3;
        this.heartRate = num;
        this.totalCalories = d;
        this.caloriesOfSec = d2;
    }

    public final long getElapsedTime() {
        return this.elapsedTime;
    }

    public final void setElapsedTime(long j) {
        this.elapsedTime = j;
    }

    public final long getTotalTimeLeft() {
        return this.totalTimeLeft;
    }

    public /* synthetic */ YogaWorkoutData(long j, long j2, String str, String str2, String str3, String str4, Integer num, Double d, Double d2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, (i & 4) != 0 ? "" : str, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : num, (i & 128) != 0 ? null : d, (i & 256) != 0 ? null : d2);
    }

    public final String getLocalDateTimeStr() {
        return this.localDateTimeStr;
    }

    public final void setLocalDateTimeStr(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.localDateTimeStr = str;
    }

    public final String getClassId() {
        return this.classId;
    }

    public final void setClassId(String str) {
        this.classId = str;
    }

    public final String getClassType() {
        return this.classType;
    }

    public final void setClassType(String str) {
        this.classType = str;
    }

    public final String getClassName() {
        return this.className;
    }

    public final void setClassName(String str) {
        this.className = str;
    }

    public final Integer getHeartRate() {
        return this.heartRate;
    }

    public final void setHeartRate(Integer num) {
        this.heartRate = num;
    }

    public final Double getTotalCalories() {
        return this.totalCalories;
    }

    public final void setTotalCalories(Double d) {
        this.totalCalories = d;
    }

    public final Double getCaloriesOfSec() {
        return this.caloriesOfSec;
    }

    public final void setCaloriesOfSec(Double d) {
        this.caloriesOfSec = d;
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [java.time.ZonedDateTime] */
    public final void setUtcDateTime(ZonedDateTime utcZonedDateTime) {
        Intrinsics.checkNotNullParameter(utcZonedDateTime, "utcZonedDateTime");
        try {
            String str = utcZonedDateTime.withZoneSameInstant((ZoneId) ZoneOffset.UTC).format(DateTimeFormatter.ISO_ZONED_DATE_TIME.withLocale(Locale.ENGLISH));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            this.localDateTimeStr = str;
        } catch (Exception e) {
            Timber.INSTANCE.e(e);
        }
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [java.time.ZonedDateTime] */
    public final ZonedDateTime getUtcDateTime() {
        try {
            return ZonedDateTime.parse(this.localDateTimeStr, DateTimeFormatter.ISO_ZONED_DATE_TIME.withLocale(Locale.ENGLISH)).withZoneSameInstant((ZoneId) ZoneOffset.UTC);
        } catch (Exception e) {
            Timber.INSTANCE.e(e);
            return null;
        }
    }

    public final Date getDate() {
        try {
            ZonedDateTime utcDateTime = getUtcDateTime();
            Date dateFrom = utcDateTime != null ? Date.from(utcDateTime.toInstant()) : null;
            return dateFrom == null ? new Date() : dateFrom;
        } catch (Exception e) {
            Timber.INSTANCE.e(e);
            return new Date();
        }
    }
}
