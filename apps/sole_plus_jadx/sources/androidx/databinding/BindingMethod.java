package androidx.databinding;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.ANNOTATION_TYPE})
/* loaded from: classes2.dex */
public @interface BindingMethod {
    String attribute();

    String method();

    Class type();
}
