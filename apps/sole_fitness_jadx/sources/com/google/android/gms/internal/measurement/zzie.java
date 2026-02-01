package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import java.util.Arrays;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.0.0 */
/* loaded from: classes2.dex */
final class zzie<T> implements Serializable, zzib {
    final T zza;

    zzie(T t) {
        this.zza = t;
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (!(obj instanceof zzie)) {
            return false;
        }
        T t = this.zza;
        T t2 = ((zzie) obj).zza;
        return t == t2 || t.equals(t2);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza});
    }

    public final String toString() {
        String string = this.zza.toString();
        StringBuilder sb = new StringBuilder(string.length() + 22);
        sb.append("Suppliers.ofInstance(");
        sb.append(string);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.measurement.zzib
    public final T zza() {
        return this.zza;
    }
}
