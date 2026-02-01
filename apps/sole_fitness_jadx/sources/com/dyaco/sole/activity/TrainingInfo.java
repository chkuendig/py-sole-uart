package com.dyaco.sole.activity;

import com.google.android.gms.maps.model.LatLng;
import java.util.LinkedList;
import java.util.List;
import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.Period;

/* loaded from: classes.dex */
public class TrainingInfo {
    private float lat;
    private float lng;
    private List<LatLng> sportPath;
    private String sportType;
    private DateTime startTime;
    private float distance = 0.0f;
    private Duration duration = new Duration(0);
    private Period pace = new Period();
    private double calorie = 0.0d;

    public DateTime getStartTime() {
        return this.startTime;
    }

    public void setStartTime(DateTime dateTime) {
        this.startTime = dateTime;
    }

    public float getDistance() {
        return this.distance;
    }

    public void setDistance(float f) {
        this.distance = f;
    }

    public Duration getDuration() {
        return this.duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public Period getPace() {
        return this.pace;
    }

    public void setPace(Period period) {
        this.pace = period;
    }

    public double getCalorie() {
        return this.calorie;
    }

    public void setCalorie(double d) {
        this.calorie = d;
    }

    public float getLat() {
        return this.lat;
    }

    public void setLat(float f) {
        this.lat = f;
    }

    public float getLng() {
        return this.lng;
    }

    public void setLng(float f) {
        this.lng = f;
    }

    public String toString() {
        return "TrainingInfo{startTime=" + this.startTime + ", distance=" + this.distance + ", duration=" + this.duration + ", pace=" + this.pace + ", calorie=" + this.calorie + ", sportType='" + this.sportType + "'}";
    }

    public TrainingInfo copy() {
        TrainingInfo trainingInfo = new TrainingInfo();
        trainingInfo.setSportType(getSportType());
        trainingInfo.setStartTime(this.startTime.plus(0L));
        trainingInfo.setDistance(this.distance);
        trainingInfo.setDuration(this.duration.plus(0L));
        trainingInfo.setPace(this.pace.plusMillis(0));
        trainingInfo.setCalorie(this.calorie);
        return trainingInfo;
    }

    public void setSportType(String str) {
        this.sportType = str;
    }

    public String getSportType() {
        return this.sportType;
    }

    public void setSportPath(LinkedList<LatLng> linkedList) {
        this.sportPath = linkedList;
    }

    public List<LatLng> getSportPath() {
        return this.sportPath;
    }
}
