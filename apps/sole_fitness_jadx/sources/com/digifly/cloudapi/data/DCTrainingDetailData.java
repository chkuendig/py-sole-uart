package com.digifly.cloudapi.data;

import java.util.Date;

/* loaded from: classes.dex */
public class DCTrainingDetailData {
    String ORG_NO;
    String account;
    int account_no;
    float d_calories;
    float d_distance;
    float d_fusion_interval_time;
    float d_fusion_recovery_time;
    String d_heart_rate_type;
    float d_hr;
    float d_incline;
    float d_level;
    float d_met;
    float d_program_height;
    float d_program_level;
    float d_program_per_step;
    float d_program_row;
    float d_program_step_height;
    float d_program_total_step;
    float d_program_vert;
    float d_rpm;
    float d_speed;
    float d_time;
    float d_watt;
    float device_gps_lat;
    float device_gps_lng;
    String password;
    String trainh_detail_no;
    String trainh_no;
    private Long trainingDetailId;
    private Long trainingId;
    Date traning_datetime;

    public DCTrainingDetailData(Long l, Long l2, String str, String str2, int i, Date date, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, String str3, String str4, String str5, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19, float f20, float f21, String str6) {
        this.trainingDetailId = l;
        this.trainingId = l2;
        this.account = str;
        this.password = str2;
        this.account_no = i;
        this.traning_datetime = date;
        this.d_time = f;
        this.d_distance = f2;
        this.d_calories = f3;
        this.d_hr = f4;
        this.d_rpm = f5;
        this.d_speed = f6;
        this.d_watt = f7;
        this.d_met = f8;
        this.d_level = f9;
        this.d_incline = f10;
        this.trainh_no = str3;
        this.trainh_detail_no = str4;
        this.d_heart_rate_type = str5;
        this.d_fusion_interval_time = f11;
        this.d_fusion_recovery_time = f12;
        this.d_program_row = f13;
        this.d_program_height = f14;
        this.d_program_level = f15;
        this.d_program_total_step = f16;
        this.d_program_per_step = f17;
        this.d_program_vert = f18;
        this.d_program_step_height = f19;
        this.device_gps_lat = f20;
        this.device_gps_lng = f21;
        this.ORG_NO = str6;
    }

    public DCTrainingDetailData() {
        this.account = "";
        this.password = "";
        this.trainh_no = "";
        this.trainh_detail_no = "";
        this.d_heart_rate_type = "";
        this.ORG_NO = "";
    }

    public String toString() {
        return "DCTrainingDetailData{trainingDetailId=" + this.trainingDetailId + ", trainingId=" + this.trainingId + ", account='" + this.account + "', password='" + this.password + "', account_no=" + this.account_no + ", traning_datetime=" + this.traning_datetime + ", d_time=" + this.d_time + ", d_distance=" + this.d_distance + ", d_calories=" + this.d_calories + ", d_hr=" + this.d_hr + ", d_rpm=" + this.d_rpm + ", d_speed=" + this.d_speed + ", d_watt=" + this.d_watt + ", d_met=" + this.d_met + ", d_level=" + this.d_level + ", d_incline=" + this.d_incline + ", trainh_no='" + this.trainh_no + "', trainh_detail_no='" + this.trainh_detail_no + "', d_heart_rate_type='" + this.d_heart_rate_type + "', d_fusion_interval_time=" + this.d_fusion_interval_time + ", d_fusion_recovery_time=" + this.d_fusion_recovery_time + ", d_program_row=" + this.d_program_row + ", d_program_height=" + this.d_program_height + ", d_program_level=" + this.d_program_level + ", d_program_total_step=" + this.d_program_total_step + ", d_program_per_step=" + this.d_program_per_step + ", d_program_vert=" + this.d_program_vert + ", d_program_step_height=" + this.d_program_step_height + ", device_gps_lat=" + this.device_gps_lat + ", device_gps_lng=" + this.device_gps_lng + ", ORG_NO='" + this.ORG_NO + "'}";
    }

    public Long getTrainingDetailId() {
        return this.trainingDetailId;
    }

    public void setTrainingDetailId(Long l) {
        this.trainingDetailId = l;
    }

    public Long getTrainingId() {
        return this.trainingId;
    }

