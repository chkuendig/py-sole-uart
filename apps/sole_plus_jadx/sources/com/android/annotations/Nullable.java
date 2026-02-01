package com.android.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.FIELD})
@Documented
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes3.dex */
public @interface Nullable {
}
