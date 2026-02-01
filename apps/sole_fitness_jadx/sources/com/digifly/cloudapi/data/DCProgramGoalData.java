package com.digifly.cloudapi.data;

import java.util.Date;

/* loaded from: classes.dex */
public class DCProgramGoalData {
    String account;
    int account_no;
    String brand_code;
    String device_model;
    String device_os_name;
    String device_os_version;
    String device_sno;
    private float elapsedays;
    private Long goalId;
    int goal_duration;
    Date goal_end_date;
    String goal_name;
    String goal_no;
    int goal_percent;
    int goal_period_type;
    int goal_pos_in_duration;
    Date goal_start_date;
    int goal_state;
    int goal_timezone_hour;
    String goal_timezone_name;
    int goal_type;
    int goal_val;
    float goal_val_now;

    public DCProgramGoalData(Long l, String str, int i, String str2, int i2, int i3, Date date, Date date2, int i4, int i5, int i6, float f, int i7, float f2, int i8, String str3, int i9, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.account = "";
        this.goal_start_date = new Date();
        new Date();
        this.goalId = l;
        this.account = str;
        this.account_no = i;
        this.goal_name = str2;
        this.goal_duration = i2;
        this.goal_period_type = i3;
        this.goal_start_date = date;
        this.goal_end_date = date2;
        this.goal_type = i4;
        this.goal_val = i5;
        this.goal_state = i6;
        this.elapsedays = f;
        this.goal_pos_in_duration = i7;
        this.goal_val_now = f2;
        this.goal_percent = i8;
        this.goal_no = str3;
        this.goal_timezone_hour = i9;
        this.goal_timezone_name = str4;
        this.brand_code = str5;
        this.device_os_name = str6;
        this.device_os_version = str7;
        this.device_model = str8;
        this.device_sno = str9;
    }

    public DCProgramGoalData() {
        this.account = "";
        this.goal_start_date = new Date();
        this.goal_end_date = new Date();
        this.goal_no = "";
    }

    public Long getGoalId() {
        return this.goalId;
    }

    public void setGoalId(Long l) {
        this.goalId = l;
    }

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

    public int getGoal_state() {
        return this.goal_state;
    }

    public void setGoal_state(int i) {
        this.goal_state = i;
    }

    public String getGoal_name() {
        return this.goal_name;
    }

    public void setGoal_name(String str) {
        this.goal_name = str;
    }

    public int getGoal_pos_in_duration() {
        return this.goal_pos_in_duration;
    }

    public void setGoal_pos_in_duration(int i) {
        this.goal_pos_in_duration = i;
    }

    public int getGoal_duration() {
        return this.goal_duration;
    }

    public void setGoal_duration(int i) {
        this.goal_duration = i;
    }

    public int getGoal_val() {
        return this.goal_val;
    }

    public void setGoal_val(int i) {
        this.goal_val = i;
    }

    public float getGoal_val_now() {
        return this.goal_val_now;
    }

    public void setGoal_val_now(float f) {
        this.goal_val_now = f;
    }

    public int getGoal_percent() {
        return this.goal_percent;
    }

    public void setGoal_percent(int i) {
        this.goal_percent = i;
    }

    public int getGoal_period_type() {
        return this.goal_period_type;
    }

    public void setGoal_period_type(int i) {
        this.goal_period_type = i;
    }

    public int getGoal_type() {
        return this.goal_type;
    }

    public void setGoal_type(int i) {
        this.goal_type = i;
    }

    public Date getGoal_start_date() {
        return this.goal_start_date;
    }

    public void setGoal_start_date(Date date) {
        this.goal_start_date = date;
    }

    public Date getGoal_end_date() {
        return this.goal_end_date;
    }

    public void setGoal_end_date(Date date) {
        this.goal_end_date = date;
    }

    public int getGoal_timezone_hour() {
        return this.goal_timezone_hour;
    }

    public void setGoal_timezone_hour(int i) {
        this.goal_timezone_hour = i;
    }

    public String getGoal_timezone_name() {
        return this.goal_timezone_name;
    }

    public void setGoal_timezone_name(String str) {
        this.goal_timezone_name = str;
    }

    public String getBrand_code() {
        return this.brand_code;
    }

    public void setBrand_code(String str) {
        this.brand_code = str;
    }

    public String getDevice_os_name() {
        return this.device_os_name;
    }

    public void setDevice_os_name(String str) {
        this.device_os_name = str;
    }

    public String getDevice_os_version() {
        return this.device_os_version;
    }

    public void setDevice_os_version(String str) {
        this.device_os_version = str;
    }

    public String getDevice_model() {
        return this.device_model;
    }

    public void setDevice_model(String str) {
        this.device_model = str;
    }

    public String getDevice_sno() {
        return this.device_sno;
    }

    public void setDevice_sno(String str) {
        this.device_sno = str;
    }

    public String getGoal_no() {
        return this.goal_no;
    }

    public void setGoal_no(String str) {
        this.goal_no = str;
    }

    public void setElapsedays(float f) {
        this.elapsedays = f;
    }

    public float getElapsedays() {
        return this.elapsedays;
    }

    public String toString() {
        return "DCProgramGoalData{goalId=" + this.goalId + ", account='" + this.account + "', account_no=" + this.account_no + ", goal_name='" + this.goal_name + "', goal_duration=" + this.goal_duration + ", goal_period_type=" + this.goal_period_type + ", goal_start_date=" + this.goal_start_date + ", goal_end_date=" + this.goal_end_date + ", goal_type=" + this.goal_type + ", goal_val=" + this.goal_val + ", goal_state=" + this.goal_state + ", elapsedays=" + this.elapsedays + ", goal_pos_in_duration=" + this.goal_pos_in_duration + ", goal_val_now=" + this.goal_val_now + ", goal_percent=" + this.goal_percent + ", goal_no='" + this.goal_no + "', goal_timezone_hour=" + this.goal_timezone_hour + ", goal_timezone_name='" + this.goal_timezone_name + "', brand_code='" + this.brand_code + "', device_os_name='" + this.device_os_name + "', device_os_version='" + this.device_os_version + "', device_model='" + this.device_model + "', device_sno='" + this.device_sno + "'}";
    }
}
