package com.soletreadmills.sole_v2._data.api.club;

import com.google.gson.annotations.SerializedName;
import com.soletreadmills.sole_v2._data._base.WebApiBaseData;
import com.soletreadmills.sole_v2._data.club.ChallengeItemFullData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetChallengeDetailApiData.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0006"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/club/GetChallengeDetailApiData;", "", "()V", com.google.android.gms.wearable.DataMap.TAG, "RequestBodyData", "ResponseData", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GetChallengeDetailApiData {
    public static final int $stable = 0;

    /* compiled from: GetChallengeDetailApiData.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u0004\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/club/GetChallengeDetailApiData$RequestBodyData;", "", "challengeUuid", "", "isWithMemberData", "", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "getChallengeUuid", "()Ljava/lang/String;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class RequestBodyData {
        public static final int $stable = 0;

        @SerializedName("challengeUuid")
        private final String challengeUuid;

        @SerializedName("isWithMemberData")
        private final Boolean isWithMemberData;

        public RequestBodyData(String challengeUuid, Boolean bool) {
            Intrinsics.checkNotNullParameter(challengeUuid, "challengeUuid");
            this.challengeUuid = challengeUuid;
            this.isWithMemberData = bool;
        }

        public /* synthetic */ RequestBodyData(String str, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : bool);
        }

        public final String getChallengeUuid() {
            return this.challengeUuid;
        }

        /* renamed from: isWithMemberData, reason: from getter */
        public final Boolean getIsWithMemberData() {
            return this.isWithMemberData;
        }
    }

    /* compiled from: GetChallengeDetailApiData.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/club/GetChallengeDetailApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/_base/WebApiBaseData;", "()V", "sysResponseData", "Lcom/soletreadmills/sole_v2/_data/api/club/GetChallengeDetailApiData$DataMap;", "getSysResponseData", "()Lcom/soletreadmills/sole_v2/_data/api/club/GetChallengeDetailApiData$DataMap;", "setSysResponseData", "(Lcom/soletreadmills/sole_v2/_data/api/club/GetChallengeDetailApiData$DataMap;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

    /* compiled from: GetChallengeDetailApiData.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0011"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/club/GetChallengeDetailApiData$DataMap;", "", "data", "Lcom/soletreadmills/sole_v2/_data/club/ChallengeItemFullData;", "(Lcom/soletreadmills/sole_v2/_data/club/ChallengeItemFullData;)V", "getData", "()Lcom/soletreadmills/sole_v2/_data/club/ChallengeItemFullData;", "setData", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class DataMap {
        public static final int $stable = 8;

        @SerializedName("data")
        private ChallengeItemFullData data;

        /* JADX WARN: Multi-variable type inference failed */
        public DataMap() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ DataMap copy$default(DataMap dataMap, ChallengeItemFullData challengeItemFullData, int i, Object obj) {
            if ((i & 1) != 0) {
                challengeItemFullData = dataMap.data;
            }
            return dataMap.copy(challengeItemFullData);
        }

        /* renamed from: component1, reason: from getter */
        public final ChallengeItemFullData getData() {
            return this.data;
        }

        public final DataMap copy(ChallengeItemFullData data) {
            return new DataMap(data);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof DataMap) && Intrinsics.areEqual(this.data, ((DataMap) other).data);
        }

        public int hashCode() {
            ChallengeItemFullData challengeItemFullData = this.data;
            if (challengeItemFullData == null) {
                return 0;
            }
            return challengeItemFullData.hashCode();
        }

        public String toString() {
            return "DataMap(data=" + this.data + ')';
        }

        public DataMap(ChallengeItemFullData challengeItemFullData) {
            this.data = challengeItemFullData;
        }

        public /* synthetic */ DataMap(ChallengeItemFullData challengeItemFullData, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : challengeItemFullData);
        }

        public final ChallengeItemFullData getData() {
            return this.data;
        }

        public final void setData(ChallengeItemFullData challengeItemFullData) {
            this.data = challengeItemFullData;
        }
    }
}
