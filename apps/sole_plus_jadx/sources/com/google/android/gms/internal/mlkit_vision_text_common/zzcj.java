package com.google.android.gms.internal.mlkit_vision_text_common;

import java.util.Objects;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.1.0 */
/* loaded from: classes4.dex */
final class zzcj extends zzbm {
    final transient Object[] zza;

    private zzcj(@CheckForNull Object obj, Object[] objArr, int i) {
        this.zza = objArr;
    }

    static zzcj zzg(int i, Object[] objArr, zzbl zzblVar) {
        zzaq.zzb(Objects.requireNonNull(objArr[0]), Objects.requireNonNull(objArr[1]));
        return new zzcj(null, objArr, 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0003  */
    @Override // com.google.android.gms.internal.mlkit_vision_text_common.zzbm, java.util.Map
    @javax.annotation.CheckForNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object get(@javax.annotation.CheckForNull java.lang.Object r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 != 0) goto L5
        L3:
            r4 = r0
            goto L1b
        L5:
            java.lang.Object[] r1 = r3.zza
            r2 = 0
            r2 = r1[r2]
            java.lang.Object r2 = java.util.Objects.requireNonNull(r2)
            boolean r4 = r2.equals(r4)
            if (r4 == 0) goto L3
            r4 = 1
            r4 = r1[r4]
            java.lang.Object r4 = java.util.Objects.requireNonNull(r4)
        L1b:
            if (r4 != 0) goto L1e
            return r0
        L1e:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_text_common.zzcj.get(java.lang.Object):java.lang.Object");
    }

    @Override // java.util.Map
    public final int size() {
        return 1;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_common.zzbm
    final zzbf zza() {
        return new zzci(this.zza, 1, 1);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_common.zzbm
    final zzbn zzd() {
        return new zzcg(this, this.zza, 0, 1);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_common.zzbm
    final zzbn zze() {
        return new zzch(this, new zzci(this.zza, 0, 1));
    }
}
