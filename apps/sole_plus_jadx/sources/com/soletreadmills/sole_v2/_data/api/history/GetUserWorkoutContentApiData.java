package com.soletreadmills.sole_v2._data.api.history;

import com.google.gson.annotations.SerializedName;
import com.soletreadmills.sole_v2._data.WorkoutViewVo;
import com.soletreadmills.sole_v2._data._base.WebApiBaseData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetUserWorkoutContentApiData.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0006"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/history/GetUserWorkoutContentApiData;", "", "()V", com.google.android.gms.wearable.DataMap.TAG, "RequestBodyData", "ResponseData", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GetUserWorkoutContentApiData {
    public static final int $stable = 0;

    /* compiled from: GetUserWorkoutContentApiData.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/history/GetUserWorkoutContentApiData$RequestBodyData;", "", "workoutUuid", "", "needRawData", "", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "getNeedRawData", "()Ljava/lang/Boolean;", "setNeedRawData", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getWorkoutUuid", "()Ljava/lang/String;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class RequestBodyData {
        public static final int $stable = 8;

        @SerializedName("needRawData")
        private Boolean needRawData;

        @SerializedName("workoutUuid")
        private final String workoutUuid;

        public RequestBodyData(String workoutUuid, Boolean bool) {
            Intrinsics.checkNotNullParameter(workoutUuid, "workoutUuid");
            this.workoutUuid = workoutUuid;
            this.needRawData = bool;
        }

        public final String getWorkoutUuid() {
            return this.workoutUuid;
        }

        public /* synthetic */ RequestBodyData(String str, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? false : bool);
        }

        public final Boolean getNeedRawData() {
            return this.needRawData;
        }

        public final void setNeedRawData(Boolean bool) {
            this.needRawData = bool;
        }
    }

    /* compiled from: GetUserWorkoutContentApiData.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/history/GetUserWorkoutContentApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/_base/WebApiBaseData;", "()V", "dataMap", "Lcom/soletreadmills/sole_v2/_data/api/history/GetUserWorkoutContentApiData$DataMap;", "getDataMap", "()Lcom/soletreadmills/sole_v2/_data/api/history/GetUserWorkoutContentApiData$DataMap;", "setDataMap", "(Lcom/soletreadmills/sole_v2/_data/api/history/GetUserWorkoutContentApiData$DataMap;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

    /* compiled from: GetUserWorkoutContentApiData.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/history/GetUserWorkoutContentApiData$DataMap;", "", "data", "Lcom/soletreadmills/sole_v2/_data/WorkoutViewVo;", "(Lcom/soletreadmills/sole_v2/_data/WorkoutViewVo;)V", "getData", "()Lcom/soletreadmills/sole_v2/_data/WorkoutViewVo;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class DataMap {
        public static final int $stable = 8;

        @SerializedName("data")
        private final WorkoutViewVo data;

        public static /* synthetic */ DataMap copy$default(DataMap dataMap, WorkoutViewVo workoutViewVo, int i, Object obj) {
            if ((i & 1) != 0) {
                workoutViewVo = dataMap.data;
            }
            return dataMap.copy(workoutViewVo);
        }

        /* renamed from: component1, reason: from getter */
        public final WorkoutViewVo getData() {
            return this.data;
        }

        public final DataMap copy(WorkoutViewVo data) {
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

        public DataMap(WorkoutViewVo data) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.data = data;
        }

        public final WorkoutViewVo getData() {
            return this.data;
        }
    }
}
