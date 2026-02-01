package com.digifly.cloudapi.data;

import com.facebook.appevents.AppEventsConstants;
import java.util.Date;

/* loaded from: classes.dex */
public class DCTrainingData {
    String ORG_NO;
    String account;
    int account_no;
    float avg_hr;
    float avg_incline;
    float avg_level;
    float avg_met;
    float avg_rpm;
    float avg_speed;
    float avg_watt;
    String brand_code;
    String brand_type;
    String category_code;
    float device_gps_lat;
    float device_gps_lng;
    String device_model;
    String device_os_name;
    String device_os_version;
    String device_sno;
    private String goals;
    String in_out;
    String mac_address;
    String model_code;
    private String notes;
    String password;
    int programNameRes;
    String program_name;
    String sales_version;
    String sportPathJsonStr;
    float total_calories;
    float total_distance;
    float total_time;
    String trainh_no;
    private Long trainingId;
    Date training_datetime;
    int training_timezone_hour;
    String training_timezone_name;
    String unit;

    public DCTrainingData(Long l, String str, String str2, int i, int i2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, Date date, String str11, int i3, String str12, String str13, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, String str14, String str15, String str16, String str17, String str18, float f11, float f12, String str19, String str20) {
        this.account = "";
        this.password = "";
        this.training_timezone_name = "";
        this.brand_code = "";
        this.model_code = "";
        this.category_code = "";
        this.brand_type = "";
        this.in_out = "";
        this.unit = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        this.sales_version = "";
        new Date();
        this.ORG_NO = "";
        this.trainingId = l;
        this.account = str;
        this.password = str2;
        this.account_no = i;
        this.training_timezone_hour = i2;
        this.training_timezone_name = str3;
        this.brand_code = str4;
        this.model_code = str5;
        this.category_code = str6;
        this.brand_type = str7;
        this.in_out = str8;
        this.unit = str9;
        this.sales_version = str10;
        this.training_datetime = date;
        this.program_name = str11;
        this.programNameRes = i3;
        this.goals = str12;
        this.notes = str13;
        this.total_time = f;
        this.total_distance = f2;
        this.total_calories = f3;
        this.avg_hr = f4;
        this.avg_rpm = f5;
        this.avg_speed = f6;
        this.avg_watt = f7;
        this.avg_met = f8;
        this.avg_level = f9;
        this.avg_incline = f10;
        this.trainh_no = str14;
        this.device_os_name = str15;
        this.device_os_version = str16;
        this.device_model = str17;
        this.device_sno = str18;
        this.device_gps_lat = f11;
        this.device_gps_lng = f12;
        this.mac_address = str19;
        this.sportPathJsonStr = str20;
    }

    public DCTrainingData() {
        this.account = "";
        this.password = "";
        this.training_timezone_name = "";
        this.brand_code = "";
        this.model_code = "";
        this.category_code = "";
        this.brand_type = "";
        this.in_out = "";
        this.unit = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        this.sales_version = "";
        this.training_datetime = new Date();
        this.program_name = "";
        this.goals = "";
        this.notes = "";
        this.trainh_no = "";
        this.device_os_name = "";
        this.device_os_version = "";
        this.device_model = "";
        this.device_sno = "";
        this.mac_address = "";
        this.sportPathJsonStr = "";
        this.ORG_NO = "";
    }

