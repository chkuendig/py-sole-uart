package com.soletreadmills.sole_v2._data.api.club;

import com.google.gson.annotations.SerializedName;
import com.soletreadmills.sole_v2._data._base.WebApiBaseData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CreateChallengeApiData.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0006"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/club/CreateChallengeApiData;", "", "()V", com.google.android.gms.wearable.DataMap.TAG, "RequestBodyData", "ResponseData", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CreateChallengeApiData {
    public static final int $stable = 0;

    /* compiled from: CreateChallengeApiData.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b$\b\u0007\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000fR\u001e\u0010\u000b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R \u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\"\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0011\"\u0004\b \u0010\u0013R\"\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0015\"\u0004\b'\u0010\u0017R\"\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\b(\u0010\"\"\u0004\b)\u0010$R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0011\"\u0004\b+\u0010\u0013R \u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0011\"\u0004\b-\u0010\u0013¨\u0006."}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/club/CreateChallengeApiData$RequestBodyData;", "", "challengeType", "", "startDate", "", "endDate", "privacyLevel", "scoreItem", "goalValue", "", "challengeName", "introduction", "onMachineType", "virtualRaceCode", "(ILjava/lang/String;Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getChallengeName", "()Ljava/lang/String;", "setChallengeName", "(Ljava/lang/String;)V", "getChallengeType", "()I", "setChallengeType", "(I)V", "getEndDate", "setEndDate", "getGoalValue", "()Ljava/lang/Double;", "setGoalValue", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "getIntroduction", "setIntroduction", "getOnMachineType", "()Ljava/lang/Integer;", "setOnMachineType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getPrivacyLevel", "setPrivacyLevel", "getScoreItem", "setScoreItem", "getStartDate", "setStartDate", "getVirtualRaceCode", "setVirtualRaceCode", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class RequestBodyData {
        public static final int $stable = 8;

        @SerializedName("challengeName")
        private String challengeName;

        @SerializedName("challengeType")
        private int challengeType;

        @SerializedName("endDate")
        private String endDate;

        @SerializedName("goalValue")
        private Double goalValue;

        @SerializedName("introduction")
        private String introduction;

        @SerializedName("onMachineType")
        private Integer onMachineType;

        @SerializedName("privacyLevel")
        private int privacyLevel;

        @SerializedName("scoreItem")
        private Integer scoreItem;

        @SerializedName("startDate")
        private String startDate;

        @SerializedName("virtualRaceCode")
        private String virtualRaceCode;

        public RequestBodyData(int i, String startDate, String str, int i2, Integer num, Double d, String challengeName, String introduction, Integer num2, String str2) {
            Intrinsics.checkNotNullParameter(startDate, "startDate");
            Intrinsics.checkNotNullParameter(challengeName, "challengeName");
            Intrinsics.checkNotNullParameter(introduction, "introduction");
            this.challengeType = i;
            this.startDate = startDate;
            this.endDate = str;
            this.privacyLevel = i2;
            this.scoreItem = num;
            this.goalValue = d;
            this.challengeName = challengeName;
            this.introduction = introduction;
            this.onMachineType = num2;
            this.virtualRaceCode = str2;
        }

        public final int getChallengeType() {
            return this.challengeType;
        }

        public final void setChallengeType(int i) {
            this.challengeType = i;
        }

        public final String getStartDate() {
            return this.startDate;
        }

        public final void setStartDate(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.startDate = str;
        }

        public final String getEndDate() {
            return this.endDate;
        }

        public final void setEndDate(String str) {
            this.endDate = str;
        }

        public final int getPrivacyLevel() {
            return this.privacyLevel;
        }

        public final void setPrivacyLevel(int i) {
            this.privacyLevel = i;
        }

        public final Integer getScoreItem() {
            return this.scoreItem;
        }

        public final void setScoreItem(Integer num) {
            this.scoreItem = num;
        }

        public final Double getGoalValue() {
            return this.goalValue;
        }

        public final void setGoalValue(Double d) {
            this.goalValue = d;
        }

        public final String getChallengeName() {
            return this.challengeName;
        }

        public final void setChallengeName(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.challengeName = str;
        }

        public final String getIntroduction() {
            return this.introduction;
        }

        public final void setIntroduction(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.introduction = str;
        }

        public final Integer getOnMachineType() {
            return this.onMachineType;
        }

        public final void setOnMachineType(Integer num) {
            this.onMachineType = num;
        }

        public final String getVirtualRaceCode() {
            return this.virtualRaceCode;
        }

        public final void setVirtualRaceCode(String str) {
            this.virtualRaceCode = str;
        }
    }

    /* compiled from: CreateChallengeApiData.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/club/CreateChallengeApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/_base/WebApiBaseData;", "()V", "sysResponseData", "Lcom/soletreadmills/sole_v2/_data/api/club/CreateChallengeApiData$DataMap;", "getSysResponseData", "()Lcom/soletreadmills/sole_v2/_data/api/club/CreateChallengeApiData$DataMap;", "setSysResponseData", "(Lcom/soletreadmills/sole_v2/_data/api/club/CreateChallengeApiData$DataMap;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ResponseData extends WebApiBaseData {
        public static final int $stable = 8;

        @SerializedName("dataMap")
        private DataMap sysResponseData;

        public final DataMap getSysResponseData() {
            return this.sysResponseData;
        }

        public final void setSysResponseData(DataMap dataMap) {
            this.sysResponseData = dataMap;
        }
    }

    /* compiled from: CreateChallengeApiData.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/club/CreateChallengeApiData$DataMap;", "", "challengeUuid", "", "challengeName", "(Ljava/lang/String;Ljava/lang/String;)V", "getChallengeName", "()Ljava/lang/String;", "getChallengeUuid", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class DataMap {
        public static final int $stable = 0;

        @SerializedName("challengeName")
        private final String challengeName;

        @SerializedName("challengeUuid")
        private final String challengeUuid;

        /* JADX WARN: Multi-variable type inference failed */
        public DataMap() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ DataMap copy$default(DataMap dataMap, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = dataMap.challengeUuid;
            }
            if ((i & 2) != 0) {
                str2 = dataMap.challengeName;
            }
            return dataMap.copy(str, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getChallengeUuid() {
            return this.challengeUuid;
        }

        /* renamed from: component2, reason: from getter */
        public final String getChallengeName() {
            return this.challengeName;
        }

        public final DataMap copy(String challengeUuid, String challengeName) {
            return new DataMap(challengeUuid, challengeName);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DataMap)) {
                return false;
            }
            DataMap dataMap = (DataMap) other;
            return Intrinsics.areEqual(this.challengeUuid, dataMap.challengeUuid) && Intrinsics.areEqual(this.challengeName, dataMap.challengeName);
        }

        public int hashCode() {
            String str = this.challengeUuid;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.challengeName;
            return iHashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "DataMap(challengeUuid=" + this.challengeUuid + ", challengeName=" + this.challengeName + ')';
        }

        public DataMap(String str, String str2) {
            this.challengeUuid = str;
            this.challengeName = str2;
        }

        public /* synthetic */ DataMap(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
        }

        public final String getChallengeUuid() {
            return this.challengeUuid;
        }

        public final String getChallengeName() {
            return this.challengeName;
        }
    }
}
