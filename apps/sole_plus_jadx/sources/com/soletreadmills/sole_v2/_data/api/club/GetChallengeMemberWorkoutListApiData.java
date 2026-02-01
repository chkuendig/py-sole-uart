package com.soletreadmills.sole_v2._data.api.club;

import com.google.gson.annotations.SerializedName;
import com.soletreadmills.sole_v2._data._base.WebApiBaseData;
import com.soletreadmills.sole_v2._data.club.ChallengeMemberWorkoutWithUserSimpleInfoData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetChallengeMemberWorkoutListApiData.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0006"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/club/GetChallengeMemberWorkoutListApiData;", "", "()V", com.google.android.gms.wearable.DataMap.TAG, "RequestBodyData", "ResponseData", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GetChallengeMemberWorkoutListApiData {
    public static final int $stable = 0;

    /* compiled from: GetChallengeMemberWorkoutListApiData.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/club/GetChallengeMemberWorkoutListApiData$RequestBodyData;", "", "challengeUuid", "", "targetGlobalUserUuid", "(Ljava/lang/String;Ljava/lang/String;)V", "getChallengeUuid", "()Ljava/lang/String;", "getTargetGlobalUserUuid", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class RequestBodyData {
        public static final int $stable = 0;

        @SerializedName("challengeUuid")
        private final String challengeUuid;

        @SerializedName("targetGlobalUserUuid")
        private final String targetGlobalUserUuid;

        public RequestBodyData(String challengeUuid, String targetGlobalUserUuid) {
            Intrinsics.checkNotNullParameter(challengeUuid, "challengeUuid");
            Intrinsics.checkNotNullParameter(targetGlobalUserUuid, "targetGlobalUserUuid");
            this.challengeUuid = challengeUuid;
            this.targetGlobalUserUuid = targetGlobalUserUuid;
        }

        public final String getChallengeUuid() {
            return this.challengeUuid;
        }

        public final String getTargetGlobalUserUuid() {
            return this.targetGlobalUserUuid;
        }
    }

    /* compiled from: GetChallengeMemberWorkoutListApiData.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/club/GetChallengeMemberWorkoutListApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/_base/WebApiBaseData;", "()V", "sysResponseData", "Lcom/soletreadmills/sole_v2/_data/api/club/GetChallengeMemberWorkoutListApiData$DataMap;", "getSysResponseData", "()Lcom/soletreadmills/sole_v2/_data/api/club/GetChallengeMemberWorkoutListApiData$DataMap;", "setSysResponseData", "(Lcom/soletreadmills/sole_v2/_data/api/club/GetChallengeMemberWorkoutListApiData$DataMap;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

    /* compiled from: GetChallengeMemberWorkoutListApiData.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/club/GetChallengeMemberWorkoutListApiData$DataMap;", "", "data", "Lcom/soletreadmills/sole_v2/_data/club/ChallengeMemberWorkoutWithUserSimpleInfoData;", "(Lcom/soletreadmills/sole_v2/_data/club/ChallengeMemberWorkoutWithUserSimpleInfoData;)V", "getData", "()Lcom/soletreadmills/sole_v2/_data/club/ChallengeMemberWorkoutWithUserSimpleInfoData;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class DataMap {
        public static final int $stable = 8;

        @SerializedName("data")
        private final ChallengeMemberWorkoutWithUserSimpleInfoData data;

        /* JADX WARN: Multi-variable type inference failed */
        public DataMap() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ DataMap copy$default(DataMap dataMap, ChallengeMemberWorkoutWithUserSimpleInfoData challengeMemberWorkoutWithUserSimpleInfoData, int i, Object obj) {
            if ((i & 1) != 0) {
                challengeMemberWorkoutWithUserSimpleInfoData = dataMap.data;
            }
            return dataMap.copy(challengeMemberWorkoutWithUserSimpleInfoData);
        }

        /* renamed from: component1, reason: from getter */
        public final ChallengeMemberWorkoutWithUserSimpleInfoData getData() {
            return this.data;
        }

        public final DataMap copy(ChallengeMemberWorkoutWithUserSimpleInfoData data) {
            return new DataMap(data);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof DataMap) && Intrinsics.areEqual(this.data, ((DataMap) other).data);
        }

        public int hashCode() {
            ChallengeMemberWorkoutWithUserSimpleInfoData challengeMemberWorkoutWithUserSimpleInfoData = this.data;
            if (challengeMemberWorkoutWithUserSimpleInfoData == null) {
                return 0;
            }
            return challengeMemberWorkoutWithUserSimpleInfoData.hashCode();
        }

        public String toString() {
            return "DataMap(data=" + this.data + ')';
        }

        public DataMap(ChallengeMemberWorkoutWithUserSimpleInfoData challengeMemberWorkoutWithUserSimpleInfoData) {
            this.data = challengeMemberWorkoutWithUserSimpleInfoData;
        }

        public /* synthetic */ DataMap(ChallengeMemberWorkoutWithUserSimpleInfoData challengeMemberWorkoutWithUserSimpleInfoData, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : challengeMemberWorkoutWithUserSimpleInfoData);
        }

        public final ChallengeMemberWorkoutWithUserSimpleInfoData getData() {
            return this.data;
        }
    }
}
