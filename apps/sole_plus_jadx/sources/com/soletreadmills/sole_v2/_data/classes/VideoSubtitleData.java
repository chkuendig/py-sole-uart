package com.soletreadmills.sole_v2._data.classes;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetClassVideoDetailApiData.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/classes/VideoSubtitleData;", "", "lang_tag", "", "url", "(Ljava/lang/String;Ljava/lang/String;)V", "getLang_tag", "()Ljava/lang/String;", "getUrl", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class VideoSubtitleData {
    public static final int $stable = 0;
    private final String lang_tag;
    private final String url;

    /* JADX WARN: Multi-variable type inference failed */
    public VideoSubtitleData() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ VideoSubtitleData copy$default(VideoSubtitleData videoSubtitleData, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = videoSubtitleData.lang_tag;
        }
        if ((i & 2) != 0) {
            str2 = videoSubtitleData.url;
        }
        return videoSubtitleData.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getLang_tag() {
        return this.lang_tag;
    }

    /* renamed from: component2, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public final VideoSubtitleData copy(String lang_tag, String url) {
        return new VideoSubtitleData(lang_tag, url);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VideoSubtitleData)) {
            return false;
        }
        VideoSubtitleData videoSubtitleData = (VideoSubtitleData) other;
        return Intrinsics.areEqual(this.lang_tag, videoSubtitleData.lang_tag) && Intrinsics.areEqual(this.url, videoSubtitleData.url);
    }

    public int hashCode() {
        String str = this.lang_tag;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.url;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "VideoSubtitleData(lang_tag=" + this.lang_tag + ", url=" + this.url + ')';
    }

    public VideoSubtitleData(String str, String str2) {
        this.lang_tag = str;
        this.url = str2;
    }

    public /* synthetic */ VideoSubtitleData(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
    }

    public final String getLang_tag() {
        return this.lang_tag;
    }

    public final String getUrl() {
        return this.url;
    }
}
