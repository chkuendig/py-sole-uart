package com.android.utils;

import com.android.ddmlib.testrunner.IInstrumentationResultParser;
import io.ktor.http.LinkHeader;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

/* compiled from: DomExtensions.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0002\u001a\u0013\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001*\u00020\u0004H\u0086\u0002\u001a\f\u0010\u0005\u001a\u0004\u0018\u00010\u0004*\u00020\u0004\u001a\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u0004*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u0014\u0010\b\u001a\u0004\u0018\u00010\u0004*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007\u001a\n\u0010\t\u001a\u00020\n*\u00020\u0004\u001a\u0018\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007\u001a\n\u0010\f\u001a\u00020\u0007*\u00020\u0004\u001a\u001e\u0010\r\u001a\u00020\u000e*\u00020\u00042\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000e0\u0010\u001a\u001e\u0010\u0012\u001a\u00020\u000e*\u00020\u00042\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e0\u0010¨\u0006\u0013"}, d2 = {"childrenIterator", "", "Lorg/w3c/dom/Node;", "iterator", "Lorg/w3c/dom/Element;", LinkHeader.Rel.Next, "tag", "", "subtag", "subtagCount", "", "subtags", "text", "visitAttributes", "", "visitor", "Lkotlin/Function1;", "Lorg/w3c/dom/Attr;", "visitElements", "common"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class DomExtensions {

    /* compiled from: DomExtensions.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0014\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002J\t\u0010\u000b\u001a\u00020\fH\u0096\u0002J\t\u0010\u0003\u001a\u00020\u0002H\u0096\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0002X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"com/android/utils/DomExtensions$iterator$1", "", "Lorg/w3c/dom/Element;", LinkHeader.Rel.Next, "getNext", "()Lorg/w3c/dom/Element;", "setNext", "(Lorg/w3c/dom/Element;)V", "findNextElement", "node", "Lorg/w3c/dom/Node;", "hasNext", "", "common"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* renamed from: com.android.utils.DomExtensions$iterator$1, reason: invalid class name and case insensitive filesystem */
    public static final class C08181 implements Iterator<Element>, KMappedMarker {
        final /* synthetic */ Element $this_iterator;
        private Element next;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        C08181(Element element) {
            this.$this_iterator = element;
            this.next = findNextElement(element.getFirstChild());
        }

        public final Element getNext() {
            return this.next;
        }

        public final void setNext(Element element) {
            this.next = element;
        }

        private final Element findNextElement(Node node) {
            while (node != null) {
                if (node instanceof Element) {
                    return (Element) node;
                }
                node = node.getNextSibling();
            }
            return null;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.next != null;
        }

        @Override // java.util.Iterator
        public Element next() {
            Element element = this.next;
            this.next = findNextElement(element == null ? null : element.getNextSibling());
            if (element != null) {
                return element;
            }
            throw new IllegalStateException("hasNext is false".toString());
        }
    }

    public static final Iterator<Element> iterator(Element element) {
        Intrinsics.checkNotNullParameter(element, "<this>");
        return new C08181(element);
    }

    /* compiled from: DomExtensions.kt */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\t\u0010\u0005\u001a\u00020\u0006H\u0096\u0002J\t\u0010\u0007\u001a\u00020\u0002H\u0096\u0002R\u0016\u0010\u0003\u001a\n \u0004*\u0004\u0018\u00010\u00020\u0002X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"com/android/utils/DomExtensions$childrenIterator$1", "", "Lorg/w3c/dom/Node;", IInstrumentationResultParser.StatusKeys.CURRENT, "kotlin.jvm.PlatformType", "hasNext", "", LinkHeader.Rel.Next, "common"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* renamed from: com.android.utils.DomExtensions$childrenIterator$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Iterator<Node>, KMappedMarker {
        final /* synthetic */ Node $this_childrenIterator;
        private Node current;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        AnonymousClass1(Node node) {
            this.$this_childrenIterator = node;
            this.current = node.getFirstChild();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.current != null;
        }

        @Override // java.util.Iterator
        public Node next() {
            Node next = this.current;
            Intrinsics.checkNotNull(next);
            this.current = next.getNextSibling();
            Intrinsics.checkNotNullExpressionValue(next, "next");
            return next;
        }
    }

    public static final Iterator<Node> childrenIterator(Node node) {
        Intrinsics.checkNotNullParameter(node, "<this>");
        return new AnonymousClass1(node);
    }

    public static final Element subtag(Element element, String tag) {
        Intrinsics.checkNotNullParameter(element, "<this>");
        Intrinsics.checkNotNullParameter(tag, "tag");
        return XmlUtils.getFirstSubTagByName(element, tag);
    }

    public static final Element next(Element element) {
        Intrinsics.checkNotNullParameter(element, "<this>");
        return XmlUtils.getNextTag(element);
    }

    public static final Element next(Element element, String tag) {
        Intrinsics.checkNotNullParameter(element, "<this>");
        Intrinsics.checkNotNullParameter(tag, "tag");
        return XmlUtils.getNextTagByName(element, tag);
    }

    public static final Iterator<Element> subtags(Element element, String tag) {
        Intrinsics.checkNotNullParameter(element, "<this>");
        Intrinsics.checkNotNullParameter(tag, "tag");
        return XmlUtils.getSubTagsByName(element, tag).iterator();
    }

    public static final int subtagCount(Element element) {
        Intrinsics.checkNotNullParameter(element, "<this>");
        return XmlUtils.getSubTagCount(element);
    }

    public static final String text(Element element) {
        Intrinsics.checkNotNullParameter(element, "<this>");
        String textContent = element.getTextContent();
        Intrinsics.checkNotNullExpressionValue(textContent, "textContent");
        return textContent;
    }

    public static final boolean visitAttributes(Element element, Function1<? super Attr, Boolean> visitor) {
        Intrinsics.checkNotNullParameter(element, "<this>");
        Intrinsics.checkNotNullParameter(visitor, "visitor");
        NamedNodeMap attributes = element.getAttributes();
        int length = attributes.getLength();
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            Node nodeItem = attributes.item(i);
            if (nodeItem == null) {
                throw new NullPointerException("null cannot be cast to non-null type org.w3c.dom.Attr");
            }
            if (visitor.invoke((Attr) nodeItem).booleanValue()) {
                return true;
            }
            i = i2;
        }
        for (Node firstChild = element.getFirstChild(); firstChild != null; firstChild = firstChild.getNextSibling()) {
            if (firstChild.getNodeType() == 1 && visitAttributes((Element) firstChild, visitor)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean visitElements(Element element, Function1<? super Element, Boolean> visitor) {
        Intrinsics.checkNotNullParameter(element, "<this>");
        Intrinsics.checkNotNullParameter(visitor, "visitor");
        if (visitor.invoke(element).booleanValue()) {
            return true;
        }
        for (Node firstChild = element.getFirstChild(); firstChild != null; firstChild = firstChild.getNextSibling()) {
            if (firstChild.getNodeType() == 1 && visitElements((Element) firstChild, visitor)) {
                return true;
            }
        }
        return false;
    }
}
