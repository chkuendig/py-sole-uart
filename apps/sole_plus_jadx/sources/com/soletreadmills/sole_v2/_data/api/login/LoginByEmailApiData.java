package com.soletreadmills.sole_v2._data.api.login;

import com.google.gson.annotations.SerializedName;
import com.soletreadmills.sole_v2._data._base.WebApiBaseData;
import com.soletreadmills.sole_v2._data.login.LoginUserData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LoginByEmailApiData.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0006"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/login/LoginByEmailApiData;", "", "()V", com.google.android.gms.wearable.DataMap.TAG, "RequestBodyData", "ResponseData", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LoginByEmailApiData {
    public static final int $stable = 0;

    /* compiled from: LoginByEmailApiData.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/login/LoginByEmailApiData$RequestBodyData;", "", "email", "", "password", "pushToken", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEmail", "()Ljava/lang/String;", "setEmail", "(Ljava/lang/String;)V", "getPassword", "setPassword", "getPushToken", "setPushToken", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class RequestBodyData {
        public static final int $stable = 8;

        @SerializedName("email")
        private String email;

        @SerializedName("password")
        private String password;

        @SerializedName("pushToken")
        private String pushToken;

        public RequestBodyData(String email, String password, String pushToken) {
            Intrinsics.checkNotNullParameter(email, "email");
            Intrinsics.checkNotNullParameter(password, "password");
            Intrinsics.checkNotNullParameter(pushToken, "pushToken");
            this.email = email;
            this.password = password;
            this.pushToken = pushToken;
        }

        public final String getEmail() {
            return this.email;
        }

        public final void setEmail(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.email = str;
        }

        public final String getPassword() {
            return this.password;
        }

        public final void setPassword(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.password = str;
        }

        public final String getPushToken() {
            return this.pushToken;
        }

        public final void setPushToken(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.pushToken = str;
        }
    }

    /* compiled from: LoginByEmailApiData.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/login/LoginByEmailApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/_base/WebApiBaseData;", "()V", "dataMap", "Lcom/soletreadmills/sole_v2/_data/api/login/LoginByEmailApiData$DataMap;", "getDataMap", "()Lcom/soletreadmills/sole_v2/_data/api/login/LoginByEmailApiData$DataMap;", "setDataMap", "(Lcom/soletreadmills/sole_v2/_data/api/login/LoginByEmailApiData$DataMap;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ResponseData extends WebApiBaseData {
        public static final int $stable = 8;

        @SerializedName("dataMap")
        private DataMap dataMap;

        public final DataMap getDataMap() {
            return this.dataMap;
        }

        public final void setDataMap(DataMap dataMap) {
            this.dataMap = dataMap;
        }
    }

    /* compiled from: LoginByEmailApiData.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J-\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/login/LoginByEmailApiData$DataMap;", "", "data", "Lcom/soletreadmills/sole_v2/_data/login/LoginUserData;", "loginToken", "", "serviceLoginToken", "(Lcom/soletreadmills/sole_v2/_data/login/LoginUserData;Ljava/lang/String;Ljava/lang/String;)V", "getData", "()Lcom/soletreadmills/sole_v2/_data/login/LoginUserData;", "getLoginToken", "()Ljava/lang/String;", "getServiceLoginToken", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class DataMap {
        public static final int $stable = 8;

        @SerializedName("data")
        private final LoginUserData data;

        @SerializedName("loginToken")
        private final String loginToken;

        @SerializedName("serviceLoginToken")
        private final String serviceLoginToken;

        public DataMap() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ DataMap copy$default(DataMap dataMap, LoginUserData loginUserData, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                loginUserData = dataMap.data;
            }
            if ((i & 2) != 0) {
                str = dataMap.loginToken;
            }
            if ((i & 4) != 0) {
                str2 = dataMap.serviceLoginToken;
            }
            return dataMap.copy(loginUserData, str, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final LoginUserData getData() {
            return this.data;
        }

        /* renamed from: component2, reason: from getter */
        public final String getLoginToken() {
            return this.loginToken;
        }

        /* renamed from: component3, reason: from getter */
        public final String getServiceLoginToken() {
            return this.serviceLoginToken;
        }

        public final DataMap copy(LoginUserData data, String loginToken, String serviceLoginToken) {
            return new DataMap(data, loginToken, serviceLoginToken);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DataMap)) {
                return false;
            }
            DataMap dataMap = (DataMap) other;
            return Intrinsics.areEqual(this.data, dataMap.data) && Intrinsics.areEqual(this.loginToken, dataMap.loginToken) && Intrinsics.areEqual(this.serviceLoginToken, dataMap.serviceLoginToken);
        }

        public int hashCode() {
            LoginUserData loginUserData = this.data;
            int iHashCode = (loginUserData == null ? 0 : loginUserData.hashCode()) * 31;
            String str = this.loginToken;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.serviceLoginToken;
            return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "DataMap(data=" + this.data + ", loginToken=" + this.loginToken + ", serviceLoginToken=" + this.serviceLoginToken + ')';
        }

        public DataMap(LoginUserData loginUserData, String str, String str2) {
            this.data = loginUserData;
            this.loginToken = str;
            this.serviceLoginToken = str2;
        }

        public /* synthetic */ DataMap(LoginUserData loginUserData, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : loginUserData, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2);
        }

        public final LoginUserData getData() {
            return this.data;
        }

        public final String getLoginToken() {
            return this.loginToken;
        }

        public final String getServiceLoginToken() {
            return this.serviceLoginToken;
        }
    }
}
