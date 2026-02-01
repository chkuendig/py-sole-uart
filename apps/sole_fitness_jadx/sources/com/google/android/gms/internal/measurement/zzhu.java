package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.StrictMode;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;
import org.apache.commons.lang3.StringUtils;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.0.0 */
/* loaded from: classes2.dex */
public abstract class zzhu<T> {
    public static final /* synthetic */ int zzc = 0;

    @Nullable
    private static volatile zzhs zze = null;
    private static volatile boolean zzf = false;
    final zzhr zza;
    final String zzb;
    private final T zzj;
    private volatile int zzk = -1;
    private volatile T zzl;
    private final boolean zzm;
    private static final Object zzd = new Object();
    private static final AtomicReference<Collection<zzhu<?>>> zzg = new AtomicReference<>();
    private static final zzhw zzh = new zzhw(zzhl.zza, null);
    private static final AtomicInteger zzi = new AtomicInteger();

    /* JADX WARN: Multi-variable type inference failed */
    /* synthetic */ zzhu(zzhr zzhrVar, String str, Object obj, boolean z, zzht zzhtVar) {
        if (zzhrVar.zzb == null) {
            throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
        }
        this.zza = zzhrVar;
        this.zzb = str;
        this.zzj = obj;
        this.zzm = true;
    }

