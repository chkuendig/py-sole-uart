package com.google.android.gms.internal.wearable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
final class zzbz {
    private static final zzbz zzb = new zzbz(true);
    final zzel zza = new zzeb(16);
    private boolean zzc;
    private boolean zzd;

    private zzbz() {
    }

    public static zzbz zza() {
        throw null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void zzd(com.google.android.gms.internal.wearable.zzby r2, java.lang.Object r3) {
        /*
            com.google.android.gms.internal.wearable.zzff r0 = r2.zzb()
            byte[] r1 = com.google.android.gms.internal.wearable.zzco.zzd
            r3.getClass()
            com.google.android.gms.internal.wearable.zzff r1 = com.google.android.gms.internal.wearable.zzff.DOUBLE
            com.google.android.gms.internal.wearable.zzfg r1 = com.google.android.gms.internal.wearable.zzfg.INT
            com.google.android.gms.internal.wearable.zzfg r0 = r0.zza()
            int r0 = r0.ordinal()
            switch(r0) {
                case 0: goto L43;
                case 1: goto L40;
                case 2: goto L3d;
                case 3: goto L3a;
                case 4: goto L37;
                case 5: goto L34;
                case 6: goto L2b;
                case 7: goto L22;
                case 8: goto L19;
                default: goto L18;
            }
        L18:
            goto L48
        L19:
            boolean r0 = r3 instanceof com.google.android.gms.internal.wearable.zzdn
            if (r0 != 0) goto L47
            boolean r0 = r3 instanceof com.google.android.gms.internal.wearable.zzcs
            if (r0 == 0) goto L48
            goto L47
        L22:
            boolean r0 = r3 instanceof java.lang.Integer
            if (r0 != 0) goto L47
            boolean r0 = r3 instanceof com.google.android.gms.internal.wearable.zzci
            if (r0 == 0) goto L48
            goto L47
        L2b:
            boolean r0 = r3 instanceof com.google.android.gms.internal.wearable.zzbh
            if (r0 != 0) goto L47
            boolean r0 = r3 instanceof byte[]
            if (r0 == 0) goto L48
            goto L47
        L34:
            boolean r0 = r3 instanceof java.lang.String
            goto L45
        L37:
            boolean r0 = r3 instanceof java.lang.Boolean
            goto L45
        L3a:
            boolean r0 = r3 instanceof java.lang.Double
            goto L45
        L3d:
            boolean r0 = r3 instanceof java.lang.Float
            goto L45
        L40:
            boolean r0 = r3 instanceof java.lang.Long
            goto L45
        L43:
            boolean r0 = r3 instanceof java.lang.Integer
        L45:
            if (r0 == 0) goto L48
        L47:
            return
        L48:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            int r1 = r2.zza()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            com.google.android.gms.internal.wearable.zzff r2 = r2.zzb()
            com.google.android.gms.internal.wearable.zzfg r2 = r2.zza()
            java.lang.Class r3 = r3.getClass()
            java.lang.String r3 = r3.getName()
            java.lang.Object[] r2 = new java.lang.Object[]{r1, r2, r3}
            java.lang.String r3 = "Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n"
            java.lang.String r2 = java.lang.String.format(r3, r2)
            r0.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.wearable.zzbz.zzd(com.google.android.gms.internal.wearable.zzby, java.lang.Object):void");
    }

    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzbz zzbzVar = new zzbz();
        for (int i = 0; i < this.zza.zzb(); i++) {
            Map.Entry entryZzg = this.zza.zzg(i);
            zzbzVar.zzc((zzby) entryZzg.getKey(), entryZzg.getValue());
        }
        for (Map.Entry entry : this.zza.zzc()) {
            zzbzVar.zzc((zzby) entry.getKey(), entry.getValue());
        }
        zzbzVar.zzd = this.zzd;
        return zzbzVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzbz) {
            return this.zza.equals(((zzbz) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final void zzb() {
        if (this.zzc) {
            return;
        }
        for (int i = 0; i < this.zza.zzb(); i++) {
            Map.Entry entryZzg = this.zza.zzg(i);
            if (entryZzg.getValue() instanceof zzcg) {
                ((zzcg) entryZzg.getValue()).zzZ();
            }
        }
        this.zza.zza();
        this.zzc = true;
    }

    public final void zzc(zzby zzbyVar, Object obj) {
        if (!zzbyVar.zzc()) {
            zzd(zzbyVar, obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                zzd(zzbyVar, arrayList.get(i));
            }
            obj = arrayList;
        }
        if (obj instanceof zzcs) {
            this.zzd = true;
        }
        this.zza.put(zzbyVar, obj);
    }

    private zzbz(boolean z) {
        zzb();
        zzb();
    }
}
