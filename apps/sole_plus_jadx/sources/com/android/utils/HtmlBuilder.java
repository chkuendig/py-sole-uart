package com.android.utils;

import io.ktor.util.date.GMTDateParser;
import java.awt.Color;
import java.net.URL;
import kotlin.text.Typography;

/* loaded from: classes3.dex */
public class HtmlBuilder {
    private static final boolean USE_DD_LISTS = true;
    private final StringBuilder mStringBuilder;
    private String mTableDataExtra;

    public HtmlBuilder(StringBuilder stringBuilder) {
        this.mStringBuilder = stringBuilder;
    }

    public HtmlBuilder() {
        this.mStringBuilder = new StringBuilder(100);
    }

    public HtmlBuilder openHtmlBody() {
        addHtml("<html><body>");
        return this;
    }

    public HtmlBuilder closeHtmlBody() {
        addHtml("</body></html>");
        return this;
    }

    public HtmlBuilder addHtml(String html) {
        this.mStringBuilder.append(html);
        return this;
    }

    public HtmlBuilder addNbsp() {
        this.mStringBuilder.append("&nbsp;");
        return this;
    }

    public HtmlBuilder addNbsps(int count) {
        for (int i = 0; i < count; i++) {
            addNbsp();
        }
        return this;
    }

    public HtmlBuilder newline() {
        this.mStringBuilder.append("<BR/>");
        return this;
    }

    public HtmlBuilder newlineIfNecessary() {
        if (!SdkUtils.endsWith(this.mStringBuilder, "<BR/>")) {
            this.mStringBuilder.append("<BR/>");
        }
        return this;
    }

    public HtmlBuilder beginNoBr() {
        this.mStringBuilder.append("<NOBR>");
        return this;
    }

    public HtmlBuilder endNoBr() {
        this.mStringBuilder.append("</NOBR>");
        return this;
    }

    public HtmlBuilder addLink(String textBefore, String linkText, String textAfter, String url) {
        if (textBefore != null) {
            add(textBefore);
        }
        addLink(linkText, url);
        if (textAfter != null) {
            add(textAfter);
        }
        return this;
    }

    public HtmlBuilder addLink(String text, String url) {
        int length = text.length();
        int i = 0;
        while (i < length) {
            char cCharAt = text.charAt(i);
            if (!Character.isWhitespace(cCharAt)) {
                break;
            }
            this.mStringBuilder.append(cCharAt);
            i++;
        }
        this.mStringBuilder.append("<A HREF=\"");
        this.mStringBuilder.append(url);
        this.mStringBuilder.append("\">");
        XmlUtils.appendXmlTextValue(this.mStringBuilder, text.trim());
        this.mStringBuilder.append("</A>");
        for (int i2 = length - 1; i2 > i; i2--) {
            char cCharAt2 = text.charAt(i);
            if (Character.isWhitespace(cCharAt2)) {
                this.mStringBuilder.append(cCharAt2);
            }
        }
        return this;
    }

    public HtmlBuilder add(String text) {
        XmlUtils.appendXmlTextValue(this.mStringBuilder, text);
        return this;
    }

    public HtmlBuilder add(String text, int start, int end) {
        XmlUtils.appendXmlTextValue(this.mStringBuilder, text, start, end);
        return this;
    }

    public String getHtml() {
        return this.mStringBuilder.toString();
    }

    public HtmlBuilder beginBold() {
        this.mStringBuilder.append("<B>");
        return this;
    }

    public HtmlBuilder endBold() {
        this.mStringBuilder.append("</B>");
        return this;
    }

    public HtmlBuilder beginUnderline() {
        this.mStringBuilder.append("<U>");
        return this;
    }

    public HtmlBuilder endUnderline() {
        this.mStringBuilder.append("</U>");
        return this;
    }

    public HtmlBuilder coloredText(Color color, String text) {
        beginColor(color);
        add(text);
        endColor();
        return this;
    }

    public HtmlBuilder beginColor(Color color) {
        this.mStringBuilder.append("<FONT color=\"#");
        String hexString = Integer.toHexString(color.getRed());
        String hexString2 = Integer.toHexString(color.getGreen());
        String hexString3 = Integer.toHexString(color.getBlue());
        this.mStringBuilder.append(hexString.length() < 2 ? "0" : "").append(hexString).append(hexString2.length() < 2 ? "0" : "").append(hexString2).append(hexString3.length() >= 2 ? "" : "0").append(hexString3);
        this.mStringBuilder.append("\">");
        return this;
    }

    public HtmlBuilder endColor() {
        this.mStringBuilder.append("</FONT>");
        return this;
    }

    public HtmlBuilder addUnderlined(String text) {
        beginUnderline();
        add(text);
        endUnderline();
        return this;
    }

    public HtmlBuilder addBold(String text) {
        beginBold();
        add(text);
        endBold();
        return this;
    }

    public HtmlBuilder beginItalic() {
        this.mStringBuilder.append("<I>");
        return this;
    }

    public HtmlBuilder endItalic() {
        this.mStringBuilder.append("</I>");
        return this;
    }

    public HtmlBuilder addItalic(String text) {
        beginItalic();
        add(text);
        endItalic();
        return this;
    }

