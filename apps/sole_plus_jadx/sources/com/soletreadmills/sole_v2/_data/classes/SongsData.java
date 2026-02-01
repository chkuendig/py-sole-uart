package com.soletreadmills.sole_v2._data.classes;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetClassVideoDetailApiData.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J2\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/classes/SongsData;", "", "duration_sec", "", "hls_url", "", "title", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getDuration_sec", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHls_url", "()Ljava/lang/String;", "getTitle", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/soletreadmills/sole_v2/_data/classes/SongsData;", "equals", "", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SongsData {
    public static final int $stable = 0;
    private final Integer duration_sec;
    private final String hls_url;
    private final String title;

    public SongsData() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ SongsData copy$default(SongsData songsData, Integer num, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = songsData.duration_sec;
        }
        if ((i & 2) != 0) {
            str = songsData.hls_url;
        }
        if ((i & 4) != 0) {
            str2 = songsData.title;
        }
        return songsData.copy(num, str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final Integer getDuration_sec() {
        return this.duration_sec;
    }

    /* renamed from: component2, reason: from getter */
    public final String getHls_url() {
        return this.hls_url;
    }

    /* renamed from: component3, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public final SongsData copy(Integer duration_sec, String hls_url, String title) {
        return new SongsData(duration_sec, hls_url, title);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SongsData)) {
            return false;
        }
        SongsData songsData = (SongsData) other;
        return Intrinsics.areEqual(this.duration_sec, songsData.duration_sec) && Intrinsics.areEqual(this.hls_url, songsData.hls_url) && Intrinsics.areEqual(this.title, songsData.title);
    }

    public int hashCode() {
        Integer num = this.duration_sec;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.hls_url;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.title;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "SongsData(duration_sec=" + this.duration_sec + ", hls_url=" + this.hls_url + ", title=" + this.title + ')';
    }

    public SongsData(Integer num, String str, String str2) {
        this.duration_sec = num;
        this.hls_url = str;
        this.title = str2;
    }

    public /* synthetic */ SongsData(Integer num, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2);
    }

    public final Integer getDuration_sec() {
        return this.duration_sec;
    }

    public final String getHls_url() {
        return this.hls_url;
    }

    public final String getTitle() {
        return this.title;
    }
}
