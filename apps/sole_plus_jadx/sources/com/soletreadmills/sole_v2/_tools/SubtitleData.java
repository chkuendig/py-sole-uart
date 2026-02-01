package com.soletreadmills.sole_v2._tools;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SrtParser.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/soletreadmills/sole_v2/_tools/SubtitleData;", "", "lang_tag", "", "url", "(Ljava/lang/String;Ljava/lang/String;)V", "getLang_tag", "()Ljava/lang/String;", "getUrl", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SubtitleData {
    public static final int $stable = 0;
    private final String lang_tag;
    private final String url;

    public static /* synthetic */ SubtitleData copy$default(SubtitleData subtitleData, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = subtitleData.lang_tag;
        }
        if ((i & 2) != 0) {
            str2 = subtitleData.url;
        }
        return subtitleData.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getLang_tag() {
        return this.lang_tag;
    }

    /* renamed from: component2, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public final SubtitleData copy(String lang_tag, String url) {
        Intrinsics.checkNotNullParameter(lang_tag, "lang_tag");
        return new SubtitleData(lang_tag, url);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SubtitleData)) {
            return false;
        }
        SubtitleData subtitleData = (SubtitleData) other;
        return Intrinsics.areEqual(this.lang_tag, subtitleData.lang_tag) && Intrinsics.areEqual(this.url, subtitleData.url);
    }

    public int hashCode() {
        int iHashCode = this.lang_tag.hashCode() * 31;
        String str = this.url;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "SubtitleData(lang_tag=" + this.lang_tag + ", url=" + this.url + ')';
    }

    public SubtitleData(String lang_tag, String str) {
        Intrinsics.checkNotNullParameter(lang_tag, "lang_tag");
        this.lang_tag = lang_tag;
        this.url = str;
    }

    public final String getLang_tag() {
        return this.lang_tag;
    }

    public final String getUrl() {
        return this.url;
    }
}