    public String toString() {
        return "DCTrainingData{trainingId=" + this.trainingId + ", account='" + this.account + "', password='" + this.password + "', account_no=" + this.account_no + ", training_timezone_hour=" + this.training_timezone_hour + ", training_timezone_name='" + this.training_timezone_name + "', brand_code='" + this.brand_code + "', model_code='" + this.model_code + "', category_code='" + this.category_code + "', brand_type='" + this.brand_type + "', in_out='" + this.in_out + "', unit='" + this.unit + "', sales_version='" + this.sales_version + "', training_datetime=" + this.training_datetime + ", program_name='" + this.program_name + "', programNameRes=" + this.programNameRes + ", goals='" + this.goals + "', notes='" + this.notes + "', total_time=" + this.total_time + ", total_distance=" + this.total_distance + ", total_calories=" + this.total_calories + ", avg_hr=" + this.avg_hr + ", avg_rpm=" + this.avg_rpm + ", avg_speed=" + this.avg_speed + ", avg_watt=" + this.avg_watt + ", avg_met=" + this.avg_met + ", avg_level=" + this.avg_level + ", avg_incline=" + this.avg_incline + ", trainh_no='" + this.trainh_no + "', device_os_name='" + this.device_os_name + "', device_os_version='" + this.device_os_version + "', device_model='" + this.device_model + "', device_sno='" + this.device_sno + "', device_gps_lat=" + this.device_gps_lat + ", device_gps_lng=" + this.device_gps_lng + ", mac_address='" + this.mac_address + "', ORG_NO='" + this.ORG_NO + "'}";
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

    public int getTraining_timezone_hour() {
        return this.training_timezone_hour;
    }

    public void setTraining_timezone_hour(int i) {
        this.training_timezone_hour = i;
    }

    public String getTraining_timezone_name() {
        return this.training_timezone_name;
    }

    public void setTraining_timezone_name(String str) {
        this.training_timezone_name = str;
    }

    public String getBrand_code() {
        return this.brand_code;
    }

    public void setBrand_code(String str) {
        this.brand_code = str;
    }

    public String getModel_code() {
        return this.model_code;
    }

    public void setModel_code(String str) {
        this.model_code = str;
    }

    public String getCategory_code() {
        return this.category_code;
    }

    public void setCategory_code(String str) {
        this.category_code = str;
    }

    public String getBrand_type() {
        return this.brand_type;
    }

    public void setBrand_type(String str) {
        this.brand_type = str;
    }

    public String getIn_out() {
        return this.in_out;
    }

    public void setIn_out(String str) {
        this.in_out = str;
    }

    public String getUnit() {
        return this.unit;
    }

    public void setUnit(String str) {
        this.unit = str;
    }

    public String getSales_version() {
        return this.sales_version;
    }

    public void setSales_version(String str) {
        this.sales_version = str;
    }

    public Date getTraining_datetime() {
        return this.training_datetime;
    }

    public void setTraining_datetime(Date date) {
        this.training_datetime = date;
    }

    public String getProgram_name() {
        return this.program_name;
    }

    public void setProgram_name(String str) {
        this.program_name = str;
    }

    public int getProgramNameRes() {
        return this.programNameRes;
    }

    public void setProgramNameRes(int i) {
        this.programNameRes = i;
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

    public float getTotal_time() {
        return this.total_time;
    }

    public void setTotal_time(float f) {
        this.total_time = f;
    }

    public float getTotal_distance() {
        return this.total_distance;
    }

    public void setTotal_distance(float f) {
        this.total_distance = f;
    }

    public float getTotal_calories() {
        return this.total_calories;
    }

    public void setTotal_calories(float f) {
        this.total_calories = f;
    }

    public float getAvg_hr() {
        return this.avg_hr;
    }

    public void setAvg_hr(float f) {
        this.avg_hr = f;
    }

    public float getAvg_rpm() {
        return this.avg_rpm;
    }

    public void setAvg_rpm(float f) {
        this.avg_rpm = f;
    }

    public float getAvg_speed() {
        return this.avg_speed;
    }

    public void setAvg_speed(float f) {
        this.avg_speed = f;
    }

    public float getAvg_watt() {
        return this.avg_watt;
    }

    public void setAvg_watt(float f) {
        this.avg_watt = f;
    }

    public float getAvg_met() {
        return this.avg_met;
    }

    public void setAvg_met(float f) {
        this.avg_met = f;
    }

    public float getAvg_level() {
        return this.avg_level;
    }

    public void setAvg_level(float f) {
        this.avg_level = f;
    }

    public float getAvg_incline() {
        return this.avg_incline;
    }

    public void setAvg_incline(float f) {
        this.avg_incline = f;
    }

    public String getTrainh_no() {
        return this.trainh_no;
    }

    public void setTrainh_no(String str) {
        this.trainh_no = str;
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

    public String getMac_address() {
        return this.mac_address;
    }

    public void setMac_address(String str) {
        this.mac_address = str;
    }

    public String getSportPathJsonStr() {
        return this.sportPathJsonStr;
    }

    public void setSportPathJsonStr(String str) {
        this.sportPathJsonStr = str;
    }
}
