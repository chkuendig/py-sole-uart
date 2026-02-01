package com.android.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PACKAGE, ElementType.TYPE})
@Documented
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes3.dex */
public @interface NonNullByDefault {
}
