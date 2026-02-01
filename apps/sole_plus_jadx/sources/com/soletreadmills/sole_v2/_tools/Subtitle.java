package com.soletreadmills.sole_v2._tools;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SrtParser.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/soletreadmills/sole_v2/_tools/Subtitle;", "", "startTime", "", SDKConstants.PARAM_END_TIME, "text", "", "(JJLjava/lang/String;)V", "getEndTime", "()J", "getStartTime", "getText", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class Subtitle {
    public static final int $stable = 0;
    private final long endTime;
    private final long startTime;
    private final String text;

    public static /* synthetic */ Subtitle copy$default(Subtitle subtitle, long j, long j2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            j = subtitle.startTime;
        }
        long j3 = j;
        if ((i & 2) != 0) {
            j2 = subtitle.endTime;
        }
        long j4 = j2;
        if ((i & 4) != 0) {
            str = subtitle.text;
        }
        return subtitle.copy(j3, j4, str);
    }

    /* renamed from: component1, reason: from getter */
    public final long getStartTime() {
        return this.startTime;
    }

    /* renamed from: component2, reason: from getter */
    public final long getEndTime() {
        return this.endTime;
    }

    /* renamed from: component3, reason: from getter */
    public final String getText() {
        return this.text;
    }

    public final Subtitle copy(long startTime, long endTime, String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        return new Subtitle(startTime, endTime, text);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Subtitle)) {
            return false;
        }
        Subtitle subtitle = (Subtitle) other;
        return this.startTime == subtitle.startTime && this.endTime == subtitle.endTime && Intrinsics.areEqual(this.text, subtitle.text);
    }

    public int hashCode() {
        return (((Long.hashCode(this.startTime) * 31) + Long.hashCode(this.endTime)) * 31) + this.text.hashCode();
    }

    public String toString() {
        return "Subtitle(startTime=" + this.startTime + ", endTime=" + this.endTime + ", text=" + this.text + ')';
    }

    public Subtitle(long j, long j2, String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.startTime = j;
        this.endTime = j2;
        this.text = text;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public final long getEndTime() {
        return this.endTime;
    }

    public final String getText() {
        return this.text;
    }
}
