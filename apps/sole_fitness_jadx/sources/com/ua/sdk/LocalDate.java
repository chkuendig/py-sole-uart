package com.ua.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import com.dyaco.sole.custom.CalendarUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/* loaded from: classes2.dex */
public class LocalDate implements Parcelable {
    public static final int APRIL = 3;
    public static final int AUGUST = 7;
    public static final int DECEMBER = 11;
    public static final int FEBUARY = 1;
    public static final int JANUARY = 0;
    public static final int JULY = 6;
    public static final int JUNE = 5;
    public static final int MARCH = 2;
    public static final int MAY = 4;
    public static final int NOVEMBER = 10;
    public static final int OCTOBER = 9;
    public static final int SEPTEMPER = 8;
    private int dayOfMonth;
    private int month;
    private int year;
    private static final ThreadLocal<SimpleDateFormat> DATE_FORMAT = new ThreadLocal<SimpleDateFormat>() { // from class: com.ua.sdk.LocalDate.1
        @Override // java.lang.ThreadLocal
        public SimpleDateFormat get() {
            return new SimpleDateFormat(CalendarUtils.SQL_DATE_FORMAT);
        }
    };
    public static Parcelable.Creator<LocalDate> CREATOR = new Parcelable.Creator<LocalDate>() { // from class: com.ua.sdk.LocalDate.2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LocalDate createFromParcel(Parcel parcel) {
            return new LocalDate(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LocalDate[] newArray(int i) {
            return new LocalDate[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LocalDate(int i, int i2, int i3) {
        if (i2 < 0 || i2 > 11) {
            throw new IllegalArgumentException("month must be a value 0 - 11");
        }
        this.year = i;
        this.month = i2;
        this.dayOfMonth = i3;
    }

    public int getYear() {
        return this.year;
    }

    public int getMonth() {
        return this.month;
    }

    public int getDayOfMonth() {
        return this.dayOfMonth;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.year);
        parcel.writeInt(this.month);
        parcel.writeInt(this.dayOfMonth);
    }

    private LocalDate(Parcel parcel) {
        this.year = parcel.readInt();
        this.month = parcel.readInt();
        this.dayOfMonth = parcel.readInt();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(10);
        sb.append(this.year);
        sb.append('-');
        if (this.month < 9) {
            sb.append('0');
        }
        sb.append(this.month + 1);
        sb.append('-');
        if (this.dayOfMonth < 10) {
            sb.append('0');
        }
        sb.append(this.dayOfMonth);
        return sb.toString();
    }

    public static final LocalDate fromString(String str) {
        if (str == null) {
            return null;
        }
        try {
            SimpleDateFormat simpleDateFormat = DATE_FORMAT.get();
            simpleDateFormat.parse(str);
            return fromCalendar(simpleDateFormat.getCalendar());
        } catch (ParseException e) {
            UaLog.debug("Error parsing LocalDate", (Throwable) e);
            return null;
        }
    }

    public static final LocalDate fromCalendar(Calendar calendar) {
        if (calendar == null) {
            return null;
        }
        return new LocalDate(calendar.get(1), calendar.get(2), calendar.get(5));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocalDate)) {
            return false;
        }
        LocalDate localDate = (LocalDate) obj;
        return this.dayOfMonth == localDate.dayOfMonth && this.month == localDate.month && this.year == localDate.year;
    }

    public int hashCode() {
        return (((this.year * 31) + this.month) * 31) + this.dayOfMonth;
    }
}
