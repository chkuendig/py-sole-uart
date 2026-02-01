package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.measurement.zznu;
import com.google.android.gms.internal.measurement.zznx;
import com.google.android.gms.internal.measurement.zzod;
import com.google.android.gms.internal.measurement.zzpn;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.0.0 */
/* loaded from: classes2.dex */
public final class zzia extends zzf {
    protected zzhz zza;
    final zzr zzb;
    protected boolean zzc;
    private zzgv zzd;
    private final Set<zzgw> zze;
    private boolean zzf;
    private final AtomicReference<String> zzg;
    private final Object zzh;
    private zzag zzi;
    private int zzj;
    private final AtomicLong zzk;
    private long zzl;
    private int zzm;
    private final zzky zzn;

    protected zzia(zzfv zzfvVar) {
        super(zzfvVar);
        this.zze = new CopyOnWriteArraySet();
        this.zzh = new Object();
        this.zzc = true;
        this.zzn = new zzho(this);
        this.zzg = new AtomicReference<>();
        this.zzi = new zzag(null, null);
        this.zzj = 100;
        this.zzl = -1L;
        this.zzm = 100;
        this.zzk = new AtomicLong(0L);
        this.zzb = new zzr(zzfvVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zzab, reason: merged with bridge method [inline-methods] */
    public final void zzB(Bundle bundle, long j) {
        zznx.zzc();
        if (!this.zzs.zzf().zzs(null, zzdy.zzar) || TextUtils.isEmpty(this.zzs.zzh().zzn())) {
            zzR(bundle, 0, j);
        } else {
            this.zzs.zzay().zzl().zza("Using developer consent only; google app id found");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzac(Boolean bool, boolean z) throws IllegalStateException {
        zzg();
        zza();
        this.zzs.zzay().zzc().zzb("Setting app measurement enabled (FE)", bool);
        this.zzs.zzm().zzh(bool);
        if (z) {
            zzfa zzfaVarZzm = this.zzs.zzm();
            zzfv zzfvVar = zzfaVarZzm.zzs;
            zzfaVarZzm.zzg();
            SharedPreferences.Editor editorEdit = zzfaVarZzm.zza().edit();
            if (bool != null) {
                editorEdit.putBoolean("measurement_enabled_from_api", bool.booleanValue());
            } else {
                editorEdit.remove("measurement_enabled_from_api");
            }
            editorEdit.apply();
        }
        if (this.zzs.zzK() || !(bool == null || bool.booleanValue())) {
            zzad();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzad() throws IllegalStateException {
        zzg();
        String strZza = this.zzs.zzm().zzh.zza();
        if (strZza != null) {
            if ("unset".equals(strZza)) {
                zzZ("app", "_npa", null, this.zzs.zzav().currentTimeMillis());
            } else {
                zzZ("app", "_npa", Long.valueOf(true != ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(strZza) ? 0L : 1L), this.zzs.zzav().currentTimeMillis());
            }
        }
        if (!this.zzs.zzJ() || !this.zzc) {
            this.zzs.zzay().zzc().zza("Updating Scion state (FE)");
            this.zzs.zzt().zzI();
            return;
        }
        this.zzs.zzay().zzc().zza("Recording app launch after enabling measurement for the first time (FE)");
        zzy();
        zzod.zzc();
        if (this.zzs.zzf().zzs(null, zzdy.zzai)) {
            this.zzs.zzu().zza.zza();
        }
        this.zzs.zzaz().zzp(new zzhd(this));
    }

    static /* synthetic */ void zzv(zzia zziaVar, zzag zzagVar, int i, long j, boolean z, boolean z2) {
        zziaVar.zzg();
        zziaVar.zza();
        if (j <= zziaVar.zzl && zzag.zzl(zziaVar.zzm, i)) {
            zziaVar.zzs.zzay().zzi().zzb("Dropped out-of-date consent setting, proposed settings", zzagVar);
            return;
        }
        zzfa zzfaVarZzm = zziaVar.zzs.zzm();
        zzfv zzfvVar = zzfaVarZzm.zzs;
        zzfaVarZzm.zzg();
        if (!zzfaVarZzm.zzl(i)) {
            zziaVar.zzs.zzay().zzi().zzb("Lower precedence consent source ignored, proposed source", Integer.valueOf(i));
            return;
        }
        SharedPreferences.Editor editorEdit = zzfaVarZzm.zza().edit();
        editorEdit.putString("consent_settings", zzagVar.zzi());
        editorEdit.putInt("consent_source", i);
        editorEdit.apply();
        zziaVar.zzl = j;
        zziaVar.zzm = i;
        zziaVar.zzs.zzt().zzF(z);
        if (z2) {
            zziaVar.zzs.zzt().zzu(new AtomicReference<>());
        }
    }

    public final void zzA() {
        if (!(this.zzs.zzau().getApplicationContext() instanceof Application) || this.zza == null) {
            return;
        }
        ((Application) this.zzs.zzau().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.zza);
    }

    final /* synthetic */ void zzC(Bundle bundle) {
        if (bundle == null) {
            this.zzs.zzm().zzr.zzb(new Bundle());
            return;
        }
        Bundle bundleZza = this.zzs.zzm().zzr.zza();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj != null && !(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Double)) {
                if (this.zzs.zzv().zzae(obj)) {
                    this.zzs.zzv().zzM(this.zzn, null, 27, null, null, 0);
                }
                this.zzs.zzay().zzl().zzc("Invalid default event parameter type. Name, value", str, obj);
            } else if (zzkz.zzag(str)) {
                this.zzs.zzay().zzl().zzb("Invalid default event parameter name. Name", str);
            } else if (obj == null) {
                bundleZza.remove(str);
            } else {
                zzkz zzkzVarZzv = this.zzs.zzv();
                this.zzs.zzf();
                if (zzkzVarZzv.zzZ("param", str, 100, obj)) {
                    this.zzs.zzv().zzN(bundleZza, str, obj);
                }
            }
        }
        this.zzs.zzv();
        int iZzc = this.zzs.zzf().zzc();
        if (bundleZza.size() > iZzc) {
            int i = 0;
            for (String str2 : new TreeSet(bundleZza.keySet())) {
                i++;
                if (i > iZzc) {
                    bundleZza.remove(str2);
                }
            }
            this.zzs.zzv().zzM(this.zzn, null, 26, null, null, 0);
            this.zzs.zzay().zzl().zza("Too many default event parameters set. Discarding beyond event parameter limit");
        }
        this.zzs.zzm().zzr.zzb(bundleZza);
        this.zzs.zzt().zzH(bundleZza);
    }

    public final void zzD(String str, String str2, Bundle bundle) throws IllegalStateException {
        zzE(str, str2, bundle, true, true, this.zzs.zzav().currentTimeMillis());
    }

    public final void zzE(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) throws IllegalStateException {
        String str3 = str == null ? "app" : str;
        Bundle bundle2 = bundle == null ? new Bundle() : bundle;
        if (zzkz.zzak(str2, FirebaseAnalytics.Event.SCREEN_VIEW)) {
            this.zzs.zzs().zzx(bundle2, j);
            return;
        }
        boolean z3 = true;
        if (z2 && this.zzd != null && !zzkz.zzag(str2)) {
            z3 = false;
        }
        zzM(str3, str2, j, bundle2, z2, z3, z, null);
    }

    public final void zzF(String str, String str2, Bundle bundle, String str3) throws IllegalStateException {
        zzfv.zzO();
        zzM("auto", str2, this.zzs.zzav().currentTimeMillis(), bundle, false, true, true, str3);
    }

    final void zzG(String str, String str2, Bundle bundle) {
        zzg();
        zzH(str, str2, this.zzs.zzav().currentTimeMillis(), bundle);
    }

    final void zzH(String str, String str2, long j, Bundle bundle) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        zzg();
        zzI(str, str2, j, bundle, true, this.zzd == null || zzkz.zzag(str2), true, null);
    }

    protected final void zzI(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        boolean z4;
        String str4;
        long j2;
        String str5;
        String str6;
        Bundle[] bundleArr;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(bundle);
        zzg();
        zza();
        if (!this.zzs.zzJ()) {
            this.zzs.zzay().zzc().zza("Event not sent since app measurement is disabled");
            return;
        }
        List<String> listZzo = this.zzs.zzh().zzo();
        if (listZzo != null && !listZzo.contains(str2)) {
            this.zzs.zzay().zzc().zzc("Dropping non-safelisted event. event name, origin", str2, str);
            return;
        }
        if (!this.zzf) {
            this.zzf = true;
            try {
                try {
                    (!this.zzs.zzN() ? Class.forName("com.google.android.gms.tagmanager.TagManagerService", true, this.zzs.zzau().getClassLoader()) : Class.forName("com.google.android.gms.tagmanager.TagManagerService")).getDeclaredMethod("initialize", Context.class).invoke(null, this.zzs.zzau());
                } catch (Exception e) {
                    this.zzs.zzay().zzk().zzb("Failed to invoke Tag Manager's initialize() method", e);
                }
            } catch (ClassNotFoundException unused) {
                this.zzs.zzay().zzi().zza("Tag Manager is not found and thus will not be used");
            }
        }
        if (Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN.equals(str2) && bundle.containsKey("gclid")) {
            this.zzs.zzaw();
            zzZ("auto", "_lgclid", bundle.getString("gclid"), this.zzs.zzav().currentTimeMillis());
        }
        this.zzs.zzaw();
        if (z && zzkz.zzal(str2)) {
            this.zzs.zzv().zzK(bundle, this.zzs.zzm().zzr.zza());
        }
        if (!z3) {
            this.zzs.zzaw();
            if (!"_iap".equals(str2)) {
                zzkz zzkzVarZzv = this.zzs.zzv();
                int i = 2;
                if (zzkzVarZzv.zzab("event", str2)) {
                    if (zzkzVarZzv.zzY("event", zzgs.zza, zzgs.zzb, str2)) {
                        zzkzVarZzv.zzs.zzf();
                        if (zzkzVarZzv.zzX("event", 40, str2)) {
                            i = 0;
                        }
                    } else {
                        i = 13;
                    }
                }
                if (i != 0) {
                    this.zzs.zzay().zze().zzb("Invalid public event name. Event will not be logged (FE)", this.zzs.zzj().zzd(str2));
                    zzkz zzkzVarZzv2 = this.zzs.zzv();
                    this.zzs.zzf();
                    this.zzs.zzv().zzM(this.zzn, null, i, "_ev", zzkzVarZzv2.zzC(str2, 40, true), str2 != null ? str2.length() : 0);
                    return;
                }
            }
        }
        zzpn.zzc();
        if (this.zzs.zzf().zzs(null, zzdy.zzaA)) {
            this.zzs.zzaw();
            zzih zzihVarZzj = this.zzs.zzs().zzj(false);
            if (zzihVarZzj != null && !bundle.containsKey("_sc")) {
                zzihVarZzj.zzd = true;
            }
            zzkz.zzJ(zzihVarZzj, bundle, z && !z3);
        } else {
            this.zzs.zzaw();
            zzih zzihVarZzj2 = this.zzs.zzs().zzj(false);
            if (zzihVarZzj2 != null && !bundle.containsKey("_sc")) {
                zzihVarZzj2.zzd = true;
            }
            zzkz.zzJ(zzihVarZzj2, bundle, z && !z3);
        }
        boolean zEquals = "am".equals(str);
        boolean zZzag = zzkz.zzag(str2);
        if (!z || this.zzd == null || zZzag) {
            z4 = zEquals;
        } else {
            if (!zEquals) {
                this.zzs.zzay().zzc().zzc("Passing event to registered event handler (FE)", this.zzs.zzj().zzd(str2), this.zzs.zzj().zzb(bundle));
                Preconditions.checkNotNull(this.zzd);
                this.zzd.interceptEvent(str, str2, bundle, j);
                return;
            }
            z4 = true;
        }
        if (this.zzs.zzM()) {
            int iZzh = this.zzs.zzv().zzh(str2);
            if (iZzh != 0) {
                this.zzs.zzay().zze().zzb("Invalid event name. Event will not be logged (FE)", this.zzs.zzj().zzd(str2));
                zzkz zzkzVarZzv3 = this.zzs.zzv();
                this.zzs.zzf();
                this.zzs.zzv().zzM(this.zzn, str3, iZzh, "_ev", zzkzVarZzv3.zzC(str2, 40, true), str2 != null ? str2.length() : 0);
                return;
            }
            Bundle bundleZzy = this.zzs.zzv().zzy(str3, str2, bundle, CollectionUtils.listOf((Object[]) new String[]{"_o", "_sn", "_sc", "_si"}), z3);
            Preconditions.checkNotNull(bundleZzy);
            this.zzs.zzaw();
            if (this.zzs.zzs().zzj(false) != null && "_ae".equals(str2)) {
                zzkb zzkbVar = this.zzs.zzu().zzb;
                long jElapsedRealtime = zzkbVar.zzc.zzs.zzav().elapsedRealtime();
                long j3 = jElapsedRealtime - zzkbVar.zzb;
                zzkbVar.zzb = jElapsedRealtime;
                if (j3 > 0) {
                    this.zzs.zzv().zzH(bundleZzy, j3);
                }
            }
            zznu.zzc();
            if (this.zzs.zzf().zzs(null, zzdy.zzah)) {
                if (!"auto".equals(str) && "_ssr".equals(str2)) {
                    zzkz zzkzVarZzv4 = this.zzs.zzv();
                    String string = bundleZzy.getString("_ffr");
                    if (Strings.isEmptyOrWhitespace(string)) {
                        string = null;
                    } else if (string != null) {
                        string = string.trim();
                    }
                    if (zzkz.zzak(string, zzkzVarZzv4.zzs.zzm().zzo.zza())) {
                        zzkzVarZzv4.zzs.zzay().zzc().zza("Not logging duplicate session_start_with_rollout event");
                        return;
                    }
                    zzkzVarZzv4.zzs.zzm().zzo.zzb(string);
                } else if ("_ae".equals(str2)) {
                    String strZza = this.zzs.zzv().zzs.zzm().zzo.zza();
                    if (!TextUtils.isEmpty(strZza)) {
                        bundleZzy.putString("_ffr", strZza);
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(bundleZzy);
            if (this.zzs.zzm().zzj.zza() > 0 && this.zzs.zzm().zzk(j) && this.zzs.zzm().zzl.zzb()) {
                this.zzs.zzay().zzj().zza("Current session is expired, remove the session number, ID, and engagement time");
                str4 = "_ae";
                j2 = 0;
                zzZ("auto", "_sid", null, this.zzs.zzav().currentTimeMillis());
                zzZ("auto", "_sno", null, this.zzs.zzav().currentTimeMillis());
                zzZ("auto", "_se", null, this.zzs.zzav().currentTimeMillis());
            } else {
                str4 = "_ae";
                j2 = 0;
            }
            if (bundleZzy.getLong(FirebaseAnalytics.Param.EXTEND_SESSION, j2) == 1) {
                this.zzs.zzay().zzj().zza("EXTEND_SESSION param attached: initiate a new session or extend the current active session");
                this.zzs.zzu().zza.zzb(j, true);
            }
            ArrayList arrayList2 = new ArrayList(bundleZzy.keySet());
            Collections.sort(arrayList2);
            int size = arrayList2.size();
            for (int i2 = 0; i2 < size; i2++) {
                String str7 = (String) arrayList2.get(i2);
                if (str7 != null) {
                    this.zzs.zzv();
                    Object obj = bundleZzy.get(str7);
                    if (obj instanceof Bundle) {
                        bundleArr = new Bundle[]{(Bundle) obj};
                    } else if (obj instanceof Parcelable[]) {
                        Parcelable[] parcelableArr = (Parcelable[]) obj;
                        bundleArr = (Bundle[]) Arrays.copyOf(parcelableArr, parcelableArr.length, Bundle[].class);
                    } else if (obj instanceof ArrayList) {
                        ArrayList arrayList3 = (ArrayList) obj;
                        bundleArr = (Bundle[]) arrayList3.toArray(new Bundle[arrayList3.size()]);
                    } else {
                        bundleArr = null;
                    }
                    if (bundleArr != null) {
                        bundleZzy.putParcelableArray(str7, bundleArr);
                    }
                }
            }
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                Bundle bundleZzt = (Bundle) arrayList.get(i3);
                if (i3 != 0) {
                    str6 = "_ep";
                    str5 = str;
                } else {
                    str5 = str;
                    str6 = str2;
                }
                bundleZzt.putString("_o", str5);
                if (z2) {
                    bundleZzt = this.zzs.zzv().zzt(bundleZzt);
                }
                Bundle bundle2 = bundleZzt;
                this.zzs.zzt().zzA(new zzat(str6, new zzar(bundle2), str, j), str3);
                if (!z4) {
                    Iterator<zzgw> it = this.zze.iterator();
                    while (it.hasNext()) {
                        it.next().onEvent(str, str2, new Bundle(bundle2), j);
                    }
                }
            }
            this.zzs.zzaw();
            if (this.zzs.zzs().zzj(false) == null || !str4.equals(str2)) {
                return;
            }
            this.zzs.zzu().zzb.zzd(true, true, this.zzs.zzav().elapsedRealtime());
        }
    }

    public final void zzJ(zzgw zzgwVar) {
        zza();
        Preconditions.checkNotNull(zzgwVar);
        if (this.zze.add(zzgwVar)) {
            return;
        }
        this.zzs.zzay().zzk().zza("OnEventListener already registered");
    }

    public final void zzK(long j) throws IllegalStateException {
        this.zzg.set(null);
        this.zzs.zzaz().zzp(new zzhi(this, j));
    }

    final void zzL(long j, boolean z) {
        zzg();
        zza();
        this.zzs.zzay().zzc().zza("Resetting analytics data (FE)");
        zzkd zzkdVarZzu = this.zzs.zzu();
        zzkdVarZzu.zzg();
        zzkc zzkcVar = zzkdVarZzu.zza;
        zzkdVarZzu.zzb.zza();
        boolean zZzJ = this.zzs.zzJ();
        zzfa zzfaVarZzm = this.zzs.zzm();
        zzfaVarZzm.zzc.zzb(j);
        if (!TextUtils.isEmpty(zzfaVarZzm.zzs.zzm().zzo.zza())) {
            zzfaVarZzm.zzo.zzb(null);
        }
        zzod.zzc();
        if (zzfaVarZzm.zzs.zzf().zzs(null, zzdy.zzai)) {
            zzfaVarZzm.zzj.zzb(0L);
        }
        if (!zzfaVarZzm.zzs.zzf().zzv()) {
            zzfaVarZzm.zzi(!zZzJ);
        }
        zzfaVarZzm.zzp.zzb(null);
        zzfaVarZzm.zzq.zzb(0L);
        zzfaVarZzm.zzr.zzb(null);
        if (z) {
            this.zzs.zzt().zzC();
        }
        zzod.zzc();
        if (this.zzs.zzf().zzs(null, zzdy.zzai)) {
            this.zzs.zzu().zza.zza();
        }
        this.zzc = !zZzJ;
    }

    protected final void zzM(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) throws IllegalStateException {
        Bundle bundle2 = new Bundle(bundle);
        for (String str4 : bundle2.keySet()) {
            Object obj = bundle2.get(str4);
            if (obj instanceof Bundle) {
                bundle2.putBundle(str4, new Bundle((Bundle) obj));
            } else {
                int i = 0;
                if (obj instanceof Parcelable[]) {
                    Parcelable[] parcelableArr = (Parcelable[]) obj;
                    while (i < parcelableArr.length) {
                        Parcelable parcelable = parcelableArr[i];
                        if (parcelable instanceof Bundle) {
                            parcelableArr[i] = new Bundle((Bundle) parcelable);
                        }
                        i++;
                    }
                } else if (obj instanceof List) {
                    List list = (List) obj;
                    while (i < list.size()) {
                        Object obj2 = list.get(i);
                        if (obj2 instanceof Bundle) {
                            list.set(i, new Bundle((Bundle) obj2));
                        }
                        i++;
                    }
                }
            }
        }
        this.zzs.zzaz().zzp(new zzhf(this, str, str2, j, bundle2, z, z2, z3, str3));
    }

    final void zzN(String str, String str2, long j, Object obj) throws IllegalStateException {
        this.zzs.zzaz().zzp(new zzhg(this, str, str2, obj, j));
    }

    final void zzO(String str) {
        this.zzg.set(str);
    }

    public final void zzP(Bundle bundle) throws IllegalStateException {
        zzQ(bundle, this.zzs.zzav().currentTimeMillis());
    }

    public final void zzQ(Bundle bundle, long j) throws IllegalStateException {
        Preconditions.checkNotNull(bundle);
        Bundle bundle2 = new Bundle(bundle);
        if (!TextUtils.isEmpty(bundle2.getString("app_id"))) {
            this.zzs.zzay().zzk().zza("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove("app_id");
        Preconditions.checkNotNull(bundle2);
        zzgr.zza(bundle2, "app_id", String.class, null);
        zzgr.zza(bundle2, "origin", String.class, null);
        zzgr.zza(bundle2, "name", String.class, null);
        zzgr.zza(bundle2, "value", Object.class, null);
        zzgr.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, String.class, null);
        zzgr.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.class, 0L);
        zzgr.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, String.class, null);
        zzgr.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, Bundle.class, null);
        zzgr.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, String.class, null);
        zzgr.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, Bundle.class, null);
        zzgr.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.class, 0L);
        zzgr.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, String.class, null);
        zzgr.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, Bundle.class, null);
        Preconditions.checkNotEmpty(bundle2.getString("name"));
        Preconditions.checkNotEmpty(bundle2.getString("origin"));
        Preconditions.checkNotNull(bundle2.get("value"));
        bundle2.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, j);
        String string = bundle2.getString("name");
        Object obj = bundle2.get("value");
        if (this.zzs.zzv().zzl(string) != 0) {
            this.zzs.zzay().zzd().zzb("Invalid conditional user property name", this.zzs.zzj().zzf(string));
            return;
        }
        if (this.zzs.zzv().zzd(string, obj) != 0) {
            this.zzs.zzay().zzd().zzc("Invalid conditional user property value", this.zzs.zzj().zzf(string), obj);
            return;
        }
        Object objZzB = this.zzs.zzv().zzB(string, obj);
        if (objZzB == null) {
            this.zzs.zzay().zzd().zzc("Unable to normalize conditional user property value", this.zzs.zzj().zzf(string), obj);
            return;
        }
        zzgr.zzb(bundle2, objZzB);
        long j2 = bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT);
        if (!TextUtils.isEmpty(bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME))) {
            this.zzs.zzf();
            if (j2 > 15552000000L || j2 < 1) {
                this.zzs.zzay().zzd().zzc("Invalid conditional user property timeout", this.zzs.zzj().zzf(string), Long.valueOf(j2));
                return;
            }
        }
        long j3 = bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE);
        this.zzs.zzf();
        if (j3 > 15552000000L || j3 < 1) {
            this.zzs.zzay().zzd().zzc("Invalid conditional user property time to live", this.zzs.zzj().zzf(string), Long.valueOf(j3));
        } else {
            this.zzs.zzaz().zzp(new zzhj(this, bundle2));
        }
    }

    public final void zzR(Bundle bundle, int i, long j) {
        zza();
        String strZzh = zzag.zzh(bundle);
        if (strZzh != null) {
            this.zzs.zzay().zzl().zzb("Ignoring invalid consent setting", strZzh);
            this.zzs.zzay().zzl().zza("Valid consent values are 'granted', 'denied'");
        }
        zzS(zzag.zza(bundle), i, j);
    }

    public final void zzS(zzag zzagVar, int i, long j) {
        boolean z;
        boolean z2;
        zzag zzagVar2;
        boolean z3;
        zza();
        if (i != -10 && zzagVar.zze() == null && zzagVar.zzf() == null) {
            this.zzs.zzay().zzl().zza("Discarding empty consent settings");
            return;
        }
        synchronized (this.zzh) {
            z = true;
            z2 = false;
            if (zzag.zzl(i, this.zzj)) {
                boolean zZzm = zzagVar.zzm(this.zzi);
                if (zzagVar.zzk() && !this.zzi.zzk()) {
                    z2 = true;
                }
                zzag zzagVarZzd = zzagVar.zzd(this.zzi);
                this.zzi = zzagVarZzd;
                this.zzj = i;
                zzagVar2 = zzagVarZzd;
                z3 = z2;
                z2 = zZzm;
            } else {
                zzagVar2 = zzagVar;
                z3 = false;
                z = false;
            }
        }
        if (!z) {
            this.zzs.zzay().zzi().zzb("Ignoring lower-priority consent settings, proposed settings", zzagVar2);
            return;
        }
        long andIncrement = this.zzk.getAndIncrement();
        if (z2) {
            this.zzg.set(null);
            this.zzs.zzaz().zzq(new zzhu(this, zzagVar2, j, i, andIncrement, z3));
        } else if (i == 30 || i == -10) {
            this.zzs.zzaz().zzq(new zzhv(this, zzagVar2, i, andIncrement, z3));
        } else {
            this.zzs.zzaz().zzp(new zzhw(this, zzagVar2, i, andIncrement, z3));
        }
    }

    public final void zzT(final Bundle bundle, final long j) throws IllegalStateException {
        zznx.zzc();
        if (this.zzs.zzf().zzs(null, zzdy.zzas)) {
            this.zzs.zzaz().zzq(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzhb
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzB(bundle, j);
                }
            });
        } else {
            zzB(bundle, j);
        }
    }

    public final void zzU(zzgv zzgvVar) {
        zzgv zzgvVar2;
        zzg();
        zza();
        if (zzgvVar != null && zzgvVar != (zzgvVar2 = this.zzd)) {
            Preconditions.checkState(zzgvVar2 == null, "EventInterceptor already set.");
        }
        this.zzd = zzgvVar;
    }

    public final void zzV(Boolean bool) throws IllegalStateException {
        zza();
        this.zzs.zzaz().zzp(new zzht(this, bool));
    }

    final void zzW(zzag zzagVar) {
        zzg();
        boolean z = (zzagVar.zzk() && zzagVar.zzj()) || this.zzs.zzt().zzM();
        if (z != this.zzs.zzK()) {
            this.zzs.zzG(z);
            zzfa zzfaVarZzm = this.zzs.zzm();
            zzfv zzfvVar = zzfaVarZzm.zzs;
            zzfaVarZzm.zzg();
            Boolean boolValueOf = zzfaVarZzm.zza().contains("measurement_enabled_from_api") ? Boolean.valueOf(zzfaVarZzm.zza().getBoolean("measurement_enabled_from_api", true)) : null;
            if (!z || boolValueOf == null || boolValueOf.booleanValue()) {
                zzac(Boolean.valueOf(z), false);
            }
        }
    }

    public final void zzX(String str, String str2, Object obj, boolean z) throws IllegalStateException {
        zzY("auto", "_ldl", obj, true, this.zzs.zzav().currentTimeMillis());
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final void zzZ(String str, String str2, Object obj, long j) {
        String str3;
        Object obj2;
        Object obj3;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzg();
        zza();
        if (!FirebaseAnalytics.UserProperty.ALLOW_AD_PERSONALIZATION_SIGNALS.equals(str2)) {
            str3 = str2;
            obj2 = obj;
        } else if (obj instanceof String) {
            String str4 = (String) obj;
            if (TextUtils.isEmpty(str4)) {
                if (obj == null) {
                    this.zzs.zzm().zzh.zzb("unset");
                    obj3 = obj;
                }
                str3 = str2;
                obj2 = obj;
            } else {
                Long lValueOf = Long.valueOf(true != "false".equals(str4.toLowerCase(Locale.ENGLISH)) ? 0L : 1L);
                this.zzs.zzm().zzh.zzb(lValueOf.longValue() == 1 ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false");
                obj3 = lValueOf;
            }
            obj2 = obj3;
            str3 = "_npa";
        }
        if (!this.zzs.zzJ()) {
            this.zzs.zzay().zzj().zza("User property not set since app measurement is disabled");
        } else if (this.zzs.zzM()) {
            this.zzs.zzt().zzK(new zzkv(str3, j, obj2, str));
        }
    }

    public final void zzaa(zzgw zzgwVar) {
        zza();
        Preconditions.checkNotNull(zzgwVar);
        if (this.zze.remove(zzgwVar)) {
            return;
        }
        this.zzs.zzay().zzk().zza("OnEventListener had not been registered");
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    protected final boolean zzf() {
        return false;
    }

    public final int zzh(String str) {
        Preconditions.checkNotEmpty(str);
        this.zzs.zzf();
        return 25;
    }

    public final Boolean zzi() {
        AtomicReference atomicReference = new AtomicReference();
        return (Boolean) this.zzs.zzaz().zzd(atomicReference, 15000L, "boolean test flag value", new zzhl(this, atomicReference));
    }

    public final Double zzj() {
        AtomicReference atomicReference = new AtomicReference();
        return (Double) this.zzs.zzaz().zzd(atomicReference, 15000L, "double test flag value", new zzhs(this, atomicReference));
    }

    public final Integer zzl() {
        AtomicReference atomicReference = new AtomicReference();
        return (Integer) this.zzs.zzaz().zzd(atomicReference, 15000L, "int test flag value", new zzhr(this, atomicReference));
    }

    public final Long zzm() {
        AtomicReference atomicReference = new AtomicReference();
        return (Long) this.zzs.zzaz().zzd(atomicReference, 15000L, "long test flag value", new zzhq(this, atomicReference));
    }

    public final String zzo() {
        return this.zzg.get();
    }

    public final String zzp() {
        zzih zzihVarZzi = this.zzs.zzs().zzi();
        if (zzihVarZzi != null) {
            return zzihVarZzi.zzb;
        }
        return null;
    }

    public final String zzq() {
        zzih zzihVarZzi = this.zzs.zzs().zzi();
        if (zzihVarZzi != null) {
            return zzihVarZzi.zza;
        }
        return null;
    }

    public final String zzr() {
        AtomicReference atomicReference = new AtomicReference();
        return (String) this.zzs.zzaz().zzd(atomicReference, 15000L, "String test flag value", new zzhp(this, atomicReference));
    }

    public final ArrayList<Bundle> zzs(String str, String str2) {
        if (this.zzs.zzaz().zzs()) {
            this.zzs.zzay().zzd().zza("Cannot get conditional user properties from analytics worker thread");
            return new ArrayList<>(0);
        }
        this.zzs.zzaw();
        if (zzaa.zza()) {
            this.zzs.zzay().zzd().zza("Cannot get conditional user properties from main thread");
            return new ArrayList<>(0);
        }
        AtomicReference atomicReference = new AtomicReference();
        this.zzs.zzaz().zzd(atomicReference, 5000L, "get conditional user properties", new zzhm(this, atomicReference, null, str, str2));
        List list = (List) atomicReference.get();
        if (list != null) {
            return zzkz.zzG(list);
        }
        this.zzs.zzay().zzd().zzb("Timed out waiting for get conditional user properties", null);
        return new ArrayList<>();
    }

    public final List<zzkv> zzt(boolean z) {
        zza();
        this.zzs.zzay().zzj().zza("Getting user properties (FE)");
        if (this.zzs.zzaz().zzs()) {
            this.zzs.zzay().zzd().zza("Cannot get all user properties from analytics worker thread");
            return Collections.emptyList();
        }
        this.zzs.zzaw();
        if (zzaa.zza()) {
            this.zzs.zzay().zzd().zza("Cannot get all user properties from main thread");
            return Collections.emptyList();
        }
        AtomicReference atomicReference = new AtomicReference();
        this.zzs.zzaz().zzd(atomicReference, 5000L, "get user properties", new zzhh(this, atomicReference, z));
        List<zzkv> list = (List) atomicReference.get();
        if (list != null) {
            return list;
        }
        this.zzs.zzay().zzd().zzb("Timed out waiting for get user properties, includeInternal", Boolean.valueOf(z));
        return Collections.emptyList();
    }

    public final Map<String, Object> zzu(String str, String str2, boolean z) {
        if (this.zzs.zzaz().zzs()) {
            this.zzs.zzay().zzd().zza("Cannot get user properties from analytics worker thread");
            return Collections.emptyMap();
        }
        this.zzs.zzaw();
        if (zzaa.zza()) {
            this.zzs.zzay().zzd().zza("Cannot get user properties from main thread");
            return Collections.emptyMap();
        }
        AtomicReference atomicReference = new AtomicReference();
        this.zzs.zzaz().zzd(atomicReference, 5000L, "get user properties", new zzhn(this, atomicReference, null, str, str2, z));
        List<zzkv> list = (List) atomicReference.get();
        if (list == null) {
            this.zzs.zzay().zzd().zzb("Timed out waiting for handle get user properties, includeInternal", Boolean.valueOf(z));
            return Collections.emptyMap();
        }
        ArrayMap arrayMap = new ArrayMap(list.size());
        for (zzkv zzkvVar : list) {
            Object objZza = zzkvVar.zza();
            if (objZza != null) {
                arrayMap.put(zzkvVar.zzb, objZza);
            }
        }
        return arrayMap;
    }

    public final void zzy() {
        zzg();
        zza();
        if (this.zzs.zzM()) {
            if (this.zzs.zzf().zzs(null, zzdy.zzZ)) {
                zzaf zzafVarZzf = this.zzs.zzf();
                zzafVarZzf.zzs.zzaw();
                Boolean boolZzk = zzafVarZzf.zzk("google_analytics_deferred_deep_link_enabled");
                if (boolZzk != null && boolZzk.booleanValue()) {
                    this.zzs.zzay().zzc().zza("Deferred Deep Link feature enabled.");
                    this.zzs.zzaz().zzp(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzgz
                        @Override // java.lang.Runnable
                        public final void run() throws IllegalStateException {
                            zzia zziaVar = this.zza;
                            zziaVar.zzg();
                            if (zziaVar.zzs.zzm().zzm.zzb()) {
                                zziaVar.zzs.zzay().zzc().zza("Deferred Deep Link already retrieved. Not fetching again.");
                                return;
                            }
                            long jZza = zziaVar.zzs.zzm().zzn.zza();
                            zziaVar.zzs.zzm().zzn.zzb(1 + jZza);
                            zziaVar.zzs.zzf();
                            if (jZza < 5) {
                                zziaVar.zzs.zzE();
                            } else {
                                zziaVar.zzs.zzay().zzk().zza("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
                                zziaVar.zzs.zzm().zzm.zza(true);
                            }
                        }
                    });
                }
            }
            this.zzs.zzt().zzq();
            this.zzc = false;
            zzfa zzfaVarZzm = this.zzs.zzm();
            zzfaVarZzm.zzg();
            String string = zzfaVarZzm.zza().getString("previous_os_version", null);
            zzfaVarZzm.zzs.zzg().zzu();
            String str = Build.VERSION.RELEASE;
            if (!TextUtils.isEmpty(str) && !str.equals(string)) {
                SharedPreferences.Editor editorEdit = zzfaVarZzm.zza().edit();
                editorEdit.putString("previous_os_version", str);
                editorEdit.apply();
            }
            if (TextUtils.isEmpty(string)) {
                return;
            }
            this.zzs.zzg().zzu();
            if (string.equals(Build.VERSION.RELEASE)) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("_po", string);
            zzG("auto", "_ou", bundle);
        }
    }

    public final void zzz(String str, String str2, Bundle bundle) throws IllegalStateException {
        long jCurrentTimeMillis = this.zzs.zzav().currentTimeMillis();
        Preconditions.checkNotEmpty(str);
        Bundle bundle2 = new Bundle();
        bundle2.putString("name", str);
        bundle2.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, jCurrentTimeMillis);
        if (str2 != null) {
            bundle2.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, str2);
            bundle2.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, bundle);
        }
        this.zzs.zzaz().zzp(new zzhk(this, bundle2));
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzY(String str, String str2, Object obj, boolean z, long j) throws IllegalStateException {
        int i;
        String str3 = str == null ? "app" : str;
        int iZzl = 6;
        if (!z) {
            zzkz zzkzVarZzv = this.zzs.zzv();
            if (zzkzVarZzv.zzab("user property", str2)) {
                if (zzkzVarZzv.zzY("user property", zzgu.zza, null, str2)) {
                    zzkzVarZzv.zzs.zzf();
                    if (zzkzVarZzv.zzX("user property", 24, str2)) {
                        i = 0;
                    }
                } else {
                    iZzl = 15;
                }
            }
            if (i == 0) {
                zzkz zzkzVarZzv2 = this.zzs.zzv();
                this.zzs.zzf();
                this.zzs.zzv().zzM(this.zzn, null, i, "_ev", zzkzVarZzv2.zzC(str2, 24, true), str2 != null ? str2.length() : 0);
                return;
            } else {
                if (obj == null) {
                    zzN(str3, str2, j, null);
                    return;
                }
                int iZzd = this.zzs.zzv().zzd(str2, obj);
                if (iZzd != 0) {
                    zzkz zzkzVarZzv3 = this.zzs.zzv();
                    this.zzs.zzf();
                    this.zzs.zzv().zzM(this.zzn, null, iZzd, "_ev", zzkzVarZzv3.zzC(str2, 24, true), ((obj instanceof String) || (obj instanceof CharSequence)) ? obj.toString().length() : 0);
                    return;
                } else {
                    Object objZzB = this.zzs.zzv().zzB(str2, obj);
                    if (objZzB != null) {
                        zzN(str3, str2, j, objZzB);
                        return;
                    }
                    return;
                }
            }
        }
        iZzl = this.zzs.zzv().zzl(str2);
        i = iZzl;
        if (i == 0) {
        }
    }
}
