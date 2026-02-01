package com.google.android.gms.common.util;

import com.android.SdkConstants;
import java.util.HashMap;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: com.google.android.gms:play-services-basement@@18.9.0 */
/* loaded from: classes4.dex */
public class MapUtils {
    public static void writeStringMapToJson(StringBuilder sb, HashMap<String, String> map) {
        sb.append("{");
        boolean z = true;
        for (String str : map.keySet()) {
            if (!z) {
                sb.append(",");
            }
            String str2 = map.get(str);
            sb.append("\"");
            sb.append(str);
            sb.append("\":");
            if (str2 == null) {
                sb.append(AbstractJsonLexerKt.NULL);
            } else {
                sb.append("\"");
                sb.append(str2);
                sb.append("\"");
            }
            z = false;
        }
        sb.append(SdkConstants.MANIFEST_PLACEHOLDER_SUFFIX);
    }
}
