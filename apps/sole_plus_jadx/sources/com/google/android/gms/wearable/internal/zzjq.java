package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.Preconditions;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
public final class zzjq extends zzfr {
    private ListenerHolder zza;
    private ListenerHolder zzb;
    private ListenerHolder zzc;
    private ListenerHolder zzd;
    private ListenerHolder zze;
    private final IntentFilter[] zzf;

    @Nullable
    private final String zzg;

    private zzjq(IntentFilter[] intentFilterArr, @Nullable String str) {
        this.zzf = (IntentFilter[]) Preconditions.checkNotNull(intentFilterArr);
        this.zzg = str;
    }

    public static zzjq zzl(ListenerHolder listenerHolder, IntentFilter[] intentFilterArr) {
        zzjq zzjqVar = new zzjq(intentFilterArr, null);
        zzjqVar.zze = (ListenerHolder) Preconditions.checkNotNull(listenerHolder);
        return zzjqVar;
    }

    public static zzjq zzn(ListenerHolder listenerHolder, IntentFilter[] intentFilterArr) {
        zzjq zzjqVar = new zzjq(intentFilterArr, null);
        zzjqVar.zzd = (ListenerHolder) Preconditions.checkNotNull(listenerHolder);
        return zzjqVar;
    }

    public static zzjq zzo(ListenerHolder listenerHolder, String str, IntentFilter[] intentFilterArr) {
        zzjq zzjqVar = new zzjq(intentFilterArr, (String) Preconditions.checkNotNull(str));
        zzjqVar.zzd = (ListenerHolder) Preconditions.checkNotNull(listenerHolder);
        return zzjqVar;
    }

    public static zzjq zzp(ListenerHolder listenerHolder, IntentFilter[] intentFilterArr) {
        zzjq zzjqVar = new zzjq(intentFilterArr, null);
        zzjqVar.zza = (ListenerHolder) Preconditions.checkNotNull(listenerHolder);
        return zzjqVar;
    }

    public static zzjq zzq(ListenerHolder listenerHolder, IntentFilter[] intentFilterArr) {
        zzjq zzjqVar = new zzjq(intentFilterArr, null);
        zzjqVar.zzb = (ListenerHolder) Preconditions.checkNotNull(listenerHolder);
        return zzjqVar;
    }

    public static zzjq zzr(ListenerHolder listenerHolder, IntentFilter[] intentFilterArr) {
        zzjq zzjqVar = new zzjq(intentFilterArr, null);
        zzjqVar.zzc = (ListenerHolder) Preconditions.checkNotNull(listenerHolder);
        return zzjqVar;
    }

    private static void zzx(ListenerHolder listenerHolder) {
        if (listenerHolder != null) {
            listenerHolder.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzy(zzfn zzfnVar, boolean z, byte[] bArr) {
        try {
            zzfnVar.zzd(z, bArr);
        } catch (RemoteException e) {
            Log.e("WearableListenerStub", "Failed to send a response back", e);
        }
    }

    @Override // com.google.android.gms.wearable.internal.zzfs
    public final void zzb(zzbj zzbjVar) {
        ListenerHolder listenerHolder = this.zzd;
        if (listenerHolder != null) {
            listenerHolder.notifyListener(new zzjp(zzbjVar));
        }
    }

    @Override // com.google.android.gms.wearable.internal.zzfs
    public final void zzc(zzas zzasVar) {
        ListenerHolder listenerHolder = this.zze;
        if (listenerHolder != null) {
            listenerHolder.notifyListener(new zzjk(zzasVar));
        }
    }

    @Override // com.google.android.gms.wearable.internal.zzfs
    public final void zzd(List list) {
    }

    @Override // com.google.android.gms.wearable.internal.zzfs
    public final void zze(DataHolder dataHolder) {
        ListenerHolder listenerHolder = this.zza;
        if (listenerHolder != null) {
            listenerHolder.notifyListener(new zzjl(dataHolder));
        } else {
            dataHolder.close();
        }
    }

    @Override // com.google.android.gms.wearable.internal.zzfs
    public final void zzf(zzk zzkVar) {
    }

    @Override // com.google.android.gms.wearable.internal.zzfs
    public final void zzg(zzgp zzgpVar) {
        ListenerHolder listenerHolder = this.zzb;
        if (listenerHolder != null) {
            listenerHolder.notifyListener(new zzjm(zzgpVar));
        }
    }

    @Override // com.google.android.gms.wearable.internal.zzfs
    public final void zzh(zzhf zzhfVar) {
        zzhfVar.zzb.close();
    }

    @Override // com.google.android.gms.wearable.internal.zzfs
    public final void zzi(zzn zznVar) {
    }

    @Override // com.google.android.gms.wearable.internal.zzfs
    public final void zzj(zzhg zzhgVar) {
    }

    @Override // com.google.android.gms.wearable.internal.zzfs
    public final void zzk(zzhg zzhgVar) {
    }

    @Override // com.google.android.gms.wearable.internal.zzfs
    public final void zzm(zzgp zzgpVar, zzfn zzfnVar) {
        ListenerHolder listenerHolder = this.zzc;
        if (listenerHolder != null) {
            listenerHolder.notifyListener(new zzjo(zzgpVar, zzfnVar));
        }
    }

    @Nullable
    public final String zzs() {
        return this.zzg;
    }

    public final void zzt() {
        zzx(this.zza);
        this.zza = null;
        zzx(this.zzb);
        this.zzb = null;
        zzx(this.zzc);
        this.zzc = null;
        zzx(this.zzd);
        this.zzd = null;
        zzx(this.zze);
        this.zze = null;
    }

    public final IntentFilter[] zzu() {
        return this.zzf;
    }
}