    private HtmlBuilder appendStyle(String cssStyle) {
        if (cssStyle != null) {
            this.mStringBuilder.append(" style=\"");
            this.mStringBuilder.append(cssStyle);
            this.mStringBuilder.append("\"");
        }
        return this;
    }

    public HtmlBuilder beginDiv() {
        return beginDiv(null);
    }

    public HtmlBuilder beginDiv(String cssStyle) {
        this.mStringBuilder.append("<div");
        appendStyle(cssStyle);
        this.mStringBuilder.append(Typography.greater);
        return this;
    }

    public HtmlBuilder endDiv() {
        this.mStringBuilder.append("</div>");
        return this;
    }

    public HtmlBuilder beginParagraph() {
        return beginParagraph(null);
    }

    public HtmlBuilder beginParagraph(String cssStyle) {
        this.mStringBuilder.append("<p");
        appendStyle(cssStyle);
        this.mStringBuilder.append(Typography.greater);
        return this;
    }

    public HtmlBuilder endParagraph() {
        this.mStringBuilder.append("</p>");
        return this;
    }

    public HtmlBuilder beginSpan() {
        return beginSpan(null);
    }

    public HtmlBuilder beginSpan(String cssStyle) {
        this.mStringBuilder.append("<span");
        appendStyle(cssStyle);
        this.mStringBuilder.append(Typography.greater);
        return this;
    }

    public HtmlBuilder beginClassSpan(String cssClasses) {
        this.mStringBuilder.append("<span class=\"");
        this.mStringBuilder.append(cssClasses);
        this.mStringBuilder.append("\">");
        return this;
    }

    public HtmlBuilder beginPre(String styleClass) {
        this.mStringBuilder.append("<pre");
        if (styleClass != null) {
            this.mStringBuilder.append(" class=\"");
            this.mStringBuilder.append(styleClass);
            this.mStringBuilder.append("\"");
        }
        this.mStringBuilder.append(">\n");
        return this;
    }

    public HtmlBuilder endPre() {
        this.mStringBuilder.append("</pre>\n");
        return this;
    }

    public HtmlBuilder endSpan() {
        this.mStringBuilder.append("</span>");
        return this;
    }

    public HtmlBuilder addHeading(String text, String fontColor) {
        this.mStringBuilder.append("<font");
        appendStyle("font-weight:bold; color:" + fontColor + ";");
        this.mStringBuilder.append(">");
        add(text);
        this.mStringBuilder.append("</font>");
        return this;
    }

    public HtmlBuilder beginList() {
        this.mStringBuilder.append("<DL>");
        return this;
    }

    public HtmlBuilder endList() {
        this.mStringBuilder.append("</DL>");
        return this;
    }

    public HtmlBuilder listItem() {
        this.mStringBuilder.append("<DD>");
        this.mStringBuilder.append("-&NBSP;");
        return this;
    }

    public HtmlBuilder addImage(URL url, String altText) {
        String externalForm;
        try {
            externalForm = url.toURI().toURL().toExternalForm();
        } catch (Throwable unused) {
            externalForm = "";
        }
        this.mStringBuilder.append("<img src='");
        this.mStringBuilder.append(externalForm);
        this.mStringBuilder.append("'");
        if (altText != null) {
            this.mStringBuilder.append(" alt=\"");
            this.mStringBuilder.append(altText);
            this.mStringBuilder.append("\"");
        }
        this.mStringBuilder.append(" />");
        return this;
    }

    public HtmlBuilder addIcon(String src) {
        if (src != null) {
            this.mStringBuilder.append("<img src='");
            this.mStringBuilder.append(src);
            this.mStringBuilder.append("' width=16 height=16 border=0 />");
        }
        return this;
    }

    public HtmlBuilder beginTable(String tdExtra) {
        this.mStringBuilder.append("<table>");
        this.mTableDataExtra = tdExtra;
        return this;
    }

    public HtmlBuilder beginTable() {
        return beginTable(null);
    }

    public HtmlBuilder endTable() {
        this.mStringBuilder.append("</table>");
        return this;
    }

    public HtmlBuilder beginTableRow() {
        this.mStringBuilder.append("<tr>");
        return this;
    }

    public HtmlBuilder endTableRow() {
        this.mStringBuilder.append("</tr>");
        return this;
    }

    public HtmlBuilder addTableRow(boolean isHeader, String... columns) {
        if (columns != null && columns.length != 0) {
            String str = "t" + (isHeader ? GMTDateParser.HOURS : GMTDateParser.DAY_OF_MONTH);
            beginTableRow();
            for (String str2 : columns) {
                this.mStringBuilder.append(Typography.less);
                this.mStringBuilder.append(str);
                if (this.mTableDataExtra != null) {
                    this.mStringBuilder.append(' ');
                    this.mStringBuilder.append(this.mTableDataExtra);
                }
                this.mStringBuilder.append(Typography.greater);
                this.mStringBuilder.append(str2);
                this.mStringBuilder.append("</");
                this.mStringBuilder.append(str);
                this.mStringBuilder.append(Typography.greater);
            }
            endTableRow();
        }
        return this;
    }

    public HtmlBuilder addTableRow(String... columns) {
        return addTableRow(false, columns);
    }

    public StringBuilder getStringBuilder() {
        return this.mStringBuilder;
    }
}
