package com.android.utils;

import com.android.ProgressManagerAdapter;
import com.android.ide.common.blame.SourcePosition;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.w3c.dom.Attr;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Comment;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.ext.DefaultHandler2;
import org.xml.sax.helpers.DefaultHandler;

/* loaded from: classes3.dex */
public class PositionXmlParser {
    public static final String CONTENT_KEY = "contents";
    private static final DocumentBuilderFactory DOCUMENT_BUILDER_FACTORY;
    private static final SAXParserFactory NAMESPACE_AWARE_SAX_PARSER_FACTORY;
    private static final String POS_KEY = "offsets";
    private static final SAXParserFactory SAX_PARSER_FACTORY;
    private static final String UTF_16 = "UTF_16";
    private static final String UTF_16LE = "UTF_16LE";
    private static final int CDATA_PREFIX_LENGTH = XmlUtils.CDATA_PREFIX.length();
    private static final Pattern ENCODING_PATTERN = Pattern.compile("encoding=['\"](\\S*)['\"]");

    static {
        DocumentBuilderFactory documentBuilderFactoryNewInstance = DocumentBuilderFactory.newInstance();
        DOCUMENT_BUILDER_FACTORY = documentBuilderFactoryNewInstance;
        documentBuilderFactoryNewInstance.setNamespaceAware(true);
        documentBuilderFactoryNewInstance.setValidating(false);
        SAXParserFactory sAXParserFactoryNewInstance = SAXParserFactory.newInstance();
        SAX_PARSER_FACTORY = sAXParserFactoryNewInstance;
        XmlUtils.configureSaxFactory(sAXParserFactoryNewInstance, false, false);
        SAXParserFactory sAXParserFactoryNewInstance2 = SAXParserFactory.newInstance();
        NAMESPACE_AWARE_SAX_PARSER_FACTORY = sAXParserFactoryNewInstance2;
        XmlUtils.configureSaxFactory(sAXParserFactoryNewInstance2, true, false);
    }

    public static Document parse(InputStream input, boolean namespaceAware) throws ParserConfigurationException, SAXException, IOException {
        return parse(readAllBytes(input), namespaceAware);
    }

    public static Document parse(InputStream input, boolean namespaceAware, List<String> parseErrors) throws ParserConfigurationException, IOException {
        return parse(readAllBytes(input), namespaceAware, parseErrors);
    }

    public static Document parse(InputStream input) throws ParserConfigurationException, SAXException, IOException {
        return parse(input, true);
    }

    public static Document parse(byte[] data) throws ParserConfigurationException, SAXException, IOException {
        return parse(data, true);
    }

    public static Document parse(String xml) throws ParserConfigurationException, SAXException, IOException {
        return parse(xml, true);
    }

    public static Document parse(byte[] data, boolean namespaceAware) throws ParserConfigurationException, SAXException, IOException {
        return parseInternal(XmlUtils.stripBom(getXmlString(data)), namespaceAware);
    }

    public static Document parse(byte[] data, boolean namespaceAware, List<String> parseErrors) throws ParserConfigurationException, IOException {
        return parseInternal(XmlUtils.stripBom(getXmlString(data)), namespaceAware, parseErrors);
    }

    public static Document parse(String xml, boolean namespaceAware) throws ParserConfigurationException, SAXException, IOException {
        return parseInternal(XmlUtils.stripBom(xml), namespaceAware);
    }

    private static Document parseInternal(String xml, boolean namespaceAware) throws ParserConfigurationException, SAXException, IOException {
        boolean z = false;
        while (true) {
            DomBuilder domBuilder = new DomBuilder(xml);
            try {
                parseInternal(xml, namespaceAware, domBuilder);
                return domBuilder.getDocument();
            } catch (SAXException e) {
                if (z || !e.getMessage().contains("Content is not allowed in prolog")) {
                    throw e;
                }
                xml = xml.replaceFirst("^([\\W]+)<", "<");
                z = true;
            }
        }
        throw e;
    }

    private static Document parseInternal(String xml, boolean namespaceAware, List<String> parseErrors) throws ParserConfigurationException, DOMException, IOException {
        DomBuilder domBuilder;
        boolean z = false;
        while (true) {
            domBuilder = new DomBuilder(xml);
            try {
                parseInternal(xml, namespaceAware, domBuilder);
                break;
            } catch (SAXException e) {
                if (z || !e.getMessage().contains("Content is not allowed in prolog")) {
                    parseErrors.add(e.getLocalizedMessage());
                    domBuilder.closeUnfinishedElements();
                } else {
                    xml = xml.replaceFirst("^([\\W]+)<", "<");
                    z = true;
                }
            }
        }
        parseErrors.add(e.getLocalizedMessage());
        domBuilder.closeUnfinishedElements();
        return domBuilder.getDocument();
    }

