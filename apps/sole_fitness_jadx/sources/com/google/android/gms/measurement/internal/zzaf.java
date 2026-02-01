package com.google.android.gms.measurement.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.dyaco.sole.R2;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.android.gms.common.wrappers.Wrappers;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.0.0 */
/* loaded from: classes2.dex */
public final class zzaf extends zzgo {
    private Boolean zza;
    private zzae zzb;
    private Boolean zzc;

    zzaf(zzfv zzfvVar) {
        super(zzfvVar);
        this.zzb = new zzae() { // from class: com.google.android.gms.measurement.internal.zzad
            @Override // com.google.android.gms.measurement.internal.zzae
            public final String zza(String str, String str2) {
                return null;
            }
        };
    }

    public static final long zzA() {
        return zzdy.zzC.zza(null).longValue();
    }

    private final String zzB(String str, String str2) {
        try {
            String str3 = (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, "");
            Preconditions.checkNotNull(str3);
            return str3;
        } catch (ClassNotFoundException e) {
            this.zzs.zzay().zzd().zzb("Could not find SystemProperties class", e);
            return "";
        } catch (IllegalAccessException e2) {
            this.zzs.zzay().zzd().zzb("Could not access SystemProperties.get()", e2);
            return "";
        } catch (NoSuchMethodException e3) {
            this.zzs.zzay().zzd().zzb("Could not find SystemProperties.get() method", e3);
            return "";
        } catch (InvocationTargetException e4) {
            this.zzs.zzay().zzd().zzb("SystemProperties.get() threw an exception", e4);
            return "";
        }
    }

    public static final long zzz() {
        return zzdy.zzc.zza(null).longValue();
    }

    public final double zza(String str, zzdx<Double> zzdxVar) {
        if (str == null) {
            return zzdxVar.zza(null).doubleValue();
        }
        String strZza = this.zzb.zza(str, zzdxVar.zzb());
        if (TextUtils.isEmpty(strZza)) {
            return zzdxVar.zza(null).doubleValue();
        }
        try {
            return zzdxVar.zza(Double.valueOf(Double.parseDouble(strZza))).doubleValue();
        } catch (NumberFormatException unused) {
            return zzdxVar.zza(null).doubleValue();
        }
    }

    final int zzb(String str) {
        return zzf(str, zzdy.zzG, 500, R2.drawable.notification_bg_normal);
    }

    public final int zzc() {
        zzkz zzkzVarZzv = this.zzs.zzv();
        Boolean boolZzj = zzkzVarZzv.zzs.zzt().zzj();
        if (zzkzVarZzv.zzm() < 201500) {
            return (boolZzj == null || boolZzj.booleanValue()) ? 25 : 100;
        }
        return 100;
    }

    public final int zzd(String str) {
        return zzf(str, zzdy.zzH, 25, 100);
    }

    public final int zze(String str, zzdx<Integer> zzdxVar) {
        if (str == null) {
            return zzdxVar.zza(null).intValue();
        }
        String strZza = this.zzb.zza(str, zzdxVar.zzb());
        if (TextUtils.isEmpty(strZza)) {
            return zzdxVar.zza(null).intValue();
        }
        try {
            return zzdxVar.zza(Integer.valueOf(Integer.parseInt(strZza))).intValue();
        } catch (NumberFormatException unused) {
            return zzdxVar.zza(null).intValue();
        }
    }

    public final int zzf(String str, zzdx<Integer> zzdxVar, int i, int i2) {
        return Math.max(Math.min(zze(str, zzdxVar), i2), i);
    }

    public final long zzh() {
        this.zzs.zzaw();
        return 46000L;
    }

    public final long zzi(String str, zzdx<Long> zzdxVar) {
        if (str == null) {
            return zzdxVar.zza(null).longValue();
        }
        String strZza = this.zzb.zza(str, zzdxVar.zzb());
        if (TextUtils.isEmpty(strZza)) {
            return zzdxVar.zza(null).longValue();
        }
        try {
            return zzdxVar.zza(Long.valueOf(Long.parseLong(strZza))).longValue();
        } catch (NumberFormatException unused) {
            return zzdxVar.zza(null).longValue();
        }
    }

