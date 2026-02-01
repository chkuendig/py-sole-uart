package com.soletreadmills.sole_v2._data.api._global;

import com.google.gson.annotations.SerializedName;
import com.soletreadmills.sole_v2._data._base.WebApiBaseData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetRegisterServerAddressApiData.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0006"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/_global/GetRegisterServerAddressApiData;", "", "()V", com.google.android.gms.wearable.DataMap.TAG, "RequestBodyData", "ResponseData", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GetRegisterServerAddressApiData {
    public static final int $stable = 0;

    /* compiled from: GetRegisterServerAddressApiData.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0010"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/_global/GetRegisterServerAddressApiData$RequestBodyData;", "", "countryCode", "", "(Ljava/lang/String;)V", "getCountryCode", "()Ljava/lang/String;", "setCountryCode", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class RequestBodyData {
        public static final int $stable = 8;

        @SerializedName("countryCode")
        private String countryCode;

        public static /* synthetic */ RequestBodyData copy$default(RequestBodyData requestBodyData, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = requestBodyData.countryCode;
            }
            return requestBodyData.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getCountryCode() {
            return this.countryCode;
        }

        public final RequestBodyData copy(String countryCode) {
            Intrinsics.checkNotNullParameter(countryCode, "countryCode");
            return new RequestBodyData(countryCode);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof RequestBodyData) && Intrinsics.areEqual(this.countryCode, ((RequestBodyData) other).countryCode);
        }

        public int hashCode() {
            return this.countryCode.hashCode();
        }

        public String toString() {
            return "RequestBodyData(countryCode=" + this.countryCode + ')';
        }

        public RequestBodyData(String countryCode) {
            Intrinsics.checkNotNullParameter(countryCode, "countryCode");
            this.countryCode = countryCode;
        }

        public final String getCountryCode() {
            return this.countryCode;
        }

        public final void setCountryCode(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.countryCode = str;
        }
    }

    /* compiled from: GetRegisterServerAddressApiData.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/_global/GetRegisterServerAddressApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/_base/WebApiBaseData;", "()V", "dataMap", "Lcom/soletreadmills/sole_v2/_data/api/_global/GetRegisterServerAddressApiData$DataMap;", "getDataMap", "()Lcom/soletreadmills/sole_v2/_data/api/_global/GetRegisterServerAddressApiData$DataMap;", "setDataMap", "(Lcom/soletreadmills/sole_v2/_data/api/_global/GetRegisterServerAddressApiData$DataMap;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

    /* compiled from: GetRegisterServerAddressApiData.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/_global/GetRegisterServerAddressApiData$DataMap;", "", "data", "", "(Ljava/lang/String;)V", "getData", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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
