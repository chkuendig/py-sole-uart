package com.google.android.gms.internal.mlkit_vision_text_common;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Set;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.1.0 */
/* loaded from: classes4.dex */
abstract class zzca extends AbstractMap {

    @CheckForNull
    private transient Set zza;

    @CheckForNull
    private transient Set zzb;

    @CheckForNull
    private transient Collection zzc;

    zzca() {
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        Set set = this.zza;
        if (set != null) {
            return set;
        }
        Set setZza = zza();
        this.zza = setZza;
        return setZza;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set keySet() {
        Set set = this.zzb;
        if (set != null) {
            return set;
        }
        zzby zzbyVar = new zzby(this);
        this.zzb = zzbyVar;
        return zzbyVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection values() {
        Collection collection = this.zzc;
        if (collection != null) {
            return collection;
        }
        zzbz zzbzVar = new zzbz(this);
        this.zzc = zzbzVar;
        return zzbzVar;
    }

    abstract Set zza();
}