    final Bundle zzj() {
        try {
            if (this.zzs.zzau().getPackageManager() == null) {
                this.zzs.zzay().zzd().zza("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo applicationInfo = Wrappers.packageManager(this.zzs.zzau()).getApplicationInfo(this.zzs.zzau().getPackageName(), 128);
            if (applicationInfo != null) {
                return applicationInfo.metaData;
            }
            this.zzs.zzay().zzd().zza("Failed to load metadata: ApplicationInfo is null");
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            this.zzs.zzay().zzd().zzb("Failed to load metadata: Package name not found", e);
            return null;
        }
    }

    final Boolean zzk(String str) {
        Preconditions.checkNotEmpty(str);
        Bundle bundleZzj = zzj();
        if (bundleZzj == null) {
            this.zzs.zzay().zzd().zza("Failed to load metadata: Metadata bundle is null");
            return null;
        }
        if (bundleZzj.containsKey(str)) {
            return Boolean.valueOf(bundleZzj.getBoolean(str));
        }
        return null;
    }

    public final String zzl() {
        return zzB("debug.firebase.analytics.app", "");
    }

    public final String zzm() {
        return zzB("debug.deferred.deeplink", "");
    }

    final String zzn() {
        this.zzs.zzaw();
        return "FA";
    }

    public final String zzo(String str, zzdx<String> zzdxVar) {
        return str == null ? zzdxVar.zza(null) : zzdxVar.zza(this.zzb.zza(str, zzdxVar.zzb()));
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x002e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final List<String> zzp(String str) throws Resources.NotFoundException {
        Integer numValueOf;
        Preconditions.checkNotEmpty("analytics.safelisted_events");
        Bundle bundleZzj = zzj();
        if (bundleZzj != null) {
            if (bundleZzj.containsKey("analytics.safelisted_events")) {
                numValueOf = Integer.valueOf(bundleZzj.getInt("analytics.safelisted_events"));
            }
            if (numValueOf != null) {
                try {
                    String[] stringArray = this.zzs.zzau().getResources().getStringArray(numValueOf.intValue());
                    if (stringArray == null) {
                        return null;
                    }
                    return Arrays.asList(stringArray);
                } catch (Resources.NotFoundException e) {
                    this.zzs.zzay().zzd().zzb("Failed to load string array from metadata: resource not found", e);
                }
            }
            return null;
        }
        this.zzs.zzay().zzd().zza("Failed to load metadata: Metadata bundle is null");
        numValueOf = null;
        if (numValueOf != null) {
        }
        return null;
    }

    final void zzq(zzae zzaeVar) {
        this.zzb = zzaeVar;
    }

    public final boolean zzr() {
        Boolean boolZzk = zzk("google_analytics_adid_collection_enabled");
        return boolZzk == null || boolZzk.booleanValue();
    }

    public final boolean zzs(String str, zzdx<Boolean> zzdxVar) {
        if (str == null) {
            return zzdxVar.zza(null).booleanValue();
        }
        String strZza = this.zzb.zza(str, zzdxVar.zzb());
        if (TextUtils.isEmpty(strZza)) {
            return zzdxVar.zza(null).booleanValue();
        }
        return zzdxVar.zza(Boolean.valueOf(this.zzs.zzf().zzs(null, zzdy.zzaB) ? AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(strZza) : Boolean.parseBoolean(strZza))).booleanValue();
    }

    public final boolean zzt(String str) {
        return AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(this.zzb.zza(str, "gaia_collection_enabled"));
    }

    public final boolean zzu() {
        Boolean boolZzk = zzk("google_analytics_automatic_screen_reporting_enabled");
        return boolZzk == null || boolZzk.booleanValue();
    }

    public final boolean zzv() {
        this.zzs.zzaw();
        Boolean boolZzk = zzk("firebase_analytics_collection_deactivated");
        return boolZzk != null && boolZzk.booleanValue();
    }

    public final boolean zzw(String str) {
        return AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(this.zzb.zza(str, "measurement.event_sampling_enabled"));
    }

    final boolean zzx() {
        if (this.zza == null) {
            Boolean boolZzk = zzk("app_measurement_lite");
            this.zza = boolZzk;
            if (boolZzk == null) {
                this.zza = false;
            }
        }
        return this.zza.booleanValue() || !this.zzs.zzN();
    }

    @EnsuresNonNull({"this.isMainProcess"})
    public final boolean zzy() {
        if (this.zzc == null) {
            synchronized (this) {
                if (this.zzc == null) {
                    ApplicationInfo applicationInfo = this.zzs.zzau().getApplicationInfo();
                    String myProcessName = ProcessUtils.getMyProcessName();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        boolean z = false;
                        if (str != null && str.equals(myProcessName)) {
                            z = true;
                        }
                        this.zzc = Boolean.valueOf(z);
                    }
                    if (this.zzc == null) {
                        this.zzc = Boolean.TRUE;
                        this.zzs.zzay().zzd().zza("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.zzc.booleanValue();
    }
}
