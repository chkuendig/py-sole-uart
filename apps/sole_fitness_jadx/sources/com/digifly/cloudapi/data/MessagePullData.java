package com.digifly.cloudapi.data;

/* loaded from: classes.dex */
public class MessagePullData {
    private String c_date;
    private String message_no;
    private String umsg_content;
    private int umsg_isread;
    private String umsg_subject;

    public String getC_date() {
        return this.c_date;
    }

    public void setC_date(String str) {
        this.c_date = str;
    }

    public String getUmsg_subject() {
        return this.umsg_subject;
    }

    public void setUmsg_subject(String str) {
        this.umsg_subject = str;
    }

    public String getUmsg_content() {
        return this.umsg_content;
    }

    public void setUmsg_content(String str) {
        this.umsg_content = str;
    }

    public int getUmsg_isread() {
        return this.umsg_isread;
    }

    public void setUmsg_isread(int i) {
        this.umsg_isread = i;
    }

    public String getMessage_no() {
        return this.message_no;
    }

    public void setMessage_no(String str) {
        this.message_no = str;
    }
}
