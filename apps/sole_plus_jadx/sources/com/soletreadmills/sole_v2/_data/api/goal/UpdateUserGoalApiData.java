package com.soletreadmills.sole_v2._data.api.goal;

import com.google.gson.annotations.SerializedName;
import com.soletreadmills.sole_v2._data._base.WebApiBaseData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UpdateUserGoalApiData.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0006"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/goal/UpdateUserGoalApiData;", "", "()V", com.google.android.gms.wearable.DataMap.TAG, "RequestBodyData", "ResponseData", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UpdateUserGoalApiData {
    public static final int $stable = 0;

    /* compiled from: UpdateUserGoalApiData.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/goal/UpdateUserGoalApiData$RequestBodyData;", "", "recordUuid", "", "goalValue", "", "(Ljava/lang/String;D)V", "getGoalValue", "()D", "setGoalValue", "(D)V", "getRecordUuid", "()Ljava/lang/String;", "setRecordUuid", "(Ljava/lang/String;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class RequestBodyData {
        public static final int $stable = 8;

        @SerializedName("goalValue")
        private double goalValue;

        @SerializedName("recordUuid")
        private String recordUuid;

        public RequestBodyData(String recordUuid, double d) {
            Intrinsics.checkNotNullParameter(recordUuid, "recordUuid");
            this.recordUuid = recordUuid;
            this.goalValue = d;
        }

        public final String getRecordUuid() {
            return this.recordUuid;
        }

        public final void setRecordUuid(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.recordUuid = str;
        }

        public final double getGoalValue() {
            return this.goalValue;
        }

        public final void setGoalValue(double d) {
            this.goalValue = d;
        }
    }

    /* compiled from: UpdateUserGoalApiData.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/goal/UpdateUserGoalApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/_base/WebApiBaseData;", "()V", "dataMap", "Lcom/soletreadmills/sole_v2/_data/api/goal/UpdateUserGoalApiData$DataMap;", "getDataMap", "()Lcom/soletreadmills/sole_v2/_data/api/goal/UpdateUserGoalApiData$DataMap;", "setDataMap", "(Lcom/soletreadmills/sole_v2/_data/api/goal/UpdateUserGoalApiData$DataMap;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

    /* compiled from: UpdateUserGoalApiData.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/goal/UpdateUserGoalApiData$DataMap;", "", "data", "", "(Ljava/lang/String;)V", "getData", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class DataMap {
        public static final int $stable = 0;

        @SerializedName("data")
        private final String data;

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
            return new DataMap(data);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof DataMap) && Intrinsics.areEqual(this.data, ((DataMap) other).data);
        }

        public int hashCode() {
            String str = this.data;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "DataMap(data=" + this.data + ')';
        }

        public DataMap(String str) {
            this.data = str;
        }

        public final String getData() {
            return this.data;
        }
    }
}