    public void setTrainingId(Long l) {
        this.trainingId = l;
    }

    public String getAccount() {
        return this.account;
    }

    public void setAccount(String str) {
        this.account = str;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public int getAccount_no() {
        return this.account_no;
    }

    public void setAccount_no(int i) {
        this.account_no = i;
    }

    public Date getTraning_datetime() {
        return this.traning_datetime;
    }

    public void setTraning_datetime(Date date) {
        this.traning_datetime = date;
    }

    public float getD_time() {
        return this.d_time;
    }

    public void setD_time(float f) {
        this.d_time = f;
    }

    public float getD_distance() {
        return this.d_distance;
    }

    public void setD_distance(float f) {
        this.d_distance = f;
    }

    public float getD_calories() {
        return this.d_calories;
    }

    public void setD_calories(float f) {
        this.d_calories = f;
    }

    public float getD_hr() {
        return this.d_hr;
    }

    public void setD_hr(float f) {
        this.d_hr = f;
    }

    public float getD_rpm() {
        return this.d_rpm;
    }

    public void setD_rpm(float f) {
        this.d_rpm = f;
    }

    public float getD_speed() {
        return this.d_speed;
    }

    public void setD_speed(float f) {
        this.d_speed = f;
    }

    public float getD_watt() {
        return this.d_watt;
    }

    public void setD_watt(float f) {
        this.d_watt = f;
    }

    public float getD_met() {
        return this.d_met;
    }

    public void setD_met(float f) {
        this.d_met = f;
    }

    public float getD_level() {
        return this.d_level;
    }

    public void setD_level(float f) {
        this.d_level = f;
    }

    public float getD_incline() {
        return this.d_incline;
    }

    public void setD_incline(float f) {
        this.d_incline = f;
    }

    public String getTrainh_no() {
        return this.trainh_no;
    }

    public void setTrainh_no(String str) {
        this.trainh_no = str;
    }

    public String getTrainh_detail_no() {
        return this.trainh_detail_no;
    }

    public void setTrainh_detail_no(String str) {
        this.trainh_detail_no = str;
    }

    public String getD_heart_rate_type() {
        return this.d_heart_rate_type;
    }

    public void setD_heart_rate_type(String str) {
        this.d_heart_rate_type = str;
    }

    public float getD_fusion_interval_time() {
        return this.d_fusion_interval_time;
    }

    public void setD_fusion_interval_time(float f) {
        this.d_fusion_interval_time = f;
    }

    public float getD_fusion_recovery_time() {
        return this.d_fusion_recovery_time;
    }

    public void setD_fusion_recovery_time(float f) {
        this.d_fusion_recovery_time = f;
    }

    public float getD_program_row() {
        return this.d_program_row;
    }

    public void setD_program_row(float f) {
        this.d_program_row = f;
    }

    public float getD_program_height() {
        return this.d_program_height;
    }

    public void setD_program_height(float f) {
        this.d_program_height = f;
    }

    public float getD_program_level() {
        return this.d_program_level;
    }

    public void setD_program_level(float f) {
        this.d_program_level = f;
    }

    public float getD_program_total_step() {
        return this.d_program_total_step;
    }

    public void setD_program_total_step(float f) {
        this.d_program_total_step = f;
    }

    public float getD_program_per_step() {
        return this.d_program_per_step;
    }

    public void setD_program_per_step(float f) {
        this.d_program_per_step = f;
    }

    public float getD_program_vert() {
        return this.d_program_vert;
    }

    public void setD_program_vert(float f) {
        this.d_program_vert = f;
    }

    public float getD_program_step_height() {
        return this.d_program_step_height;
    }

    public void setD_program_step_height(float f) {
        this.d_program_step_height = f;
    }

    public float getDevice_gps_lat() {
        return this.device_gps_lat;
    }

    public void setDevice_gps_lat(float f) {
        this.device_gps_lat = f;
    }

    public float getDevice_gps_lng() {
        return this.device_gps_lng;
    }

    public void setDevice_gps_lng(float f) {
        this.device_gps_lng = f;
    }

    public String getORG_NO() {
        return this.ORG_NO;
    }

    public void setORG_NO(String str) {
        this.ORG_NO = str;
    }
}
