package com.google.android.gms.measurement.internal;

import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.firebase.messaging.Constants;

/* compiled from: com.google.android.gms:play-services-measurement@@20.0.0 */
/* loaded from: classes2.dex */
final class zzfb implements Runnable {
    final /* synthetic */ com.google.android.gms.internal.measurement.zzbr zza;
    final /* synthetic */ ServiceConnection zzb;
    final /* synthetic */ zzfc zzc;

    zzfb(zzfc zzfcVar, com.google.android.gms.internal.measurement.zzbr zzbrVar, ServiceConnection serviceConnection) {
        this.zzc = zzfcVar;
        this.zza = zzbrVar;
        this.zzb = serviceConnection;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x012d  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() throws IllegalStateException {
        zzfc zzfcVar = this.zzc;
        zzfd zzfdVar = zzfcVar.zza;
        String str = zzfcVar.zzb;
        com.google.android.gms.internal.measurement.zzbr zzbrVar = this.zza;
        ServiceConnection serviceConnection = this.zzb;
        zzfdVar.zza.zzaz().zzg();
        Bundle bundle = new Bundle();
        bundle.putString("package_name", str);
        Bundle bundle2 = null;
        try {
            Bundle bundleZzd = zzbrVar.zzd(bundle);
            if (bundleZzd == null) {
                zzfdVar.zza.zzay().zzd().zza("Install Referrer Service returned a null response");
            } else {
                bundle2 = bundleZzd;
            }
        } catch (Exception e) {
            zzfdVar.zza.zzay().zzd().zzb("Exception occurred while retrieving the Install Referrer", e.getMessage());
        }
        zzfdVar.zza.zzaz().zzg();
        zzfv.zzO();
        if (bundle2 != null) {
            long j = bundle2.getLong("install_begin_timestamp_seconds", 0L) * 1000;
            if (j == 0) {
                zzfdVar.zza.zzay().zzk().zza("Service response is missing Install Referrer install timestamp");
            } else {
                String string = bundle2.getString("install_referrer");
                if (string == null || string.isEmpty()) {
                    zzfdVar.zza.zzay().zzd().zza("No referrer defined in Install Referrer response");
                } else {
                    zzfdVar.zza.zzay().zzj().zzb("InstallReferrer API result", string);
                    Bundle bundleZzs = zzfdVar.zza.zzv().zzs(Uri.parse(string.length() != 0 ? "?".concat(string) : new String("?")));
                    if (bundleZzs == null) {
                        zzfdVar.zza.zzay().zzd().zza("No campaign params defined in Install Referrer result");
                    } else {
                        String string2 = bundleZzs.getString("medium");
                        if (string2 == null || "(not set)".equalsIgnoreCase(string2) || "organic".equalsIgnoreCase(string2)) {
                            if (j == zzfdVar.zza.zzm().zzd.zza()) {
                                zzfdVar.zza.zzay().zzj().zza("Logging Install Referrer campaign from module while it may have already been logged.");
                            }
                            if (zzfdVar.zza.zzJ()) {
                                zzfdVar.zza.zzm().zzd.zzb(j);
                                zzfdVar.zza.zzay().zzj().zzb("Logging Install Referrer campaign from gmscore with ", "referrer API v2");
                                bundleZzs.putString("_cis", "referrer API v2");
                                zzfdVar.zza.zzq().zzF("auto", Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN, bundleZzs, str);
                            }
                        } else {
                            long j2 = bundle2.getLong("referrer_click_timestamp_seconds", 0L) * 1000;
                            if (j2 == 0) {
                                zzfdVar.zza.zzay().zzd().zza("Install Referrer is missing click timestamp for ad campaign");
                            } else {
                                bundleZzs.putLong("click_timestamp", j2);
                                if (j == zzfdVar.zza.zzm().zzd.zza()) {
                                }
                                if (zzfdVar.zza.zzJ()) {
                                }
                            }
                        }
                    }
                }
            }
        }
        ConnectionTracker.getInstance().unbindService(zzfdVar.zza.zzau(), serviceConnection);
    }
}
