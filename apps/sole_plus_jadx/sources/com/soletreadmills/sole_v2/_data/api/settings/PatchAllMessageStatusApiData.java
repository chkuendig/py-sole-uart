package com.soletreadmills.sole_v2._data.api.settings;

import com.google.gson.annotations.SerializedName;
import com.soletreadmills.sole_v2._data._base.JwtNotificationApiBaseData;
import kotlin.Metadata;

/* compiled from: PatchAllMessageStatusApiData.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/settings/PatchAllMessageStatusApiData;", "", "()V", "RequestBody", "ResponseData", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PatchAllMessageStatusApiData {
    public static final int $stable = 0;

    /* compiled from: PatchAllMessageStatusApiData.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/settings/PatchAllMessageStatusApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/_base/JwtNotificationApiBaseData;", "()V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ResponseData extends JwtNotificationApiBaseData {
        public static final int $stable = 0;
    }

    /* compiled from: PatchAllMessageStatusApiData.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/settings/PatchAllMessageStatusApiData$RequestBody;", "", "()V", "is_read", "", "()Z", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class RequestBody {
        public static final int $stable = 0;

        @SerializedName("is_read")
        private final boolean is_read = true;

        /* renamed from: is_read, reason: from getter */
        public final boolean getIs_read() {
            return this.is_read;
        }
    }
}
