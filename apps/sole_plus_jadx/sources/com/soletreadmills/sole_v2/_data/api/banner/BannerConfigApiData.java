package com.soletreadmills.sole_v2._data.api.banner;

import com.google.gson.annotations.SerializedName;
import com.soletreadmills.sole_v2._data._base.JwtNotificationApiBaseData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BannerConfigApiData.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/banner/BannerConfigApiData;", "", "()V", "RequestBodyData", "ResponseData", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BannerConfigApiData {
    public static final int $stable = 0;

    /* compiled from: BannerConfigApiData.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/banner/BannerConfigApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/_base/JwtNotificationApiBaseData;", "()V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ResponseData extends JwtNotificationApiBaseData {
        public static final int $stable = 0;
    }

    /* compiled from: BannerConfigApiData.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/banner/BannerConfigApiData$RequestBodyData;", "", "bannerId", "", "(Ljava/lang/String;)V", "getBannerId", "()Ljava/lang/String;", "setBannerId", "isBannerDisabled", "", "()Z", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class RequestBodyData {
        public static final int $stable = 8;

        @SerializedName("banner_id")
        private String bannerId;

        @SerializedName("is_banner_disabled")
        private final boolean isBannerDisabled;

        public RequestBodyData(String bannerId) {
            Intrinsics.checkNotNullParameter(bannerId, "bannerId");
            this.bannerId = bannerId;
            this.isBannerDisabled = true;
        }

        public final String getBannerId() {
            return this.bannerId;
        }

        public final void setBannerId(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.bannerId = str;
        }

        /* renamed from: isBannerDisabled, reason: from getter */
        public final boolean getIsBannerDisabled() {
            return this.isBannerDisabled;
        }
    }
}
