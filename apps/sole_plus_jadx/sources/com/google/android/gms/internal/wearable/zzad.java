package com.google.android.gms.internal.wearable;

import java.util.Arrays;
import javax.annotation.CheckForNull;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.objectweb.asm.signature.SignatureVisitor;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
public final class zzad {
    private final String zza;
    private final zzab zzb;
    private zzab zzc;

    /* synthetic */ zzad(String str, zzac zzacVar) {
        zzab zzabVar = new zzab(null);
        this.zzb = zzabVar;
        this.zzc = zzabVar;
        str.getClass();
        this.zza = str;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.zza);
        sb.append(AbstractJsonLexerKt.BEGIN_OBJ);
        zzab zzabVar = this.zzb.zzc;
        String str = "";
        while (zzabVar != null) {
            Object obj = zzabVar.zzb;
            sb.append(str);
            String str2 = zzabVar.zza;
            if (str2 != null) {
                sb.append(str2);
                sb.append(SignatureVisitor.INSTANCEOF);
            }
            if (obj == null || !obj.getClass().isArray()) {
                sb.append(obj);
            } else {
                sb.append((CharSequence) Arrays.deepToString(new Object[]{obj}), 1, r2.length() - 1);
            }
            zzabVar = zzabVar.zzc;
            str = ", ";
        }
        sb.append(AbstractJsonLexerKt.END_OBJ);
        return sb.toString();
    }

    public final zzad zza(String str, int i) {
        String strValueOf = String.valueOf(i);
        zzz zzzVar = new zzz(null);
        this.zzc.zzc = zzzVar;
        this.zzc = zzzVar;
        zzzVar.zzb = strValueOf;
        zzzVar.zza = "filterType";
        return this;
    }

    public final zzad zzb(String str, @CheckForNull Object obj) {
        zzab zzabVar = new zzab(null);
        this.zzc.zzc = zzabVar;
        this.zzc = zzabVar;
        zzabVar.zzb = obj;
        zzabVar.zza = str;
        return this;
    }
}