    @Deprecated
    public static void zzd(final Context context) {
        synchronized (zzd) {
            zzhs zzhsVar = zze;
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            if (zzhsVar == null || zzhsVar.zza() != context) {
                zzha.zze();
                zzhv.zzc();
                zzhh.zze();
                zze = new zzgx(context, zzif.zza(new zzib() { // from class: com.google.android.gms.internal.measurement.zzhm
                    @Override // com.google.android.gms.internal.measurement.zzib
                    public final Object zza() {
                        zzhz zzhzVarZzc;
                        zzhz zzhzVarZzc2;
                        Context contextCreateDeviceProtectedStorageContext = context;
                        int i = zzhu.zzc;
                        String str = Build.TYPE;
                        String str2 = Build.TAGS;
                        if ((!str.equals("eng") && !str.equals("userdebug")) || (!str2.contains("dev-keys") && !str2.contains("test-keys"))) {
                            return zzhz.zzc();
                        }
                        if (zzgw.zza() && !contextCreateDeviceProtectedStorageContext.isDeviceProtectedStorage()) {
                            contextCreateDeviceProtectedStorageContext = contextCreateDeviceProtectedStorageContext.createDeviceProtectedStorageContext();
                        }
                        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
                        try {
                            StrictMode.allowThreadDiskWrites();
                            try {
                                File file = new File(contextCreateDeviceProtectedStorageContext.getDir("phenotype_hermetic", 0), "overrides.txt");
                                zzhzVarZzc = file.exists() ? zzhz.zzd(file) : zzhz.zzc();
                            } catch (RuntimeException e) {
                                Log.e("HermeticFileOverrides", "no data dir", e);
                                zzhzVarZzc = zzhz.zzc();
                            }
                            if (zzhzVarZzc.zzb()) {
                                File file2 = (File) zzhzVarZzc.zza();
                                try {
                                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file2)));
                                    try {
                                        HashMap map = new HashMap();
                                        HashMap map2 = new HashMap();
                                        while (true) {
                                            String line = bufferedReader.readLine();
                                            if (line == null) {
                                                break;
                                            }
                                            String[] strArrSplit = line.split(StringUtils.SPACE, 3);
                                            if (strArrSplit.length != 3) {
                                                Log.e("HermeticFileOverrides", line.length() != 0 ? "Invalid: ".concat(line) : new String("Invalid: "));
                                            } else {
                                                String str3 = new String(strArrSplit[0]);
                                                String strDecode = Uri.decode(new String(strArrSplit[1]));
                                                String strDecode2 = (String) map2.get(strArrSplit[2]);
                                                if (strDecode2 == null) {
                                                    String str4 = new String(strArrSplit[2]);
                                                    strDecode2 = Uri.decode(str4);
                                                    if (strDecode2.length() < 1024 || strDecode2 == str4) {
                                                        map2.put(str4, strDecode2);
                                                    }
                                                }
                                                if (!map.containsKey(str3)) {
                                                    map.put(str3, new HashMap());
                                                }
                                                ((Map) map.get(str3)).put(strDecode, strDecode2);
                                            }
                                        }
                                        String string = file2.toString();
                                        StringBuilder sb = new StringBuilder(string.length() + 7);
                                        sb.append("Parsed ");
                                        sb.append(string);
                                        Log.i("HermeticFileOverrides", sb.toString());
                                        zzhi zzhiVar = new zzhi(map);
                                        bufferedReader.close();
                                        zzhzVarZzc2 = zzhz.zzd(zzhiVar);
                                    } catch (Throwable th) {
                                        try {
                                            bufferedReader.close();
                                        } catch (Throwable unused) {
                                        }
                                        throw th;
                                    }
                                } catch (IOException e2) {
                                    throw new RuntimeException(e2);
                                }
                            } else {
                                zzhzVarZzc2 = zzhz.zzc();
                            }
                            return zzhzVarZzc2;
                        } finally {
                            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                        }
                    }
                }));
                zzi.incrementAndGet();
            }
        }
    }

    static void zze() {
        zzi.incrementAndGet();
    }

    abstract T zza(Object obj);

    /* JADX WARN: Removed duplicated region for block: B:36:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b8 A[Catch: all -> 0x011e, TryCatch #0 {, blocks: (B:8:0x0016, B:10:0x001a, B:12:0x0020, B:14:0x0037, B:16:0x0043, B:18:0x004c, B:20:0x005e, B:22:0x0069, B:21:0x0063, B:49:0x00e4, B:51:0x00f4, B:53:0x010a, B:54:0x010d, B:55:0x0111, B:37:0x00b8, B:39:0x00be, B:43:0x00d4, B:45:0x00da, B:48:0x00e2, B:42:0x00d0, B:24:0x006e, B:26:0x0074, B:28:0x0082, B:32:0x00a7, B:34:0x00b1, B:30:0x0099, B:56:0x0116, B:57:0x011b, B:58:0x011c), top: B:65:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00f4 A[Catch: all -> 0x011e, TryCatch #0 {, blocks: (B:8:0x0016, B:10:0x001a, B:12:0x0020, B:14:0x0037, B:16:0x0043, B:18:0x004c, B:20:0x005e, B:22:0x0069, B:21:0x0063, B:49:0x00e4, B:51:0x00f4, B:53:0x010a, B:54:0x010d, B:55:0x0111, B:37:0x00b8, B:39:0x00be, B:43:0x00d4, B:45:0x00da, B:48:0x00e2, B:42:0x00d0, B:24:0x006e, B:26:0x0074, B:28:0x0082, B:32:0x00a7, B:34:0x00b1, B:30:0x0099, B:56:0x0116, B:57:0x011b, B:58:0x011c), top: B:65:0x0016 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final T zzb() {
        zzhe zzheVarZza;
        Object objZzb;
        T tZza;
        String str;
        zzhz<zzhi> zzhzVarZza;
        if (!this.zzm) {
            Objects.requireNonNull(this.zzb, "flagName must not be null");
        }
        int i = zzi.get();
        if (this.zzk < i) {
            synchronized (this) {
                if (this.zzk < i) {
                    zzhs zzhsVar = zze;
                    if (zzhsVar == null) {
                        throw new IllegalStateException("Must call PhenotypeFlag.init() first");
                    }
                    zzhr zzhrVar = this.zza;
                    boolean z = zzhrVar.zzf;
                    boolean z2 = zzhrVar.zzg;
                    String strZzc = zzhh.zza(zzhsVar.zza()).zzb("gms:phenotype:phenotype_flag:debug_bypass_phenotype");
                    if (strZzc == null || !zzgv.zzc.matcher(strZzc).matches()) {
                        if (this.zza.zzb == null) {
                            Context contextZza = zzhsVar.zza();
                            String str2 = this.zza.zza;
                            zzheVarZza = zzhv.zza(contextZza, null);
                        } else if (zzhj.zza(zzhsVar.zza(), this.zza.zzb)) {
                            boolean z3 = this.zza.zzh;
                            zzheVarZza = zzha.zza(zzhsVar.zza().getContentResolver(), this.zza.zzb);
                        } else {
                            zzheVarZza = null;
                        }
                        if (zzheVarZza != null && (objZzb = zzheVarZza.zzb(zzc())) != null) {
                            tZza = zza(objZzb);
                        }
                        if (tZza != null) {
                            zzhr zzhrVar2 = this.zza;
                            if (!zzhrVar2.zze) {
                                zzhy<Context, Boolean> zzhyVar = zzhrVar2.zzi;
                                zzhh zzhhVarZza = zzhh.zza(zzhsVar.zza());
                                zzhr zzhrVar3 = this.zza;
                                if (zzhrVar3.zze) {
                                    str = null;
                                } else {
                                    String str3 = zzhrVar3.zzc;
                                    str = this.zzb;
                                }
                                String strZzc2 = zzhhVarZza.zzb(str);
                                tZza = strZzc2 != null ? zza(strZzc2) : null;
                                if (tZza == null) {
                                    tZza = this.zzj;
                                }
                            }
                        }
                        zzhzVarZza = zzhsVar.zzb().zza();
                        if (zzhzVarZza.zzb()) {
                            zzhi zzhiVarZza = zzhzVarZza.zza();
                            zzhr zzhrVar4 = this.zza;
                            Uri uri = zzhrVar4.zzb;
                            String str4 = zzhrVar4.zza;
                            String strZza = zzhiVarZza.zza(uri, null, zzhrVar4.zzd, this.zzb);
                            tZza = strZza == null ? this.zzj : zza(strZza);
                        }
                        this.zzl = tZza;
                        this.zzk = i;
                    } else if (Log.isLoggable("PhenotypeFlag", 3)) {
                        String strValueOf = String.valueOf(zzc());
                        Log.d("PhenotypeFlag", strValueOf.length() != 0 ? "Bypass reading Phenotype values for flag: ".concat(strValueOf) : new String("Bypass reading Phenotype values for flag: "));
                    }
                    tZza = null;
                    if (tZza != null) {
                    }
                    zzhzVarZza = zzhsVar.zzb().zza();
                    if (zzhzVarZza.zzb()) {
                    }
                    this.zzl = tZza;
                    this.zzk = i;
                }
            }
        }
        return this.zzl;
    }

    public final String zzc() {
        String str = this.zza.zzd;
        return this.zzb;
    }
}
