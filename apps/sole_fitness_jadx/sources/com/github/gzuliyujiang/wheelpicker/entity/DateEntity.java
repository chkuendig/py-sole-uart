package com.github.gzuliyujiang.wheelpicker.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import org.apache.commons.cli.HelpFormatter;

/* loaded from: classes.dex */
public class DateEntity implements Serializable {
    private int day;
    private int month;
    private int year;

    public static DateEntity target(int i, int i2, int i3) {
        DateEntity dateEntity = new DateEntity();
        dateEntity.setYear(i);
        dateEntity.setMonth(i2);
        dateEntity.setDay(i3);
        return dateEntity;
    }

    public static DateEntity today() {
        Calendar calendar = Calendar.getInstance();
        return target(calendar.get(1), calendar.get(2) + 1, calendar.get(5));
    }

    public static DateEntity dayOnFuture(int i) {
        DateEntity dateEntity = today();
        dateEntity.setDay(dateEntity.getDay() + i);
        return dateEntity;
    }

    public static DateEntity monthOnFuture(int i) {
        DateEntity dateEntity = today();
        dateEntity.setMonth(dateEntity.getMonth() + i);
        return dateEntity;
    }

    public static DateEntity yearOnFuture(int i) {
        DateEntity dateEntity = today();
        dateEntity.setYear(dateEntity.getYear() + i);
        return dateEntity;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int i) {
        this.year = i;
    }

    public int getMonth() {
        return this.month;
    }

    public void setMonth(int i) {
        this.month = i;
    }

    public int getDay() {
        return this.day;
    }

    public void setDay(int i) {
        this.day = i;
    }

    public long toTimeInMillis() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, this.year);
        calendar.set(2, this.month - 1);
        calendar.set(5, this.day);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DateEntity dateEntity = (DateEntity) obj;
        return this.year == dateEntity.year && this.month == dateEntity.month && this.day == dateEntity.day;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.year), Integer.valueOf(this.month), Integer.valueOf(this.day));
    }

    public String toString() {
        return this.year + HelpFormatter.DEFAULT_OPT_PREFIX + this.month + HelpFormatter.DEFAULT_OPT_PREFIX + this.day;
    }
}
