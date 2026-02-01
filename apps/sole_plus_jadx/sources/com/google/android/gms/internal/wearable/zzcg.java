package com.google.android.gms.internal.wearable;

import com.google.android.gms.internal.wearable.zzcd;
import com.google.android.gms.internal.wearable.zzcg;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
public abstract class zzcg<MessageType extends zzcg<MessageType, BuilderType>, BuilderType extends zzcd<MessageType, BuilderType>> extends zzar<MessageType, BuilderType> {
    private static final Map zzb = new ConcurrentHashMap();
    private int zzd = -1;
    protected zzeq zzc = zzeq.zzc();

    static zzcg zzO(Class cls) throws ClassNotFoundException {
        Map map = zzb;
        zzcg zzcgVar = (zzcg) map.get(cls);
        if (zzcgVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzcgVar = (zzcg) map.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzcgVar == null) {
            zzcgVar = (zzcg) ((zzcg) zzez.zze(cls)).zzG(6, null, null);
            if (zzcgVar == null) {
                throw new IllegalStateException();
            }
            map.put(cls, zzcgVar);
        }
        return zzcgVar;
    }

    protected static zzcg zzQ(zzcg zzcgVar, byte[] bArr) throws zzcq {
        zzcg zzcgVarZzc = zzc(zzcgVar, bArr, 0, bArr.length, zzbu.zza);
        zzb(zzcgVarZzc);
        return zzcgVarZzc;
    }

    protected static zzcg zzR(zzcg zzcgVar, byte[] bArr, zzbu zzbuVar) throws zzcq {
        zzcg zzcgVarZzc = zzc(zzcgVar, bArr, 0, bArr.length, zzbuVar);
        zzb(zzcgVarZzc);
        return zzcgVarZzc;
    }

    protected static zzcl zzS() {
        return zzcb.zze();
    }

    protected static zzcm zzT() {
        return zzdc.zzf();
    }

    protected static zzcn zzU() {
        return zzdw.zze();
    }

    protected static zzcn zzV(zzcn zzcnVar) {
        int size = zzcnVar.size();
        return zzcnVar.zzd(size == 0 ? 10 : size + size);
    }

    static Object zzX(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    protected static Object zzY(zzdn zzdnVar, String str, Object[] objArr) {
        return new zzdx(zzdnVar, str, objArr);
    }

    private final int zza(zzdy zzdyVar) {
        return zzdv.zza().zzb(getClass()).zza(this);
    }

    protected static void zzab(Class cls, zzcg zzcgVar) {
        zzcgVar.zzaa();
        zzb.put(cls, zzcgVar);
    }

    private static zzcg zzb(zzcg zzcgVar) throws zzcq {
        if (zzcgVar == null || zzcgVar.zzae()) {
            return zzcgVar;
        }
        zzcq zzcqVarZza = new zzeo(zzcgVar).zza();
        zzcqVarZza.zzf(zzcgVar);
        throw zzcqVarZza;
    }

    private static zzcg zzc(zzcg zzcgVar, byte[] bArr, int i, int i2, zzbu zzbuVar) throws zzcq {
        zzcg zzcgVarZzP = zzcgVar.zzP();
        try {
            zzdy zzdyVarZzb = zzdv.zza().zzb(zzcgVarZzP.getClass());
            zzdyVarZzb.zzh(zzcgVarZzP, bArr, 0, i2, new zzau(zzbuVar));
            zzdyVarZzb.zzf(zzcgVarZzP);
            return zzcgVarZzP;
        } catch (zzcq e) {
            e.zzf(zzcgVarZzP);
            throw e;
        } catch (zzeo e2) {
            zzcq zzcqVarZza = e2.zza();
            zzcqVarZza.zzf(zzcgVarZzP);
            throw zzcqVarZza;
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzcq) {
                throw ((zzcq) e3.getCause());
            }
            zzcq zzcqVar = new zzcq(e3);
            zzcqVar.zzf(zzcgVarZzP);
            throw zzcqVar;
        } catch (IndexOutOfBoundsException unused) {
            zzcq zzcqVarZzg = zzcq.zzg();
            zzcqVarZzg.zzf(zzcgVarZzP);
            throw zzcqVarZzg;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return zzdv.zza().zzb(getClass()).zzj(this, (zzcg) obj);
    }

    public final int hashCode() {
        if (zzaf()) {
            return zzL();
        }
        int i = this.zza;
        if (i != 0) {
            return i;
        }
        int iZzL = zzL();
        this.zza = iZzL;
        return iZzL;
    }

    public final String toString() {
        return zzdp.zza(this, super.toString());
    }

    protected abstract Object zzG(int i, Object obj, Object obj2);

    @Override // com.google.android.gms.internal.wearable.zzar
    final int zzH(zzdy zzdyVar) {
        if (zzaf()) {
            int iZza = zzdyVar.zza(this);
            if (iZza >= 0) {
                return iZza;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + iZza);
        }
        int i = this.zzd & Integer.MAX_VALUE;
        if (i != Integer.MAX_VALUE) {
            return i;
        }
        int iZza2 = zzdyVar.zza(this);
        if (iZza2 >= 0) {
            this.zzd = (this.zzd & Integer.MIN_VALUE) | iZza2;
            return iZza2;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + iZza2);
    }

    final int zzL() {
        return zzdv.zza().zzb(getClass()).zzb(this);
    }

    protected final zzcd zzN() {
        return (zzcd) zzG(5, null, null);
    }

    final zzcg zzP() {
        return (zzcg) zzG(4, null, null);
    }

    @Override // com.google.android.gms.internal.wearable.zzdn
    public final /* synthetic */ zzdm zzW() {
        return (zzcd) zzG(5, null, null);
    }

    protected final void zzZ() {
        zzdv.zza().zzb(getClass()).zzf(this);
        zzaa();
    }

    final void zzaa() {
        this.zzd &= Integer.MAX_VALUE;
    }

    final void zzac(int i) {
        this.zzd = (this.zzd & Integer.MIN_VALUE) | Integer.MAX_VALUE;
    }

    @Override // com.google.android.gms.internal.wearable.zzdn
    public final void zzad(zzbp zzbpVar) throws IOException {
        zzdv.zza().zzb(getClass()).zzi(this, zzbq.zza(zzbpVar));
    }

    public final boolean zzae() {
        boolean zBooleanValue = Boolean.TRUE.booleanValue();
        byte bByteValue = ((Byte) zzG(1, null, null)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zZzk = zzdv.zza().zzb(getClass()).zzk(this);
        if (!zBooleanValue) {
            return zZzk;
        }
        zzG(2, true != zZzk ? null : this, null);
        return zZzk;
    }

    final boolean zzaf() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    @Override // com.google.android.gms.internal.wearable.zzdo
    public final /* synthetic */ zzdn zzag() {
        return (zzcg) zzG(6, null, null);
    }

    @Override // com.google.android.gms.internal.wearable.zzdn
    public final int zzM() {
        int iZza;
        if (zzaf()) {
            iZza = zza(null);
            if (iZza < 0) {
                throw new IllegalStateException("serialized size must be non-negative, was " + iZza);
            }
        } else {
            iZza = this.zzd & Integer.MAX_VALUE;
            if (iZza == Integer.MAX_VALUE) {
                iZza = zza(null);
                if (iZza < 0) {
                    throw new IllegalStateException("serialized size must be non-negative, was " + iZza);
                }
                this.zzd = (this.zzd & Integer.MIN_VALUE) | iZza;
            }
        }
        return iZza;
    }
}
