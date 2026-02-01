package com.android.utils;

import com.android.SdkConstants;
import com.android.ide.common.blame.SourceFile;
import com.android.ide.common.blame.SourceFilePosition;
import com.android.ide.common.blame.SourcePosition;
import com.google.common.base.CharMatcher;
import com.google.common.base.Charsets;
import com.google.common.collect.Sets;
import com.google.common.io.Files;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import org.w3c.dom.Attr;
import org.w3c.dom.Comment;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.XMLReader;

/* loaded from: classes3.dex */
public class XmlUtils {
    public static final String CDATA_PREFIX = "<![CDATA[";
    public static final String CDATA_SUFFIX = "]]>";
    private static final String DISALLOW_DOCTYPE_DECL = "http://apache.org/xml/features/disallow-doctype-decl";
    private static final String EXTERNAL_GENERAL_ENTITIES = "http://xml.org/sax/features/external-general-entities";
    private static final String EXTERNAL_PARAMETER_ENTITIES = "http://xml.org/sax/features/external-parameter-entities";
    private static final String LOAD_EXTERNAL_DTD = "http://apache.org/xml/features/nonvalidating/load-external-dtd";
    private static final int MAXIMUM_XML_DEPTH = 500;
    private static final String NAMESPACE_PREFIX_FEATURE = "http://xml.org/sax/features/namespace-prefixes";
    public static final char NS_SEPARATOR = ':';
    private static final byte PROTO_XML_LEAD_BYTE = 10;
    private static final String PROVIDE_XMLNS_URIS = "http://xml.org/sax/features/xmlns-uris";
    public static final String SAX_PARSER_FACTORY = "com.sun.org.apache.xerces.internal.jaxp.SAXParserFactoryImpl";
    private static final String SOURCE_FILE_USER_DATA_KEY = "sourcefile";
    public static final String XML_COMMENT_BEGIN = "<!--";
    public static final String XML_COMMENT_END = "-->";
    public static final String XML_PROLOG = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n";

    public static String lookupNamespacePrefix(Node node, String nsUri) {
        return lookupNamespacePrefix(node, nsUri, "http://schemas.android.com/apk/res/android".equals(nsUri) ? "android" : "app", true);
    }

    public static String lookupNamespacePrefix(Node node, String nsUri, boolean create) {
        return lookupNamespacePrefix(node, nsUri, "http://schemas.android.com/apk/res/android".equals(nsUri) ? "android" : "app", create);
    }

    public static String lookupNamespacePrefix(Node node, String nsUri, String defaultPrefix, boolean create) throws DOMException {
        String strLookupPrefix;
        if (nsUri == null) {
            return null;
        }
        if (SdkConstants.XMLNS_URI.equals(nsUri)) {
            return SdkConstants.XMLNS;
        }
        HashSet hashSet = new HashSet();
        Document ownerDocument = node == null ? null : node.getOwnerDocument();
        if (ownerDocument != null) {
            try {
                strLookupPrefix = ownerDocument.lookupPrefix(nsUri);
            } catch (Throwable unused) {
            }
        } else {
            strLookupPrefix = null;
        }
        if (strLookupPrefix != null) {
            return strLookupPrefix;
        }
        while (node != null && node.getNodeType() == 1) {
            NamedNodeMap attributes = node.getAttributes();
            for (int length = attributes.getLength() - 1; length >= 0; length--) {
                Node nodeItem = attributes.item(length);
                if (SdkConstants.XMLNS.equals(nodeItem.getPrefix())) {
                    String nodeValue = nodeItem.getNodeValue();
                    String localName = nodeItem.getLocalName();
                    if (nsUri.equals(nodeValue)) {
                        return localName;
                    }
                    hashSet.add(localName);
                } else if (nodeItem.getPrefix() == null && nodeItem.getNodeName().startsWith(SdkConstants.XMLNS_PREFIX)) {
                    String nodeValue2 = nodeItem.getNodeValue();
                    String strSubstring = nodeItem.getNodeName().substring(SdkConstants.XMLNS_PREFIX.length());
                    if (nsUri.equals(nodeValue2)) {
                        return strSubstring;
                    }
                    hashSet.add(strSubstring);
                }
            }
            node = node.getParentNode();
        }
        if (defaultPrefix == null) {
            return null;
        }
        String str = defaultPrefix;
        int i = 1;
        while (hashSet.contains(str)) {
            str = defaultPrefix + Integer.toString(i);
            i++;
        }
        if (ownerDocument != null) {
            Node firstChild = ownerDocument.getFirstChild();
            while (firstChild != null && firstChild.getNodeType() != 1) {
                firstChild = firstChild.getNextSibling();
            }
            if (firstChild != null && create) {
                Attr attrCreateAttributeNS = ownerDocument.createAttributeNS(SdkConstants.XMLNS_URI, SdkConstants.XMLNS_PREFIX + str);
                attrCreateAttributeNS.setValue(nsUri);
                firstChild.getAttributes().setNamedItemNS(attrCreateAttributeNS);
            }
        }
        return str;
    }

