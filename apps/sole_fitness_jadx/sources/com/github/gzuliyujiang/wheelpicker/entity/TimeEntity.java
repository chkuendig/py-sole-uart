package com.github.gzuliyujiang.wheelpicker.entity;

import com.facebook.internal.security.CertificateUtil;
import java.io.Serializable;
import java.util.Calendar;

/* loaded from: classes.dex */
public class TimeEntity implements Serializable {
    private int hour;
    private int minute;
    private int second;

    public static TimeEntity target(int i, int i2, int i3) {
        TimeEntity timeEntity = new TimeEntity();
        timeEntity.setHour(i);
        timeEntity.setMinute(i2);
        timeEntity.setSecond(i3);
        return timeEntity;
    }

    public static TimeEntity now() {
        Calendar calendar = Calendar.getInstance();
        return target(calendar.get(11), calendar.get(12), calendar.get(13));
    }

    public static TimeEntity minuteOnFuture(int i) {
        TimeEntity timeEntityNow = now();
        timeEntityNow.setMinute(timeEntityNow.getMinute() + i);
        return timeEntityNow;
    }

    public static TimeEntity hourOnFuture(int i) {
        TimeEntity timeEntityNow = now();
        timeEntityNow.setHour(timeEntityNow.getHour() + i);
        return timeEntityNow;
    }

    public int getHour() {
        return this.hour;
    }

    public void setHour(int i) {
        this.hour = i;
    }

    public int getMinute() {
        return this.minute;
    }

    public void setMinute(int i) {
        this.minute = i;
    }

    public int getSecond() {
        return this.second;
    }

    public void setSecond(int i) {
        this.second = i;
    }

    public long toTimeInMillis() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, this.hour);
        calendar.set(12, this.minute);
        calendar.set(13, this.second);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    public String toString() {
        return this.hour + CertificateUtil.DELIMITER + this.minute + CertificateUtil.DELIMITER + this.second;
    }
}
