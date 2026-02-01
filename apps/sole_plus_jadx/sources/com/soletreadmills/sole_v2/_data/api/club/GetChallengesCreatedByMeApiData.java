package com.soletreadmills.sole_v2._data.api.club;

import com.google.gson.annotations.SerializedName;
import com.soletreadmills.sole_v2._data._base.WebApiBaseData;
import com.soletreadmills.sole_v2._data.club.ChallengeItemSimpleData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetChallengesCreatedByMeApiData.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0006"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/club/GetChallengesCreatedByMeApiData;", "", "()V", com.google.android.gms.wearable.DataMap.TAG, "RequestBodyData", "ResponseData", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GetChallengesCreatedByMeApiData {
    public static final int $stable = 0;

    /* compiled from: GetChallengesCreatedByMeApiData.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006¢\u0006\u0002\u0010\bR\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\fR\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/club/GetChallengesCreatedByMeApiData$RequestBodyData;", "", "page", "", "pageSize", "challengeType", "", "scoreItem", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;)V", "getChallengeType", "()Ljava/util/List;", "getPage", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPageSize", "getScoreItem", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class RequestBodyData {
        public static final int $stable = 8;

        @SerializedName("challengeTypes")
        private final List<Integer> challengeType;

        @SerializedName("page")
        private final Integer page;

        @SerializedName("pageSize")
        private final Integer pageSize;

        @SerializedName("scoreItem")
        private final List<Integer> scoreItem;

        public RequestBodyData() {
            this(null, null, null, null, 15, null);
        }

        public RequestBodyData(Integer num, Integer num2, List<Integer> list, List<Integer> list2) {
            this.page = num;
            this.pageSize = num2;
            this.challengeType = list;
            this.scoreItem = list2;
        }

        public /* synthetic */ RequestBodyData(Integer num, Integer num2, List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : list, (i & 8) != 0 ? null : list2);
        }

        public final Integer getPage() {
            return this.page;
        }

        public final Integer getPageSize() {
            return this.pageSize;
        }

        public final List<Integer> getChallengeType() {
            return this.challengeType;
        }

        public final List<Integer> getScoreItem() {
            return this.scoreItem;
        }
    }

    /* compiled from: GetChallengesCreatedByMeApiData.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/club/GetChallengesCreatedByMeApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/_base/WebApiBaseData;", "()V", "sysResponseData", "Lcom/soletreadmills/sole_v2/_data/api/club/GetChallengesCreatedByMeApiData$DataMap;", "getSysResponseData", "()Lcom/soletreadmills/sole_v2/_data/api/club/GetChallengesCreatedByMeApiData$DataMap;", "setSysResponseData", "(Lcom/soletreadmills/sole_v2/_data/api/club/GetChallengesCreatedByMeApiData$DataMap;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

    /* compiled from: GetChallengesCreatedByMeApiData.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000bJ,\u0010\u000f\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/club/GetChallengesCreatedByMeApiData$DataMap;", "", "data", "", "Lcom/soletreadmills/sole_v2/_data/club/ChallengeItemSimpleData;", "totalCount", "", "(Ljava/util/List;Ljava/lang/Integer;)V", "getData", "()Ljava/util/List;", "getTotalCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/util/List;Ljava/lang/Integer;)Lcom/soletreadmills/sole_v2/_data/api/club/GetChallengesCreatedByMeApiData$DataMap;", "equals", "", "other", "hashCode", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class DataMap {
        public static final int $stable = 8;

        @SerializedName("data")
        private final List<ChallengeItemSimpleData> data;

        @SerializedName("totalCount")
        private final Integer totalCount;

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
            this(list, (i & 2) != 0 ? null : num);
        }

        public final List<ChallengeItemSimpleData> getData() {
            return this.data;
        }

        public final Integer getTotalCount() {
            return this.totalCount;
        }
    }
}
