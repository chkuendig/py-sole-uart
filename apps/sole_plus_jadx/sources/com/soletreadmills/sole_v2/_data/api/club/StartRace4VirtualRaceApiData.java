package com.soletreadmills.sole_v2._data.api.club;

import com.google.gson.annotations.SerializedName;
import com.soletreadmills.sole_v2._data._base.WebApiBaseData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StartRace4VirtualRaceApiData.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u0007\u0003\u0004\u0005\u0006\u0007\b\tB\u0005¢\u0006\u0002\u0010\u0002¨\u0006\n"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/club/StartRace4VirtualRaceApiData;", "", "()V", com.google.android.gms.wearable.DataMap.TAG, "OthersWorkout", "RawData", "RequestBodyData", "ResponseData", "UserSimpleInfo", "WorkoutData", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class StartRace4VirtualRaceApiData {
    public static final int $stable = 0;

    /* compiled from: StartRace4VirtualRaceApiData.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/club/StartRace4VirtualRaceApiData$RequestBodyData;", "", "challengeUuid", "", "machineType", "", "(Ljava/lang/String;I)V", "getChallengeUuid", "()Ljava/lang/String;", "setChallengeUuid", "(Ljava/lang/String;)V", "getMachineType", "()I", "setMachineType", "(I)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class RequestBodyData {
        public static final int $stable = 8;
        private String challengeUuid;
        private int machineType;

        public RequestBodyData(String challengeUuid, int i) {
            Intrinsics.checkNotNullParameter(challengeUuid, "challengeUuid");
            this.challengeUuid = challengeUuid;
            this.machineType = i;
        }

        public final String getChallengeUuid() {
            return this.challengeUuid;
        }

        public final void setChallengeUuid(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.challengeUuid = str;
        }

        public final int getMachineType() {
            return this.machineType;
        }

        public final void setMachineType(int i) {
            this.machineType = i;
        }
    }

    /* compiled from: StartRace4VirtualRaceApiData.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/club/StartRace4VirtualRaceApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/_base/WebApiBaseData;", "()V", "dataMap", "Lcom/soletreadmills/sole_v2/_data/api/club/StartRace4VirtualRaceApiData$DataMap;", "getDataMap", "()Lcom/soletreadmills/sole_v2/_data/api/club/StartRace4VirtualRaceApiData$DataMap;", "setDataMap", "(Lcom/soletreadmills/sole_v2/_data/api/club/StartRace4VirtualRaceApiData$DataMap;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

    /* compiled from: StartRace4VirtualRaceApiData.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/club/StartRace4VirtualRaceApiData$DataMap;", "", "data", "Lcom/soletreadmills/sole_v2/_data/api/club/StartRace4VirtualRaceApiData$WorkoutData;", "(Lcom/soletreadmills/sole_v2/_data/api/club/StartRace4VirtualRaceApiData$WorkoutData;)V", "getData", "()Lcom/soletreadmills/sole_v2/_data/api/club/StartRace4VirtualRaceApiData$WorkoutData;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class DataMap {
        public static final int $stable = 8;
        private final WorkoutData data;

        public static /* synthetic */ DataMap copy$default(DataMap dataMap, WorkoutData workoutData, int i, Object obj) {
            if ((i & 1) != 0) {
                workoutData = dataMap.data;
            }
            return dataMap.copy(workoutData);
        }

        /* renamed from: component1, reason: from getter */
        public final WorkoutData getData() {
            return this.data;
        }

        public final DataMap copy(WorkoutData data) {
            return new DataMap(data);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof DataMap) && Intrinsics.areEqual(this.data, ((DataMap) other).data);
        }

        public int hashCode() {
            WorkoutData workoutData = this.data;
            if (workoutData == null) {
                return 0;
            }
            return workoutData.hashCode();
        }

        public String toString() {
            return "DataMap(data=" + this.data + ')';
        }

        public DataMap(WorkoutData workoutData) {
            this.data = workoutData;
        }

        public final WorkoutData getData() {
            return this.data;
        }
    }

    /* compiled from: StartRace4VirtualRaceApiData.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/club/StartRace4VirtualRaceApiData$WorkoutData;", "", "ticket", "", "othersWorkoutVoList", "", "Lcom/soletreadmills/sole_v2/_data/api/club/StartRace4VirtualRaceApiData$OthersWorkout;", "(Ljava/lang/String;Ljava/util/List;)V", "getOthersWorkoutVoList", "()Ljava/util/List;", "getTicket", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class WorkoutData {
        public static final int $stable = 8;
        private final List<OthersWorkout> othersWorkoutVoList;
        private final String ticket;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ WorkoutData copy$default(WorkoutData workoutData, String str, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = workoutData.ticket;
            }
            if ((i & 2) != 0) {
                list = workoutData.othersWorkoutVoList;
            }
            return workoutData.copy(str, list);
        }

        /* renamed from: component1, reason: from getter */
        public final String getTicket() {
            return this.ticket;
        }

        public final List<OthersWorkout> component2() {
            return this.othersWorkoutVoList;
        }

        public final WorkoutData copy(String ticket, List<OthersWorkout> othersWorkoutVoList) {
            Intrinsics.checkNotNullParameter(ticket, "ticket");
            Intrinsics.checkNotNullParameter(othersWorkoutVoList, "othersWorkoutVoList");
            return new WorkoutData(ticket, othersWorkoutVoList);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof WorkoutData)) {
                return false;
            }
            WorkoutData workoutData = (WorkoutData) other;
            return Intrinsics.areEqual(this.ticket, workoutData.ticket) && Intrinsics.areEqual(this.othersWorkoutVoList, workoutData.othersWorkoutVoList);
        }

        public int hashCode() {
            return (this.ticket.hashCode() * 31) + this.othersWorkoutVoList.hashCode();
        }

        public String toString() {
            return "WorkoutData(ticket=" + this.ticket + ", othersWorkoutVoList=" + this.othersWorkoutVoList + ')';
        }

        public WorkoutData(String ticket, List<OthersWorkout> othersWorkoutVoList) {
            Intrinsics.checkNotNullParameter(ticket, "ticket");
            Intrinsics.checkNotNullParameter(othersWorkoutVoList, "othersWorkoutVoList");
            this.ticket = ticket;
            this.othersWorkoutVoList = othersWorkoutVoList;
        }

        public final String getTicket() {
            return this.ticket;
        }

        public final List<OthersWorkout> getOthersWorkoutVoList() {
            return this.othersWorkoutVoList;
        }
    }

    /* compiled from: StartRace4VirtualRaceApiData.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003JS\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0005HÖ\u0001R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010¨\u0006#"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/club/StartRace4VirtualRaceApiData$OthersWorkout;", "", "userSimpleInfo", "Lcom/soletreadmills/sole_v2/_data/api/club/StartRace4VirtualRaceApiData$UserSimpleInfo;", "workoutDate", "", "totalCalories", "totalTime", "totalDistance", "rawDataList", "", "Lcom/soletreadmills/sole_v2/_data/api/club/StartRace4VirtualRaceApiData$RawData;", "(Lcom/soletreadmills/sole_v2/_data/api/club/StartRace4VirtualRaceApiData$UserSimpleInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getRawDataList", "()Ljava/util/List;", "getTotalCalories", "()Ljava/lang/String;", "getTotalDistance", "getTotalTime", "getUserSimpleInfo", "()Lcom/soletreadmills/sole_v2/_data/api/club/StartRace4VirtualRaceApiData$UserSimpleInfo;", "getWorkoutDate", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class OthersWorkout {
        public static final int $stable = 8;
        private final List<RawData> rawDataList;
        private final String totalCalories;
        private final String totalDistance;
        private final String totalTime;
        private final UserSimpleInfo userSimpleInfo;
        private final String workoutDate;

        public static /* synthetic */ OthersWorkout copy$default(OthersWorkout othersWorkout, UserSimpleInfo userSimpleInfo, String str, String str2, String str3, String str4, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                userSimpleInfo = othersWorkout.userSimpleInfo;
            }
            if ((i & 2) != 0) {
                str = othersWorkout.workoutDate;
            }
            String str5 = str;
            if ((i & 4) != 0) {
                str2 = othersWorkout.totalCalories;
            }
            String str6 = str2;
            if ((i & 8) != 0) {
                str3 = othersWorkout.totalTime;
            }
            String str7 = str3;
            if ((i & 16) != 0) {
                str4 = othersWorkout.totalDistance;
            }
            String str8 = str4;
            if ((i & 32) != 0) {
                list = othersWorkout.rawDataList;
            }
            return othersWorkout.copy(userSimpleInfo, str5, str6, str7, str8, list);
        }

        /* renamed from: component1, reason: from getter */
        public final UserSimpleInfo getUserSimpleInfo() {
            return this.userSimpleInfo;
        }

        /* renamed from: component2, reason: from getter */
        public final String getWorkoutDate() {
            return this.workoutDate;
        }

        /* renamed from: component3, reason: from getter */
        public final String getTotalCalories() {
            return this.totalCalories;
        }

        /* renamed from: component4, reason: from getter */
        public final String getTotalTime() {
            return this.totalTime;
        }

        /* renamed from: component5, reason: from getter */
        public final String getTotalDistance() {
            return this.totalDistance;
        }

        public final List<RawData> component6() {
            return this.rawDataList;
        }

        public final OthersWorkout copy(UserSimpleInfo userSimpleInfo, String workoutDate, String totalCalories, String totalTime, String totalDistance, List<RawData> rawDataList) {
            Intrinsics.checkNotNullParameter(userSimpleInfo, "userSimpleInfo");
            Intrinsics.checkNotNullParameter(rawDataList, "rawDataList");
            return new OthersWorkout(userSimpleInfo, workoutDate, totalCalories, totalTime, totalDistance, rawDataList);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OthersWorkout)) {
                return false;
            }
            OthersWorkout othersWorkout = (OthersWorkout) other;
            return Intrinsics.areEqual(this.userSimpleInfo, othersWorkout.userSimpleInfo) && Intrinsics.areEqual(this.workoutDate, othersWorkout.workoutDate) && Intrinsics.areEqual(this.totalCalories, othersWorkout.totalCalories) && Intrinsics.areEqual(this.totalTime, othersWorkout.totalTime) && Intrinsics.areEqual(this.totalDistance, othersWorkout.totalDistance) && Intrinsics.areEqual(this.rawDataList, othersWorkout.rawDataList);
        }

        public int hashCode() {
            int iHashCode = this.userSimpleInfo.hashCode() * 31;
            String str = this.workoutDate;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.totalCalories;
            int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.totalTime;
            int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.totalDistance;
            return ((iHashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31) + this.rawDataList.hashCode();
        }

        public String toString() {
            return "OthersWorkout(userSimpleInfo=" + this.userSimpleInfo + ", workoutDate=" + this.workoutDate + ", totalCalories=" + this.totalCalories + ", totalTime=" + this.totalTime + ", totalDistance=" + this.totalDistance + ", rawDataList=" + this.rawDataList + ')';
        }

        public OthersWorkout(UserSimpleInfo userSimpleInfo, String str, String str2, String str3, String str4, List<RawData> rawDataList) {
            Intrinsics.checkNotNullParameter(userSimpleInfo, "userSimpleInfo");
            Intrinsics.checkNotNullParameter(rawDataList, "rawDataList");
            this.userSimpleInfo = userSimpleInfo;
            this.workoutDate = str;
            this.totalCalories = str2;
            this.totalTime = str3;
            this.totalDistance = str4;
            this.rawDataList = rawDataList;
        }

        public final UserSimpleInfo getUserSimpleInfo() {
            return this.userSimpleInfo;
        }

        public final String getWorkoutDate() {
            return this.workoutDate;
        }

        public final String getTotalCalories() {
            return this.totalCalories;
        }

        public final String getTotalTime() {
            return this.totalTime;
        }

        public final String getTotalDistance() {
            return this.totalDistance;
        }

        public final List<RawData> getRawDataList() {
            return this.rawDataList;
        }
    }

    /* compiled from: StartRace4VirtualRaceApiData.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/club/StartRace4VirtualRaceApiData$UserSimpleInfo;", "", "nickName", "", "photoUrl", "avatarId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAvatarId", "()Ljava/lang/String;", "getNickName", "getPhotoUrl", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class UserSimpleInfo {
        public static final int $stable = 0;
        private final String avatarId;
        private final String nickName;
        private final String photoUrl;

        public static /* synthetic */ UserSimpleInfo copy$default(UserSimpleInfo userSimpleInfo, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = userSimpleInfo.nickName;
            }
            if ((i & 2) != 0) {
                str2 = userSimpleInfo.photoUrl;
            }
            if ((i & 4) != 0) {
                str3 = userSimpleInfo.avatarId;
            }
            return userSimpleInfo.copy(str, str2, str3);
        }

        /* renamed from: component1, reason: from getter */
        public final String getNickName() {
            return this.nickName;
        }

        /* renamed from: component2, reason: from getter */
        public final String getPhotoUrl() {
            return this.photoUrl;
        }

        /* renamed from: component3, reason: from getter */
        public final String getAvatarId() {
            return this.avatarId;
        }

        public final UserSimpleInfo copy(String nickName, String photoUrl, String avatarId) {
            Intrinsics.checkNotNullParameter(nickName, "nickName");
            Intrinsics.checkNotNullParameter(photoUrl, "photoUrl");
            return new UserSimpleInfo(nickName, photoUrl, avatarId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UserSimpleInfo)) {
                return false;
            }
            UserSimpleInfo userSimpleInfo = (UserSimpleInfo) other;
            return Intrinsics.areEqual(this.nickName, userSimpleInfo.nickName) && Intrinsics.areEqual(this.photoUrl, userSimpleInfo.photoUrl) && Intrinsics.areEqual(this.avatarId, userSimpleInfo.avatarId);
        }

        public int hashCode() {
            int iHashCode = ((this.nickName.hashCode() * 31) + this.photoUrl.hashCode()) * 31;
            String str = this.avatarId;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "UserSimpleInfo(nickName=" + this.nickName + ", photoUrl=" + this.photoUrl + ", avatarId=" + this.avatarId + ')';
        }

        public UserSimpleInfo(String nickName, String photoUrl, String str) {
            Intrinsics.checkNotNullParameter(nickName, "nickName");
            Intrinsics.checkNotNullParameter(photoUrl, "photoUrl");
            this.nickName = nickName;
            this.photoUrl = photoUrl;
            this.avatarId = str;
        }

        public final String getNickName() {
            return this.nickName;
        }

        public final String getPhotoUrl() {
            return this.photoUrl;
        }

        public final String getAvatarId() {
            return this.avatarId;
        }
    }

    /* compiled from: StartRace4VirtualRaceApiData.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/club/StartRace4VirtualRaceApiData$RawData;", "", "totalWorkoutTime", "", "nowSpeed", "", "(IF)V", "getNowSpeed", "()F", "getTotalWorkoutTime", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class RawData {
        public static final int $stable = 0;
        private final float nowSpeed;
        private final int totalWorkoutTime;

        public static /* synthetic */ RawData copy$default(RawData rawData, int i, float f, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = rawData.totalWorkoutTime;
            }
            if ((i2 & 2) != 0) {
                f = rawData.nowSpeed;
            }
            return rawData.copy(i, f);
        }

        /* renamed from: component1, reason: from getter */
        public final int getTotalWorkoutTime() {
            return this.totalWorkoutTime;
        }

        /* renamed from: component2, reason: from getter */
        public final float getNowSpeed() {
            return this.nowSpeed;
        }

        public final RawData copy(int totalWorkoutTime, float nowSpeed) {
            return new RawData(totalWorkoutTime, nowSpeed);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RawData)) {
                return false;
            }
            RawData rawData = (RawData) other;
            return this.totalWorkoutTime == rawData.totalWorkoutTime && Float.compare(this.nowSpeed, rawData.nowSpeed) == 0;
        }

        public int hashCode() {
            return (Integer.hashCode(this.totalWorkoutTime) * 31) + Float.hashCode(this.nowSpeed);
        }

        public String toString() {
            return "RawData(totalWorkoutTime=" + this.totalWorkoutTime + ", nowSpeed=" + this.nowSpeed + ')';
        }

        public RawData(int i, float f) {
            this.totalWorkoutTime = i;
            this.nowSpeed = f;
        }

        public final int getTotalWorkoutTime() {
            return this.totalWorkoutTime;
        }

        public final float getNowSpeed() {
            return this.nowSpeed;
        }
    }
}
