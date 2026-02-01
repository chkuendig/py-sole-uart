package com.google.android.gms.internal.wearable;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
final class zzen {
    static String zza(zzbh zzbhVar) {
        StringBuilder sb = new StringBuilder(zzbhVar.zzd());
        for (int i = 0; i < zzbhVar.zzd(); i++) {
            byte bZza = zzbhVar.zza(i);
            if (bZza == 34) {
                sb.append("\\\"");
            } else if (bZza == 39) {
                sb.append("\\'");
            } else if (bZza != 92) {
                switch (bZza) {
                    case 7:
                        sb.append("\\a");
                        break;
                    case 8:
                        sb.append("\\b");
                        break;
                    case 9:
                        sb.append("\\t");
                        break;
                    case 10:
                        sb.append("\\n");
                        break;
                    case 11:
                        sb.append("\\v");
                        break;
                    case 12:
                        sb.append("\\f");
                        break;
                    case 13:
                        sb.append("\\r");
                        break;
                    default:
                        if (bZza < 32 || bZza > 126) {
                            sb.append(AbstractJsonLexerKt.STRING_ESC);
                            sb.append((char) (((bZza >>> 6) & 3) + 48));
                            sb.append((char) (((bZza >>> 3) & 7) + 48));
                            sb.append((char) ((bZza & 7) + 48));
                            break;
                        } else {
                            sb.append((char) bZza);
                            break;
                        }
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }
}
