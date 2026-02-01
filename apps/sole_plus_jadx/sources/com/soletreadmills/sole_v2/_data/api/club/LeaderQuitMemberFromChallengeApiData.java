package com.soletreadmills.sole_v2._data.api.club;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.soletreadmills.sole_v2._data._base.WebApiBaseData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LeaderQuitMemberFromChallengeApiData.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0006"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/club/LeaderQuitMemberFromChallengeApiData;", "", "()V", com.google.android.gms.wearable.DataMap.TAG, "RequestBodyData", "ResponseData", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LeaderQuitMemberFromChallengeApiData {
    public static final int $stable = 0;

    /* compiled from: LeaderQuitMemberFromChallengeApiData.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/club/LeaderQuitMemberFromChallengeApiData$RequestBodyData;", "", "challengeUuid", "", "globalUserUuidList", "", "(Ljava/lang/String;Ljava/util/List;)V", "getChallengeUuid", "()Ljava/lang/String;", "getGlobalUserUuidList", "()Ljava/util/List;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class RequestBodyData {
        public static final int $stable = 8;

        @SerializedName("challengeUuid")
        private final String challengeUuid;

        @SerializedName("globalUserUuidList")
        private final List<String> globalUserUuidList;

        public RequestBodyData(String challengeUuid, List<String> globalUserUuidList) {
            Intrinsics.checkNotNullParameter(challengeUuid, "challengeUuid");
            Intrinsics.checkNotNullParameter(globalUserUuidList, "globalUserUuidList");
            this.challengeUuid = challengeUuid;
            this.globalUserUuidList = globalUserUuidList;
        }

        public final String getChallengeUuid() {
            return this.challengeUuid;
        }

        public final List<String> getGlobalUserUuidList() {
            return this.globalUserUuidList;
        }
    }

    /* compiled from: LeaderQuitMemberFromChallengeApiData.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/club/LeaderQuitMemberFromChallengeApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/_base/WebApiBaseData;", "()V", "sysResponseData", "Lcom/soletreadmills/sole_v2/_data/api/club/LeaderQuitMemberFromChallengeApiData$DataMap;", "getSysResponseData", "()Lcom/soletreadmills/sole_v2/_data/api/club/LeaderQuitMemberFromChallengeApiData$DataMap;", "setSysResponseData", "(Lcom/soletreadmills/sole_v2/_data/api/club/LeaderQuitMemberFromChallengeApiData$DataMap;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

    /* compiled from: LeaderQuitMemberFromChallengeApiData.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/club/LeaderQuitMemberFromChallengeApiData$DataMap;", "", "data", "Lcom/google/gson/JsonObject;", "(Lcom/google/gson/JsonObject;)V", "getData", "()Lcom/google/gson/JsonObject;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class DataMap {
        public static final int $stable = 8;

        @SerializedName("data")
        private final JsonObject data;

        /* JADX WARN: Multi-variable type inference failed */
        public DataMap() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ DataMap copy$default(DataMap dataMap, JsonObject jsonObject, int i, Object obj) {
            if ((i & 1) != 0) {
                jsonObject = dataMap.data;
            }
            return dataMap.copy(jsonObject);
        }

        /* renamed from: component1, reason: from getter */
        public final JsonObject getData() {
            return this.data;
        }

        public final DataMap copy(JsonObject data) {
            return new DataMap(data);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof DataMap) && Intrinsics.areEqual(this.data, ((DataMap) other).data);
        }

        public int hashCode() {
            JsonObject jsonObject = this.data;
            if (jsonObject == null) {
                return 0;
            }
            return jsonObject.hashCode();
        }

        public String toString() {
            return "DataMap(data=" + this.data + ')';
        }

        public DataMap(JsonObject jsonObject) {
            this.data = jsonObject;
        }

        public /* synthetic */ DataMap(JsonObject jsonObject, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : jsonObject);
        }

        public final JsonObject getData() {
            return this.data;
        }
    }
}
