package com.google.common.xml;

import com.android.SdkConstants;
import com.google.common.escape.Escaper;
import com.google.common.escape.Escapers;
import kotlin.text.Typography;
import okio.Utf8;

@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public class XmlEscapers {
    private static final char MAX_ASCII_CONTROL_CHAR = 31;
    private static final char MIN_ASCII_CONTROL_CHAR = 0;
    private static final Escaper XML_ATTRIBUTE_ESCAPER;
    private static final Escaper XML_CONTENT_ESCAPER;
    private static final Escaper XML_ESCAPER;

    private XmlEscapers() {
    }

    public static Escaper xmlContentEscaper() {
        return XML_CONTENT_ESCAPER;
    }

    public static Escaper xmlAttributeEscaper() {
        return XML_ATTRIBUTE_ESCAPER;
    }

    static {
        Escapers.Builder builder = Escapers.builder();
        builder.setSafeRange((char) 0, Utf8.REPLACEMENT_CHARACTER);
        builder.setUnsafeReplacement("�");
        for (char c = 0; c <= 31; c = (char) (c + 1)) {
            if (c != '\t' && c != '\n' && c != '\r') {
                builder.addEscape(c, "�");
            }
        }
        builder.addEscape(Typography.amp, SdkConstants.AMP_ENTITY);
        builder.addEscape(Typography.less, SdkConstants.LT_ENTITY);
        builder.addEscape(Typography.greater, SdkConstants.GT_ENTITY);
        XML_CONTENT_ESCAPER = builder.build();
        builder.addEscape('\'', SdkConstants.APOS_ENTITY);
        builder.addEscape('\"', SdkConstants.QUOT_ENTITY);
        XML_ESCAPER = builder.build();
        builder.addEscape('\t', "&#x9;");
        builder.addEscape('\n', SdkConstants.NEWLINE_ENTITY);
        builder.addEscape('\r', "&#xD;");
        XML_ATTRIBUTE_ESCAPER = builder.build();
    }
}
