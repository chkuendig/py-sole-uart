package com.soletreadmills.sole_v2._data.api.login;

import com.google.gson.annotations.SerializedName;
import com.soletreadmills.sole_v2._data._base.WebApiBaseData;
import com.soletreadmills.sole_v2._data.api.login.LoginByEmailApiData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LoginByGoogleApiData.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/login/LoginByGoogleApiData;", "", "()V", "RequestBodyData", "ResponseData", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LoginByGoogleApiData {
    public static final int $stable = 0;

    /* compiled from: LoginByGoogleApiData.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\f"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/login/LoginByGoogleApiData$RequestBodyData;", "", "idToken", "", "pushToken", "(Ljava/lang/String;Ljava/lang/String;)V", "getIdToken", "()Ljava/lang/String;", "setIdToken", "(Ljava/lang/String;)V", "getPushToken", "setPushToken", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class RequestBodyData {
        public static final int $stable = 8;

        @SerializedName("idToken")
        private String idToken;

        @SerializedName("pushToken")
        private String pushToken;

        public RequestBodyData(String idToken, String pushToken) {
            Intrinsics.checkNotNullParameter(idToken, "idToken");
            Intrinsics.checkNotNullParameter(pushToken, "pushToken");
            this.idToken = idToken;
            this.pushToken = pushToken;
        }

        public final String getIdToken() {
            return this.idToken;
        }

        public final void setIdToken(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.idToken = str;
        }

        public final String getPushToken() {
            return this.pushToken;
        }

        public final void setPushToken(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.pushToken = str;
        }
    }

    /* compiled from: LoginByGoogleApiData.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/login/LoginByGoogleApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/_base/WebApiBaseData;", "()V", "dataMap", "Lcom/soletreadmills/sole_v2/_data/api/login/LoginByEmailApiData$DataMap;", "getDataMap", "()Lcom/soletreadmills/sole_v2/_data/api/login/LoginByEmailApiData$DataMap;", "setDataMap", "(Lcom/soletreadmills/sole_v2/_data/api/login/LoginByEmailApiData$DataMap;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ResponseData extends WebApiBaseData {
        public static final int $stable = 8;

        @SerializedName("dataMap")
        private LoginByEmailApiData.DataMap dataMap;

        public final LoginByEmailApiData.DataMap getDataMap() {
            return this.dataMap;
        }

        public final void setDataMap(LoginByEmailApiData.DataMap dataMap) {
            this.dataMap = dataMap;
        }
    }
}
