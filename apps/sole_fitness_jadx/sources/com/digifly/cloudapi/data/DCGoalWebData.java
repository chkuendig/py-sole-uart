package com.digifly.cloudapi.data;

import java.util.Date;

/* loaded from: classes.dex */
public class DCGoalWebData {
    int account_no;
    int goal_duration;
    int goal_duration_range;
    private float goal_finish_day;
    float goal_finish_value;
    String goal_name;
    int goal_staturs;
    int goal_type;
    int goal_type_value;
    String account = "";
    Date goal_starttime = new Date();
    Date goal_endtime = new Date();
    String goal_no = "";

    public String getAccount() {
        return this.account;
    }

    public void setAccount(String str) {
        this.account = str;
    }

    public int getAccount_no() {
        return this.account_no;
    }

    public void setAccount_no(int i) {
        this.account_no = i;
    }

    public String getGoal_name() {
        return this.goal_name;
    }

    public void setGoal_name(String str) {
        this.goal_name = str;
    }

    public int getGoal_duration() {
        return this.goal_duration;
    }

    public void setGoal_duration(int i) {
        this.goal_duration = i;
    }

    public int getGoal_duration_range() {
        return this.goal_duration_range;
    }

    public void setGoal_duration_range(int i) {
        this.goal_duration_range = i;
    }

    public Date getGoal_starttime() {
        return this.goal_starttime;
    }

    public void setGoal_starttime(Date date) {
        this.goal_starttime = date;
    }

    public Date getGoal_endtime() {
        return this.goal_endtime;
    }

    public void setGoal_endtime(Date date) {
        this.goal_endtime = date;
    }

    public int getGoal_type() {
        return this.goal_type;
    }

    public void setGoal_type(int i) {
        this.goal_type = i;
    }

    public int getGoal_type_value() {
        return this.goal_type_value;
    }

    public void setGoal_type_value(int i) {
        this.goal_type_value = i;
    }

    public int getGoal_staturs() {
        return this.goal_staturs;
    }

    public void setGoal_staturs(int i) {
        this.goal_staturs = i;
    }

    public float getGoal_finish_day() {
        return this.goal_finish_day;
    }

    public void setGoal_finish_day(float f) {
        this.goal_finish_day = f;
    }

    public float getGoal_finish_value() {
        return this.goal_finish_value;
    }

    public void setGoal_finish_value(float f) {
        this.goal_finish_value = f;
    }

    public String getGoal_no() {
        return this.goal_no;
    }

    public void setGoal_no(String str) {
        this.goal_no = str;
    }

    public String toString() {
        return "DCGoalWebData{account='" + this.account + "', account_no=" + this.account_no + ", goal_name='" + this.goal_name + "', goal_duration=" + this.goal_duration + ", goal_duration_range=" + this.goal_duration_range + ", goal_starttime=" + this.goal_starttime + ", goal_endtime=" + this.goal_endtime + ", goal_type=" + this.goal_type + ", goal_type_value=" + this.goal_type_value + ", goal_staturs=" + this.goal_staturs + ", goal_finish_day=" + this.goal_finish_day + ", goal_finish_value=" + this.goal_finish_value + ", goal_no='" + this.goal_no + "'}";
    }
}
