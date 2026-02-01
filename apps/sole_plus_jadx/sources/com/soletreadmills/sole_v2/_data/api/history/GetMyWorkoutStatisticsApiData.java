package com.soletreadmills.sole_v2._data.api.history;

import com.google.gson.annotations.SerializedName;
import com.soletreadmills.sole_v2._data.UserStatisticsVoData;
import com.soletreadmills.sole_v2._data._base.WebApiBaseData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetMyWorkoutStatisticsApiData.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/history/GetMyWorkoutStatisticsApiData;", "", "()V", com.google.android.gms.wearable.DataMap.TAG, "ResponseData", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GetMyWorkoutStatisticsApiData {
    public static final int $stable = 0;

    /* compiled from: GetMyWorkoutStatisticsApiData.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/history/GetMyWorkoutStatisticsApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/_base/WebApiBaseData;", "()V", "dataMap", "Lcom/soletreadmills/sole_v2/_data/api/history/GetMyWorkoutStatisticsApiData$DataMap;", "getDataMap", "()Lcom/soletreadmills/sole_v2/_data/api/history/GetMyWorkoutStatisticsApiData$DataMap;", "setDataMap", "(Lcom/soletreadmills/sole_v2/_data/api/history/GetMyWorkoutStatisticsApiData$DataMap;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

    /* compiled from: GetMyWorkoutStatisticsApiData.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/history/GetMyWorkoutStatisticsApiData$DataMap;", "", "data", "Lcom/soletreadmills/sole_v2/_data/UserStatisticsVoData;", "(Lcom/soletreadmills/sole_v2/_data/UserStatisticsVoData;)V", "getData", "()Lcom/soletreadmills/sole_v2/_data/UserStatisticsVoData;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class DataMap {
        public static final int $stable = 8;

        @SerializedName("data")
        private final UserStatisticsVoData data;

        /* JADX WARN: Multi-variable type inference failed */
        public DataMap() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ DataMap copy$default(DataMap dataMap, UserStatisticsVoData userStatisticsVoData, int i, Object obj) {
            if ((i & 1) != 0) {
                userStatisticsVoData = dataMap.data;
            }
            return dataMap.copy(userStatisticsVoData);
        }

        /* renamed from: component1, reason: from getter */
        public final UserStatisticsVoData getData() {
            return this.data;
        }

        public final DataMap copy(UserStatisticsVoData data) {
            return new DataMap(data);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof DataMap) && Intrinsics.areEqual(this.data, ((DataMap) other).data);
        }

        public int hashCode() {
            UserStatisticsVoData userStatisticsVoData = this.data;
            if (userStatisticsVoData == null) {
                return 0;
            }
            return userStatisticsVoData.hashCode();
        }

        public String toString() {
            return "DataMap(data=" + this.data + ')';
        }

        public DataMap(UserStatisticsVoData userStatisticsVoData) {
            this.data = userStatisticsVoData;
        }

        public /* synthetic */ DataMap(UserStatisticsVoData userStatisticsVoData, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : userStatisticsVoData);
        }

        public final UserStatisticsVoData getData() {
            return this.data;
        }
    }
}
