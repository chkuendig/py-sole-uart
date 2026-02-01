package com.digifly.cloudapi.data;

import java.util.List;

/* loaded from: classes.dex */
public class ResponseMessagePush {
    private static final String LOGIN_FAILED = "-1";
    private static final String LOGIN_SUCCESS = "1";
    List<MessagePullData> sys_response_data;
    ResponseMessage sys_response_message;

    public ResponseMessage getSys_response_message() {
        return this.sys_response_message;
    }

    public void setSys_response_message(ResponseMessage responseMessage) {
        this.sys_response_message = responseMessage;
    }

    public List<MessagePullData> getSys_response_data() {
        return this.sys_response_data;
    }

    public void setSys_response_data(List<MessagePullData> list) {
        this.sys_response_data = list;
    }

    public String toString() {
        return "ResponseDataGet{sys_response_message=" + this.sys_response_message + ", sys_response_data=" + this.sys_response_data + '}';
    }

    public boolean isSuccess() {
        return this.sys_response_message.getCode().equals("1");
    }
}
