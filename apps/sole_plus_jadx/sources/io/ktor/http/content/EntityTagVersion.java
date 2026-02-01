package io.ktor.http.content;

import io.ktor.http.ApplicationResponsePropertiesKt;
import io.ktor.http.HeaderValue;
import io.ktor.http.HeaderValueWithParametersKt;
import io.ktor.http.Headers;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpHeaderValueParserKt;
import io.ktor.http.HttpHeaders;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.slf4j.Marker;

/* compiled from: Versions.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\b\u0086\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\u000e\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0000J\u0014\u0010\u001c\u001a\u00020\u00112\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00000\u001eJ\u0014\u0010\u001f\u001a\u00020\u00112\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00000\u001eJ\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006#"}, d2 = {"Lio/ktor/http/content/EntityTagVersion;", "Lio/ktor/http/content/Version;", "etag", "", "weak", "", "(Ljava/lang/String;Z)V", "getEtag", "()Ljava/lang/String;", "normalized", "getWeak", "()Z", "appendHeadersTo", "", "builder", "Lio/ktor/http/HeadersBuilder;", "check", "Lio/ktor/http/content/VersionCheckResult;", "requestHeaders", "Lio/ktor/http/Headers;", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "match", "givenMatchEtags", "", "noneMatch", "givenNoneMatchEtags", "toString", "Companion", "ktor-http"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final /* data */ class EntityTagVersion implements Version {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final EntityTagVersion STAR = new EntityTagVersion(Marker.ANY_MARKER, false);
    private final String etag;
    private final String normalized;
    private final boolean weak;

    public static /* synthetic */ EntityTagVersion copy$default(EntityTagVersion entityTagVersion, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = entityTagVersion.etag;
        }
        if ((i & 2) != 0) {
            z = entityTagVersion.weak;
        }
        return entityTagVersion.copy(str, z);
    }

    /* renamed from: component1, reason: from getter */
    public final String getEtag() {
        return this.etag;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getWeak() {
        return this.weak;
    }

    public final EntityTagVersion copy(String etag, boolean weak) {
        Intrinsics.checkNotNullParameter(etag, "etag");
        return new EntityTagVersion(etag, weak);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EntityTagVersion)) {
            return false;
        }
        EntityTagVersion entityTagVersion = (EntityTagVersion) other;
        return Intrinsics.areEqual(this.etag, entityTagVersion.etag) && this.weak == entityTagVersion.weak;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iHashCode = this.etag.hashCode() * 31;
        boolean z = this.weak;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return iHashCode + i;
    }

    public String toString() {
        return "EntityTagVersion(etag=" + this.etag + ", weak=" + this.weak + ')';
    }

    public EntityTagVersion(String etag, boolean z) {
        Intrinsics.checkNotNullParameter(etag, "etag");
        this.etag = etag;
        this.weak = z;
        this.normalized = (Intrinsics.areEqual(etag, Marker.ANY_MARKER) || StringsKt.startsWith$default(etag, "\"", false, 2, (Object) null)) ? etag : HeaderValueWithParametersKt.quote(etag);
        int length = etag.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = this.etag.charAt(i);
            if ((Intrinsics.compare((int) cCharAt, 32) <= 0 || cCharAt == '\"') && i != 0 && i != StringsKt.getLastIndex(this.etag)) {
                throw new IllegalArgumentException(("Character '" + cCharAt + "' is not allowed in entity-tag.").toString());
            }
        }
    }

    public final String getEtag() {
        return this.etag;
    }

    public final boolean getWeak() {
        return this.weak;
    }

    @Override // io.ktor.http.content.Version
    public VersionCheckResult check(Headers requestHeaders) {
        List<EntityTagVersion> list;
        VersionCheckResult versionCheckResultMatch;
        List<EntityTagVersion> list2;
        VersionCheckResult versionCheckResultNoneMatch;
        Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
        String str = requestHeaders.get(HttpHeaders.INSTANCE.getIfNoneMatch());
        if (str != null && (list2 = INSTANCE.parse(str)) != null && (versionCheckResultNoneMatch = noneMatch(list2)) != VersionCheckResult.OK) {
            return versionCheckResultNoneMatch;
        }
        String str2 = requestHeaders.get(HttpHeaders.INSTANCE.getIfMatch());
        return (str2 == null || (list = INSTANCE.parse(str2)) == null || (versionCheckResultMatch = match(list)) == VersionCheckResult.OK) ? VersionCheckResult.OK : versionCheckResultMatch;
    }

    public final boolean match(EntityTagVersion other) {
        Intrinsics.checkNotNullParameter(other, "other");
        EntityTagVersion entityTagVersion = STAR;
        if (Intrinsics.areEqual(this, entityTagVersion) || Intrinsics.areEqual(other, entityTagVersion)) {
            return true;
        }
        return Intrinsics.areEqual(this.normalized, other.normalized);
    }

    public final VersionCheckResult noneMatch(List<EntityTagVersion> givenNoneMatchEtags) {
        Intrinsics.checkNotNullParameter(givenNoneMatchEtags, "givenNoneMatchEtags");
        if (givenNoneMatchEtags.contains(STAR)) {
            return VersionCheckResult.OK;
        }
        List<EntityTagVersion> list = givenNoneMatchEtags;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (match((EntityTagVersion) it.next())) {
                    return VersionCheckResult.NOT_MODIFIED;
                }
            }
        }
        return VersionCheckResult.OK;
    }

    public final VersionCheckResult match(List<EntityTagVersion> givenMatchEtags) {
        Intrinsics.checkNotNullParameter(givenMatchEtags, "givenMatchEtags");
        if (!givenMatchEtags.isEmpty() && !givenMatchEtags.contains(STAR)) {
            Iterator<EntityTagVersion> it = givenMatchEtags.iterator();
            while (it.hasNext()) {
                if (match(it.next())) {
                    return VersionCheckResult.OK;
                }
            }
            return VersionCheckResult.PRECONDITION_FAILED;
        }
        return VersionCheckResult.OK;
    }

    @Override // io.ktor.http.content.Version
    public void appendHeadersTo(HeadersBuilder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        ApplicationResponsePropertiesKt.etag(builder, this.normalized);
    }

    /* compiled from: Versions.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\nR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lio/ktor/http/content/EntityTagVersion$Companion;", "", "()V", "STAR", "Lio/ktor/http/content/EntityTagVersion;", "getSTAR", "()Lio/ktor/http/content/EntityTagVersion;", "parse", "", "headerValue", "", "parseSingle", "value", "ktor-http"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final EntityTagVersion getSTAR() {
            return EntityTagVersion.STAR;
        }

        public final List<EntityTagVersion> parse(String headerValue) {
            Intrinsics.checkNotNullParameter(headerValue, "headerValue");
            List<HeaderValue> headerValue2 = HttpHeaderValueParserKt.parseHeaderValue(headerValue);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(headerValue2, 10));
            for (HeaderValue headerValue3 : headerValue2) {
                if (headerValue3.getQuality() != 1.0d) {
                    throw new IllegalStateException(("entity-tag quality parameter is not allowed: " + headerValue3.getQuality() + '.').toString());
                }
                if (!headerValue3.getParams().isEmpty()) {
                    throw new IllegalStateException(("entity-tag parameters are not allowed: " + headerValue3.getParams() + '.').toString());
                }
                arrayList.add(EntityTagVersion.INSTANCE.parseSingle(headerValue3.getValue()));
            }
            return arrayList;
        }

        public final EntityTagVersion parseSingle(String value) {
            boolean z;
            Intrinsics.checkNotNullParameter(value, "value");
            if (Intrinsics.areEqual(value, Marker.ANY_MARKER)) {
                return getSTAR();
            }
            if (StringsKt.startsWith$default(value, "W/", false, 2, (Object) null)) {
                value = StringsKt.drop(value, 2);
                z = true;
            } else {
                z = false;
            }
            if (!StringsKt.startsWith$default(value, "\"", false, 2, (Object) null)) {
                value = HeaderValueWithParametersKt.quote(value);
            }
            return new EntityTagVersion(value, z);
        }
    }
}
