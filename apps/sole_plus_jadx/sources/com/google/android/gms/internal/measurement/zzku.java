package com.google.android.gms.internal.measurement;

import com.android.SdkConstants;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@22.0.2 */
/* loaded from: classes4.dex */
final class zzku {
    private static final char[] zza;

    static String zza(zzkt zzktVar, String str) throws SecurityException {
        StringBuilder sb = new StringBuilder();
        sb.append("# ").append(str);
        zza(zzktVar, sb, 0);
        return sb.toString();
    }

    static {
        char[] cArr = new char[80];
        zza = cArr;
        Arrays.fill(cArr, ' ');
    }

    private static void zza(int i, StringBuilder sb) {
        while (i > 0) {
            char[] cArr = zza;
            int length = i > cArr.length ? cArr.length : i;
            sb.append(cArr, 0, length);
            i -= length;
        }
    }

    static void zza(StringBuilder sb, int i, String str, Object obj) throws SecurityException {
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                zza(sb, i, str, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                zza(sb, i, str, (Map.Entry) it2.next());
            }
            return;
        }
        sb.append('\n');
        zza(i, sb);
        if (!str.isEmpty()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(Character.toLowerCase(str.charAt(0)));
            for (int i2 = 1; i2 < str.length(); i2++) {
                char cCharAt = str.charAt(i2);
                if (Character.isUpperCase(cCharAt)) {
                    sb2.append("_");
                }
                sb2.append(Character.toLowerCase(cCharAt));
            }
            str = sb2.toString();
        }
        sb.append(str);
        if (obj instanceof String) {
            sb.append(": \"").append(zzmb.zza(zzia.zza((String) obj))).append('\"');
            return;
        }
        if (obj instanceof zzia) {
            sb.append(": \"").append(zzmb.zza((zzia) obj)).append('\"');
            return;
        }
        if (obj instanceof zzjk) {
            sb.append(" {");
            zza((zzjk) obj, sb, i + 2);
            sb.append("\n");
            zza(i, sb);
            sb.append(SdkConstants.MANIFEST_PLACEHOLDER_SUFFIX);
            return;
        }
        if (obj instanceof Map.Entry) {
            sb.append(" {");
            Map.Entry entry = (Map.Entry) obj;
            int i3 = i + 2;
            zza(sb, i3, "key", entry.getKey());
            zza(sb, i3, "value", entry.getValue());
            sb.append("\n");
            zza(i, sb);
            sb.append(SdkConstants.MANIFEST_PLACEHOLDER_SUFFIX);
            return;
        }
        sb.append(": ").append(obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x019c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void zza(com.google.android.gms.internal.measurement.zzkt r20, java.lang.StringBuilder r21, int r22) throws java.lang.SecurityException {
        /*
            Method dump skipped, instructions count: 594
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzku.zza(com.google.android.gms.internal.measurement.zzkt, java.lang.StringBuilder, int):void");
    }
}
