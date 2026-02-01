package com.android.utils.cxx;

import kotlin.Metadata;

/* compiled from: CxxDiagnosticCode.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/android/utils/cxx/CxxBugDiagnosticCode;", "", "bugNumber", "", "(Ljava/lang/String;II)V", "getBugNumber", "()I", "CMAKE_SERVER_HANDSHAKE_FAILED", "NINJA_BUILD_SCRIPT_AUTHOR_FEEDBACK", "common"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public enum CxxBugDiagnosticCode {
    CMAKE_SERVER_HANDSHAKE_FAILED(194020297),
    NINJA_BUILD_SCRIPT_AUTHOR_FEEDBACK(213607318);

    private final int bugNumber;

    CxxBugDiagnosticCode(int i) {
        this.bugNumber = i;
    }

    public final int getBugNumber() {
        return this.bugNumber;
    }
}
