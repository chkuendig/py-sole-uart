package com.digifly.cloudapi.data;

/* loaded from: classes.dex */
public class DCConnectInfoData {
    private String brand_type;
    int connect_timezone_hour;
    float device_gps_lat;
    float device_gps_lng;
    String account = "";
    String password = "";
    String connect_time = "";
    String connect_timezone_name = "";
    String brand_code = "";
    String model_code = "";
    String category_code = "";
    String mac_address = "";
    String sales_version = "";
    String unit = "";
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

    public String getConnect_time() {
        return this.connect_time;
    }

    public void setConnect_time(String str) {
        this.connect_time = str;
    }

    public int getConnect_timezone_hour() {
        return this.connect_timezone_hour;
    }

    public void setConnect_timezone_hour(int i) {
        this.connect_timezone_hour = i;
    }

    public String getBrand_type() {
        return this.brand_type;
    }

    public void setBrand_type(String str) {
        this.brand_type = str;
    }

    public String getConnect_timezone_name() {
        return this.connect_timezone_name;
    }

    public void setConnect_timezone_name(String str) {
        this.connect_timezone_name = str;
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

    public String getMac_address() {
        return this.mac_address;
    }

    public void setMac_address(String str) {
        this.mac_address = str;
    }

    public String getSales_version() {
        return this.sales_version;
    }

    public void setSales_version(String str) {
        this.sales_version = str;
    }

    public String getUnit() {
        return this.unit;
    }

    public void setUnit(String str) {
        this.unit = str;
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
        return "DCConnectInfoData{account='" + this.account + "', password='" + this.password + "', connect_time='" + this.connect_time + "', connect_timezone_hour=" + this.connect_timezone_hour + ", connect_timezone_name='" + this.connect_timezone_name + "', brand_code='" + this.brand_code + "', model_code='" + this.model_code + "', category_code='" + this.category_code + "', mac_address='" + this.mac_address + "', sales_version='" + this.sales_version + "', unit='" + this.unit + "', device_os_name='" + this.device_os_name + "', device_os_version='" + this.device_os_version + "', device_model='" + this.device_model + "', device_sno='" + this.device_sno + "', device_gps_lat=" + this.device_gps_lat + ", device_gps_lng=" + this.device_gps_lng + '}';
    }
}
