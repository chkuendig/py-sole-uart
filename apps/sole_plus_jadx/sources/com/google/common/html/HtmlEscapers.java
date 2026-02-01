package com.google.common.html;

import com.android.SdkConstants;
import com.google.common.escape.Escaper;
import com.google.common.escape.Escapers;
import kotlin.text.Typography;

@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public final class HtmlEscapers {
    private static final Escaper HTML_ESCAPER = Escapers.builder().addEscape('\"', SdkConstants.QUOT_ENTITY).addEscape('\'', "&#39;").addEscape(Typography.amp, SdkConstants.AMP_ENTITY).addEscape(Typography.less, SdkConstants.LT_ENTITY).addEscape(Typography.greater, SdkConstants.GT_ENTITY).build();

    public static Escaper htmlEscaper() {
        return HTML_ESCAPER;
    }

    private HtmlEscapers() {
    }
}
