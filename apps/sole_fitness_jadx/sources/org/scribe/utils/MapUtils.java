package org.scribe.utils;

import java.util.Map;

/* loaded from: classes2.dex */
public class MapUtils {
    private MapUtils() {
    }

    public static <K, V> String toString(Map<K, V> map) {
        if (map == null) {
            return "";
        }
        if (map.isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            sb.append(String.format(", %s -> %s ", entry.getKey().toString(), entry.getValue().toString()));
        }
        return "{" + sb.substring(1) + "}";
    }
}
