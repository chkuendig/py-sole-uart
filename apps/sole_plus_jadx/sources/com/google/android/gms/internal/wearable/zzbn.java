package com.google.android.gms.internal.wearable;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
public final class zzbn extends IOException {
    zzbn() {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.");
    }

    zzbn(String str, Throwable th) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat(String.valueOf(str)), th);
    }

    zzbn(Throwable th) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
    }
}
