package org.kxml2.wap;

import com.android.SdkConstants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.Hashtable;
import java.util.Vector;
import kotlin.text.Typography;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes6.dex */
public class WbxmlParser implements XmlPullParser {
    static final String HEX_DIGITS = "0123456789abcdef";
    private static final String ILLEGAL_TYPE = "Wrong event type";
    private static final String UNEXPECTED_EOF = "Unexpected EOF";
    public static final int WAP_EXTENSION = 64;
    private String[] attrStartTable;
    private String[] attrValueTable;
    private int attributeCount;
    private boolean degenerated;
    private int depth;
    private String encoding;
    private InputStream in;
    private boolean isWhitespace;
    private String name;
    private String namespace;
    private String prefix;
    private boolean processNsp;
    private int publicIdentifierId;
    private byte[] stringTable;
    private String[] tagTable;
    private String text;
    private int type;
    private int version;
    private int wapCode;
    private Object wapExtensionData;
    private int TAG_TABLE = 0;
    private int ATTR_START_TABLE = 1;
    private int ATTR_VALUE_TABLE = 2;
    private Hashtable cacheStringTable = null;
    private String[] elementStack = new String[16];
    private String[] nspStack = new String[8];
    private int[] nspCounts = new int[4];
    private String[] attributes = new String[16];
    private int nextId = -2;
    private Vector tables = new Vector();

    private final boolean adjustNsp() throws XmlPullParserException {
        int i;
        String strSubstring;
        int i2 = 0;
        boolean z = false;
        while (true) {
            i = this.attributeCount;
            if (i2 >= (i << 2)) {
                break;
            }
            String str = this.attributes[i2 + 2];
            int iIndexOf = str.indexOf(58);
            if (iIndexOf != -1) {
                String strSubstring2 = str.substring(0, iIndexOf);
                strSubstring = str.substring(iIndexOf + 1);
                str = strSubstring2;
            } else if (str.equals(SdkConstants.XMLNS)) {
                strSubstring = null;
            } else {
                i2 += 4;
            }
            if (str.equals(SdkConstants.XMLNS)) {
                int[] iArr = this.nspCounts;
                int i3 = this.depth;
                int i4 = iArr[i3];
                iArr[i3] = i4 + 1;
                int i5 = i4 << 1;
                String[] strArrEnsureCapacity = ensureCapacity(this.nspStack, i5 + 2);
                this.nspStack = strArrEnsureCapacity;
                strArrEnsureCapacity[i5] = strSubstring;
                String[] strArr = this.attributes;
                int i6 = i2 + 3;
                strArrEnsureCapacity[i5 + 1] = strArr[i6];
                if (strSubstring != null && strArr[i6].equals("")) {
                    exception("illegal empty namespace");
                }
                String[] strArr2 = this.attributes;
                int i7 = this.attributeCount - 1;
                this.attributeCount = i7;
                System.arraycopy(strArr2, i2 + 4, strArr2, i2, (i7 << 2) - i2);
                i2 -= 4;
            } else {
                z = true;
            }
            i2 += 4;
        }
        if (z) {
            for (int i8 = (i << 2) - 4; i8 >= 0; i8 -= 4) {
                int i9 = i8 + 2;
                String str2 = this.attributes[i9];
                int iIndexOf2 = str2.indexOf(58);
                if (iIndexOf2 == 0) {
                    throw new RuntimeException(new StringBuffer("illegal attribute name: ").append(str2).append(" at ").append(this).toString());
                }
                if (iIndexOf2 != -1) {
                    String strSubstring3 = str2.substring(0, iIndexOf2);
                    String strSubstring4 = str2.substring(iIndexOf2 + 1);
                    String namespace = getNamespace(strSubstring3);
                    if (namespace == null) {
                        throw new RuntimeException(new StringBuffer("Undefined Prefix: ").append(strSubstring3).append(" in ").append(this).toString());
                    }
                    String[] strArr3 = this.attributes;
                    strArr3[i8] = namespace;
                    strArr3[i8 + 1] = strSubstring3;
                    strArr3[i9] = strSubstring4;
                    for (int i10 = (this.attributeCount << 2) - 4; i10 > i8; i10 -= 4) {
                        if (strSubstring4.equals(this.attributes[i10 + 2]) && namespace.equals(this.attributes[i10])) {
                            exception(new StringBuffer("Duplicate Attribute: {").append(namespace).append(SdkConstants.MANIFEST_PLACEHOLDER_SUFFIX).append(strSubstring4).toString());
                        }
                    }
                }
            }
        }
        int iIndexOf3 = this.name.indexOf(58);
        if (iIndexOf3 == 0) {
            exception(new StringBuffer("illegal tag name: ").append(this.name).toString());
        } else if (iIndexOf3 != -1) {
            this.prefix = this.name.substring(0, iIndexOf3);
            this.name = this.name.substring(iIndexOf3 + 1);
        }
        String namespace2 = getNamespace(this.prefix);
        this.namespace = namespace2;
        if (namespace2 == null) {
            if (this.prefix != null) {
                exception(new StringBuffer("undefined prefix: ").append(this.prefix).toString());
            }
            this.namespace = "";
        }
        return z;
    }

