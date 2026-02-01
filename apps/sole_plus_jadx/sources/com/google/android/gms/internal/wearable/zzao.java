package com.google.android.gms.internal.wearable;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;
import javax.annotation.CheckForNull;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
final class zzao extends AbstractList implements RandomAccess, Serializable {
    final long[] zza;
    final int zzb;
    final int zzc;

    zzao(long[] jArr, int i, int i2) {
        this.zza = jArr;
        this.zzb = i;
        this.zzc = i2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(@CheckForNull Object obj) {
        return (obj instanceof Long) && zzap.zza(this.zza, ((Long) obj).longValue(), this.zzb, this.zzc) != -1;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzao)) {
            return super.equals(obj);
        }
        zzao zzaoVar = (zzao) obj;
        int i = this.zzc - this.zzb;
        if (zzaoVar.zzc - zzaoVar.zzb != i) {
            return false;
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (this.zza[this.zzb + i2] != zzaoVar.zza[zzaoVar.zzb + i2]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i) {
        zzaf.zza(i, this.zzc - this.zzb, "index");
        return Long.valueOf(this.zza[this.zzb + i]);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = this.zzb; i2 < this.zzc; i2++) {
            long j = this.zza[i2];
            i = (i * 31) + ((int) (j ^ (j >>> 32)));
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(@CheckForNull Object obj) {
        int iZza;
        if (!(obj instanceof Long) || (iZza = zzap.zza(this.zza, ((Long) obj).longValue(), this.zzb, this.zzc)) < 0) {
            return -1;
        }
        return iZza - this.zzb;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return false;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(@CheckForNull Object obj) {
        if (obj instanceof Long) {
            long[] jArr = this.zza;
            long jLongValue = ((Long) obj).longValue();
            int i = this.zzb;
            int i2 = this.zzc - 1;
            while (true) {
                if (i2 < i) {
                    i2 = -1;
                    break;
                }
                if (jArr[i2] == jLongValue) {
                    break;
                }
                i2--;
            }
            if (i2 >= 0) {
                return i2 - this.zzb;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        Long l = (Long) obj;
        zzaf.zza(i, this.zzc - this.zzb, "index");
        long[] jArr = this.zza;
        int i2 = this.zzb + i;
        long j = jArr[i2];
        l.getClass();
        jArr[i2] = l.longValue();
        return Long.valueOf(j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc - this.zzb;
    }

    @Override // java.util.AbstractList, java.util.List
    public final List subList(int i, int i2) {
        zzaf.zzb(i, i2, this.zzc - this.zzb);
        if (i == i2) {
            return Collections.emptyList();
        }
        long[] jArr = this.zza;
        int i3 = this.zzb;
        return new zzao(jArr, i + i3, i3 + i2);
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        StringBuilder sb = new StringBuilder((this.zzc - this.zzb) * 10);
        sb.append(AbstractJsonLexerKt.BEGIN_LIST);
        sb.append(this.zza[this.zzb]);
        int i = this.zzb;
        while (true) {
            i++;
            if (i >= this.zzc) {
                sb.append(AbstractJsonLexerKt.END_LIST);
                return sb.toString();
            }
            sb.append(", ");
            sb.append(this.zza[i]);
        }
    }
}
