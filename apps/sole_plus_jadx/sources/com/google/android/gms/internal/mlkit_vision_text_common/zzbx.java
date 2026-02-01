package com.google.android.gms.internal.mlkit_vision_text_common;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.1.0 */
/* loaded from: classes4.dex */
abstract class zzbx extends zzck {
    zzbx() {
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        zza().clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@CheckForNull Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object key = entry.getKey();
        Object objZza = zzcb.zza(zza(), key);
        if (zzw.zza(objZza, entry.getValue())) {
            return objZza != null || zzcb.zzb(((zzad) zza()).zza, key);
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return zza().isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(@CheckForNull Object obj) {
        if (contains(obj) && (obj instanceof Map.Entry)) {
            return ((zzad) zza()).zzb.zzo().remove(((Map.Entry) obj).getKey());
        }
        return false;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_common.zzck, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean removeAll(Collection collection) {
        try {
            if (collection == null) {
                throw null;
            }
            return zzcl.zzb(this, collection);
        } catch (UnsupportedOperationException unused) {
            return zzcl.zzc(this, collection.iterator());
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_common.zzck, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean retainAll(Collection collection) {
        int iCeil;
        try {
            if (collection == null) {
                throw null;
            }
            return super.retainAll(collection);
        } catch (UnsupportedOperationException unused) {
            int size = collection.size();
            if (size < 3) {
                zzaq.zza(size, "expectedSize");
                iCeil = size + 1;
            } else {
                iCeil = size < 1073741824 ? (int) Math.ceil(size / 0.75d) : Integer.MAX_VALUE;
            }
            HashSet hashSet = new HashSet(iCeil);
            for (Object obj : collection) {
                if (contains(obj) && (obj instanceof Map.Entry)) {
                    hashSet.add(((Map.Entry) obj).getKey());
                }
            }
            return ((zzad) zza()).zzb.zzo().retainAll(hashSet);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return zza().size();
    }

    abstract Map zza();
}
