package com.android.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
@Deprecated
/* loaded from: classes3.dex */
public @interface VisibleForTesting {

    public enum Visibility {
        PROTECTED,
        PACKAGE,
        PRIVATE
    }

    Visibility visibility() default Visibility.PRIVATE;
}
