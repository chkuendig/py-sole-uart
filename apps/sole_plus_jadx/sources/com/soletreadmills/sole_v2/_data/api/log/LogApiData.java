package com.soletreadmills.sole_v2._data.api.log;

import com.google.gson.annotations.SerializedName;
import com.soletreadmills.sole_v2._data._base.WebApiBaseData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LogApiData.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/log/LogApiData;", "", "()V", "RequestBodyData", "ResponseData", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LogApiData {
    public static final int $stable = 0;

    /* compiled from: LogApiData.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0003X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\n\"\u0004\b\f\u0010\rR\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\rR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\n\"\u0004\b\u0011\u0010\rR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\n\"\u0004\b\u0013\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/log/LogApiData$RequestBodyData;", "", "userUuid", "", "logUuid", "brandId", "logData", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "app", "getApp", "()Ljava/lang/String;", "getBrandId", "setBrandId", "(Ljava/lang/String;)V", "getLogData", "setLogData", "getLogUuid", "setLogUuid", "getUserUuid", "setUserUuid", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class RequestBodyData {
        public static final int $stable = 8;
        private final String app;

        @SerializedName("brand_id")
        private String brandId;

        @SerializedName("log_data")
        private String logData;

        @SerializedName("log_uuid")
        private String logUuid;

        @SerializedName("user_uuid")
        private String userUuid;

        public RequestBodyData(String userUuid, String logUuid, String brandId, String logData) {
            Intrinsics.checkNotNullParameter(userUuid, "userUuid");
            Intrinsics.checkNotNullParameter(logUuid, "logUuid");
            Intrinsics.checkNotNullParameter(brandId, "brandId");
            Intrinsics.checkNotNullParameter(logData, "logData");
            this.userUuid = userUuid;
            this.logUuid = logUuid;
            this.brandId = brandId;
            this.logData = logData;
            this.app = "HOME_SOLE_ANDROID";
        }

        public final String getUserUuid() {
            return this.userUuid;
        }

        public final void setUserUuid(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.userUuid = str;
        }

        public final String getLogUuid() {
            return this.logUuid;
        }

        public final void setLogUuid(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.logUuid = str;
        }

        public final String getBrandId() {
            return this.brandId;
        }

        public final void setBrandId(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.brandId = str;
        }

        public final String getLogData() {
            return this.logData;
        }

        public final void setLogData(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.logData = str;
        }

        public final String getApp() {
            return this.app;
        }
    }

    /* compiled from: LogApiData.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/log/LogApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/_base/WebApiBaseData;", "()V", "logUuid", "", "getLogUuid", "()Ljava/lang/String;", "message", "getMessage", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ResponseData extends WebApiBaseData {
        public static final int $stable = 0;

        @SerializedName("log_uuid")
        private final String logUuid;

        @SerializedName("message")
        private final String message;

        public final String getMessage() {
            return this.message;
        }

        public final String getLogUuid() {
            return this.logUuid;
        }
    }
}
