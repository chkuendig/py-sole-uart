package com.google.android.gms.internal.mlkit_vision_text_common;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.1.0 */
/* loaded from: classes4.dex */
abstract class zzcm implements Iterator {
    final Iterator zzb;

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return zza(this.zzb.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.zzb.remove();
    }

    abstract Object zza(Object obj);

    zzcm(Iterator it) {
        it.getClass();
        this.zzb = it;
    }
}
