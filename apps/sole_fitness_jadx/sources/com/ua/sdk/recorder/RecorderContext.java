package com.ua.sdk.recorder;

import android.content.Context;
import com.ua.sdk.activitytype.ActivityType;
import com.ua.sdk.heartrate.HeartRateZones;
import com.ua.sdk.user.User;

/* loaded from: classes2.dex */
public class RecorderContext {
    private ActivityType activityType;
    private Context applicationContext;
    private RecorderClock clock;
    private HeartRateZones heartRateZones;
    private String name;
    private User user;

    public Context getApplicationContext() {
        return this.applicationContext;
    }

    public void setApplicationContext(Context context) {
        this.applicationContext = context;
    }

    public RecorderClock getClock() {
        return this.clock;
    }

    public void setClock(RecorderClock recorderClock) {
        this.clock = recorderClock;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ActivityType getActivityType() {
        return this.activityType;
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }

    public HeartRateZones getHeartRateZones() {
        return this.heartRateZones;
    }

    public void setHeartRateZones(HeartRateZones heartRateZones) {
        this.heartRateZones = heartRateZones;
    }
}
