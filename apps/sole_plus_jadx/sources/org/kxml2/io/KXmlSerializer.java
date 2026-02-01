package org.kxml2.io;

import com.android.SdkConstants;
import com.android.utils.XmlUtils;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: classes6.dex */
public class KXmlSerializer implements XmlSerializer {
    private int auto;
    private int depth;
    private String encoding;
    private boolean pending;
    private boolean unicode;
    private Writer writer;
    private String[] elementStack = new String[12];
    private int[] nspCounts = new int[4];
    private String[] nspStack = new String[8];
    private boolean[] indent = new boolean[4];

    private final void check(boolean z) throws IOException {
        if (!this.pending) {
            return;
        }
        int i = this.depth;
        int i2 = i + 1;
        this.depth = i2;
        this.pending = false;
        boolean[] zArr = this.indent;
        if (zArr.length <= i2) {
            boolean[] zArr2 = new boolean[i + 5];
            System.arraycopy(zArr, 0, zArr2, 0, i2);
            this.indent = zArr2;
        }
        boolean[] zArr3 = this.indent;
        int i3 = this.depth;
        zArr3[i3] = zArr3[i3 - 1];
        int i4 = this.nspCounts[i3 - 1];
        while (true) {
            int[] iArr = this.nspCounts;
            int i5 = this.depth;
            if (i4 >= iArr[i5]) {
                if (iArr.length <= i5 + 1) {
                    int[] iArr2 = new int[i5 + 8];
                    System.arraycopy(iArr, 0, iArr2, 0, i5 + 1);
                    this.nspCounts = iArr2;
                }
                int[] iArr3 = this.nspCounts;
                int i6 = this.depth;
                iArr3[i6 + 1] = iArr3[i6];
                this.writer.write(z ? " />" : ">");
                return;
            }
            this.writer.write(32);
            this.writer.write(SdkConstants.XMLNS);
            int i7 = i4 * 2;
            if (!"".equals(this.nspStack[i7])) {
                this.writer.write(58);
                this.writer.write(this.nspStack[i7]);
            } else if ("".equals(getNamespace()) && !"".equals(this.nspStack[i7 + 1])) {
                throw new IllegalStateException("Cannot set default namespace for elements in no namespace");
            }
            this.writer.write("=\"");
            writeEscaped(this.nspStack[i7 + 1], 34);
            this.writer.write(34);
            i4++;
        }
    }

