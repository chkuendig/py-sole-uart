package com.dyaco.ideabussdk_sole.protocol;

/* loaded from: classes.dex */
public class EndWorkoutData {
    float calories;
    float distance;
    String getnum;
    int heart_rate;
    int incline;
    int level;
    float mets;
    int rpm;
    int seconds;
    float speed;
    int watt;

    public void setGetnum(String str) {
        this.getnum = str;
    }

    public String getGetnum() {
        return this.getnum;
    }

    public void setSeconds(int i) {
        this.seconds = i;
    }

    public int getSeconds() {
        return this.seconds;
    }

    public void setDistance(float f) {
        this.distance = f;
    }

    public float getDistance() {
        return this.distance;
    }

    public void setCalories(float f) {
        this.calories = f;
    }

    public float getCalories() {
        return this.calories;
    }

    public void setHeartRate(int i) {
        this.heart_rate = i;
    }

    public int getHeartRate() {
        return this.heart_rate;
    }

    public void setRpm(int i) {
        this.rpm = i;
    }

    public int getRpm() {
        return this.rpm;
    }

    public void setSpeed(float f) {
        this.speed = f;
    }

    public float getSpeed() {
        return this.speed;
    }

    public void setWatt(int i) {
        this.watt = i;
    }

    public int getWatt() {
        return this.watt;
    }

    public void setMets(float f) {
        this.mets = f;
    }

    public float getMets() {
        return this.mets;
    }

    public void setLevel(int i) {
        this.level = i;
    }

    public int getLevel() {
        return this.level;
    }

    public void setIncline(int i) {
        this.incline = i;
    }

    public int getIncline() {
        return this.incline;
    }

    public String toString() {
        return "EndWorkoutData{seconds=" + this.seconds + ", distance=" + this.distance + ", calories=" + this.calories + ", heart_rate=" + this.heart_rate + ", rpm=" + this.rpm + ", speed=" + this.speed + ", watt=" + this.watt + ", mets=" + this.mets + ", level=" + this.level + ", incline=" + this.incline + '}';
    }
}
