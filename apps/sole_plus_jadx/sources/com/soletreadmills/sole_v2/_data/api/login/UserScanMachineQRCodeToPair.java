package com.soletreadmills.sole_v2._data.api.login;

import com.google.gson.annotations.SerializedName;
import com.soletreadmills.sole_v2._data._base.WebApiBaseData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UserScanMachineQRCodeToPair.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/login/UserScanMachineQRCodeToPair;", "", "()V", "RequestBodyData", "ResponseData", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UserScanMachineQRCodeToPair {
    public static final int $stable = 0;

    /* compiled from: UserScanMachineQRCodeToPair.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/login/UserScanMachineQRCodeToPair$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/_base/WebApiBaseData;", "()V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ResponseData extends WebApiBaseData {
        public static final int $stable = 0;
    }

    /* compiled from: UserScanMachineQRCodeToPair.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/login/UserScanMachineQRCodeToPair$RequestBodyData;", "", "deviceId", "", "(Ljava/lang/String;)V", "getDeviceId", "()Ljava/lang/String;", "setDeviceId", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class RequestBodyData {
        public static final int $stable = 8;

        @SerializedName("deviceId")
        private String deviceId;

        public RequestBodyData(String deviceId) {
            Intrinsics.checkNotNullParameter(deviceId, "deviceId");
            this.deviceId = deviceId;
        }

        public final String getDeviceId() {
            return this.deviceId;
        }

        public final void setDeviceId(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.deviceId = str;
        }
    }
}
