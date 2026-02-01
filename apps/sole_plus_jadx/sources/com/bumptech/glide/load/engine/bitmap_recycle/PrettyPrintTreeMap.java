package com.bumptech.glide.load.engine.bitmap_recycle;

import java.util.Map;
import java.util.TreeMap;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes3.dex */
class PrettyPrintTreeMap<K, V> extends TreeMap<K, V> {
    PrettyPrintTreeMap() {
    }

    @Override // java.util.AbstractMap
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("( ");
        for (Map.Entry<K, V> entry : entrySet()) {
            sb.append(AbstractJsonLexerKt.BEGIN_OBJ).append(entry.getKey()).append(':').append(entry.getValue()).append("}, ");
        }
        if (!isEmpty()) {
            sb.replace(sb.length() - 2, sb.length(), "");
        }
        return sb.append(" )").toString();
    }
}
