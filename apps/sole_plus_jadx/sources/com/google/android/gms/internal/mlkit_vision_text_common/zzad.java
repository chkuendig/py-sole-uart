package com.google.android.gms.internal.mlkit_vision_text_common;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.1.0 */
/* loaded from: classes4.dex */
final class zzad extends zzca {
    final transient Map zza;
    final /* synthetic */ zzal zzb;

    zzad(zzal zzalVar, Map map) {
        this.zzb = zzalVar;
        this.zza = map;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        zzal zzalVar = this.zzb;
        if (this.zza == zzalVar.zza) {
            zzalVar.zzl();
        } else {
            zzbo.zza(new zzac(this));
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(@CheckForNull Object obj) {
        return zzcb.zzb(this.zza, obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(@CheckForNull Object obj) {
        return this == obj || this.zza.equals(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CheckForNull
    public final /* bridge */ /* synthetic */ Object get(@CheckForNull Object obj) {
        Collection collection = (Collection) zzcb.zza(this.zza, obj);
        if (collection == null) {
            return null;
        }
        return this.zzb.zzb(obj, collection);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        return this.zza.hashCode();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_common.zzca, java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        return this.zzb.zzo();
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CheckForNull
    public final /* bridge */ /* synthetic */ Object remove(@CheckForNull Object obj) {
        Collection collection = (Collection) this.zza.remove(obj);
        if (collection == null) {
            return null;
        }
        Collection collectionZza = this.zzb.zza();
        collectionZza.addAll(collection);
        this.zzb.zzb -= collection.size();
        collection.clear();
        return collectionZza;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.zza.size();
    }

    @Override // java.util.AbstractMap
    public final String toString() {
        return this.zza.toString();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_common.zzca
    protected final Set zza() {
        return new zzab(this);
    }
}
