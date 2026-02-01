package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement@@20.0.0 */
/* loaded from: classes2.dex */
final class zzet extends BroadcastReceiver {
    static final String zza = "com.google.android.gms.measurement.internal.zzet";
    private final zzks zzb;
    private boolean zzc;
    private boolean zzd;

    zzet(zzks zzksVar) {
        Preconditions.checkNotNull(zzksVar);
        this.zzb = zzksVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) throws IllegalStateException {
        this.zzb.zzB();
        String action = intent.getAction();
        this.zzb.zzay().zzj().zzb("NetworkBroadcastReceiver received action", action);
        if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            this.zzb.zzay().zzk().zzb("NetworkBroadcastReceiver received unknown action", action);
            return;
        }
        boolean zZza = this.zzb.zzl().zza();
        if (this.zzd != zZza) {
            this.zzd = zZza;
            this.zzb.zzaz().zzp(new zzes(this, zZza));
        }
    }

    public final void zzb() {
        this.zzb.zzB();
        this.zzb.zzaz().zzg();
        if (this.zzc) {
            return;
        }
        this.zzb.zzau().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        this.zzd = this.zzb.zzl().zza();
        this.zzb.zzay().zzj().zzb("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.zzd));
        this.zzc = true;
    }

    public final void zzc() {
        this.zzb.zzB();
        this.zzb.zzaz().zzg();
        this.zzb.zzaz().zzg();
        if (this.zzc) {
            this.zzb.zzay().zzj().zza("Unregistering connectivity change receiver");
            this.zzc = false;
            this.zzd = false;
            try {
                this.zzb.zzau().unregisterReceiver(this);
            } catch (IllegalArgumentException e) {
                this.zzb.zzay().zzd().zzb("Failed to unregister the network broadcast receiver", e);
            }
        }
    }
}
