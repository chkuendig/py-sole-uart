package com.soletreadmills.sole_v2._data.api._global;

import com.google.gson.annotations.SerializedName;
import com.soletreadmills.sole_v2._data._base.WebApiBaseData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetLoginServerAddressApiData.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0006"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/_global/GetLoginServerAddressApiData;", "", "()V", com.google.android.gms.wearable.DataMap.TAG, "RequestBodyData", "ResponseData", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GetLoginServerAddressApiData {
    public static final int $stable = 0;

    /* compiled from: GetLoginServerAddressApiData.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/_global/GetLoginServerAddressApiData$RequestBodyData;", "", "registerType", "", "emailOrUserUuidInIdentityProvider", "", "(ILjava/lang/String;)V", "getEmailOrUserUuidInIdentityProvider", "()Ljava/lang/String;", "setEmailOrUserUuidInIdentityProvider", "(Ljava/lang/String;)V", "getRegisterType", "()I", "setRegisterType", "(I)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

    /* compiled from: GetLoginServerAddressApiData.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/_global/GetLoginServerAddressApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/_base/WebApiBaseData;", "()V", "dataMap", "Lcom/soletreadmills/sole_v2/_data/api/_global/GetLoginServerAddressApiData$DataMap;", "getDataMap", "()Lcom/soletreadmills/sole_v2/_data/api/_global/GetLoginServerAddressApiData$DataMap;", "setDataMap", "(Lcom/soletreadmills/sole_v2/_data/api/_global/GetLoginServerAddressApiData$DataMap;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

    /* compiled from: GetLoginServerAddressApiData.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/_global/GetLoginServerAddressApiData$DataMap;", "", "data", "", "(Ljava/lang/String;)V", "getData", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class DataMap {
        public static final int $stable = 0;

        @SerializedName("data")
        private final String data;

        /* JADX WARN: Multi-variable type inference failed */
        public DataMap() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ DataMap copy$default(DataMap dataMap, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = dataMap.data;
            }
            return dataMap.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getData() {
            return this.data;
        }

        public final DataMap copy(String data) {
            Intrinsics.checkNotNullParameter(data, "data");
            return new DataMap(data);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof DataMap) && Intrinsics.areEqual(this.data, ((DataMap) other).data);
        }

        public int hashCode() {
            return this.data.hashCode();
        }

        public String toString() {
            return "DataMap(data=" + this.data + ')';
        }

        public DataMap(String data) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.data = data;
        }

        public /* synthetic */ DataMap(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str);
        }

        public final String getData() {
            return this.data;
        }
    }
}
