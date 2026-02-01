package com.soletreadmills.sole_v2._data.api.club;

import com.google.gson.annotations.SerializedName;
import com.soletreadmills.sole_v2._data._base.WebApiBaseData;
import com.soletreadmills.sole_v2._data.club.ChallengeItemSimpleData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetPublicChallengesToJoinApiData.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0006"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/club/GetPublicChallengesToJoinApiData;", "", "()V", com.google.android.gms.wearable.DataMap.TAG, "RequestBodyData", "ResponseData", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GetPublicChallengesToJoinApiData {
    public static final int $stable = 0;

    /* compiled from: GetPublicChallengesToJoinApiData.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001c\b\u0007\u0018\u00002\u00020\u0001Bq\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\fR \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R&\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R&\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R&\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R\"\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR&\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0012\"\u0004\b!\u0010\u0014¨\u0006\""}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/club/GetPublicChallengesToJoinApiData$RequestBodyData;", "", "onMachineTypes", "", "", "challengeName", "", "page", "pageSize", "challengeTypes", "scoreItems", "durations", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getChallengeName", "()Ljava/lang/String;", "setChallengeName", "(Ljava/lang/String;)V", "getChallengeTypes", "()Ljava/util/List;", "setChallengeTypes", "(Ljava/util/List;)V", "getDurations", "setDurations", "getOnMachineTypes", "setOnMachineTypes", "getPage", "()Ljava/lang/Integer;", "setPage", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getPageSize", "setPageSize", "getScoreItems", "setScoreItems", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class RequestBodyData {
        public static final int $stable = 8;

        @SerializedName("challengeName")
        private String challengeName;

        @SerializedName("challengeTypes")
        private List<Integer> challengeTypes;

        @SerializedName("durations")
        private List<Integer> durations;

        @SerializedName("onMachineTypes")
        private List<Integer> onMachineTypes;

        @SerializedName("page")
        private Integer page;

        @SerializedName("pageSize")
        private Integer pageSize;

        @SerializedName("scoreItems")
        private List<Integer> scoreItems;

        public RequestBodyData() {
            this(null, null, null, null, null, null, null, 127, null);
        }

        public RequestBodyData(List<Integer> list, String str, Integer num, Integer num2, List<Integer> list2, List<Integer> list3, List<Integer> list4) {
            this.onMachineTypes = list;
            this.challengeName = str;
            this.page = num;
            this.pageSize = num2;
            this.challengeTypes = list2;
            this.scoreItems = list3;
            this.durations = list4;
        }

        public /* synthetic */ RequestBodyData(List list, String str, Integer num, Integer num2, List list2, List list3, List list4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : num2, (i & 16) != 0 ? null : list2, (i & 32) != 0 ? null : list3, (i & 64) != 0 ? null : list4);
        }

        public final List<Integer> getOnMachineTypes() {
            return this.onMachineTypes;
        }

        public final void setOnMachineTypes(List<Integer> list) {
            this.onMachineTypes = list;
        }

        public final String getChallengeName() {
            return this.challengeName;
        }

        public final void setChallengeName(String str) {
            this.challengeName = str;
        }

        public final Integer getPage() {
            return this.page;
        }

        public final void setPage(Integer num) {
            this.page = num;
        }

        public final Integer getPageSize() {
            return this.pageSize;
        }

        public final void setPageSize(Integer num) {
            this.pageSize = num;
        }

        public final List<Integer> getChallengeTypes() {
            return this.challengeTypes;
        }

        public final void setChallengeTypes(List<Integer> list) {
            this.challengeTypes = list;
        }

        public final List<Integer> getScoreItems() {
            return this.scoreItems;
        }

        public final void setScoreItems(List<Integer> list) {
            this.scoreItems = list;
        }

        public final List<Integer> getDurations() {
            return this.durations;
        }

        public final void setDurations(List<Integer> list) {
            this.durations = list;
        }
    }

    /* compiled from: GetPublicChallengesToJoinApiData.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/club/GetPublicChallengesToJoinApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/_base/WebApiBaseData;", "()V", "sysResponseData", "Lcom/soletreadmills/sole_v2/_data/api/club/GetPublicChallengesToJoinApiData$DataMap;", "getSysResponseData", "()Lcom/soletreadmills/sole_v2/_data/api/club/GetPublicChallengesToJoinApiData$DataMap;", "setSysResponseData", "(Lcom/soletreadmills/sole_v2/_data/api/club/GetPublicChallengesToJoinApiData$DataMap;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

    /* compiled from: GetPublicChallengesToJoinApiData.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0011\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\rJ,\u0010\u0011\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R&\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/club/GetPublicChallengesToJoinApiData$DataMap;", "", "data", "", "Lcom/soletreadmills/sole_v2/_data/club/ChallengeItemSimpleData;", "totalCount", "", "(Ljava/util/List;Ljava/lang/Integer;)V", "getData", "()Ljava/util/List;", "setData", "(Ljava/util/List;)V", "getTotalCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/util/List;Ljava/lang/Integer;)Lcom/soletreadmills/sole_v2/_data/api/club/GetPublicChallengesToJoinApiData$DataMap;", "equals", "", "other", "hashCode", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class DataMap {
        public static final int $stable = 8;

        @SerializedName("data")
        private List<ChallengeItemSimpleData> data;

        @SerializedName("totalCount")
        private final Integer totalCount;

        /* JADX WARN: Multi-variable type inference failed */
        public DataMap() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ DataMap copy$default(DataMap dataMap, List list, Integer num, int i, Object obj) {
            if ((i & 1) != 0) {
                list = dataMap.data;
            }
            if ((i & 2) != 0) {
                num = dataMap.totalCount;
            }
            return dataMap.copy(list, num);
        }

        public final List<ChallengeItemSimpleData> component1() {
            return this.data;
        }

        /* renamed from: component2, reason: from getter */
        public final Integer getTotalCount() {
            return this.totalCount;
        }

        public final DataMap copy(List<ChallengeItemSimpleData> data, Integer totalCount) {
            return new DataMap(data, totalCount);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DataMap)) {
                return false;
            }
            DataMap dataMap = (DataMap) other;
            return Intrinsics.areEqual(this.data, dataMap.data) && Intrinsics.areEqual(this.totalCount, dataMap.totalCount);
        }

        public int hashCode() {
            List<ChallengeItemSimpleData> list = this.data;
            int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
            Integer num = this.totalCount;
            return iHashCode + (num != null ? num.hashCode() : 0);
        }

        public String toString() {
            return "DataMap(data=" + this.data + ", totalCount=" + this.totalCount + ')';
        }

        public DataMap(List<ChallengeItemSimpleData> list, Integer num) {
            this.data = list;
            this.totalCount = num;
        }

        public /* synthetic */ DataMap(List list, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : num);
        }

        public final List<ChallengeItemSimpleData> getData() {
            return this.data;
        }

        public final void setData(List<ChallengeItemSimpleData> list) {
            this.data = list;
        }

        public final Integer getTotalCount() {
            return this.totalCount;
        }
    }
}
