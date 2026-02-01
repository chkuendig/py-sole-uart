package com.digifly.cloudapi.data;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class BaseWebApiData {
    private String sys_response_data;
    private SysResponseMessageBean sys_response_message;

    public static BaseWebApiData objectFromData(String str) {
        return (BaseWebApiData) new Gson().fromJson(str, BaseWebApiData.class);
    }

    public static BaseWebApiData objectFromData(String str, String str2) {
        try {
            return (BaseWebApiData) new Gson().fromJson(new JSONObject(str).getString(str), BaseWebApiData.class);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<BaseWebApiData> arrayBaseWebApiDataFromData(String str) {
        return (List) new Gson().fromJson(str, new TypeToken<ArrayList<BaseWebApiData>>() { // from class: com.digifly.cloudapi.data.BaseWebApiData.1
        }.getType());
    }

    public static List<BaseWebApiData> arrayBaseWebApiDataFromData(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return (List) new Gson().fromJson(jSONObject.getString(str), new TypeToken<ArrayList<BaseWebApiData>>() { // from class: com.digifly.cloudapi.data.BaseWebApiData.2
            }.getType());
        } catch (JSONException e) {
            e.printStackTrace();
            return new ArrayList();
        }
    }

    public SysResponseMessageBean getSys_response_message() {
        return this.sys_response_message;
    }

    public void setSys_response_message(SysResponseMessageBean sysResponseMessageBean) {
        this.sys_response_message = sysResponseMessageBean;
    }

    public String getSys_response_data() {
        return this.sys_response_data;
    }

    public void setSys_response_data(String str) {
        this.sys_response_data = str;
    }

    public static class SysResponseMessageBean {
        private String code;
        private String message;

        public static SysResponseMessageBean objectFromData(String str) {
            return (SysResponseMessageBean) new Gson().fromJson(str, SysResponseMessageBean.class);
        }

        public static SysResponseMessageBean objectFromData(String str, String str2) {
            try {
                return (SysResponseMessageBean) new Gson().fromJson(new JSONObject(str).getString(str), SysResponseMessageBean.class);
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }

        public static List<SysResponseMessageBean> arraySysResponseMessageBeanFromData(String str) {
            return (List) new Gson().fromJson(str, new TypeToken<ArrayList<SysResponseMessageBean>>() { // from class: com.digifly.cloudapi.data.BaseWebApiData.SysResponseMessageBean.1
            }.getType());
        }

        public static List<SysResponseMessageBean> arraySysResponseMessageBeanFromData(String str, String str2) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                return (List) new Gson().fromJson(jSONObject.getString(str), new TypeToken<ArrayList<SysResponseMessageBean>>() { // from class: com.digifly.cloudapi.data.BaseWebApiData.SysResponseMessageBean.2
                }.getType());
            } catch (JSONException e) {
                e.printStackTrace();
                return new ArrayList();
            }
        }

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
    }
}
