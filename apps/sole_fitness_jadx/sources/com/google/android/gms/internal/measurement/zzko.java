package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.0.0 */
/* loaded from: classes2.dex */
final class zzko extends zzkq {
    private static final Class<?> zza = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzko() {
        super(null);
    }

    /* synthetic */ zzko(zzkn zzknVar) {
        super(null);
    }

    @Override // com.google.android.gms.internal.measurement.zzkq
    final void zza(Object obj, long j) {
        Object objUnmodifiableList;
        List list = (List) zzml.zzf(obj, j);
        if (list instanceof zzkm) {
            objUnmodifiableList = ((zzkm) list).zze();
        } else {
            if (zza.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof zzlj) && (list instanceof zzke)) {
                zzke zzkeVar = (zzke) list;
                if (zzkeVar.zzc()) {
                    zzkeVar.zzb();
                    return;
                }
                return;
            }
            objUnmodifiableList = Collections.unmodifiableList(list);
        }
        zzml.zzs(obj, j, objUnmodifiableList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.zzkq
    final <E> void zzb(Object obj, Object obj2, long j) {
        zzkl zzklVar;
        List list = (List) zzml.zzf(obj2, j);
        int size = list.size();
        List listZzd = (List) zzml.zzf(obj, j);
        if (listZzd.isEmpty()) {
            listZzd = listZzd instanceof zzkm ? new zzkl(size) : ((listZzd instanceof zzlj) && (listZzd instanceof zzke)) ? ((zzke) listZzd).zzd(size) : new ArrayList(size);
            zzml.zzs(obj, j, listZzd);
        } else {
            if (zza.isAssignableFrom(listZzd.getClass())) {
                ArrayList arrayList = new ArrayList(listZzd.size() + size);
                arrayList.addAll(listZzd);
                zzml.zzs(obj, j, arrayList);
                zzklVar = arrayList;
            } else if (listZzd instanceof zzmg) {
                zzkl zzklVar2 = new zzkl(listZzd.size() + size);
                zzklVar2.addAll(zzklVar2.size(), (zzmg) listZzd);
                zzml.zzs(obj, j, zzklVar2);
                zzklVar = zzklVar2;
            } else if ((listZzd instanceof zzlj) && (listZzd instanceof zzke)) {
                zzke zzkeVar = (zzke) listZzd;
                if (!zzkeVar.zzc()) {
                    listZzd = zzkeVar.zzd(listZzd.size() + size);
                    zzml.zzs(obj, j, listZzd);
                }
            }
            listZzd = zzklVar;
        }
        int size2 = listZzd.size();
        int size3 = list.size();
        if (size2 > 0 && size3 > 0) {
            listZzd.addAll(list);
        }
        if (size2 > 0) {
            list = listZzd;
        }
        zzml.zzs(obj, j, list);
    }
}