    private final String getPrefix(String str, boolean z, boolean z2) throws IOException {
        int i = this.nspCounts[this.depth + 1] * 2;
        while (true) {
            i -= 2;
            String str2 = null;
            String str3 = "";
            if (i < 0) {
                if (!z2) {
                    return null;
                }
                if (!"".equals(str)) {
                    do {
                        StringBuffer stringBuffer = new StringBuffer("n");
                        int i2 = this.auto;
                        this.auto = i2 + 1;
                        String string = stringBuffer.append(i2).toString();
                        int i3 = (this.nspCounts[this.depth + 1] * 2) - 2;
                        while (true) {
                            if (i3 < 0) {
                                str3 = string;
                                break;
                            }
                            if (string.equals(this.nspStack[i3])) {
                                str3 = null;
                                break;
                            }
                            i3 -= 2;
                        }
                    } while (str3 == null);
                }
                boolean z3 = this.pending;
                this.pending = false;
                setPrefix(str3, str);
                this.pending = z3;
                return str3;
            }
            if (this.nspStack[i + 1].equals(str) && (z || !this.nspStack[i].equals(""))) {
                String str4 = this.nspStack[i];
                int i4 = i + 2;
                while (true) {
                    if (i4 >= this.nspCounts[this.depth + 1] * 2) {
                        str2 = str4;
                        break;
                    }
                    if (this.nspStack[i4].equals(str4)) {
                        break;
                    }
                    i4++;
                }
                if (str2 != null) {
                    return str2;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void writeEscaped(java.lang.String r6, int r7) throws java.io.IOException {
        /*
            r5 = this;
            r0 = 0
        L1:
            int r1 = r6.length()
            if (r0 >= r1) goto L98
            char r1 = r6.charAt(r0)
            r2 = 9
            java.lang.String r3 = "&#"
            if (r1 == r2) goto L79
            r2 = 10
            if (r1 == r2) goto L79
            r2 = 13
            if (r1 == r2) goto L79
            r2 = 34
            if (r1 == r2) goto L40
            r4 = 60
            if (r1 == r4) goto L3b
            r4 = 62
            if (r1 == r4) goto L36
            r4 = 38
            if (r1 == r4) goto L2e
            r4 = 39
            if (r1 == r4) goto L40
            goto L4f
        L2e:
            java.io.Writer r1 = r5.writer
            java.lang.String r2 = "&amp;"
        L32:
            r1.write(r2)
            goto L94
        L36:
            java.io.Writer r1 = r5.writer
            java.lang.String r2 = "&gt;"
            goto L32
        L3b:
            java.io.Writer r1 = r5.writer
            java.lang.String r2 = "&lt;"
            goto L32
        L40:
            if (r1 != r7) goto L4f
            java.io.Writer r3 = r5.writer
            if (r1 != r2) goto L49
            java.lang.String r1 = "&quot;"
            goto L4b
        L49:
            java.lang.String r1 = "&apos;"
        L4b:
            r3.write(r1)
            goto L94
        L4f:
            r2 = 32
            if (r1 < r2) goto L60
            r2 = 64
            if (r1 == r2) goto L60
            r2 = 127(0x7f, float:1.78E-43)
            if (r1 < r2) goto L7c
            boolean r2 = r5.unicode
            if (r2 == 0) goto L60
            goto L7c
        L60:
            java.io.Writer r2 = r5.writer
            java.lang.StringBuffer r4 = new java.lang.StringBuffer
            r4.<init>(r3)
            java.lang.StringBuffer r1 = r4.append(r1)
            java.lang.String r3 = ";"
            java.lang.StringBuffer r1 = r1.append(r3)
        L71:
            java.lang.String r1 = r1.toString()
            r2.write(r1)
            goto L94
        L79:
            r2 = -1
            if (r7 != r2) goto L82
        L7c:
            java.io.Writer r2 = r5.writer
            r2.write(r1)
            goto L94
        L82:
            java.io.Writer r2 = r5.writer
            java.lang.StringBuffer r4 = new java.lang.StringBuffer
            r4.<init>(r3)
            java.lang.StringBuffer r1 = r4.append(r1)
            r3 = 59
            java.lang.StringBuffer r1 = r1.append(r3)
            goto L71
        L94:
            int r0 = r0 + 1
            goto L1
        L98:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.kxml2.io.KXmlSerializer.writeEscaped(java.lang.String, int):void");
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public XmlSerializer attribute(String str, String str2, String str3) throws IOException {
        if (!this.pending) {
            throw new IllegalStateException("illegal position for attribute");
        }
        if (str == null) {
            str = "";
        }
        String prefix = "".equals(str) ? "" : getPrefix(str, false, true);
        this.writer.write(32);
        if (!"".equals(prefix)) {
            this.writer.write(prefix);
            this.writer.write(58);
        }
        this.writer.write(str2);
        this.writer.write(61);
        int i = str3.indexOf(34) != -1 ? 39 : 34;
        this.writer.write(i);
        writeEscaped(str3, i);
        this.writer.write(i);
        return this;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void cdsect(String str) throws IOException {
        check(false);
        this.writer.write(XmlUtils.CDATA_PREFIX);
        this.writer.write(str);
        this.writer.write(XmlUtils.CDATA_SUFFIX);
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void comment(String str) throws IOException {
        check(false);
        this.writer.write(XmlUtils.XML_COMMENT_BEGIN);
        this.writer.write(str);
        this.writer.write(XmlUtils.XML_COMMENT_END);
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void docdecl(String str) throws IOException {
        this.writer.write("<!DOCTYPE");
        this.writer.write(str);
        this.writer.write(">");
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void endDocument() throws IOException {
        while (true) {
            if (this.depth <= 0) {
                flush();
                return;
            } else {
                String[] strArr = this.elementStack;
                endTag(strArr[(r0 * 3) - 3], strArr[(r0 * 3) - 1]);
            }
        }
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public XmlSerializer endTag(String str, String str2) throws IOException {
        if (!this.pending) {
            this.depth--;
        }
        if ((str == null && this.elementStack[this.depth * 3] != null) || ((str != null && !str.equals(this.elementStack[this.depth * 3])) || !this.elementStack[(this.depth * 3) + 2].equals(str2))) {
            throw new IllegalArgumentException(new StringBuffer("</{").append(str).append(SdkConstants.MANIFEST_PLACEHOLDER_SUFFIX).append(str2).append("> does not match start").toString());
        }
        if (this.pending) {
            check(true);
            this.depth--;
        } else {
            if (this.indent[this.depth + 1]) {
                this.writer.write("\r\n");
                for (int i = 0; i < this.depth; i++) {
                    this.writer.write("  ");
                }
            }
            this.writer.write("</");
            String str3 = this.elementStack[(this.depth * 3) + 1];
            if (!"".equals(str3)) {
                this.writer.write(str3);
                this.writer.write(58);
            }
            this.writer.write(str2);
            this.writer.write(62);
        }
        int[] iArr = this.nspCounts;
        int i2 = this.depth;
        iArr[i2 + 1] = iArr[i2];
        return this;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void entityRef(String str) throws IOException {
        check(false);
        this.writer.write(38);
        this.writer.write(str);
        this.writer.write(59);
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void flush() throws IOException {
        check(false);
        this.writer.flush();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public int getDepth() {
        return this.pending ? this.depth + 1 : this.depth;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public boolean getFeature(String str) {
        if ("http://xmlpull.org/v1/doc/features.html#indent-output".equals(str)) {
            return this.indent[this.depth];
        }
        return false;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public String getName() {
        if (getDepth() == 0) {
            return null;
        }
        return this.elementStack[(getDepth() * 3) - 1];
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public String getNamespace() {
        if (getDepth() == 0) {
            return null;
        }
        return this.elementStack[(getDepth() * 3) - 3];
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public String getPrefix(String str, boolean z) {
        try {
            return getPrefix(str, false, z);
        } catch (IOException e) {
            throw new RuntimeException(e.toString());
        }
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public Object getProperty(String str) {
        throw new RuntimeException("Unsupported property");
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void ignorableWhitespace(String str) throws IOException {
        text(str);
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void processingInstruction(String str) throws IOException {
        check(false);
        this.writer.write("<?");
        this.writer.write(str);
        this.writer.write("?>");
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void setFeature(String str, boolean z) {
        if (!"http://xmlpull.org/v1/doc/features.html#indent-output".equals(str)) {
            throw new RuntimeException("Unsupported Feature");
        }
        this.indent[this.depth] = z;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void setOutput(OutputStream outputStream, String str) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException();
        }
        setOutput(str == null ? new OutputStreamWriter(outputStream) : new OutputStreamWriter(outputStream, str));
        this.encoding = str;
        if (str == null || !str.toLowerCase().startsWith("utf")) {
            return;
        }
        this.unicode = true;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void setOutput(Writer writer) {
        this.writer = writer;
        int[] iArr = this.nspCounts;
        iArr[0] = 2;
        iArr[1] = 2;
        String[] strArr = this.nspStack;
        strArr[0] = "";
        strArr[1] = "";
        strArr[2] = "xml";
        strArr[3] = SdkConstants.XML_NAMESPACE_URI;
        this.pending = false;
        this.auto = 0;
        this.depth = 0;
        this.unicode = false;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void setPrefix(String str, String str2) throws IOException {
        check(false);
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        if (str.equals(getPrefix(str2, true, false))) {
            return;
        }
        int[] iArr = this.nspCounts;
        int i = this.depth + 1;
        int i2 = iArr[i];
        iArr[i] = i2 + 1;
        int i3 = i2 << 1;
        String[] strArr = this.nspStack;
        int i4 = i3 + 1;
        if (strArr.length < i4) {
            String[] strArr2 = new String[strArr.length + 16];
            System.arraycopy(strArr, 0, strArr2, 0, i3);
            this.nspStack = strArr2;
        }
        String[] strArr3 = this.nspStack;
        strArr3[i3] = str;
        strArr3[i4] = str2;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void setProperty(String str, Object obj) {
        throw new RuntimeException(new StringBuffer("Unsupported Property:").append(obj).toString());
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void startDocument(String str, Boolean bool) throws IOException {
        this.writer.write("<?xml version='1.0' ");
        if (str != null) {
            this.encoding = str;
            if (str.toLowerCase().startsWith("utf")) {
                this.unicode = true;
            }
        }
        if (this.encoding != null) {
            this.writer.write("encoding='");
            this.writer.write(this.encoding);
            this.writer.write("' ");
        }
        if (bool != null) {
            this.writer.write("standalone='");
            this.writer.write(bool.booleanValue() ? SdkConstants.VALUE_YES : SdkConstants.VALUE_NO);
            this.writer.write("' ");
        }
        this.writer.write("?>");
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public XmlSerializer startTag(String str, String str2) throws IOException {
        check(false);
        if (this.indent[this.depth]) {
            this.writer.write("\r\n");
            for (int i = 0; i < this.depth; i++) {
                this.writer.write("  ");
            }
        }
        int i2 = this.depth * 3;
        String[] strArr = this.elementStack;
        if (strArr.length < i2 + 3) {
            String[] strArr2 = new String[strArr.length + 12];
            System.arraycopy(strArr, 0, strArr2, 0, i2);
            this.elementStack = strArr2;
        }
        String prefix = str == null ? "" : getPrefix(str, true, true);
        if ("".equals(str)) {
            for (int i3 = this.nspCounts[this.depth]; i3 < this.nspCounts[this.depth + 1]; i3++) {
                int i4 = i3 * 2;
                if ("".equals(this.nspStack[i4]) && !"".equals(this.nspStack[i4 + 1])) {
                    throw new IllegalStateException("Cannot set default namespace for elements in no namespace");
                }
            }
        }
        String[] strArr3 = this.elementStack;
        strArr3[i2] = str;
        strArr3[i2 + 1] = prefix;
        strArr3[i2 + 2] = str2;
        this.writer.write(60);
        if (!"".equals(prefix)) {
            this.writer.write(prefix);
            this.writer.write(58);
        }
        this.writer.write(str2);
        this.pending = true;
        return this;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public XmlSerializer text(String str) throws IOException {
        check(false);
        this.indent[this.depth] = false;
        writeEscaped(str, -1);
        return this;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public XmlSerializer text(char[] cArr, int i, int i2) throws IOException {
        text(new String(cArr, i, i2));
        return this;
    }
}
