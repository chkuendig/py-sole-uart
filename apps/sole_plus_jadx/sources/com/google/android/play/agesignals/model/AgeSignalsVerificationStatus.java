package com.google.android.play.agesignals.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: com.google.android.play:age-signals@@0.0.2 */
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes4.dex */
public @interface AgeSignalsVerificationStatus {
    public static final int SUPERVISED = 1;
    public static final int SUPERVISED_APPROVAL_DENIED = 3;
    public static final int SUPERVISED_APPROVAL_PENDING = 2;
    public static final int UNKNOWN = 4;
    public static final int VERIFIED = 0;
}
