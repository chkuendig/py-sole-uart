package com.digifly.cloudapi.data;

/* loaded from: classes.dex */
public class DCLoginInfoData {
    float device_gps_lat;
    float device_gps_lng;
    private Long loginId;
    int login_timezone_hour;
    String account = "";
    String password = "";
    String login_model_code = "";
    String login_time = "";
    String login_timezone_name = "";
    String device_os_name = "";
    String device_os_version = "";
    String device_model = "";
    String device_sno = "";

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

    public String getLogin_model_code() {
        return this.login_model_code;
    }

    public void setLogin_model_code(String str) {
        this.login_model_code = str;
    }

    public String getLogin_time() {
        return this.login_time;
    }

    public void setLogin_time(String str) {
        this.login_time = str;
    }

    public int getLogin_timezone_hour() {
        return this.login_timezone_hour;
    }

    public void setLogin_timezone_hour(int i) {
        this.login_timezone_hour = i;
    }

    public String getLogin_timezone_name() {
        return this.login_timezone_name;
    }

    public void setLogin_timezone_name(String str) {
        this.login_timezone_name = str;
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

    public String toString() {
        return "DCLoginInfoData{account='" + this.account + "', password='" + this.password + "', login_model_code='" + this.login_model_code + "', login_time='" + this.login_time + "', login_timezone_hour=" + this.login_timezone_hour + ", login_timezone_name='" + this.login_timezone_name + "', device_os_name='" + this.device_os_name + "', device_os_version='" + this.device_os_version + "', device_model='" + this.device_model + "', device_sno='" + this.device_sno + "', device_gps_lat=" + this.device_gps_lat + ", device_gps_lng=" + this.device_gps_lng + '}';
    }

    public Long getLoginId() {
        return this.loginId;
    }

    public void setLoginId(Long l) {
        this.loginId = l;
    }
}
