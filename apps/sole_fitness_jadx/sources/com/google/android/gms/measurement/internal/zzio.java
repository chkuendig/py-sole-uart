package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.0.0 */
/* loaded from: classes2.dex */
public final class zzio extends zzf {
    protected zzih zza;
    private volatile zzih zzb;
    private volatile zzih zzc;
    private final Map<Activity, zzih> zzd;
    private Activity zze;
    private volatile boolean zzf;
    private volatile zzih zzg;
    private zzih zzh;
    private boolean zzi;
    private final Object zzj;
    private zzih zzk;
    private String zzl;

    public zzio(zzfv zzfvVar) {
        super(zzfvVar);
        this.zzj = new Object();
        this.zzd = new ConcurrentHashMap();
    }

    private final void zzA(Activity activity, zzih zzihVar, boolean z) throws IllegalStateException {
        zzih zzihVar2;
        zzih zzihVar3 = this.zzb == null ? this.zzc : this.zzb;
        if (zzihVar.zzb == null) {
            zzihVar2 = new zzih(zzihVar.zza, activity != null ? zzl(activity.getClass(), "Activity") : null, zzihVar.zzc, zzihVar.zze, zzihVar.zzf);
        } else {
            zzihVar2 = zzihVar;
        }
        this.zzc = this.zzb;
        this.zzb = zzihVar2;
        this.zzs.zzaz().zzp(new zzij(this, zzihVar2, zzihVar3, this.zzs.zzav().elapsedRealtime(), z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzB(zzih zzihVar, zzih zzihVar2, long j, boolean z, Bundle bundle) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        long j2;
        long j3;
        zzg();
        boolean z2 = false;
        boolean z3 = (zzihVar2 != null && zzihVar2.zzc == zzihVar.zzc && zzkz.zzak(zzihVar2.zzb, zzihVar.zzb) && zzkz.zzak(zzihVar2.zza, zzihVar.zza)) ? false : true;
        if (z && this.zza != null) {
            z2 = true;
        }
        if (z3) {
            Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
            zzkz.zzJ(zzihVar, bundle2, true);
            if (zzihVar2 != null) {
                String str = zzihVar2.zza;
                if (str != null) {
                    bundle2.putString("_pn", str);
                }
                String str2 = zzihVar2.zzb;
                if (str2 != null) {
                    bundle2.putString("_pc", str2);
                }
                bundle2.putLong("_pi", zzihVar2.zzc);
            }
            if (z2) {
                zzkb zzkbVar = this.zzs.zzu().zzb;
                long j4 = j - zzkbVar.zzb;
                zzkbVar.zzb = j;
                if (j4 > 0) {
                    this.zzs.zzv().zzH(bundle2, j4);
                }
            }
            if (!this.zzs.zzf().zzu()) {
                bundle2.putLong("_mst", 1L);
            }
            String str3 = true != zzihVar.zze ? "auto" : "app";
            long jCurrentTimeMillis = this.zzs.zzav().currentTimeMillis();
            if (zzihVar.zze) {
                j2 = jCurrentTimeMillis;
                long j5 = zzihVar.zzf;
                if (j5 != 0) {
                    j3 = j5;
                }
                this.zzs.zzq().zzH(str3, "_vs", j3, bundle2);
            } else {
                j2 = jCurrentTimeMillis;
            }
            j3 = j2;
            this.zzs.zzq().zzH(str3, "_vs", j3, bundle2);
        }
        if (z2) {
            zzC(this.zza, true, j);
        }
        this.zza = zzihVar;
        if (zzihVar.zze) {
            this.zzh = zzihVar;
        }
        this.zzs.zzt().zzG(zzihVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzC(zzih zzihVar, boolean z, long j) {
        this.zzs.zzd().zzf(this.zzs.zzav().elapsedRealtime());
        if (!this.zzs.zzu().zzb.zzd(zzihVar != null && zzihVar.zzd, z, j) || zzihVar == null) {
            return;
        }
        zzihVar.zzd = false;
    }

    static /* bridge */ /* synthetic */ void zzp(zzio zzioVar, Bundle bundle, zzih zzihVar, zzih zzihVar2, long j) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        bundle.remove(FirebaseAnalytics.Param.SCREEN_NAME);
        bundle.remove(FirebaseAnalytics.Param.SCREEN_CLASS);
        zzioVar.zzB(zzihVar, zzihVar2, j, true, zzioVar.zzs.zzv().zzy(null, FirebaseAnalytics.Event.SCREEN_VIEW, bundle, null, false));
    }

    private final zzih zzz(Activity activity) {
        Preconditions.checkNotNull(activity);
        zzih zzihVar = this.zzd.get(activity);
        if (zzihVar == null) {
            zzih zzihVar2 = new zzih(null, zzl(activity.getClass(), "Activity"), this.zzs.zzv().zzq());
            this.zzd.put(activity, zzihVar2);
            zzihVar = zzihVar2;
        }
        return this.zzg != null ? this.zzg : zzihVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    protected final boolean zzf() {
        return false;
    }

    public final zzih zzi() {
        return this.zzb;
    }

    public final zzih zzj(boolean z) {
        zza();
        zzg();
        if (!z) {
            return this.zza;
        }
        zzih zzihVar = this.zza;
        return zzihVar != null ? zzihVar : this.zzh;
    }

    final String zzl(Class<?> cls, String str) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            return "Activity";
        }
        String[] strArrSplit = canonicalName.split("\\.");
        int length = strArrSplit.length;
        String str2 = length > 0 ? strArrSplit[length - 1] : "";
        int length2 = str2.length();
        this.zzs.zzf();
        if (length2 <= 100) {
            return str2;
        }
        this.zzs.zzf();
        return str2.substring(0, 100);
    }

    public final void zzr(Activity activity, Bundle bundle) {
        Bundle bundle2;
        if (!this.zzs.zzf().zzu() || bundle == null || (bundle2 = bundle.getBundle("com.google.app_measurement.screen_service")) == null) {
            return;
        }
        this.zzd.put(activity, new zzih(bundle2.getString("name"), bundle2.getString("referrer_name"), bundle2.getLong("id")));
    }

    public final void zzs(Activity activity) {
        synchronized (this.zzj) {
            if (activity == this.zze) {
                this.zze = null;
            }
        }
        if (this.zzs.zzf().zzu()) {
            this.zzd.remove(activity);
        }
    }

    public final void zzt(Activity activity) throws IllegalStateException {
        synchronized (this.zzj) {
            this.zzi = false;
            this.zzf = true;
        }
        long jElapsedRealtime = this.zzs.zzav().elapsedRealtime();
        if (!this.zzs.zzf().zzu()) {
            this.zzb = null;
            this.zzs.zzaz().zzp(new zzil(this, jElapsedRealtime));
        } else {
            zzih zzihVarZzz = zzz(activity);
            this.zzc = this.zzb;
            this.zzb = null;
            this.zzs.zzaz().zzp(new zzim(this, zzihVarZzz, jElapsedRealtime));
        }
    }

    public final void zzu(Activity activity) throws IllegalStateException {
        synchronized (this.zzj) {
            this.zzi = true;
            if (activity != this.zze) {
                synchronized (this.zzj) {
                    this.zze = activity;
                    this.zzf = false;
                }
                if (this.zzs.zzf().zzu()) {
                    this.zzg = null;
                    this.zzs.zzaz().zzp(new zzin(this));
                }
            }
        }
        if (!this.zzs.zzf().zzu()) {
            this.zzb = this.zzg;
            this.zzs.zzaz().zzp(new zzik(this));
        } else {
            zzA(activity, zzz(activity), false);
            zzd zzdVarZzd = this.zzs.zzd();
            zzdVarZzd.zzs.zzaz().zzp(new zzc(zzdVarZzd, zzdVarZzd.zzs.zzav().elapsedRealtime()));
        }
    }

    public final void zzv(Activity activity, Bundle bundle) {
        zzih zzihVar;
        if (!this.zzs.zzf().zzu() || bundle == null || (zzihVar = this.zzd.get(activity)) == null) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putLong("id", zzihVar.zzc);
        bundle2.putString("name", zzihVar.zza);
        bundle2.putString("referrer_name", zzihVar.zzb);
        bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0088, code lost:
    
        if (r5.length() <= 100) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b4, code lost:
    
        if (r6.length() <= 100) goto L39;
     */
    @Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzw(Activity activity, String str, String str2) throws IllegalStateException {
        if (!this.zzs.zzf().zzu()) {
            this.zzs.zzay().zzl().zza("setCurrentScreen cannot be called while screen reporting is disabled.");
            return;
        }
        zzih zzihVar = this.zzb;
        if (zzihVar == null) {
            this.zzs.zzay().zzl().zza("setCurrentScreen cannot be called while no activity active");
            return;
        }
        if (this.zzd.get(activity) == null) {
            this.zzs.zzay().zzl().zza("setCurrentScreen must be called with an activity in the activity lifecycle");
            return;
        }
        if (str2 == null) {
            str2 = zzl(activity.getClass(), "Activity");
        }
        boolean zZzak = zzkz.zzak(zzihVar.zzb, str2);
        boolean zZzak2 = zzkz.zzak(zzihVar.zza, str);
        if (zZzak && zZzak2) {
            this.zzs.zzay().zzl().zza("setCurrentScreen cannot be called with the same class and name");
            return;
        }
        if (str != null) {
            if (str.length() > 0) {
                this.zzs.zzf();
            }
            this.zzs.zzay().zzl().zzb("Invalid screen name length in setCurrentScreen. Length", Integer.valueOf(str.length()));
            return;
        }
        if (str2 != null) {
            if (str2.length() > 0) {
                this.zzs.zzf();
            }
            this.zzs.zzay().zzl().zzb("Invalid class name length in setCurrentScreen. Length", Integer.valueOf(str2.length()));
            return;
        }
        this.zzs.zzay().zzj().zzc("Setting current screen to name, class", str == null ? "null" : str, str2);
        zzih zzihVar2 = new zzih(str, str2, this.zzs.zzv().zzq());
        this.zzd.put(activity, zzihVar2);
        zzA(activity, zzihVar2, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0031, code lost:
    
        if (r2 > 100) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0063, code lost:
    
        if (r4 > 100) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzx(Bundle bundle, long j) {
        String strZzl;
        synchronized (this.zzj) {
            if (!this.zzi) {
                this.zzs.zzay().zzl().zza("Cannot log screen view event when the app is in the background.");
                return;
            }
            String string = bundle.getString(FirebaseAnalytics.Param.SCREEN_NAME);
            if (string != null) {
                if (string.length() > 0) {
                    int length = string.length();
                    this.zzs.zzf();
                }
                this.zzs.zzay().zzl().zzb("Invalid screen name length for screen view. Length", Integer.valueOf(string.length()));
                return;
            }
            String string2 = bundle.getString(FirebaseAnalytics.Param.SCREEN_CLASS);
            if (string2 != null) {
                if (string2.length() > 0) {
                    int length2 = string2.length();
                    this.zzs.zzf();
                }
                this.zzs.zzay().zzl().zzb("Invalid screen class length for screen view. Length", Integer.valueOf(string2.length()));
                return;
            }
            if (string2 == null) {
                Activity activity = this.zze;
                strZzl = activity != null ? zzl(activity.getClass(), "Activity") : "Activity";
            } else {
                strZzl = string2;
            }
            zzih zzihVar = this.zzb;
            if (this.zzf && zzihVar != null) {
                this.zzf = false;
                boolean zZzak = zzkz.zzak(zzihVar.zzb, strZzl);
                boolean zZzak2 = zzkz.zzak(zzihVar.zza, string);
                if (zZzak && zZzak2) {
                    this.zzs.zzay().zzl().zza("Ignoring call to log screen view event with duplicate parameters.");
                    return;
                }
            }
            this.zzs.zzay().zzj().zzc("Logging screen view with name, class", string == null ? "null" : string, strZzl == null ? "null" : strZzl);
            zzih zzihVar2 = this.zzb == null ? this.zzc : this.zzb;
            zzih zzihVar3 = new zzih(string, strZzl, this.zzs.zzv().zzq(), true, j);
            this.zzb = zzihVar3;
            this.zzc = zzihVar2;
            this.zzg = zzihVar3;
            this.zzs.zzaz().zzp(new zzii(this, bundle, zzihVar3, zzihVar2, this.zzs.zzav().elapsedRealtime()));
        }
    }

    public final void zzy(String str, zzih zzihVar) {
        zzg();
        synchronized (this) {
            String str2 = this.zzl;
            if (str2 == null || str2.equals(str) || zzihVar != null) {
                this.zzl = str;
                this.zzk = zzihVar;
            }
        }
    }
}
