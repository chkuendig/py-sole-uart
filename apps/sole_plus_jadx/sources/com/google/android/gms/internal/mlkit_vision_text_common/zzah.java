package com.google.android.gms.internal.mlkit_vision_text_common;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.1.0 */
/* loaded from: classes4.dex */
class zzah implements Iterator {
    final Iterator zza;
    final Collection zzb;
    final /* synthetic */ zzai zzc;

    zzah(zzai zzaiVar) {
        this.zzc = zzaiVar;
        this.zzb = zzaiVar.zzb;
        Collection collection = zzaiVar.zzb;
        this.zza = collection instanceof List ? ((List) collection).listIterator() : collection.iterator();
    }

    zzah(zzai zzaiVar, Iterator it) {
        this.zzc = zzaiVar;
        this.zzb = zzaiVar.zzb;
        this.zza = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        zza();
        return this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        zza();
        return this.zza.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.zza.remove();
        zzal zzalVar = this.zzc.zze;
        zzalVar.zzb--;
        this.zzc.zzc();
    }

    final void zza() {
        this.zzc.zzb();
        if (this.zzc.zzb != this.zzb) {
            throw new ConcurrentModificationException();
        }
    }
}
