package com.soletreadmills.sole_v2._data.classes;

import com.google.gson.annotations.SerializedName;
import com.soletreadmills.sole_v2._data._base.JwtApiBaseData;
import kotlin.Metadata;

/* compiled from: GetFollowedCollectionApiData.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/classes/GetFollowedCollectionApiData;", "", "()V", "ResponseData", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GetFollowedCollectionApiData {
    public static final int $stable = 0;

    /* compiled from: GetFollowedCollectionApiData.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/classes/GetFollowedCollectionApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/_base/JwtApiBaseData;", "()V", "dataMap", "Lcom/soletreadmills/sole_v2/_data/classes/FollowedCollectionData;", "getDataMap", "()Lcom/soletreadmills/sole_v2/_data/classes/FollowedCollectionData;", "setDataMap", "(Lcom/soletreadmills/sole_v2/_data/classes/FollowedCollectionData;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ResponseData extends JwtApiBaseData {
        public static final int $stable = 8;

        @SerializedName("sys_response_data")
        private FollowedCollectionData dataMap;

        public final FollowedCollectionData getDataMap() {
            return this.dataMap;
        }

        public final void setDataMap(FollowedCollectionData followedCollectionData) {
            this.dataMap = followedCollectionData;
        }
    }
}
