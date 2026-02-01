package com.soletreadmills.sole_v2._data.api.signUp;

import com.google.gson.annotations.SerializedName;
import com.soletreadmills.sole_v2._data._base.WebApiBaseData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResendConfirmSignUpCodeApiData.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/signUp/ResendConfirmSignUpCodeApiData;", "", "()V", "RequestBodyData", "ResponseData", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ResendConfirmSignUpCodeApiData {
    public static final int $stable = 0;

    /* compiled from: ResendConfirmSignUpCodeApiData.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/signUp/ResendConfirmSignUpCodeApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/_base/WebApiBaseData;", "()V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ResponseData extends WebApiBaseData {
        public static final int $stable = 0;
    }

    /* compiled from: ResendConfirmSignUpCodeApiData.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/signUp/ResendConfirmSignUpCodeApiData$RequestBodyData;", "", "registerType", "", "loginName", "", "(ILjava/lang/String;)V", "getLoginName", "()Ljava/lang/String;", "setLoginName", "(Ljava/lang/String;)V", "getRegisterType", "()I", "setRegisterType", "(I)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class RequestBodyData {
        public static final int $stable = 8;

        @SerializedName("loginName")
        private String loginName;

        @SerializedName("registerType")
        private int registerType;

        public RequestBodyData(int i, String loginName) {
            Intrinsics.checkNotNullParameter(loginName, "loginName");
            this.registerType = i;
            this.loginName = loginName;
        }

        public final int getRegisterType() {
            return this.registerType;
        }

        public final void setRegisterType(int i) {
            this.registerType = i;
        }

        public final String getLoginName() {
            return this.loginName;
        }

        public final void setLoginName(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.loginName = str;
        }
    }
}
