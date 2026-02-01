package com.android.utils;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* compiled from: NodeCollectionHelper.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a$\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0086\bø\u0001\u0000\u001a$\u0010\u0000\u001a\u00020\u0001*\u00020\u00062\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0007"}, d2 = {"forEach", "", "Lorg/w3c/dom/NamedNodeMap;", "f", "Lkotlin/Function1;", "Lorg/w3c/dom/Node;", "Lorg/w3c/dom/NodeList;", "common"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class NodeCollectionHelperKt {
    public static final void forEach(NodeList nodeList, Function1<? super Node, Unit> f) {
        Intrinsics.checkNotNullParameter(nodeList, "<this>");
        Intrinsics.checkNotNullParameter(f, "f");
        ArrayList arrayList = new ArrayList(nodeList.getLength());
        int length = nodeList.getLength();
        for (int i = 0; i < length; i++) {
            arrayList.add(nodeList.item(i));
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            f.invoke((Node) it.next());
        }
    }

    public static final void forEach(NamedNodeMap namedNodeMap, Function1<? super Node, Unit> f) {
        Intrinsics.checkNotNullParameter(namedNodeMap, "<this>");
        Intrinsics.checkNotNullParameter(f, "f");
        ArrayList arrayList = new ArrayList(namedNodeMap.getLength());
        int length = namedNodeMap.getLength();
        for (int i = 0; i < length; i++) {
            arrayList.add(namedNodeMap.item(i));
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            f.invoke((Node) it.next());
        }
    }
}