    private final String[] ensureCapacity(String[] strArr, int i) {
        if (strArr.length >= i) {
            return strArr;
        }
        String[] strArr2 = new String[i + 16];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        return strArr2;
    }

    private final void exception(String str) throws XmlPullParserException {
        throw new XmlPullParserException(str, this, null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void nextImpl() throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r4 = this;
            int r0 = r4.type
            r1 = 1
            r2 = 3
            if (r0 != r2) goto Lb
            int r0 = r4.depth
            int r0 = r0 - r1
            r4.depth = r0
        Lb:
            boolean r0 = r4.degenerated
            if (r0 == 0) goto L15
            r4.type = r2
            r0 = 0
            r4.degenerated = r0
            return
        L15:
            r0 = 0
            r4.text = r0
            r4.prefix = r0
            r4.name = r0
        L1c:
            int r0 = r4.peekId()
            r3 = -2
            r4.nextId = r3
            if (r0 != 0) goto L2d
            int r0 = r4.readByte()
            r4.selectPage(r0, r1)
            goto L1c
        L2d:
            r3 = -1
            if (r0 == r3) goto Lab
            r3 = 2
            if (r0 == r1) goto L93
            if (r0 == r3) goto L6a
            r1 = 4
            if (r0 == r2) goto L61
            switch(r0) {
                case 64: goto L54;
                case 65: goto L54;
                case 66: goto L54;
                case 67: goto L4c;
                default: goto L3b;
            }
        L3b:
            switch(r0) {
                case 128: goto L54;
                case 129: goto L54;
                case 130: goto L54;
                case 131: goto L45;
                default: goto L3e;
            }
        L3e:
            switch(r0) {
                case 192: goto L54;
                case 193: goto L54;
                case 194: goto L54;
                case 195: goto L54;
                default: goto L41;
            }
        L41:
            r4.parseElement(r0)
            goto Lad
        L45:
            r4.type = r1
            java.lang.String r0 = r4.readStrT()
            goto L67
        L4c:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r1 = "PI curr. not supp."
            r0.<init>(r1)
            throw r0
        L54:
            r1 = 64
            r4.type = r1
            r4.wapCode = r0
            java.lang.Object r0 = r4.parseWapExtension(r0)
            r4.wapExtensionData = r0
            goto Lad
        L61:
            r4.type = r1
            java.lang.String r0 = r4.readStrI()
        L67:
            r4.text = r0
            goto Lad
        L6a:
            r0 = 6
            r4.type = r0
            int r0 = r4.readInt()
            char r0 = (char) r0
            java.lang.StringBuffer r1 = new java.lang.StringBuffer
            java.lang.String r2 = ""
            r1.<init>(r2)
            java.lang.StringBuffer r1 = r1.append(r0)
            java.lang.String r1 = r1.toString()
            r4.text = r1
            java.lang.StringBuffer r1 = new java.lang.StringBuffer
            java.lang.String r2 = "#"
            r1.<init>(r2)
            java.lang.StringBuffer r0 = r1.append(r0)
            java.lang.String r0 = r0.toString()
            goto La8
        L93:
            int r0 = r4.depth
            int r0 = r0 - r1
            int r0 = r0 << r3
            r4.type = r2
            java.lang.String[] r1 = r4.elementStack
            r2 = r1[r0]
            r4.namespace = r2
            int r2 = r0 + 1
            r2 = r1[r2]
            r4.prefix = r2
            int r0 = r0 + r3
            r0 = r1[r0]
        La8:
            r4.name = r0
            goto Lad
        Lab:
            r4.type = r1
        Lad:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.kxml2.wap.WbxmlParser.nextImpl():void");
    }

    private int peekId() throws IOException {
        if (this.nextId == -2) {
            this.nextId = this.in.read();
        }
        return this.nextId;
    }

    private void selectPage(int i, boolean z) throws XmlPullParserException {
        if (this.tables.size() == 0 && i == 0) {
            return;
        }
        int i2 = i * 3;
        if (i2 > this.tables.size()) {
            exception(new StringBuffer("Code Page ").append(i).append(" undefined!").toString());
        }
        Vector vector = this.tables;
        if (z) {
            this.tagTable = (String[]) vector.elementAt(i2 + this.TAG_TABLE);
        } else {
            this.attrStartTable = (String[]) vector.elementAt(this.ATTR_START_TABLE + i2);
            this.attrValueTable = (String[]) this.tables.elementAt(i2 + this.ATTR_VALUE_TABLE);
        }
    }

    private final void setTable(int i, int i2, String[] strArr) {
        if (this.stringTable != null) {
            throw new RuntimeException("setXxxTable must be called before setInput!");
        }
        while (true) {
            int i3 = i * 3;
            if (this.tables.size() >= i3 + 3) {
                this.tables.setElementAt(strArr, i3 + i2);
                return;
            }
            this.tables.addElement(null);
        }
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public void defineEntityReplacementText(String str, String str2) throws XmlPullParserException {
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public int getAttributeCount() {
        return this.attributeCount;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getAttributeName(int i) {
        if (i < this.attributeCount) {
            return this.attributes[(i << 2) + 2];
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getAttributeNamespace(int i) {
        if (i < this.attributeCount) {
            return this.attributes[i << 2];
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getAttributePrefix(int i) {
        if (i < this.attributeCount) {
            return this.attributes[(i << 2) + 1];
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getAttributeType(int i) {
        return "CDATA";
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getAttributeValue(int i) {
        if (i < this.attributeCount) {
            return this.attributes[(i << 2) + 3];
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getAttributeValue(String str, String str2) {
        for (int i = (this.attributeCount << 2) - 4; i >= 0; i -= 4) {
            if (this.attributes[i + 2].equals(str2) && (str == null || this.attributes[i].equals(str))) {
                return this.attributes[i + 3];
            }
        }
        return null;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public int getColumnNumber() {
        return -1;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public int getDepth() {
        return this.depth;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public int getEventType() throws XmlPullParserException {
        return this.type;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public boolean getFeature(String str) {
        if (XmlPullParser.FEATURE_PROCESS_NAMESPACES.equals(str)) {
            return this.processNsp;
        }
        return false;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getInputEncoding() {
        return this.encoding;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public int getLineNumber() {
        return -1;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getName() {
        return this.name;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getNamespace() {
        return this.namespace;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getNamespace(String str) {
        if ("xml".equals(str)) {
            return SdkConstants.XML_NAMESPACE_URI;
        }
        if (SdkConstants.XMLNS.equals(str)) {
            return SdkConstants.XMLNS_URI;
        }
        for (int namespaceCount = (getNamespaceCount(this.depth) << 1) - 2; namespaceCount >= 0; namespaceCount -= 2) {
            String[] strArr = this.nspStack;
            if (str == null) {
                if (strArr[namespaceCount] == null) {
                    return strArr[namespaceCount + 1];
                }
            } else if (str.equals(strArr[namespaceCount])) {
                return this.nspStack[namespaceCount + 1];
            }
        }
        return null;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public int getNamespaceCount(int i) {
        if (i <= this.depth) {
            return this.nspCounts[i];
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getNamespacePrefix(int i) {
        return this.nspStack[i << 1];
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getNamespaceUri(int i) {
        return this.nspStack[(i << 1) + 1];
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getPositionDescription() {
        String text;
        StringBuffer stringBuffer = new StringBuffer(this.type < XmlPullParser.TYPES.length ? XmlPullParser.TYPES[this.type] : "unknown");
        stringBuffer.append(' ');
        int i = this.type;
        if (i == 2 || i == 3) {
            if (this.degenerated) {
                stringBuffer.append("(empty) ");
            }
            stringBuffer.append(Typography.less);
            if (this.type == 3) {
                stringBuffer.append('/');
            }
            if (this.prefix != null) {
                stringBuffer.append(new StringBuffer("{").append(this.namespace).append(SdkConstants.MANIFEST_PLACEHOLDER_SUFFIX).append(this.prefix).append(":").toString());
            }
            stringBuffer.append(this.name);
            int i2 = this.attributeCount << 2;
            for (int i3 = 0; i3 < i2; i3 += 4) {
                stringBuffer.append(' ');
                int i4 = i3 + 1;
                if (this.attributes[i4] != null) {
                    stringBuffer.append(new StringBuffer("{").append(this.attributes[i3]).append(SdkConstants.MANIFEST_PLACEHOLDER_SUFFIX).append(this.attributes[i4]).append(":").toString());
                }
                stringBuffer.append(new StringBuffer().append(this.attributes[i3 + 2]).append("='").append(this.attributes[i3 + 3]).append("'").toString());
            }
            stringBuffer.append(Typography.greater);
        } else if (i != 7) {
            if (i != 4) {
                text = getText();
            } else if (this.isWhitespace) {
                text = "(whitespace)";
            } else {
                text = getText();
                if (text.length() > 16) {
                    text = new StringBuffer().append(text.substring(0, 16)).append("...").toString();
                }
            }
            stringBuffer.append(text);
        }
        return stringBuffer.toString();
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getPrefix() {
        return this.prefix;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public Object getProperty(String str) {
        return null;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getText() {
        return this.text;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public char[] getTextCharacters(int[] iArr) {
        if (this.type < 4) {
            iArr[0] = -1;
            iArr[1] = -1;
            return null;
        }
        iArr[0] = 0;
        iArr[1] = this.text.length();
        char[] cArr = new char[this.text.length()];
        String str = this.text;
        str.getChars(0, str.length(), cArr, 0);
        return cArr;
    }

    public int getWapCode() {
        return this.wapCode;
    }

    public Object getWapExtensionData() {
        return this.wapExtensionData;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public boolean isAttributeDefault(int i) {
        return false;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public boolean isEmptyElementTag() throws XmlPullParserException {
        if (this.type != 2) {
            exception(ILLEGAL_TYPE);
        }
        return this.degenerated;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public boolean isWhitespace() throws XmlPullParserException {
        int i = this.type;
        if (i != 4 && i != 7 && i != 5) {
            exception(ILLEGAL_TYPE);
        }
        return this.isWhitespace;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public int next() throws XmlPullParserException, IOException {
        this.isWhitespace = true;
        int i = 9999;
        while (true) {
            String string = this.text;
            nextImpl();
            int i2 = this.type;
            if (i2 < i) {
                i = i2;
            }
            if (i <= 5) {
                if (i >= 4) {
                    if (string != null) {
                        if (this.text != null) {
                            string = new StringBuffer().append(string).append(this.text).toString();
                        }
                        this.text = string;
                    }
                    int iPeekId = peekId();
                    if (iPeekId != 2 && iPeekId != 3 && iPeekId != 4 && iPeekId != 68 && iPeekId != 196 && iPeekId != 131 && iPeekId != 132) {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        this.type = i;
        if (i > 4) {
            this.type = 4;
        }
        return this.type;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public int nextTag() throws XmlPullParserException, IOException {
        next();
        if (this.type == 4 && this.isWhitespace) {
            next();
        }
        int i = this.type;
        if (i != 3 && i != 2) {
            exception("unexpected type");
        }
        return this.type;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String nextText() throws XmlPullParserException, IOException {
        String text;
        if (this.type != 2) {
            exception("precondition: START_TAG");
        }
        next();
        if (this.type == 4) {
            text = getText();
            next();
        } else {
            text = "";
        }
        if (this.type != 3) {
            exception("END_TAG expected");
        }
        return text;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public int nextToken() throws XmlPullParserException, IOException {
        this.isWhitespace = true;
        nextImpl();
        return this.type;
    }

    void parseElement(int i) throws XmlPullParserException, IOException {
        this.type = 2;
        this.name = resolveId(this.tagTable, i & 63);
        this.attributeCount = 0;
        if ((i & 128) != 0) {
            readAttr();
        }
        this.degenerated = (i & 64) == 0;
        int i2 = this.depth;
        this.depth = i2 + 1;
        int i3 = i2 << 2;
        String[] strArrEnsureCapacity = ensureCapacity(this.elementStack, i3 + 4);
        this.elementStack = strArrEnsureCapacity;
        strArrEnsureCapacity[i3 + 3] = this.name;
        int i4 = this.depth;
        int[] iArr = this.nspCounts;
        if (i4 >= iArr.length) {
            int[] iArr2 = new int[i4 + 4];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            this.nspCounts = iArr2;
        }
        int[] iArr3 = this.nspCounts;
        int i5 = this.depth;
        iArr3[i5] = iArr3[i5 - 1];
        for (int i6 = this.attributeCount - 1; i6 > 0; i6--) {
            for (int i7 = 0; i7 < i6; i7++) {
                if (getAttributeName(i6).equals(getAttributeName(i7))) {
                    exception(new StringBuffer("Duplicate Attribute: ").append(getAttributeName(i6)).toString());
                }
            }
        }
        if (this.processNsp) {
            adjustNsp();
        } else {
            this.namespace = "";
        }
        String[] strArr = this.elementStack;
        strArr[i3] = this.namespace;
        strArr[i3 + 1] = this.prefix;
        strArr[i3 + 2] = this.name;
    }

    public Object parseWapExtension(int i) throws XmlPullParserException, IOException {
        switch (i) {
            case 64:
            case 65:
            case 66:
                return readStrI();
            default:
                switch (i) {
                    case 128:
                    case 129:
                    case 130:
                        return new Integer(readInt());
                    default:
                        byte[] bArr = null;
                        switch (i) {
                            case 195:
                                int i2 = readInt();
                                bArr = new byte[i2];
                                int i3 = i2;
                                while (i3 > 0) {
                                    i3 -= this.in.read(bArr, i2 - i3, i3);
                                }
                            case 192:
                            case 193:
                            case 194:
                                return bArr;
                            default:
                                exception(new StringBuffer("illegal id: ").append(i).toString());
                                return null;
                        }
                }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void readAttr() throws XmlPullParserException, IOException {
        StringBuffer stringBuffer;
        int i;
        String strI;
        int i2 = readByte();
        int i3 = 0;
        while (i2 != 1) {
            while (i2 == 0) {
                selectPage(readByte(), false);
                i2 = readByte();
            }
            String strResolveId = resolveId(this.attrStartTable, i2);
            int iIndexOf = strResolveId.indexOf(61);
            if (iIndexOf == -1) {
                stringBuffer = new StringBuffer();
            } else {
                StringBuffer stringBuffer2 = new StringBuffer(strResolveId.substring(iIndexOf + 1));
                strResolveId = strResolveId.substring(0, iIndexOf);
                stringBuffer = stringBuffer2;
            }
            while (true) {
                i = readByte();
                if (i > 128 || i == 0 || i == 2 || i == 3 || i == 131 || ((i >= 64 && i <= 66) || (i >= 128 && i <= 130))) {
                    if (i == 0) {
                        selectPage(readByte(), false);
                    } else if (i != 2) {
                        if (i != 3) {
                            switch (i) {
                                default:
                                    switch (i) {
                                        case 128:
                                        case 129:
                                        case 130:
                                            break;
                                        case 131:
                                            strI = readStrT();
                                            break;
                                        default:
                                            switch (i) {
                                                case 192:
                                                case 193:
                                                case 194:
                                                case 195:
                                                    break;
                                                default:
                                                    strI = resolveId(this.attrValueTable, i);
                                                    break;
                                            }
                                    }
                                case 64:
                                case 65:
                                case 66:
                                    strI = resolveWapExtension(i, parseWapExtension(i));
                                    break;
                            }
                        } else {
                            strI = readStrI();
                        }
                        stringBuffer.append(strI);
                    } else {
                        stringBuffer.append((char) readInt());
                    }
                }
            }
            String[] strArrEnsureCapacity = ensureCapacity(this.attributes, i3 + 4);
            this.attributes = strArrEnsureCapacity;
            strArrEnsureCapacity[i3] = "";
            strArrEnsureCapacity[i3 + 1] = null;
            int i4 = i3 + 3;
            strArrEnsureCapacity[i3 + 2] = strResolveId;
            i3 += 4;
            strArrEnsureCapacity[i4] = stringBuffer.toString();
            this.attributeCount++;
            i2 = i;
        }
    }

    int readByte() throws IOException {
        int i = this.in.read();
        if (i != -1) {
            return i;
        }
        throw new IOException(UNEXPECTED_EOF);
    }

    int readInt() throws IOException {
        int i;
        int i2 = 0;
        do {
            i = readByte();
            i2 = (i2 << 7) | (i & 127);
        } while ((i & 128) != 0);
        return i2;
    }

    String readStrI() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        boolean z = true;
        while (true) {
            int i = this.in.read();
            if (i == 0) {
                this.isWhitespace = z;
                String str = new String(byteArrayOutputStream.toByteArray(), this.encoding);
                byteArrayOutputStream.close();
                return str;
            }
            if (i == -1) {
                throw new IOException(UNEXPECTED_EOF);
            }
            if (i > 32) {
                z = false;
            }
            byteArrayOutputStream.write(i);
        }
    }

    String readStrT() throws IOException {
        int i = readInt();
        if (this.cacheStringTable == null) {
            this.cacheStringTable = new Hashtable();
        }
        String str = (String) this.cacheStringTable.get(new Integer(i));
        if (str != null) {
            return str;
        }
        int i2 = i;
        while (true) {
            byte[] bArr = this.stringTable;
            if (i2 >= bArr.length || bArr[i2] == 0) {
                break;
            }
            i2++;
        }
        String str2 = new String(this.stringTable, i, i2 - i, this.encoding);
        this.cacheStringTable.put(new Integer(i), str2);
        return str2;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public void require(int i, String str, String str2) throws XmlPullParserException, IOException {
        if (i == this.type && ((str == null || str.equals(getNamespace())) && (str2 == null || str2.equals(getName())))) {
            return;
        }
        exception(new StringBuffer("expected: ").append(i == 64 ? "WAP Ext." : new StringBuffer().append(XmlPullParser.TYPES[i]).append(" {").append(str).append(SdkConstants.MANIFEST_PLACEHOLDER_SUFFIX).append(str2).toString()).toString());
    }

    String resolveId(String[] strArr, int i) throws IOException {
        String str;
        int i2 = i & 127;
        int i3 = i2 - 5;
        if (i3 == -1) {
            this.wapCode = -1;
            return readStrT();
        }
        if (i3 < 0 || strArr == null || i3 >= strArr.length || (str = strArr[i3]) == null) {
            throw new IOException(new StringBuffer("id ").append(i).append(" undef.").toString());
        }
        this.wapCode = i2;
        return str;
    }

    protected String resolveWapExtension(int i, Object obj) {
        if (!(obj instanceof byte[])) {
            return new StringBuffer("$(").append(obj).append(")").toString();
        }
        StringBuffer stringBuffer = new StringBuffer();
        byte[] bArr = (byte[]) obj;
        for (int i2 = 0; i2 < bArr.length; i2++) {
            stringBuffer.append(HEX_DIGITS.charAt((bArr[i2] >> 4) & 15));
            stringBuffer.append(HEX_DIGITS.charAt(bArr[i2] & 15));
        }
        return stringBuffer.toString();
    }

    public void setAttrStartTable(int i, String[] strArr) {
        setTable(i, this.ATTR_START_TABLE, strArr);
    }

    public void setAttrValueTable(int i, String[] strArr) {
        setTable(i, this.ATTR_VALUE_TABLE, strArr);
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public void setFeature(String str, boolean z) throws XmlPullParserException {
        if (XmlPullParser.FEATURE_PROCESS_NAMESPACES.equals(str)) {
            this.processNsp = z;
        } else {
            exception(new StringBuffer("unsupported feature: ").append(str).toString());
        }
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public void setInput(InputStream inputStream, String str) throws XmlPullParserException, IOException {
        this.in = inputStream;
        try {
            this.version = readByte();
            int i = readInt();
            this.publicIdentifierId = i;
            if (i == 0) {
                readInt();
            }
            int i2 = readInt();
            if (str == null) {
                if (i2 == 4) {
                    str = "ISO-8859-1";
                } else {
                    if (i2 != 106) {
                        throw new UnsupportedEncodingException(new StringBuffer("").append(i2).toString());
                    }
                    str = "UTF-8";
                }
            }
            this.encoding = str;
            int i3 = readInt();
            this.stringTable = new byte[i3];
            int i4 = 0;
            while (i4 < i3) {
                int i5 = inputStream.read(this.stringTable, i4, i3 - i4);
                if (i5 <= 0) {
                    break;
                } else {
                    i4 += i5;
                }
            }
            selectPage(0, true);
            selectPage(0, false);
        } catch (IOException unused) {
            exception("Illegal input format");
        }
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public void setInput(Reader reader) throws XmlPullParserException {
        exception("InputStream required");
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public void setProperty(String str, Object obj) throws XmlPullParserException {
        throw new XmlPullParserException(new StringBuffer("unsupported property: ").append(str).toString());
    }

    public void setTagTable(int i, String[] strArr) {
        setTable(i, this.TAG_TABLE, strArr);
    }
}
