package com.digifly.cloudapi.data;

import com.facebook.appevents.AppEventsConstants;

/* loaded from: classes.dex */
public class MemberData {
    String ORG_NO;
    String account;
    private int account_no;
    String birthday;
    String email;
    int height;
    private Long memberId;
    String name;
    String password;
    String regist_type;
    String sex;
    String unit_type;
    int weight;

    public MemberData() {
        this.account = "";
        this.password = "";
        this.name = "";
        this.email = "";
        this.sex = "";
        this.birthday = "";
        this.regist_type = "";
        this.unit_type = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        this.ORG_NO = "";
    }

    public MemberData(Long l, String str, String str2, int i, String str3, String str4, String str5, int i2, int i3, String str6, String str7, String str8, String str9) {
        this.memberId = l;
        this.account = str;
        this.password = str2;
        this.account_no = i;
        this.name = str3;
        this.email = str4;
        this.sex = str5;
        this.height = i2;
        this.weight = i3;
        this.birthday = str6;
        this.regist_type = str7;
        this.unit_type = str8;
        this.ORG_NO = str9;
    }

    public int getAccount_no() {
        return this.account_no;
    }

    public void setAccount_no(int i) {
        this.account_no = i;
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

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public String getSex() {
        return this.sex;
    }

    public void setSex(String str) {
        this.sex = str;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int getWeight() {
        return this.weight;
    }

    public void setWeight(int i) {
        this.weight = i;
    }

    public String getBirthday() {
        return this.birthday;
    }

    public void setBirthday(String str) {
        this.birthday = str;
    }

    public String getRegist_type() {
        return this.regist_type;
    }

    public void setRegist_type(String str) {
        this.regist_type = str;
    }

    public String getUnit_type() {
        return this.unit_type;
    }

    public void setUnit_type(String str) {
        this.unit_type = str;
    }

    public String getORG_NO() {
        return this.ORG_NO;
    }

    public void setORG_NO(String str) {
        this.ORG_NO = str;
    }

    public String toString() {
        return "MemberData{memberId=" + this.memberId + ", account='" + this.account + "', password='" + this.password + "', account_no=" + this.account_no + ", name='" + this.name + "', email='" + this.email + "', sex='" + this.sex + "', height=" + this.height + ", weight=" + this.weight + ", birthday='" + this.birthday + "', regist_type='" + this.regist_type + "', unit_type='" + this.unit_type + "', ORG_NO='" + this.ORG_NO + "'}";
    }

    public Long getMemberId() {
        return this.memberId;
    }

    public void setMemberId(Long l) {
        this.memberId = l;
    }
}
