package com.google.android.gms.internal.wearable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
final class zzcx extends zzdb {
    private static final Class zza = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzcx() {
        super(null);
    }

    /* synthetic */ zzcx(zzcw zzcwVar) {
        super(null);
    }

    @Override // com.google.android.gms.internal.wearable.zzdb
    final void zza(Object obj, long j) {
        Object objUnmodifiableList;
        List list = (List) zzez.zzf(obj, j);
        if (list instanceof zzcv) {
            objUnmodifiableList = ((zzcv) list).zze();
        } else {
            if (zza.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof zzdu) && (list instanceof zzcn)) {
                zzcn zzcnVar = (zzcn) list;
                if (zzcnVar.zzc()) {
                    zzcnVar.zzb();
                    return;
                }
                return;
            }
            objUnmodifiableList = Collections.unmodifiableList(list);
        }
        zzez.zzs(obj, j, objUnmodifiableList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.wearable.zzdb
    final void zzb(Object obj, Object obj2, long j) {
        zzcu zzcuVar;
        List list = (List) zzez.zzf(obj2, j);
        int size = list.size();
        List listZzd = (List) zzez.zzf(obj, j);
        if (listZzd.isEmpty()) {
            listZzd = listZzd instanceof zzcv ? new zzcu(size) : ((listZzd instanceof zzdu) && (listZzd instanceof zzcn)) ? ((zzcn) listZzd).zzd(size) : new ArrayList(size);
            zzez.zzs(obj, j, listZzd);
        } else {
            if (zza.isAssignableFrom(listZzd.getClass())) {
                ArrayList arrayList = new ArrayList(listZzd.size() + size);
                arrayList.addAll(listZzd);
                zzez.zzs(obj, j, arrayList);
                zzcuVar = arrayList;
            } else if (listZzd instanceof zzeu) {
                zzcu zzcuVar2 = new zzcu(listZzd.size() + size);
                zzcuVar2.addAll(zzcuVar2.size(), (zzeu) listZzd);
                zzez.zzs(obj, j, zzcuVar2);
                zzcuVar = zzcuVar2;
            } else if ((listZzd instanceof zzdu) && (listZzd instanceof zzcn)) {
                zzcn zzcnVar = (zzcn) listZzd;
                if (!zzcnVar.zzc()) {
                    listZzd = zzcnVar.zzd(listZzd.size() + size);
                    zzez.zzs(obj, j, listZzd);
                }
            }
            listZzd = zzcuVar;
        }
        int size2 = listZzd.size();
        int size3 = list.size();
        if (size2 > 0 && size3 > 0) {
            listZzd.addAll(list);
        }
        if (size2 > 0) {
            list = listZzd;
        }
        zzez.zzs(obj, j, list);
    }
}
