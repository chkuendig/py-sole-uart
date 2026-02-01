package com.dyaco.sole;

import java.util.List;

/* loaded from: classes.dex */
public class ScheduleData {
    String alertTime;
    private List<Boolean> weekList;

    public List<Boolean> getWeekList() {
        return this.weekList;
    }

    public void setWeekList(List<Boolean> list) {
        this.weekList = list;
    }

    public String getAlertTime() {
        return this.alertTime;
    }

    public void setAlertTime(String str) {
        this.alertTime = str;
    }

    public String toString() {
        return "ScheduleData{alertTime='" + this.alertTime + "', weekList=" + this.weekList + '}';
    }
}
