package com.digifly.data;

import com.google.gson.Gson;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class MemberData2 {
    private SysResponseDataBean sys_response_data;
    private SysResponseMessageBean sys_response_message;

    public static MemberData2 objectFromData(String str) {
        return (MemberData2) new Gson().fromJson(str, MemberData2.class);
    }

    public static MemberData2 objectFromData(String str, String str2) {
        try {
            return (MemberData2) new Gson().fromJson(new JSONObject(str).getString(str), MemberData2.class);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public SysResponseMessageBean getSys_response_message() {
        return this.sys_response_message;
    }

    public void setSys_response_message(SysResponseMessageBean sysResponseMessageBean) {
        this.sys_response_message = sysResponseMessageBean;
    }

    public SysResponseDataBean getSys_response_data() {
        return this.sys_response_data;
    }

    public void setSys_response_data(SysResponseDataBean sysResponseDataBean) {
        this.sys_response_data = sysResponseDataBean;
    }

    public static class SysResponseMessageBean {
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
    }

    public static class SysResponseDataBean {
        private String ORG_NO;
        private String account;
        private String account_no;
        private String api_token;
        private String app_brand;
        private Object authority;
        private String birthday;
        private String device_id;
        private String edm_favorite_brand;
        private String email;
        private String head_photo;
        private String head_photo_url;
        private String height;
        private boolean is_new_account;
        private String isadmin;
        private String lang_code;
        private String name;
        private String password;
        private String regist_type;
        private String sex;
        private List<SyncDeviceListBean> sync_device_list;
        private String synce_password;
        private String unit_type;
        private String user_access_token;
        private String weight;

        public String getAccount_no() {
            return this.account_no;
        }

        public void setAccount_no(String str) {
            this.account_no = str;
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

        public String getHeight() {
            return this.height;
        }

        public void setHeight(String str) {
            this.height = str;
        }

        public String getWeight() {
            return this.weight;
        }

        public void setWeight(String str) {
            this.weight = str;
        }

        public String getBirthday() {
            return this.birthday;
        }

        public void setBirthday(String str) {
            this.birthday = str;
        }

        public boolean isIs_new_account() {
            return this.is_new_account;
        }

        public void setIs_new_account(boolean z) {
            this.is_new_account = z;
        }

        public String getIsadmin() {
            return this.isadmin;
        }

        public void setIsadmin(String str) {
            this.isadmin = str;
        }

        public Object getAuthority() {
            return this.authority;
        }

        public void setAuthority(Object obj) {
            this.authority = obj;
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

        public String getLang_code() {
            return this.lang_code;
        }

        public void setLang_code(String str) {
            this.lang_code = str;
        }

        public String getEdm_favorite_brand() {
            return this.edm_favorite_brand;
        }

        public void setEdm_favorite_brand(String str) {
            this.edm_favorite_brand = str;
        }

        public String getDevice_id() {
            return this.device_id;
        }

        public void setDevice_id(String str) {
            this.device_id = str;
        }

        public String getApp_brand() {
            return this.app_brand;
        }

        public void setApp_brand(String str) {
            this.app_brand = str;
        }

        public String getORG_NO() {
            return this.ORG_NO;
        }

        public void setORG_NO(String str) {
            this.ORG_NO = str;
        }

        public String getApi_token() {
            return this.api_token;
        }

        public void setApi_token(String str) {
            this.api_token = str;
        }

        public String getSynce_password() {
            return this.synce_password;
        }

        public void setSynce_password(String str) {
            this.synce_password = str;
        }

        public List<SyncDeviceListBean> getSync_device_list() {
            return this.sync_device_list;
        }

        public void setSync_device_list(List<SyncDeviceListBean> list) {
            this.sync_device_list = list;
        }

        public String getHead_photo() {
            return this.head_photo;
        }

        public void setHead_photo(String str) {
            this.head_photo = str;
        }

        public String getHead_photo_url() {
            return this.head_photo_url;
        }

        public void setHead_photo_url(String str) {
            this.head_photo_url = str;
        }

        public String getUser_access_token() {
            return this.user_access_token;
        }

        public void setUser_access_token(String str) {
            this.user_access_token = str;
        }

        public static class SyncDeviceListBean {
            private String device_no;

            public String getDevice_no() {
                return this.device_no;
            }

            public void setDevice_no(String str) {
                this.device_no = str;
            }
        }
    }
}