    public static String toXmlAttributeValue(String attrValue) {
        int length = attrValue.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = attrValue.charAt(i);
            if (cCharAt == '\"' || cCharAt == '\'' || cCharAt == '<' || cCharAt == '>' || cCharAt == '&' || cCharAt == '\n') {
                StringBuilder sb = new StringBuilder(attrValue.length() * 2);
                appendXmlAttributeValue(sb, attrValue);
                return sb.toString();
            }
        }
        return attrValue;
    }

    public static String fromXmlAttributeValue(String escapedAttrValue) {
        return escapedAttrValue.indexOf(38) == -1 ? escapedAttrValue : escapedAttrValue.replace(SdkConstants.QUOT_ENTITY, "\"").replace(SdkConstants.LT_ENTITY, "<").replace(SdkConstants.APOS_ENTITY, "'").replace(SdkConstants.AMP_ENTITY, "&").replace(SdkConstants.GT_ENTITY, ">").replace(SdkConstants.NEWLINE_ENTITY, "\n");
    }

    public static String toXmlTextValue(String textValue) {
        int length = textValue.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = textValue.charAt(i);
            if (cCharAt == '<' || cCharAt == '&') {
                StringBuilder sb = new StringBuilder(textValue.length() * 2);
                appendXmlTextValue(sb, textValue);
                return sb.toString();
            }
        }
        return textValue;
    }

    public static void appendXmlAttributeValue(StringBuilder sb, String attrValue) {
        appendXmlAttributeValue(sb, attrValue, 0, attrValue.length());
    }

    public static void appendXmlAttributeValue(StringBuilder sb, String attrValue, int start, int end) {
        char c = 0;
        while (start < end) {
            char cCharAt = attrValue.charAt(start);
            if (cCharAt == '\"') {
                sb.append(SdkConstants.QUOT_ENTITY);
            } else if (cCharAt == '<') {
                sb.append(SdkConstants.LT_ENTITY);
            } else if (cCharAt == '\'') {
                sb.append(SdkConstants.APOS_ENTITY);
            } else if (cCharAt == '&') {
                sb.append(SdkConstants.AMP_ENTITY);
            } else if (cCharAt == '\n') {
                sb.append(SdkConstants.NEWLINE_ENTITY);
            } else if (cCharAt == '>' && c == ']') {
                sb.append(SdkConstants.GT_ENTITY);
            } else {
                sb.append(cCharAt);
            }
            start++;
            c = cCharAt;
        }
    }

    public static void appendXmlTextValue(StringBuilder sb, String textValue) {
        appendXmlTextValue(sb, textValue, 0, textValue.length());
    }

    public static void appendXmlTextValue(StringBuilder sb, String textValue, int start, int end) {
        int iMin = Math.min(textValue.length(), end);
        while (start < iMin) {
            char cCharAt = textValue.charAt(start);
            if (cCharAt == '<') {
                sb.append(SdkConstants.LT_ENTITY);
            } else if (cCharAt == '&') {
                sb.append(SdkConstants.AMP_ENTITY);
            } else {
                sb.append(cCharAt);
            }
            start++;
        }
    }

    public static boolean hasElementChildren(Node node) {
        NodeList childNodes = node.getChildNodes();
        int length = childNodes.getLength();
        for (int i = 0; i < length; i++) {
            if (childNodes.item(i).getNodeType() == 1) {
                return true;
            }
        }
        return false;
    }

    public static Reader getUtfReader(File file) throws IOException {
        byte[] byteArray = Files.toByteArray(file);
        int length = byteArray.length;
        if (length == 0) {
            return new StringReader("");
        }
        byte b = byteArray[0];
        if (b != -17) {
            if (b != -2) {
                if (b == -1) {
                    if (length >= 2 && byteArray[1] == -2) {
                        if (length >= 4 && byteArray[2] == 0 && byteArray[3] == 0) {
                            return new InputStreamReader(new ByteArrayInputStream(byteArray, 4, length - 4), "UTF-32LE");
                        }
                        return new InputStreamReader(new ByteArrayInputStream(byteArray, 2, length - 2), Charsets.UTF_16LE);
                    }
                } else if (b == 0 && length >= 4 && b == 0 && byteArray[1] == 0 && byteArray[2] == -2 && byteArray[3] == -1) {
                    return new InputStreamReader(new ByteArrayInputStream(byteArray, 4, length - 4), "UTF-32BE");
                }
            } else if (length >= 2 && byteArray[1] == -1) {
                return new InputStreamReader(new ByteArrayInputStream(byteArray, 2, length - 2), Charsets.UTF_16BE);
            }
        } else if (length >= 3 && byteArray[1] == -69 && byteArray[2] == -65) {
            return new InputStreamReader(new ByteArrayInputStream(byteArray, 3, length - 3), Charsets.UTF_8);
        }
        return new InputStreamReader(new ByteArrayInputStream(byteArray), Charsets.UTF_8);
    }

    public static Document parseDocument(String xml, boolean namespaceAware) throws SAXException, IOException {
        return parseDocument(new StringReader(stripBom(xml)), namespaceAware);
    }

    public static Document parseDocument(Reader xml, boolean namespaceAware) throws SAXException, IOException {
        return createDocumentBuilder(namespaceAware).parse(new InputSource(xml));
    }

    public static Document parseUtfXmlFile(File file, boolean namespaceAware) throws SAXException, IOException {
        Reader utfReader = getUtfReader(file);
        try {
            Document document = parseDocument(utfReader, namespaceAware);
            if (utfReader != null) {
                utfReader.close();
            }
            return document;
        } catch (Throwable th) {
            if (utfReader != null) {
                try {
                    utfReader.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public static Document createDocument(boolean namespaceAware) {
        return createDocumentBuilder(namespaceAware).newDocument();
    }

    private static DocumentBuilder createDocumentBuilder(boolean namespaceAware) throws ParserConfigurationException {
        try {
            DocumentBuilderFactory documentBuilderFactoryNewInstance = DocumentBuilderFactory.newInstance();
            documentBuilderFactoryNewInstance.setNamespaceAware(namespaceAware);
            documentBuilderFactoryNewInstance.setValidating(false);
            documentBuilderFactoryNewInstance.setFeature(EXTERNAL_GENERAL_ENTITIES, false);
            documentBuilderFactoryNewInstance.setFeature(EXTERNAL_PARAMETER_ENTITIES, false);
            documentBuilderFactoryNewInstance.setFeature(LOAD_EXTERNAL_DTD, false);
            return documentBuilderFactoryNewInstance.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new Error(e);
        }
    }

    public static String stripBom(String xml) {
        return (xml.isEmpty() || xml.charAt(0) != 65279) ? xml : xml.substring(1);
    }

    public static Document parseDocumentSilently(String xml, boolean namespaceAware) {
        try {
            return parseDocument(xml, namespaceAware);
        } catch (Exception unused) {
            return null;
        }
    }

    public static SAXParserFactory configureSaxFactory(SAXParserFactory factory, boolean namespaceAware, boolean checkDtd) throws SAXNotRecognizedException, SAXNotSupportedException, ParserConfigurationException {
        try {
            factory.setXIncludeAware(false);
            factory.setNamespaceAware(namespaceAware);
            factory.setFeature(NAMESPACE_PREFIX_FEATURE, namespaceAware);
            factory.setFeature(PROVIDE_XMLNS_URIS, namespaceAware);
            factory.setValidating(checkDtd);
        } catch (ParserConfigurationException | SAXException unused) {
        }
        return factory;
    }

    public static SAXParserFactory getConfiguredSaxFactory(boolean namespaceAware, boolean checkDtd) {
        return configureSaxFactory(SAXParserFactory.newInstance(SAX_PARSER_FACTORY, null), namespaceAware, checkDtd);
    }

    public static SAXParser createSaxParser(SAXParserFactory factory) throws ParserConfigurationException, SAXException {
        return createSaxParser(factory, false);
    }

    public static SAXParser createSaxParser(SAXParserFactory factory, boolean allowDocTypeDeclarations) throws ParserConfigurationException, SAXException {
        SAXParser sAXParserNewSAXParser = factory.newSAXParser();
        XMLReader xMLReader = sAXParserNewSAXParser.getXMLReader();
        if (!allowDocTypeDeclarations) {
            xMLReader.setFeature(DISALLOW_DOCTYPE_DECL, true);
        } else {
            xMLReader.setFeature(EXTERNAL_GENERAL_ENTITIES, false);
            xMLReader.setFeature(EXTERNAL_PARAMETER_ENTITIES, false);
            xMLReader.setFeature(LOAD_EXTERNAL_DTD, false);
        }
        return sAXParserNewSAXParser;
    }

    public static String toXml(Node node) {
        return toXml(node, null);
    }

    public static String toXml(Node node, Map<SourcePosition, SourceFilePosition> blame) {
        PositionAwareStringBuilder positionAwareStringBuilder = new PositionAwareStringBuilder(1000);
        append(positionAwareStringBuilder, node, blame, Sets.newHashSet());
        return positionAwareStringBuilder.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0096 A[LOOP:0: B:25:0x0094->B:26:0x0096, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void append(com.android.utils.XmlUtils.PositionAwareStringBuilder r16, org.w3c.dom.Node r17, java.util.Map<com.android.ide.common.blame.SourcePosition, com.android.ide.common.blame.SourceFilePosition> r18, java.util.Set<org.w3c.dom.Node> r19) {
        /*
            Method dump skipped, instructions count: 373
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.utils.XmlUtils.append(com.android.utils.XmlUtils$PositionAwareStringBuilder, org.w3c.dom.Node, java.util.Map, java.util.Set):void");
    }

    private static class PositionAwareStringBuilder {
        private final StringBuilder sb;
        int line = 0;
        int column = 0;

        public PositionAwareStringBuilder(int size) {
            this.sb = new StringBuilder(size);
        }

        public PositionAwareStringBuilder append(String text) {
            this.sb.append(text);
            if (text.lastIndexOf(10) == -1) {
                this.column += text.length();
            } else {
                this.line += CharMatcher.is('\n').countIn(text);
                this.column = (text.length() - r1) - 1;
            }
            return this;
        }

        public PositionAwareStringBuilder append(char character) {
            this.sb.append(character);
            if (character == '\n') {
                this.line++;
                this.column = 0;
            } else {
                this.column++;
            }
            return this;
        }

        public int getOffset() {
            return this.sb.length();
        }

        public String toString() {
            return this.sb.toString();
        }
    }

    public static void attachSourceFile(Node node, SourceFile sourceFile) {
        node.setUserData(SOURCE_FILE_USER_DATA_KEY, sourceFile, null);
    }

    public static SourceFilePosition getSourceFilePosition(Node node) {
        SourceFile sourceFile = (SourceFile) node.getUserData(SOURCE_FILE_USER_DATA_KEY);
        if (sourceFile == null) {
            sourceFile = SourceFile.UNKNOWN;
        }
        return new SourceFilePosition(sourceFile, PositionXmlParser.getPosition(node));
    }

    public static String formatFloatValue(double value) {
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid number: " + value);
        }
        return DecimalUtils.trimInsignificantZeros(Float.toString((float) value));
    }

    public static String getRootTagName(File xmlFile) throws IOException {
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(xmlFile));
            try {
                XMLStreamReader xMLStreamReaderCreateXMLStreamReader = XMLInputFactory.newFactory().createXMLStreamReader(bufferedInputStream);
                while (xMLStreamReaderCreateXMLStreamReader.hasNext()) {
                    if (xMLStreamReaderCreateXMLStreamReader.next() == 1) {
                        String localName = xMLStreamReaderCreateXMLStreamReader.getLocalName();
                        bufferedInputStream.close();
                        return localName;
                    }
                }
                bufferedInputStream.close();
                return null;
            } catch (Throwable th) {
                try {
                    bufferedInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (XMLStreamException | IOException unused) {
            return null;
        }
    }

    public static String getRootTagName(String xmlText) throws IOException {
        XMLInputFactory xMLInputFactoryNewFactory = XMLInputFactory.newFactory();
        try {
            StringReader stringReader = new StringReader(xmlText);
            try {
                XMLStreamReader xMLStreamReaderCreateXMLStreamReader = xMLInputFactoryNewFactory.createXMLStreamReader(stringReader);
                while (xMLStreamReaderCreateXMLStreamReader.hasNext()) {
                    if (xMLStreamReaderCreateXMLStreamReader.next() == 1) {
                        String localName = xMLStreamReaderCreateXMLStreamReader.getLocalName();
                        stringReader.close();
                        return localName;
                    }
                }
                stringReader.close();
                return null;
            } catch (Throwable th) {
                try {
                    stringReader.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException | XMLStreamException unused) {
            return null;
        }
    }

    public static List<Element> getSubTagsAsList(Node parent) {
        NodeList childNodes = parent.getChildNodes();
        ArrayList arrayList = new ArrayList(childNodes.getLength());
        int length = childNodes.getLength();
        for (int i = 0; i < length; i++) {
            Node nodeItem = childNodes.item(i);
            if (nodeItem.getNodeType() == 1) {
                arrayList.add((Element) nodeItem);
            }
        }
        return arrayList;
    }

    public static Iterable<Element> getSubTags(Node parent) {
        return new SubTagIterator(parent);
    }

    public static Iterable<Element> getSubTagsByName(Node parent, String tagName) {
        return new NamedSubTagIterator(parent, tagName);
    }

    private static class SubTagIterator implements Iterator<Element>, Iterable<Element> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private Element next;
        private boolean used;

        public SubTagIterator(Node parent) {
            this.next = XmlUtils.getFirstSubTag(parent);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.next != null;
        }

        @Override // java.util.Iterator
        public Element next() {
            Element element = this.next;
            this.next = XmlUtils.getNextTag(element);
            return element;
        }

        @Override // java.lang.Iterable
        public Iterator<Element> iterator() {
            this.used = true;
            return this;
        }
    }

    private static class NamedSubTagIterator implements Iterator<Element>, Iterable<Element> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final String name;
        private Element next;
        private boolean used;

        public NamedSubTagIterator(Node parent, String name) {
            this.name = name;
            this.next = XmlUtils.getFirstSubTagByName(parent, name);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.next != null;
        }

        @Override // java.util.Iterator
        public Element next() {
            Element element = this.next;
            this.next = XmlUtils.getNextTagByName(element, this.name);
            return element;
        }

        @Override // java.lang.Iterable
        public Iterator<Element> iterator() {
            this.used = true;
            return this;
        }
    }

    public static Element getFirstSubTag(Node parent) {
        if (parent == null) {
            return null;
        }
        for (Node firstChild = parent.getFirstChild(); firstChild != null; firstChild = firstChild.getNextSibling()) {
            if (firstChild.getNodeType() == 1) {
                return (Element) firstChild;
            }
        }
        return null;
    }

    public static Element getNextTag(Node node) {
        if (node == null) {
            return null;
        }
        for (Node nextSibling = node.getNextSibling(); nextSibling != null; nextSibling = nextSibling.getNextSibling()) {
            if (nextSibling.getNodeType() == 1) {
                return (Element) nextSibling;
            }
        }
        return null;
    }

    public static Element getPreviousTag(Node node) {
        if (node == null) {
            return null;
        }
        for (Node previousSibling = node.getPreviousSibling(); previousSibling != null; previousSibling = previousSibling.getPreviousSibling()) {
            if (previousSibling.getNodeType() == 1) {
                return (Element) previousSibling;
            }
        }
        return null;
    }

    public static Element getFirstSubTagByName(Node parent, String name) {
        if (parent == null) {
            return null;
        }
        for (Node firstChild = parent.getFirstChild(); firstChild != null; firstChild = firstChild.getNextSibling()) {
            if (firstChild.getNodeType() == 1) {
                String localName = firstChild.getLocalName();
                if (localName == null) {
                    localName = firstChild.getNodeName();
                }
                if (name.equals(localName)) {
                    return (Element) firstChild;
                }
            }
        }
        return null;
    }

    public static Element getNextTagByName(Node node, String name) {
        if (node == null) {
            return null;
        }
        for (Node nextSibling = node.getNextSibling(); nextSibling != null; nextSibling = nextSibling.getNextSibling()) {
            if (nextSibling.getNodeType() == 1) {
                String localName = nextSibling.getLocalName();
                if (localName == null) {
                    localName = nextSibling.getNodeName();
                }
                if (name.equals(localName)) {
                    return (Element) nextSibling;
                }
            }
        }
        return null;
    }

    public static Element getPreviousTagByName(Node node, String name) {
        if (node == null) {
            return null;
        }
        for (Node previousSibling = node.getPreviousSibling(); previousSibling != null; previousSibling = previousSibling.getPreviousSibling()) {
            if (previousSibling.getNodeType() == 1) {
                String localName = previousSibling.getLocalName();
                if (localName == null) {
                    localName = previousSibling.getNodeName();
                }
                if (name.equals(localName)) {
                    return (Element) previousSibling;
                }
            }
        }
        return null;
    }

    public static Comment getPreviousComment(Node element) {
        do {
            element = element.getPreviousSibling();
            if (element instanceof Comment) {
                return (Comment) element;
            }
            if (!(element instanceof Text)) {
                return null;
            }
        } while (CharMatcher.whitespace().matchesAllOf(element.getNodeValue()));
        return null;
    }

    public static String getPreviousCommentText(Node element) {
        Comment previousComment = getPreviousComment(element);
        if (previousComment == null) {
            return null;
        }
        String nodeValue = previousComment.getNodeValue();
        if (CharMatcher.whitespace().matchesAllOf(nodeValue)) {
            return null;
        }
        return nodeValue.trim();
    }

    public static int getSubTagCount(Node parent) {
        if (parent == null) {
            return 0;
        }
        NodeList childNodes = parent.getChildNodes();
        int length = childNodes.getLength();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (childNodes.item(i2).getNodeType() == 1) {
                i++;
            }
        }
        return i;
    }

    public static boolean isProtoXml(byte[] bytes) {
        for (int i = 0; i < bytes.length; i++) {
            byte b = bytes[i];
            if (i == 0 && b != 10) {
                return false;
            }
            if (!Character.isWhitespace(b)) {
                return b != 60;
            }
        }
        return true;
    }

    public static boolean isProtoXml(InputStream stream) throws IOException {
        boolean z = false;
        if (stream.markSupported()) {
            stream.mark(100);
            int i = 0;
            while (true) {
                if (i >= 100) {
                    break;
                }
                try {
                    try {
                        int i2 = stream.read();
                        if (i2 < 0 || (i == 0 && i2 != 10)) {
                            break;
                        }
                        if (Character.isWhitespace(i2)) {
                            i++;
                        } else if (i2 != 60) {
                            z = true;
                        }
                    } finally {
                        stream.reset();
                    }
                } catch (IOException unused) {
                }
            }
        }
        return z;
    }
}
