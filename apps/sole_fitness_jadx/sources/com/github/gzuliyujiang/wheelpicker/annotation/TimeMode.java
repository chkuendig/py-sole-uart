package com.github.gzuliyujiang.wheelpicker.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes.dex */
public @interface TimeMode {
    public static final int HOUR_12_HAS_SECOND = 3;
    public static final int HOUR_12_NO_SECOND = 2;
    public static final int HOUR_24_HAS_SECOND = 1;
    public static final int HOUR_24_NO_SECOND = 0;
    public static final int NONE = -1;
}
