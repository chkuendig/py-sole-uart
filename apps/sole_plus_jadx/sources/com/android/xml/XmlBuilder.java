package com.android.xml;

import com.android.SdkConstants;
import kotlin.text.Typography;

/* loaded from: classes3.dex */
public final class XmlBuilder {
    private int indentationLevel;
    private final StringBuilder stringBuilder = new StringBuilder();
    private Construct lastAppendedConstruct = Construct.NULL;

    private enum Construct {
        NULL,
        START_TAG,
        ATTRIBUTE,
        CHARACTER_DATA,
        END_TAG
    }

    public XmlBuilder startTag(String name) {
        int length;
        if (!this.lastAppendedConstruct.equals(Construct.END_TAG) && (length = this.stringBuilder.length()) > 0) {
            this.stringBuilder.replace(length - 1, length, ">\n");
        }
        if (this.indentationLevel != 0) {
            this.stringBuilder.append('\n');
        }
        indent();
        this.stringBuilder.append(Typography.less).append(name).append('\n');
        this.indentationLevel++;
        this.lastAppendedConstruct = Construct.START_TAG;
        return this;
    }

    public XmlBuilder androidAttribute(String name, boolean value) {
        return androidAttribute(name, Boolean.toString(value));
    }

    public XmlBuilder androidAttribute(String name, int value) {
        return androidAttribute(name, Integer.toString(value));
    }

    public XmlBuilder androidAttribute(String name, String value) {
        return attribute("android", name, value);
    }

    public XmlBuilder attribute(String name, String value) {
        return attribute("", name, value);
    }

    public XmlBuilder attribute(String namespacePrefix, String name, String value) {
        indent();
        if (!namespacePrefix.isEmpty()) {
            this.stringBuilder.append(namespacePrefix).append(':');
        }
        this.stringBuilder.append(name).append("=\"").append(value).append("\"\n");
        this.lastAppendedConstruct = Construct.ATTRIBUTE;
        return this;
    }

    public XmlBuilder wrapContent() {
        return withSize(SdkConstants.VALUE_WRAP_CONTENT, SdkConstants.VALUE_WRAP_CONTENT);
    }

    public XmlBuilder matchParent() {
        return withSize(SdkConstants.VALUE_MATCH_PARENT, SdkConstants.VALUE_MATCH_PARENT);
    }

    public XmlBuilder withSize(String width, String height) {
        androidAttribute(SdkConstants.ATTR_LAYOUT_WIDTH, width);
        androidAttribute(SdkConstants.ATTR_LAYOUT_HEIGHT, height);
        return this;
    }

    public XmlBuilder characterData(String data) {
        if (this.lastAppendedConstruct.equals(Construct.START_TAG) || this.lastAppendedConstruct.equals(Construct.ATTRIBUTE)) {
            int length = this.stringBuilder.length();
            this.stringBuilder.replace(length - 1, length, ">\n");
        }
        indent();
        this.stringBuilder.append(data).append('\n');
        this.lastAppendedConstruct = Construct.CHARACTER_DATA;
        return this;
    }

    public XmlBuilder endTag(String name) {
        return endTagImpl(name, (name.endsWith(SdkConstants.MotionSceneTags.LAYOUT) || name.equals(SdkConstants.PreferenceTags.PREFERENCE_CATEGORY)) ? false : true);
    }

    public XmlBuilder seperateEndTag(String name) {
        return endTagImpl(name, false);
    }

    private XmlBuilder endTagImpl(String name, boolean useEmptyElementTag) {
        if (this.lastAppendedConstruct.equals(Construct.START_TAG) || this.lastAppendedConstruct.equals(Construct.ATTRIBUTE)) {
            int length = this.stringBuilder.length();
            if (useEmptyElementTag) {
                this.stringBuilder.deleteCharAt(length - 1);
            } else {
                this.stringBuilder.replace(length - 1, length, ">\n\n");
            }
        }
        this.indentationLevel--;
        if ((this.lastAppendedConstruct.equals(Construct.START_TAG) || this.lastAppendedConstruct.equals(Construct.ATTRIBUTE)) && useEmptyElementTag) {
            this.stringBuilder.append(" />\n");
        } else {
            indent();
            this.stringBuilder.append("</").append(name).append(">\n");
        }
        this.lastAppendedConstruct = Construct.END_TAG;
        return this;
    }

    private void indent() {
        for (int i = 0; i < this.indentationLevel; i++) {
            this.stringBuilder.append("    ");
        }
    }

    public String toString() {
        return this.stringBuilder.toString();
    }
}
