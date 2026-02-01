package com.google.android.gms.internal.measurement;

import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.0.0 */
/* loaded from: classes2.dex */
final class zzia<T> extends zzhz<T> {
    private final T zza;

    zzia(T t) {
        this.zza = t;
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj instanceof zzia) {
            return this.zza.equals(((zzia) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode() + 1502476572;
    }

    public final String toString() {
        String string = this.zza.toString();
        StringBuilder sb = new StringBuilder(string.length() + 13);
        sb.append("Optional.of(");
        sb.append(string);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.measurement.zzhz
    public final T zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzhz
    public final boolean zzb() {
        return true;
    }
}
