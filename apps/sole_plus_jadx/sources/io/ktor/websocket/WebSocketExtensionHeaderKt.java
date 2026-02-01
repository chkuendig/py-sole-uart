package io.ktor.websocket;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: WebSocketExtensionHeader.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"parseWebSocketExtensions", "", "Lio/ktor/websocket/WebSocketExtensionHeader;", "value", "", "ktor-websockets"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class WebSocketExtensionHeaderKt {
    public static final List<WebSocketExtensionHeader> parseWebSocketExtensions(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        List listSplit$default = StringsKt.split$default((CharSequence) value, new String[]{","}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSplit$default, 10));
        Iterator it = listSplit$default.iterator();
        while (it.hasNext()) {
            List listSplit$default2 = StringsKt.split$default((CharSequence) it.next(), new String[]{";"}, false, 0, 6, (Object) null);
            String string = StringsKt.trim((CharSequence) CollectionsKt.first(listSplit$default2)).toString();
            List listDrop = CollectionsKt.drop(listSplit$default2, 1);
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listDrop, 10));
            Iterator it2 = listDrop.iterator();
            while (it2.hasNext()) {
                arrayList2.add(StringsKt.trim((CharSequence) it2.next()).toString());
            }
            arrayList.add(new WebSocketExtensionHeader(string, arrayList2));
        }
        return arrayList;
    }
}
