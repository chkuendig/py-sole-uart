package com.google.android.gms.dependencies;

import com.facebook.internal.ServerProtocol;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: VersionEvaluation.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003\t\n\u000bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\f"}, d2 = {"Lcom/google/android/gms/dependencies/VersionEvaluators;", "", "()V", "getEvaluator", "Lcom/google/android/gms/dependencies/VersionEvaluator;", "versionString", "", "enableStrictMatching", "", "AlwaysCompatibleEvaluator", "ExactVersionEvaluator", "SemVerVersionEvaluator", "strict-version-matcher-plugin"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class VersionEvaluators {
    public static final VersionEvaluators INSTANCE = new VersionEvaluators();

    /* compiled from: VersionEvaluation.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/google/android/gms/dependencies/VersionEvaluators$AlwaysCompatibleEvaluator;", "Lcom/google/android/gms/dependencies/VersionEvaluator;", "()V", "isCompatible", "", ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, "", "strict-version-matcher-plugin"}, k = 1, mv = {1, 4, 0})
    public static final class AlwaysCompatibleEvaluator implements VersionEvaluator {
        @Override // com.google.android.gms.dependencies.VersionEvaluator
        public boolean isCompatible(String version) {
            Intrinsics.checkNotNullParameter(version, "version");
            return true;
        }
    }

    private VersionEvaluators() {
    }

    public final VersionEvaluator getEvaluator(String versionString, boolean enableStrictMatching) {
        AlwaysCompatibleEvaluator alwaysCompatibleEvaluator;
        Intrinsics.checkNotNullParameter(versionString, "versionString");
        String str = versionString;
        boolean z = StringsKt.indexOf$default((CharSequence) str, ",", 0, false, 6, (Object) null) > 0 || StringsKt.indexOf$default((CharSequence) str, ")", 0, false, 6, (Object) null) > 0 || StringsKt.indexOf$default((CharSequence) str, "(", 0, false, 6, (Object) null) > 0;
        if (enableStrictMatching && StringsKt.startsWith$default(versionString, "[", false, 2, (Object) null) && StringsKt.endsWith$default(versionString, "]", false, 2, (Object) null)) {
            String strSubstring = versionString.substring(1, versionString.length() - 1);
            Intrinsics.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return new ExactVersionEvaluator(strSubstring);
        }
        if (!enableStrictMatching || !z) {
            alwaysCompatibleEvaluator = new AlwaysCompatibleEvaluator();
        } else {
            alwaysCompatibleEvaluator = new AlwaysCompatibleEvaluator();
        }
        return alwaysCompatibleEvaluator;
    }

    /* compiled from: VersionEvaluation.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0003H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u000b"}, d2 = {"Lcom/google/android/gms/dependencies/VersionEvaluators$ExactVersionEvaluator;", "Lcom/google/android/gms/dependencies/VersionEvaluator;", "versionString", "", "(Ljava/lang/String;)V", "getVersionString$strict_version_matcher_plugin", "()Ljava/lang/String;", "setVersionString$strict_version_matcher_plugin", "isCompatible", "", ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, "strict-version-matcher-plugin"}, k = 1, mv = {1, 4, 0})
    public static final class ExactVersionEvaluator implements VersionEvaluator {
        private String versionString;

        public ExactVersionEvaluator(String versionString) {
            Intrinsics.checkNotNullParameter(versionString, "versionString");
            this.versionString = versionString;
        }

        /* renamed from: getVersionString$strict_version_matcher_plugin, reason: from getter */
        public final String getVersionString() {
            return this.versionString;
        }

        public final void setVersionString$strict_version_matcher_plugin(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.versionString = str;
        }

        @Override // com.google.android.gms.dependencies.VersionEvaluator
        public boolean isCompatible(String version) {
            Intrinsics.checkNotNullParameter(version, "version");
            return Intrinsics.areEqual(version, this.versionString);
        }
    }

    /* compiled from: VersionEvaluation.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0003H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/google/android/gms/dependencies/VersionEvaluators$SemVerVersionEvaluator;", "Lcom/google/android/gms/dependencies/VersionEvaluator;", "versionString", "", "(Ljava/lang/String;)V", "versionInfo", "Lcom/google/android/gms/dependencies/SemVerInfo;", "getVersionInfo$strict_version_matcher_plugin", "()Lcom/google/android/gms/dependencies/SemVerInfo;", "setVersionInfo$strict_version_matcher_plugin", "(Lcom/google/android/gms/dependencies/SemVerInfo;)V", "isCompatible", "", ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, "strict-version-matcher-plugin"}, k = 1, mv = {1, 4, 0})
    public static final class SemVerVersionEvaluator implements VersionEvaluator {
        private SemVerInfo versionInfo;

        public SemVerVersionEvaluator(String versionString) {
            Intrinsics.checkNotNullParameter(versionString, "versionString");
            this.versionInfo = SemVerInfo.INSTANCE.parseString(versionString);
        }

        /* renamed from: getVersionInfo$strict_version_matcher_plugin, reason: from getter */
        public final SemVerInfo getVersionInfo() {
            return this.versionInfo;
        }

        public final void setVersionInfo$strict_version_matcher_plugin(SemVerInfo semVerInfo) {
            Intrinsics.checkNotNullParameter(semVerInfo, "<set-?>");
            this.versionInfo = semVerInfo;
        }

        @Override // com.google.android.gms.dependencies.VersionEvaluator
        public boolean isCompatible(String version) {
            Intrinsics.checkNotNullParameter(version, "version");
            SemVerInfo string = SemVerInfo.INSTANCE.parseString(version);
            return string.getMajor() == this.versionInfo.getMajor() && string.getMinor() >= this.versionInfo.getMinor();
        }
    }
}
