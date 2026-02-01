package com.google.android.gms.internal.mlkit_vision_text_common;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.1.0 */
/* loaded from: classes4.dex */
final class zzax extends AbstractSet {
    final /* synthetic */ zzba zza;

    zzax(zzba zzbaVar) {
        this.zza = zzbaVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.zza.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(@CheckForNull Object obj) {
        return this.zza.containsKey(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        zzba zzbaVar = this.zza;
        Map mapZzl = zzbaVar.zzl();
        return mapZzl != null ? mapZzl.keySet().iterator() : new zzar(zzbaVar);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(@CheckForNull Object obj) {
        Map mapZzl = this.zza.zzl();
        return mapZzl != null ? mapZzl.keySet().remove(obj) : this.zza.zzy(obj) != zzba.zzd;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zza.size();
    }
}
