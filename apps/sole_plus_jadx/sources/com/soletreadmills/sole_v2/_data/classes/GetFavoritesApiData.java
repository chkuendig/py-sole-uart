package com.soletreadmills.sole_v2._data.classes;

import com.google.gson.annotations.SerializedName;
import com.soletreadmills.sole_v2._data._base.JwtApiBaseData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetFavoritesApiData.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/classes/GetFavoritesApiData;", "", "()V", "RequestBodyData", "ResponseData", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GetFavoritesApiData {
    public static final int $stable = 0;

    /* compiled from: GetFavoritesApiData.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/classes/GetFavoritesApiData$RequestBodyData;", "", "objectTypes", "", "(Ljava/lang/String;)V", "getObjectTypes", "()Ljava/lang/String;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class RequestBodyData {
        public static final int $stable = 0;

        @SerializedName("object_types")
        private final String objectTypes;

        public RequestBodyData(String objectTypes) {
            Intrinsics.checkNotNullParameter(objectTypes, "objectTypes");
            this.objectTypes = objectTypes;
        }

        public final String getObjectTypes() {
            return this.objectTypes;
        }
    }

    /* compiled from: GetFavoritesApiData.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/classes/GetFavoritesApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/_base/JwtApiBaseData;", "()V", "dataMap", "", "Lcom/soletreadmills/sole_v2/_data/classes/FavoritesData;", "getDataMap", "()Ljava/util/List;", "setDataMap", "(Ljava/util/List;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ResponseData extends JwtApiBaseData {
        public static final int $stable = 8;

        @SerializedName("sys_response_data")
        private List<FavoritesData> dataMap;

        public final List<FavoritesData> getDataMap() {
            return this.dataMap;
        }

        public final void setDataMap(List<FavoritesData> list) {
            this.dataMap = list;
        }
    }
}
