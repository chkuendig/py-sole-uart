package com.soletreadmills.sole_v2._data.api.club;

import com.google.gson.annotations.SerializedName;
import com.soletreadmills.sole_v2._data._base.WebApiBaseData;
import com.soletreadmills.sole_v2._data.club.ChallengeItemSimpleDataWithMemberData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetMyOnGoingChallengesWithMemberApiData.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0006"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/club/GetMyOnGoingChallengesWithMemberApiData;", "", "()V", com.google.android.gms.wearable.DataMap.TAG, "RequestBodyData", "ResponseData", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GetMyOnGoingChallengesWithMemberApiData {
    public static final int $stable = 0;

    /* compiled from: GetMyOnGoingChallengesWithMemberApiData.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\u000f\u0010\t\"\u0004\b\u0010\u0010\u000bR\"\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\u0011\u0010\t\"\u0004\b\u0012\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/club/GetMyOnGoingChallengesWithMemberApiData$RequestBodyData;", "", "page", "", "pageSize", "challengeType", "scoreItem", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getChallengeType", "()Ljava/lang/Integer;", "setChallengeType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getPage", "setPage", "getPageSize", "setPageSize", "getScoreItem", "setScoreItem", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class RequestBodyData {
        public static final int $stable = 8;

        @SerializedName("challengeType")
        private Integer challengeType;

        @SerializedName("page")
        private Integer page;

        @SerializedName("pageSize")
        private Integer pageSize;

        @SerializedName("scoreItem")
        private Integer scoreItem;

        public RequestBodyData() {
            this(null, null, null, null, 15, null);
        }

        public RequestBodyData(Integer num, Integer num2, Integer num3, Integer num4) {
            this.page = num;
            this.pageSize = num2;
            this.challengeType = num3;
            this.scoreItem = num4;
        }

        public /* synthetic */ RequestBodyData(Integer num, Integer num2, Integer num3, Integer num4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : num3, (i & 8) != 0 ? null : num4);
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

        public final Integer getChallengeType() {
            return this.challengeType;
        }

        public final void setChallengeType(Integer num) {
            this.challengeType = num;
        }

        public final Integer getScoreItem() {
            return this.scoreItem;
        }

        public final void setScoreItem(Integer num) {
            this.scoreItem = num;
        }
    }

    /* compiled from: GetMyOnGoingChallengesWithMemberApiData.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/club/GetMyOnGoingChallengesWithMemberApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/_base/WebApiBaseData;", "()V", "sysResponseData", "Lcom/soletreadmills/sole_v2/_data/api/club/GetMyOnGoingChallengesWithMemberApiData$DataMap;", "getSysResponseData", "()Lcom/soletreadmills/sole_v2/_data/api/club/GetMyOnGoingChallengesWithMemberApiData$DataMap;", "setSysResponseData", "(Lcom/soletreadmills/sole_v2/_data/api/club/GetMyOnGoingChallengesWithMemberApiData$DataMap;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

    /* compiled from: GetMyOnGoingChallengesWithMemberApiData.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\rJ,\u0010\u0013\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R&\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/club/GetMyOnGoingChallengesWithMemberApiData$DataMap;", "", "data", "", "Lcom/soletreadmills/sole_v2/_data/club/ChallengeItemSimpleDataWithMemberData;", "totalCount", "", "(Ljava/util/List;Ljava/lang/Long;)V", "getData", "()Ljava/util/List;", "setData", "(Ljava/util/List;)V", "getTotalCount", "()Ljava/lang/Long;", "setTotalCount", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "component1", "component2", "copy", "(Ljava/util/List;Ljava/lang/Long;)Lcom/soletreadmills/sole_v2/_data/api/club/GetMyOnGoingChallengesWithMemberApiData$DataMap;", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class DataMap {
        public static final int $stable = 8;

        @SerializedName("data")
        private List<ChallengeItemSimpleDataWithMemberData> data;

        @SerializedName("totalCount")
        private Long totalCount;

        /* JADX WARN: Multi-variable type inference failed */
        public DataMap() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ DataMap copy$default(DataMap dataMap, List list, Long l, int i, Object obj) {
            if ((i & 1) != 0) {
                list = dataMap.data;
            }
            if ((i & 2) != 0) {
                l = dataMap.totalCount;
            }
            return dataMap.copy(list, l);
        }

        public final List<ChallengeItemSimpleDataWithMemberData> component1() {
            return this.data;
        }

        /* renamed from: component2, reason: from getter */
        public final Long getTotalCount() {
            return this.totalCount;
        }

        public final DataMap copy(List<ChallengeItemSimpleDataWithMemberData> data, Long totalCount) {
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
            List<ChallengeItemSimpleDataWithMemberData> list = this.data;
            int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
            Long l = this.totalCount;
            return iHashCode + (l != null ? l.hashCode() : 0);
        }

        public String toString() {
            return "DataMap(data=" + this.data + ", totalCount=" + this.totalCount + ')';
        }

        public DataMap(List<ChallengeItemSimpleDataWithMemberData> list, Long l) {
            this.data = list;
            this.totalCount = l;
        }

        public /* synthetic */ DataMap(List list, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : l);
        }

        public final List<ChallengeItemSimpleDataWithMemberData> getData() {
            return this.data;
        }

        public final void setData(List<ChallengeItemSimpleDataWithMemberData> list) {
            this.data = list;
        }

        public final Long getTotalCount() {
            return this.totalCount;
        }

        public final void setTotalCount(Long l) {
            this.totalCount = l;
        }
    }
}
