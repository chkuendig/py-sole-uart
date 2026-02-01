package io.ktor.http;

import com.facebook.gamingservices.internal.TournamentShareDialogURIBuilder;
import com.sun.jna.platform.win32.WinError;
import io.ktor.util.CharsetKt;
import io.ktor.util.TextKt;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: URLProtocol.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lio/ktor/http/URLProtocol;", "", "name", "", "defaultPort", "", "(Ljava/lang/String;I)V", "getDefaultPort", "()I", "getName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "ktor-http"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final /* data */ class URLProtocol {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final URLProtocol HTTP;
    private static final URLProtocol HTTPS;
    private static final URLProtocol SOCKS;
    private static final URLProtocol WS;
    private static final URLProtocol WSS;
    private static final Map<String, URLProtocol> byName;
    private final int defaultPort;
    private final String name;

    public static /* synthetic */ URLProtocol copy$default(URLProtocol uRLProtocol, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = uRLProtocol.name;
        }
        if ((i2 & 2) != 0) {
            i = uRLProtocol.defaultPort;
        }
        return uRLProtocol.copy(str, i);
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2, reason: from getter */
    public final int getDefaultPort() {
        return this.defaultPort;
    }

    public final URLProtocol copy(String name, int defaultPort) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new URLProtocol(name, defaultPort);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof URLProtocol)) {
            return false;
        }
        URLProtocol uRLProtocol = (URLProtocol) other;
        return Intrinsics.areEqual(this.name, uRLProtocol.name) && this.defaultPort == uRLProtocol.defaultPort;
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + Integer.hashCode(this.defaultPort);
    }

    public String toString() {
        return "URLProtocol(name=" + this.name + ", defaultPort=" + this.defaultPort + ')';
    }

    public URLProtocol(String name, int i) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.defaultPort = i;
        String str = name;
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (!CharsetKt.isLowerCase(str.charAt(i2))) {
                throw new IllegalArgumentException("All characters should be lower case".toString());
            }
        }
    }

    public final int getDefaultPort() {
        return this.defaultPort;
    }

    public final String getName() {
        return this.name;
    }

    /* compiled from: URLProtocol.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0011R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u001d\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00040\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lio/ktor/http/URLProtocol$Companion;", "", "()V", "HTTP", "Lio/ktor/http/URLProtocol;", "getHTTP", "()Lio/ktor/http/URLProtocol;", "HTTPS", "getHTTPS", "SOCKS", "getSOCKS", "WS", "getWS", "WSS", "getWSS", "byName", "", "", "getByName", "()Ljava/util/Map;", "createOrDefault", "name", "ktor-http"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final URLProtocol getHTTP() {
            return URLProtocol.HTTP;
        }

        public final URLProtocol getHTTPS() {
            return URLProtocol.HTTPS;
        }

        public final URLProtocol getWS() {
            return URLProtocol.WS;
        }

        public final URLProtocol getWSS() {
            return URLProtocol.WSS;
        }

        public final URLProtocol getSOCKS() {
            return URLProtocol.SOCKS;
        }

        public final Map<String, URLProtocol> getByName() {
            return URLProtocol.byName;
        }

        public final URLProtocol createOrDefault(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            String lowerCasePreservingASCIIRules = TextKt.toLowerCasePreservingASCIIRules(name);
            URLProtocol uRLProtocol = URLProtocol.INSTANCE.getByName().get(lowerCasePreservingASCIIRules);
            return uRLProtocol == null ? new URLProtocol(lowerCasePreservingASCIIRules, 0) : uRLProtocol;
        }
    }

    static {
        URLProtocol uRLProtocol = new URLProtocol("http", 80);
        HTTP = uRLProtocol;
        URLProtocol uRLProtocol2 = new URLProtocol(TournamentShareDialogURIBuilder.scheme, 443);
        HTTPS = uRLProtocol2;
        URLProtocol uRLProtocol3 = new URLProtocol("ws", 80);
        WS = uRLProtocol3;
        URLProtocol uRLProtocol4 = new URLProtocol("wss", 443);
        WSS = uRLProtocol4;
        URLProtocol uRLProtocol5 = new URLProtocol("socks", WinError.ERROR_CANNOT_DETECT_DRIVER_FAILURE);
        SOCKS = uRLProtocol5;
        List listListOf = CollectionsKt.listOf((Object[]) new URLProtocol[]{uRLProtocol, uRLProtocol2, uRLProtocol3, uRLProtocol4, uRLProtocol5});
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(listListOf, 10)), 16));
        for (Object obj : listListOf) {
            linkedHashMap.put(((URLProtocol) obj).name, obj);
        }
        byName = linkedHashMap;
    }
}
