package com.soletreadmills.sole_v2._tools;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SrtParser.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\t\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/soletreadmills/sole_v2/_tools/VideoDetailData;", "", "subtitles", "", "Lcom/soletreadmills/sole_v2/_tools/SubtitleData;", "(Ljava/util/List;)V", "getSubtitles", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class VideoDetailData {
    public static final int $stable = 8;
    private final List<SubtitleData> subtitles;

    /* JADX WARN: Multi-variable type inference failed */
    public VideoDetailData() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ VideoDetailData copy$default(VideoDetailData videoDetailData, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = videoDetailData.subtitles;
        }
        return videoDetailData.copy(list);
    }

    public final List<SubtitleData> component1() {
        return this.subtitles;
    }

    public final VideoDetailData copy(List<SubtitleData> subtitles) {
        return new VideoDetailData(subtitles);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof VideoDetailData) && Intrinsics.areEqual(this.subtitles, ((VideoDetailData) other).subtitles);
    }

    public int hashCode() {
        List<SubtitleData> list = this.subtitles;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    public String toString() {
        return "VideoDetailData(subtitles=" + this.subtitles + ')';
    }

    public VideoDetailData(List<SubtitleData> list) {
        this.subtitles = list;
    }

    public /* synthetic */ VideoDetailData(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list);
    }

    public final List<SubtitleData> getSubtitles() {
        return this.subtitles;
    }
}
