package com.dyaco.sole;

import android.util.Log;
import com.google.gson.annotations.Expose;
import java.util.ArrayList;
import java.util.List;
import org.joda.time.DateTime;
import org.joda.time.LocalTime;
import org.joda.time.MutableDateTime;
import org.joda.time.format.DateTimeFormat;

/* loaded from: classes.dex */
public class AlertSchedule {
    private static final int WEEK_SIZE = 7;

    @Expose
    private LocalTime alertLocalTime;
    private List<DateTime> scheduleDateTimeList;

    @Expose
    private List<Boolean> weekList = new ArrayList();

    public AlertSchedule() {
        for (int i = 0; i < Week.values().length; i++) {
            this.weekList.add(i, false);
        }
        this.scheduleDateTimeList = new ArrayList();
    }

    public void setWeek(Week week, boolean z) {
        Log.d("ddd", String.valueOf(week.ordinal()));
        this.weekList.set(week.ordinal(), Boolean.valueOf(z));
    }

    public void setTime(LocalTime localTime) {
        this.alertLocalTime = localTime;
    }

    public LocalTime getAlertLocalTime() {
        return this.alertLocalTime;
    }

    public String toString() {
        return "AlertSchedule{alertLocalTime=" + this.alertLocalTime + ", weekList=" + this.weekList + '}';
    }

    public void generateScheduleDateTime() {
        generateScheduleDateTime(new DateTime(), 1);
    }

    public void generateScheduleDateTime(DateTime dateTime, int i) {
        initScheduleDateTime();
        int i2 = i * 7;
        MutableDateTime mutableDateTime = dateTime.toMutableDateTime();
        MutableDateTime mutableDateTime2 = dateTime.toMutableDateTime();
        mutableDateTime2.setTime(this.alertLocalTime.getMillisOfDay());
        for (int i3 = 0; i3 < i2; i3++) {
            if (this.weekList.get(mutableDateTime2.getDayOfWeek() - 1).booleanValue()) {
                Log.d("ddd", "startDateTime:" + mutableDateTime);
                Log.d("ddd", "alertDateTime:" + mutableDateTime2);
                if (i3 == 0 && mutableDateTime.isAfter(mutableDateTime2)) {
                    Log.d("ddd ggg", "startDateTime:" + mutableDateTime);
                    Log.d("ddd ggg", "alertDateTime:" + mutableDateTime2);
                    mutableDateTime2.addDays(1);
                } else {
                    this.scheduleDateTimeList.add(mutableDateTime2.toDateTime());
                    mutableDateTime2.addDays(1);
                }
            } else {
                mutableDateTime2.addDays(1);
            }
        }
    }

    private void initScheduleDateTime() {
        this.scheduleDateTimeList.clear();
    }

    public List<DateTime> getScheduleDateTimeList() {
        return this.scheduleDateTimeList;
    }

    public ScheduleData getScheduleData() {
        ScheduleData scheduleData = new ScheduleData();
        scheduleData.setAlertTime(this.alertLocalTime.toString("HH:mm:ss"));
        scheduleData.setWeekList(this.weekList);
        return scheduleData;
    }

    public void setScheduleData(ScheduleData scheduleData) {
        this.alertLocalTime = LocalTime.parse(scheduleData.getAlertTime(), DateTimeFormat.forPattern("HH:mm:ss"));
        this.weekList = scheduleData.getWeekList();
    }
}