    private static void parseInternal(String xml, boolean namespaceAware, DefaultHandler handler) throws ParserConfigurationException, SAXException, IOException {
        SAXParser sAXParserCreateSaxParser = XmlUtils.createSaxParser(namespaceAware ? NAMESPACE_AWARE_SAX_PARSER_FACTORY : SAX_PARSER_FACTORY, true);
        sAXParserCreateSaxParser.getXMLReader().setProperty("http://xml.org/sax/properties/lexical-handler", handler);
        sAXParserCreateSaxParser.parse(createSource(xml), handler);
    }

    private static byte[] readAllBytes(InputStream input) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                ProgressManagerAdapter.checkCanceled();
                int i = input.read(bArr);
                if (i == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, i);
            } catch (Throwable th) {
                if (input != null) {
                    try {
                        input.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        if (input != null) {
            input.close();
        }
        return byteArrayOutputStream.toByteArray();
    }

    private static InputSource createSource(String xml) {
        return new InputSource(new StringReader(xml));
    }

    public static String getXmlString(byte[] data) {
        return getXmlString(data, "UTF-8");
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:135:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String getXmlString(byte[] r16, java.lang.String r17) {
        /*
            Method dump skipped, instructions count: 299
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.utils.PositionXmlParser.getXmlString(byte[], java.lang.String):java.lang.String");
    }

    public static SourcePosition getPosition(Node node) {
        return getPosition(node, -1, -1);
    }

    public static SourcePosition getPosition(Node node, int start, int end) throws DOMException {
        Position positionHelper = getPositionHelper(node, start, end);
        return positionHelper == null ? SourcePosition.UNKNOWN : positionHelper.toSourcePosition();
    }

    public static Node findNodeAtOffset(Document document, int offset) {
        Element documentElement = document.getDocumentElement();
        if (documentElement != null) {
            return findNodeAtOffset(documentElement, offset);
        }
        return null;
    }

    private static Node findNodeAtOffset(Node node, int offset) throws DOMException {
        Position positionHelper = getPositionHelper(node, -1, -1);
        if (positionHelper == null || offset < positionHelper.getOffset()) {
            return null;
        }
        Position end = positionHelper.getEnd();
        if (end != null && offset >= end.getOffset()) {
            return null;
        }
        NodeList childNodes = node.getChildNodes();
        int length = childNodes.getLength();
        for (int i = 0; i < length; i++) {
            Node nodeFindNodeAtOffset = findNodeAtOffset(childNodes.item(i), offset);
            if (nodeFindNodeAtOffset != null) {
                return nodeFindNodeAtOffset;
            }
        }
        NamedNodeMap attributes = node.getAttributes();
        if (attributes != null) {
            int length2 = attributes.getLength();
            for (int i2 = 0; i2 < length2; i2++) {
                Node nodeFindNodeAtOffset2 = findNodeAtOffset(attributes.item(i2), offset);
                if (nodeFindNodeAtOffset2 != null) {
                    return nodeFindNodeAtOffset2;
                }
            }
        }
        return node;
    }

    public static Node findNodeAtLineAndCol(Document document, int line, int column) {
        Element documentElement = document.getDocumentElement();
        if (documentElement != null) {
            return findNodeAtLineAndCol(documentElement, line, column);
        }
        return null;
    }

    private static Node findNodeAtLineAndCol(Node node, int line, int column) throws DOMException {
        Position positionHelper = getPositionHelper(node, -1, -1);
        if (positionHelper == null || line < positionHelper.getLine() || (line == positionHelper.getLine() && column != -1 && column < positionHelper.getColumn())) {
            return null;
        }
        Position end = positionHelper.getEnd();
        if (end != null && (line > end.getLine() || (line == end.getLine() && column != -1 && column >= end.getColumn()))) {
            return null;
        }
        NodeList childNodes = node.getChildNodes();
        int length = childNodes.getLength();
        for (int i = 0; i < length; i++) {
            Node nodeFindNodeAtLineAndCol = findNodeAtLineAndCol(childNodes.item(i), line, column);
            if (nodeFindNodeAtLineAndCol != null) {
                return nodeFindNodeAtLineAndCol;
            }
        }
        NamedNodeMap attributes = node.getAttributes();
        if (attributes != null) {
            int length2 = attributes.getLength();
            for (int i2 = 0; i2 < length2; i2++) {
                Node nodeFindNodeAtLineAndCol2 = findNodeAtLineAndCol(attributes.item(i2), line, column);
                if (nodeFindNodeAtLineAndCol2 != null) {
                    return nodeFindNodeAtLineAndCol2;
                }
            }
        }
        return node;
    }

    private static Position getPositionHelper(Node node, int start, int end) throws DOMException {
        int i;
        int i2;
        int i3;
        String str;
        if (node instanceof Attr) {
            Attr attr = (Attr) node;
            Position position = (Position) attr.getOwnerElement().getUserData(POS_KEY);
            if (position != null) {
                int offset = position.getOffset();
                int offset2 = position.getEnd().getOffset();
                if (start != -1) {
                    offset += start;
                    if (end != -1) {
                        offset2 = offset + (end - start);
                    }
                }
                String str2 = (String) node.getOwnerDocument().getUserData(CONTENT_KEY);
                if (str2 == null) {
                    return null;
                }
                String name = attr.getName();
                if (attr.getPrefix() != null) {
                    str = String.format("(%1$s\\s*=\\s*((\".*?\")|('.*?')))", name);
                } else {
                    str = String.format("[^:](%1$s\\s*=\\s*((\".*?\")|('.*?')))", name);
                }
                Matcher matcher = Pattern.compile(str).matcher(str2);
                if (!matcher.find(offset) || matcher.start(1) > offset2) {
                    return position;
                }
                int iStart = matcher.start(1);
                int line = position.getLine();
                int column = position.getColumn();
                for (int offset3 = position.getOffset(); offset3 < iStart; offset3++) {
                    if (str2.charAt(offset3) == '\n') {
                        line++;
                        column = 0;
                    } else {
                        column++;
                    }
                }
                Position position2 = new Position(line, column, iStart);
                position2.setEnd(new Position(line, (column + matcher.end(1)) - iStart, matcher.end(1)));
                return position2;
            }
        } else if (node instanceof Text) {
            Position position3 = node.getPreviousSibling() != null ? (Position) node.getPreviousSibling().getUserData(POS_KEY) : null;
            if (position3 == null) {
                position3 = (Position) node.getParentNode().getUserData(POS_KEY);
            }
            if (position3 != null) {
                int offset4 = position3.getEnd().getOffset();
                int line2 = position3.getLine();
                int column2 = position3.getColumn();
                String str3 = (String) node.getOwnerDocument().getUserData(CONTENT_KEY);
                if (str3 == null || str3.length() < offset4) {
                    return null;
                }
                boolean z = false;
                for (int offset5 = position3.getOffset(); offset5 <= offset4; offset5++) {
                    char cCharAt = str3.charAt(offset5);
                    if (cCharAt == '>' && !z) {
                        int i4 = offset5 + 1;
                        int i5 = column2 + 1;
                        if (node instanceof CDATASection) {
                            int i6 = CDATA_PREFIX_LENGTH;
                            if (str3.regionMatches(i4, XmlUtils.CDATA_PREFIX, 0, i6)) {
                                i4 += i6;
                                i5 += i6;
                            }
                        }
                        String nodeValue = node.getNodeValue();
                        int length = nodeValue.length();
                        if (start != -1) {
                            length = Math.min(length, start);
                            i = 0;
                            i2 = line2;
                            i3 = i5;
                            while (i < length) {
                                if (nodeValue.charAt(i) == '\n') {
                                    i2++;
                                    i3 = 0;
                                } else {
                                    i3++;
                                }
                                i++;
                            }
                        } else {
                            i = 0;
                            i2 = line2;
                            i3 = i5;
                            while (i < length) {
                                char cCharAt2 = nodeValue.charAt(i);
                                if (cCharAt2 == '\n') {
                                    i2++;
                                    i3 = 0;
                                } else {
                                    if (!Character.isWhitespace(cCharAt2)) {
                                        break;
                                    }
                                    i3++;
                                }
                                i++;
                            }
                        }
                        if (i == nodeValue.length()) {
                            i = 0;
                        } else {
                            i5 = i3;
                            line2 = i2;
                        }
                        int i7 = i4 + i;
                        Position position4 = new Position(line2, i5, i7);
                        if (end != -1) {
                            position4.setEnd(new Position(line2, i5, i4 + end));
                        } else {
                            int i8 = length - 1;
                            while (true) {
                                if (i8 < 0) {
                                    break;
                                }
                                if (!Character.isWhitespace(nodeValue.charAt(i8))) {
                                    length = i8 + 1;
                                    break;
                                }
                                i8--;
                            }
                            while (i < length) {
                                if (nodeValue.charAt(i) == '\n') {
                                    line2++;
                                    i5 = 0;
                                } else {
                                    i5++;
                                }
                                i7++;
                                i++;
                            }
                            position4.setEnd(new Position(line2, i5, i7));
                        }
                        return position4;
                    }
                    if (cCharAt == '\"') {
                        z = !z;
                    } else if (cCharAt == '\n') {
                        line2++;
                        column2 = -1;
                    }
                    column2++;
                }
                return position3;
            }
        }
        return (Position) node.getUserData(POS_KEY);
    }

    private static final class DomBuilder extends DefaultHandler2 {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private boolean mCdata;
        private int mCurrentColumn;
        private int mCurrentOffset;
        private final Document mDocument;
        private Locator mLocator;
        private final String mXml;
        private int mCurrentLine = 0;
        private final List<Element> mStack = new ArrayList();
        private final StringBuilder mPendingText = new StringBuilder();

        DomBuilder(String xml) throws ParserConfigurationException {
            this.mXml = xml;
            Document documentNewDocument = PositionXmlParser.DOCUMENT_BUILDER_FACTORY.newDocumentBuilder().newDocument();
            this.mDocument = documentNewDocument;
            documentNewDocument.setUserData(PositionXmlParser.CONTENT_KEY, xml, null);
        }

        Document getDocument() throws DOMException {
            closeUnfinishedElements();
            return this.mDocument;
        }

        void closeUnfinishedElements() throws DOMException {
            flushText();
            while (!this.mStack.isEmpty()) {
                Element elementRemove = this.mStack.remove(r0.size() - 1);
                ((Position) elementRemove.getUserData(PositionXmlParser.POS_KEY)).setEnd(getCurrentPosition());
                addNodeToParent(elementRemove);
            }
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void setDocumentLocator(Locator locator) {
            this.mLocator = locator;
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws DOMException, SAXException {
            try {
                flushText();
                Element elementCreateElementNS = this.mDocument.createElementNS(uri, qName);
                for (int i = 0; i < attributes.getLength(); i++) {
                    if (attributes.getURI(i) != null && !attributes.getURI(i).isEmpty()) {
                        Attr attrCreateAttributeNS = this.mDocument.createAttributeNS(attributes.getURI(i), attributes.getQName(i));
                        attrCreateAttributeNS.setValue(attributes.getValue(i));
                        elementCreateElementNS.setAttributeNodeNS(attrCreateAttributeNS);
                    } else {
                        Attr attrCreateAttribute = this.mDocument.createAttribute(attributes.getQName(i));
                        attrCreateAttribute.setValue(attributes.getValue(i));
                        elementCreateElementNS.setAttributeNode(attrCreateAttribute);
                    }
                }
                elementCreateElementNS.setUserData(PositionXmlParser.POS_KEY, findOpeningTag(getCurrentPosition()), null);
                this.mStack.add(elementCreateElementNS);
            } catch (Exception e) {
                throw new SAXException(e);
            }
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endElement(String uri, String localName, String qName) throws DOMException {
            flushText();
            Element elementRemove = this.mStack.remove(r1.size() - 1);
            ((Position) elementRemove.getUserData(PositionXmlParser.POS_KEY)).setEnd(getCurrentPosition());
            addNodeToParent(elementRemove);
        }

        @Override // org.xml.sax.ext.DefaultHandler2, org.xml.sax.ext.LexicalHandler
        public void comment(char[] chars, int start, int length) throws DOMException, SAXException {
            flushText();
            Comment commentCreateComment = this.mDocument.createComment(new String(chars, start, length));
            Position currentPosition = getCurrentPosition();
            Position positionFindOpeningTag = findOpeningTag(currentPosition);
            positionFindOpeningTag.setEnd(currentPosition);
            commentCreateComment.setUserData(PositionXmlParser.POS_KEY, positionFindOpeningTag, null);
            addNodeToParent(commentCreateComment);
        }

        private void addNodeToParent(Node nodeToAdd) {
            if (this.mStack.isEmpty()) {
                this.mDocument.appendChild(nodeToAdd);
            } else {
                this.mStack.get(r0.size() - 1).appendChild(nodeToAdd);
            }
        }

        private Position findOpeningTag(Position startingPosition) {
            for (int offset = startingPosition.getOffset() - 1; offset >= 0; offset--) {
                if (this.mXml.charAt(offset) == '<') {
                    int line = startingPosition.getLine();
                    int offset2 = startingPosition.getOffset();
                    for (int i = offset; i < offset2; i++) {
                        if (this.mXml.charAt(i) == '\n') {
                            line--;
                        }
                    }
                    int i2 = offset - 1;
                    int i3 = 0;
                    while (i2 >= 0 && this.mXml.charAt(i2) != '\n') {
                        i2--;
                        i3++;
                    }
                    return new Position(line, i3, offset);
                }
            }
            return startingPosition;
        }

        private Position getCurrentPosition() {
            int i;
            int i2;
            int lineNumber = this.mLocator.getLineNumber() - 1;
            int columnNumber = this.mLocator.getColumnNumber() - 1;
            int length = this.mXml.length();
            while (this.mCurrentLine < lineNumber && (i = this.mCurrentOffset) < length) {
                char cCharAt = this.mXml.charAt(i);
                if (cCharAt != '\r' || (i2 = this.mCurrentOffset) >= length - 1) {
                    if (cCharAt == '\n') {
                        this.mCurrentLine++;
                        this.mCurrentColumn = 0;
                    } else {
                        this.mCurrentColumn++;
                    }
                } else if (this.mXml.charAt(i2 + 1) != '\n') {
                    this.mCurrentLine++;
                    this.mCurrentColumn = 0;
                }
                this.mCurrentOffset++;
            }
            for (int i3 = this.mCurrentColumn; i3 < columnNumber; i3++) {
                int i4 = this.mCurrentOffset;
                if (i4 == length || this.mXml.charAt(i4) == '\n') {
                    break;
                }
                this.mCurrentOffset++;
            }
            if (this.mCurrentOffset >= length) {
                this.mCurrentOffset = length;
            }
            this.mCurrentColumn = columnNumber;
            return new Position(this.mCurrentLine, this.mCurrentColumn, this.mCurrentOffset);
        }

        @Override // org.xml.sax.ext.DefaultHandler2, org.xml.sax.ext.LexicalHandler
        public void startCDATA() throws DOMException {
            flushText();
            this.mCdata = true;
        }

        @Override // org.xml.sax.ext.DefaultHandler2, org.xml.sax.ext.LexicalHandler
        public void endCDATA() throws DOMException {
            flushText();
            this.mCdata = false;
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void characters(char[] c, int start, int length) throws SAXException {
            this.mPendingText.append(c, start, length);
        }

        private void flushText() throws DOMException {
            Text textCreateTextNode;
            if ((this.mPendingText.length() > 0 || this.mCdata) && !this.mStack.isEmpty()) {
                Element element = this.mStack.get(r0.size() - 1);
                if (this.mCdata) {
                    textCreateTextNode = this.mDocument.createCDATASection(this.mPendingText.toString());
                } else {
                    textCreateTextNode = this.mDocument.createTextNode(this.mPendingText.toString());
                }
                element.appendChild(textCreateTextNode);
                this.mPendingText.setLength(0);
            }
        }
    }

    private static class Position {
        private final int mColumn;
        private Position mEnd;
        private final int mLine;
        private final int mOffset;

        Position(int line, int column, int offset) {
            this.mLine = line;
            this.mColumn = column;
            this.mOffset = offset;
        }

        public int getLine() {
            return this.mLine;
        }

        public int getOffset() {
            return this.mOffset;
        }

        public int getColumn() {
            return this.mColumn;
        }

        public Position getEnd() {
            return this.mEnd;
        }

        public void setEnd(Position end) {
            this.mEnd = end;
        }

        public SourcePosition toSourcePosition() {
            int line = this.mLine;
            int column = this.mColumn;
            int offset = this.mOffset;
            Position position = this.mEnd;
            if (position != null) {
                line = position.getLine();
                column = this.mEnd.getColumn();
                offset = this.mEnd.getOffset();
            }
            return new SourcePosition(this.mLine, this.mColumn, this.mOffset, line, column, offset);
        }
    }

    private PositionXmlParser() {
    }
}
