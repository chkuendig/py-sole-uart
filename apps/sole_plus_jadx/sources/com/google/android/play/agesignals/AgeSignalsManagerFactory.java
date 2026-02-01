package com.google.android.play.agesignals;

import android.content.Context;

/* compiled from: com.google.android.play:age-signals@@0.0.2 */
/* loaded from: classes4.dex */
public class AgeSignalsManagerFactory {
    private AgeSignalsManagerFactory() {
    }

    public static AgeSignalsManager create(Context context) {
        return new zzb(new zzg(context));
    }
}
