package com.dyaco.sole.database;

import android.util.Log;

/* loaded from: classes.dex */
public class UserData {
    public static final String AGE = "age";
    public static final String GENDER = "gender";
    public static final String GOALS = "goals";
    public static final String NAME = "name";
    public static final String NOTES = "notes";
    public static final String TAG = "UserData";
    public static final String USER_TB_NAME = "user";
    public static final String WEIGHT = "weight";
    private int age;
    private int gender;
    private String goals;
    private String name;
    private String notes;
    private int weight;

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int i) {
        this.age = i;
    }

    public int getWeight() {
        Log.d(TAG, "getWeight()  this.weight : " + this.weight);
        return this.weight;
    }

    public void setWeight(int i) {
        Log.d(TAG, "setWeight()  weight : " + i);
        this.weight = i;
        Log.d(TAG, "setWeight()  this.weight : " + this.weight);
    }

    public int getGender() {
        return this.gender;
    }

    public void setGender(int i) {
        this.gender = i;
    }

    public String getGoals() {
        return this.goals;
    }

    public void setGoals(String str) {
        this.goals = str;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String str) {
        this.notes = str;
    }
}
