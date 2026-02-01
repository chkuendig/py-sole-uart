package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzjt;
import com.google.android.gms.internal.measurement.zzjx;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.0.0 */
/* loaded from: classes2.dex */
public abstract class zzjx<MessageType extends zzjx<MessageType, BuilderType>, BuilderType extends zzjt<MessageType, BuilderType>> extends zzih<MessageType, BuilderType> {
    private static final Map<Object, zzjx<?, ?>> zza = new ConcurrentHashMap();
    protected zzmc zzc = zzmc.zzc();
    protected int zzd = -1;

    protected static <E> zzke<E> zzbA() {
        return zzll.zze();
    }

    protected static <E> zzke<E> zzbB(zzke<E> zzkeVar) {
        int size = zzkeVar.size();
        return zzkeVar.zzd(size == 0 ? 10 : size + size);
    }

    static Object zzbE(Method method, Object obj, Object... objArr) {
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

    protected static Object zzbF(zzlc zzlcVar, String str, Object[] objArr) {
        return new zzlm(zzlcVar, str, objArr);
    }

    protected static <T extends zzjx> void zzbG(Class<T> cls, T t) {
        zza.put(cls, t);
    }

    static <T extends zzjx> T zzbw(Class<T> cls) throws ClassNotFoundException {
        Map<Object, zzjx<?, ?>> map = zza;
        zzjx<?, ?> zzjxVar = map.get(cls);
        if (zzjxVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzjxVar = map.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzjxVar == null) {
            zzjxVar = (zzjx) ((zzjx) zzml.zze(cls)).zzl(6, null, null);
            if (zzjxVar == null) {
                throw new IllegalStateException();
            }
            map.put(cls, zzjxVar);
        }
        return zzjxVar;
    }

    protected static zzkc zzbx() {
        return zzjy.zzf();
    }

    protected static zzkd zzby() {
        return zzkr.zzf();
    }

    protected static zzkd zzbz(zzkd zzkdVar) {
        int size = zzkdVar.size();
        return zzkdVar.zzd(size == 0 ? 10 : size + size);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzlk.zza().zzb(getClass()).zzi(this, (zzjx) obj);
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzb;
        if (i != 0) {
            return i;
        }
        int iZzb = zzlk.zza().zzb(getClass()).zzb(this);
        this.zzb = iZzb;
        return iZzb;
    }

    public final String toString() {
        return zzle.zza(this, super.toString());
    }

    @Override // com.google.android.gms.internal.measurement.zzlc
    public final /* synthetic */ zzlb zzbC() {
        return (zzjt) zzl(5, null, null);
    }

    @Override // com.google.android.gms.internal.measurement.zzlc
    public final /* synthetic */ zzlb zzbD() {
        zzjt zzjtVar = (zzjt) zzl(5, null, null);
        zzjtVar.zzay(this);
        return zzjtVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzlc
    public final void zzbH(zzje zzjeVar) throws IOException {
        zzlk.zza().zzb(getClass()).zzm(this, zzjf.zza(zzjeVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzld
    public final /* synthetic */ zzlc zzbL() {
        return (zzjx) zzl(6, null, null);
    }

    @Override // com.google.android.gms.internal.measurement.zzih
    final int zzbo() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.measurement.zzih
    final void zzbr(int i) {
        this.zzd = i;
    }

    @Override // com.google.android.gms.internal.measurement.zzlc
    public final int zzbt() {
        int i = this.zzd;
        if (i != -1) {
            return i;
        }
        int iZza = zzlk.zza().zzb(getClass()).zza(this);
        this.zzd = iZza;
        return iZza;
    }

    protected final <MessageType extends zzjx<MessageType, BuilderType>, BuilderType extends zzjt<MessageType, BuilderType>> BuilderType zzbu() {
        return (BuilderType) zzl(5, null, null);
    }

    public final BuilderType zzbv() {
        BuilderType buildertype = (BuilderType) zzl(5, null, null);
        buildertype.zzay(this);
        return buildertype;
    }

    protected abstract Object zzl(int i, Object obj, Object obj2);
}
