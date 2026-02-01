package com.google.android.gms.internal.wearable;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
final class zzdf implements zzdz {
    private static final zzdl zza = new zzdd();
    private final zzdl zzb;

    public zzdf() {
        zzdl zzdlVar;
        zzdl[] zzdlVarArr = new zzdl[2];
        zzdlVarArr[0] = zzcc.zza();
        try {
            zzdlVar = (zzdl) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            zzdlVar = zza;
        }
        zzdlVarArr[1] = zzdlVar;
        zzde zzdeVar = new zzde(zzdlVarArr);
        byte[] bArr = zzco.zzd;
        this.zzb = zzdeVar;
    }

    private static boolean zzb(zzdk zzdkVar) {
        return zzdkVar.zzc() + (-1) != 1;
    }

    @Override // com.google.android.gms.internal.wearable.zzdz
    public final zzdy zza(Class cls) {
        zzea.zzq(cls);
        zzdk zzdkVarZzb = this.zzb.zzb(cls);
        return zzdkVarZzb.zzb() ? zzcg.class.isAssignableFrom(cls) ? zzdr.zzc(zzea.zzn(), zzbx.zzb(), zzdkVarZzb.zza()) : zzdr.zzc(zzea.zzm(), zzbx.zza(), zzdkVarZzb.zza()) : zzcg.class.isAssignableFrom(cls) ? zzb(zzdkVarZzb) ? zzdq.zzl(cls, zzdkVarZzb, zzdt.zzb(), zzdb.zzd(), zzea.zzn(), zzbx.zzb(), zzdj.zzb()) : zzdq.zzl(cls, zzdkVarZzb, zzdt.zzb(), zzdb.zzd(), zzea.zzn(), null, zzdj.zzb()) : zzb(zzdkVarZzb) ? zzdq.zzl(cls, zzdkVarZzb, zzdt.zza(), zzdb.zzc(), zzea.zzm(), zzbx.zza(), zzdj.zza()) : zzdq.zzl(cls, zzdkVarZzb, zzdt.zza(), zzdb.zzc(), zzea.zzm(), null, zzdj.zza());
    }
}
