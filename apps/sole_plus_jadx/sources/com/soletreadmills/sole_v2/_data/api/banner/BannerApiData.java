package com.soletreadmills.sole_v2._data.api.banner;

import com.google.gson.annotations.SerializedName;
import com.soletreadmills.sole_v2.AppConfig;
import com.soletreadmills.sole_v2._data._base.JwtNotificationApiBaseData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BannerApiData.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0006"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/banner/BannerApiData;", "", "()V", "BannerResult", "RequestBodyData", "ResponseData", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BannerApiData {
    public static final int $stable = 0;

    /* compiled from: BannerApiData.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/banner/BannerApiData$RequestBodyData;", "", "()V", "appLaunchTime", "", "getAppLaunchTime", "()Ljava/lang/String;", "countryCode", "getCountryCode", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class RequestBodyData {
        public static final int $stable = 0;

        @SerializedName("country_code")
        private final String countryCode = AppConfig.INSTANCE.getHEADER_COUNTRY_CODE();

        @SerializedName("app_launch_time")
        private final String appLaunchTime = "1";

        public final String getCountryCode() {
            return this.countryCode;
        }

        public final String getAppLaunchTime() {
            return this.appLaunchTime;
        }
    }

    /* compiled from: BannerApiData.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/banner/BannerApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/_base/JwtNotificationApiBaseData;", "()V", "result", "Lcom/soletreadmills/sole_v2/_data/api/banner/BannerApiData$BannerResult;", "getResult", "()Lcom/soletreadmills/sole_v2/_data/api/banner/BannerApiData$BannerResult;", "setResult", "(Lcom/soletreadmills/sole_v2/_data/api/banner/BannerApiData$BannerResult;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ResponseData extends JwtNotificationApiBaseData {
        public static final int $stable = 8;

        @SerializedName("result")
        private BannerResult result;

        public final BannerResult getResult() {
            return this.result;
        }

        public final void setResult(BannerResult bannerResult) {
            this.result = bannerResult;
        }
    }

    /* compiled from: BannerApiData.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b'\b\u0087\b\u0018\u00002\u00020\u0001Bs\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010&\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010'\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u0010(\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0092\u0001\u0010+\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010,J\u0013\u0010-\u001a\u00020\n2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u00020\u0007HÖ\u0001J\t\u00100\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0018\u0010\u0016R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\t\u0010\u0019R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001b\u0010\u0016R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001e\u0010\u0016R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0012¨\u00061"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/banner/BannerApiData$BannerResult;", "", "banner_id", "", "button_text", "cover_url", "display_time_in_seconds", "", "frequency_in_days", "is_display_banner", "", "link_interaction", "message", "message_background_color", "message_background_opacity", "url_link", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getBanner_id", "()Ljava/lang/String;", "getButton_text", "getCover_url", "getDisplay_time_in_seconds", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getFrequency_in_days", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getLink_interaction", "getMessage", "getMessage_background_color", "getMessage_background_opacity", "getUrl_link", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/soletreadmills/sole_v2/_data/api/banner/BannerApiData$BannerResult;", "equals", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class BannerResult {
        public static final int $stable = 0;
        private final String banner_id;
        private final String button_text;
        private final String cover_url;
        private final Integer display_time_in_seconds;
        private final Integer frequency_in_days;
        private final Boolean is_display_banner;
        private final Integer link_interaction;
        private final String message;
        private final String message_background_color;
        private final Integer message_background_opacity;
        private final String url_link;

        /* renamed from: component1, reason: from getter */
        public final String getBanner_id() {
            return this.banner_id;
        }

        /* renamed from: component10, reason: from getter */
        public final Integer getMessage_background_opacity() {
            return this.message_background_opacity;
        }

        /* renamed from: component11, reason: from getter */
        public final String getUrl_link() {
            return this.url_link;
        }

        /* renamed from: component2, reason: from getter */
        public final String getButton_text() {
            return this.button_text;
        }

        /* renamed from: component3, reason: from getter */
        public final String getCover_url() {
            return this.cover_url;
        }

        /* renamed from: component4, reason: from getter */
        public final Integer getDisplay_time_in_seconds() {
            return this.display_time_in_seconds;
        }

        /* renamed from: component5, reason: from getter */
        public final Integer getFrequency_in_days() {
            return this.frequency_in_days;
        }

        /* renamed from: component6, reason: from getter */
        public final Boolean getIs_display_banner() {
            return this.is_display_banner;
        }

        /* renamed from: component7, reason: from getter */
        public final Integer getLink_interaction() {
            return this.link_interaction;
        }

        /* renamed from: component8, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        /* renamed from: component9, reason: from getter */
        public final String getMessage_background_color() {
            return this.message_background_color;
        }

        public final BannerResult copy(String banner_id, String button_text, String cover_url, Integer display_time_in_seconds, Integer frequency_in_days, Boolean is_display_banner, Integer link_interaction, String message, String message_background_color, Integer message_background_opacity, String url_link) {
            return new BannerResult(banner_id, button_text, cover_url, display_time_in_seconds, frequency_in_days, is_display_banner, link_interaction, message, message_background_color, message_background_opacity, url_link);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BannerResult)) {
                return false;
            }
            BannerResult bannerResult = (BannerResult) other;
            return Intrinsics.areEqual(this.banner_id, bannerResult.banner_id) && Intrinsics.areEqual(this.button_text, bannerResult.button_text) && Intrinsics.areEqual(this.cover_url, bannerResult.cover_url) && Intrinsics.areEqual(this.display_time_in_seconds, bannerResult.display_time_in_seconds) && Intrinsics.areEqual(this.frequency_in_days, bannerResult.frequency_in_days) && Intrinsics.areEqual(this.is_display_banner, bannerResult.is_display_banner) && Intrinsics.areEqual(this.link_interaction, bannerResult.link_interaction) && Intrinsics.areEqual(this.message, bannerResult.message) && Intrinsics.areEqual(this.message_background_color, bannerResult.message_background_color) && Intrinsics.areEqual(this.message_background_opacity, bannerResult.message_background_opacity) && Intrinsics.areEqual(this.url_link, bannerResult.url_link);
        }

        public int hashCode() {
            String str = this.banner_id;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.button_text;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.cover_url;
            int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            Integer num = this.display_time_in_seconds;
            int iHashCode4 = (iHashCode3 + (num == null ? 0 : num.hashCode())) * 31;
            Integer num2 = this.frequency_in_days;
            int iHashCode5 = (iHashCode4 + (num2 == null ? 0 : num2.hashCode())) * 31;
            Boolean bool = this.is_display_banner;
            int iHashCode6 = (iHashCode5 + (bool == null ? 0 : bool.hashCode())) * 31;
            Integer num3 = this.link_interaction;
            int iHashCode7 = (iHashCode6 + (num3 == null ? 0 : num3.hashCode())) * 31;
            String str4 = this.message;
            int iHashCode8 = (iHashCode7 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.message_background_color;
            int iHashCode9 = (iHashCode8 + (str5 == null ? 0 : str5.hashCode())) * 31;
            Integer num4 = this.message_background_opacity;
            int iHashCode10 = (iHashCode9 + (num4 == null ? 0 : num4.hashCode())) * 31;
            String str6 = this.url_link;
            return iHashCode10 + (str6 != null ? str6.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("BannerResult(banner_id=");
            sb.append(this.banner_id).append(", button_text=").append(this.button_text).append(", cover_url=").append(this.cover_url).append(", display_time_in_seconds=").append(this.display_time_in_seconds).append(", frequency_in_days=").append(this.frequency_in_days).append(", is_display_banner=").append(this.is_display_banner).append(", link_interaction=").append(this.link_interaction).append(", message=").append(this.message).append(", message_background_color=").append(this.message_background_color).append(", message_background_opacity=").append(this.message_background_opacity).append(", url_link=").append(this.url_link).append(')');
            return sb.toString();
        }

        public BannerResult(String str, String str2, String str3, Integer num, Integer num2, Boolean bool, Integer num3, String str4, String str5, Integer num4, String str6) {
            this.banner_id = str;
            this.button_text = str2;
            this.cover_url = str3;
            this.display_time_in_seconds = num;
            this.frequency_in_days = num2;
            this.is_display_banner = bool;
            this.link_interaction = num3;
            this.message = str4;
            this.message_background_color = str5;
            this.message_background_opacity = num4;
            this.url_link = str6;
        }

        public final String getBanner_id() {
            return this.banner_id;
        }

        public final String getButton_text() {
            return this.button_text;
        }

        public final String getCover_url() {
            return this.cover_url;
        }

        public final Integer getDisplay_time_in_seconds() {
            return this.display_time_in_seconds;
        }

        public final Integer getFrequency_in_days() {
            return this.frequency_in_days;
        }

        public final Boolean is_display_banner() {
            return this.is_display_banner;
        }

        public final Integer getLink_interaction() {
            return this.link_interaction;
        }

        public final String getMessage() {
            return this.message;
        }

        public final String getMessage_background_color() {
            return this.message_background_color;
        }

        public final Integer getMessage_background_opacity() {
            return this.message_background_opacity;
        }

        public final String getUrl_link() {
            return this.url_link;
        }
    }
}
