package com.google.android.gms.internal.wearable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
public final class zzcu extends zzas implements RandomAccess, zzcv {

    @Deprecated
    public static final zzcv zza;
    private static final zzcu zzb;
    private final List zzc;

    static {
        zzcu zzcuVar = new zzcu(false);
        zzb = zzcuVar;
        zza = zzcuVar;
    }

    public zzcu() {
        this(10);
    }

    private static String zzj(Object obj) {
        return obj instanceof String ? (String) obj : obj instanceof zzbh ? ((zzbh) obj).zzn(zzco.zzb) : zzco.zzd((byte[]) obj);
    }

    @Override // com.google.android.gms.internal.wearable.zzas, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ void add(int i, Object obj) {
        zzah();
        this.zzc.add(i, (String) obj);
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.wearable.zzas, java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection collection) {
        zzah();
        if (collection instanceof zzcv) {
            collection = ((zzcv) collection).zzh();
        }
        boolean zAddAll = this.zzc.addAll(i, collection);
        this.modCount++;
        return zAddAll;
    }

    @Override // com.google.android.gms.internal.wearable.zzas, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        zzah();
        this.zzc.clear();
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.wearable.zzas, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i) {
        zzah();
        Object objRemove = this.zzc.remove(i);
        this.modCount++;
        return zzj(objRemove);
    }

    @Override // com.google.android.gms.internal.wearable.zzas, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        zzah();
        return zzj(this.zzc.set(i, (String) obj));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc.size();
    }

    @Override // com.google.android.gms.internal.wearable.zzcn
    public final /* bridge */ /* synthetic */ zzcn zzd(int i) {
        if (i < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i);
        arrayList.addAll(this.zzc);
        return new zzcu(arrayList);
    }

    @Override // com.google.android.gms.internal.wearable.zzcv
    public final zzcv zze() {
        return zzc() ? new zzeu(this) : this;
    }

    @Override // com.google.android.gms.internal.wearable.zzcv
    public final Object zzf(int i) {
        return this.zzc.get(i);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: zzg, reason: merged with bridge method [inline-methods] */
    public final String get(int i) {
        Object obj = this.zzc.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzbh) {
            zzbh zzbhVar = (zzbh) obj;
            String strZzn = zzbhVar.zzn(zzco.zzb);
            if (zzbhVar.zzj()) {
                this.zzc.set(i, strZzn);
            }
            return strZzn;
        }
        byte[] bArr = (byte[]) obj;
        String strZzd = zzco.zzd(bArr);
        if (zzfe.zzd(bArr)) {
            this.zzc.set(i, strZzd);
        }
        return strZzd;
    }

    @Override // com.google.android.gms.internal.wearable.zzcv
    public final List zzh() {
        return Collections.unmodifiableList(this.zzc);
    }

    @Override // com.google.android.gms.internal.wearable.zzcv
    public final void zzi(zzbh zzbhVar) {
        zzah();
        this.zzc.add(zzbhVar);
        this.modCount++;
    }

    public zzcu(int i) {
        ArrayList arrayList = new ArrayList(i);
        super(true);
        this.zzc = arrayList;
    }

    private zzcu(ArrayList arrayList) {
        super(true);
        this.zzc = arrayList;
    }

    private zzcu(boolean z) {
        super(false);
        this.zzc = Collections.emptyList();
    }

    @Override // com.google.android.gms.internal.wearable.zzas, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        return addAll(size(), collection);
    }
}
