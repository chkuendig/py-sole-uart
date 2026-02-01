package com.digifly.cloudapi.data;

/* loaded from: classes.dex */
public class ResponseMessage {
    private String code;
    private String message;

    public String getCode() {
        return this.code;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String toString() {
        return "ResponseMessage{code='" + this.code + "', message='" + this.message + "'}";
    }
}
