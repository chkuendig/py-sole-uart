package com.soletreadmills.sole_v2.ui.classes;

import java.net.HttpCookie;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VideoPlayerView.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\bHÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J9\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/classes/CookieData;", "", "videoUrl", "", "cookies", "", "Ljava/net/HttpCookie;", "setLoop", "", "isMuted", "(Ljava/lang/String;Ljava/util/List;ZZ)V", "getCookies", "()Ljava/util/List;", "()Z", "getSetLoop", "getVideoUrl", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class CookieData {
    public static final int $stable = 8;
    private final List<HttpCookie> cookies;
    private final boolean isMuted;
    private final boolean setLoop;
    private final String videoUrl;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CookieData copy$default(CookieData cookieData, String str, List list, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = cookieData.videoUrl;
        }
        if ((i & 2) != 0) {
            list = cookieData.cookies;
        }
        if ((i & 4) != 0) {
            z = cookieData.setLoop;
        }
        if ((i & 8) != 0) {
            z2 = cookieData.isMuted;
        }
        return cookieData.copy(str, list, z, z2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getVideoUrl() {
        return this.videoUrl;
    }

    public final List<HttpCookie> component2() {
        return this.cookies;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getSetLoop() {
        return this.setLoop;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getIsMuted() {
        return this.isMuted;
    }

    public final CookieData copy(String videoUrl, List<HttpCookie> cookies, boolean setLoop, boolean isMuted) {
        Intrinsics.checkNotNullParameter(videoUrl, "videoUrl");
        return new CookieData(videoUrl, cookies, setLoop, isMuted);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CookieData)) {
            return false;
        }
        CookieData cookieData = (CookieData) other;
        return Intrinsics.areEqual(this.videoUrl, cookieData.videoUrl) && Intrinsics.areEqual(this.cookies, cookieData.cookies) && this.setLoop == cookieData.setLoop && this.isMuted == cookieData.isMuted;
    }

    public int hashCode() {
        int iHashCode = this.videoUrl.hashCode() * 31;
        List<HttpCookie> list = this.cookies;
        return ((((iHashCode + (list == null ? 0 : list.hashCode())) * 31) + Boolean.hashCode(this.setLoop)) * 31) + Boolean.hashCode(this.isMuted);
    }

    public String toString() {
        return "CookieData(videoUrl=" + this.videoUrl + ", cookies=" + this.cookies + ", setLoop=" + this.setLoop + ", isMuted=" + this.isMuted + ')';
    }

    public CookieData(String videoUrl, List<HttpCookie> list, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(videoUrl, "videoUrl");
        this.videoUrl = videoUrl;
        this.cookies = list;
        this.setLoop = z;
        this.isMuted = z2;
    }

    public /* synthetic */ CookieData(String str, List list, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : list, (i & 4) != 0 ? true : z, (i & 8) != 0 ? false : z2);
    }

    public final String getVideoUrl() {
        return this.videoUrl;
    }

    public final List<HttpCookie> getCookies() {
        return this.cookies;
    }

    public final boolean getSetLoop() {
        return this.setLoop;
    }

    public final boolean isMuted() {
        return this.isMuted;
    }
}
