package com.google.android.gms.dependencies;

import com.android.SdkConstants;
import com.facebook.internal.ServerProtocol;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: Versions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/google/android/gms/dependencies/Version;", "", "rawString", "", "trimmedString", "(Ljava/lang/String;Ljava/lang/String;)V", "getRawString", "()Ljava/lang/String;", "getTrimmedString", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "strict-version-matcher-plugin"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final /* data */ class Version {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String rawString;
    private final String trimmedString;

    public static /* synthetic */ Version copy$default(Version version, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = version.rawString;
        }
        if ((i & 2) != 0) {
            str2 = version.trimmedString;
        }
        return version.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getRawString() {
        return this.rawString;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTrimmedString() {
        return this.trimmedString;
    }

    public final Version copy(String rawString, String trimmedString) {
        Intrinsics.checkNotNullParameter(rawString, "rawString");
        Intrinsics.checkNotNullParameter(trimmedString, "trimmedString");
        return new Version(rawString, trimmedString);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Version)) {
            return false;
        }
        Version version = (Version) other;
        return Intrinsics.areEqual(this.rawString, version.rawString) && Intrinsics.areEqual(this.trimmedString, version.trimmedString);
    }

    public int hashCode() {
        String str = this.rawString;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.trimmedString;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "Version(rawString=" + this.rawString + ", trimmedString=" + this.trimmedString + ")";
    }

    /* compiled from: Versions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/google/android/gms/dependencies/Version$Companion;", "", "()V", "fromString", "Lcom/google/android/gms/dependencies/Version;", ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, "", "strict-version-matcher-plugin"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Version fromString(String version) {
            if (version == null) {
                return null;
            }
            return new Version(version, (String) StringsKt.split$default((CharSequence) version, new String[]{SdkConstants.RES_QUALIFIER_SEP}, false, 0, 6, (Object) null).get(0));
        }
    }

    public Version(String rawString, String trimmedString) {
        Intrinsics.checkNotNullParameter(rawString, "rawString");
        Intrinsics.checkNotNullParameter(trimmedString, "trimmedString");
        this.rawString = rawString;
        this.trimmedString = trimmedString;
    }

    public final String getRawString() {
        return this.rawString;
    }

    public final String getTrimmedString() {
        return this.trimmedString;
    }
}
