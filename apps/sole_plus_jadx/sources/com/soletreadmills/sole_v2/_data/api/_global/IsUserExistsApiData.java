package com.soletreadmills.sole_v2._data.api._global;

import com.google.gson.annotations.SerializedName;
import com.soletreadmills.sole_v2._data._base.WebApiBaseData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IsUserExistsApiData.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0006"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/_global/IsUserExistsApiData;", "", "()V", com.google.android.gms.wearable.DataMap.TAG, "RequestBodyData", "ResponseData", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class IsUserExistsApiData {
    public static final int $stable = 0;

    /* compiled from: IsUserExistsApiData.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/_global/IsUserExistsApiData$RequestBodyData;", "", "registerType", "", "emailOrUserUuidInIdentityProvider", "", "(ILjava/lang/String;)V", "getEmailOrUserUuidInIdentityProvider", "()Ljava/lang/String;", "setEmailOrUserUuidInIdentityProvider", "(Ljava/lang/String;)V", "getRegisterType", "()I", "setRegisterType", "(I)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class RequestBodyData {
        public static final int $stable = 8;

        @SerializedName("emailOrUserUuidInIdentityProvider")
        private String emailOrUserUuidInIdentityProvider;

        @SerializedName("registerType")
        private int registerType;

        public static /* synthetic */ RequestBodyData copy$default(RequestBodyData requestBodyData, int i, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = requestBodyData.registerType;
            }
            if ((i2 & 2) != 0) {
                str = requestBodyData.emailOrUserUuidInIdentityProvider;
            }
            return requestBodyData.copy(i, str);
        }

        /* renamed from: component1, reason: from getter */
        public final int getRegisterType() {
            return this.registerType;
        }

        /* renamed from: component2, reason: from getter */
        public final String getEmailOrUserUuidInIdentityProvider() {
            return this.emailOrUserUuidInIdentityProvider;
        }

        public final RequestBodyData copy(int registerType, String emailOrUserUuidInIdentityProvider) {
            Intrinsics.checkNotNullParameter(emailOrUserUuidInIdentityProvider, "emailOrUserUuidInIdentityProvider");
            return new RequestBodyData(registerType, emailOrUserUuidInIdentityProvider);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RequestBodyData)) {
                return false;
            }
            RequestBodyData requestBodyData = (RequestBodyData) other;
            return this.registerType == requestBodyData.registerType && Intrinsics.areEqual(this.emailOrUserUuidInIdentityProvider, requestBodyData.emailOrUserUuidInIdentityProvider);
        }

        public int hashCode() {
            return (Integer.hashCode(this.registerType) * 31) + this.emailOrUserUuidInIdentityProvider.hashCode();
        }

        public String toString() {
            return "RequestBodyData(registerType=" + this.registerType + ", emailOrUserUuidInIdentityProvider=" + this.emailOrUserUuidInIdentityProvider + ')';
        }

        public RequestBodyData(int i, String emailOrUserUuidInIdentityProvider) {
            Intrinsics.checkNotNullParameter(emailOrUserUuidInIdentityProvider, "emailOrUserUuidInIdentityProvider");
            this.registerType = i;
            this.emailOrUserUuidInIdentityProvider = emailOrUserUuidInIdentityProvider;
        }

        public final int getRegisterType() {
            return this.registerType;
        }

        public final void setRegisterType(int i) {
            this.registerType = i;
        }

        public final String getEmailOrUserUuidInIdentityProvider() {
            return this.emailOrUserUuidInIdentityProvider;
        }

        public final void setEmailOrUserUuidInIdentityProvider(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.emailOrUserUuidInIdentityProvider = str;
        }
    }

    /* compiled from: IsUserExistsApiData.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/_global/IsUserExistsApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/_base/WebApiBaseData;", "()V", "dataMap", "Lcom/soletreadmills/sole_v2/_data/api/_global/IsUserExistsApiData$DataMap;", "getDataMap", "()Lcom/soletreadmills/sole_v2/_data/api/_global/IsUserExistsApiData$DataMap;", "setDataMap", "(Lcom/soletreadmills/sole_v2/_data/api/_global/IsUserExistsApiData$DataMap;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

    /* compiled from: IsUserExistsApiData.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\nJ$\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/_global/IsUserExistsApiData$DataMap;", "", "data", "", "userStatus", "", "(ZLjava/lang/Integer;)V", "getData", "()Z", "getUserStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(ZLjava/lang/Integer;)Lcom/soletreadmills/sole_v2/_data/api/_global/IsUserExistsApiData$DataMap;", "equals", "other", "hashCode", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class DataMap {
        public static final int $stable = 0;

        @SerializedName("data")
        private final boolean data;

        @SerializedName("userStatus")
        private final Integer userStatus;

        public static /* synthetic */ DataMap copy$default(DataMap dataMap, boolean z, Integer num, int i, Object obj) {
            if ((i & 1) != 0) {
                z = dataMap.data;
            }
            if ((i & 2) != 0) {
                num = dataMap.userStatus;
            }
            return dataMap.copy(z, num);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getData() {
            return this.data;
        }

        /* renamed from: component2, reason: from getter */
        public final Integer getUserStatus() {
            return this.userStatus;
        }

        public final DataMap copy(boolean data, Integer userStatus) {
            return new DataMap(data, userStatus);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DataMap)) {
                return false;
            }
            DataMap dataMap = (DataMap) other;
            return this.data == dataMap.data && Intrinsics.areEqual(this.userStatus, dataMap.userStatus);
        }

        public int hashCode() {
            int iHashCode = Boolean.hashCode(this.data) * 31;
            Integer num = this.userStatus;
            return iHashCode + (num == null ? 0 : num.hashCode());
        }

        public String toString() {
            return "DataMap(data=" + this.data + ", userStatus=" + this.userStatus + ')';
        }

        public DataMap(boolean z, Integer num) {
            this.data = z;
            this.userStatus = num;
        }

        public /* synthetic */ DataMap(boolean z, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z, num);
        }

        public final boolean getData() {
            return this.data;
        }

        public final Integer getUserStatus() {
            return this.userStatus;
        }
    }
}
