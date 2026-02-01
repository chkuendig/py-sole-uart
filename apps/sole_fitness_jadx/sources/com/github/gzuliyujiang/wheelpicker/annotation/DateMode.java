package com.github.gzuliyujiang.wheelpicker.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes.dex */
public @interface DateMode {
    public static final int MONTH_DAY = 2;
    public static final int NONE = -1;
    public static final int YEAR_MONTH = 1;
    public static final int YEAR_MONTH_DAY = 0;
}
