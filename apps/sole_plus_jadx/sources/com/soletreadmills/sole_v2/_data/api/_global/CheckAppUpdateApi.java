package com.soletreadmills.sole_v2._data.api._global;

import com.google.gson.annotations.SerializedName;
import com.soletreadmills.sole_v2.AppConfig;
import com.soletreadmills.sole_v2._data._base.WebApiBaseData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CheckAppUpdateApiData.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0007"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/_global/CheckAppUpdateApi;", "", "()V", com.google.android.gms.wearable.DataMap.TAG, "Request", "ResponseData", "UpdateInfo", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CheckAppUpdateApi {
    public static final int $stable = 0;

    /* compiled from: CheckAppUpdateApiData.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/_global/CheckAppUpdateApi$Request;", "", "app", "", "brandCode", "appVersion", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getApp", "()Ljava/lang/String;", "getAppVersion", "getBrandCode", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Request {
        public static final int $stable = 0;
        private final String app;

        @SerializedName("appVersion")
        private final String appVersion;

        @SerializedName("brand_code")
        private final String brandCode;

        public Request() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ Request copy$default(Request request, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = request.app;
            }
            if ((i & 2) != 0) {
                str2 = request.brandCode;
            }
            if ((i & 4) != 0) {
                str3 = request.appVersion;
            }
            return request.copy(str, str2, str3);
        }

        /* renamed from: component1, reason: from getter */
        public final String getApp() {
            return this.app;
        }

        /* renamed from: component2, reason: from getter */
        public final String getBrandCode() {
            return this.brandCode;
        }

        /* renamed from: component3, reason: from getter */
        public final String getAppVersion() {
            return this.appVersion;
        }

        public final Request copy(String app, String brandCode, String appVersion) {
            Intrinsics.checkNotNullParameter(app, "app");
            Intrinsics.checkNotNullParameter(brandCode, "brandCode");
            Intrinsics.checkNotNullParameter(appVersion, "appVersion");
            return new Request(app, brandCode, appVersion);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Request)) {
                return false;
            }
            Request request = (Request) other;
            return Intrinsics.areEqual(this.app, request.app) && Intrinsics.areEqual(this.brandCode, request.brandCode) && Intrinsics.areEqual(this.appVersion, request.appVersion);
        }

        public int hashCode() {
            return (((this.app.hashCode() * 31) + this.brandCode.hashCode()) * 31) + this.appVersion.hashCode();
        }

        public String toString() {
            return "Request(app=" + this.app + ", brandCode=" + this.brandCode + ", appVersion=" + this.appVersion + ')';
        }

        public Request(String app, String brandCode, String appVersion) {
            Intrinsics.checkNotNullParameter(app, "app");
            Intrinsics.checkNotNullParameter(brandCode, "brandCode");
            Intrinsics.checkNotNullParameter(appVersion, "appVersion");
            this.app = app;
            this.brandCode = brandCode;
            this.appVersion = appVersion;
        }

        public /* synthetic */ Request(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? AppConfig.HEADER_DEVICE_TYPE_TITLE : str, (i & 2) != 0 ? "sole" : str2, (i & 4) != 0 ? "255" : str3);
        }

        public final String getApp() {
            return this.app;
        }

        public final String getBrandCode() {
            return this.brandCode;
        }

        public final String getAppVersion() {
            return this.appVersion;
        }
    }

    /* compiled from: CheckAppUpdateApiData.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/_global/CheckAppUpdateApi$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/_base/WebApiBaseData;", "dataMap", "Lcom/soletreadmills/sole_v2/_data/api/_global/CheckAppUpdateApi$DataMap;", "(Lcom/soletreadmills/sole_v2/_data/api/_global/CheckAppUpdateApi$DataMap;)V", "getDataMap", "()Lcom/soletreadmills/sole_v2/_data/api/_global/CheckAppUpdateApi$DataMap;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class ResponseData extends WebApiBaseData {
        public static final int $stable = 0;

        @SerializedName("dataMap")
        private final DataMap dataMap;

        /* JADX WARN: Multi-variable type inference failed */
        public ResponseData() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ ResponseData copy$default(ResponseData responseData, DataMap dataMap, int i, Object obj) {
            if ((i & 1) != 0) {
                dataMap = responseData.dataMap;
            }
            return responseData.copy(dataMap);
        }

        /* renamed from: component1, reason: from getter */
        public final DataMap getDataMap() {
            return this.dataMap;
        }

        public final ResponseData copy(DataMap dataMap) {
            return new ResponseData(dataMap);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ResponseData) && Intrinsics.areEqual(this.dataMap, ((ResponseData) other).dataMap);
        }

        public int hashCode() {
            DataMap dataMap = this.dataMap;
            if (dataMap == null) {
                return 0;
            }
            return dataMap.hashCode();
        }

        public String toString() {
            return "ResponseData(dataMap=" + this.dataMap + ')';
        }

        public /* synthetic */ ResponseData(DataMap dataMap, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : dataMap);
        }

        public final DataMap getDataMap() {
            return this.dataMap;
        }

        public ResponseData(DataMap dataMap) {
            this.dataMap = dataMap;
        }
    }

    /* compiled from: CheckAppUpdateApiData.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/_global/CheckAppUpdateApi$DataMap;", "", "data", "Lcom/soletreadmills/sole_v2/_data/api/_global/CheckAppUpdateApi$UpdateInfo;", "(Lcom/soletreadmills/sole_v2/_data/api/_global/CheckAppUpdateApi$UpdateInfo;)V", "getData", "()Lcom/soletreadmills/sole_v2/_data/api/_global/CheckAppUpdateApi$UpdateInfo;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class DataMap {
        public static final int $stable = 0;

        @SerializedName("data")
        private final UpdateInfo data;

        /* JADX WARN: Multi-variable type inference failed */
        public DataMap() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ DataMap copy$default(DataMap dataMap, UpdateInfo updateInfo, int i, Object obj) {
            if ((i & 1) != 0) {
                updateInfo = dataMap.data;
            }
            return dataMap.copy(updateInfo);
        }

        /* renamed from: component1, reason: from getter */
        public final UpdateInfo getData() {
            return this.data;
        }

        public final DataMap copy(UpdateInfo data) {
            return new DataMap(data);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof DataMap) && Intrinsics.areEqual(this.data, ((DataMap) other).data);
        }

        public int hashCode() {
            UpdateInfo updateInfo = this.data;
            if (updateInfo == null) {
                return 0;
            }
            return updateInfo.hashCode();
        }

        public String toString() {
            return "DataMap(data=" + this.data + ')';
        }

        public DataMap(UpdateInfo updateInfo) {
            this.data = updateInfo;
        }

        public /* synthetic */ DataMap(UpdateInfo updateInfo, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : updateInfo);
        }

        public final UpdateInfo getData() {
            return this.data;
        }
    }

    /* compiled from: CheckAppUpdateApiData.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\rJ0\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/_global/CheckAppUpdateApi$UpdateInfo;", "", "isForceUpgrade", "", "newestVersion", "", "newestVersionInt", "", "(ZLjava/lang/String;Ljava/lang/Long;)V", "()Z", "getNewestVersion", "()Ljava/lang/String;", "getNewestVersionInt", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "copy", "(ZLjava/lang/String;Ljava/lang/Long;)Lcom/soletreadmills/sole_v2/_data/api/_global/CheckAppUpdateApi$UpdateInfo;", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class UpdateInfo {
        public static final int $stable = 0;

        @SerializedName("isForceUpgrade")
        private final boolean isForceUpgrade;

        @SerializedName("newestVersion")
        private final String newestVersion;

        @SerializedName("newestVersionInt")
        private final Long newestVersionInt;

        public UpdateInfo() {
            this(false, null, null, 7, null);
        }

        public static /* synthetic */ UpdateInfo copy$default(UpdateInfo updateInfo, boolean z, String str, Long l, int i, Object obj) {
            if ((i & 1) != 0) {
                z = updateInfo.isForceUpgrade;
            }
            if ((i & 2) != 0) {
                str = updateInfo.newestVersion;
            }
            if ((i & 4) != 0) {
                l = updateInfo.newestVersionInt;
            }
            return updateInfo.copy(z, str, l);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getIsForceUpgrade() {
            return this.isForceUpgrade;
        }

        /* renamed from: component2, reason: from getter */
        public final String getNewestVersion() {
            return this.newestVersion;
        }

        /* renamed from: component3, reason: from getter */
        public final Long getNewestVersionInt() {
            return this.newestVersionInt;
        }

        public final UpdateInfo copy(boolean isForceUpgrade, String newestVersion, Long newestVersionInt) {
            return new UpdateInfo(isForceUpgrade, newestVersion, newestVersionInt);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UpdateInfo)) {
                return false;
            }
            UpdateInfo updateInfo = (UpdateInfo) other;
            return this.isForceUpgrade == updateInfo.isForceUpgrade && Intrinsics.areEqual(this.newestVersion, updateInfo.newestVersion) && Intrinsics.areEqual(this.newestVersionInt, updateInfo.newestVersionInt);
        }

        public int hashCode() {
            int iHashCode = Boolean.hashCode(this.isForceUpgrade) * 31;
            String str = this.newestVersion;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            Long l = this.newestVersionInt;
            return iHashCode2 + (l != null ? l.hashCode() : 0);
        }

        public String toString() {
            return "UpdateInfo(isForceUpgrade=" + this.isForceUpgrade + ", newestVersion=" + this.newestVersion + ", newestVersionInt=" + this.newestVersionInt + ')';
        }

        public UpdateInfo(boolean z, String str, Long l) {
            this.isForceUpgrade = z;
            this.newestVersion = str;
            this.newestVersionInt = l;
        }

        public final boolean isForceUpgrade() {
            return this.isForceUpgrade;
        }

        public final String getNewestVersion() {
            return this.newestVersion;
        }

        public /* synthetic */ UpdateInfo(boolean z, String str, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z, (i & 2) != 0 ? null : str, (i & 4) != 0 ? 0L : l);
        }

        public final Long getNewestVersionInt() {
            return this.newestVersionInt;
        }
    }
}
