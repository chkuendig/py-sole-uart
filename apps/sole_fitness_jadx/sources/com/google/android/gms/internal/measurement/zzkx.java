package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.0.0 */
/* loaded from: classes2.dex */
final class zzkx {
    zzkx() {
    }

    public static final int zza(int i, Object obj, Object obj2) {
        zzkw zzkwVar = (zzkw) obj;
        if (zzkwVar.isEmpty()) {
            return 0;
        }
        Iterator it = zzkwVar.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw null;
    }

    public static final Object zzb(Object obj, Object obj2) {
        zzkw zzkwVarZzb = (zzkw) obj;
        zzkw zzkwVar = (zzkw) obj2;
        if (!zzkwVar.isEmpty()) {
            if (!zzkwVarZzb.zze()) {
                zzkwVarZzb = zzkwVarZzb.zzb();
            }
            zzkwVarZzb.zzd(zzkwVar);
        }
        return zzkwVarZzb;
    }
}
