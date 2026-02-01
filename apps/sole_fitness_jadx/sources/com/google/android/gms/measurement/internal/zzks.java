package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.collection.ArrayMap;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.codeless.internal.Constants;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzmt;
import com.google.android.gms.internal.measurement.zzom;
import com.google.android.gms.internal.measurement.zzpe;
import com.google.android.gms.internal.measurement.zzpn;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.mapbox.mapboxsdk.tileprovider.modules.MBTilesFileArchive;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.zip.GZIPInputStream;
import kotlin.time.DurationKt;
import org.apache.http.HttpHeaders;
import org.joda.time.DateTimeConstants;

/* compiled from: com.google.android.gms:play-services-measurement@@20.0.0 */
/* loaded from: classes2.dex */
public final class zzks implements zzgq {
    private static volatile zzks zzb;
    private long zzA;
    private final Map<String, zzag> zzB;
    long zza;
    private final zzfm zzc;
    private final zzer zzd;
    private zzaj zze;
    private zzet zzf;
    private zzkg zzg;
    private zzz zzh;
    private final zzku zzi;
    private zzif zzj;
    private zzjp zzk;
    private final zzkj zzl;
    private zzfd zzm;
    private final zzfv zzn;
    private boolean zzp;
    private List<Runnable> zzq;
    private int zzr;
    private int zzs;
    private boolean zzt;
    private boolean zzu;
    private boolean zzv;
    private FileLock zzw;
    private FileChannel zzx;
    private List<Long> zzy;
    private List<Long> zzz;
    private boolean zzo = false;
    private final zzky zzC = new zzkp(this);

    zzks(zzkt zzktVar, zzfv zzfvVar) throws IllegalStateException {
        Preconditions.checkNotNull(zzktVar);
        this.zzn = zzfv.zzp(zzktVar.zza, null, null);
        this.zzA = -1L;
        this.zzl = new zzkj(this);
        zzku zzkuVar = new zzku(this);
        zzkuVar.zzZ();
        this.zzi = zzkuVar;
        zzer zzerVar = new zzer(this);
        zzerVar.zzZ();
        this.zzd = zzerVar;
        zzfm zzfmVar = new zzfm(this);
        zzfmVar.zzZ();
        this.zzc = zzfmVar;
        this.zzB = new HashMap();
        zzaz().zzp(new zzkk(this, zzktVar));
    }

    static final void zzY(com.google.android.gms.internal.measurement.zzfn zzfnVar, int i, String str) {
        List<com.google.android.gms.internal.measurement.zzfs> listZzp = zzfnVar.zzp();
        for (int i2 = 0; i2 < listZzp.size(); i2++) {
            if ("_err".equals(listZzp.get(i2).zzg())) {
                return;
            }
        }
        com.google.android.gms.internal.measurement.zzfr zzfrVarZze = com.google.android.gms.internal.measurement.zzfs.zze();
        zzfrVarZze.zzj("_err");
        zzfrVarZze.zzi(Long.valueOf(i).longValue());
        com.google.android.gms.internal.measurement.zzfs zzfsVarZzaA = zzfrVarZze.zzaA();
        com.google.android.gms.internal.measurement.zzfr zzfrVarZze2 = com.google.android.gms.internal.measurement.zzfs.zze();
        zzfrVarZze2.zzj("_ev");
        zzfrVarZze2.zzk(str);
        com.google.android.gms.internal.measurement.zzfs zzfsVarZzaA2 = zzfrVarZze2.zzaA();
        zzfnVar.zzf(zzfsVarZzaA);
        zzfnVar.zzf(zzfsVarZzaA2);
    }

    static final void zzZ(com.google.android.gms.internal.measurement.zzfn zzfnVar, String str) {
        List<com.google.android.gms.internal.measurement.zzfs> listZzp = zzfnVar.zzp();
        for (int i = 0; i < listZzp.size(); i++) {
            if (str.equals(listZzp.get(i).zzg())) {
                zzfnVar.zzh(i);
                return;
            }
        }
    }

    private final zzp zzaa(String str) {
        zzaj zzajVar = this.zze;
        zzak(zzajVar);
        zzg zzgVarZzj = zzajVar.zzj(str);
        if (zzgVarZzj == null || TextUtils.isEmpty(zzgVarZzj.zzw())) {
            zzay().zzc().zzb("No app data available; dropping", str);
            return null;
        }
        Boolean boolZzab = zzab(zzgVarZzj);
        if (boolZzab != null && !boolZzab.booleanValue()) {
            zzay().zzd().zzb("App version does not match; dropping. appId", zzel.zzn(str));
            return null;
        }
        String strZzz = zzgVarZzj.zzz();
        String strZzw = zzgVarZzj.zzw();
        long jZzb = zzgVarZzj.zzb();
        String strZzv = zzgVarZzj.zzv();
        long jZzm = zzgVarZzj.zzm();
        long jZzj = zzgVarZzj.zzj();
        boolean zZzaj = zzgVarZzj.zzaj();
        String strZzx = zzgVarZzj.zzx();
        long jZza = zzgVarZzj.zza();
        boolean zZzai = zzgVarZzj.zzai();
        String strZzr = zzgVarZzj.zzr();
        Boolean boolZzq = zzgVarZzj.zzq();
        long jZzk = zzgVarZzj.zzk();
        List<String> listZzC = zzgVarZzj.zzC();
        zzom.zzc();
        return new zzp(str, strZzz, strZzw, jZzb, strZzv, jZzm, jZzj, (String) null, zZzaj, false, strZzx, jZza, 0L, 0, zZzai, false, strZzr, boolZzq, jZzk, listZzC, zzg().zzs(str, zzdy.zzac) ? zzgVarZzj.zzy() : null, zzh(str).zzi());
    }

    private final Boolean zzab(zzg zzgVar) {
        try {
            if (zzgVar.zzb() != -2147483648L) {
                if (zzgVar.zzb() == Wrappers.packageManager(this.zzn.zzau()).getPackageInfo(zzgVar.zzt(), 0).versionCode) {
                    return true;
                }
            } else {
                String str = Wrappers.packageManager(this.zzn.zzau()).getPackageInfo(zzgVar.zzt(), 0).versionName;
                String strZzw = zzgVar.zzw();
                if (strZzw != null && strZzw.equals(str)) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private final void zzac() {
        zzaz().zzg();
        if (this.zzt || this.zzu || this.zzv) {
            zzay().zzj().zzd("Not stopping services. fetch, network, upload", Boolean.valueOf(this.zzt), Boolean.valueOf(this.zzu), Boolean.valueOf(this.zzv));
            return;
        }
        zzay().zzj().zza("Stopping uploading service(s)");
        List<Runnable> list = this.zzq;
        if (list == null) {
            return;
        }
        Iterator<Runnable> it = list.iterator();
        while (it.hasNext()) {
            it.next().run();
        }
        ((List) Preconditions.checkNotNull(this.zzq)).clear();
    }

    private final void zzad(com.google.android.gms.internal.measurement.zzfx zzfxVar, long j, boolean z) {
        String str = true != z ? "_lte" : "_se";
        zzaj zzajVar = this.zze;
        zzak(zzajVar);
        zzkx zzkxVarZzp = zzajVar.zzp(zzfxVar.zzal(), str);
        zzkx zzkxVar = (zzkxVarZzp == null || zzkxVarZzp.zze == null) ? new zzkx(zzfxVar.zzal(), "auto", str, zzav().currentTimeMillis(), Long.valueOf(j)) : new zzkx(zzfxVar.zzal(), "auto", str, zzav().currentTimeMillis(), Long.valueOf(((Long) zzkxVarZzp.zze).longValue() + j));
        com.google.android.gms.internal.measurement.zzgg zzggVarZzd = com.google.android.gms.internal.measurement.zzgh.zzd();
        zzggVarZzd.zzf(str);
        zzggVarZzd.zzg(zzav().currentTimeMillis());
        zzggVarZzd.zze(((Long) zzkxVar.zze).longValue());
        com.google.android.gms.internal.measurement.zzgh zzghVarZzaA = zzggVarZzd.zzaA();
        int iZza = zzku.zza(zzfxVar, str);
        if (iZza >= 0) {
            zzfxVar.zzai(iZza, zzghVarZzaA);
        } else {
            zzfxVar.zzl(zzghVarZzaA);
        }
        if (j > 0) {
            zzaj zzajVar2 = this.zze;
            zzak(zzajVar2);
            zzajVar2.zzN(zzkxVar);
            zzay().zzj().zzc("Updated engagement user property. scope, value", true != z ? "lifetime" : "session-scoped", zzkxVar.zze);
        }
    }

    private final void zzae(com.google.android.gms.internal.measurement.zzfn zzfnVar, com.google.android.gms.internal.measurement.zzfn zzfnVar2) {
        Preconditions.checkArgument("_e".equals(zzfnVar.zzo()));
        zzak(this.zzi);
        com.google.android.gms.internal.measurement.zzfs zzfsVarZzC = zzku.zzC(zzfnVar.zzaA(), "_et");
        if (zzfsVarZzC == null || !zzfsVarZzC.zzw() || zzfsVarZzC.zzd() <= 0) {
            return;
        }
        long jZzd = zzfsVarZzC.zzd();
        zzak(this.zzi);
        com.google.android.gms.internal.measurement.zzfs zzfsVarZzC2 = zzku.zzC(zzfnVar2.zzaA(), "_et");
        if (zzfsVarZzC2 != null && zzfsVarZzC2.zzd() > 0) {
            jZzd += zzfsVarZzC2.zzd();
        }
        zzak(this.zzi);
        zzku.zzA(zzfnVar2, "_et", Long.valueOf(jZzd));
        zzak(this.zzi);
        zzku.zzA(zzfnVar, "_fr", 1L);
    }

    private final void zzaf() {
        long jMax;
        long jMax2;
        zzaz().zzg();
        zzB();
        if (this.zza > 0) {
            long jAbs = 3600000 - Math.abs(zzav().elapsedRealtime() - this.zza);
            if (jAbs > 0) {
                zzay().zzj().zzb("Upload has been suspended. Will update scheduling later in approximately ms", Long.valueOf(jAbs));
                zzm().zzc();
                zzkg zzkgVar = this.zzg;
                zzak(zzkgVar);
                zzkgVar.zza();
                return;
            }
            this.zza = 0L;
        }
        if (!this.zzn.zzM() || !zzai()) {
            zzay().zzj().zza("Nothing to upload or uploading impossible");
            zzm().zzc();
            zzkg zzkgVar2 = this.zzg;
            zzak(zzkgVar2);
            zzkgVar2.zza();
            return;
        }
        long jCurrentTimeMillis = zzav().currentTimeMillis();
        zzg();
        long jMax3 = Math.max(0L, zzdy.zzz.zza(null).longValue());
        zzaj zzajVar = this.zze;
        zzak(zzajVar);
        boolean z = true;
        if (!zzajVar.zzJ()) {
            zzaj zzajVar2 = this.zze;
            zzak(zzajVar2);
            if (!zzajVar2.zzI()) {
                z = false;
            }
        }
        if (z) {
            String strZzl = zzg().zzl();
            if (TextUtils.isEmpty(strZzl) || ".none.".equals(strZzl)) {
                zzg();
                jMax = Math.max(0L, zzdy.zzt.zza(null).longValue());
            } else {
                zzg();
                jMax = Math.max(0L, zzdy.zzu.zza(null).longValue());
            }
        } else {
            zzg();
            jMax = Math.max(0L, zzdy.zzs.zza(null).longValue());
        }
        long jZza = this.zzk.zzc.zza();
        long jZza2 = this.zzk.zzd.zza();
        zzaj zzajVar3 = this.zze;
        zzak(zzajVar3);
        boolean z2 = z;
        long jZzd = zzajVar3.zzd();
        zzaj zzajVar4 = this.zze;
        zzak(zzajVar4);
        long jMax4 = Math.max(jZzd, zzajVar4.zze());
        if (jMax4 == 0) {
            jMax2 = 0;
        } else {
            long jAbs2 = jCurrentTimeMillis - Math.abs(jMax4 - jCurrentTimeMillis);
            long jAbs3 = Math.abs(jZza - jCurrentTimeMillis);
            long jAbs4 = jCurrentTimeMillis - Math.abs(jZza2 - jCurrentTimeMillis);
            long jMax5 = Math.max(jCurrentTimeMillis - jAbs3, jAbs4);
            jMax2 = jAbs2 + jMax3;
            if (z2 && jMax5 > 0) {
                jMax2 = Math.min(jAbs2, jMax5) + jMax;
            }
            zzku zzkuVar = this.zzi;
            zzak(zzkuVar);
            if (!zzkuVar.zzx(jMax5, jMax)) {
                jMax2 = jMax5 + jMax;
            }
            if (jAbs4 != 0 && jAbs4 >= jAbs2) {
                int i = 0;
                while (true) {
                    zzg();
                    if (i >= Math.min(20, Math.max(0, zzdy.zzB.zza(null).intValue()))) {
                        break;
                    }
                    zzg();
                    jMax2 += Math.max(0L, zzdy.zzA.zza(null).longValue()) * (1 << i);
                    if (jMax2 > jAbs4) {
                        break;
                    } else {
                        i++;
                    }
                }
            }
        }
        if (jMax2 == 0) {
            zzay().zzj().zza("Next upload time is 0");
            zzm().zzc();
            zzkg zzkgVar3 = this.zzg;
            zzak(zzkgVar3);
            zzkgVar3.zza();
            return;
        }
        zzer zzerVar = this.zzd;
        zzak(zzerVar);
        if (!zzerVar.zza()) {
            zzay().zzj().zza("No network");
            zzm().zzb();
            zzkg zzkgVar4 = this.zzg;
            zzak(zzkgVar4);
            zzkgVar4.zza();
            return;
        }
        long jZza3 = this.zzk.zzb.zza();
        zzg();
        long jMax6 = Math.max(0L, zzdy.zzq.zza(null).longValue());
        zzku zzkuVar2 = this.zzi;
        zzak(zzkuVar2);
        if (!zzkuVar2.zzx(jZza3, jMax6)) {
            jMax2 = Math.max(jMax2, jZza3 + jMax6);
        }
        zzm().zzc();
        long jCurrentTimeMillis2 = jMax2 - zzav().currentTimeMillis();
        if (jCurrentTimeMillis2 <= 0) {
            zzg();
            jCurrentTimeMillis2 = Math.max(0L, zzdy.zzv.zza(null).longValue());
            this.zzk.zzc.zzb(zzav().currentTimeMillis());
        }
        zzay().zzj().zzb("Upload scheduled in approximately ms", Long.valueOf(jCurrentTimeMillis2));
        zzkg zzkgVar5 = this.zzg;
        zzak(zzkgVar5);
        zzkgVar5.zzd(jCurrentTimeMillis2);
    }

    private final boolean zzag(zzp zzpVar) {
        zzom.zzc();
        return zzg().zzs(zzpVar.zza, zzdy.zzac) ? (TextUtils.isEmpty(zzpVar.zzb) && TextUtils.isEmpty(zzpVar.zzu) && TextUtils.isEmpty(zzpVar.zzq)) ? false : true : (TextUtils.isEmpty(zzpVar.zzb) && TextUtils.isEmpty(zzpVar.zzq)) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x0396 A[Catch: all -> 0x0e1f, TryCatch #4 {all -> 0x0e1f, blocks: (B:3:0x0010, B:5:0x0028, B:8:0x0030, B:9:0x0058, B:12:0x006a, B:15:0x0091, B:17:0x00c7, B:20:0x00d9, B:22:0x00e3, B:214:0x069d, B:24:0x010b, B:26:0x0119, B:29:0x0139, B:31:0x013f, B:33:0x0151, B:35:0x015f, B:37:0x016f, B:38:0x017c, B:39:0x0181, B:42:0x019a, B:113:0x03c7, B:114:0x03d3, B:117:0x03dd, B:123:0x0400, B:120:0x03ef, B:145:0x047f, B:147:0x048b, B:150:0x049e, B:152:0x04af, B:154:0x04bb, B:203:0x062f, B:205:0x0639, B:207:0x063f, B:208:0x0657, B:210:0x066a, B:211:0x0682, B:213:0x068b, B:160:0x04ea, B:162:0x04f9, B:165:0x050e, B:167:0x0520, B:169:0x052c, B:175:0x054e, B:177:0x0564, B:179:0x0570, B:182:0x0583, B:184:0x0596, B:186:0x05df, B:188:0x05e6, B:190:0x05ec, B:192:0x05f6, B:194:0x05fd, B:196:0x0603, B:198:0x060f, B:199:0x0621, B:127:0x0408, B:129:0x0414, B:131:0x0420, B:143:0x0465, B:135:0x043d, B:138:0x044f, B:140:0x0455, B:142:0x045f, B:68:0x01fa, B:71:0x0204, B:73:0x0212, B:78:0x025d, B:74:0x0230, B:76:0x0241, B:82:0x026e, B:85:0x029d, B:86:0x02c7, B:88:0x02fe, B:90:0x0304, B:93:0x0310, B:95:0x0346, B:96:0x0361, B:98:0x0367, B:100:0x0375, B:104:0x0388, B:101:0x037d, B:107:0x038f, B:110:0x0396, B:111:0x03ae, B:219:0x06b8, B:221:0x06c6, B:223:0x06d1, B:234:0x0705, B:224:0x06d9, B:226:0x06e4, B:228:0x06ea, B:231:0x06f6, B:233:0x0700, B:236:0x070a, B:237:0x0716, B:240:0x071e, B:242:0x0730, B:243:0x073c, B:245:0x0744, B:249:0x0769, B:251:0x078e, B:253:0x079f, B:255:0x07a5, B:257:0x07b1, B:258:0x07e2, B:260:0x07e8, B:262:0x07f6, B:263:0x07fa, B:264:0x07fd, B:265:0x0800, B:266:0x080e, B:268:0x0814, B:270:0x0824, B:271:0x082b, B:273:0x0837, B:274:0x083e, B:275:0x0841, B:277:0x087f, B:278:0x0892, B:280:0x0898, B:283:0x08b0, B:285:0x08cb, B:287:0x08e2, B:289:0x08e7, B:291:0x08eb, B:293:0x08ef, B:295:0x08f9, B:296:0x0903, B:298:0x0907, B:300:0x090d, B:301:0x091d, B:302:0x0926, B:371:0x0b7a, B:304:0x0931, B:306:0x0948, B:312:0x0964, B:314:0x0986, B:315:0x098e, B:317:0x0994, B:319:0x09a6, B:326:0x09cf, B:327:0x09f2, B:329:0x09fe, B:331:0x0a13, B:333:0x0a54, B:337:0x0a6c, B:339:0x0a73, B:341:0x0a82, B:343:0x0a86, B:345:0x0a8a, B:347:0x0a8e, B:348:0x0a9a, B:349:0x0a9f, B:351:0x0aa5, B:353:0x0ac1, B:354:0x0ac6, B:370:0x0b77, B:355:0x0adf, B:357:0x0ae7, B:361:0x0b12, B:363:0x0b3e, B:365:0x0b4d, B:366:0x0b5d, B:368:0x0b67, B:358:0x0af8, B:324:0x09ba, B:310:0x094f, B:372:0x0b82, B:374:0x0b8e, B:375:0x0b94, B:376:0x0b9c, B:378:0x0ba2, B:381:0x0bbb, B:383:0x0bcc, B:403:0x0c40, B:405:0x0c46, B:407:0x0c5e, B:410:0x0c65, B:415:0x0c94, B:417:0x0cd6, B:420:0x0d0b, B:421:0x0d0f, B:422:0x0d1a, B:424:0x0d5d, B:425:0x0d6a, B:427:0x0d79, B:431:0x0d93, B:433:0x0dac, B:419:0x0ce8, B:411:0x0c6d, B:413:0x0c79, B:414:0x0c7d, B:434:0x0dc4, B:436:0x0dd8, B:441:0x0dfb, B:440:0x0de8, B:384:0x0be4, B:386:0x0bea, B:388:0x0bf4, B:390:0x0bfb, B:396:0x0c0b, B:398:0x0c12, B:400:0x0c31, B:402:0x0c38, B:401:0x0c35, B:397:0x0c0f, B:389:0x0bf8, B:246:0x0749, B:248:0x074f, B:444:0x0e0d), top: B:458:0x0010, inners: #0, #1, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x03ae A[Catch: all -> 0x0e1f, TryCatch #4 {all -> 0x0e1f, blocks: (B:3:0x0010, B:5:0x0028, B:8:0x0030, B:9:0x0058, B:12:0x006a, B:15:0x0091, B:17:0x00c7, B:20:0x00d9, B:22:0x00e3, B:214:0x069d, B:24:0x010b, B:26:0x0119, B:29:0x0139, B:31:0x013f, B:33:0x0151, B:35:0x015f, B:37:0x016f, B:38:0x017c, B:39:0x0181, B:42:0x019a, B:113:0x03c7, B:114:0x03d3, B:117:0x03dd, B:123:0x0400, B:120:0x03ef, B:145:0x047f, B:147:0x048b, B:150:0x049e, B:152:0x04af, B:154:0x04bb, B:203:0x062f, B:205:0x0639, B:207:0x063f, B:208:0x0657, B:210:0x066a, B:211:0x0682, B:213:0x068b, B:160:0x04ea, B:162:0x04f9, B:165:0x050e, B:167:0x0520, B:169:0x052c, B:175:0x054e, B:177:0x0564, B:179:0x0570, B:182:0x0583, B:184:0x0596, B:186:0x05df, B:188:0x05e6, B:190:0x05ec, B:192:0x05f6, B:194:0x05fd, B:196:0x0603, B:198:0x060f, B:199:0x0621, B:127:0x0408, B:129:0x0414, B:131:0x0420, B:143:0x0465, B:135:0x043d, B:138:0x044f, B:140:0x0455, B:142:0x045f, B:68:0x01fa, B:71:0x0204, B:73:0x0212, B:78:0x025d, B:74:0x0230, B:76:0x0241, B:82:0x026e, B:85:0x029d, B:86:0x02c7, B:88:0x02fe, B:90:0x0304, B:93:0x0310, B:95:0x0346, B:96:0x0361, B:98:0x0367, B:100:0x0375, B:104:0x0388, B:101:0x037d, B:107:0x038f, B:110:0x0396, B:111:0x03ae, B:219:0x06b8, B:221:0x06c6, B:223:0x06d1, B:234:0x0705, B:224:0x06d9, B:226:0x06e4, B:228:0x06ea, B:231:0x06f6, B:233:0x0700, B:236:0x070a, B:237:0x0716, B:240:0x071e, B:242:0x0730, B:243:0x073c, B:245:0x0744, B:249:0x0769, B:251:0x078e, B:253:0x079f, B:255:0x07a5, B:257:0x07b1, B:258:0x07e2, B:260:0x07e8, B:262:0x07f6, B:263:0x07fa, B:264:0x07fd, B:265:0x0800, B:266:0x080e, B:268:0x0814, B:270:0x0824, B:271:0x082b, B:273:0x0837, B:274:0x083e, B:275:0x0841, B:277:0x087f, B:278:0x0892, B:280:0x0898, B:283:0x08b0, B:285:0x08cb, B:287:0x08e2, B:289:0x08e7, B:291:0x08eb, B:293:0x08ef, B:295:0x08f9, B:296:0x0903, B:298:0x0907, B:300:0x090d, B:301:0x091d, B:302:0x0926, B:371:0x0b7a, B:304:0x0931, B:306:0x0948, B:312:0x0964, B:314:0x0986, B:315:0x098e, B:317:0x0994, B:319:0x09a6, B:326:0x09cf, B:327:0x09f2, B:329:0x09fe, B:331:0x0a13, B:333:0x0a54, B:337:0x0a6c, B:339:0x0a73, B:341:0x0a82, B:343:0x0a86, B:345:0x0a8a, B:347:0x0a8e, B:348:0x0a9a, B:349:0x0a9f, B:351:0x0aa5, B:353:0x0ac1, B:354:0x0ac6, B:370:0x0b77, B:355:0x0adf, B:357:0x0ae7, B:361:0x0b12, B:363:0x0b3e, B:365:0x0b4d, B:366:0x0b5d, B:368:0x0b67, B:358:0x0af8, B:324:0x09ba, B:310:0x094f, B:372:0x0b82, B:374:0x0b8e, B:375:0x0b94, B:376:0x0b9c, B:378:0x0ba2, B:381:0x0bbb, B:383:0x0bcc, B:403:0x0c40, B:405:0x0c46, B:407:0x0c5e, B:410:0x0c65, B:415:0x0c94, B:417:0x0cd6, B:420:0x0d0b, B:421:0x0d0f, B:422:0x0d1a, B:424:0x0d5d, B:425:0x0d6a, B:427:0x0d79, B:431:0x0d93, B:433:0x0dac, B:419:0x0ce8, B:411:0x0c6d, B:413:0x0c79, B:414:0x0c7d, B:434:0x0dc4, B:436:0x0dd8, B:441:0x0dfb, B:440:0x0de8, B:384:0x0be4, B:386:0x0bea, B:388:0x0bf4, B:390:0x0bfb, B:396:0x0c0b, B:398:0x0c12, B:400:0x0c31, B:402:0x0c38, B:401:0x0c35, B:397:0x0c0f, B:389:0x0bf8, B:246:0x0749, B:248:0x074f, B:444:0x0e0d), top: B:458:0x0010, inners: #0, #1, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x03c7 A[Catch: all -> 0x0e1f, TryCatch #4 {all -> 0x0e1f, blocks: (B:3:0x0010, B:5:0x0028, B:8:0x0030, B:9:0x0058, B:12:0x006a, B:15:0x0091, B:17:0x00c7, B:20:0x00d9, B:22:0x00e3, B:214:0x069d, B:24:0x010b, B:26:0x0119, B:29:0x0139, B:31:0x013f, B:33:0x0151, B:35:0x015f, B:37:0x016f, B:38:0x017c, B:39:0x0181, B:42:0x019a, B:113:0x03c7, B:114:0x03d3, B:117:0x03dd, B:123:0x0400, B:120:0x03ef, B:145:0x047f, B:147:0x048b, B:150:0x049e, B:152:0x04af, B:154:0x04bb, B:203:0x062f, B:205:0x0639, B:207:0x063f, B:208:0x0657, B:210:0x066a, B:211:0x0682, B:213:0x068b, B:160:0x04ea, B:162:0x04f9, B:165:0x050e, B:167:0x0520, B:169:0x052c, B:175:0x054e, B:177:0x0564, B:179:0x0570, B:182:0x0583, B:184:0x0596, B:186:0x05df, B:188:0x05e6, B:190:0x05ec, B:192:0x05f6, B:194:0x05fd, B:196:0x0603, B:198:0x060f, B:199:0x0621, B:127:0x0408, B:129:0x0414, B:131:0x0420, B:143:0x0465, B:135:0x043d, B:138:0x044f, B:140:0x0455, B:142:0x045f, B:68:0x01fa, B:71:0x0204, B:73:0x0212, B:78:0x025d, B:74:0x0230, B:76:0x0241, B:82:0x026e, B:85:0x029d, B:86:0x02c7, B:88:0x02fe, B:90:0x0304, B:93:0x0310, B:95:0x0346, B:96:0x0361, B:98:0x0367, B:100:0x0375, B:104:0x0388, B:101:0x037d, B:107:0x038f, B:110:0x0396, B:111:0x03ae, B:219:0x06b8, B:221:0x06c6, B:223:0x06d1, B:234:0x0705, B:224:0x06d9, B:226:0x06e4, B:228:0x06ea, B:231:0x06f6, B:233:0x0700, B:236:0x070a, B:237:0x0716, B:240:0x071e, B:242:0x0730, B:243:0x073c, B:245:0x0744, B:249:0x0769, B:251:0x078e, B:253:0x079f, B:255:0x07a5, B:257:0x07b1, B:258:0x07e2, B:260:0x07e8, B:262:0x07f6, B:263:0x07fa, B:264:0x07fd, B:265:0x0800, B:266:0x080e, B:268:0x0814, B:270:0x0824, B:271:0x082b, B:273:0x0837, B:274:0x083e, B:275:0x0841, B:277:0x087f, B:278:0x0892, B:280:0x0898, B:283:0x08b0, B:285:0x08cb, B:287:0x08e2, B:289:0x08e7, B:291:0x08eb, B:293:0x08ef, B:295:0x08f9, B:296:0x0903, B:298:0x0907, B:300:0x090d, B:301:0x091d, B:302:0x0926, B:371:0x0b7a, B:304:0x0931, B:306:0x0948, B:312:0x0964, B:314:0x0986, B:315:0x098e, B:317:0x0994, B:319:0x09a6, B:326:0x09cf, B:327:0x09f2, B:329:0x09fe, B:331:0x0a13, B:333:0x0a54, B:337:0x0a6c, B:339:0x0a73, B:341:0x0a82, B:343:0x0a86, B:345:0x0a8a, B:347:0x0a8e, B:348:0x0a9a, B:349:0x0a9f, B:351:0x0aa5, B:353:0x0ac1, B:354:0x0ac6, B:370:0x0b77, B:355:0x0adf, B:357:0x0ae7, B:361:0x0b12, B:363:0x0b3e, B:365:0x0b4d, B:366:0x0b5d, B:368:0x0b67, B:358:0x0af8, B:324:0x09ba, B:310:0x094f, B:372:0x0b82, B:374:0x0b8e, B:375:0x0b94, B:376:0x0b9c, B:378:0x0ba2, B:381:0x0bbb, B:383:0x0bcc, B:403:0x0c40, B:405:0x0c46, B:407:0x0c5e, B:410:0x0c65, B:415:0x0c94, B:417:0x0cd6, B:420:0x0d0b, B:421:0x0d0f, B:422:0x0d1a, B:424:0x0d5d, B:425:0x0d6a, B:427:0x0d79, B:431:0x0d93, B:433:0x0dac, B:419:0x0ce8, B:411:0x0c6d, B:413:0x0c79, B:414:0x0c7d, B:434:0x0dc4, B:436:0x0dd8, B:441:0x0dfb, B:440:0x0de8, B:384:0x0be4, B:386:0x0bea, B:388:0x0bf4, B:390:0x0bfb, B:396:0x0c0b, B:398:0x0c12, B:400:0x0c31, B:402:0x0c38, B:401:0x0c35, B:397:0x0c0f, B:389:0x0bf8, B:246:0x0749, B:248:0x074f, B:444:0x0e0d), top: B:458:0x0010, inners: #0, #1, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:144:0x047e  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x048b A[Catch: all -> 0x0e1f, TryCatch #4 {all -> 0x0e1f, blocks: (B:3:0x0010, B:5:0x0028, B:8:0x0030, B:9:0x0058, B:12:0x006a, B:15:0x0091, B:17:0x00c7, B:20:0x00d9, B:22:0x00e3, B:214:0x069d, B:24:0x010b, B:26:0x0119, B:29:0x0139, B:31:0x013f, B:33:0x0151, B:35:0x015f, B:37:0x016f, B:38:0x017c, B:39:0x0181, B:42:0x019a, B:113:0x03c7, B:114:0x03d3, B:117:0x03dd, B:123:0x0400, B:120:0x03ef, B:145:0x047f, B:147:0x048b, B:150:0x049e, B:152:0x04af, B:154:0x04bb, B:203:0x062f, B:205:0x0639, B:207:0x063f, B:208:0x0657, B:210:0x066a, B:211:0x0682, B:213:0x068b, B:160:0x04ea, B:162:0x04f9, B:165:0x050e, B:167:0x0520, B:169:0x052c, B:175:0x054e, B:177:0x0564, B:179:0x0570, B:182:0x0583, B:184:0x0596, B:186:0x05df, B:188:0x05e6, B:190:0x05ec, B:192:0x05f6, B:194:0x05fd, B:196:0x0603, B:198:0x060f, B:199:0x0621, B:127:0x0408, B:129:0x0414, B:131:0x0420, B:143:0x0465, B:135:0x043d, B:138:0x044f, B:140:0x0455, B:142:0x045f, B:68:0x01fa, B:71:0x0204, B:73:0x0212, B:78:0x025d, B:74:0x0230, B:76:0x0241, B:82:0x026e, B:85:0x029d, B:86:0x02c7, B:88:0x02fe, B:90:0x0304, B:93:0x0310, B:95:0x0346, B:96:0x0361, B:98:0x0367, B:100:0x0375, B:104:0x0388, B:101:0x037d, B:107:0x038f, B:110:0x0396, B:111:0x03ae, B:219:0x06b8, B:221:0x06c6, B:223:0x06d1, B:234:0x0705, B:224:0x06d9, B:226:0x06e4, B:228:0x06ea, B:231:0x06f6, B:233:0x0700, B:236:0x070a, B:237:0x0716, B:240:0x071e, B:242:0x0730, B:243:0x073c, B:245:0x0744, B:249:0x0769, B:251:0x078e, B:253:0x079f, B:255:0x07a5, B:257:0x07b1, B:258:0x07e2, B:260:0x07e8, B:262:0x07f6, B:263:0x07fa, B:264:0x07fd, B:265:0x0800, B:266:0x080e, B:268:0x0814, B:270:0x0824, B:271:0x082b, B:273:0x0837, B:274:0x083e, B:275:0x0841, B:277:0x087f, B:278:0x0892, B:280:0x0898, B:283:0x08b0, B:285:0x08cb, B:287:0x08e2, B:289:0x08e7, B:291:0x08eb, B:293:0x08ef, B:295:0x08f9, B:296:0x0903, B:298:0x0907, B:300:0x090d, B:301:0x091d, B:302:0x0926, B:371:0x0b7a, B:304:0x0931, B:306:0x0948, B:312:0x0964, B:314:0x0986, B:315:0x098e, B:317:0x0994, B:319:0x09a6, B:326:0x09cf, B:327:0x09f2, B:329:0x09fe, B:331:0x0a13, B:333:0x0a54, B:337:0x0a6c, B:339:0x0a73, B:341:0x0a82, B:343:0x0a86, B:345:0x0a8a, B:347:0x0a8e, B:348:0x0a9a, B:349:0x0a9f, B:351:0x0aa5, B:353:0x0ac1, B:354:0x0ac6, B:370:0x0b77, B:355:0x0adf, B:357:0x0ae7, B:361:0x0b12, B:363:0x0b3e, B:365:0x0b4d, B:366:0x0b5d, B:368:0x0b67, B:358:0x0af8, B:324:0x09ba, B:310:0x094f, B:372:0x0b82, B:374:0x0b8e, B:375:0x0b94, B:376:0x0b9c, B:378:0x0ba2, B:381:0x0bbb, B:383:0x0bcc, B:403:0x0c40, B:405:0x0c46, B:407:0x0c5e, B:410:0x0c65, B:415:0x0c94, B:417:0x0cd6, B:420:0x0d0b, B:421:0x0d0f, B:422:0x0d1a, B:424:0x0d5d, B:425:0x0d6a, B:427:0x0d79, B:431:0x0d93, B:433:0x0dac, B:419:0x0ce8, B:411:0x0c6d, B:413:0x0c79, B:414:0x0c7d, B:434:0x0dc4, B:436:0x0dd8, B:441:0x0dfb, B:440:0x0de8, B:384:0x0be4, B:386:0x0bea, B:388:0x0bf4, B:390:0x0bfb, B:396:0x0c0b, B:398:0x0c12, B:400:0x0c31, B:402:0x0c38, B:401:0x0c35, B:397:0x0c0f, B:389:0x0bf8, B:246:0x0749, B:248:0x074f, B:444:0x0e0d), top: B:458:0x0010, inners: #0, #1, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:160:0x04ea A[Catch: all -> 0x0e1f, TryCatch #4 {all -> 0x0e1f, blocks: (B:3:0x0010, B:5:0x0028, B:8:0x0030, B:9:0x0058, B:12:0x006a, B:15:0x0091, B:17:0x00c7, B:20:0x00d9, B:22:0x00e3, B:214:0x069d, B:24:0x010b, B:26:0x0119, B:29:0x0139, B:31:0x013f, B:33:0x0151, B:35:0x015f, B:37:0x016f, B:38:0x017c, B:39:0x0181, B:42:0x019a, B:113:0x03c7, B:114:0x03d3, B:117:0x03dd, B:123:0x0400, B:120:0x03ef, B:145:0x047f, B:147:0x048b, B:150:0x049e, B:152:0x04af, B:154:0x04bb, B:203:0x062f, B:205:0x0639, B:207:0x063f, B:208:0x0657, B:210:0x066a, B:211:0x0682, B:213:0x068b, B:160:0x04ea, B:162:0x04f9, B:165:0x050e, B:167:0x0520, B:169:0x052c, B:175:0x054e, B:177:0x0564, B:179:0x0570, B:182:0x0583, B:184:0x0596, B:186:0x05df, B:188:0x05e6, B:190:0x05ec, B:192:0x05f6, B:194:0x05fd, B:196:0x0603, B:198:0x060f, B:199:0x0621, B:127:0x0408, B:129:0x0414, B:131:0x0420, B:143:0x0465, B:135:0x043d, B:138:0x044f, B:140:0x0455, B:142:0x045f, B:68:0x01fa, B:71:0x0204, B:73:0x0212, B:78:0x025d, B:74:0x0230, B:76:0x0241, B:82:0x026e, B:85:0x029d, B:86:0x02c7, B:88:0x02fe, B:90:0x0304, B:93:0x0310, B:95:0x0346, B:96:0x0361, B:98:0x0367, B:100:0x0375, B:104:0x0388, B:101:0x037d, B:107:0x038f, B:110:0x0396, B:111:0x03ae, B:219:0x06b8, B:221:0x06c6, B:223:0x06d1, B:234:0x0705, B:224:0x06d9, B:226:0x06e4, B:228:0x06ea, B:231:0x06f6, B:233:0x0700, B:236:0x070a, B:237:0x0716, B:240:0x071e, B:242:0x0730, B:243:0x073c, B:245:0x0744, B:249:0x0769, B:251:0x078e, B:253:0x079f, B:255:0x07a5, B:257:0x07b1, B:258:0x07e2, B:260:0x07e8, B:262:0x07f6, B:263:0x07fa, B:264:0x07fd, B:265:0x0800, B:266:0x080e, B:268:0x0814, B:270:0x0824, B:271:0x082b, B:273:0x0837, B:274:0x083e, B:275:0x0841, B:277:0x087f, B:278:0x0892, B:280:0x0898, B:283:0x08b0, B:285:0x08cb, B:287:0x08e2, B:289:0x08e7, B:291:0x08eb, B:293:0x08ef, B:295:0x08f9, B:296:0x0903, B:298:0x0907, B:300:0x090d, B:301:0x091d, B:302:0x0926, B:371:0x0b7a, B:304:0x0931, B:306:0x0948, B:312:0x0964, B:314:0x0986, B:315:0x098e, B:317:0x0994, B:319:0x09a6, B:326:0x09cf, B:327:0x09f2, B:329:0x09fe, B:331:0x0a13, B:333:0x0a54, B:337:0x0a6c, B:339:0x0a73, B:341:0x0a82, B:343:0x0a86, B:345:0x0a8a, B:347:0x0a8e, B:348:0x0a9a, B:349:0x0a9f, B:351:0x0aa5, B:353:0x0ac1, B:354:0x0ac6, B:370:0x0b77, B:355:0x0adf, B:357:0x0ae7, B:361:0x0b12, B:363:0x0b3e, B:365:0x0b4d, B:366:0x0b5d, B:368:0x0b67, B:358:0x0af8, B:324:0x09ba, B:310:0x094f, B:372:0x0b82, B:374:0x0b8e, B:375:0x0b94, B:376:0x0b9c, B:378:0x0ba2, B:381:0x0bbb, B:383:0x0bcc, B:403:0x0c40, B:405:0x0c46, B:407:0x0c5e, B:410:0x0c65, B:415:0x0c94, B:417:0x0cd6, B:420:0x0d0b, B:421:0x0d0f, B:422:0x0d1a, B:424:0x0d5d, B:425:0x0d6a, B:427:0x0d79, B:431:0x0d93, B:433:0x0dac, B:419:0x0ce8, B:411:0x0c6d, B:413:0x0c79, B:414:0x0c7d, B:434:0x0dc4, B:436:0x0dd8, B:441:0x0dfb, B:440:0x0de8, B:384:0x0be4, B:386:0x0bea, B:388:0x0bf4, B:390:0x0bfb, B:396:0x0c0b, B:398:0x0c12, B:400:0x0c31, B:402:0x0c38, B:401:0x0c35, B:397:0x0c0f, B:389:0x0bf8, B:246:0x0749, B:248:0x074f, B:444:0x0e0d), top: B:458:0x0010, inners: #0, #1, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:203:0x062f A[Catch: all -> 0x0e1f, TryCatch #4 {all -> 0x0e1f, blocks: (B:3:0x0010, B:5:0x0028, B:8:0x0030, B:9:0x0058, B:12:0x006a, B:15:0x0091, B:17:0x00c7, B:20:0x00d9, B:22:0x00e3, B:214:0x069d, B:24:0x010b, B:26:0x0119, B:29:0x0139, B:31:0x013f, B:33:0x0151, B:35:0x015f, B:37:0x016f, B:38:0x017c, B:39:0x0181, B:42:0x019a, B:113:0x03c7, B:114:0x03d3, B:117:0x03dd, B:123:0x0400, B:120:0x03ef, B:145:0x047f, B:147:0x048b, B:150:0x049e, B:152:0x04af, B:154:0x04bb, B:203:0x062f, B:205:0x0639, B:207:0x063f, B:208:0x0657, B:210:0x066a, B:211:0x0682, B:213:0x068b, B:160:0x04ea, B:162:0x04f9, B:165:0x050e, B:167:0x0520, B:169:0x052c, B:175:0x054e, B:177:0x0564, B:179:0x0570, B:182:0x0583, B:184:0x0596, B:186:0x05df, B:188:0x05e6, B:190:0x05ec, B:192:0x05f6, B:194:0x05fd, B:196:0x0603, B:198:0x060f, B:199:0x0621, B:127:0x0408, B:129:0x0414, B:131:0x0420, B:143:0x0465, B:135:0x043d, B:138:0x044f, B:140:0x0455, B:142:0x045f, B:68:0x01fa, B:71:0x0204, B:73:0x0212, B:78:0x025d, B:74:0x0230, B:76:0x0241, B:82:0x026e, B:85:0x029d, B:86:0x02c7, B:88:0x02fe, B:90:0x0304, B:93:0x0310, B:95:0x0346, B:96:0x0361, B:98:0x0367, B:100:0x0375, B:104:0x0388, B:101:0x037d, B:107:0x038f, B:110:0x0396, B:111:0x03ae, B:219:0x06b8, B:221:0x06c6, B:223:0x06d1, B:234:0x0705, B:224:0x06d9, B:226:0x06e4, B:228:0x06ea, B:231:0x06f6, B:233:0x0700, B:236:0x070a, B:237:0x0716, B:240:0x071e, B:242:0x0730, B:243:0x073c, B:245:0x0744, B:249:0x0769, B:251:0x078e, B:253:0x079f, B:255:0x07a5, B:257:0x07b1, B:258:0x07e2, B:260:0x07e8, B:262:0x07f6, B:263:0x07fa, B:264:0x07fd, B:265:0x0800, B:266:0x080e, B:268:0x0814, B:270:0x0824, B:271:0x082b, B:273:0x0837, B:274:0x083e, B:275:0x0841, B:277:0x087f, B:278:0x0892, B:280:0x0898, B:283:0x08b0, B:285:0x08cb, B:287:0x08e2, B:289:0x08e7, B:291:0x08eb, B:293:0x08ef, B:295:0x08f9, B:296:0x0903, B:298:0x0907, B:300:0x090d, B:301:0x091d, B:302:0x0926, B:371:0x0b7a, B:304:0x0931, B:306:0x0948, B:312:0x0964, B:314:0x0986, B:315:0x098e, B:317:0x0994, B:319:0x09a6, B:326:0x09cf, B:327:0x09f2, B:329:0x09fe, B:331:0x0a13, B:333:0x0a54, B:337:0x0a6c, B:339:0x0a73, B:341:0x0a82, B:343:0x0a86, B:345:0x0a8a, B:347:0x0a8e, B:348:0x0a9a, B:349:0x0a9f, B:351:0x0aa5, B:353:0x0ac1, B:354:0x0ac6, B:370:0x0b77, B:355:0x0adf, B:357:0x0ae7, B:361:0x0b12, B:363:0x0b3e, B:365:0x0b4d, B:366:0x0b5d, B:368:0x0b67, B:358:0x0af8, B:324:0x09ba, B:310:0x094f, B:372:0x0b82, B:374:0x0b8e, B:375:0x0b94, B:376:0x0b9c, B:378:0x0ba2, B:381:0x0bbb, B:383:0x0bcc, B:403:0x0c40, B:405:0x0c46, B:407:0x0c5e, B:410:0x0c65, B:415:0x0c94, B:417:0x0cd6, B:420:0x0d0b, B:421:0x0d0f, B:422:0x0d1a, B:424:0x0d5d, B:425:0x0d6a, B:427:0x0d79, B:431:0x0d93, B:433:0x0dac, B:419:0x0ce8, B:411:0x0c6d, B:413:0x0c79, B:414:0x0c7d, B:434:0x0dc4, B:436:0x0dd8, B:441:0x0dfb, B:440:0x0de8, B:384:0x0be4, B:386:0x0bea, B:388:0x0bf4, B:390:0x0bfb, B:396:0x0c0b, B:398:0x0c12, B:400:0x0c31, B:402:0x0c38, B:401:0x0c35, B:397:0x0c0f, B:389:0x0bf8, B:246:0x0749, B:248:0x074f, B:444:0x0e0d), top: B:458:0x0010, inners: #0, #1, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0689  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x06d9 A[Catch: all -> 0x0e1f, TryCatch #4 {all -> 0x0e1f, blocks: (B:3:0x0010, B:5:0x0028, B:8:0x0030, B:9:0x0058, B:12:0x006a, B:15:0x0091, B:17:0x00c7, B:20:0x00d9, B:22:0x00e3, B:214:0x069d, B:24:0x010b, B:26:0x0119, B:29:0x0139, B:31:0x013f, B:33:0x0151, B:35:0x015f, B:37:0x016f, B:38:0x017c, B:39:0x0181, B:42:0x019a, B:113:0x03c7, B:114:0x03d3, B:117:0x03dd, B:123:0x0400, B:120:0x03ef, B:145:0x047f, B:147:0x048b, B:150:0x049e, B:152:0x04af, B:154:0x04bb, B:203:0x062f, B:205:0x0639, B:207:0x063f, B:208:0x0657, B:210:0x066a, B:211:0x0682, B:213:0x068b, B:160:0x04ea, B:162:0x04f9, B:165:0x050e, B:167:0x0520, B:169:0x052c, B:175:0x054e, B:177:0x0564, B:179:0x0570, B:182:0x0583, B:184:0x0596, B:186:0x05df, B:188:0x05e6, B:190:0x05ec, B:192:0x05f6, B:194:0x05fd, B:196:0x0603, B:198:0x060f, B:199:0x0621, B:127:0x0408, B:129:0x0414, B:131:0x0420, B:143:0x0465, B:135:0x043d, B:138:0x044f, B:140:0x0455, B:142:0x045f, B:68:0x01fa, B:71:0x0204, B:73:0x0212, B:78:0x025d, B:74:0x0230, B:76:0x0241, B:82:0x026e, B:85:0x029d, B:86:0x02c7, B:88:0x02fe, B:90:0x0304, B:93:0x0310, B:95:0x0346, B:96:0x0361, B:98:0x0367, B:100:0x0375, B:104:0x0388, B:101:0x037d, B:107:0x038f, B:110:0x0396, B:111:0x03ae, B:219:0x06b8, B:221:0x06c6, B:223:0x06d1, B:234:0x0705, B:224:0x06d9, B:226:0x06e4, B:228:0x06ea, B:231:0x06f6, B:233:0x0700, B:236:0x070a, B:237:0x0716, B:240:0x071e, B:242:0x0730, B:243:0x073c, B:245:0x0744, B:249:0x0769, B:251:0x078e, B:253:0x079f, B:255:0x07a5, B:257:0x07b1, B:258:0x07e2, B:260:0x07e8, B:262:0x07f6, B:263:0x07fa, B:264:0x07fd, B:265:0x0800, B:266:0x080e, B:268:0x0814, B:270:0x0824, B:271:0x082b, B:273:0x0837, B:274:0x083e, B:275:0x0841, B:277:0x087f, B:278:0x0892, B:280:0x0898, B:283:0x08b0, B:285:0x08cb, B:287:0x08e2, B:289:0x08e7, B:291:0x08eb, B:293:0x08ef, B:295:0x08f9, B:296:0x0903, B:298:0x0907, B:300:0x090d, B:301:0x091d, B:302:0x0926, B:371:0x0b7a, B:304:0x0931, B:306:0x0948, B:312:0x0964, B:314:0x0986, B:315:0x098e, B:317:0x0994, B:319:0x09a6, B:326:0x09cf, B:327:0x09f2, B:329:0x09fe, B:331:0x0a13, B:333:0x0a54, B:337:0x0a6c, B:339:0x0a73, B:341:0x0a82, B:343:0x0a86, B:345:0x0a8a, B:347:0x0a8e, B:348:0x0a9a, B:349:0x0a9f, B:351:0x0aa5, B:353:0x0ac1, B:354:0x0ac6, B:370:0x0b77, B:355:0x0adf, B:357:0x0ae7, B:361:0x0b12, B:363:0x0b3e, B:365:0x0b4d, B:366:0x0b5d, B:368:0x0b67, B:358:0x0af8, B:324:0x09ba, B:310:0x094f, B:372:0x0b82, B:374:0x0b8e, B:375:0x0b94, B:376:0x0b9c, B:378:0x0ba2, B:381:0x0bbb, B:383:0x0bcc, B:403:0x0c40, B:405:0x0c46, B:407:0x0c5e, B:410:0x0c65, B:415:0x0c94, B:417:0x0cd6, B:420:0x0d0b, B:421:0x0d0f, B:422:0x0d1a, B:424:0x0d5d, B:425:0x0d6a, B:427:0x0d79, B:431:0x0d93, B:433:0x0dac, B:419:0x0ce8, B:411:0x0c6d, B:413:0x0c79, B:414:0x0c7d, B:434:0x0dc4, B:436:0x0dd8, B:441:0x0dfb, B:440:0x0de8, B:384:0x0be4, B:386:0x0bea, B:388:0x0bf4, B:390:0x0bfb, B:396:0x0c0b, B:398:0x0c12, B:400:0x0c31, B:402:0x0c38, B:401:0x0c35, B:397:0x0c0f, B:389:0x0bf8, B:246:0x0749, B:248:0x074f, B:444:0x0e0d), top: B:458:0x0010, inners: #0, #1, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:314:0x0986 A[Catch: all -> 0x0e1f, TryCatch #4 {all -> 0x0e1f, blocks: (B:3:0x0010, B:5:0x0028, B:8:0x0030, B:9:0x0058, B:12:0x006a, B:15:0x0091, B:17:0x00c7, B:20:0x00d9, B:22:0x00e3, B:214:0x069d, B:24:0x010b, B:26:0x0119, B:29:0x0139, B:31:0x013f, B:33:0x0151, B:35:0x015f, B:37:0x016f, B:38:0x017c, B:39:0x0181, B:42:0x019a, B:113:0x03c7, B:114:0x03d3, B:117:0x03dd, B:123:0x0400, B:120:0x03ef, B:145:0x047f, B:147:0x048b, B:150:0x049e, B:152:0x04af, B:154:0x04bb, B:203:0x062f, B:205:0x0639, B:207:0x063f, B:208:0x0657, B:210:0x066a, B:211:0x0682, B:213:0x068b, B:160:0x04ea, B:162:0x04f9, B:165:0x050e, B:167:0x0520, B:169:0x052c, B:175:0x054e, B:177:0x0564, B:179:0x0570, B:182:0x0583, B:184:0x0596, B:186:0x05df, B:188:0x05e6, B:190:0x05ec, B:192:0x05f6, B:194:0x05fd, B:196:0x0603, B:198:0x060f, B:199:0x0621, B:127:0x0408, B:129:0x0414, B:131:0x0420, B:143:0x0465, B:135:0x043d, B:138:0x044f, B:140:0x0455, B:142:0x045f, B:68:0x01fa, B:71:0x0204, B:73:0x0212, B:78:0x025d, B:74:0x0230, B:76:0x0241, B:82:0x026e, B:85:0x029d, B:86:0x02c7, B:88:0x02fe, B:90:0x0304, B:93:0x0310, B:95:0x0346, B:96:0x0361, B:98:0x0367, B:100:0x0375, B:104:0x0388, B:101:0x037d, B:107:0x038f, B:110:0x0396, B:111:0x03ae, B:219:0x06b8, B:221:0x06c6, B:223:0x06d1, B:234:0x0705, B:224:0x06d9, B:226:0x06e4, B:228:0x06ea, B:231:0x06f6, B:233:0x0700, B:236:0x070a, B:237:0x0716, B:240:0x071e, B:242:0x0730, B:243:0x073c, B:245:0x0744, B:249:0x0769, B:251:0x078e, B:253:0x079f, B:255:0x07a5, B:257:0x07b1, B:258:0x07e2, B:260:0x07e8, B:262:0x07f6, B:263:0x07fa, B:264:0x07fd, B:265:0x0800, B:266:0x080e, B:268:0x0814, B:270:0x0824, B:271:0x082b, B:273:0x0837, B:274:0x083e, B:275:0x0841, B:277:0x087f, B:278:0x0892, B:280:0x0898, B:283:0x08b0, B:285:0x08cb, B:287:0x08e2, B:289:0x08e7, B:291:0x08eb, B:293:0x08ef, B:295:0x08f9, B:296:0x0903, B:298:0x0907, B:300:0x090d, B:301:0x091d, B:302:0x0926, B:371:0x0b7a, B:304:0x0931, B:306:0x0948, B:312:0x0964, B:314:0x0986, B:315:0x098e, B:317:0x0994, B:319:0x09a6, B:326:0x09cf, B:327:0x09f2, B:329:0x09fe, B:331:0x0a13, B:333:0x0a54, B:337:0x0a6c, B:339:0x0a73, B:341:0x0a82, B:343:0x0a86, B:345:0x0a8a, B:347:0x0a8e, B:348:0x0a9a, B:349:0x0a9f, B:351:0x0aa5, B:353:0x0ac1, B:354:0x0ac6, B:370:0x0b77, B:355:0x0adf, B:357:0x0ae7, B:361:0x0b12, B:363:0x0b3e, B:365:0x0b4d, B:366:0x0b5d, B:368:0x0b67, B:358:0x0af8, B:324:0x09ba, B:310:0x094f, B:372:0x0b82, B:374:0x0b8e, B:375:0x0b94, B:376:0x0b9c, B:378:0x0ba2, B:381:0x0bbb, B:383:0x0bcc, B:403:0x0c40, B:405:0x0c46, B:407:0x0c5e, B:410:0x0c65, B:415:0x0c94, B:417:0x0cd6, B:420:0x0d0b, B:421:0x0d0f, B:422:0x0d1a, B:424:0x0d5d, B:425:0x0d6a, B:427:0x0d79, B:431:0x0d93, B:433:0x0dac, B:419:0x0ce8, B:411:0x0c6d, B:413:0x0c79, B:414:0x0c7d, B:434:0x0dc4, B:436:0x0dd8, B:441:0x0dfb, B:440:0x0de8, B:384:0x0be4, B:386:0x0bea, B:388:0x0bf4, B:390:0x0bfb, B:396:0x0c0b, B:398:0x0c12, B:400:0x0c31, B:402:0x0c38, B:401:0x0c35, B:397:0x0c0f, B:389:0x0bf8, B:246:0x0749, B:248:0x074f, B:444:0x0e0d), top: B:458:0x0010, inners: #0, #1, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:324:0x09ba A[Catch: all -> 0x0e1f, EDGE_INSN: B:498:0x09ba->B:324:0x09ba BREAK  A[LOOP:11: B:315:0x098e->B:323:0x09b7], TryCatch #4 {all -> 0x0e1f, blocks: (B:3:0x0010, B:5:0x0028, B:8:0x0030, B:9:0x0058, B:12:0x006a, B:15:0x0091, B:17:0x00c7, B:20:0x00d9, B:22:0x00e3, B:214:0x069d, B:24:0x010b, B:26:0x0119, B:29:0x0139, B:31:0x013f, B:33:0x0151, B:35:0x015f, B:37:0x016f, B:38:0x017c, B:39:0x0181, B:42:0x019a, B:113:0x03c7, B:114:0x03d3, B:117:0x03dd, B:123:0x0400, B:120:0x03ef, B:145:0x047f, B:147:0x048b, B:150:0x049e, B:152:0x04af, B:154:0x04bb, B:203:0x062f, B:205:0x0639, B:207:0x063f, B:208:0x0657, B:210:0x066a, B:211:0x0682, B:213:0x068b, B:160:0x04ea, B:162:0x04f9, B:165:0x050e, B:167:0x0520, B:169:0x052c, B:175:0x054e, B:177:0x0564, B:179:0x0570, B:182:0x0583, B:184:0x0596, B:186:0x05df, B:188:0x05e6, B:190:0x05ec, B:192:0x05f6, B:194:0x05fd, B:196:0x0603, B:198:0x060f, B:199:0x0621, B:127:0x0408, B:129:0x0414, B:131:0x0420, B:143:0x0465, B:135:0x043d, B:138:0x044f, B:140:0x0455, B:142:0x045f, B:68:0x01fa, B:71:0x0204, B:73:0x0212, B:78:0x025d, B:74:0x0230, B:76:0x0241, B:82:0x026e, B:85:0x029d, B:86:0x02c7, B:88:0x02fe, B:90:0x0304, B:93:0x0310, B:95:0x0346, B:96:0x0361, B:98:0x0367, B:100:0x0375, B:104:0x0388, B:101:0x037d, B:107:0x038f, B:110:0x0396, B:111:0x03ae, B:219:0x06b8, B:221:0x06c6, B:223:0x06d1, B:234:0x0705, B:224:0x06d9, B:226:0x06e4, B:228:0x06ea, B:231:0x06f6, B:233:0x0700, B:236:0x070a, B:237:0x0716, B:240:0x071e, B:242:0x0730, B:243:0x073c, B:245:0x0744, B:249:0x0769, B:251:0x078e, B:253:0x079f, B:255:0x07a5, B:257:0x07b1, B:258:0x07e2, B:260:0x07e8, B:262:0x07f6, B:263:0x07fa, B:264:0x07fd, B:265:0x0800, B:266:0x080e, B:268:0x0814, B:270:0x0824, B:271:0x082b, B:273:0x0837, B:274:0x083e, B:275:0x0841, B:277:0x087f, B:278:0x0892, B:280:0x0898, B:283:0x08b0, B:285:0x08cb, B:287:0x08e2, B:289:0x08e7, B:291:0x08eb, B:293:0x08ef, B:295:0x08f9, B:296:0x0903, B:298:0x0907, B:300:0x090d, B:301:0x091d, B:302:0x0926, B:371:0x0b7a, B:304:0x0931, B:306:0x0948, B:312:0x0964, B:314:0x0986, B:315:0x098e, B:317:0x0994, B:319:0x09a6, B:326:0x09cf, B:327:0x09f2, B:329:0x09fe, B:331:0x0a13, B:333:0x0a54, B:337:0x0a6c, B:339:0x0a73, B:341:0x0a82, B:343:0x0a86, B:345:0x0a8a, B:347:0x0a8e, B:348:0x0a9a, B:349:0x0a9f, B:351:0x0aa5, B:353:0x0ac1, B:354:0x0ac6, B:370:0x0b77, B:355:0x0adf, B:357:0x0ae7, B:361:0x0b12, B:363:0x0b3e, B:365:0x0b4d, B:366:0x0b5d, B:368:0x0b67, B:358:0x0af8, B:324:0x09ba, B:310:0x094f, B:372:0x0b82, B:374:0x0b8e, B:375:0x0b94, B:376:0x0b9c, B:378:0x0ba2, B:381:0x0bbb, B:383:0x0bcc, B:403:0x0c40, B:405:0x0c46, B:407:0x0c5e, B:410:0x0c65, B:415:0x0c94, B:417:0x0cd6, B:420:0x0d0b, B:421:0x0d0f, B:422:0x0d1a, B:424:0x0d5d, B:425:0x0d6a, B:427:0x0d79, B:431:0x0d93, B:433:0x0dac, B:419:0x0ce8, B:411:0x0c6d, B:413:0x0c79, B:414:0x0c7d, B:434:0x0dc4, B:436:0x0dd8, B:441:0x0dfb, B:440:0x0de8, B:384:0x0be4, B:386:0x0bea, B:388:0x0bf4, B:390:0x0bfb, B:396:0x0c0b, B:398:0x0c12, B:400:0x0c31, B:402:0x0c38, B:401:0x0c35, B:397:0x0c0f, B:389:0x0bf8, B:246:0x0749, B:248:0x074f, B:444:0x0e0d), top: B:458:0x0010, inners: #0, #1, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:326:0x09cf A[Catch: all -> 0x0e1f, TryCatch #4 {all -> 0x0e1f, blocks: (B:3:0x0010, B:5:0x0028, B:8:0x0030, B:9:0x0058, B:12:0x006a, B:15:0x0091, B:17:0x00c7, B:20:0x00d9, B:22:0x00e3, B:214:0x069d, B:24:0x010b, B:26:0x0119, B:29:0x0139, B:31:0x013f, B:33:0x0151, B:35:0x015f, B:37:0x016f, B:38:0x017c, B:39:0x0181, B:42:0x019a, B:113:0x03c7, B:114:0x03d3, B:117:0x03dd, B:123:0x0400, B:120:0x03ef, B:145:0x047f, B:147:0x048b, B:150:0x049e, B:152:0x04af, B:154:0x04bb, B:203:0x062f, B:205:0x0639, B:207:0x063f, B:208:0x0657, B:210:0x066a, B:211:0x0682, B:213:0x068b, B:160:0x04ea, B:162:0x04f9, B:165:0x050e, B:167:0x0520, B:169:0x052c, B:175:0x054e, B:177:0x0564, B:179:0x0570, B:182:0x0583, B:184:0x0596, B:186:0x05df, B:188:0x05e6, B:190:0x05ec, B:192:0x05f6, B:194:0x05fd, B:196:0x0603, B:198:0x060f, B:199:0x0621, B:127:0x0408, B:129:0x0414, B:131:0x0420, B:143:0x0465, B:135:0x043d, B:138:0x044f, B:140:0x0455, B:142:0x045f, B:68:0x01fa, B:71:0x0204, B:73:0x0212, B:78:0x025d, B:74:0x0230, B:76:0x0241, B:82:0x026e, B:85:0x029d, B:86:0x02c7, B:88:0x02fe, B:90:0x0304, B:93:0x0310, B:95:0x0346, B:96:0x0361, B:98:0x0367, B:100:0x0375, B:104:0x0388, B:101:0x037d, B:107:0x038f, B:110:0x0396, B:111:0x03ae, B:219:0x06b8, B:221:0x06c6, B:223:0x06d1, B:234:0x0705, B:224:0x06d9, B:226:0x06e4, B:228:0x06ea, B:231:0x06f6, B:233:0x0700, B:236:0x070a, B:237:0x0716, B:240:0x071e, B:242:0x0730, B:243:0x073c, B:245:0x0744, B:249:0x0769, B:251:0x078e, B:253:0x079f, B:255:0x07a5, B:257:0x07b1, B:258:0x07e2, B:260:0x07e8, B:262:0x07f6, B:263:0x07fa, B:264:0x07fd, B:265:0x0800, B:266:0x080e, B:268:0x0814, B:270:0x0824, B:271:0x082b, B:273:0x0837, B:274:0x083e, B:275:0x0841, B:277:0x087f, B:278:0x0892, B:280:0x0898, B:283:0x08b0, B:285:0x08cb, B:287:0x08e2, B:289:0x08e7, B:291:0x08eb, B:293:0x08ef, B:295:0x08f9, B:296:0x0903, B:298:0x0907, B:300:0x090d, B:301:0x091d, B:302:0x0926, B:371:0x0b7a, B:304:0x0931, B:306:0x0948, B:312:0x0964, B:314:0x0986, B:315:0x098e, B:317:0x0994, B:319:0x09a6, B:326:0x09cf, B:327:0x09f2, B:329:0x09fe, B:331:0x0a13, B:333:0x0a54, B:337:0x0a6c, B:339:0x0a73, B:341:0x0a82, B:343:0x0a86, B:345:0x0a8a, B:347:0x0a8e, B:348:0x0a9a, B:349:0x0a9f, B:351:0x0aa5, B:353:0x0ac1, B:354:0x0ac6, B:370:0x0b77, B:355:0x0adf, B:357:0x0ae7, B:361:0x0b12, B:363:0x0b3e, B:365:0x0b4d, B:366:0x0b5d, B:368:0x0b67, B:358:0x0af8, B:324:0x09ba, B:310:0x094f, B:372:0x0b82, B:374:0x0b8e, B:375:0x0b94, B:376:0x0b9c, B:378:0x0ba2, B:381:0x0bbb, B:383:0x0bcc, B:403:0x0c40, B:405:0x0c46, B:407:0x0c5e, B:410:0x0c65, B:415:0x0c94, B:417:0x0cd6, B:420:0x0d0b, B:421:0x0d0f, B:422:0x0d1a, B:424:0x0d5d, B:425:0x0d6a, B:427:0x0d79, B:431:0x0d93, B:433:0x0dac, B:419:0x0ce8, B:411:0x0c6d, B:413:0x0c79, B:414:0x0c7d, B:434:0x0dc4, B:436:0x0dd8, B:441:0x0dfb, B:440:0x0de8, B:384:0x0be4, B:386:0x0bea, B:388:0x0bf4, B:390:0x0bfb, B:396:0x0c0b, B:398:0x0c12, B:400:0x0c31, B:402:0x0c38, B:401:0x0c35, B:397:0x0c0f, B:389:0x0bf8, B:246:0x0749, B:248:0x074f, B:444:0x0e0d), top: B:458:0x0010, inners: #0, #1, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:327:0x09f2 A[Catch: all -> 0x0e1f, TryCatch #4 {all -> 0x0e1f, blocks: (B:3:0x0010, B:5:0x0028, B:8:0x0030, B:9:0x0058, B:12:0x006a, B:15:0x0091, B:17:0x00c7, B:20:0x00d9, B:22:0x00e3, B:214:0x069d, B:24:0x010b, B:26:0x0119, B:29:0x0139, B:31:0x013f, B:33:0x0151, B:35:0x015f, B:37:0x016f, B:38:0x017c, B:39:0x0181, B:42:0x019a, B:113:0x03c7, B:114:0x03d3, B:117:0x03dd, B:123:0x0400, B:120:0x03ef, B:145:0x047f, B:147:0x048b, B:150:0x049e, B:152:0x04af, B:154:0x04bb, B:203:0x062f, B:205:0x0639, B:207:0x063f, B:208:0x0657, B:210:0x066a, B:211:0x0682, B:213:0x068b, B:160:0x04ea, B:162:0x04f9, B:165:0x050e, B:167:0x0520, B:169:0x052c, B:175:0x054e, B:177:0x0564, B:179:0x0570, B:182:0x0583, B:184:0x0596, B:186:0x05df, B:188:0x05e6, B:190:0x05ec, B:192:0x05f6, B:194:0x05fd, B:196:0x0603, B:198:0x060f, B:199:0x0621, B:127:0x0408, B:129:0x0414, B:131:0x0420, B:143:0x0465, B:135:0x043d, B:138:0x044f, B:140:0x0455, B:142:0x045f, B:68:0x01fa, B:71:0x0204, B:73:0x0212, B:78:0x025d, B:74:0x0230, B:76:0x0241, B:82:0x026e, B:85:0x029d, B:86:0x02c7, B:88:0x02fe, B:90:0x0304, B:93:0x0310, B:95:0x0346, B:96:0x0361, B:98:0x0367, B:100:0x0375, B:104:0x0388, B:101:0x037d, B:107:0x038f, B:110:0x0396, B:111:0x03ae, B:219:0x06b8, B:221:0x06c6, B:223:0x06d1, B:234:0x0705, B:224:0x06d9, B:226:0x06e4, B:228:0x06ea, B:231:0x06f6, B:233:0x0700, B:236:0x070a, B:237:0x0716, B:240:0x071e, B:242:0x0730, B:243:0x073c, B:245:0x0744, B:249:0x0769, B:251:0x078e, B:253:0x079f, B:255:0x07a5, B:257:0x07b1, B:258:0x07e2, B:260:0x07e8, B:262:0x07f6, B:263:0x07fa, B:264:0x07fd, B:265:0x0800, B:266:0x080e, B:268:0x0814, B:270:0x0824, B:271:0x082b, B:273:0x0837, B:274:0x083e, B:275:0x0841, B:277:0x087f, B:278:0x0892, B:280:0x0898, B:283:0x08b0, B:285:0x08cb, B:287:0x08e2, B:289:0x08e7, B:291:0x08eb, B:293:0x08ef, B:295:0x08f9, B:296:0x0903, B:298:0x0907, B:300:0x090d, B:301:0x091d, B:302:0x0926, B:371:0x0b7a, B:304:0x0931, B:306:0x0948, B:312:0x0964, B:314:0x0986, B:315:0x098e, B:317:0x0994, B:319:0x09a6, B:326:0x09cf, B:327:0x09f2, B:329:0x09fe, B:331:0x0a13, B:333:0x0a54, B:337:0x0a6c, B:339:0x0a73, B:341:0x0a82, B:343:0x0a86, B:345:0x0a8a, B:347:0x0a8e, B:348:0x0a9a, B:349:0x0a9f, B:351:0x0aa5, B:353:0x0ac1, B:354:0x0ac6, B:370:0x0b77, B:355:0x0adf, B:357:0x0ae7, B:361:0x0b12, B:363:0x0b3e, B:365:0x0b4d, B:366:0x0b5d, B:368:0x0b67, B:358:0x0af8, B:324:0x09ba, B:310:0x094f, B:372:0x0b82, B:374:0x0b8e, B:375:0x0b94, B:376:0x0b9c, B:378:0x0ba2, B:381:0x0bbb, B:383:0x0bcc, B:403:0x0c40, B:405:0x0c46, B:407:0x0c5e, B:410:0x0c65, B:415:0x0c94, B:417:0x0cd6, B:420:0x0d0b, B:421:0x0d0f, B:422:0x0d1a, B:424:0x0d5d, B:425:0x0d6a, B:427:0x0d79, B:431:0x0d93, B:433:0x0dac, B:419:0x0ce8, B:411:0x0c6d, B:413:0x0c79, B:414:0x0c7d, B:434:0x0dc4, B:436:0x0dd8, B:441:0x0dfb, B:440:0x0de8, B:384:0x0be4, B:386:0x0bea, B:388:0x0bf4, B:390:0x0bfb, B:396:0x0c0b, B:398:0x0c12, B:400:0x0c31, B:402:0x0c38, B:401:0x0c35, B:397:0x0c0f, B:389:0x0bf8, B:246:0x0749, B:248:0x074f, B:444:0x0e0d), top: B:458:0x0010, inners: #0, #1, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:332:0x0a52 A[PHI: r11
      0x0a52: PHI (r11v21 com.google.android.gms.measurement.internal.zzap) = (r11v20 com.google.android.gms.measurement.internal.zzap), (r11v34 com.google.android.gms.measurement.internal.zzap) binds: [B:328:0x09fc, B:330:0x0a11] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:419:0x0ce8 A[Catch: all -> 0x0e1f, TryCatch #4 {all -> 0x0e1f, blocks: (B:3:0x0010, B:5:0x0028, B:8:0x0030, B:9:0x0058, B:12:0x006a, B:15:0x0091, B:17:0x00c7, B:20:0x00d9, B:22:0x00e3, B:214:0x069d, B:24:0x010b, B:26:0x0119, B:29:0x0139, B:31:0x013f, B:33:0x0151, B:35:0x015f, B:37:0x016f, B:38:0x017c, B:39:0x0181, B:42:0x019a, B:113:0x03c7, B:114:0x03d3, B:117:0x03dd, B:123:0x0400, B:120:0x03ef, B:145:0x047f, B:147:0x048b, B:150:0x049e, B:152:0x04af, B:154:0x04bb, B:203:0x062f, B:205:0x0639, B:207:0x063f, B:208:0x0657, B:210:0x066a, B:211:0x0682, B:213:0x068b, B:160:0x04ea, B:162:0x04f9, B:165:0x050e, B:167:0x0520, B:169:0x052c, B:175:0x054e, B:177:0x0564, B:179:0x0570, B:182:0x0583, B:184:0x0596, B:186:0x05df, B:188:0x05e6, B:190:0x05ec, B:192:0x05f6, B:194:0x05fd, B:196:0x0603, B:198:0x060f, B:199:0x0621, B:127:0x0408, B:129:0x0414, B:131:0x0420, B:143:0x0465, B:135:0x043d, B:138:0x044f, B:140:0x0455, B:142:0x045f, B:68:0x01fa, B:71:0x0204, B:73:0x0212, B:78:0x025d, B:74:0x0230, B:76:0x0241, B:82:0x026e, B:85:0x029d, B:86:0x02c7, B:88:0x02fe, B:90:0x0304, B:93:0x0310, B:95:0x0346, B:96:0x0361, B:98:0x0367, B:100:0x0375, B:104:0x0388, B:101:0x037d, B:107:0x038f, B:110:0x0396, B:111:0x03ae, B:219:0x06b8, B:221:0x06c6, B:223:0x06d1, B:234:0x0705, B:224:0x06d9, B:226:0x06e4, B:228:0x06ea, B:231:0x06f6, B:233:0x0700, B:236:0x070a, B:237:0x0716, B:240:0x071e, B:242:0x0730, B:243:0x073c, B:245:0x0744, B:249:0x0769, B:251:0x078e, B:253:0x079f, B:255:0x07a5, B:257:0x07b1, B:258:0x07e2, B:260:0x07e8, B:262:0x07f6, B:263:0x07fa, B:264:0x07fd, B:265:0x0800, B:266:0x080e, B:268:0x0814, B:270:0x0824, B:271:0x082b, B:273:0x0837, B:274:0x083e, B:275:0x0841, B:277:0x087f, B:278:0x0892, B:280:0x0898, B:283:0x08b0, B:285:0x08cb, B:287:0x08e2, B:289:0x08e7, B:291:0x08eb, B:293:0x08ef, B:295:0x08f9, B:296:0x0903, B:298:0x0907, B:300:0x090d, B:301:0x091d, B:302:0x0926, B:371:0x0b7a, B:304:0x0931, B:306:0x0948, B:312:0x0964, B:314:0x0986, B:315:0x098e, B:317:0x0994, B:319:0x09a6, B:326:0x09cf, B:327:0x09f2, B:329:0x09fe, B:331:0x0a13, B:333:0x0a54, B:337:0x0a6c, B:339:0x0a73, B:341:0x0a82, B:343:0x0a86, B:345:0x0a8a, B:347:0x0a8e, B:348:0x0a9a, B:349:0x0a9f, B:351:0x0aa5, B:353:0x0ac1, B:354:0x0ac6, B:370:0x0b77, B:355:0x0adf, B:357:0x0ae7, B:361:0x0b12, B:363:0x0b3e, B:365:0x0b4d, B:366:0x0b5d, B:368:0x0b67, B:358:0x0af8, B:324:0x09ba, B:310:0x094f, B:372:0x0b82, B:374:0x0b8e, B:375:0x0b94, B:376:0x0b9c, B:378:0x0ba2, B:381:0x0bbb, B:383:0x0bcc, B:403:0x0c40, B:405:0x0c46, B:407:0x0c5e, B:410:0x0c65, B:415:0x0c94, B:417:0x0cd6, B:420:0x0d0b, B:421:0x0d0f, B:422:0x0d1a, B:424:0x0d5d, B:425:0x0d6a, B:427:0x0d79, B:431:0x0d93, B:433:0x0dac, B:419:0x0ce8, B:411:0x0c6d, B:413:0x0c79, B:414:0x0c7d, B:434:0x0dc4, B:436:0x0dd8, B:441:0x0dfb, B:440:0x0de8, B:384:0x0be4, B:386:0x0bea, B:388:0x0bf4, B:390:0x0bfb, B:396:0x0c0b, B:398:0x0c12, B:400:0x0c31, B:402:0x0c38, B:401:0x0c35, B:397:0x0c0f, B:389:0x0bf8, B:246:0x0749, B:248:0x074f, B:444:0x0e0d), top: B:458:0x0010, inners: #0, #1, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01df  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean zzah(String str, long j) {
        String str2;
        long j2;
        long jLongValue;
        zzkr zzkrVar;
        long j3;
        int iZzc;
        long j4;
        SecureRandom secureRandom;
        com.google.android.gms.internal.measurement.zzfx zzfxVar;
        zzkr zzkrVar2;
        zzap zzapVar;
        Long l;
        long jZzr;
        String str3;
        String str4;
        boolean z;
        int i;
        String str5;
        com.google.android.gms.internal.measurement.zzfx zzfxVar2;
        int i2;
        String str6;
        String str7;
        com.google.android.gms.internal.measurement.zzfx zzfxVar3;
        int i3;
        String str8;
        com.google.android.gms.internal.measurement.zzfx zzfxVar4;
        int i4;
        int i5;
        String str9;
        String str10;
        int i6;
        com.google.android.gms.internal.measurement.zzfn zzfnVar;
        int i7;
        int i8;
        com.google.android.gms.internal.measurement.zzfn zzfnVar2;
        char c;
        String str11 = "_sn";
        String str12 = "_npa";
        String str13 = "_ai";
        zzaj zzajVar = this.zze;
        zzak(zzajVar);
        zzajVar.zzw();
        try {
            zzkr zzkrVar3 = new zzkr(this, null);
            zzaj zzajVar2 = this.zze;
            zzak(zzajVar2);
            zzajVar2.zzW(null, j, this.zzA, zzkrVar3);
            List<com.google.android.gms.internal.measurement.zzfo> list = zzkrVar3.zzc;
            if (list != null && !list.isEmpty()) {
                com.google.android.gms.internal.measurement.zzfx zzfxVarZzbv = zzkrVar3.zza.zzbv();
                zzfxVarZzbv.zzp();
                boolean zZzs = zzg().zzs(zzkrVar3.zza.zzy(), zzdy.zzT);
                com.google.android.gms.internal.measurement.zzfn zzfnVar3 = null;
                com.google.android.gms.internal.measurement.zzfn zzfnVar4 = null;
                int i9 = -1;
                int i10 = 0;
                int i11 = -1;
                long jLongValue2 = 0;
                int i12 = 0;
                int i13 = 0;
                while (true) {
                    String str14 = "_fr";
                    String str15 = "_et";
                    str2 = str12;
                    j2 = jLongValue2;
                    if (i10 >= zzkrVar3.zzc.size()) {
                        break;
                    }
                    com.google.android.gms.internal.measurement.zzfn zzfnVarZzbv = zzkrVar3.zzc.get(i10).zzbv();
                    zzfm zzfmVar = this.zzc;
                    zzak(zzfmVar);
                    int i14 = i10;
                    if (zzfmVar.zzo(zzkrVar3.zza.zzy(), zzfnVarZzbv.zzo())) {
                        zzay().zzk().zzc("Dropping blocked raw event. appId", zzel.zzn(zzkrVar3.zza.zzy()), this.zzn.zzj().zzd(zzfnVarZzbv.zzo()));
                        zzfm zzfmVar2 = this.zzc;
                        zzak(zzfmVar2);
                        if (!zzfmVar2.zzm(zzkrVar3.zza.zzy())) {
                            zzfm zzfmVar3 = this.zzc;
                            zzak(zzfmVar3);
                            if (!zzfmVar3.zzp(zzkrVar3.zza.zzy()) && !"_err".equals(zzfnVarZzbv.zzo())) {
                                zzv().zzM(this.zzC, zzkrVar3.zza.zzy(), 11, "_ev", zzfnVarZzbv.zzo(), 0);
                            }
                        }
                        str3 = str13;
                        zzfxVar4 = zzfxVarZzbv;
                        z = zZzs;
                        jLongValue2 = j2;
                        i7 = i14;
                        str10 = str11;
                    } else {
                        if (zzfnVarZzbv.zzo().equals(zzgs.zza(str13))) {
                            zzfnVarZzbv.zzi(str13);
                            zzay().zzj().zza("Renaming ad_impression to _ai");
                            if (Log.isLoggable(zzay().zzq(), 5)) {
                                int i15 = 0;
                                while (i15 < zzfnVarZzbv.zza()) {
                                    String str16 = str13;
                                    if (FirebaseAnalytics.Param.AD_PLATFORM.equals(zzfnVarZzbv.zzn(i15).zzg()) && !TextUtils.isEmpty(zzfnVarZzbv.zzn(i15).zzh()) && "admob".equalsIgnoreCase(zzfnVarZzbv.zzn(i15).zzh())) {
                                        zzay().zzl().zza("AdMob ad impression logged from app. Potentially duplicative.");
                                    }
                                    i15++;
                                    str13 = str16;
                                }
                            }
                        }
                        str3 = str13;
                        zzfm zzfmVar4 = this.zzc;
                        zzak(zzfmVar4);
                        boolean zZzn = zzfmVar4.zzn(zzkrVar3.zza.zzy(), zzfnVarZzbv.zzo());
                        if (zZzn) {
                            str4 = str11;
                            z = zZzs;
                        } else {
                            zzak(this.zzi);
                            String strZzo = zzfnVarZzbv.zzo();
                            Preconditions.checkNotEmpty(strZzo);
                            z = zZzs;
                            int iHashCode = strZzo.hashCode();
                            str4 = str11;
                            if (iHashCode == 94660) {
                                if (strZzo.equals("_in")) {
                                    c = 0;
                                }
                                if (c != 0) {
                                }
                            } else if (iHashCode != 95025) {
                                c = (iHashCode == 95027 && strZzo.equals("_ui")) ? (char) 1 : (char) 65535;
                                if (c != 0 && c != 1 && c != 2) {
                                    i2 = i9;
                                    str6 = "_fr";
                                    str5 = "_et";
                                    i = i11;
                                    zZzn = false;
                                    str7 = "_e";
                                    zzfxVar2 = zzfxVarZzbv;
                                }
                                if (!zZzn) {
                                    ArrayList arrayList = new ArrayList(zzfnVarZzbv.zzp());
                                    int i16 = -1;
                                    int i17 = -1;
                                    for (int i18 = 0; i18 < arrayList.size(); i18++) {
                                        if ("value".equals(((com.google.android.gms.internal.measurement.zzfs) arrayList.get(i18)).zzg())) {
                                            i16 = i18;
                                        } else if (FirebaseAnalytics.Param.CURRENCY.equals(((com.google.android.gms.internal.measurement.zzfs) arrayList.get(i18)).zzg())) {
                                            i17 = i18;
                                        }
                                    }
                                    if (i16 != -1) {
                                        if (((com.google.android.gms.internal.measurement.zzfs) arrayList.get(i16)).zzw() || ((com.google.android.gms.internal.measurement.zzfs) arrayList.get(i16)).zzu()) {
                                            if (i17 != -1) {
                                                String strZzh = ((com.google.android.gms.internal.measurement.zzfs) arrayList.get(i17)).zzh();
                                                if (strZzh.length() == 3) {
                                                    int iCharCount = 0;
                                                    while (iCharCount < strZzh.length()) {
                                                        int iCodePointAt = strZzh.codePointAt(iCharCount);
                                                        if (Character.isLetter(iCodePointAt)) {
                                                            iCharCount += Character.charCount(iCodePointAt);
                                                        }
                                                    }
                                                }
                                            }
                                            zzay().zzl().zza("Value parameter discarded. You must also supply a 3-letter ISO_4217 currency code in the currency parameter.");
                                            zzfnVarZzbv.zzh(i16);
                                            zzZ(zzfnVarZzbv, "_c");
                                            zzY(zzfnVarZzbv, 19, FirebaseAnalytics.Param.CURRENCY);
                                            break;
                                        }
                                        zzay().zzl().zza("Value must be specified with a numeric type.");
                                        zzfnVarZzbv.zzh(i16);
                                        zzZ(zzfnVarZzbv, "_c");
                                        zzY(zzfnVarZzbv, 18, "value");
                                    }
                                    if (str7.equals(zzfnVarZzbv.zzo())) {
                                        zzfxVar4 = zzfxVar2;
                                        i4 = i2;
                                        if ("_vs".equals(zzfnVarZzbv.zzo())) {
                                            zzak(this.zzi);
                                            str9 = str5;
                                            if (zzku.zzC(zzfnVarZzbv.zzaA(), str9) == null) {
                                                if (zzfnVar3 == null || Math.abs(zzfnVar3.zzc() - zzfnVarZzbv.zzc()) > 1000) {
                                                    i11 = i;
                                                    zzfnVar4 = zzfnVarZzbv;
                                                    i9 = i12;
                                                } else {
                                                    com.google.android.gms.internal.measurement.zzfn zzfnVarZzax = zzfnVar3.clone();
                                                    if (zzaj(zzfnVarZzax, zzfnVarZzbv)) {
                                                        i6 = i;
                                                        zzfxVar4.zzO(i6, zzfnVarZzax);
                                                        i9 = i4;
                                                        zzfnVar = null;
                                                        zzfnVar3 = null;
                                                    } else {
                                                        i6 = i;
                                                        zzfnVar = zzfnVarZzbv;
                                                        i9 = i12;
                                                    }
                                                    zzfnVar4 = zzfnVar;
                                                    i11 = i6;
                                                }
                                                str10 = str4;
                                            } else {
                                                i5 = i;
                                                str10 = str4;
                                                i11 = i5;
                                                i9 = i4;
                                            }
                                        } else {
                                            i5 = i;
                                            str9 = str5;
                                            if (zzg().zzs(zzkrVar3.zza.zzy(), zzdy.zzaf) && "_ab".equals(zzfnVarZzbv.zzo())) {
                                                zzak(this.zzi);
                                                if (zzku.zzC(zzfnVarZzbv.zzaA(), str9) == null && zzfnVar3 != null && Math.abs(zzfnVar3.zzc() - zzfnVarZzbv.zzc()) <= 4000) {
                                                    com.google.android.gms.internal.measurement.zzfn zzfnVarZzax2 = zzfnVar3.clone();
                                                    zzae(zzfnVarZzax2, zzfnVarZzbv);
                                                    Preconditions.checkArgument(str7.equals(zzfnVarZzax2.zzo()));
                                                    zzak(this.zzi);
                                                    str10 = str4;
                                                    com.google.android.gms.internal.measurement.zzfs zzfsVarZzC = zzku.zzC(zzfnVarZzax2.zzaA(), str10);
                                                    zzak(this.zzi);
                                                    com.google.android.gms.internal.measurement.zzfs zzfsVarZzC2 = zzku.zzC(zzfnVarZzax2.zzaA(), "_sc");
                                                    zzak(this.zzi);
                                                    com.google.android.gms.internal.measurement.zzfs zzfsVarZzC3 = zzku.zzC(zzfnVarZzax2.zzaA(), "_si");
                                                    String strZzh2 = zzfsVarZzC != null ? zzfsVarZzC.zzh() : "";
                                                    if (!TextUtils.isEmpty(strZzh2)) {
                                                        zzak(this.zzi);
                                                        zzku.zzA(zzfnVarZzbv, str10, strZzh2);
                                                    }
                                                    String strZzh3 = zzfsVarZzC2 != null ? zzfsVarZzC2.zzh() : "";
                                                    if (!TextUtils.isEmpty(strZzh3)) {
                                                        zzak(this.zzi);
                                                        zzku.zzA(zzfnVarZzbv, "_sc", strZzh3);
                                                    }
                                                    if (zzfsVarZzC3 != null) {
                                                        zzak(this.zzi);
                                                        zzku.zzA(zzfnVarZzbv, "_si", Long.valueOf(zzfsVarZzC3.zzd()));
                                                    }
                                                    zzfxVar4.zzO(i5, zzfnVarZzax2);
                                                    i11 = i5;
                                                    i9 = i4;
                                                    zzfnVar3 = null;
                                                }
                                            }
                                            str10 = str4;
                                            i11 = i5;
                                            i9 = i4;
                                        }
                                        if (z) {
                                        }
                                    } else {
                                        zzak(this.zzi);
                                        if (zzku.zzC(zzfnVarZzbv.zzaA(), str6) == null) {
                                            if (zzfnVar4 == null || Math.abs(zzfnVar4.zzc() - zzfnVarZzbv.zzc()) > 1000) {
                                                zzfxVar4 = zzfxVar2;
                                                zzfnVar3 = zzfnVarZzbv;
                                                i9 = i2;
                                                i11 = i12;
                                            } else {
                                                com.google.android.gms.internal.measurement.zzfn zzfnVarZzax3 = zzfnVar4.clone();
                                                if (zzaj(zzfnVarZzbv, zzfnVarZzax3)) {
                                                    zzfxVar4 = zzfxVar2;
                                                    i8 = i2;
                                                    zzfxVar4.zzO(i8, zzfnVarZzax3);
                                                    i11 = i;
                                                    zzfnVar2 = null;
                                                    zzfnVar4 = null;
                                                } else {
                                                    zzfxVar4 = zzfxVar2;
                                                    i8 = i2;
                                                    zzfnVar2 = zzfnVarZzbv;
                                                    i11 = i12;
                                                }
                                                zzfnVar3 = zzfnVar2;
                                                i9 = i8;
                                            }
                                            str10 = str4;
                                            str9 = str5;
                                            if (z || !str7.equals(zzfnVarZzbv.zzo())) {
                                                jLongValue2 = j2;
                                                i7 = i14;
                                                zzkrVar3.zzc.set(i7, zzfnVarZzbv.zzaA());
                                                i12++;
                                                zzfxVar4.zzj(zzfnVarZzbv);
                                            } else {
                                                if (zzfnVarZzbv.zza() == 0) {
                                                    zzay().zzk().zzb("Engagement event does not contain any parameters. appId", zzel.zzn(zzkrVar3.zza.zzy()));
                                                } else {
                                                    zzak(this.zzi);
                                                    Long l2 = (Long) zzku.zzD(zzfnVarZzbv.zzaA(), str9);
                                                    if (l2 == null) {
                                                        zzay().zzk().zzb("Engagement event does not include duration. appId", zzel.zzn(zzkrVar3.zza.zzy()));
                                                    } else {
                                                        jLongValue2 = j2 + l2.longValue();
                                                        i7 = i14;
                                                        zzkrVar3.zzc.set(i7, zzfnVarZzbv.zzaA());
                                                        i12++;
                                                        zzfxVar4.zzj(zzfnVarZzbv);
                                                    }
                                                }
                                                jLongValue2 = j2;
                                                i7 = i14;
                                                zzkrVar3.zzc.set(i7, zzfnVarZzbv.zzaA());
                                                i12++;
                                                zzfxVar4.zzj(zzfnVarZzbv);
                                            }
                                        } else {
                                            zzfxVar4 = zzfxVar2;
                                            i4 = i2;
                                            i5 = i;
                                            str10 = str4;
                                            str9 = str5;
                                            i11 = i5;
                                            i9 = i4;
                                            if (z) {
                                                jLongValue2 = j2;
                                                i7 = i14;
                                                zzkrVar3.zzc.set(i7, zzfnVarZzbv.zzaA());
                                                i12++;
                                                zzfxVar4.zzj(zzfnVarZzbv);
                                            }
                                        }
                                    }
                                } else if (str7.equals(zzfnVarZzbv.zzo())) {
                                }
                            } else {
                                if (strZzo.equals("_ug")) {
                                    c = 2;
                                }
                                if (c != 0) {
                                }
                            }
                        }
                        i = i11;
                        int i19 = 0;
                        boolean z2 = false;
                        boolean z3 = false;
                        while (true) {
                            str5 = str15;
                            if (i19 >= zzfnVarZzbv.zza()) {
                                break;
                            }
                            if ("_c".equals(zzfnVarZzbv.zzn(i19).zzg())) {
                                com.google.android.gms.internal.measurement.zzfr zzfrVarZzbv = zzfnVarZzbv.zzn(i19).zzbv();
                                zzfxVar3 = zzfxVarZzbv;
                                i3 = i9;
                                zzfrVarZzbv.zzi(1L);
                                zzfnVarZzbv.zzk(i19, zzfrVarZzbv.zzaA());
                                str8 = str14;
                                z2 = true;
                            } else {
                                zzfxVar3 = zzfxVarZzbv;
                                i3 = i9;
                                if ("_r".equals(zzfnVarZzbv.zzn(i19).zzg())) {
                                    com.google.android.gms.internal.measurement.zzfr zzfrVarZzbv2 = zzfnVarZzbv.zzn(i19).zzbv();
                                    str8 = str14;
                                    zzfrVarZzbv2.zzi(1L);
                                    zzfnVarZzbv.zzk(i19, zzfrVarZzbv2.zzaA());
                                    z3 = true;
                                } else {
                                    str8 = str14;
                                }
                            }
                            i19++;
                            str14 = str8;
                            zzfxVarZzbv = zzfxVar3;
                            str15 = str5;
                            i9 = i3;
                        }
                        zzfxVar2 = zzfxVarZzbv;
                        i2 = i9;
                        String str17 = str14;
                        if (z2 || !zZzn) {
                            str6 = str17;
                        } else {
                            zzay().zzj().zzb("Marking event as conversion", this.zzn.zzj().zzd(zzfnVarZzbv.zzo()));
                            com.google.android.gms.internal.measurement.zzfr zzfrVarZze = com.google.android.gms.internal.measurement.zzfs.zze();
                            zzfrVarZze.zzj("_c");
                            str6 = str17;
                            zzfrVarZze.zzi(1L);
                            zzfnVarZzbv.zze(zzfrVarZze);
                        }
                        if (!z3) {
                            zzay().zzj().zzb("Marking event as real-time", this.zzn.zzj().zzd(zzfnVarZzbv.zzo()));
                            com.google.android.gms.internal.measurement.zzfr zzfrVarZze2 = com.google.android.gms.internal.measurement.zzfs.zze();
                            zzfrVarZze2.zzj("_r");
                            zzfrVarZze2.zzi(1L);
                            zzfnVarZzbv.zze(zzfrVarZze2);
                        }
                        zzaj zzajVar3 = this.zze;
                        zzak(zzajVar3);
                        str7 = "_e";
                        if (zzajVar3.zzl(zza(), zzkrVar3.zza.zzy(), false, false, false, false, true).zze > zzg().zze(zzkrVar3.zza.zzy(), zzdy.zzn)) {
                            zzZ(zzfnVarZzbv, "_r");
                        } else {
                            i13 = 1;
                        }
                        if (zzkz.zzah(zzfnVarZzbv.zzo()) && zZzn) {
                            zzaj zzajVar4 = this.zze;
                            zzak(zzajVar4);
                            if (zzajVar4.zzl(zza(), zzkrVar3.zza.zzy(), false, false, true, false, false).zzc > zzg().zze(zzkrVar3.zza.zzy(), zzdy.zzm)) {
                                zzay().zzk().zzb("Too many conversions. Not logging as conversion. appId", zzel.zzn(zzkrVar3.zza.zzy()));
                                com.google.android.gms.internal.measurement.zzfr zzfrVarZzbv3 = null;
                                boolean z4 = false;
                                int i20 = -1;
                                for (int i21 = 0; i21 < zzfnVarZzbv.zza(); i21++) {
                                    com.google.android.gms.internal.measurement.zzfs zzfsVarZzn = zzfnVarZzbv.zzn(i21);
                                    if ("_c".equals(zzfsVarZzn.zzg())) {
                                        zzfrVarZzbv3 = zzfsVarZzn.zzbv();
                                        i20 = i21;
                                    } else if ("_err".equals(zzfsVarZzn.zzg())) {
                                        z4 = true;
                                    }
                                }
                                if (z4) {
                                    if (zzfrVarZzbv3 != null) {
                                        zzfnVarZzbv.zzh(i20);
                                    } else {
                                        zzfrVarZzbv3 = null;
                                        if (zzfrVarZzbv3 == null) {
                                        }
                                    }
                                } else if (zzfrVarZzbv3 == null) {
                                    com.google.android.gms.internal.measurement.zzfr zzfrVarZzax = zzfrVarZzbv3.clone();
                                    zzfrVarZzax.zzj("_err");
                                    zzfrVarZzax.zzi(10L);
                                    zzfnVarZzbv.zzk(i20, zzfrVarZzax.zzaA());
                                } else {
                                    zzay().zzd().zzb("Did not find conversion parameter. appId", zzel.zzn(zzkrVar3.zza.zzy()));
                                }
                            }
                        }
                        if (!zZzn) {
                        }
                    }
                    i10 = i7 + 1;
                    zzfxVarZzbv = zzfxVar4;
                    str11 = str10;
                    str12 = str2;
                    zZzs = z;
                    str13 = str3;
                }
                com.google.android.gms.internal.measurement.zzfx zzfxVar5 = zzfxVarZzbv;
                if (zZzs) {
                    int i22 = i12;
                    jLongValue = j2;
                    int i23 = 0;
                    while (i23 < i22) {
                        com.google.android.gms.internal.measurement.zzfo zzfoVarZze = zzfxVar5.zze(i23);
                        if ("_e".equals(zzfoVarZze.zzh())) {
                            zzak(this.zzi);
                            if (zzku.zzC(zzfoVarZze, "_fr") != null) {
                                zzfxVar5.zzw(i23);
                                i22--;
                                i23--;
                            } else {
                                zzak(this.zzi);
                                com.google.android.gms.internal.measurement.zzfs zzfsVarZzC4 = zzku.zzC(zzfoVarZze, "_et");
                                if (zzfsVarZzC4 != null) {
                                    Long lValueOf = zzfsVarZzC4.zzw() ? Long.valueOf(zzfsVarZzC4.zzd()) : null;
                                    if (lValueOf != null && lValueOf.longValue() > 0) {
                                        jLongValue += lValueOf.longValue();
                                    }
                                }
                            }
                        }
                        i23++;
                    }
                } else {
                    jLongValue = j2;
                }
                zzad(zzfxVar5, jLongValue, false);
                Iterator<com.google.android.gms.internal.measurement.zzfo> it = zzfxVar5.zzao().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if ("_s".equals(it.next().zzh())) {
                        zzaj zzajVar5 = this.zze;
                        zzak(zzajVar5);
                        zzajVar5.zzB(zzfxVar5.zzal(), "_se");
                        break;
                    }
                }
                if (zzku.zza(zzfxVar5, "_sid") >= 0) {
                    zzad(zzfxVar5, jLongValue, true);
                } else {
                    int iZza = zzku.zza(zzfxVar5, "_se");
                    if (iZza >= 0) {
                        zzfxVar5.zzx(iZza);
                        zzay().zzd().zzb("Session engagement user property is in the bundle without session ID. appId", zzel.zzn(zzkrVar3.zza.zzy()));
                    }
                }
                zzku zzkuVar = this.zzi;
                zzak(zzkuVar);
                zzkuVar.zzs.zzay().zzj().zza("Checking account type status for ad personalization signals");
                zzfm zzfmVar5 = zzkuVar.zzf.zzc;
                zzak(zzfmVar5);
                if (zzfmVar5.zzk(zzfxVar5.zzal())) {
                    zzaj zzajVar6 = zzkuVar.zzf.zze;
                    zzak(zzajVar6);
                    zzg zzgVarZzj = zzajVar6.zzj(zzfxVar5.zzal());
                    if (zzgVarZzj != null && zzgVarZzj.zzai() && zzkuVar.zzs.zzg().zze()) {
                        zzkuVar.zzs.zzay().zzc().zza("Turning off ad personalization due to account type");
                        com.google.android.gms.internal.measurement.zzgg zzggVarZzd = com.google.android.gms.internal.measurement.zzgh.zzd();
                        zzggVarZzd.zzf(str2);
                        zzggVarZzd.zzg(zzkuVar.zzs.zzg().zza());
                        zzggVarZzd.zze(1L);
                        com.google.android.gms.internal.measurement.zzgh zzghVarZzaA = zzggVarZzd.zzaA();
                        int i24 = 0;
                        while (true) {
                            if (i24 >= zzfxVar5.zzb()) {
                                zzfxVar5.zzl(zzghVarZzaA);
                                break;
                            }
                            if (str2.equals(zzfxVar5.zzak(i24).zzf())) {
                                zzfxVar5.zzai(i24, zzghVarZzaA);
                                break;
                            }
                            i24++;
                        }
                    }
                }
                zzfxVar5.zzae(Long.MAX_VALUE);
                zzfxVar5.zzN(Long.MIN_VALUE);
                for (int i25 = 0; i25 < zzfxVar5.zza(); i25++) {
                    com.google.android.gms.internal.measurement.zzfo zzfoVarZze2 = zzfxVar5.zze(i25);
                    if (zzfoVarZze2.zzd() < zzfxVar5.zzd()) {
                        zzfxVar5.zzae(zzfoVarZze2.zzd());
                    }
                    if (zzfoVarZze2.zzd() > zzfxVar5.zzc()) {
                        zzfxVar5.zzN(zzfoVarZze2.zzd());
                    }
                }
                zzfxVar5.zzv();
                zzfxVar5.zzn();
                zzz zzzVar = this.zzh;
                zzak(zzzVar);
                zzfxVar5.zzf(zzzVar.zza(zzfxVar5.zzal(), zzfxVar5.zzao(), zzfxVar5.zzap(), Long.valueOf(zzfxVar5.zzd()), Long.valueOf(zzfxVar5.zzc())));
                if (zzg().zzw(zzkrVar3.zza.zzy())) {
                    HashMap map = new HashMap();
                    ArrayList arrayList2 = new ArrayList();
                    SecureRandom secureRandomZzF = zzv().zzF();
                    int i26 = 0;
                    while (i26 < zzfxVar5.zza()) {
                        com.google.android.gms.internal.measurement.zzfn zzfnVarZzbv2 = zzfxVar5.zze(i26).zzbv();
                        if (zzfnVarZzbv2.zzo().equals("_ep")) {
                            zzak(this.zzi);
                            String str18 = (String) zzku.zzD(zzfnVarZzbv2.zzaA(), "_en");
                            zzap zzapVarZzn = (zzap) map.get(str18);
                            if (zzapVarZzn == null) {
                                zzaj zzajVar7 = this.zze;
                                zzak(zzajVar7);
                                zzapVarZzn = zzajVar7.zzn(zzkrVar3.zza.zzy(), (String) Preconditions.checkNotNull(str18));
                                if (zzapVarZzn != null) {
                                    map.put(str18, zzapVarZzn);
                                }
                            }
                            if (zzapVarZzn != null && zzapVarZzn.zzi == null) {
                                Long l3 = zzapVarZzn.zzj;
                                if (l3 != null && l3.longValue() > 1) {
                                    zzak(this.zzi);
                                    zzku.zzA(zzfnVarZzbv2, "_sr", zzapVarZzn.zzj);
                                }
                                Boolean bool = zzapVarZzn.zzk;
                                if (bool != null && bool.booleanValue()) {
                                    zzak(this.zzi);
                                    zzku.zzA(zzfnVarZzbv2, "_efs", 1L);
                                }
                                arrayList2.add(zzfnVarZzbv2.zzaA());
                            }
                            zzfxVar5.zzO(i26, zzfnVarZzbv2);
                        } else {
                            zzfm zzfmVar6 = this.zzc;
                            zzak(zzfmVar6);
                            String strZzy = zzkrVar3.zza.zzy();
                            String strZza = zzfmVar6.zza(strZzy, "measurement.account.time_zone_offset_minutes");
                            if (TextUtils.isEmpty(strZza)) {
                                j3 = 0;
                                long jZzr2 = zzv().zzr(zzfnVarZzbv2.zzc(), j3);
                                com.google.android.gms.internal.measurement.zzfo zzfoVarZzaA = zzfnVarZzbv2.zzaA();
                                long j5 = j3;
                                Long l4 = 1L;
                                if (TextUtils.isEmpty("_dbg")) {
                                }
                            } else {
                                try {
                                    j3 = Long.parseLong(strZza);
                                } catch (NumberFormatException e) {
                                    zzfmVar6.zzs.zzay().zzk().zzc("Unable to parse timezone offset. appId", zzel.zzn(strZzy), e);
                                }
                                long jZzr22 = zzv().zzr(zzfnVarZzbv2.zzc(), j3);
                                com.google.android.gms.internal.measurement.zzfo zzfoVarZzaA2 = zzfnVarZzbv2.zzaA();
                                long j52 = j3;
                                Long l42 = 1L;
                                if (TextUtils.isEmpty("_dbg")) {
                                    Iterator<com.google.android.gms.internal.measurement.zzfs> it2 = zzfoVarZzaA2.zzi().iterator();
                                    while (true) {
                                        if (!it2.hasNext()) {
                                            break;
                                        }
                                        com.google.android.gms.internal.measurement.zzfs next = it2.next();
                                        Iterator<com.google.android.gms.internal.measurement.zzfs> it3 = it2;
                                        if (!"_dbg".equals(next.zzg())) {
                                            it2 = it3;
                                        } else if (l42.equals(Long.valueOf(next.zzd()))) {
                                            iZzc = 1;
                                        }
                                    }
                                    zzfm zzfmVar7 = this.zzc;
                                    zzak(zzfmVar7);
                                    iZzc = zzfmVar7.zzc(zzkrVar3.zza.zzy(), zzfnVarZzbv2.zzo());
                                    if (iZzc > 0) {
                                        zzay().zzk().zzc("Sample rate must be positive. event, rate", zzfnVarZzbv2.zzo(), Integer.valueOf(iZzc));
                                        arrayList2.add(zzfnVarZzbv2.zzaA());
                                        zzfxVar5.zzO(i26, zzfnVarZzbv2);
                                    } else {
                                        zzap zzapVarZza = (zzap) map.get(zzfnVarZzbv2.zzo());
                                        if (zzapVarZza == null) {
                                            zzaj zzajVar8 = this.zze;
                                            zzak(zzajVar8);
                                            zzapVarZza = zzajVar8.zzn(zzkrVar3.zza.zzy(), zzfnVarZzbv2.zzo());
                                            if (zzapVarZza == null) {
                                                j4 = jZzr22;
                                                zzay().zzk().zzc("Event being bundled has no eventAggregate. appId, eventName", zzkrVar3.zza.zzy(), zzfnVarZzbv2.zzo());
                                                zzapVarZza = new zzap(zzkrVar3.zza.zzy(), zzfnVarZzbv2.zzo(), 1L, 1L, 1L, zzfnVarZzbv2.zzc(), 0L, null, null, null, null);
                                            } else {
                                                j4 = jZzr22;
                                            }
                                            zzak(this.zzi);
                                            Long l5 = (Long) zzku.zzD(zzfnVarZzbv2.zzaA(), "_eid");
                                            Boolean boolValueOf = Boolean.valueOf(l5 != null);
                                            if (iZzc == 1) {
                                                arrayList2.add(zzfnVarZzbv2.zzaA());
                                                if (boolValueOf.booleanValue() && (zzapVarZza.zzi != null || zzapVarZza.zzj != null || zzapVarZza.zzk != null)) {
                                                    map.put(zzfnVarZzbv2.zzo(), zzapVarZza.zza(null, null, null));
                                                }
                                                zzfxVar5.zzO(i26, zzfnVarZzbv2);
                                            } else {
                                                if (secureRandomZzF.nextInt(iZzc) == 0) {
                                                    zzak(this.zzi);
                                                    Long lValueOf2 = Long.valueOf(iZzc);
                                                    zzku.zzA(zzfnVarZzbv2, "_sr", lValueOf2);
                                                    arrayList2.add(zzfnVarZzbv2.zzaA());
                                                    if (boolValueOf.booleanValue()) {
                                                        zzapVarZza = zzapVarZza.zza(null, lValueOf2, null);
                                                    }
                                                    map.put(zzfnVarZzbv2.zzo(), zzapVarZza.zzb(zzfnVarZzbv2.zzc(), j4));
                                                    zzkrVar2 = zzkrVar3;
                                                    secureRandom = secureRandomZzF;
                                                } else {
                                                    secureRandom = secureRandomZzF;
                                                    long j6 = j4;
                                                    Long l6 = zzapVarZza.zzh;
                                                    if (l6 != null) {
                                                        zzfxVar = zzfxVar5;
                                                        zzapVar = zzapVarZza;
                                                        l = l5;
                                                        zzkrVar2 = zzkrVar3;
                                                        jZzr = l6.longValue();
                                                    } else {
                                                        zzfxVar = zzfxVar5;
                                                        zzkrVar2 = zzkrVar3;
                                                        zzapVar = zzapVarZza;
                                                        l = l5;
                                                        jZzr = zzv().zzr(zzfnVarZzbv2.zzb(), j52);
                                                    }
                                                    if (jZzr != j6) {
                                                        zzak(this.zzi);
                                                        zzku.zzA(zzfnVarZzbv2, "_efs", 1L);
                                                        zzak(this.zzi);
                                                        Long lValueOf3 = Long.valueOf(iZzc);
                                                        zzku.zzA(zzfnVarZzbv2, "_sr", lValueOf3);
                                                        arrayList2.add(zzfnVarZzbv2.zzaA());
                                                        map.put(zzfnVarZzbv2.zzo(), (boolValueOf.booleanValue() ? zzapVar.zza(null, lValueOf3, true) : zzapVar).zzb(zzfnVarZzbv2.zzc(), j6));
                                                    } else {
                                                        zzap zzapVar2 = zzapVar;
                                                        if (boolValueOf.booleanValue()) {
                                                            map.put(zzfnVarZzbv2.zzo(), zzapVar2.zza(l, null, null));
                                                        }
                                                    }
                                                    zzfxVar5 = zzfxVar;
                                                }
                                                zzfxVar5.zzO(i26, zzfnVarZzbv2);
                                            }
                                        }
                                    }
                                } else {
                                    zzfm zzfmVar72 = this.zzc;
                                    zzak(zzfmVar72);
                                    iZzc = zzfmVar72.zzc(zzkrVar3.zza.zzy(), zzfnVarZzbv2.zzo());
                                    if (iZzc > 0) {
                                    }
                                }
                            }
                            i26++;
                            secureRandomZzF = secureRandom;
                            zzkrVar3 = zzkrVar2;
                        }
                        zzkrVar2 = zzkrVar3;
                        secureRandom = secureRandomZzF;
                        i26++;
                        secureRandomZzF = secureRandom;
                        zzkrVar3 = zzkrVar2;
                    }
                    zzkr zzkrVar4 = zzkrVar3;
                    if (arrayList2.size() < zzfxVar5.zza()) {
                        zzfxVar5.zzp();
                        zzfxVar5.zzg(arrayList2);
                    }
                    for (Map.Entry entry : map.entrySet()) {
                        zzaj zzajVar9 = this.zze;
                        zzak(zzajVar9);
                        zzajVar9.zzF((zzap) entry.getValue());
                    }
                    zzkrVar = zzkrVar4;
                } else {
                    zzkrVar = zzkrVar3;
                }
                String strZzy2 = zzkrVar.zza.zzy();
                zzaj zzajVar10 = this.zze;
                zzak(zzajVar10);
                zzg zzgVarZzj2 = zzajVar10.zzj(strZzy2);
                if (zzgVarZzj2 == null) {
                    zzay().zzd().zzb("Bundling raw events w/o app info. appId", zzel.zzn(zzkrVar.zza.zzy()));
                } else if (zzfxVar5.zza() > 0) {
                    long jZzn = zzgVarZzj2.zzn();
                    if (jZzn != 0) {
                        zzfxVar5.zzY(jZzn);
                    } else {
                        zzfxVar5.zzs();
                    }
                    long jZzp = zzgVarZzj2.zzp();
                    if (jZzp != 0) {
                        jZzn = jZzp;
                    }
                    if (jZzn != 0) {
                        zzfxVar5.zzZ(jZzn);
                    } else {
                        zzfxVar5.zzt();
                    }
                    zzgVarZzj2.zzE();
                    zzfxVar5.zzF((int) zzgVarZzj2.zzo());
                    zzgVarZzj2.zzad(zzfxVar5.zzd());
                    zzgVarZzj2.zzab(zzfxVar5.zzc());
                    String strZzs = zzgVarZzj2.zzs();
                    if (strZzs != null) {
                        zzfxVar5.zzT(strZzs);
                    } else {
                        zzfxVar5.zzq();
                    }
                    zzaj zzajVar11 = this.zze;
                    zzak(zzajVar11);
                    zzajVar11.zzE(zzgVarZzj2);
                }
                if (zzfxVar5.zza() > 0) {
                    this.zzn.zzaw();
                    zzfm zzfmVar8 = this.zzc;
                    zzak(zzfmVar8);
                    com.google.android.gms.internal.measurement.zzfc zzfcVarZze = zzfmVar8.zze(zzkrVar.zza.zzy());
                    if (zzfcVarZze != null && zzfcVarZze.zzq()) {
                        zzfxVar5.zzH(zzfcVarZze.zzc());
                    } else if (TextUtils.isEmpty(zzkrVar.zza.zzH())) {
                        zzfxVar5.zzH(-1L);
                    } else {
                        zzay().zzk().zzb("Did not find measurement config or missing version info. appId", zzel.zzn(zzkrVar.zza.zzy()));
                    }
                    zzaj zzajVar12 = this.zze;
                    zzak(zzajVar12);
                    com.google.android.gms.internal.measurement.zzfy zzfyVar = (com.google.android.gms.internal.measurement.zzfy) zzfxVar5.zzaA();
                    zzajVar12.zzg();
                    zzajVar12.zzY();
                    Preconditions.checkNotNull(zzfyVar);
                    Preconditions.checkNotEmpty(zzfyVar.zzy());
                    Preconditions.checkState(zzfyVar.zzbc());
                    zzajVar12.zzA();
                    long jCurrentTimeMillis = zzajVar12.zzs.zzav().currentTimeMillis();
                    long jZzm = zzfyVar.zzm();
                    zzajVar12.zzs.zzf();
                    if (jZzm >= jCurrentTimeMillis - zzaf.zzA()) {
                        long jZzm2 = zzfyVar.zzm();
                        zzajVar12.zzs.zzf();
                        if (jZzm2 > zzaf.zzA() + jCurrentTimeMillis) {
                            zzajVar12.zzs.zzay().zzk().zzd("Storing bundle outside of the max uploading time span. appId, now, timestamp", zzel.zzn(zzfyVar.zzy()), Long.valueOf(jCurrentTimeMillis), Long.valueOf(zzfyVar.zzm()));
                        }
                        byte[] bArrZzbs = zzfyVar.zzbs();
                        try {
                            zzku zzkuVar2 = zzajVar12.zzf.zzi;
                            zzak(zzkuVar2);
                            byte[] bArrZzz = zzkuVar2.zzz(bArrZzbs);
                            zzajVar12.zzs.zzay().zzj().zzb("Saving bundle, size", Integer.valueOf(bArrZzz.length));
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("app_id", zzfyVar.zzy());
                            contentValues.put("bundle_end_timestamp", Long.valueOf(zzfyVar.zzm()));
                            contentValues.put("data", bArrZzz);
                            contentValues.put("has_realtime", Integer.valueOf(i13));
                            if (zzfyVar.zzbi()) {
                                contentValues.put("retry_count", Integer.valueOf(zzfyVar.zze()));
                            }
                            try {
                                if (zzajVar12.zzh().insert("queue", null, contentValues) == -1) {
                                    zzajVar12.zzs.zzay().zzd().zzb("Failed to insert bundle (got -1). appId", zzel.zzn(zzfyVar.zzy()));
                                }
                            } catch (SQLiteException e2) {
                                zzajVar12.zzs.zzay().zzd().zzc("Error storing bundle. appId", zzel.zzn(zzfyVar.zzy()), e2);
                            }
                        } catch (IOException e3) {
                            zzajVar12.zzs.zzay().zzd().zzc("Data loss. Failed to serialize bundle. appId", zzel.zzn(zzfyVar.zzy()), e3);
                        }
                    }
                }
                zzaj zzajVar13 = this.zze;
                zzak(zzajVar13);
                zzajVar13.zzx(zzkrVar.zzb);
                zzaj zzajVar14 = this.zze;
                zzak(zzajVar14);
                try {
                    zzajVar14.zzh().execSQL("delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)", new String[]{strZzy2, strZzy2});
                } catch (SQLiteException e4) {
                    zzajVar14.zzs.zzay().zzd().zzc("Failed to remove unused event metadata. appId", zzel.zzn(strZzy2), e4);
                }
                zzaj zzajVar15 = this.zze;
                zzak(zzajVar15);
                zzajVar15.zzD();
                zzaj zzajVar16 = this.zze;
                zzak(zzajVar16);
                zzajVar16.zzy();
                return true;
            }
            zzaj zzajVar17 = this.zze;
            zzak(zzajVar17);
            zzajVar17.zzD();
            zzaj zzajVar18 = this.zze;
            zzak(zzajVar18);
            zzajVar18.zzy();
            return false;
        } catch (Throwable th) {
            zzaj zzajVar19 = this.zze;
            zzak(zzajVar19);
            zzajVar19.zzy();
            throw th;
        }
    }

    private final boolean zzai() {
        zzaz().zzg();
        zzB();
        zzaj zzajVar = this.zze;
        zzak(zzajVar);
        if (zzajVar.zzH()) {
            return true;
        }
        zzaj zzajVar2 = this.zze;
        zzak(zzajVar2);
        return !TextUtils.isEmpty(zzajVar2.zzr());
    }

    private final boolean zzaj(com.google.android.gms.internal.measurement.zzfn zzfnVar, com.google.android.gms.internal.measurement.zzfn zzfnVar2) {
        Preconditions.checkArgument("_e".equals(zzfnVar.zzo()));
        zzak(this.zzi);
        com.google.android.gms.internal.measurement.zzfs zzfsVarZzC = zzku.zzC(zzfnVar.zzaA(), "_sc");
        String strZzh = zzfsVarZzC == null ? null : zzfsVarZzC.zzh();
        zzak(this.zzi);
        com.google.android.gms.internal.measurement.zzfs zzfsVarZzC2 = zzku.zzC(zzfnVar2.zzaA(), "_pc");
        String strZzh2 = zzfsVarZzC2 != null ? zzfsVarZzC2.zzh() : null;
        if (strZzh2 == null || !strZzh2.equals(strZzh)) {
            return false;
        }
        zzae(zzfnVar, zzfnVar2);
        return true;
    }

    private static final zzki zzak(zzki zzkiVar) {
        if (zzkiVar == null) {
            throw new IllegalStateException("Upload Component not created");
        }
        if (zzkiVar.zzaa()) {
            return zzkiVar;
        }
        String strValueOf = String.valueOf(zzkiVar.getClass());
        String.valueOf(strValueOf).length();
        throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(strValueOf)));
    }

    public static zzks zzt(Context context) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzb == null) {
            synchronized (zzks.class) {
                if (zzb == null) {
                    zzb = new zzks((zzkt) Preconditions.checkNotNull(new zzkt(context)), null);
                }
            }
        }
        return zzb;
    }

    static /* bridge */ /* synthetic */ void zzy(zzks zzksVar, zzkt zzktVar) {
        zzksVar.zzaz().zzg();
        zzksVar.zzm = new zzfd(zzksVar);
        zzaj zzajVar = new zzaj(zzksVar);
        zzajVar.zzZ();
        zzksVar.zze = zzajVar;
        zzksVar.zzg().zzq((zzae) Preconditions.checkNotNull(zzksVar.zzc));
        zzjp zzjpVar = new zzjp(zzksVar);
        zzjpVar.zzZ();
        zzksVar.zzk = zzjpVar;
        zzz zzzVar = new zzz(zzksVar);
        zzzVar.zzZ();
        zzksVar.zzh = zzzVar;
        zzif zzifVar = new zzif(zzksVar);
        zzifVar.zzZ();
        zzksVar.zzj = zzifVar;
        zzkg zzkgVar = new zzkg(zzksVar);
        zzkgVar.zzZ();
        zzksVar.zzg = zzkgVar;
        zzksVar.zzf = new zzet(zzksVar);
        if (zzksVar.zzr != zzksVar.zzs) {
            zzksVar.zzay().zzd().zzc("Not all upload components initialized", Integer.valueOf(zzksVar.zzr), Integer.valueOf(zzksVar.zzs));
        }
        zzksVar.zzo = true;
    }

    final void zzA() {
        zzaz().zzg();
        zzB();
        if (this.zzp) {
            return;
        }
        this.zzp = true;
        if (zzX()) {
            FileChannel fileChannel = this.zzx;
            zzaz().zzg();
            int i = 0;
            if (fileChannel == null || !fileChannel.isOpen()) {
                zzay().zzd().zza("Bad channel to read from");
            } else {
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
                try {
                    fileChannel.position(0L);
                    int i2 = fileChannel.read(byteBufferAllocate);
                    if (i2 == 4) {
                        byteBufferAllocate.flip();
                        i = byteBufferAllocate.getInt();
                    } else if (i2 != -1) {
                        zzay().zzk().zzb("Unexpected data length. Bytes read", Integer.valueOf(i2));
                    }
                } catch (IOException e) {
                    zzay().zzd().zzb("Failed to read from channel", e);
                }
            }
            int iZzi = this.zzn.zzh().zzi();
            zzaz().zzg();
            if (i > iZzi) {
                zzay().zzd().zzc("Panic: can't downgrade version. Previous, current version", Integer.valueOf(i), Integer.valueOf(iZzi));
                return;
            }
            if (i < iZzi) {
                FileChannel fileChannel2 = this.zzx;
                zzaz().zzg();
                if (fileChannel2 == null || !fileChannel2.isOpen()) {
                    zzay().zzd().zza("Bad channel to read from");
                } else {
                    ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(4);
                    byteBufferAllocate2.putInt(iZzi);
                    byteBufferAllocate2.flip();
                    try {
                        fileChannel2.truncate(0L);
                        if (zzg().zzs(null, zzdy.zzak) && Build.VERSION.SDK_INT <= 19) {
                            fileChannel2.position(0L);
                        }
                        fileChannel2.write(byteBufferAllocate2);
                        fileChannel2.force(true);
                        if (fileChannel2.size() != 4) {
                            zzay().zzd().zzb("Error writing to channel. Bytes written", Long.valueOf(fileChannel2.size()));
                        }
                        zzay().zzj().zzc("Storage version upgraded. Previous, current version", Integer.valueOf(i), Integer.valueOf(iZzi));
                        return;
                    } catch (IOException e2) {
                        zzay().zzd().zzb("Failed to write to channel", e2);
                    }
                }
                zzay().zzd().zzc("Storage version upgrade failed. Previous, current version", Integer.valueOf(i), Integer.valueOf(iZzi));
            }
        }
    }

    final void zzB() {
        if (!this.zzo) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    final void zzC(zzg zzgVar) throws IllegalStateException {
        zzaz().zzg();
        zzom.zzc();
        if (zzg().zzs(zzgVar.zzt(), zzdy.zzac)) {
            if (TextUtils.isEmpty(zzgVar.zzz()) && TextUtils.isEmpty(zzgVar.zzy()) && TextUtils.isEmpty(zzgVar.zzr())) {
                zzH((String) Preconditions.checkNotNull(zzgVar.zzt()), 204, null, null, null);
                return;
            }
        } else if (TextUtils.isEmpty(zzgVar.zzz()) && TextUtils.isEmpty(zzgVar.zzr())) {
            zzH((String) Preconditions.checkNotNull(zzgVar.zzt()), 204, null, null, null);
            return;
        }
        zzkj zzkjVar = this.zzl;
        Uri.Builder builder = new Uri.Builder();
        String strZzz = zzgVar.zzz();
        if (TextUtils.isEmpty(strZzz)) {
            zzom.zzc();
            if (zzkjVar.zzs.zzf().zzs(zzgVar.zzt(), zzdy.zzac)) {
                strZzz = zzgVar.zzy();
                if (TextUtils.isEmpty(strZzz)) {
                    strZzz = zzgVar.zzr();
                }
            } else {
                strZzz = zzgVar.zzr();
            }
        }
        ArrayMap arrayMap = null;
        Uri.Builder builderEncodedAuthority = builder.scheme(zzdy.zzd.zza(null)).encodedAuthority(zzdy.zze.zza(null));
        String strValueOf = String.valueOf(strZzz);
        Uri.Builder builderAppendQueryParameter = builderEncodedAuthority.path(strValueOf.length() != 0 ? "config/app/".concat(strValueOf) : new String("config/app/")).appendQueryParameter("app_instance_id", zzgVar.zzu()).appendQueryParameter("platform", Constants.PLATFORM);
        zzkjVar.zzs.zzf().zzh();
        builderAppendQueryParameter.appendQueryParameter("gmp_version", String.valueOf(46000L));
        zzpe.zzc();
        if (zzkjVar.zzs.zzf().zzs(zzgVar.zzt(), zzdy.zzat)) {
            builder.appendQueryParameter("runtime_version", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        }
        String string = builder.build().toString();
        try {
            String str = (String) Preconditions.checkNotNull(zzgVar.zzt());
            URL url = new URL(string);
            zzay().zzj().zzb("Fetching remote configuration", str);
            zzfm zzfmVar = this.zzc;
            zzak(zzfmVar);
            com.google.android.gms.internal.measurement.zzfc zzfcVarZze = zzfmVar.zze(str);
            zzfm zzfmVar2 = this.zzc;
            zzak(zzfmVar2);
            String strZzf = zzfmVar2.zzf(str);
            if (zzfcVarZze != null && !TextUtils.isEmpty(strZzf)) {
                arrayMap = new ArrayMap();
                arrayMap.put("If-Modified-Since", strZzf);
            }
            this.zzt = true;
            zzer zzerVar = this.zzd;
            zzak(zzerVar);
            zzkm zzkmVar = new zzkm(this);
            zzerVar.zzg();
            zzerVar.zzY();
            Preconditions.checkNotNull(url);
            Preconditions.checkNotNull(zzkmVar);
            zzerVar.zzs.zzaz().zzo(new zzeq(zzerVar, str, url, null, arrayMap, zzkmVar));
        } catch (MalformedURLException unused) {
            zzay().zzd().zzc("Failed to parse config URL. Not fetching. appId", zzel.zzn(zzgVar.zzt()), string);
        }
    }

    final void zzD(zzat zzatVar, zzp zzpVar) {
        zzat zzatVar2;
        List<zzab> listZzt;
        List<zzab> listZzt2;
        List<zzab> listZzt3;
        Preconditions.checkNotNull(zzpVar);
        Preconditions.checkNotEmpty(zzpVar.zza);
        zzaz().zzg();
        zzB();
        String str = zzpVar.zza;
        zzat zzatVarZza = zzatVar;
        long j = zzatVarZza.zzd;
        zzpn.zzc();
        if (zzg().zzs(null, zzdy.zzaA)) {
            zzem zzemVarZzb = zzem.zzb(zzatVar);
            zzaz().zzg();
            zzkz.zzJ(null, zzemVarZzb.zzd, false);
            zzatVarZza = zzemVarZzb.zza();
        }
        zzak(this.zzi);
        if (zzku.zzB(zzatVarZza, zzpVar)) {
            if (!zzpVar.zzh) {
                zzd(zzpVar);
                return;
            }
            List<String> list = zzpVar.zzt;
            if (list == null) {
                zzatVar2 = zzatVarZza;
            } else if (!list.contains(zzatVarZza.zza)) {
                zzay().zzc().zzd("Dropping non-safelisted event. appId, event name, origin", str, zzatVarZza.zza, zzatVarZza.zzc);
                return;
            } else {
                Bundle bundleZzc = zzatVarZza.zzb.zzc();
                bundleZzc.putLong("ga_safelisted", 1L);
                zzatVar2 = new zzat(zzatVarZza.zza, new zzar(bundleZzc), zzatVarZza.zzc, zzatVarZza.zzd);
            }
            zzaj zzajVar = this.zze;
            zzak(zzajVar);
            zzajVar.zzw();
            try {
                zzaj zzajVar2 = this.zze;
                zzak(zzajVar2);
                Preconditions.checkNotEmpty(str);
                zzajVar2.zzg();
                zzajVar2.zzY();
                if (j < 0) {
                    zzajVar2.zzs.zzay().zzk().zzc("Invalid time querying timed out conditional properties", zzel.zzn(str), Long.valueOf(j));
                    listZzt = Collections.emptyList();
                } else {
                    listZzt = zzajVar2.zzt("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str, String.valueOf(j)});
                }
                for (zzab zzabVar : listZzt) {
                    if (zzabVar != null) {
                        zzay().zzj().zzd("User property timed out", zzabVar.zza, this.zzn.zzj().zzf(zzabVar.zzc.zzb), zzabVar.zzc.zza());
                        zzat zzatVar3 = zzabVar.zzg;
                        if (zzatVar3 != null) {
                            zzW(new zzat(zzatVar3, j), zzpVar);
                        }
                        zzaj zzajVar3 = this.zze;
                        zzak(zzajVar3);
                        zzajVar3.zza(str, zzabVar.zzc.zzb);
                    }
                }
                zzaj zzajVar4 = this.zze;
                zzak(zzajVar4);
                Preconditions.checkNotEmpty(str);
                zzajVar4.zzg();
                zzajVar4.zzY();
                if (j < 0) {
                    zzajVar4.zzs.zzay().zzk().zzc("Invalid time querying expired conditional properties", zzel.zzn(str), Long.valueOf(j));
                    listZzt2 = Collections.emptyList();
                } else {
                    listZzt2 = zzajVar4.zzt("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str, String.valueOf(j)});
                }
                ArrayList arrayList = new ArrayList(listZzt2.size());
                for (zzab zzabVar2 : listZzt2) {
                    if (zzabVar2 != null) {
                        zzay().zzj().zzd("User property expired", zzabVar2.zza, this.zzn.zzj().zzf(zzabVar2.zzc.zzb), zzabVar2.zzc.zza());
                        zzaj zzajVar5 = this.zze;
                        zzak(zzajVar5);
                        zzajVar5.zzB(str, zzabVar2.zzc.zzb);
                        zzat zzatVar4 = zzabVar2.zzk;
                        if (zzatVar4 != null) {
                            arrayList.add(zzatVar4);
                        }
                        zzaj zzajVar6 = this.zze;
                        zzak(zzajVar6);
                        zzajVar6.zza(str, zzabVar2.zzc.zzb);
                    }
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    zzW(new zzat((zzat) it.next(), j), zzpVar);
                }
                zzaj zzajVar7 = this.zze;
                zzak(zzajVar7);
                String str2 = zzatVar2.zza;
                Preconditions.checkNotEmpty(str);
                Preconditions.checkNotEmpty(str2);
                zzajVar7.zzg();
                zzajVar7.zzY();
                if (j < 0) {
                    zzajVar7.zzs.zzay().zzk().zzd("Invalid time querying triggered conditional properties", zzel.zzn(str), zzajVar7.zzs.zzj().zzd(str2), Long.valueOf(j));
                    listZzt3 = Collections.emptyList();
                } else {
                    listZzt3 = zzajVar7.zzt("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str, str2, String.valueOf(j)});
                }
                ArrayList arrayList2 = new ArrayList(listZzt3.size());
                for (zzab zzabVar3 : listZzt3) {
                    if (zzabVar3 != null) {
                        zzkv zzkvVar = zzabVar3.zzc;
                        zzkx zzkxVar = new zzkx((String) Preconditions.checkNotNull(zzabVar3.zza), zzabVar3.zzb, zzkvVar.zzb, j, Preconditions.checkNotNull(zzkvVar.zza()));
                        zzaj zzajVar8 = this.zze;
                        zzak(zzajVar8);
                        if (zzajVar8.zzN(zzkxVar)) {
                            zzay().zzj().zzd("User property triggered", zzabVar3.zza, this.zzn.zzj().zzf(zzkxVar.zzc), zzkxVar.zze);
                        } else {
                            zzay().zzd().zzd("Too many active user properties, ignoring", zzel.zzn(zzabVar3.zza), this.zzn.zzj().zzf(zzkxVar.zzc), zzkxVar.zze);
                        }
                        zzat zzatVar5 = zzabVar3.zzi;
                        if (zzatVar5 != null) {
                            arrayList2.add(zzatVar5);
                        }
                        zzabVar3.zzc = new zzkv(zzkxVar);
                        zzabVar3.zze = true;
                        zzaj zzajVar9 = this.zze;
                        zzak(zzajVar9);
                        zzajVar9.zzM(zzabVar3);
                    }
                }
                zzW(zzatVar2, zzpVar);
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    zzW(new zzat((zzat) it2.next(), j), zzpVar);
                }
                zzaj zzajVar10 = this.zze;
                zzak(zzajVar10);
                zzajVar10.zzD();
            } finally {
                zzaj zzajVar11 = this.zze;
                zzak(zzajVar11);
                zzajVar11.zzy();
            }
        }
    }

    final void zzE(zzat zzatVar, String str) {
        zzaj zzajVar = this.zze;
        zzak(zzajVar);
        zzg zzgVarZzj = zzajVar.zzj(str);
        if (zzgVarZzj == null || TextUtils.isEmpty(zzgVarZzj.zzw())) {
            zzay().zzc().zzb("No app data available; dropping event", str);
            return;
        }
        Boolean boolZzab = zzab(zzgVarZzj);
        if (boolZzab == null) {
            if (!"_ui".equals(zzatVar.zza)) {
                zzay().zzk().zzb("Could not find package. appId", zzel.zzn(str));
            }
        } else if (!boolZzab.booleanValue()) {
            zzay().zzd().zzb("App version does not match; dropping event. appId", zzel.zzn(str));
            return;
        }
        String strZzz = zzgVarZzj.zzz();
        String strZzw = zzgVarZzj.zzw();
        long jZzb = zzgVarZzj.zzb();
        String strZzv = zzgVarZzj.zzv();
        long jZzm = zzgVarZzj.zzm();
        long jZzj = zzgVarZzj.zzj();
        boolean zZzaj = zzgVarZzj.zzaj();
        String strZzx = zzgVarZzj.zzx();
        long jZza = zzgVarZzj.zza();
        boolean zZzai = zzgVarZzj.zzai();
        String strZzr = zzgVarZzj.zzr();
        Boolean boolZzq = zzgVarZzj.zzq();
        long jZzk = zzgVarZzj.zzk();
        List<String> listZzC = zzgVarZzj.zzC();
        zzom.zzc();
        zzF(zzatVar, new zzp(str, strZzz, strZzw, jZzb, strZzv, jZzm, jZzj, (String) null, zZzaj, false, strZzx, jZza, 0L, 0, zZzai, false, strZzr, boolZzq, jZzk, listZzC, zzg().zzs(zzgVarZzj.zzt(), zzdy.zzac) ? zzgVarZzj.zzy() : null, zzh(str).zzi()));
    }

    final void zzF(zzat zzatVar, zzp zzpVar) {
        Preconditions.checkNotEmpty(zzpVar.zza);
        zzem zzemVarZzb = zzem.zzb(zzatVar);
        zzkz zzkzVarZzv = zzv();
        Bundle bundle = zzemVarZzb.zzd;
        zzaj zzajVar = this.zze;
        zzak(zzajVar);
        zzkzVarZzv.zzK(bundle, zzajVar.zzi(zzpVar.zza));
        zzv().zzL(zzemVarZzb, zzg().zzd(zzpVar.zza));
        zzat zzatVarZza = zzemVarZzb.zza();
        if (Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN.equals(zzatVarZza.zza) && "referrer API v2".equals(zzatVarZza.zzb.zzg("_cis"))) {
            String strZzg = zzatVarZza.zzb.zzg("gclid");
            if (!TextUtils.isEmpty(strZzg)) {
                zzU(new zzkv("_lgclid", zzatVarZza.zzd, strZzg, "auto"), zzpVar);
            }
        }
        zzD(zzatVarZza, zzpVar);
    }

    final void zzG() {
        this.zzs++;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0126 A[Catch: all -> 0x016b, TryCatch #1 {all -> 0x016b, blocks: (B:6:0x002c, B:16:0x0049, B:61:0x015d, B:21:0x0063, B:26:0x00b5, B:25:0x00a6, B:29:0x00bd, B:32:0x00c9, B:34:0x00cf, B:39:0x00dc, B:51:0x0111, B:53:0x0126, B:55:0x0145, B:57:0x0150, B:59:0x0156, B:60:0x015a, B:54:0x0134, B:45:0x00f5, B:47:0x0100), top: B:70:0x002c, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0134 A[Catch: all -> 0x016b, TryCatch #1 {all -> 0x016b, blocks: (B:6:0x002c, B:16:0x0049, B:61:0x015d, B:21:0x0063, B:26:0x00b5, B:25:0x00a6, B:29:0x00bd, B:32:0x00c9, B:34:0x00cf, B:39:0x00dc, B:51:0x0111, B:53:0x0126, B:55:0x0145, B:57:0x0150, B:59:0x0156, B:60:0x015a, B:54:0x0134, B:45:0x00f5, B:47:0x0100), top: B:70:0x002c, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x015a A[Catch: all -> 0x016b, TryCatch #1 {all -> 0x016b, blocks: (B:6:0x002c, B:16:0x0049, B:61:0x015d, B:21:0x0063, B:26:0x00b5, B:25:0x00a6, B:29:0x00bd, B:32:0x00c9, B:34:0x00cf, B:39:0x00dc, B:51:0x0111, B:53:0x0126, B:55:0x0145, B:57:0x0150, B:59:0x0156, B:60:0x015a, B:54:0x0134, B:45:0x00f5, B:47:0x0100), top: B:70:0x002c, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final void zzH(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        boolean z;
        zzaj zzajVar;
        zzer zzerVar;
        zzaz().zzg();
        zzB();
        Preconditions.checkNotEmpty(str);
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } finally {
                this.zzt = false;
                zzac();
            }
        }
        zzej zzejVarZzj = zzay().zzj();
        Integer numValueOf = Integer.valueOf(bArr.length);
        zzejVarZzj.zzb("onConfigFetched. Response size", numValueOf);
        zzaj zzajVar2 = this.zze;
        zzak(zzajVar2);
        zzajVar2.zzw();
        try {
            zzaj zzajVar3 = this.zze;
            zzak(zzajVar3);
            zzg zzgVarZzj = zzajVar3.zzj(str);
            if (i == 200 || i == 204) {
                z = th != null;
            } else {
                if (i == 304) {
                    i = 304;
                    if (th != null) {
                    }
                }
            }
            if (zzgVarZzj == null) {
                zzay().zzk().zzb("App does not exist in onConfigFetched. appId", zzel.zzn(str));
            } else if (z || i == 404) {
                List<String> list = map != null ? map.get(HttpHeaders.LAST_MODIFIED) : null;
                String str2 = (list == null || list.size() <= 0) ? null : list.get(0);
                if (i != 404 && i != 304) {
                    zzfm zzfmVar = this.zzc;
                    zzak(zzfmVar);
                    if (!zzfmVar.zzq(str, bArr, str2)) {
                        zzajVar = this.zze;
                        zzak(zzajVar);
                        zzajVar.zzy();
                    }
                    zzgVarZzj.zzM(zzav().currentTimeMillis());
                    zzaj zzajVar4 = this.zze;
                    zzak(zzajVar4);
                    zzajVar4.zzE(zzgVarZzj);
                    if (i != 404) {
                    }
                    zzerVar = this.zzd;
                    zzak(zzerVar);
                    if (zzerVar.zza()) {
                        zzaf();
                    }
                    zzajVar.zzy();
                }
                zzfm zzfmVar2 = this.zzc;
                zzak(zzfmVar2);
                if (zzfmVar2.zze(str) == null) {
                    zzfm zzfmVar3 = this.zzc;
                    zzak(zzfmVar3);
                    if (!zzfmVar3.zzq(str, null, null)) {
                        zzajVar = this.zze;
                        zzak(zzajVar);
                        zzajVar.zzy();
                    }
                }
                zzgVarZzj.zzM(zzav().currentTimeMillis());
                zzaj zzajVar42 = this.zze;
                zzak(zzajVar42);
                zzajVar42.zzE(zzgVarZzj);
                if (i != 404) {
                    zzay().zzl().zzb("Config not found. Using empty config. appId", str);
                } else {
                    zzay().zzj().zzc("Successfully fetched config. Got network response. code, size", Integer.valueOf(i), numValueOf);
                }
                zzerVar = this.zzd;
                zzak(zzerVar);
                if (zzerVar.zza() || !zzai()) {
                    zzaf();
                } else {
                    zzV();
                }
            } else {
                zzgVarZzj.zzV(zzav().currentTimeMillis());
                zzaj zzajVar5 = this.zze;
                zzak(zzajVar5);
                zzajVar5.zzE(zzgVarZzj);
                zzay().zzj().zzc("Fetching config failed. code, error", Integer.valueOf(i), th);
                zzfm zzfmVar4 = this.zzc;
                zzak(zzfmVar4);
                zzfmVar4.zzi(str);
                this.zzk.zzd.zzb(zzav().currentTimeMillis());
                if (i == 503 || i == 429) {
                    this.zzk.zzb.zzb(zzav().currentTimeMillis());
                }
                zzaf();
            }
            zzaj zzajVar6 = this.zze;
            zzak(zzajVar6);
            zzajVar6.zzD();
            zzajVar = this.zze;
            zzak(zzajVar);
            zzajVar.zzy();
        } catch (Throwable th2) {
            zzaj zzajVar7 = this.zze;
            zzak(zzajVar7);
            zzajVar7.zzy();
            throw th2;
        }
    }

    final void zzI(boolean z) {
        zzaf();
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x014a A[Catch: all -> 0x016a, TryCatch #1 {all -> 0x016a, blocks: (B:4:0x000d, B:5:0x000f, B:45:0x0122, B:50:0x0159, B:49:0x014a, B:11:0x0025, B:33:0x00c3, B:35:0x00d8, B:37:0x00de, B:39:0x00e9, B:38:0x00e2, B:41:0x00ed, B:42:0x00f5, B:44:0x00f7), top: B:57:0x000d, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0025 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final void zzJ(int i, Throwable th, byte[] bArr, String str) {
        zzaj zzajVar;
        long jLongValue;
        zzaz().zzg();
        zzB();
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } finally {
                this.zzu = false;
                zzac();
            }
        }
        List<Long> list = (List) Preconditions.checkNotNull(this.zzy);
        this.zzy = null;
        if (i != 200) {
            if (i == 204) {
                i = 204;
                if (th != null) {
                }
            }
            zzay().zzj().zzc("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th);
            this.zzk.zzd.zzb(zzav().currentTimeMillis());
            if (i != 503) {
                this.zzk.zzb.zzb(zzav().currentTimeMillis());
                zzaj zzajVar2 = this.zze;
                zzak(zzajVar2);
                zzajVar2.zzz(list);
                zzaf();
            }
        } else if (th != null) {
            try {
                this.zzk.zzc.zzb(zzav().currentTimeMillis());
                this.zzk.zzd.zzb(0L);
                zzaf();
                zzay().zzj().zzc("Successful upload. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                zzaj zzajVar3 = this.zze;
                zzak(zzajVar3);
                zzajVar3.zzw();
                try {
                    for (Long l : list) {
                        try {
                            zzajVar = this.zze;
                            zzak(zzajVar);
                            jLongValue = l.longValue();
                            zzajVar.zzg();
                            zzajVar.zzY();
                        } catch (SQLiteException e) {
                            List<Long> list2 = this.zzz;
                            if (list2 == null || !list2.contains(l)) {
                                throw e;
                            }
                        }
                        try {
                            if (zzajVar.zzh().delete("queue", "rowid=?", new String[]{String.valueOf(jLongValue)}) != 1) {
                                throw new SQLiteException("Deleted fewer rows from queue than expected");
                            }
                        } catch (SQLiteException e2) {
                            zzajVar.zzs.zzay().zzd().zzb("Failed to delete a bundle in a queue table", e2);
                            throw e2;
                        }
                    }
                    zzaj zzajVar4 = this.zze;
                    zzak(zzajVar4);
                    zzajVar4.zzD();
                    zzaj zzajVar5 = this.zze;
                    zzak(zzajVar5);
                    zzajVar5.zzy();
                    this.zzz = null;
                    zzer zzerVar = this.zzd;
                    zzak(zzerVar);
                    if (zzerVar.zza() && zzai()) {
                        zzV();
                    } else {
                        this.zzA = -1L;
                        zzaf();
                    }
                    this.zza = 0L;
                } catch (Throwable th2) {
                    zzaj zzajVar6 = this.zze;
                    zzak(zzajVar6);
                    zzajVar6.zzy();
                    throw th2;
                }
            } catch (SQLiteException e3) {
                zzay().zzd().zzb("Database error while trying to delete uploaded bundles", e3);
                this.zza = zzav().elapsedRealtime();
                zzay().zzj().zzb("Disable upload, time", Long.valueOf(this.zza));
            }
        } else {
            zzay().zzj().zzc("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th);
            this.zzk.zzd.zzb(zzav().currentTimeMillis());
            if (i != 503 || i == 429) {
                this.zzk.zzb.zzb(zzav().currentTimeMillis());
            }
            zzaj zzajVar22 = this.zze;
            zzak(zzajVar22);
            zzajVar22.zzz(list);
            zzaf();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x021b A[Catch: all -> 0x05a3, TryCatch #1 {all -> 0x05a3, blocks: (B:23:0x00a4, B:25:0x00b3, B:43:0x0118, B:45:0x012b, B:47:0x0141, B:48:0x0168, B:50:0x01b8, B:53:0x01cd, B:56:0x01e3, B:58:0x01ee, B:63:0x01ff, B:66:0x020d, B:70:0x0218, B:72:0x021b, B:74:0x023c, B:76:0x0241, B:79:0x0260, B:82:0x0273, B:84:0x0299, B:87:0x02a1, B:89:0x02b0, B:119:0x03a1, B:121:0x03d3, B:122:0x03d6, B:124:0x03ff, B:164:0x04de, B:165:0x04e1, B:170:0x0543, B:172:0x0551, B:176:0x0592, B:127:0x0416, B:132:0x043f, B:134:0x0447, B:136:0x0453, B:140:0x0466, B:144:0x0477, B:148:0x0483, B:151:0x049b, B:156:0x04c0, B:158:0x04c6, B:159:0x04cd, B:161:0x04d3, B:154:0x04ac, B:142:0x046f, B:130:0x0429, B:90:0x02c1, B:92:0x02ee, B:93:0x02ff, B:95:0x0306, B:97:0x030c, B:99:0x0316, B:101:0x0320, B:103:0x0326, B:105:0x032c, B:106:0x0331, B:112:0x0359, B:115:0x035e, B:116:0x0372, B:117:0x0382, B:118:0x0392, B:166:0x04f8, B:168:0x052c, B:169:0x052f, B:173:0x0575, B:175:0x0579, B:77:0x0250, B:29:0x00c4, B:31:0x00c8, B:35:0x00d7, B:37:0x00f3, B:39:0x00fd, B:42:0x0108), top: B:185:0x00a4, inners: #0, #2, #3, #4 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final void zzK(zzp zzpVar) {
        String str;
        String str2;
        int i;
        String str3;
        zzap zzapVarZzn;
        boolean z;
        String str4;
        String str5;
        PackageInfo packageInfo;
        String str6;
        String str7;
        String str8;
        ApplicationInfo applicationInfo;
        ApplicationInfo applicationInfo2;
        boolean z2;
        boolean z3;
        String strZzw;
        zzaz().zzg();
        zzB();
        Preconditions.checkNotNull(zzpVar);
        Preconditions.checkNotEmpty(zzpVar.zza);
        if (zzag(zzpVar)) {
            zzaj zzajVar = this.zze;
            zzak(zzajVar);
            zzg zzgVarZzj = zzajVar.zzj(zzpVar.zza);
            if (zzgVarZzj != null && TextUtils.isEmpty(zzgVarZzj.zzz()) && !TextUtils.isEmpty(zzpVar.zzb)) {
                zzgVarZzj.zzM(0L);
                zzaj zzajVar2 = this.zze;
                zzak(zzajVar2);
                zzajVar2.zzE(zzgVarZzj);
                zzfm zzfmVar = this.zzc;
                zzak(zzfmVar);
                zzfmVar.zzj(zzpVar.zza);
            }
            if (!zzpVar.zzh) {
                zzd(zzpVar);
                return;
            }
            long jCurrentTimeMillis = zzpVar.zzm;
            if (jCurrentTimeMillis == 0) {
                jCurrentTimeMillis = zzav().currentTimeMillis();
            }
            this.zzn.zzg().zzd();
            int i2 = zzpVar.zzn;
            if (i2 != 0 && i2 != 1) {
                zzay().zzk().zzc("Incorrect app type, assuming installed app. appId, appType", zzel.zzn(zzpVar.zza), Integer.valueOf(i2));
                i2 = 0;
            }
            zzaj zzajVar3 = this.zze;
            zzak(zzajVar3);
            zzajVar3.zzw();
            try {
                zzaj zzajVar4 = this.zze;
                zzak(zzajVar4);
                zzkx zzkxVarZzp = zzajVar4.zzp(zzpVar.zza, "_npa");
                if (zzkxVarZzp == null || "auto".equals(zzkxVarZzp.zzb)) {
                    Boolean bool = zzpVar.zzr;
                    if (bool != null) {
                        str = "_sysu";
                        str2 = "_sys";
                        i = 1;
                        zzkv zzkvVar = new zzkv("_npa", jCurrentTimeMillis, Long.valueOf(true != bool.booleanValue() ? 0L : 1L), "auto");
                        if (zzkxVarZzp == null || !zzkxVarZzp.zze.equals(zzkvVar.zzd)) {
                            zzU(zzkvVar, zzpVar);
                        }
                    } else {
                        str = "_sysu";
                        str2 = "_sys";
                        i = 1;
                        if (zzkxVarZzp != null) {
                            zzO(new zzkv("_npa", jCurrentTimeMillis, null, "auto"), zzpVar);
                        }
                    }
                } else {
                    str = "_sysu";
                    str2 = "_sys";
                    i = 1;
                }
                zzaj zzajVar5 = this.zze;
                zzak(zzajVar5);
                zzg zzgVarZzj2 = zzajVar5.zzj((String) Preconditions.checkNotNull(zzpVar.zza));
                if (zzgVarZzj2 != null && zzv().zzam(zzpVar.zzb, zzgVarZzj2.zzz(), zzpVar.zzq, zzgVarZzj2.zzr())) {
                    zzay().zzk().zzb("New GMP App Id passed in. Removing cached database data. appId", zzel.zzn(zzgVarZzj2.zzt()));
                    zzaj zzajVar6 = this.zze;
                    zzak(zzajVar6);
                    String strZzt = zzgVarZzj2.zzt();
                    zzajVar6.zzY();
                    zzajVar6.zzg();
                    Preconditions.checkNotEmpty(strZzt);
                    try {
                        SQLiteDatabase sQLiteDatabaseZzh = zzajVar6.zzh();
                        String[] strArr = new String[i];
                        strArr[0] = strZzt;
                        int iDelete = sQLiteDatabaseZzh.delete("events", "app_id=?", strArr) + sQLiteDatabaseZzh.delete("user_attributes", "app_id=?", strArr) + sQLiteDatabaseZzh.delete("conditional_properties", "app_id=?", strArr) + sQLiteDatabaseZzh.delete("apps", "app_id=?", strArr) + sQLiteDatabaseZzh.delete("raw_events", "app_id=?", strArr) + sQLiteDatabaseZzh.delete("raw_events_metadata", "app_id=?", strArr) + sQLiteDatabaseZzh.delete("event_filters", "app_id=?", strArr) + sQLiteDatabaseZzh.delete("property_filters", "app_id=?", strArr) + sQLiteDatabaseZzh.delete("audience_filter_values", "app_id=?", strArr) + sQLiteDatabaseZzh.delete("consent_settings", "app_id=?", strArr);
                        if (iDelete > 0) {
                            zzajVar6.zzs.zzay().zzj().zzc("Deleted application data. app, records", strZzt, Integer.valueOf(iDelete));
                        }
                    } catch (SQLiteException e) {
                        zzajVar6.zzs.zzay().zzd().zzc("Error deleting application data. appId, error", zzel.zzn(strZzt), e);
                    }
                    zzgVarZzj2 = null;
                }
                if (zzgVarZzj2 != null) {
                    if (zzgVarZzj2.zzb() != -2147483648L) {
                        str3 = "com.android.vending";
                        z3 = zzgVarZzj2.zzb() != zzpVar.zzj;
                        strZzw = zzgVarZzj2.zzw();
                        if (((zzgVarZzj2.zzb() == -2147483648L || strZzw == null || strZzw.equals(zzpVar.zzc)) ? false : true) | z3) {
                            Bundle bundle = new Bundle();
                            bundle.putString("_pv", strZzw);
                            zzD(new zzat("_au", new zzar(bundle), "auto", jCurrentTimeMillis), zzpVar);
                        }
                    } else {
                        str3 = "com.android.vending";
                    }
                    strZzw = zzgVarZzj2.zzw();
                    if (zzgVarZzj2.zzb() == -2147483648L) {
                        if (((zzgVarZzj2.zzb() == -2147483648L || strZzw == null || strZzw.equals(zzpVar.zzc)) ? false : true) | z3) {
                        }
                    }
                } else {
                    str3 = "com.android.vending";
                }
                zzd(zzpVar);
                if (i2 == 0) {
                    zzaj zzajVar7 = this.zze;
                    zzak(zzajVar7);
                    zzapVarZzn = zzajVar7.zzn(zzpVar.zza, "_f");
                    z = false;
                } else {
                    zzaj zzajVar8 = this.zze;
                    zzak(zzajVar8);
                    zzapVarZzn = zzajVar8.zzn(zzpVar.zza, "_v");
                    z = true;
                }
                if (zzapVarZzn == null) {
                    long j = ((jCurrentTimeMillis / 3600000) + 1) * 3600000;
                    if (z) {
                        zzU(new zzkv("_fvt", jCurrentTimeMillis, Long.valueOf(j), "auto"), zzpVar);
                        zzaz().zzg();
                        zzB();
                        Bundle bundle2 = new Bundle();
                        bundle2.putLong("_c", 1L);
                        bundle2.putLong("_r", 1L);
                        str4 = "_et";
                        bundle2.putLong(str4, 1L);
                        if (zzpVar.zzp) {
                            bundle2.putLong("_dac", 1L);
                        }
                        zzF(new zzat("_v", new zzar(bundle2), "auto", jCurrentTimeMillis), zzpVar);
                    } else {
                        zzU(new zzkv("_fot", jCurrentTimeMillis, Long.valueOf(j), "auto"), zzpVar);
                        zzaz().zzg();
                        zzfd zzfdVar = (zzfd) Preconditions.checkNotNull(this.zzm);
                        String str9 = zzpVar.zza;
                        if (str9 == null || str9.isEmpty()) {
                            zzfdVar.zza.zzay().zzm().zza("Install Referrer Reporter was called with invalid app package name");
                        } else {
                            zzfdVar.zza.zzaz().zzg();
                            if (zzfdVar.zza()) {
                                zzfc zzfcVar = new zzfc(zzfdVar, str9);
                                zzfdVar.zza.zzaz().zzg();
                                Intent intent = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
                                String str10 = str3;
                                intent.setComponent(new ComponentName(str10, "com.google.android.finsky.externalreferrer.GetInstallReferrerService"));
                                PackageManager packageManager = zzfdVar.zza.zzau().getPackageManager();
                                if (packageManager == null) {
                                    zzfdVar.zza.zzay().zzm().zza("Failed to obtain Package Manager to verify binding conditions for Install Referrer");
                                } else {
                                    List<ResolveInfo> listQueryIntentServices = packageManager.queryIntentServices(intent, 0);
                                    if (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) {
                                        zzfdVar.zza.zzay().zzi().zza("Play Service for fetching Install Referrer is unavailable on device");
                                    } else {
                                        ResolveInfo resolveInfo = listQueryIntentServices.get(0);
                                        if (resolveInfo.serviceInfo != null) {
                                            String str11 = resolveInfo.serviceInfo.packageName;
                                            if (resolveInfo.serviceInfo.name != null && str10.equals(str11) && zzfdVar.zza()) {
                                                try {
                                                    zzfdVar.zza.zzay().zzj().zzb("Install Referrer Service is", true != ConnectionTracker.getInstance().bindService(zzfdVar.zza.zzau(), new Intent(intent), zzfcVar, 1) ? "not available" : "available");
                                                } catch (RuntimeException e2) {
                                                    zzfdVar.zza.zzay().zzd().zzb("Exception occurred while binding to Install Referrer Service", e2.getMessage());
                                                }
                                            } else {
                                                zzfdVar.zza.zzay().zzk().zza("Play Store version 8.3.73 or higher required for Install Referrer");
                                            }
                                        }
                                    }
                                }
                            } else {
                                zzfdVar.zza.zzay().zzi().zza("Install Referrer Reporter is not available");
                            }
                        }
                        zzaz().zzg();
                        zzB();
                        Bundle bundle3 = new Bundle();
                        bundle3.putLong("_c", 1L);
                        bundle3.putLong("_r", 1L);
                        bundle3.putLong("_uwa", 0L);
                        bundle3.putLong("_pfo", 0L);
                        String str12 = str2;
                        bundle3.putLong(str12, 0L);
                        String str13 = str;
                        bundle3.putLong(str13, 0L);
                        bundle3.putLong("_et", 1L);
                        if (zzpVar.zzp) {
                            bundle3.putLong("_dac", 1L);
                        }
                        String str14 = (String) Preconditions.checkNotNull(zzpVar.zza);
                        zzaj zzajVar9 = this.zze;
                        zzak(zzajVar9);
                        Preconditions.checkNotEmpty(str14);
                        zzajVar9.zzg();
                        zzajVar9.zzY();
                        long jZzc = zzajVar9.zzc(str14, "first_open_count");
                        if (this.zzn.zzau().getPackageManager() == null) {
                            zzay().zzd().zzb("PackageManager is null, first open report might be inaccurate. appId", zzel.zzn(str14));
                            str7 = "_et";
                        } else {
                            try {
                                packageInfo = Wrappers.packageManager(this.zzn.zzau()).getPackageInfo(str14, 0);
                                str5 = str13;
                            } catch (PackageManager.NameNotFoundException e3) {
                                str5 = str13;
                                zzay().zzd().zzc("Package info is null, first open report might be inaccurate. appId", zzel.zzn(str14), e3);
                                packageInfo = null;
                            }
                            if (packageInfo == null || packageInfo.firstInstallTime == 0) {
                                str6 = str12;
                                str7 = "_et";
                                str8 = str5;
                                applicationInfo = null;
                            } else {
                                str6 = str12;
                                str7 = "_et";
                                if (packageInfo.firstInstallTime != packageInfo.lastUpdateTime) {
                                    applicationInfo = null;
                                    if (!zzg().zzs(null, zzdy.zzag)) {
                                        bundle3.putLong("_uwa", 1L);
                                    } else if (jZzc == 0) {
                                        bundle3.putLong("_uwa", 1L);
                                        jZzc = 0;
                                    }
                                    z2 = false;
                                } else {
                                    applicationInfo = null;
                                    z2 = true;
                                }
                                str8 = str5;
                                zzU(new zzkv("_fi", jCurrentTimeMillis, Long.valueOf(true != z2 ? 0L : 1L), "auto"), zzpVar);
                            }
                            try {
                                applicationInfo2 = Wrappers.packageManager(this.zzn.zzau()).getApplicationInfo(str14, 0);
                            } catch (PackageManager.NameNotFoundException e4) {
                                zzay().zzd().zzc("Application info is null, first open report might be inaccurate. appId", zzel.zzn(str14), e4);
                                applicationInfo2 = applicationInfo;
                            }
                            if (applicationInfo2 != null) {
                                if ((applicationInfo2.flags & 1) != 0) {
                                    bundle3.putLong(str6, 1L);
                                }
                                if ((applicationInfo2.flags & 128) != 0) {
                                    bundle3.putLong(str8, 1L);
                                }
                            }
                        }
                        if (jZzc >= 0) {
                            bundle3.putLong("_pfo", jZzc);
                        }
                        zzF(new zzat("_f", new zzar(bundle3), "auto", jCurrentTimeMillis), zzpVar);
                        str4 = str7;
                    }
                    if (!zzg().zzs(zzpVar.zza, zzdy.zzT)) {
                        Bundle bundle4 = new Bundle();
                        bundle4.putLong(str4, 1L);
                        bundle4.putLong("_fr", 1L);
                        zzF(new zzat("_e", new zzar(bundle4), "auto", jCurrentTimeMillis), zzpVar);
                    }
                } else if (zzpVar.zzi) {
                    zzF(new zzat("_cd", new zzar(new Bundle()), "auto", jCurrentTimeMillis), zzpVar);
                }
                zzaj zzajVar10 = this.zze;
                zzak(zzajVar10);
                zzajVar10.zzD();
            } finally {
                zzaj zzajVar11 = this.zze;
                zzak(zzajVar11);
                zzajVar11.zzy();
            }
        }
    }

    final void zzL() {
        this.zzr++;
    }

    final void zzM(zzab zzabVar) {
        zzp zzpVarZzaa = zzaa((String) Preconditions.checkNotNull(zzabVar.zza));
        if (zzpVarZzaa != null) {
            zzN(zzabVar, zzpVarZzaa);
        }
    }

    final void zzN(zzab zzabVar, zzp zzpVar) {
        Preconditions.checkNotNull(zzabVar);
        Preconditions.checkNotEmpty(zzabVar.zza);
        Preconditions.checkNotNull(zzabVar.zzc);
        Preconditions.checkNotEmpty(zzabVar.zzc.zzb);
        zzaz().zzg();
        zzB();
        if (zzag(zzpVar)) {
            if (!zzpVar.zzh) {
                zzd(zzpVar);
                return;
            }
            zzaj zzajVar = this.zze;
            zzak(zzajVar);
            zzajVar.zzw();
            try {
                zzd(zzpVar);
                String str = (String) Preconditions.checkNotNull(zzabVar.zza);
                zzaj zzajVar2 = this.zze;
                zzak(zzajVar2);
                zzab zzabVarZzk = zzajVar2.zzk(str, zzabVar.zzc.zzb);
                if (zzabVarZzk != null) {
                    zzay().zzc().zzc("Removing conditional user property", zzabVar.zza, this.zzn.zzj().zzf(zzabVar.zzc.zzb));
                    zzaj zzajVar3 = this.zze;
                    zzak(zzajVar3);
                    zzajVar3.zza(str, zzabVar.zzc.zzb);
                    if (zzabVarZzk.zze) {
                        zzaj zzajVar4 = this.zze;
                        zzak(zzajVar4);
                        zzajVar4.zzB(str, zzabVar.zzc.zzb);
                    }
                    zzat zzatVar = zzabVar.zzk;
                    if (zzatVar != null) {
                        zzar zzarVar = zzatVar.zzb;
                        zzW((zzat) Preconditions.checkNotNull(zzv().zzz(str, ((zzat) Preconditions.checkNotNull(zzabVar.zzk)).zza, zzarVar != null ? zzarVar.zzc() : null, zzabVarZzk.zzb, zzabVar.zzk.zzd, true, true)), zzpVar);
                    }
                } else {
                    zzay().zzk().zzc("Conditional user property doesn't exist", zzel.zzn(zzabVar.zza), this.zzn.zzj().zzf(zzabVar.zzc.zzb));
                }
                zzaj zzajVar5 = this.zze;
                zzak(zzajVar5);
                zzajVar5.zzD();
            } finally {
                zzaj zzajVar6 = this.zze;
                zzak(zzajVar6);
                zzajVar6.zzy();
            }
        }
    }

    final void zzO(zzkv zzkvVar, zzp zzpVar) {
        zzaz().zzg();
        zzB();
        if (zzag(zzpVar)) {
            if (!zzpVar.zzh) {
                zzd(zzpVar);
                return;
            }
            if ("_npa".equals(zzkvVar.zzb) && zzpVar.zzr != null) {
                zzay().zzc().zza("Falling back to manifest metadata value for ad personalization");
                zzU(new zzkv("_npa", zzav().currentTimeMillis(), Long.valueOf(true != zzpVar.zzr.booleanValue() ? 0L : 1L), "auto"), zzpVar);
                return;
            }
            zzay().zzc().zzb("Removing user property", this.zzn.zzj().zzf(zzkvVar.zzb));
            zzaj zzajVar = this.zze;
            zzak(zzajVar);
            zzajVar.zzw();
            try {
                zzd(zzpVar);
                zzmt.zzc();
                if (this.zzn.zzf().zzs(null, zzdy.zzav) && this.zzn.zzf().zzs(null, zzdy.zzax) && "_id".equals(zzkvVar.zzb)) {
                    zzaj zzajVar2 = this.zze;
                    zzak(zzajVar2);
                    zzajVar2.zzB((String) Preconditions.checkNotNull(zzpVar.zza), "_lair");
                }
                zzaj zzajVar3 = this.zze;
                zzak(zzajVar3);
                zzajVar3.zzB((String) Preconditions.checkNotNull(zzpVar.zza), zzkvVar.zzb);
                zzaj zzajVar4 = this.zze;
                zzak(zzajVar4);
                zzajVar4.zzD();
                zzay().zzc().zzb("User property removed", this.zzn.zzj().zzf(zzkvVar.zzb));
            } finally {
                zzaj zzajVar5 = this.zze;
                zzak(zzajVar5);
                zzajVar5.zzy();
            }
        }
    }

    final void zzP(zzp zzpVar) {
        if (this.zzy != null) {
            ArrayList arrayList = new ArrayList();
            this.zzz = arrayList;
            arrayList.addAll(this.zzy);
        }
        zzaj zzajVar = this.zze;
        zzak(zzajVar);
        String str = (String) Preconditions.checkNotNull(zzpVar.zza);
        Preconditions.checkNotEmpty(str);
        zzajVar.zzg();
        zzajVar.zzY();
        try {
            SQLiteDatabase sQLiteDatabaseZzh = zzajVar.zzh();
            String[] strArr = {str};
            int iDelete = sQLiteDatabaseZzh.delete("apps", "app_id=?", strArr) + sQLiteDatabaseZzh.delete("events", "app_id=?", strArr) + sQLiteDatabaseZzh.delete("user_attributes", "app_id=?", strArr) + sQLiteDatabaseZzh.delete("conditional_properties", "app_id=?", strArr) + sQLiteDatabaseZzh.delete("raw_events", "app_id=?", strArr) + sQLiteDatabaseZzh.delete("raw_events_metadata", "app_id=?", strArr) + sQLiteDatabaseZzh.delete("queue", "app_id=?", strArr) + sQLiteDatabaseZzh.delete("audience_filter_values", "app_id=?", strArr) + sQLiteDatabaseZzh.delete("main_event_params", "app_id=?", strArr) + sQLiteDatabaseZzh.delete("default_event_params", "app_id=?", strArr);
            if (iDelete > 0) {
                zzajVar.zzs.zzay().zzj().zzc("Reset analytics data. app, records", str, Integer.valueOf(iDelete));
            }
        } catch (SQLiteException e) {
            zzajVar.zzs.zzay().zzd().zzc("Error resetting analytics data. appId, error", zzel.zzn(str), e);
        }
        if (zzpVar.zzh) {
            zzK(zzpVar);
        }
    }

    protected final void zzQ() {
        zzaz().zzg();
        zzaj zzajVar = this.zze;
        zzak(zzajVar);
        zzajVar.zzA();
        if (this.zzk.zzc.zza() == 0) {
            this.zzk.zzc.zzb(zzav().currentTimeMillis());
        }
        zzaf();
    }

    final void zzR(zzab zzabVar) {
        zzp zzpVarZzaa = zzaa((String) Preconditions.checkNotNull(zzabVar.zza));
        if (zzpVarZzaa != null) {
            zzS(zzabVar, zzpVarZzaa);
        }
    }

    final void zzS(zzab zzabVar, zzp zzpVar) {
        zzat zzatVar;
        Preconditions.checkNotNull(zzabVar);
        Preconditions.checkNotEmpty(zzabVar.zza);
        Preconditions.checkNotNull(zzabVar.zzb);
        Preconditions.checkNotNull(zzabVar.zzc);
        Preconditions.checkNotEmpty(zzabVar.zzc.zzb);
        zzaz().zzg();
        zzB();
        if (zzag(zzpVar)) {
            if (!zzpVar.zzh) {
                zzd(zzpVar);
                return;
            }
            zzab zzabVar2 = new zzab(zzabVar);
            boolean z = false;
            zzabVar2.zze = false;
            zzaj zzajVar = this.zze;
            zzak(zzajVar);
            zzajVar.zzw();
            try {
                zzaj zzajVar2 = this.zze;
                zzak(zzajVar2);
                zzab zzabVarZzk = zzajVar2.zzk((String) Preconditions.checkNotNull(zzabVar2.zza), zzabVar2.zzc.zzb);
                if (zzabVarZzk != null && !zzabVarZzk.zzb.equals(zzabVar2.zzb)) {
                    zzay().zzk().zzd("Updating a conditional user property with different origin. name, origin, origin (from DB)", this.zzn.zzj().zzf(zzabVar2.zzc.zzb), zzabVar2.zzb, zzabVarZzk.zzb);
                }
                if (zzabVarZzk != null && zzabVarZzk.zze) {
                    zzabVar2.zzb = zzabVarZzk.zzb;
                    zzabVar2.zzd = zzabVarZzk.zzd;
                    zzabVar2.zzh = zzabVarZzk.zzh;
                    zzabVar2.zzf = zzabVarZzk.zzf;
                    zzabVar2.zzi = zzabVarZzk.zzi;
                    zzabVar2.zze = true;
                    zzkv zzkvVar = zzabVar2.zzc;
                    zzabVar2.zzc = new zzkv(zzkvVar.zzb, zzabVarZzk.zzc.zzc, zzkvVar.zza(), zzabVarZzk.zzc.zzf);
                } else if (TextUtils.isEmpty(zzabVar2.zzf)) {
                    zzkv zzkvVar2 = zzabVar2.zzc;
                    zzabVar2.zzc = new zzkv(zzkvVar2.zzb, zzabVar2.zzd, zzkvVar2.zza(), zzabVar2.zzc.zzf);
                    zzabVar2.zze = true;
                    z = true;
                }
                if (zzabVar2.zze) {
                    zzkv zzkvVar3 = zzabVar2.zzc;
                    zzkx zzkxVar = new zzkx((String) Preconditions.checkNotNull(zzabVar2.zza), zzabVar2.zzb, zzkvVar3.zzb, zzkvVar3.zzc, Preconditions.checkNotNull(zzkvVar3.zza()));
                    zzaj zzajVar3 = this.zze;
                    zzak(zzajVar3);
                    if (zzajVar3.zzN(zzkxVar)) {
                        zzay().zzc().zzd("User property updated immediately", zzabVar2.zza, this.zzn.zzj().zzf(zzkxVar.zzc), zzkxVar.zze);
                    } else {
                        zzay().zzd().zzd("(2)Too many active user properties, ignoring", zzel.zzn(zzabVar2.zza), this.zzn.zzj().zzf(zzkxVar.zzc), zzkxVar.zze);
                    }
                    if (z && (zzatVar = zzabVar2.zzi) != null) {
                        zzW(new zzat(zzatVar, zzabVar2.zzd), zzpVar);
                    }
                }
                zzaj zzajVar4 = this.zze;
                zzak(zzajVar4);
                if (zzajVar4.zzM(zzabVar2)) {
                    zzay().zzc().zzd("Conditional property added", zzabVar2.zza, this.zzn.zzj().zzf(zzabVar2.zzc.zzb), zzabVar2.zzc.zza());
                } else {
                    zzay().zzd().zzd("Too many conditional properties, ignoring", zzel.zzn(zzabVar2.zza), this.zzn.zzj().zzf(zzabVar2.zzc.zzb), zzabVar2.zzc.zza());
                }
                zzaj zzajVar5 = this.zze;
                zzak(zzajVar5);
                zzajVar5.zzD();
            } finally {
                zzaj zzajVar6 = this.zze;
                zzak(zzajVar6);
                zzajVar6.zzy();
            }
        }
    }

    final void zzT(String str, zzag zzagVar) {
        zzaz().zzg();
        zzB();
        this.zzB.put(str, zzagVar);
        zzaj zzajVar = this.zze;
        zzak(zzajVar);
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(zzagVar);
        zzajVar.zzg();
        zzajVar.zzY();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("consent_state", zzagVar.zzi());
        try {
            if (zzajVar.zzh().insertWithOnConflict("consent_settings", null, contentValues, 5) == -1) {
                zzajVar.zzs.zzay().zzd().zzb("Failed to insert/update consent setting (got -1). appId", zzel.zzn(str));
            }
        } catch (SQLiteException e) {
            zzajVar.zzs.zzay().zzd().zzc("Error storing consent setting. appId, error", zzel.zzn(str), e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00d2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final void zzU(zzkv zzkvVar, zzp zzpVar) {
        long jLongValue;
        zzaz().zzg();
        zzB();
        if (zzag(zzpVar)) {
            if (!zzpVar.zzh) {
                zzd(zzpVar);
                return;
            }
            int iZzl = zzv().zzl(zzkvVar.zzb);
            int length = 0;
            if (iZzl != 0) {
                zzkz zzkzVarZzv = zzv();
                String str = zzkvVar.zzb;
                zzg();
                String strZzC = zzkzVarZzv.zzC(str, 24, true);
                String str2 = zzkvVar.zzb;
                zzv().zzM(this.zzC, zzpVar.zza, iZzl, "_ev", strZzC, str2 != null ? str2.length() : 0);
                return;
            }
            int iZzd = zzv().zzd(zzkvVar.zzb, zzkvVar.zza());
            if (iZzd != 0) {
                zzkz zzkzVarZzv2 = zzv();
                String str3 = zzkvVar.zzb;
                zzg();
                String strZzC2 = zzkzVarZzv2.zzC(str3, 24, true);
                Object objZza = zzkvVar.zza();
                if (objZza != null && ((objZza instanceof String) || (objZza instanceof CharSequence))) {
                    length = objZza.toString().length();
                }
                zzv().zzM(this.zzC, zzpVar.zza, iZzd, "_ev", strZzC2, length);
                return;
            }
            Object objZzB = zzv().zzB(zzkvVar.zzb, zzkvVar.zza());
            if (objZzB == null) {
                return;
            }
            if ("_sid".equals(zzkvVar.zzb)) {
                long j = zzkvVar.zzc;
                String str4 = zzkvVar.zzf;
                String str5 = (String) Preconditions.checkNotNull(zzpVar.zza);
                zzaj zzajVar = this.zze;
                zzak(zzajVar);
                zzkx zzkxVarZzp = zzajVar.zzp(str5, "_sno");
                if (zzkxVarZzp != null) {
                    Object obj = zzkxVarZzp.zze;
                    if (obj instanceof Long) {
                        jLongValue = ((Long) obj).longValue();
                    } else {
                        if (zzkxVarZzp != null) {
                            zzay().zzk().zzb("Retrieved last session number from database does not contain a valid (long) value", zzkxVarZzp.zze);
                        }
                        zzaj zzajVar2 = this.zze;
                        zzak(zzajVar2);
                        zzap zzapVarZzn = zzajVar2.zzn(str5, "_s");
                        if (zzapVarZzn != null) {
                            jLongValue = zzapVarZzn.zzc;
                            zzay().zzj().zzb("Backfill the session number. Last used session number", Long.valueOf(jLongValue));
                        } else {
                            jLongValue = 0;
                        }
                    }
                    zzU(new zzkv("_sno", j, Long.valueOf(jLongValue + 1), str4), zzpVar);
                }
            }
            zzkx zzkxVar = new zzkx((String) Preconditions.checkNotNull(zzpVar.zza), (String) Preconditions.checkNotNull(zzkvVar.zzf), zzkvVar.zzb, zzkvVar.zzc, objZzB);
            zzay().zzj().zzc("Setting user property", this.zzn.zzj().zzf(zzkxVar.zzc), objZzB);
            zzaj zzajVar3 = this.zze;
            zzak(zzajVar3);
            zzajVar3.zzw();
            try {
                zzmt.zzc();
                if (this.zzn.zzf().zzs(null, zzdy.zzav) && "_id".equals(zzkxVar.zzc)) {
                    zzaj zzajVar4 = this.zze;
                    zzak(zzajVar4);
                    zzajVar4.zzB(zzpVar.zza, "_lair");
                }
                zzd(zzpVar);
                zzaj zzajVar5 = this.zze;
                zzak(zzajVar5);
                boolean zZzN = zzajVar5.zzN(zzkxVar);
                zzaj zzajVar6 = this.zze;
                zzak(zzajVar6);
                zzajVar6.zzD();
                if (!zZzN) {
                    zzay().zzd().zzc("Too many unique user properties are set. Ignoring user property", this.zzn.zzj().zzf(zzkxVar.zzc), zzkxVar.zze);
                    zzv().zzM(this.zzC, zzpVar.zza, 9, null, null, 0);
                }
            } finally {
                zzaj zzajVar7 = this.zze;
                zzak(zzajVar7);
                zzajVar7.zzy();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:155:0x02fc, code lost:
    
        r0 = r0.subList(0, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x0301, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x0302, code lost:
    
        r2 = false;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0270 A[Catch: all -> 0x0518, TRY_ENTER, TRY_LEAVE, TryCatch #20 {all -> 0x0518, blocks: (B:134:0x029f, B:136:0x02a5, B:138:0x02af, B:139:0x02b3, B:141:0x02b9, B:143:0x02cd, B:147:0x02d6, B:149:0x02dc, B:152:0x02f1, B:160:0x0308, B:162:0x0323, B:166:0x0330, B:168:0x0343, B:172:0x037d, B:174:0x0382, B:176:0x038a, B:177:0x038d, B:179:0x0399, B:180:0x03af, B:183:0x03bb, B:185:0x03cc, B:187:0x03dd, B:188:0x03f8, B:190:0x040a, B:192:0x041f, B:196:0x042f, B:197:0x0433, B:191:0x0418, B:199:0x0476, B:121:0x0270, B:133:0x029c, B:203:0x048d, B:204:0x0490, B:205:0x0491, B:211:0x04d3, B:226:0x04f7, B:228:0x04fd, B:230:0x0508, B:235:0x0514, B:236:0x0517, B:195:0x042b), top: B:267:0x00eb, inners: #17 }] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x02a5 A[Catch: all -> 0x0518, TryCatch #20 {all -> 0x0518, blocks: (B:134:0x029f, B:136:0x02a5, B:138:0x02af, B:139:0x02b3, B:141:0x02b9, B:143:0x02cd, B:147:0x02d6, B:149:0x02dc, B:152:0x02f1, B:160:0x0308, B:162:0x0323, B:166:0x0330, B:168:0x0343, B:172:0x037d, B:174:0x0382, B:176:0x038a, B:177:0x038d, B:179:0x0399, B:180:0x03af, B:183:0x03bb, B:185:0x03cc, B:187:0x03dd, B:188:0x03f8, B:190:0x040a, B:192:0x041f, B:196:0x042f, B:197:0x0433, B:191:0x0418, B:199:0x0476, B:121:0x0270, B:133:0x029c, B:203:0x048d, B:204:0x0490, B:205:0x0491, B:211:0x04d3, B:226:0x04f7, B:228:0x04fd, B:230:0x0508, B:235:0x0514, B:236:0x0517, B:195:0x042b), top: B:267:0x00eb, inners: #17 }] */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0308 A[Catch: all -> 0x0518, EDGE_INSN: B:280:0x0308->B:160:0x0308 BREAK  A[LOOP:2: B:147:0x02d6->B:159:0x0305], EDGE_INSN: B:155:0x02fc->B:160:0x0308 BREAK  A[LOOP:2: B:147:0x02d6->B:159:0x0305], PHI: r0
      0x0308: PHI (r0v45 java.util.List) = (r0v44 java.util.List), (r0v44 java.util.List), (r0v44 java.util.List), (r0v58 java.util.List) binds: [B:137:0x02ad, B:145:0x02d3, B:280:0x0308, B:155:0x02fc] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TryCatch #20 {all -> 0x0518, blocks: (B:134:0x029f, B:136:0x02a5, B:138:0x02af, B:139:0x02b3, B:141:0x02b9, B:143:0x02cd, B:147:0x02d6, B:149:0x02dc, B:152:0x02f1, B:160:0x0308, B:162:0x0323, B:166:0x0330, B:168:0x0343, B:172:0x037d, B:174:0x0382, B:176:0x038a, B:177:0x038d, B:179:0x0399, B:180:0x03af, B:183:0x03bb, B:185:0x03cc, B:187:0x03dd, B:188:0x03f8, B:190:0x040a, B:192:0x041f, B:196:0x042f, B:197:0x0433, B:191:0x0418, B:199:0x0476, B:121:0x0270, B:133:0x029c, B:203:0x048d, B:204:0x0490, B:205:0x0491, B:211:0x04d3, B:226:0x04f7, B:228:0x04fd, B:230:0x0508, B:235:0x0514, B:236:0x0517, B:195:0x042b), top: B:267:0x00eb, inners: #17 }] */
    /* JADX WARN: Removed duplicated region for block: B:165:0x032f  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0343 A[Catch: all -> 0x0518, TRY_LEAVE, TryCatch #20 {all -> 0x0518, blocks: (B:134:0x029f, B:136:0x02a5, B:138:0x02af, B:139:0x02b3, B:141:0x02b9, B:143:0x02cd, B:147:0x02d6, B:149:0x02dc, B:152:0x02f1, B:160:0x0308, B:162:0x0323, B:166:0x0330, B:168:0x0343, B:172:0x037d, B:174:0x0382, B:176:0x038a, B:177:0x038d, B:179:0x0399, B:180:0x03af, B:183:0x03bb, B:185:0x03cc, B:187:0x03dd, B:188:0x03f8, B:190:0x040a, B:192:0x041f, B:196:0x042f, B:197:0x0433, B:191:0x0418, B:199:0x0476, B:121:0x0270, B:133:0x029c, B:203:0x048d, B:204:0x0490, B:205:0x0491, B:211:0x04d3, B:226:0x04f7, B:228:0x04fd, B:230:0x0508, B:235:0x0514, B:236:0x0517, B:195:0x042b), top: B:267:0x00eb, inners: #17 }] */
    /* JADX WARN: Removed duplicated region for block: B:185:0x03cc A[Catch: all -> 0x0518, TryCatch #20 {all -> 0x0518, blocks: (B:134:0x029f, B:136:0x02a5, B:138:0x02af, B:139:0x02b3, B:141:0x02b9, B:143:0x02cd, B:147:0x02d6, B:149:0x02dc, B:152:0x02f1, B:160:0x0308, B:162:0x0323, B:166:0x0330, B:168:0x0343, B:172:0x037d, B:174:0x0382, B:176:0x038a, B:177:0x038d, B:179:0x0399, B:180:0x03af, B:183:0x03bb, B:185:0x03cc, B:187:0x03dd, B:188:0x03f8, B:190:0x040a, B:192:0x041f, B:196:0x042f, B:197:0x0433, B:191:0x0418, B:199:0x0476, B:121:0x0270, B:133:0x029c, B:203:0x048d, B:204:0x0490, B:205:0x0491, B:211:0x04d3, B:226:0x04f7, B:228:0x04fd, B:230:0x0508, B:235:0x0514, B:236:0x0517, B:195:0x042b), top: B:267:0x00eb, inners: #17 }] */
    /* JADX WARN: Removed duplicated region for block: B:186:0x03dc  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x040a A[Catch: MalformedURLException -> 0x0476, all -> 0x0518, TryCatch #17 {MalformedURLException -> 0x0476, blocks: (B:188:0x03f8, B:190:0x040a, B:192:0x041f, B:195:0x042b, B:196:0x042f, B:197:0x0433, B:191:0x0418), top: B:263:0x03f8, outer: #20 }] */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0418 A[Catch: MalformedURLException -> 0x0476, all -> 0x0518, TryCatch #17 {MalformedURLException -> 0x0476, blocks: (B:188:0x03f8, B:190:0x040a, B:192:0x041f, B:195:0x042b, B:196:0x042f, B:197:0x0433, B:191:0x0418), top: B:263:0x03f8, outer: #20 }] */
    /* JADX WARN: Removed duplicated region for block: B:194:0x042a  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x04d3 A[Catch: all -> 0x0518, PHI: r3 r9
      0x04d3: PHI (r3v7 android.database.Cursor) = (r3v50 android.database.Cursor), (r3v51 android.database.Cursor), (r3v52 android.database.Cursor) binds: [B:215:0x04dc, B:210:0x04d1, B:224:0x04f4] A[DONT_GENERATE, DONT_INLINE]
      0x04d3: PHI (r9v4 java.lang.String) = (r9v49 java.lang.String), (r9v31 java.lang.String), (r9v50 java.lang.String) binds: [B:215:0x04dc, B:210:0x04d1, B:224:0x04f4] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #20 {all -> 0x0518, blocks: (B:134:0x029f, B:136:0x02a5, B:138:0x02af, B:139:0x02b3, B:141:0x02b9, B:143:0x02cd, B:147:0x02d6, B:149:0x02dc, B:152:0x02f1, B:160:0x0308, B:162:0x0323, B:166:0x0330, B:168:0x0343, B:172:0x037d, B:174:0x0382, B:176:0x038a, B:177:0x038d, B:179:0x0399, B:180:0x03af, B:183:0x03bb, B:185:0x03cc, B:187:0x03dd, B:188:0x03f8, B:190:0x040a, B:192:0x041f, B:196:0x042f, B:197:0x0433, B:191:0x0418, B:199:0x0476, B:121:0x0270, B:133:0x029c, B:203:0x048d, B:204:0x0490, B:205:0x0491, B:211:0x04d3, B:226:0x04f7, B:228:0x04fd, B:230:0x0508, B:235:0x0514, B:236:0x0517, B:195:0x042b), top: B:267:0x00eb, inners: #17 }] */
    /* JADX WARN: Removed duplicated region for block: B:228:0x04fd A[Catch: all -> 0x0518, TryCatch #20 {all -> 0x0518, blocks: (B:134:0x029f, B:136:0x02a5, B:138:0x02af, B:139:0x02b3, B:141:0x02b9, B:143:0x02cd, B:147:0x02d6, B:149:0x02dc, B:152:0x02f1, B:160:0x0308, B:162:0x0323, B:166:0x0330, B:168:0x0343, B:172:0x037d, B:174:0x0382, B:176:0x038a, B:177:0x038d, B:179:0x0399, B:180:0x03af, B:183:0x03bb, B:185:0x03cc, B:187:0x03dd, B:188:0x03f8, B:190:0x040a, B:192:0x041f, B:196:0x042f, B:197:0x0433, B:191:0x0418, B:199:0x0476, B:121:0x0270, B:133:0x029c, B:203:0x048d, B:204:0x0490, B:205:0x0491, B:211:0x04d3, B:226:0x04f7, B:228:0x04fd, B:230:0x0508, B:235:0x0514, B:236:0x0517, B:195:0x042b), top: B:267:0x00eb, inners: #17 }] */
    /* JADX WARN: Removed duplicated region for block: B:235:0x0514 A[Catch: all -> 0x0518, TRY_ENTER, TryCatch #20 {all -> 0x0518, blocks: (B:134:0x029f, B:136:0x02a5, B:138:0x02af, B:139:0x02b3, B:141:0x02b9, B:143:0x02cd, B:147:0x02d6, B:149:0x02dc, B:152:0x02f1, B:160:0x0308, B:162:0x0323, B:166:0x0330, B:168:0x0343, B:172:0x037d, B:174:0x0382, B:176:0x038a, B:177:0x038d, B:179:0x0399, B:180:0x03af, B:183:0x03bb, B:185:0x03cc, B:187:0x03dd, B:188:0x03f8, B:190:0x040a, B:192:0x041f, B:196:0x042f, B:197:0x0433, B:191:0x0418, B:199:0x0476, B:121:0x0270, B:133:0x029c, B:203:0x048d, B:204:0x0490, B:205:0x0491, B:211:0x04d3, B:226:0x04f7, B:228:0x04fd, B:230:0x0508, B:235:0x0514, B:236:0x0517, B:195:0x042b), top: B:267:0x00eb, inners: #17 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x010a A[Catch: all -> 0x051b, PHI: r7 r11
      0x010a: PHI (r7v16 long) = (r7v0 long), (r7v18 long), (r7v0 long) binds: [B:54:0x012a, B:45:0x0112, B:41:0x0108] A[DONT_GENERATE, DONT_INLINE]
      0x010a: PHI (r11v17 android.database.Cursor) = (r11v16 android.database.Cursor), (r11v19 android.database.Cursor), (r11v19 android.database.Cursor) binds: [B:54:0x012a, B:45:0x0112, B:41:0x0108] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #22 {all -> 0x051b, blocks: (B:3:0x0010, B:5:0x0021, B:9:0x0034, B:11:0x003a, B:13:0x004a, B:15:0x0052, B:17:0x0058, B:19:0x0063, B:21:0x0073, B:23:0x007e, B:25:0x0091, B:27:0x00b0, B:29:0x00b6, B:30:0x00b9, B:32:0x00c5, B:33:0x00dc, B:35:0x00ed, B:37:0x00f3, B:42:0x010a, B:56:0x012d, B:60:0x0134, B:61:0x0137, B:62:0x0138, B:66:0x0160, B:70:0x0168, B:76:0x019e, B:195:0x042b), top: B:268:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0134 A[Catch: all -> 0x051b, TryCatch #22 {all -> 0x051b, blocks: (B:3:0x0010, B:5:0x0021, B:9:0x0034, B:11:0x003a, B:13:0x004a, B:15:0x0052, B:17:0x0058, B:19:0x0063, B:21:0x0073, B:23:0x007e, B:25:0x0091, B:27:0x00b0, B:29:0x00b6, B:30:0x00b9, B:32:0x00c5, B:33:0x00dc, B:35:0x00ed, B:37:0x00f3, B:42:0x010a, B:56:0x012d, B:60:0x0134, B:61:0x0137, B:62:0x0138, B:66:0x0160, B:70:0x0168, B:76:0x019e, B:195:0x042b), top: B:268:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0198 A[Catch: SQLiteException -> 0x0277, all -> 0x0489, TRY_LEAVE, TryCatch #2 {SQLiteException -> 0x0277, blocks: (B:72:0x0192, B:74:0x0198, B:78:0x01a5, B:79:0x01ab, B:80:0x01af, B:81:0x01ba), top: B:245:0x0192 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01a5 A[Catch: SQLiteException -> 0x0277, all -> 0x0489, TRY_ENTER, TryCatch #2 {SQLiteException -> 0x0277, blocks: (B:72:0x0192, B:74:0x0198, B:78:0x01a5, B:79:0x01ab, B:80:0x01af, B:81:0x01ba), top: B:245:0x0192 }] */
    /* JADX WARN: Type inference failed for: r0v52, types: [com.google.android.gms.measurement.internal.zzej] */
    /* JADX WARN: Type inference failed for: r2v23, types: [com.google.android.gms.measurement.internal.zzfs] */
    /* JADX WARN: Type inference failed for: r3v12, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v15, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v17, types: [com.google.android.gms.measurement.internal.zzeq, java.lang.Runnable] */
    /* JADX WARN: Type inference failed for: r3v29 */
    /* JADX WARN: Type inference failed for: r3v31 */
    /* JADX WARN: Type inference failed for: r3v33, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r3v35 */
    /* JADX WARN: Type inference failed for: r3v53 */
    /* JADX WARN: Type inference failed for: r3v54 */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* JADX WARN: Type inference failed for: r9v19 */
    /* JADX WARN: Type inference failed for: r9v20 */
    /* JADX WARN: Type inference failed for: r9v21 */
    /* JADX WARN: Type inference failed for: r9v22 */
    /* JADX WARN: Type inference failed for: r9v23 */
    /* JADX WARN: Type inference failed for: r9v24 */
    /* JADX WARN: Type inference failed for: r9v25 */
    /* JADX WARN: Type inference failed for: r9v26, types: [java.io.ByteArrayInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r9v33 */
    /* JADX WARN: Type inference failed for: r9v34 */
    /* JADX WARN: Type inference failed for: r9v35 */
    /* JADX WARN: Type inference failed for: r9v51 */
    /* JADX WARN: Type inference failed for: r9v52 */
    /* JADX WARN: Type inference failed for: r9v53 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:227:0x04fb -> B:231:0x050b). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:229:0x0506 -> B:231:0x050b). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:230:0x0508 -> B:231:0x050b). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final void zzV() {
        boolean z;
        zzaj zzajVar;
        Cursor cursorRawQuery;
        Cursor cursor;
        Cursor cursor2;
        boolean zIsEmpty;
        zzaj zzajVar2;
        Cursor cursor3;
        long j;
        Cursor cursorQuery;
        List listEmptyList;
        com.google.android.gms.internal.measurement.zzfv zzfvVarZza;
        int size;
        ArrayList arrayList;
        int i;
        String strZzm;
        String strZza;
        String strZzL;
        ?? byteArrayOutputStream;
        byte[] byteArray;
        Cursor cursorRawQuery2;
        zzaz().zzg();
        zzB();
        int i2 = 1;
        this.zzv = true;
        int i3 = 0;
        Cursor cursor4 = null;
        try {
            this.zzn.zzaw();
            Boolean boolZzj = this.zzn.zzt().zzj();
            if (boolZzj == null) {
                zzay().zzk().zza("Upload data called on the client side before use of service was decided");
                this.zzv = false;
            } else if (boolZzj.booleanValue()) {
                zzay().zzd().zza("Upload called in the client side when service should be used");
                this.zzv = false;
            } else if (this.zza > 0) {
                zzaf();
                this.zzv = false;
            } else {
                zzaz().zzg();
                if (this.zzy != null) {
                    zzay().zzj().zza("Uploading requested multiple times");
                    this.zzv = false;
                } else {
                    zzer zzerVar = this.zzd;
                    zzak(zzerVar);
                    if (zzerVar.zza()) {
                        long jCurrentTimeMillis = zzav().currentTimeMillis();
                        Cursor cursor5 = null;
                        Cursor cursor6 = null;
                        String str = null;
                        byteArrayInputStream = 0;
                        byteArrayInputStream = 0;
                        ?? byteArrayInputStream = 0;
                        String str2 = null;
                        String str3 = null;
                        str = null;
                        String str4 = null;
                        int iZze = zzg().zze(null, zzdy.zzP);
                        zzg();
                        long jZzz = jCurrentTimeMillis - zzaf.zzz();
                        for (int i4 = 0; i4 < iZze && zzah(null, jZzz); i4++) {
                        }
                        long jZza = this.zzk.zzc.zza();
                        if (jZza != 0) {
                            zzay().zzc().zzb("Uploading events. Elapsed time since last upload attempt (ms)", Long.valueOf(Math.abs(jCurrentTimeMillis - jZza)));
                        }
                        zzaj zzajVar3 = this.zze;
                        zzak(zzajVar3);
                        String strZzr = zzajVar3.zzr();
                        long j2 = -1;
                        try {
                            if (TextUtils.isEmpty(strZzr)) {
                                this.zzA = -1L;
                                zzajVar = this.zze;
                                zzak(zzajVar);
                                zzg();
                                long jZzz2 = jCurrentTimeMillis - zzaf.zzz();
                                zzajVar.zzg();
                                zzajVar.zzY();
                                try {
                                    cursorRawQuery = zzajVar.zzh().rawQuery("select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;", new String[]{String.valueOf(jZzz2)});
                                    try {
                                        try {
                                        } catch (SQLiteException e) {
                                            e = e;
                                            zzajVar.zzs.zzay().zzd().zzb("Error selecting expired configs", e);
                                            cursor2 = cursorRawQuery;
                                            str2 = str4;
                                            cursor = cursorRawQuery;
                                            str3 = str4;
                                            if (cursorRawQuery != null) {
                                            }
                                            zIsEmpty = TextUtils.isEmpty(str2);
                                            cursorRawQuery = cursor2;
                                            str4 = str2;
                                            if (!zIsEmpty) {
                                            }
                                            zzajVar = null;
                                            this.zzv = false;
                                            zzac();
                                        }
                                    } catch (Throwable th) {
                                        th = th;
                                        cursor5 = cursorRawQuery;
                                        if (cursor5 != null) {
                                            cursor5.close();
                                        }
                                        throw th;
                                    }
                                } catch (SQLiteException e2) {
                                    e = e2;
                                    cursorRawQuery = null;
                                    zzajVar.zzs.zzay().zzd().zzb("Error selecting expired configs", e);
                                    cursor2 = cursorRawQuery;
                                    str2 = str4;
                                    cursor = cursorRawQuery;
                                    str3 = str4;
                                    if (cursorRawQuery != null) {
                                    }
                                    zIsEmpty = TextUtils.isEmpty(str2);
                                    cursorRawQuery = cursor2;
                                    str4 = str2;
                                    if (!zIsEmpty) {
                                    }
                                    zzajVar = null;
                                    this.zzv = false;
                                    zzac();
                                } catch (Throwable th2) {
                                    th = th2;
                                    if (cursor5 != null) {
                                    }
                                    throw th;
                                }
                                if (cursorRawQuery.moveToFirst()) {
                                    String string = cursorRawQuery.getString(0);
                                    cursor2 = cursorRawQuery;
                                    str2 = string;
                                    cursor = cursorRawQuery;
                                    str3 = string;
                                    if (cursorRawQuery != null) {
                                    }
                                    zIsEmpty = TextUtils.isEmpty(str2);
                                    cursorRawQuery = cursor2;
                                    str4 = str2;
                                    if (!zIsEmpty) {
                                    }
                                    zzajVar = null;
                                    this.zzv = false;
                                } else {
                                    zzajVar.zzs.zzay().zzj().zza("No expired configs for apps with pending events");
                                    cursor2 = cursorRawQuery;
                                    cursor = cursorRawQuery;
                                    if (cursorRawQuery != null) {
                                        cursor.close();
                                        cursor2 = cursor;
                                        str2 = str3;
                                    }
                                    zIsEmpty = TextUtils.isEmpty(str2);
                                    cursorRawQuery = cursor2;
                                    str4 = str2;
                                    if (!zIsEmpty) {
                                        zzaj zzajVar4 = this.zze;
                                        zzak(zzajVar4);
                                        zzg zzgVarZzj = zzajVar4.zzj(str2);
                                        cursorRawQuery = cursor2;
                                        str4 = str2;
                                        if (zzgVarZzj != null) {
                                            zzC(zzgVarZzj);
                                            cursorRawQuery = cursor2;
                                            str4 = str2;
                                        }
                                    }
                                    zzajVar = null;
                                    this.zzv = false;
                                }
                            } else {
                                if (this.zzA == -1) {
                                    zzaj zzajVar5 = this.zze;
                                    zzak(zzajVar5);
                                    try {
                                        cursorRawQuery2 = zzajVar5.zzh().rawQuery("select rowid from raw_events order by rowid desc limit 1;", null);
                                        try {
                                            try {
                                            } catch (SQLiteException e3) {
                                                e = e3;
                                                zzajVar5.zzs.zzay().zzd().zzb("Error querying raw events", e);
                                                if (cursorRawQuery2 != null) {
                                                }
                                                this.zzA = j2;
                                                int iZze2 = zzg().zze(strZzr, zzdy.zzf);
                                                int iMax = Math.max(0, zzg().zze(strZzr, zzdy.zzg));
                                                zzajVar2 = this.zze;
                                                zzak(zzajVar2);
                                                zzajVar2.zzg();
                                                zzajVar2.zzY();
                                                Preconditions.checkArgument(iZze2 <= 0);
                                                Preconditions.checkArgument(iMax <= 0);
                                                Preconditions.checkNotEmpty(strZzr);
                                                cursorQuery = zzajVar2.zzh().query("queue", new String[]{"rowid", "data", "retry_count"}, "app_id=?", new String[]{strZzr}, null, null, "rowid", String.valueOf(iZze2));
                                                try {
                                                    try {
                                                        if (cursorQuery.moveToFirst()) {
                                                        }
                                                    } catch (SQLiteException e4) {
                                                        e = e4;
                                                        j = jCurrentTimeMillis;
                                                    }
                                                    cursorRawQuery = cursor4;
                                                    str4 = str;
                                                    if (!listEmptyList.isEmpty()) {
                                                    }
                                                    zzajVar = null;
                                                    this.zzv = false;
                                                    zzac();
                                                } catch (Throwable th3) {
                                                    th = th3;
                                                    cursor3 = cursorQuery;
                                                    if (cursor3 != null) {
                                                        cursor3.close();
                                                    }
                                                    throw th;
                                                }
                                            }
                                        } catch (Throwable th4) {
                                            th = th4;
                                            cursor6 = cursorRawQuery2;
                                            if (cursor6 != null) {
                                                cursor6.close();
                                            }
                                            throw th;
                                        }
                                    } catch (SQLiteException e5) {
                                        e = e5;
                                        cursorRawQuery2 = null;
                                    } catch (Throwable th5) {
                                        th = th5;
                                        if (cursor6 != null) {
                                        }
                                        throw th;
                                    }
                                    if (cursorRawQuery2.moveToFirst()) {
                                        j2 = cursorRawQuery2.getLong(0);
                                        if (cursorRawQuery2 != null) {
                                        }
                                        this.zzA = j2;
                                    } else {
                                        if (cursorRawQuery2 != null) {
                                            cursorRawQuery2.close();
                                        }
                                        this.zzA = j2;
                                    }
                                }
                                int iZze22 = zzg().zze(strZzr, zzdy.zzf);
                                int iMax2 = Math.max(0, zzg().zze(strZzr, zzdy.zzg));
                                zzajVar2 = this.zze;
                                zzak(zzajVar2);
                                zzajVar2.zzg();
                                zzajVar2.zzY();
                                Preconditions.checkArgument(iZze22 <= 0);
                                Preconditions.checkArgument(iMax2 <= 0);
                                Preconditions.checkNotEmpty(strZzr);
                                try {
                                    cursorQuery = zzajVar2.zzh().query("queue", new String[]{"rowid", "data", "retry_count"}, "app_id=?", new String[]{strZzr}, null, null, "rowid", String.valueOf(iZze22));
                                    if (cursorQuery.moveToFirst()) {
                                        listEmptyList = Collections.emptyList();
                                        if (cursorQuery != null) {
                                            cursorQuery.close();
                                        }
                                        j = jCurrentTimeMillis;
                                    } else {
                                        ArrayList arrayList2 = new ArrayList();
                                        int length = 0;
                                        while (true) {
                                            long j3 = cursorQuery.getLong(i3);
                                            try {
                                                byte[] blob = cursorQuery.getBlob(i2);
                                                zzku zzkuVar = zzajVar2.zzf.zzi;
                                                zzak(zzkuVar);
                                                try {
                                                    byteArrayInputStream = new ByteArrayInputStream(blob);
                                                    GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                                                    byteArrayOutputStream = new ByteArrayOutputStream();
                                                    byte[] bArr = new byte[1024];
                                                    j = jCurrentTimeMillis;
                                                    while (true) {
                                                        try {
                                                            try {
                                                                int i5 = gZIPInputStream.read(bArr);
                                                                if (i5 <= 0) {
                                                                    break;
                                                                } else {
                                                                    byteArrayOutputStream.write(bArr, 0, i5);
                                                                }
                                                            } catch (SQLiteException e6) {
                                                                e = e6;
                                                                ?? r3 = "Error querying bundles. appId";
                                                                zzajVar2.zzs.zzay().zzd().zzc("Error querying bundles. appId", zzel.zzn(strZzr), e);
                                                                listEmptyList = Collections.emptyList();
                                                                cursor4 = r3;
                                                                str = byteArrayInputStream;
                                                                if (cursorQuery != null) {
                                                                    cursorQuery.close();
                                                                    cursor4 = r3;
                                                                    str = byteArrayInputStream;
                                                                }
                                                                cursorRawQuery = cursor4;
                                                                str4 = str;
                                                                if (!listEmptyList.isEmpty()) {
                                                                }
                                                                zzajVar = null;
                                                                this.zzv = false;
                                                                zzac();
                                                            }
                                                        } catch (IOException e7) {
                                                            e = e7;
                                                            try {
                                                                zzkuVar.zzs.zzay().zzd().zzb("Failed to ungzip content", e);
                                                                throw e;
                                                            } catch (IOException e8) {
                                                                e = e8;
                                                                zzajVar2.zzs.zzay().zzd().zzc("Failed to unzip queued bundle. appId", zzel.zzn(strZzr), e);
                                                                byteArrayOutputStream = "Failed to unzip queued bundle. appId";
                                                                byteArrayInputStream = byteArrayInputStream;
                                                                if (cursorQuery.moveToNext()) {
                                                                    break;
                                                                } else {
                                                                    break;
                                                                }
                                                                if (cursorQuery != null) {
                                                                }
                                                                listEmptyList = arrayList2;
                                                                cursor4 = byteArrayOutputStream;
                                                                str = byteArrayInputStream;
                                                                cursorRawQuery = cursor4;
                                                                str4 = str;
                                                                if (!listEmptyList.isEmpty()) {
                                                                }
                                                                zzajVar = null;
                                                                this.zzv = false;
                                                                zzac();
                                                            }
                                                        }
                                                    }
                                                    gZIPInputStream.close();
                                                    byteArrayInputStream.close();
                                                    byteArray = byteArrayOutputStream.toByteArray();
                                                } catch (IOException e9) {
                                                    e = e9;
                                                    j = jCurrentTimeMillis;
                                                }
                                            } catch (IOException e10) {
                                                e = e10;
                                                j = jCurrentTimeMillis;
                                            }
                                            if (!arrayList2.isEmpty() && byteArray.length + length > iMax2) {
                                                break;
                                            }
                                            try {
                                                com.google.android.gms.internal.measurement.zzfx zzfxVar = (com.google.android.gms.internal.measurement.zzfx) zzku.zzl(com.google.android.gms.internal.measurement.zzfy.zzu(), byteArray);
                                                byteArrayOutputStream = 2;
                                                if (!cursorQuery.isNull(2)) {
                                                    zzfxVar.zzac(cursorQuery.getInt(2));
                                                }
                                                length += byteArray.length;
                                                arrayList2.add(Pair.create(zzfxVar.zzaA(), Long.valueOf(j3)));
                                                byteArrayInputStream = byteArrayInputStream;
                                            } catch (IOException e11) {
                                                zzajVar2.zzs.zzay().zzd().zzc("Failed to merge queued bundle. appId", zzel.zzn(strZzr), e11);
                                                byteArrayOutputStream = "Failed to merge queued bundle. appId";
                                                byteArrayInputStream = byteArrayInputStream;
                                            }
                                            if (cursorQuery.moveToNext() || length > iMax2) {
                                                break;
                                                break;
                                            }
                                            jCurrentTimeMillis = j;
                                            i2 = 1;
                                            i3 = 0;
                                            byteArrayInputStream = 0;
                                        }
                                        if (cursorQuery != null) {
                                            cursorQuery.close();
                                        }
                                        listEmptyList = arrayList2;
                                        cursor4 = byteArrayOutputStream;
                                        str = byteArrayInputStream;
                                    }
                                } catch (SQLiteException e12) {
                                    e = e12;
                                    j = jCurrentTimeMillis;
                                    cursorQuery = null;
                                } catch (Throwable th6) {
                                    th = th6;
                                    cursor3 = null;
                                }
                                cursorRawQuery = cursor4;
                                str4 = str;
                                if (!listEmptyList.isEmpty()) {
                                    if (zzh(strZzr).zzj()) {
                                        Iterator it = listEmptyList.iterator();
                                        while (true) {
                                            if (!it.hasNext()) {
                                                strZzL = null;
                                                break;
                                            }
                                            com.google.android.gms.internal.measurement.zzfy zzfyVar = (com.google.android.gms.internal.measurement.zzfy) ((Pair) it.next()).first;
                                            if (!TextUtils.isEmpty(zzfyVar.zzL())) {
                                                strZzL = zzfyVar.zzL();
                                                break;
                                            }
                                        }
                                        if (strZzL != null) {
                                            int i6 = 0;
                                            while (true) {
                                                if (i6 >= listEmptyList.size()) {
                                                    break;
                                                }
                                                com.google.android.gms.internal.measurement.zzfy zzfyVar2 = (com.google.android.gms.internal.measurement.zzfy) ((Pair) listEmptyList.get(i6)).first;
                                                if (!TextUtils.isEmpty(zzfyVar2.zzL()) && !zzfyVar2.zzL().equals(strZzL)) {
                                                    break;
                                                }
                                                i6++;
                                            }
                                            zzfvVarZza = com.google.android.gms.internal.measurement.zzfw.zza();
                                            size = listEmptyList.size();
                                            arrayList = new ArrayList(listEmptyList.size());
                                            boolean z2 = !zzg().zzt(strZzr) && zzh(strZzr).zzj();
                                            boolean zZzj = zzh(strZzr).zzj();
                                            boolean zZzk = zzh(strZzr).zzk();
                                            i = 0;
                                            while (i < size) {
                                                com.google.android.gms.internal.measurement.zzfx zzfxVarZzbv = ((com.google.android.gms.internal.measurement.zzfy) ((Pair) listEmptyList.get(i)).first).zzbv();
                                                arrayList.add((Long) ((Pair) listEmptyList.get(i)).second);
                                                zzg().zzh();
                                                zzfxVarZzbv.zzah(46000L);
                                                long j4 = j;
                                                zzfxVarZzbv.zzag(j4);
                                                this.zzn.zzaw();
                                                try {
                                                    zzfxVarZzbv.zzad(false);
                                                    if (!z2) {
                                                        zzfxVarZzbv.zzo();
                                                    }
                                                    if (!zZzj) {
                                                        zzfxVarZzbv.zzu();
                                                        zzfxVarZzbv.zzr();
                                                    }
                                                    if (!zZzk) {
                                                        zzfxVarZzbv.zzm();
                                                    }
                                                    if (zzg().zzs(strZzr, zzdy.zzV)) {
                                                        byte[] bArrZzbs = zzfxVarZzbv.zzaA().zzbs();
                                                        zzku zzkuVar2 = this.zzi;
                                                        zzak(zzkuVar2);
                                                        zzfxVarZzbv.zzG(zzkuVar2.zzd(bArrZzbs));
                                                    }
                                                    zzfvVarZza.zza(zzfxVarZzbv);
                                                    i++;
                                                    j = j4;
                                                } catch (Throwable th7) {
                                                    th = th7;
                                                    z = false;
                                                    this.zzv = z;
                                                    zzac();
                                                    throw th;
                                                }
                                            }
                                            long j5 = j;
                                            if (Log.isLoggable(zzay().zzq(), 2)) {
                                                strZzm = null;
                                            } else {
                                                zzku zzkuVar3 = this.zzi;
                                                zzak(zzkuVar3);
                                                strZzm = zzkuVar3.zzm(zzfvVarZza.zzaA());
                                            }
                                            zzak(this.zzi);
                                            byte[] bArrZzbs2 = zzfvVarZza.zzaA().zzbs();
                                            zzg();
                                            str4 = null;
                                            str4 = null;
                                            strZza = zzdy.zzp.zza(null);
                                            try {
                                                URL url = new URL(strZza);
                                                Preconditions.checkArgument(!arrayList.isEmpty());
                                                if (this.zzy == null) {
                                                    zzay().zzd().zza("Set uploading progress before finishing the previous upload");
                                                } else {
                                                    this.zzy = new ArrayList(arrayList);
                                                }
                                                this.zzk.zzd.zzb(j5);
                                                zzay().zzj().zzd("Uploading data. app, uncompressed size, data", size > 0 ? zzfvVarZza.zzb(0).zzy() : "?", Integer.valueOf(bArrZzbs2.length), strZzm);
                                                this.zzu = true;
                                                zzer zzerVar2 = this.zzd;
                                                zzak(zzerVar2);
                                                zzkl zzklVar = new zzkl(this, strZzr);
                                                zzerVar2.zzg();
                                                zzerVar2.zzY();
                                                Preconditions.checkNotNull(url);
                                                Preconditions.checkNotNull(bArrZzbs2);
                                                Preconditions.checkNotNull(zzklVar);
                                                ?? Zzaz = zzerVar2.zzs.zzaz();
                                                ?? zzeqVar = new zzeq(zzerVar2, strZzr, url, bArrZzbs2, null, zzklVar);
                                                Zzaz.zzo(zzeqVar);
                                                cursorRawQuery = zzeqVar;
                                            } catch (MalformedURLException unused) {
                                                ?? Zzd = zzay().zzd();
                                                ?? Zzn = zzel.zzn(strZzr);
                                                Zzd.zzc("Failed to parse upload URL. Not uploading. appId", Zzn, strZza);
                                                cursorRawQuery = Zzn;
                                            }
                                        } else {
                                            zzfvVarZza = com.google.android.gms.internal.measurement.zzfw.zza();
                                            size = listEmptyList.size();
                                            arrayList = new ArrayList(listEmptyList.size());
                                            if (zzg().zzt(strZzr)) {
                                                boolean zZzj2 = zzh(strZzr).zzj();
                                                boolean zZzk2 = zzh(strZzr).zzk();
                                                i = 0;
                                                while (i < size) {
                                                }
                                                long j52 = j;
                                                if (Log.isLoggable(zzay().zzq(), 2)) {
                                                }
                                                zzak(this.zzi);
                                                byte[] bArrZzbs22 = zzfvVarZza.zzaA().zzbs();
                                                zzg();
                                                str4 = null;
                                                str4 = null;
                                                strZza = zzdy.zzp.zza(null);
                                                URL url2 = new URL(strZza);
                                                Preconditions.checkArgument(!arrayList.isEmpty());
                                                if (this.zzy == null) {
                                                }
                                                this.zzk.zzd.zzb(j52);
                                                zzay().zzj().zzd("Uploading data. app, uncompressed size, data", size > 0 ? zzfvVarZza.zzb(0).zzy() : "?", Integer.valueOf(bArrZzbs22.length), strZzm);
                                                this.zzu = true;
                                                zzer zzerVar22 = this.zzd;
                                                zzak(zzerVar22);
                                                zzkl zzklVar2 = new zzkl(this, strZzr);
                                                zzerVar22.zzg();
                                                zzerVar22.zzY();
                                                Preconditions.checkNotNull(url2);
                                                Preconditions.checkNotNull(bArrZzbs22);
                                                Preconditions.checkNotNull(zzklVar2);
                                                ?? Zzaz2 = zzerVar22.zzs.zzaz();
                                                ?? zzeqVar2 = new zzeq(zzerVar22, strZzr, url2, bArrZzbs22, null, zzklVar2);
                                                Zzaz2.zzo(zzeqVar2);
                                                cursorRawQuery = zzeqVar2;
                                            }
                                        }
                                    }
                                }
                                zzajVar = null;
                                this.zzv = false;
                            }
                        } catch (Throwable th8) {
                            th = th8;
                            z = false;
                            this.zzv = z;
                            zzac();
                            throw th;
                        }
                    } else {
                        zzay().zzj().zza("Network not connected, ignoring upload request");
                        zzaf();
                        this.zzv = false;
                    }
                }
            }
            zzac();
        } catch (Throwable th9) {
            th = th9;
            z = false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x02f5 A[Catch: all -> 0x0ae3, TryCatch #3 {all -> 0x0ae3, blocks: (B:28:0x0124, B:30:0x0136, B:32:0x0142, B:33:0x014e, B:36:0x015c, B:38:0x0166, B:43:0x0172, B:103:0x032c, B:112:0x0362, B:114:0x03a2, B:116:0x03a8, B:117:0x03bf, B:121:0x03d2, B:123:0x03e9, B:125:0x03ef, B:126:0x0406, B:131:0x0430, B:135:0x0451, B:136:0x0468, B:139:0x0479, B:142:0x0496, B:143:0x04aa, B:145:0x04b4, B:147:0x04c3, B:149:0x04c9, B:150:0x04d2, B:151:0x04e0, B:153:0x04f5, B:155:0x050a, B:167:0x0536, B:168:0x054b, B:170:0x0575, B:173:0x058d, B:176:0x05d0, B:178:0x05fc, B:180:0x063b, B:181:0x0640, B:183:0x0648, B:184:0x064d, B:186:0x0655, B:187:0x065a, B:189:0x0663, B:190:0x0667, B:192:0x0674, B:193:0x0679, B:195:0x06a7, B:197:0x06b1, B:199:0x06b9, B:200:0x06be, B:202:0x06c8, B:204:0x06d2, B:206:0x06da, B:212:0x06f7, B:214:0x06ff, B:215:0x0702, B:217:0x071a, B:220:0x0722, B:221:0x073b, B:223:0x0741, B:225:0x0755, B:227:0x0761, B:229:0x076e, B:233:0x0788, B:234:0x0798, B:238:0x07a1, B:239:0x07a4, B:241:0x07c0, B:243:0x07d2, B:245:0x07d6, B:247:0x07e1, B:248:0x07ec, B:250:0x082f, B:251:0x0834, B:253:0x083c, B:255:0x0845, B:256:0x0848, B:258:0x0855, B:260:0x0875, B:261:0x0880, B:263:0x08b5, B:264:0x08ba, B:265:0x08c7, B:267:0x08cd, B:269:0x08d7, B:270:0x08e4, B:272:0x08ee, B:273:0x08fb, B:274:0x0908, B:276:0x090e, B:278:0x093e, B:279:0x0984, B:280:0x098e, B:281:0x099a, B:283:0x09a0, B:292:0x09ee, B:293:0x0a3c, B:295:0x0a4c, B:309:0x0ab0, B:298:0x0a64, B:300:0x0a68, B:286:0x09ac, B:288:0x09d8, B:304:0x0a81, B:305:0x0a98, B:308:0x0a9b, B:207:0x06e0, B:209:0x06ea, B:211:0x06f2, B:177:0x05ee, B:164:0x051b, B:106:0x0342, B:107:0x0349, B:109:0x034f, B:111:0x035b, B:49:0x0186, B:52:0x0192, B:54:0x01a9, B:60:0x01c7, B:68:0x0207, B:70:0x020d, B:72:0x021b, B:74:0x0227, B:76:0x0231, B:78:0x023c, B:81:0x0243, B:99:0x02ea, B:101:0x02f5, B:82:0x0271, B:83:0x028e, B:85:0x0295, B:87:0x02a6, B:98:0x02ce, B:97:0x02bb, B:75:0x022c, B:63:0x01d5, B:67:0x01fd), top: B:322:0x0124, inners: #0, #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0342 A[Catch: all -> 0x0ae3, TryCatch #3 {all -> 0x0ae3, blocks: (B:28:0x0124, B:30:0x0136, B:32:0x0142, B:33:0x014e, B:36:0x015c, B:38:0x0166, B:43:0x0172, B:103:0x032c, B:112:0x0362, B:114:0x03a2, B:116:0x03a8, B:117:0x03bf, B:121:0x03d2, B:123:0x03e9, B:125:0x03ef, B:126:0x0406, B:131:0x0430, B:135:0x0451, B:136:0x0468, B:139:0x0479, B:142:0x0496, B:143:0x04aa, B:145:0x04b4, B:147:0x04c3, B:149:0x04c9, B:150:0x04d2, B:151:0x04e0, B:153:0x04f5, B:155:0x050a, B:167:0x0536, B:168:0x054b, B:170:0x0575, B:173:0x058d, B:176:0x05d0, B:178:0x05fc, B:180:0x063b, B:181:0x0640, B:183:0x0648, B:184:0x064d, B:186:0x0655, B:187:0x065a, B:189:0x0663, B:190:0x0667, B:192:0x0674, B:193:0x0679, B:195:0x06a7, B:197:0x06b1, B:199:0x06b9, B:200:0x06be, B:202:0x06c8, B:204:0x06d2, B:206:0x06da, B:212:0x06f7, B:214:0x06ff, B:215:0x0702, B:217:0x071a, B:220:0x0722, B:221:0x073b, B:223:0x0741, B:225:0x0755, B:227:0x0761, B:229:0x076e, B:233:0x0788, B:234:0x0798, B:238:0x07a1, B:239:0x07a4, B:241:0x07c0, B:243:0x07d2, B:245:0x07d6, B:247:0x07e1, B:248:0x07ec, B:250:0x082f, B:251:0x0834, B:253:0x083c, B:255:0x0845, B:256:0x0848, B:258:0x0855, B:260:0x0875, B:261:0x0880, B:263:0x08b5, B:264:0x08ba, B:265:0x08c7, B:267:0x08cd, B:269:0x08d7, B:270:0x08e4, B:272:0x08ee, B:273:0x08fb, B:274:0x0908, B:276:0x090e, B:278:0x093e, B:279:0x0984, B:280:0x098e, B:281:0x099a, B:283:0x09a0, B:292:0x09ee, B:293:0x0a3c, B:295:0x0a4c, B:309:0x0ab0, B:298:0x0a64, B:300:0x0a68, B:286:0x09ac, B:288:0x09d8, B:304:0x0a81, B:305:0x0a98, B:308:0x0a9b, B:207:0x06e0, B:209:0x06ea, B:211:0x06f2, B:177:0x05ee, B:164:0x051b, B:106:0x0342, B:107:0x0349, B:109:0x034f, B:111:0x035b, B:49:0x0186, B:52:0x0192, B:54:0x01a9, B:60:0x01c7, B:68:0x0207, B:70:0x020d, B:72:0x021b, B:74:0x0227, B:76:0x0231, B:78:0x023c, B:81:0x0243, B:99:0x02ea, B:101:0x02f5, B:82:0x0271, B:83:0x028e, B:85:0x0295, B:87:0x02a6, B:98:0x02ce, B:97:0x02bb, B:75:0x022c, B:63:0x01d5, B:67:0x01fd), top: B:322:0x0124, inners: #0, #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x03a2 A[Catch: all -> 0x0ae3, TryCatch #3 {all -> 0x0ae3, blocks: (B:28:0x0124, B:30:0x0136, B:32:0x0142, B:33:0x014e, B:36:0x015c, B:38:0x0166, B:43:0x0172, B:103:0x032c, B:112:0x0362, B:114:0x03a2, B:116:0x03a8, B:117:0x03bf, B:121:0x03d2, B:123:0x03e9, B:125:0x03ef, B:126:0x0406, B:131:0x0430, B:135:0x0451, B:136:0x0468, B:139:0x0479, B:142:0x0496, B:143:0x04aa, B:145:0x04b4, B:147:0x04c3, B:149:0x04c9, B:150:0x04d2, B:151:0x04e0, B:153:0x04f5, B:155:0x050a, B:167:0x0536, B:168:0x054b, B:170:0x0575, B:173:0x058d, B:176:0x05d0, B:178:0x05fc, B:180:0x063b, B:181:0x0640, B:183:0x0648, B:184:0x064d, B:186:0x0655, B:187:0x065a, B:189:0x0663, B:190:0x0667, B:192:0x0674, B:193:0x0679, B:195:0x06a7, B:197:0x06b1, B:199:0x06b9, B:200:0x06be, B:202:0x06c8, B:204:0x06d2, B:206:0x06da, B:212:0x06f7, B:214:0x06ff, B:215:0x0702, B:217:0x071a, B:220:0x0722, B:221:0x073b, B:223:0x0741, B:225:0x0755, B:227:0x0761, B:229:0x076e, B:233:0x0788, B:234:0x0798, B:238:0x07a1, B:239:0x07a4, B:241:0x07c0, B:243:0x07d2, B:245:0x07d6, B:247:0x07e1, B:248:0x07ec, B:250:0x082f, B:251:0x0834, B:253:0x083c, B:255:0x0845, B:256:0x0848, B:258:0x0855, B:260:0x0875, B:261:0x0880, B:263:0x08b5, B:264:0x08ba, B:265:0x08c7, B:267:0x08cd, B:269:0x08d7, B:270:0x08e4, B:272:0x08ee, B:273:0x08fb, B:274:0x0908, B:276:0x090e, B:278:0x093e, B:279:0x0984, B:280:0x098e, B:281:0x099a, B:283:0x09a0, B:292:0x09ee, B:293:0x0a3c, B:295:0x0a4c, B:309:0x0ab0, B:298:0x0a64, B:300:0x0a68, B:286:0x09ac, B:288:0x09d8, B:304:0x0a81, B:305:0x0a98, B:308:0x0a9b, B:207:0x06e0, B:209:0x06ea, B:211:0x06f2, B:177:0x05ee, B:164:0x051b, B:106:0x0342, B:107:0x0349, B:109:0x034f, B:111:0x035b, B:49:0x0186, B:52:0x0192, B:54:0x01a9, B:60:0x01c7, B:68:0x0207, B:70:0x020d, B:72:0x021b, B:74:0x0227, B:76:0x0231, B:78:0x023c, B:81:0x0243, B:99:0x02ea, B:101:0x02f5, B:82:0x0271, B:83:0x028e, B:85:0x0295, B:87:0x02a6, B:98:0x02ce, B:97:0x02bb, B:75:0x022c, B:63:0x01d5, B:67:0x01fd), top: B:322:0x0124, inners: #0, #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0536 A[Catch: all -> 0x0ae3, TryCatch #3 {all -> 0x0ae3, blocks: (B:28:0x0124, B:30:0x0136, B:32:0x0142, B:33:0x014e, B:36:0x015c, B:38:0x0166, B:43:0x0172, B:103:0x032c, B:112:0x0362, B:114:0x03a2, B:116:0x03a8, B:117:0x03bf, B:121:0x03d2, B:123:0x03e9, B:125:0x03ef, B:126:0x0406, B:131:0x0430, B:135:0x0451, B:136:0x0468, B:139:0x0479, B:142:0x0496, B:143:0x04aa, B:145:0x04b4, B:147:0x04c3, B:149:0x04c9, B:150:0x04d2, B:151:0x04e0, B:153:0x04f5, B:155:0x050a, B:167:0x0536, B:168:0x054b, B:170:0x0575, B:173:0x058d, B:176:0x05d0, B:178:0x05fc, B:180:0x063b, B:181:0x0640, B:183:0x0648, B:184:0x064d, B:186:0x0655, B:187:0x065a, B:189:0x0663, B:190:0x0667, B:192:0x0674, B:193:0x0679, B:195:0x06a7, B:197:0x06b1, B:199:0x06b9, B:200:0x06be, B:202:0x06c8, B:204:0x06d2, B:206:0x06da, B:212:0x06f7, B:214:0x06ff, B:215:0x0702, B:217:0x071a, B:220:0x0722, B:221:0x073b, B:223:0x0741, B:225:0x0755, B:227:0x0761, B:229:0x076e, B:233:0x0788, B:234:0x0798, B:238:0x07a1, B:239:0x07a4, B:241:0x07c0, B:243:0x07d2, B:245:0x07d6, B:247:0x07e1, B:248:0x07ec, B:250:0x082f, B:251:0x0834, B:253:0x083c, B:255:0x0845, B:256:0x0848, B:258:0x0855, B:260:0x0875, B:261:0x0880, B:263:0x08b5, B:264:0x08ba, B:265:0x08c7, B:267:0x08cd, B:269:0x08d7, B:270:0x08e4, B:272:0x08ee, B:273:0x08fb, B:274:0x0908, B:276:0x090e, B:278:0x093e, B:279:0x0984, B:280:0x098e, B:281:0x099a, B:283:0x09a0, B:292:0x09ee, B:293:0x0a3c, B:295:0x0a4c, B:309:0x0ab0, B:298:0x0a64, B:300:0x0a68, B:286:0x09ac, B:288:0x09d8, B:304:0x0a81, B:305:0x0a98, B:308:0x0a9b, B:207:0x06e0, B:209:0x06ea, B:211:0x06f2, B:177:0x05ee, B:164:0x051b, B:106:0x0342, B:107:0x0349, B:109:0x034f, B:111:0x035b, B:49:0x0186, B:52:0x0192, B:54:0x01a9, B:60:0x01c7, B:68:0x0207, B:70:0x020d, B:72:0x021b, B:74:0x0227, B:76:0x0231, B:78:0x023c, B:81:0x0243, B:99:0x02ea, B:101:0x02f5, B:82:0x0271, B:83:0x028e, B:85:0x0295, B:87:0x02a6, B:98:0x02ce, B:97:0x02bb, B:75:0x022c, B:63:0x01d5, B:67:0x01fd), top: B:322:0x0124, inners: #0, #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0575 A[Catch: all -> 0x0ae3, TryCatch #3 {all -> 0x0ae3, blocks: (B:28:0x0124, B:30:0x0136, B:32:0x0142, B:33:0x014e, B:36:0x015c, B:38:0x0166, B:43:0x0172, B:103:0x032c, B:112:0x0362, B:114:0x03a2, B:116:0x03a8, B:117:0x03bf, B:121:0x03d2, B:123:0x03e9, B:125:0x03ef, B:126:0x0406, B:131:0x0430, B:135:0x0451, B:136:0x0468, B:139:0x0479, B:142:0x0496, B:143:0x04aa, B:145:0x04b4, B:147:0x04c3, B:149:0x04c9, B:150:0x04d2, B:151:0x04e0, B:153:0x04f5, B:155:0x050a, B:167:0x0536, B:168:0x054b, B:170:0x0575, B:173:0x058d, B:176:0x05d0, B:178:0x05fc, B:180:0x063b, B:181:0x0640, B:183:0x0648, B:184:0x064d, B:186:0x0655, B:187:0x065a, B:189:0x0663, B:190:0x0667, B:192:0x0674, B:193:0x0679, B:195:0x06a7, B:197:0x06b1, B:199:0x06b9, B:200:0x06be, B:202:0x06c8, B:204:0x06d2, B:206:0x06da, B:212:0x06f7, B:214:0x06ff, B:215:0x0702, B:217:0x071a, B:220:0x0722, B:221:0x073b, B:223:0x0741, B:225:0x0755, B:227:0x0761, B:229:0x076e, B:233:0x0788, B:234:0x0798, B:238:0x07a1, B:239:0x07a4, B:241:0x07c0, B:243:0x07d2, B:245:0x07d6, B:247:0x07e1, B:248:0x07ec, B:250:0x082f, B:251:0x0834, B:253:0x083c, B:255:0x0845, B:256:0x0848, B:258:0x0855, B:260:0x0875, B:261:0x0880, B:263:0x08b5, B:264:0x08ba, B:265:0x08c7, B:267:0x08cd, B:269:0x08d7, B:270:0x08e4, B:272:0x08ee, B:273:0x08fb, B:274:0x0908, B:276:0x090e, B:278:0x093e, B:279:0x0984, B:280:0x098e, B:281:0x099a, B:283:0x09a0, B:292:0x09ee, B:293:0x0a3c, B:295:0x0a4c, B:309:0x0ab0, B:298:0x0a64, B:300:0x0a68, B:286:0x09ac, B:288:0x09d8, B:304:0x0a81, B:305:0x0a98, B:308:0x0a9b, B:207:0x06e0, B:209:0x06ea, B:211:0x06f2, B:177:0x05ee, B:164:0x051b, B:106:0x0342, B:107:0x0349, B:109:0x034f, B:111:0x035b, B:49:0x0186, B:52:0x0192, B:54:0x01a9, B:60:0x01c7, B:68:0x0207, B:70:0x020d, B:72:0x021b, B:74:0x0227, B:76:0x0231, B:78:0x023c, B:81:0x0243, B:99:0x02ea, B:101:0x02f5, B:82:0x0271, B:83:0x028e, B:85:0x0295, B:87:0x02a6, B:98:0x02ce, B:97:0x02bb, B:75:0x022c, B:63:0x01d5, B:67:0x01fd), top: B:322:0x0124, inners: #0, #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:177:0x05ee A[Catch: all -> 0x0ae3, TryCatch #3 {all -> 0x0ae3, blocks: (B:28:0x0124, B:30:0x0136, B:32:0x0142, B:33:0x014e, B:36:0x015c, B:38:0x0166, B:43:0x0172, B:103:0x032c, B:112:0x0362, B:114:0x03a2, B:116:0x03a8, B:117:0x03bf, B:121:0x03d2, B:123:0x03e9, B:125:0x03ef, B:126:0x0406, B:131:0x0430, B:135:0x0451, B:136:0x0468, B:139:0x0479, B:142:0x0496, B:143:0x04aa, B:145:0x04b4, B:147:0x04c3, B:149:0x04c9, B:150:0x04d2, B:151:0x04e0, B:153:0x04f5, B:155:0x050a, B:167:0x0536, B:168:0x054b, B:170:0x0575, B:173:0x058d, B:176:0x05d0, B:178:0x05fc, B:180:0x063b, B:181:0x0640, B:183:0x0648, B:184:0x064d, B:186:0x0655, B:187:0x065a, B:189:0x0663, B:190:0x0667, B:192:0x0674, B:193:0x0679, B:195:0x06a7, B:197:0x06b1, B:199:0x06b9, B:200:0x06be, B:202:0x06c8, B:204:0x06d2, B:206:0x06da, B:212:0x06f7, B:214:0x06ff, B:215:0x0702, B:217:0x071a, B:220:0x0722, B:221:0x073b, B:223:0x0741, B:225:0x0755, B:227:0x0761, B:229:0x076e, B:233:0x0788, B:234:0x0798, B:238:0x07a1, B:239:0x07a4, B:241:0x07c0, B:243:0x07d2, B:245:0x07d6, B:247:0x07e1, B:248:0x07ec, B:250:0x082f, B:251:0x0834, B:253:0x083c, B:255:0x0845, B:256:0x0848, B:258:0x0855, B:260:0x0875, B:261:0x0880, B:263:0x08b5, B:264:0x08ba, B:265:0x08c7, B:267:0x08cd, B:269:0x08d7, B:270:0x08e4, B:272:0x08ee, B:273:0x08fb, B:274:0x0908, B:276:0x090e, B:278:0x093e, B:279:0x0984, B:280:0x098e, B:281:0x099a, B:283:0x09a0, B:292:0x09ee, B:293:0x0a3c, B:295:0x0a4c, B:309:0x0ab0, B:298:0x0a64, B:300:0x0a68, B:286:0x09ac, B:288:0x09d8, B:304:0x0a81, B:305:0x0a98, B:308:0x0a9b, B:207:0x06e0, B:209:0x06ea, B:211:0x06f2, B:177:0x05ee, B:164:0x051b, B:106:0x0342, B:107:0x0349, B:109:0x034f, B:111:0x035b, B:49:0x0186, B:52:0x0192, B:54:0x01a9, B:60:0x01c7, B:68:0x0207, B:70:0x020d, B:72:0x021b, B:74:0x0227, B:76:0x0231, B:78:0x023c, B:81:0x0243, B:99:0x02ea, B:101:0x02f5, B:82:0x0271, B:83:0x028e, B:85:0x0295, B:87:0x02a6, B:98:0x02ce, B:97:0x02bb, B:75:0x022c, B:63:0x01d5, B:67:0x01fd), top: B:322:0x0124, inners: #0, #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:180:0x063b A[Catch: all -> 0x0ae3, TryCatch #3 {all -> 0x0ae3, blocks: (B:28:0x0124, B:30:0x0136, B:32:0x0142, B:33:0x014e, B:36:0x015c, B:38:0x0166, B:43:0x0172, B:103:0x032c, B:112:0x0362, B:114:0x03a2, B:116:0x03a8, B:117:0x03bf, B:121:0x03d2, B:123:0x03e9, B:125:0x03ef, B:126:0x0406, B:131:0x0430, B:135:0x0451, B:136:0x0468, B:139:0x0479, B:142:0x0496, B:143:0x04aa, B:145:0x04b4, B:147:0x04c3, B:149:0x04c9, B:150:0x04d2, B:151:0x04e0, B:153:0x04f5, B:155:0x050a, B:167:0x0536, B:168:0x054b, B:170:0x0575, B:173:0x058d, B:176:0x05d0, B:178:0x05fc, B:180:0x063b, B:181:0x0640, B:183:0x0648, B:184:0x064d, B:186:0x0655, B:187:0x065a, B:189:0x0663, B:190:0x0667, B:192:0x0674, B:193:0x0679, B:195:0x06a7, B:197:0x06b1, B:199:0x06b9, B:200:0x06be, B:202:0x06c8, B:204:0x06d2, B:206:0x06da, B:212:0x06f7, B:214:0x06ff, B:215:0x0702, B:217:0x071a, B:220:0x0722, B:221:0x073b, B:223:0x0741, B:225:0x0755, B:227:0x0761, B:229:0x076e, B:233:0x0788, B:234:0x0798, B:238:0x07a1, B:239:0x07a4, B:241:0x07c0, B:243:0x07d2, B:245:0x07d6, B:247:0x07e1, B:248:0x07ec, B:250:0x082f, B:251:0x0834, B:253:0x083c, B:255:0x0845, B:256:0x0848, B:258:0x0855, B:260:0x0875, B:261:0x0880, B:263:0x08b5, B:264:0x08ba, B:265:0x08c7, B:267:0x08cd, B:269:0x08d7, B:270:0x08e4, B:272:0x08ee, B:273:0x08fb, B:274:0x0908, B:276:0x090e, B:278:0x093e, B:279:0x0984, B:280:0x098e, B:281:0x099a, B:283:0x09a0, B:292:0x09ee, B:293:0x0a3c, B:295:0x0a4c, B:309:0x0ab0, B:298:0x0a64, B:300:0x0a68, B:286:0x09ac, B:288:0x09d8, B:304:0x0a81, B:305:0x0a98, B:308:0x0a9b, B:207:0x06e0, B:209:0x06ea, B:211:0x06f2, B:177:0x05ee, B:164:0x051b, B:106:0x0342, B:107:0x0349, B:109:0x034f, B:111:0x035b, B:49:0x0186, B:52:0x0192, B:54:0x01a9, B:60:0x01c7, B:68:0x0207, B:70:0x020d, B:72:0x021b, B:74:0x0227, B:76:0x0231, B:78:0x023c, B:81:0x0243, B:99:0x02ea, B:101:0x02f5, B:82:0x0271, B:83:0x028e, B:85:0x0295, B:87:0x02a6, B:98:0x02ce, B:97:0x02bb, B:75:0x022c, B:63:0x01d5, B:67:0x01fd), top: B:322:0x0124, inners: #0, #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0648 A[Catch: all -> 0x0ae3, TryCatch #3 {all -> 0x0ae3, blocks: (B:28:0x0124, B:30:0x0136, B:32:0x0142, B:33:0x014e, B:36:0x015c, B:38:0x0166, B:43:0x0172, B:103:0x032c, B:112:0x0362, B:114:0x03a2, B:116:0x03a8, B:117:0x03bf, B:121:0x03d2, B:123:0x03e9, B:125:0x03ef, B:126:0x0406, B:131:0x0430, B:135:0x0451, B:136:0x0468, B:139:0x0479, B:142:0x0496, B:143:0x04aa, B:145:0x04b4, B:147:0x04c3, B:149:0x04c9, B:150:0x04d2, B:151:0x04e0, B:153:0x04f5, B:155:0x050a, B:167:0x0536, B:168:0x054b, B:170:0x0575, B:173:0x058d, B:176:0x05d0, B:178:0x05fc, B:180:0x063b, B:181:0x0640, B:183:0x0648, B:184:0x064d, B:186:0x0655, B:187:0x065a, B:189:0x0663, B:190:0x0667, B:192:0x0674, B:193:0x0679, B:195:0x06a7, B:197:0x06b1, B:199:0x06b9, B:200:0x06be, B:202:0x06c8, B:204:0x06d2, B:206:0x06da, B:212:0x06f7, B:214:0x06ff, B:215:0x0702, B:217:0x071a, B:220:0x0722, B:221:0x073b, B:223:0x0741, B:225:0x0755, B:227:0x0761, B:229:0x076e, B:233:0x0788, B:234:0x0798, B:238:0x07a1, B:239:0x07a4, B:241:0x07c0, B:243:0x07d2, B:245:0x07d6, B:247:0x07e1, B:248:0x07ec, B:250:0x082f, B:251:0x0834, B:253:0x083c, B:255:0x0845, B:256:0x0848, B:258:0x0855, B:260:0x0875, B:261:0x0880, B:263:0x08b5, B:264:0x08ba, B:265:0x08c7, B:267:0x08cd, B:269:0x08d7, B:270:0x08e4, B:272:0x08ee, B:273:0x08fb, B:274:0x0908, B:276:0x090e, B:278:0x093e, B:279:0x0984, B:280:0x098e, B:281:0x099a, B:283:0x09a0, B:292:0x09ee, B:293:0x0a3c, B:295:0x0a4c, B:309:0x0ab0, B:298:0x0a64, B:300:0x0a68, B:286:0x09ac, B:288:0x09d8, B:304:0x0a81, B:305:0x0a98, B:308:0x0a9b, B:207:0x06e0, B:209:0x06ea, B:211:0x06f2, B:177:0x05ee, B:164:0x051b, B:106:0x0342, B:107:0x0349, B:109:0x034f, B:111:0x035b, B:49:0x0186, B:52:0x0192, B:54:0x01a9, B:60:0x01c7, B:68:0x0207, B:70:0x020d, B:72:0x021b, B:74:0x0227, B:76:0x0231, B:78:0x023c, B:81:0x0243, B:99:0x02ea, B:101:0x02f5, B:82:0x0271, B:83:0x028e, B:85:0x0295, B:87:0x02a6, B:98:0x02ce, B:97:0x02bb, B:75:0x022c, B:63:0x01d5, B:67:0x01fd), top: B:322:0x0124, inners: #0, #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0655 A[Catch: all -> 0x0ae3, TryCatch #3 {all -> 0x0ae3, blocks: (B:28:0x0124, B:30:0x0136, B:32:0x0142, B:33:0x014e, B:36:0x015c, B:38:0x0166, B:43:0x0172, B:103:0x032c, B:112:0x0362, B:114:0x03a2, B:116:0x03a8, B:117:0x03bf, B:121:0x03d2, B:123:0x03e9, B:125:0x03ef, B:126:0x0406, B:131:0x0430, B:135:0x0451, B:136:0x0468, B:139:0x0479, B:142:0x0496, B:143:0x04aa, B:145:0x04b4, B:147:0x04c3, B:149:0x04c9, B:150:0x04d2, B:151:0x04e0, B:153:0x04f5, B:155:0x050a, B:167:0x0536, B:168:0x054b, B:170:0x0575, B:173:0x058d, B:176:0x05d0, B:178:0x05fc, B:180:0x063b, B:181:0x0640, B:183:0x0648, B:184:0x064d, B:186:0x0655, B:187:0x065a, B:189:0x0663, B:190:0x0667, B:192:0x0674, B:193:0x0679, B:195:0x06a7, B:197:0x06b1, B:199:0x06b9, B:200:0x06be, B:202:0x06c8, B:204:0x06d2, B:206:0x06da, B:212:0x06f7, B:214:0x06ff, B:215:0x0702, B:217:0x071a, B:220:0x0722, B:221:0x073b, B:223:0x0741, B:225:0x0755, B:227:0x0761, B:229:0x076e, B:233:0x0788, B:234:0x0798, B:238:0x07a1, B:239:0x07a4, B:241:0x07c0, B:243:0x07d2, B:245:0x07d6, B:247:0x07e1, B:248:0x07ec, B:250:0x082f, B:251:0x0834, B:253:0x083c, B:255:0x0845, B:256:0x0848, B:258:0x0855, B:260:0x0875, B:261:0x0880, B:263:0x08b5, B:264:0x08ba, B:265:0x08c7, B:267:0x08cd, B:269:0x08d7, B:270:0x08e4, B:272:0x08ee, B:273:0x08fb, B:274:0x0908, B:276:0x090e, B:278:0x093e, B:279:0x0984, B:280:0x098e, B:281:0x099a, B:283:0x09a0, B:292:0x09ee, B:293:0x0a3c, B:295:0x0a4c, B:309:0x0ab0, B:298:0x0a64, B:300:0x0a68, B:286:0x09ac, B:288:0x09d8, B:304:0x0a81, B:305:0x0a98, B:308:0x0a9b, B:207:0x06e0, B:209:0x06ea, B:211:0x06f2, B:177:0x05ee, B:164:0x051b, B:106:0x0342, B:107:0x0349, B:109:0x034f, B:111:0x035b, B:49:0x0186, B:52:0x0192, B:54:0x01a9, B:60:0x01c7, B:68:0x0207, B:70:0x020d, B:72:0x021b, B:74:0x0227, B:76:0x0231, B:78:0x023c, B:81:0x0243, B:99:0x02ea, B:101:0x02f5, B:82:0x0271, B:83:0x028e, B:85:0x0295, B:87:0x02a6, B:98:0x02ce, B:97:0x02bb, B:75:0x022c, B:63:0x01d5, B:67:0x01fd), top: B:322:0x0124, inners: #0, #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0663 A[Catch: all -> 0x0ae3, TryCatch #3 {all -> 0x0ae3, blocks: (B:28:0x0124, B:30:0x0136, B:32:0x0142, B:33:0x014e, B:36:0x015c, B:38:0x0166, B:43:0x0172, B:103:0x032c, B:112:0x0362, B:114:0x03a2, B:116:0x03a8, B:117:0x03bf, B:121:0x03d2, B:123:0x03e9, B:125:0x03ef, B:126:0x0406, B:131:0x0430, B:135:0x0451, B:136:0x0468, B:139:0x0479, B:142:0x0496, B:143:0x04aa, B:145:0x04b4, B:147:0x04c3, B:149:0x04c9, B:150:0x04d2, B:151:0x04e0, B:153:0x04f5, B:155:0x050a, B:167:0x0536, B:168:0x054b, B:170:0x0575, B:173:0x058d, B:176:0x05d0, B:178:0x05fc, B:180:0x063b, B:181:0x0640, B:183:0x0648, B:184:0x064d, B:186:0x0655, B:187:0x065a, B:189:0x0663, B:190:0x0667, B:192:0x0674, B:193:0x0679, B:195:0x06a7, B:197:0x06b1, B:199:0x06b9, B:200:0x06be, B:202:0x06c8, B:204:0x06d2, B:206:0x06da, B:212:0x06f7, B:214:0x06ff, B:215:0x0702, B:217:0x071a, B:220:0x0722, B:221:0x073b, B:223:0x0741, B:225:0x0755, B:227:0x0761, B:229:0x076e, B:233:0x0788, B:234:0x0798, B:238:0x07a1, B:239:0x07a4, B:241:0x07c0, B:243:0x07d2, B:245:0x07d6, B:247:0x07e1, B:248:0x07ec, B:250:0x082f, B:251:0x0834, B:253:0x083c, B:255:0x0845, B:256:0x0848, B:258:0x0855, B:260:0x0875, B:261:0x0880, B:263:0x08b5, B:264:0x08ba, B:265:0x08c7, B:267:0x08cd, B:269:0x08d7, B:270:0x08e4, B:272:0x08ee, B:273:0x08fb, B:274:0x0908, B:276:0x090e, B:278:0x093e, B:279:0x0984, B:280:0x098e, B:281:0x099a, B:283:0x09a0, B:292:0x09ee, B:293:0x0a3c, B:295:0x0a4c, B:309:0x0ab0, B:298:0x0a64, B:300:0x0a68, B:286:0x09ac, B:288:0x09d8, B:304:0x0a81, B:305:0x0a98, B:308:0x0a9b, B:207:0x06e0, B:209:0x06ea, B:211:0x06f2, B:177:0x05ee, B:164:0x051b, B:106:0x0342, B:107:0x0349, B:109:0x034f, B:111:0x035b, B:49:0x0186, B:52:0x0192, B:54:0x01a9, B:60:0x01c7, B:68:0x0207, B:70:0x020d, B:72:0x021b, B:74:0x0227, B:76:0x0231, B:78:0x023c, B:81:0x0243, B:99:0x02ea, B:101:0x02f5, B:82:0x0271, B:83:0x028e, B:85:0x0295, B:87:0x02a6, B:98:0x02ce, B:97:0x02bb, B:75:0x022c, B:63:0x01d5, B:67:0x01fd), top: B:322:0x0124, inners: #0, #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0674 A[Catch: all -> 0x0ae3, TryCatch #3 {all -> 0x0ae3, blocks: (B:28:0x0124, B:30:0x0136, B:32:0x0142, B:33:0x014e, B:36:0x015c, B:38:0x0166, B:43:0x0172, B:103:0x032c, B:112:0x0362, B:114:0x03a2, B:116:0x03a8, B:117:0x03bf, B:121:0x03d2, B:123:0x03e9, B:125:0x03ef, B:126:0x0406, B:131:0x0430, B:135:0x0451, B:136:0x0468, B:139:0x0479, B:142:0x0496, B:143:0x04aa, B:145:0x04b4, B:147:0x04c3, B:149:0x04c9, B:150:0x04d2, B:151:0x04e0, B:153:0x04f5, B:155:0x050a, B:167:0x0536, B:168:0x054b, B:170:0x0575, B:173:0x058d, B:176:0x05d0, B:178:0x05fc, B:180:0x063b, B:181:0x0640, B:183:0x0648, B:184:0x064d, B:186:0x0655, B:187:0x065a, B:189:0x0663, B:190:0x0667, B:192:0x0674, B:193:0x0679, B:195:0x06a7, B:197:0x06b1, B:199:0x06b9, B:200:0x06be, B:202:0x06c8, B:204:0x06d2, B:206:0x06da, B:212:0x06f7, B:214:0x06ff, B:215:0x0702, B:217:0x071a, B:220:0x0722, B:221:0x073b, B:223:0x0741, B:225:0x0755, B:227:0x0761, B:229:0x076e, B:233:0x0788, B:234:0x0798, B:238:0x07a1, B:239:0x07a4, B:241:0x07c0, B:243:0x07d2, B:245:0x07d6, B:247:0x07e1, B:248:0x07ec, B:250:0x082f, B:251:0x0834, B:253:0x083c, B:255:0x0845, B:256:0x0848, B:258:0x0855, B:260:0x0875, B:261:0x0880, B:263:0x08b5, B:264:0x08ba, B:265:0x08c7, B:267:0x08cd, B:269:0x08d7, B:270:0x08e4, B:272:0x08ee, B:273:0x08fb, B:274:0x0908, B:276:0x090e, B:278:0x093e, B:279:0x0984, B:280:0x098e, B:281:0x099a, B:283:0x09a0, B:292:0x09ee, B:293:0x0a3c, B:295:0x0a4c, B:309:0x0ab0, B:298:0x0a64, B:300:0x0a68, B:286:0x09ac, B:288:0x09d8, B:304:0x0a81, B:305:0x0a98, B:308:0x0a9b, B:207:0x06e0, B:209:0x06ea, B:211:0x06f2, B:177:0x05ee, B:164:0x051b, B:106:0x0342, B:107:0x0349, B:109:0x034f, B:111:0x035b, B:49:0x0186, B:52:0x0192, B:54:0x01a9, B:60:0x01c7, B:68:0x0207, B:70:0x020d, B:72:0x021b, B:74:0x0227, B:76:0x0231, B:78:0x023c, B:81:0x0243, B:99:0x02ea, B:101:0x02f5, B:82:0x0271, B:83:0x028e, B:85:0x0295, B:87:0x02a6, B:98:0x02ce, B:97:0x02bb, B:75:0x022c, B:63:0x01d5, B:67:0x01fd), top: B:322:0x0124, inners: #0, #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:195:0x06a7 A[Catch: all -> 0x0ae3, TryCatch #3 {all -> 0x0ae3, blocks: (B:28:0x0124, B:30:0x0136, B:32:0x0142, B:33:0x014e, B:36:0x015c, B:38:0x0166, B:43:0x0172, B:103:0x032c, B:112:0x0362, B:114:0x03a2, B:116:0x03a8, B:117:0x03bf, B:121:0x03d2, B:123:0x03e9, B:125:0x03ef, B:126:0x0406, B:131:0x0430, B:135:0x0451, B:136:0x0468, B:139:0x0479, B:142:0x0496, B:143:0x04aa, B:145:0x04b4, B:147:0x04c3, B:149:0x04c9, B:150:0x04d2, B:151:0x04e0, B:153:0x04f5, B:155:0x050a, B:167:0x0536, B:168:0x054b, B:170:0x0575, B:173:0x058d, B:176:0x05d0, B:178:0x05fc, B:180:0x063b, B:181:0x0640, B:183:0x0648, B:184:0x064d, B:186:0x0655, B:187:0x065a, B:189:0x0663, B:190:0x0667, B:192:0x0674, B:193:0x0679, B:195:0x06a7, B:197:0x06b1, B:199:0x06b9, B:200:0x06be, B:202:0x06c8, B:204:0x06d2, B:206:0x06da, B:212:0x06f7, B:214:0x06ff, B:215:0x0702, B:217:0x071a, B:220:0x0722, B:221:0x073b, B:223:0x0741, B:225:0x0755, B:227:0x0761, B:229:0x076e, B:233:0x0788, B:234:0x0798, B:238:0x07a1, B:239:0x07a4, B:241:0x07c0, B:243:0x07d2, B:245:0x07d6, B:247:0x07e1, B:248:0x07ec, B:250:0x082f, B:251:0x0834, B:253:0x083c, B:255:0x0845, B:256:0x0848, B:258:0x0855, B:260:0x0875, B:261:0x0880, B:263:0x08b5, B:264:0x08ba, B:265:0x08c7, B:267:0x08cd, B:269:0x08d7, B:270:0x08e4, B:272:0x08ee, B:273:0x08fb, B:274:0x0908, B:276:0x090e, B:278:0x093e, B:279:0x0984, B:280:0x098e, B:281:0x099a, B:283:0x09a0, B:292:0x09ee, B:293:0x0a3c, B:295:0x0a4c, B:309:0x0ab0, B:298:0x0a64, B:300:0x0a68, B:286:0x09ac, B:288:0x09d8, B:304:0x0a81, B:305:0x0a98, B:308:0x0a9b, B:207:0x06e0, B:209:0x06ea, B:211:0x06f2, B:177:0x05ee, B:164:0x051b, B:106:0x0342, B:107:0x0349, B:109:0x034f, B:111:0x035b, B:49:0x0186, B:52:0x0192, B:54:0x01a9, B:60:0x01c7, B:68:0x0207, B:70:0x020d, B:72:0x021b, B:74:0x0227, B:76:0x0231, B:78:0x023c, B:81:0x0243, B:99:0x02ea, B:101:0x02f5, B:82:0x0271, B:83:0x028e, B:85:0x0295, B:87:0x02a6, B:98:0x02ce, B:97:0x02bb, B:75:0x022c, B:63:0x01d5, B:67:0x01fd), top: B:322:0x0124, inners: #0, #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:207:0x06e0 A[Catch: all -> 0x0ae3, TryCatch #3 {all -> 0x0ae3, blocks: (B:28:0x0124, B:30:0x0136, B:32:0x0142, B:33:0x014e, B:36:0x015c, B:38:0x0166, B:43:0x0172, B:103:0x032c, B:112:0x0362, B:114:0x03a2, B:116:0x03a8, B:117:0x03bf, B:121:0x03d2, B:123:0x03e9, B:125:0x03ef, B:126:0x0406, B:131:0x0430, B:135:0x0451, B:136:0x0468, B:139:0x0479, B:142:0x0496, B:143:0x04aa, B:145:0x04b4, B:147:0x04c3, B:149:0x04c9, B:150:0x04d2, B:151:0x04e0, B:153:0x04f5, B:155:0x050a, B:167:0x0536, B:168:0x054b, B:170:0x0575, B:173:0x058d, B:176:0x05d0, B:178:0x05fc, B:180:0x063b, B:181:0x0640, B:183:0x0648, B:184:0x064d, B:186:0x0655, B:187:0x065a, B:189:0x0663, B:190:0x0667, B:192:0x0674, B:193:0x0679, B:195:0x06a7, B:197:0x06b1, B:199:0x06b9, B:200:0x06be, B:202:0x06c8, B:204:0x06d2, B:206:0x06da, B:212:0x06f7, B:214:0x06ff, B:215:0x0702, B:217:0x071a, B:220:0x0722, B:221:0x073b, B:223:0x0741, B:225:0x0755, B:227:0x0761, B:229:0x076e, B:233:0x0788, B:234:0x0798, B:238:0x07a1, B:239:0x07a4, B:241:0x07c0, B:243:0x07d2, B:245:0x07d6, B:247:0x07e1, B:248:0x07ec, B:250:0x082f, B:251:0x0834, B:253:0x083c, B:255:0x0845, B:256:0x0848, B:258:0x0855, B:260:0x0875, B:261:0x0880, B:263:0x08b5, B:264:0x08ba, B:265:0x08c7, B:267:0x08cd, B:269:0x08d7, B:270:0x08e4, B:272:0x08ee, B:273:0x08fb, B:274:0x0908, B:276:0x090e, B:278:0x093e, B:279:0x0984, B:280:0x098e, B:281:0x099a, B:283:0x09a0, B:292:0x09ee, B:293:0x0a3c, B:295:0x0a4c, B:309:0x0ab0, B:298:0x0a64, B:300:0x0a68, B:286:0x09ac, B:288:0x09d8, B:304:0x0a81, B:305:0x0a98, B:308:0x0a9b, B:207:0x06e0, B:209:0x06ea, B:211:0x06f2, B:177:0x05ee, B:164:0x051b, B:106:0x0342, B:107:0x0349, B:109:0x034f, B:111:0x035b, B:49:0x0186, B:52:0x0192, B:54:0x01a9, B:60:0x01c7, B:68:0x0207, B:70:0x020d, B:72:0x021b, B:74:0x0227, B:76:0x0231, B:78:0x023c, B:81:0x0243, B:99:0x02ea, B:101:0x02f5, B:82:0x0271, B:83:0x028e, B:85:0x0295, B:87:0x02a6, B:98:0x02ce, B:97:0x02bb, B:75:0x022c, B:63:0x01d5, B:67:0x01fd), top: B:322:0x0124, inners: #0, #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:214:0x06ff A[Catch: all -> 0x0ae3, TryCatch #3 {all -> 0x0ae3, blocks: (B:28:0x0124, B:30:0x0136, B:32:0x0142, B:33:0x014e, B:36:0x015c, B:38:0x0166, B:43:0x0172, B:103:0x032c, B:112:0x0362, B:114:0x03a2, B:116:0x03a8, B:117:0x03bf, B:121:0x03d2, B:123:0x03e9, B:125:0x03ef, B:126:0x0406, B:131:0x0430, B:135:0x0451, B:136:0x0468, B:139:0x0479, B:142:0x0496, B:143:0x04aa, B:145:0x04b4, B:147:0x04c3, B:149:0x04c9, B:150:0x04d2, B:151:0x04e0, B:153:0x04f5, B:155:0x050a, B:167:0x0536, B:168:0x054b, B:170:0x0575, B:173:0x058d, B:176:0x05d0, B:178:0x05fc, B:180:0x063b, B:181:0x0640, B:183:0x0648, B:184:0x064d, B:186:0x0655, B:187:0x065a, B:189:0x0663, B:190:0x0667, B:192:0x0674, B:193:0x0679, B:195:0x06a7, B:197:0x06b1, B:199:0x06b9, B:200:0x06be, B:202:0x06c8, B:204:0x06d2, B:206:0x06da, B:212:0x06f7, B:214:0x06ff, B:215:0x0702, B:217:0x071a, B:220:0x0722, B:221:0x073b, B:223:0x0741, B:225:0x0755, B:227:0x0761, B:229:0x076e, B:233:0x0788, B:234:0x0798, B:238:0x07a1, B:239:0x07a4, B:241:0x07c0, B:243:0x07d2, B:245:0x07d6, B:247:0x07e1, B:248:0x07ec, B:250:0x082f, B:251:0x0834, B:253:0x083c, B:255:0x0845, B:256:0x0848, B:258:0x0855, B:260:0x0875, B:261:0x0880, B:263:0x08b5, B:264:0x08ba, B:265:0x08c7, B:267:0x08cd, B:269:0x08d7, B:270:0x08e4, B:272:0x08ee, B:273:0x08fb, B:274:0x0908, B:276:0x090e, B:278:0x093e, B:279:0x0984, B:280:0x098e, B:281:0x099a, B:283:0x09a0, B:292:0x09ee, B:293:0x0a3c, B:295:0x0a4c, B:309:0x0ab0, B:298:0x0a64, B:300:0x0a68, B:286:0x09ac, B:288:0x09d8, B:304:0x0a81, B:305:0x0a98, B:308:0x0a9b, B:207:0x06e0, B:209:0x06ea, B:211:0x06f2, B:177:0x05ee, B:164:0x051b, B:106:0x0342, B:107:0x0349, B:109:0x034f, B:111:0x035b, B:49:0x0186, B:52:0x0192, B:54:0x01a9, B:60:0x01c7, B:68:0x0207, B:70:0x020d, B:72:0x021b, B:74:0x0227, B:76:0x0231, B:78:0x023c, B:81:0x0243, B:99:0x02ea, B:101:0x02f5, B:82:0x0271, B:83:0x028e, B:85:0x0295, B:87:0x02a6, B:98:0x02ce, B:97:0x02bb, B:75:0x022c, B:63:0x01d5, B:67:0x01fd), top: B:322:0x0124, inners: #0, #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:236:0x079e  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x07a1 A[Catch: all -> 0x0ae3, TryCatch #3 {all -> 0x0ae3, blocks: (B:28:0x0124, B:30:0x0136, B:32:0x0142, B:33:0x014e, B:36:0x015c, B:38:0x0166, B:43:0x0172, B:103:0x032c, B:112:0x0362, B:114:0x03a2, B:116:0x03a8, B:117:0x03bf, B:121:0x03d2, B:123:0x03e9, B:125:0x03ef, B:126:0x0406, B:131:0x0430, B:135:0x0451, B:136:0x0468, B:139:0x0479, B:142:0x0496, B:143:0x04aa, B:145:0x04b4, B:147:0x04c3, B:149:0x04c9, B:150:0x04d2, B:151:0x04e0, B:153:0x04f5, B:155:0x050a, B:167:0x0536, B:168:0x054b, B:170:0x0575, B:173:0x058d, B:176:0x05d0, B:178:0x05fc, B:180:0x063b, B:181:0x0640, B:183:0x0648, B:184:0x064d, B:186:0x0655, B:187:0x065a, B:189:0x0663, B:190:0x0667, B:192:0x0674, B:193:0x0679, B:195:0x06a7, B:197:0x06b1, B:199:0x06b9, B:200:0x06be, B:202:0x06c8, B:204:0x06d2, B:206:0x06da, B:212:0x06f7, B:214:0x06ff, B:215:0x0702, B:217:0x071a, B:220:0x0722, B:221:0x073b, B:223:0x0741, B:225:0x0755, B:227:0x0761, B:229:0x076e, B:233:0x0788, B:234:0x0798, B:238:0x07a1, B:239:0x07a4, B:241:0x07c0, B:243:0x07d2, B:245:0x07d6, B:247:0x07e1, B:248:0x07ec, B:250:0x082f, B:251:0x0834, B:253:0x083c, B:255:0x0845, B:256:0x0848, B:258:0x0855, B:260:0x0875, B:261:0x0880, B:263:0x08b5, B:264:0x08ba, B:265:0x08c7, B:267:0x08cd, B:269:0x08d7, B:270:0x08e4, B:272:0x08ee, B:273:0x08fb, B:274:0x0908, B:276:0x090e, B:278:0x093e, B:279:0x0984, B:280:0x098e, B:281:0x099a, B:283:0x09a0, B:292:0x09ee, B:293:0x0a3c, B:295:0x0a4c, B:309:0x0ab0, B:298:0x0a64, B:300:0x0a68, B:286:0x09ac, B:288:0x09d8, B:304:0x0a81, B:305:0x0a98, B:308:0x0a9b, B:207:0x06e0, B:209:0x06ea, B:211:0x06f2, B:177:0x05ee, B:164:0x051b, B:106:0x0342, B:107:0x0349, B:109:0x034f, B:111:0x035b, B:49:0x0186, B:52:0x0192, B:54:0x01a9, B:60:0x01c7, B:68:0x0207, B:70:0x020d, B:72:0x021b, B:74:0x0227, B:76:0x0231, B:78:0x023c, B:81:0x0243, B:99:0x02ea, B:101:0x02f5, B:82:0x0271, B:83:0x028e, B:85:0x0295, B:87:0x02a6, B:98:0x02ce, B:97:0x02bb, B:75:0x022c, B:63:0x01d5, B:67:0x01fd), top: B:322:0x0124, inners: #0, #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:241:0x07c0 A[Catch: all -> 0x0ae3, TryCatch #3 {all -> 0x0ae3, blocks: (B:28:0x0124, B:30:0x0136, B:32:0x0142, B:33:0x014e, B:36:0x015c, B:38:0x0166, B:43:0x0172, B:103:0x032c, B:112:0x0362, B:114:0x03a2, B:116:0x03a8, B:117:0x03bf, B:121:0x03d2, B:123:0x03e9, B:125:0x03ef, B:126:0x0406, B:131:0x0430, B:135:0x0451, B:136:0x0468, B:139:0x0479, B:142:0x0496, B:143:0x04aa, B:145:0x04b4, B:147:0x04c3, B:149:0x04c9, B:150:0x04d2, B:151:0x04e0, B:153:0x04f5, B:155:0x050a, B:167:0x0536, B:168:0x054b, B:170:0x0575, B:173:0x058d, B:176:0x05d0, B:178:0x05fc, B:180:0x063b, B:181:0x0640, B:183:0x0648, B:184:0x064d, B:186:0x0655, B:187:0x065a, B:189:0x0663, B:190:0x0667, B:192:0x0674, B:193:0x0679, B:195:0x06a7, B:197:0x06b1, B:199:0x06b9, B:200:0x06be, B:202:0x06c8, B:204:0x06d2, B:206:0x06da, B:212:0x06f7, B:214:0x06ff, B:215:0x0702, B:217:0x071a, B:220:0x0722, B:221:0x073b, B:223:0x0741, B:225:0x0755, B:227:0x0761, B:229:0x076e, B:233:0x0788, B:234:0x0798, B:238:0x07a1, B:239:0x07a4, B:241:0x07c0, B:243:0x07d2, B:245:0x07d6, B:247:0x07e1, B:248:0x07ec, B:250:0x082f, B:251:0x0834, B:253:0x083c, B:255:0x0845, B:256:0x0848, B:258:0x0855, B:260:0x0875, B:261:0x0880, B:263:0x08b5, B:264:0x08ba, B:265:0x08c7, B:267:0x08cd, B:269:0x08d7, B:270:0x08e4, B:272:0x08ee, B:273:0x08fb, B:274:0x0908, B:276:0x090e, B:278:0x093e, B:279:0x0984, B:280:0x098e, B:281:0x099a, B:283:0x09a0, B:292:0x09ee, B:293:0x0a3c, B:295:0x0a4c, B:309:0x0ab0, B:298:0x0a64, B:300:0x0a68, B:286:0x09ac, B:288:0x09d8, B:304:0x0a81, B:305:0x0a98, B:308:0x0a9b, B:207:0x06e0, B:209:0x06ea, B:211:0x06f2, B:177:0x05ee, B:164:0x051b, B:106:0x0342, B:107:0x0349, B:109:0x034f, B:111:0x035b, B:49:0x0186, B:52:0x0192, B:54:0x01a9, B:60:0x01c7, B:68:0x0207, B:70:0x020d, B:72:0x021b, B:74:0x0227, B:76:0x0231, B:78:0x023c, B:81:0x0243, B:99:0x02ea, B:101:0x02f5, B:82:0x0271, B:83:0x028e, B:85:0x0295, B:87:0x02a6, B:98:0x02ce, B:97:0x02bb, B:75:0x022c, B:63:0x01d5, B:67:0x01fd), top: B:322:0x0124, inners: #0, #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:250:0x082f A[Catch: all -> 0x0ae3, TryCatch #3 {all -> 0x0ae3, blocks: (B:28:0x0124, B:30:0x0136, B:32:0x0142, B:33:0x014e, B:36:0x015c, B:38:0x0166, B:43:0x0172, B:103:0x032c, B:112:0x0362, B:114:0x03a2, B:116:0x03a8, B:117:0x03bf, B:121:0x03d2, B:123:0x03e9, B:125:0x03ef, B:126:0x0406, B:131:0x0430, B:135:0x0451, B:136:0x0468, B:139:0x0479, B:142:0x0496, B:143:0x04aa, B:145:0x04b4, B:147:0x04c3, B:149:0x04c9, B:150:0x04d2, B:151:0x04e0, B:153:0x04f5, B:155:0x050a, B:167:0x0536, B:168:0x054b, B:170:0x0575, B:173:0x058d, B:176:0x05d0, B:178:0x05fc, B:180:0x063b, B:181:0x0640, B:183:0x0648, B:184:0x064d, B:186:0x0655, B:187:0x065a, B:189:0x0663, B:190:0x0667, B:192:0x0674, B:193:0x0679, B:195:0x06a7, B:197:0x06b1, B:199:0x06b9, B:200:0x06be, B:202:0x06c8, B:204:0x06d2, B:206:0x06da, B:212:0x06f7, B:214:0x06ff, B:215:0x0702, B:217:0x071a, B:220:0x0722, B:221:0x073b, B:223:0x0741, B:225:0x0755, B:227:0x0761, B:229:0x076e, B:233:0x0788, B:234:0x0798, B:238:0x07a1, B:239:0x07a4, B:241:0x07c0, B:243:0x07d2, B:245:0x07d6, B:247:0x07e1, B:248:0x07ec, B:250:0x082f, B:251:0x0834, B:253:0x083c, B:255:0x0845, B:256:0x0848, B:258:0x0855, B:260:0x0875, B:261:0x0880, B:263:0x08b5, B:264:0x08ba, B:265:0x08c7, B:267:0x08cd, B:269:0x08d7, B:270:0x08e4, B:272:0x08ee, B:273:0x08fb, B:274:0x0908, B:276:0x090e, B:278:0x093e, B:279:0x0984, B:280:0x098e, B:281:0x099a, B:283:0x09a0, B:292:0x09ee, B:293:0x0a3c, B:295:0x0a4c, B:309:0x0ab0, B:298:0x0a64, B:300:0x0a68, B:286:0x09ac, B:288:0x09d8, B:304:0x0a81, B:305:0x0a98, B:308:0x0a9b, B:207:0x06e0, B:209:0x06ea, B:211:0x06f2, B:177:0x05ee, B:164:0x051b, B:106:0x0342, B:107:0x0349, B:109:0x034f, B:111:0x035b, B:49:0x0186, B:52:0x0192, B:54:0x01a9, B:60:0x01c7, B:68:0x0207, B:70:0x020d, B:72:0x021b, B:74:0x0227, B:76:0x0231, B:78:0x023c, B:81:0x0243, B:99:0x02ea, B:101:0x02f5, B:82:0x0271, B:83:0x028e, B:85:0x0295, B:87:0x02a6, B:98:0x02ce, B:97:0x02bb, B:75:0x022c, B:63:0x01d5, B:67:0x01fd), top: B:322:0x0124, inners: #0, #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:253:0x083c A[Catch: all -> 0x0ae3, TryCatch #3 {all -> 0x0ae3, blocks: (B:28:0x0124, B:30:0x0136, B:32:0x0142, B:33:0x014e, B:36:0x015c, B:38:0x0166, B:43:0x0172, B:103:0x032c, B:112:0x0362, B:114:0x03a2, B:116:0x03a8, B:117:0x03bf, B:121:0x03d2, B:123:0x03e9, B:125:0x03ef, B:126:0x0406, B:131:0x0430, B:135:0x0451, B:136:0x0468, B:139:0x0479, B:142:0x0496, B:143:0x04aa, B:145:0x04b4, B:147:0x04c3, B:149:0x04c9, B:150:0x04d2, B:151:0x04e0, B:153:0x04f5, B:155:0x050a, B:167:0x0536, B:168:0x054b, B:170:0x0575, B:173:0x058d, B:176:0x05d0, B:178:0x05fc, B:180:0x063b, B:181:0x0640, B:183:0x0648, B:184:0x064d, B:186:0x0655, B:187:0x065a, B:189:0x0663, B:190:0x0667, B:192:0x0674, B:193:0x0679, B:195:0x06a7, B:197:0x06b1, B:199:0x06b9, B:200:0x06be, B:202:0x06c8, B:204:0x06d2, B:206:0x06da, B:212:0x06f7, B:214:0x06ff, B:215:0x0702, B:217:0x071a, B:220:0x0722, B:221:0x073b, B:223:0x0741, B:225:0x0755, B:227:0x0761, B:229:0x076e, B:233:0x0788, B:234:0x0798, B:238:0x07a1, B:239:0x07a4, B:241:0x07c0, B:243:0x07d2, B:245:0x07d6, B:247:0x07e1, B:248:0x07ec, B:250:0x082f, B:251:0x0834, B:253:0x083c, B:255:0x0845, B:256:0x0848, B:258:0x0855, B:260:0x0875, B:261:0x0880, B:263:0x08b5, B:264:0x08ba, B:265:0x08c7, B:267:0x08cd, B:269:0x08d7, B:270:0x08e4, B:272:0x08ee, B:273:0x08fb, B:274:0x0908, B:276:0x090e, B:278:0x093e, B:279:0x0984, B:280:0x098e, B:281:0x099a, B:283:0x09a0, B:292:0x09ee, B:293:0x0a3c, B:295:0x0a4c, B:309:0x0ab0, B:298:0x0a64, B:300:0x0a68, B:286:0x09ac, B:288:0x09d8, B:304:0x0a81, B:305:0x0a98, B:308:0x0a9b, B:207:0x06e0, B:209:0x06ea, B:211:0x06f2, B:177:0x05ee, B:164:0x051b, B:106:0x0342, B:107:0x0349, B:109:0x034f, B:111:0x035b, B:49:0x0186, B:52:0x0192, B:54:0x01a9, B:60:0x01c7, B:68:0x0207, B:70:0x020d, B:72:0x021b, B:74:0x0227, B:76:0x0231, B:78:0x023c, B:81:0x0243, B:99:0x02ea, B:101:0x02f5, B:82:0x0271, B:83:0x028e, B:85:0x0295, B:87:0x02a6, B:98:0x02ce, B:97:0x02bb, B:75:0x022c, B:63:0x01d5, B:67:0x01fd), top: B:322:0x0124, inners: #0, #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:258:0x0855 A[Catch: all -> 0x0ae3, TryCatch #3 {all -> 0x0ae3, blocks: (B:28:0x0124, B:30:0x0136, B:32:0x0142, B:33:0x014e, B:36:0x015c, B:38:0x0166, B:43:0x0172, B:103:0x032c, B:112:0x0362, B:114:0x03a2, B:116:0x03a8, B:117:0x03bf, B:121:0x03d2, B:123:0x03e9, B:125:0x03ef, B:126:0x0406, B:131:0x0430, B:135:0x0451, B:136:0x0468, B:139:0x0479, B:142:0x0496, B:143:0x04aa, B:145:0x04b4, B:147:0x04c3, B:149:0x04c9, B:150:0x04d2, B:151:0x04e0, B:153:0x04f5, B:155:0x050a, B:167:0x0536, B:168:0x054b, B:170:0x0575, B:173:0x058d, B:176:0x05d0, B:178:0x05fc, B:180:0x063b, B:181:0x0640, B:183:0x0648, B:184:0x064d, B:186:0x0655, B:187:0x065a, B:189:0x0663, B:190:0x0667, B:192:0x0674, B:193:0x0679, B:195:0x06a7, B:197:0x06b1, B:199:0x06b9, B:200:0x06be, B:202:0x06c8, B:204:0x06d2, B:206:0x06da, B:212:0x06f7, B:214:0x06ff, B:215:0x0702, B:217:0x071a, B:220:0x0722, B:221:0x073b, B:223:0x0741, B:225:0x0755, B:227:0x0761, B:229:0x076e, B:233:0x0788, B:234:0x0798, B:238:0x07a1, B:239:0x07a4, B:241:0x07c0, B:243:0x07d2, B:245:0x07d6, B:247:0x07e1, B:248:0x07ec, B:250:0x082f, B:251:0x0834, B:253:0x083c, B:255:0x0845, B:256:0x0848, B:258:0x0855, B:260:0x0875, B:261:0x0880, B:263:0x08b5, B:264:0x08ba, B:265:0x08c7, B:267:0x08cd, B:269:0x08d7, B:270:0x08e4, B:272:0x08ee, B:273:0x08fb, B:274:0x0908, B:276:0x090e, B:278:0x093e, B:279:0x0984, B:280:0x098e, B:281:0x099a, B:283:0x09a0, B:292:0x09ee, B:293:0x0a3c, B:295:0x0a4c, B:309:0x0ab0, B:298:0x0a64, B:300:0x0a68, B:286:0x09ac, B:288:0x09d8, B:304:0x0a81, B:305:0x0a98, B:308:0x0a9b, B:207:0x06e0, B:209:0x06ea, B:211:0x06f2, B:177:0x05ee, B:164:0x051b, B:106:0x0342, B:107:0x0349, B:109:0x034f, B:111:0x035b, B:49:0x0186, B:52:0x0192, B:54:0x01a9, B:60:0x01c7, B:68:0x0207, B:70:0x020d, B:72:0x021b, B:74:0x0227, B:76:0x0231, B:78:0x023c, B:81:0x0243, B:99:0x02ea, B:101:0x02f5, B:82:0x0271, B:83:0x028e, B:85:0x0295, B:87:0x02a6, B:98:0x02ce, B:97:0x02bb, B:75:0x022c, B:63:0x01d5, B:67:0x01fd), top: B:322:0x0124, inners: #0, #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:272:0x08ee A[Catch: all -> 0x0ae3, TryCatch #3 {all -> 0x0ae3, blocks: (B:28:0x0124, B:30:0x0136, B:32:0x0142, B:33:0x014e, B:36:0x015c, B:38:0x0166, B:43:0x0172, B:103:0x032c, B:112:0x0362, B:114:0x03a2, B:116:0x03a8, B:117:0x03bf, B:121:0x03d2, B:123:0x03e9, B:125:0x03ef, B:126:0x0406, B:131:0x0430, B:135:0x0451, B:136:0x0468, B:139:0x0479, B:142:0x0496, B:143:0x04aa, B:145:0x04b4, B:147:0x04c3, B:149:0x04c9, B:150:0x04d2, B:151:0x04e0, B:153:0x04f5, B:155:0x050a, B:167:0x0536, B:168:0x054b, B:170:0x0575, B:173:0x058d, B:176:0x05d0, B:178:0x05fc, B:180:0x063b, B:181:0x0640, B:183:0x0648, B:184:0x064d, B:186:0x0655, B:187:0x065a, B:189:0x0663, B:190:0x0667, B:192:0x0674, B:193:0x0679, B:195:0x06a7, B:197:0x06b1, B:199:0x06b9, B:200:0x06be, B:202:0x06c8, B:204:0x06d2, B:206:0x06da, B:212:0x06f7, B:214:0x06ff, B:215:0x0702, B:217:0x071a, B:220:0x0722, B:221:0x073b, B:223:0x0741, B:225:0x0755, B:227:0x0761, B:229:0x076e, B:233:0x0788, B:234:0x0798, B:238:0x07a1, B:239:0x07a4, B:241:0x07c0, B:243:0x07d2, B:245:0x07d6, B:247:0x07e1, B:248:0x07ec, B:250:0x082f, B:251:0x0834, B:253:0x083c, B:255:0x0845, B:256:0x0848, B:258:0x0855, B:260:0x0875, B:261:0x0880, B:263:0x08b5, B:264:0x08ba, B:265:0x08c7, B:267:0x08cd, B:269:0x08d7, B:270:0x08e4, B:272:0x08ee, B:273:0x08fb, B:274:0x0908, B:276:0x090e, B:278:0x093e, B:279:0x0984, B:280:0x098e, B:281:0x099a, B:283:0x09a0, B:292:0x09ee, B:293:0x0a3c, B:295:0x0a4c, B:309:0x0ab0, B:298:0x0a64, B:300:0x0a68, B:286:0x09ac, B:288:0x09d8, B:304:0x0a81, B:305:0x0a98, B:308:0x0a9b, B:207:0x06e0, B:209:0x06ea, B:211:0x06f2, B:177:0x05ee, B:164:0x051b, B:106:0x0342, B:107:0x0349, B:109:0x034f, B:111:0x035b, B:49:0x0186, B:52:0x0192, B:54:0x01a9, B:60:0x01c7, B:68:0x0207, B:70:0x020d, B:72:0x021b, B:74:0x0227, B:76:0x0231, B:78:0x023c, B:81:0x0243, B:99:0x02ea, B:101:0x02f5, B:82:0x0271, B:83:0x028e, B:85:0x0295, B:87:0x02a6, B:98:0x02ce, B:97:0x02bb, B:75:0x022c, B:63:0x01d5, B:67:0x01fd), top: B:322:0x0124, inners: #0, #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:276:0x090e A[Catch: all -> 0x0ae3, TRY_LEAVE, TryCatch #3 {all -> 0x0ae3, blocks: (B:28:0x0124, B:30:0x0136, B:32:0x0142, B:33:0x014e, B:36:0x015c, B:38:0x0166, B:43:0x0172, B:103:0x032c, B:112:0x0362, B:114:0x03a2, B:116:0x03a8, B:117:0x03bf, B:121:0x03d2, B:123:0x03e9, B:125:0x03ef, B:126:0x0406, B:131:0x0430, B:135:0x0451, B:136:0x0468, B:139:0x0479, B:142:0x0496, B:143:0x04aa, B:145:0x04b4, B:147:0x04c3, B:149:0x04c9, B:150:0x04d2, B:151:0x04e0, B:153:0x04f5, B:155:0x050a, B:167:0x0536, B:168:0x054b, B:170:0x0575, B:173:0x058d, B:176:0x05d0, B:178:0x05fc, B:180:0x063b, B:181:0x0640, B:183:0x0648, B:184:0x064d, B:186:0x0655, B:187:0x065a, B:189:0x0663, B:190:0x0667, B:192:0x0674, B:193:0x0679, B:195:0x06a7, B:197:0x06b1, B:199:0x06b9, B:200:0x06be, B:202:0x06c8, B:204:0x06d2, B:206:0x06da, B:212:0x06f7, B:214:0x06ff, B:215:0x0702, B:217:0x071a, B:220:0x0722, B:221:0x073b, B:223:0x0741, B:225:0x0755, B:227:0x0761, B:229:0x076e, B:233:0x0788, B:234:0x0798, B:238:0x07a1, B:239:0x07a4, B:241:0x07c0, B:243:0x07d2, B:245:0x07d6, B:247:0x07e1, B:248:0x07ec, B:250:0x082f, B:251:0x0834, B:253:0x083c, B:255:0x0845, B:256:0x0848, B:258:0x0855, B:260:0x0875, B:261:0x0880, B:263:0x08b5, B:264:0x08ba, B:265:0x08c7, B:267:0x08cd, B:269:0x08d7, B:270:0x08e4, B:272:0x08ee, B:273:0x08fb, B:274:0x0908, B:276:0x090e, B:278:0x093e, B:279:0x0984, B:280:0x098e, B:281:0x099a, B:283:0x09a0, B:292:0x09ee, B:293:0x0a3c, B:295:0x0a4c, B:309:0x0ab0, B:298:0x0a64, B:300:0x0a68, B:286:0x09ac, B:288:0x09d8, B:304:0x0a81, B:305:0x0a98, B:308:0x0a9b, B:207:0x06e0, B:209:0x06ea, B:211:0x06f2, B:177:0x05ee, B:164:0x051b, B:106:0x0342, B:107:0x0349, B:109:0x034f, B:111:0x035b, B:49:0x0186, B:52:0x0192, B:54:0x01a9, B:60:0x01c7, B:68:0x0207, B:70:0x020d, B:72:0x021b, B:74:0x0227, B:76:0x0231, B:78:0x023c, B:81:0x0243, B:99:0x02ea, B:101:0x02f5, B:82:0x0271, B:83:0x028e, B:85:0x0295, B:87:0x02a6, B:98:0x02ce, B:97:0x02bb, B:75:0x022c, B:63:0x01d5, B:67:0x01fd), top: B:322:0x0124, inners: #0, #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:283:0x09a0 A[Catch: all -> 0x0ae3, TryCatch #3 {all -> 0x0ae3, blocks: (B:28:0x0124, B:30:0x0136, B:32:0x0142, B:33:0x014e, B:36:0x015c, B:38:0x0166, B:43:0x0172, B:103:0x032c, B:112:0x0362, B:114:0x03a2, B:116:0x03a8, B:117:0x03bf, B:121:0x03d2, B:123:0x03e9, B:125:0x03ef, B:126:0x0406, B:131:0x0430, B:135:0x0451, B:136:0x0468, B:139:0x0479, B:142:0x0496, B:143:0x04aa, B:145:0x04b4, B:147:0x04c3, B:149:0x04c9, B:150:0x04d2, B:151:0x04e0, B:153:0x04f5, B:155:0x050a, B:167:0x0536, B:168:0x054b, B:170:0x0575, B:173:0x058d, B:176:0x05d0, B:178:0x05fc, B:180:0x063b, B:181:0x0640, B:183:0x0648, B:184:0x064d, B:186:0x0655, B:187:0x065a, B:189:0x0663, B:190:0x0667, B:192:0x0674, B:193:0x0679, B:195:0x06a7, B:197:0x06b1, B:199:0x06b9, B:200:0x06be, B:202:0x06c8, B:204:0x06d2, B:206:0x06da, B:212:0x06f7, B:214:0x06ff, B:215:0x0702, B:217:0x071a, B:220:0x0722, B:221:0x073b, B:223:0x0741, B:225:0x0755, B:227:0x0761, B:229:0x076e, B:233:0x0788, B:234:0x0798, B:238:0x07a1, B:239:0x07a4, B:241:0x07c0, B:243:0x07d2, B:245:0x07d6, B:247:0x07e1, B:248:0x07ec, B:250:0x082f, B:251:0x0834, B:253:0x083c, B:255:0x0845, B:256:0x0848, B:258:0x0855, B:260:0x0875, B:261:0x0880, B:263:0x08b5, B:264:0x08ba, B:265:0x08c7, B:267:0x08cd, B:269:0x08d7, B:270:0x08e4, B:272:0x08ee, B:273:0x08fb, B:274:0x0908, B:276:0x090e, B:278:0x093e, B:279:0x0984, B:280:0x098e, B:281:0x099a, B:283:0x09a0, B:292:0x09ee, B:293:0x0a3c, B:295:0x0a4c, B:309:0x0ab0, B:298:0x0a64, B:300:0x0a68, B:286:0x09ac, B:288:0x09d8, B:304:0x0a81, B:305:0x0a98, B:308:0x0a9b, B:207:0x06e0, B:209:0x06ea, B:211:0x06f2, B:177:0x05ee, B:164:0x051b, B:106:0x0342, B:107:0x0349, B:109:0x034f, B:111:0x035b, B:49:0x0186, B:52:0x0192, B:54:0x01a9, B:60:0x01c7, B:68:0x0207, B:70:0x020d, B:72:0x021b, B:74:0x0227, B:76:0x0231, B:78:0x023c, B:81:0x0243, B:99:0x02ea, B:101:0x02f5, B:82:0x0271, B:83:0x028e, B:85:0x0295, B:87:0x02a6, B:98:0x02ce, B:97:0x02bb, B:75:0x022c, B:63:0x01d5, B:67:0x01fd), top: B:322:0x0124, inners: #0, #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:295:0x0a4c A[Catch: SQLiteException -> 0x0a67, all -> 0x0ae3, TRY_LEAVE, TryCatch #1 {SQLiteException -> 0x0a67, blocks: (B:293:0x0a3c, B:295:0x0a4c), top: B:318:0x0a3c, outer: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:297:0x0a62  */
    /* JADX WARN: Removed duplicated region for block: B:346:0x09ac A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0192 A[Catch: all -> 0x0ae3, TRY_ENTER, TryCatch #3 {all -> 0x0ae3, blocks: (B:28:0x0124, B:30:0x0136, B:32:0x0142, B:33:0x014e, B:36:0x015c, B:38:0x0166, B:43:0x0172, B:103:0x032c, B:112:0x0362, B:114:0x03a2, B:116:0x03a8, B:117:0x03bf, B:121:0x03d2, B:123:0x03e9, B:125:0x03ef, B:126:0x0406, B:131:0x0430, B:135:0x0451, B:136:0x0468, B:139:0x0479, B:142:0x0496, B:143:0x04aa, B:145:0x04b4, B:147:0x04c3, B:149:0x04c9, B:150:0x04d2, B:151:0x04e0, B:153:0x04f5, B:155:0x050a, B:167:0x0536, B:168:0x054b, B:170:0x0575, B:173:0x058d, B:176:0x05d0, B:178:0x05fc, B:180:0x063b, B:181:0x0640, B:183:0x0648, B:184:0x064d, B:186:0x0655, B:187:0x065a, B:189:0x0663, B:190:0x0667, B:192:0x0674, B:193:0x0679, B:195:0x06a7, B:197:0x06b1, B:199:0x06b9, B:200:0x06be, B:202:0x06c8, B:204:0x06d2, B:206:0x06da, B:212:0x06f7, B:214:0x06ff, B:215:0x0702, B:217:0x071a, B:220:0x0722, B:221:0x073b, B:223:0x0741, B:225:0x0755, B:227:0x0761, B:229:0x076e, B:233:0x0788, B:234:0x0798, B:238:0x07a1, B:239:0x07a4, B:241:0x07c0, B:243:0x07d2, B:245:0x07d6, B:247:0x07e1, B:248:0x07ec, B:250:0x082f, B:251:0x0834, B:253:0x083c, B:255:0x0845, B:256:0x0848, B:258:0x0855, B:260:0x0875, B:261:0x0880, B:263:0x08b5, B:264:0x08ba, B:265:0x08c7, B:267:0x08cd, B:269:0x08d7, B:270:0x08e4, B:272:0x08ee, B:273:0x08fb, B:274:0x0908, B:276:0x090e, B:278:0x093e, B:279:0x0984, B:280:0x098e, B:281:0x099a, B:283:0x09a0, B:292:0x09ee, B:293:0x0a3c, B:295:0x0a4c, B:309:0x0ab0, B:298:0x0a64, B:300:0x0a68, B:286:0x09ac, B:288:0x09d8, B:304:0x0a81, B:305:0x0a98, B:308:0x0a9b, B:207:0x06e0, B:209:0x06ea, B:211:0x06f2, B:177:0x05ee, B:164:0x051b, B:106:0x0342, B:107:0x0349, B:109:0x034f, B:111:0x035b, B:49:0x0186, B:52:0x0192, B:54:0x01a9, B:60:0x01c7, B:68:0x0207, B:70:0x020d, B:72:0x021b, B:74:0x0227, B:76:0x0231, B:78:0x023c, B:81:0x0243, B:99:0x02ea, B:101:0x02f5, B:82:0x0271, B:83:0x028e, B:85:0x0295, B:87:0x02a6, B:98:0x02ce, B:97:0x02bb, B:75:0x022c, B:63:0x01d5, B:67:0x01fd), top: B:322:0x0124, inners: #0, #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x020d A[Catch: all -> 0x0ae3, TryCatch #3 {all -> 0x0ae3, blocks: (B:28:0x0124, B:30:0x0136, B:32:0x0142, B:33:0x014e, B:36:0x015c, B:38:0x0166, B:43:0x0172, B:103:0x032c, B:112:0x0362, B:114:0x03a2, B:116:0x03a8, B:117:0x03bf, B:121:0x03d2, B:123:0x03e9, B:125:0x03ef, B:126:0x0406, B:131:0x0430, B:135:0x0451, B:136:0x0468, B:139:0x0479, B:142:0x0496, B:143:0x04aa, B:145:0x04b4, B:147:0x04c3, B:149:0x04c9, B:150:0x04d2, B:151:0x04e0, B:153:0x04f5, B:155:0x050a, B:167:0x0536, B:168:0x054b, B:170:0x0575, B:173:0x058d, B:176:0x05d0, B:178:0x05fc, B:180:0x063b, B:181:0x0640, B:183:0x0648, B:184:0x064d, B:186:0x0655, B:187:0x065a, B:189:0x0663, B:190:0x0667, B:192:0x0674, B:193:0x0679, B:195:0x06a7, B:197:0x06b1, B:199:0x06b9, B:200:0x06be, B:202:0x06c8, B:204:0x06d2, B:206:0x06da, B:212:0x06f7, B:214:0x06ff, B:215:0x0702, B:217:0x071a, B:220:0x0722, B:221:0x073b, B:223:0x0741, B:225:0x0755, B:227:0x0761, B:229:0x076e, B:233:0x0788, B:234:0x0798, B:238:0x07a1, B:239:0x07a4, B:241:0x07c0, B:243:0x07d2, B:245:0x07d6, B:247:0x07e1, B:248:0x07ec, B:250:0x082f, B:251:0x0834, B:253:0x083c, B:255:0x0845, B:256:0x0848, B:258:0x0855, B:260:0x0875, B:261:0x0880, B:263:0x08b5, B:264:0x08ba, B:265:0x08c7, B:267:0x08cd, B:269:0x08d7, B:270:0x08e4, B:272:0x08ee, B:273:0x08fb, B:274:0x0908, B:276:0x090e, B:278:0x093e, B:279:0x0984, B:280:0x098e, B:281:0x099a, B:283:0x09a0, B:292:0x09ee, B:293:0x0a3c, B:295:0x0a4c, B:309:0x0ab0, B:298:0x0a64, B:300:0x0a68, B:286:0x09ac, B:288:0x09d8, B:304:0x0a81, B:305:0x0a98, B:308:0x0a9b, B:207:0x06e0, B:209:0x06ea, B:211:0x06f2, B:177:0x05ee, B:164:0x051b, B:106:0x0342, B:107:0x0349, B:109:0x034f, B:111:0x035b, B:49:0x0186, B:52:0x0192, B:54:0x01a9, B:60:0x01c7, B:68:0x0207, B:70:0x020d, B:72:0x021b, B:74:0x0227, B:76:0x0231, B:78:0x023c, B:81:0x0243, B:99:0x02ea, B:101:0x02f5, B:82:0x0271, B:83:0x028e, B:85:0x0295, B:87:0x02a6, B:98:0x02ce, B:97:0x02bb, B:75:0x022c, B:63:0x01d5, B:67:0x01fd), top: B:322:0x0124, inners: #0, #1, #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final void zzW(zzat zzatVar, zzp zzpVar) throws IllegalStateException {
        String strZzg;
        String str;
        long jLongValue;
        String str2;
        String str3;
        String str4;
        zzaj zzajVar;
        String str5;
        zzkx zzkxVar;
        zzaj zzajVar2;
        zzar zzarVar;
        long length;
        long jIntValue;
        String str6;
        int i;
        long jDelete;
        zzao zzaoVar;
        String str7;
        zzap zzapVarZzn;
        zzap zzapVarZzc;
        com.google.android.gms.internal.measurement.zzfx zzfxVarZzu;
        long j;
        long j2;
        Map<String, String> mapZzc;
        ArrayList arrayList;
        zzag zzagVarZzc;
        zzg zzgVarZzj;
        List<zzkx> listZzu;
        int i2;
        zzaj zzajVar3;
        com.google.android.gms.internal.measurement.zzfy zzfyVar;
        zzaj zzajVar4;
        zzaq zzaqVar;
        int i3;
        ContentValues contentValues;
        Preconditions.checkNotNull(zzpVar);
        Preconditions.checkNotEmpty(zzpVar.zza);
        long jNanoTime = System.nanoTime();
        zzaz().zzg();
        zzB();
        String str8 = zzpVar.zza;
        zzak(this.zzi);
        if (zzku.zzB(zzatVar, zzpVar)) {
            if (!zzpVar.zzh) {
                zzd(zzpVar);
                return;
            }
            zzfm zzfmVar = this.zzc;
            zzak(zzfmVar);
            if (zzfmVar.zzo(str8, zzatVar.zza)) {
                zzay().zzk().zzc("Dropping blocked event. appId", zzel.zzn(str8), this.zzn.zzj().zzd(zzatVar.zza));
                zzfm zzfmVar2 = this.zzc;
                zzak(zzfmVar2);
                if (!zzfmVar2.zzm(str8)) {
                    zzfm zzfmVar3 = this.zzc;
                    zzak(zzfmVar3);
                    if (!zzfmVar3.zzp(str8)) {
                        if ("_err".equals(zzatVar.zza)) {
                            return;
                        }
                        zzv().zzM(this.zzC, str8, 11, "_ev", zzatVar.zza, 0);
                        return;
                    }
                }
                zzaj zzajVar5 = this.zze;
                zzak(zzajVar5);
                zzg zzgVarZzj2 = zzajVar5.zzj(str8);
                if (zzgVarZzj2 != null) {
                    long jAbs = Math.abs(zzav().currentTimeMillis() - Math.max(zzgVarZzj2.zzl(), zzgVarZzj2.zzc()));
                    zzg();
                    if (jAbs > zzdy.zzy.zza(null).longValue()) {
                        zzay().zzc().zza("Fetching config for blocked app");
                        zzC(zzgVarZzj2);
                        return;
                    }
                    return;
                }
                return;
            }
            zzem zzemVarZzb = zzem.zzb(zzatVar);
            zzv().zzL(zzemVarZzb, zzg().zzd(str8));
            zzat zzatVarZza = zzemVarZzb.zza();
            if (Log.isLoggable(zzay().zzq(), 2)) {
                zzay().zzj().zzb("Logging event", this.zzn.zzj().zzc(zzatVarZza));
            }
            zzaj zzajVar6 = this.zze;
            zzak(zzajVar6);
            zzajVar6.zzw();
            try {
                zzd(zzpVar);
                zzmt.zzc();
                if (!zzg().zzs(null, zzdy.zzav) && zzg().zzs(null, zzdy.zzaw)) {
                    zzaj zzajVar7 = this.zze;
                    zzak(zzajVar7);
                    zzajVar7.zzB(zzpVar.zza, "_lair");
                }
                boolean z = FirebaseAnalytics.Event.ECOMMERCE_PURCHASE.equals(zzatVarZza.zza) || FirebaseAnalytics.Event.PURCHASE.equals(zzatVarZza.zza) || FirebaseAnalytics.Event.REFUND.equals(zzatVarZza.zza);
                if ("_iap".equals(zzatVarZza.zza)) {
                    strZzg = zzatVarZza.zzb.zzg(FirebaseAnalytics.Param.CURRENCY);
                    if (z) {
                        str = "_err";
                        jLongValue = zzatVarZza.zzb.zze("value").longValue();
                    } else {
                        double dDoubleValue = zzatVarZza.zzb.zzd("value").doubleValue() * 1000000.0d;
                        if (dDoubleValue == 0.0d) {
                            str = "_err";
                            dDoubleValue = zzatVarZza.zzb.zze("value").longValue() * 1000000.0d;
                        } else {
                            str = "_err";
                        }
                        if (dDoubleValue > 9.223372036854776E18d || dDoubleValue < -9.223372036854776E18d) {
                            zzay().zzk().zzc("Data lost. Currency value is too big. appId", zzel.zzn(str8), Double.valueOf(dDoubleValue));
                            zzaj zzajVar8 = this.zze;
                            zzak(zzajVar8);
                            zzajVar8.zzD();
                            return;
                        }
                        jLongValue = Math.round(dDoubleValue);
                        if (FirebaseAnalytics.Event.REFUND.equals(zzatVarZza.zza)) {
                            jLongValue = -jLongValue;
                        }
                    }
                    if (!TextUtils.isEmpty(strZzg)) {
                        String upperCase = strZzg.toUpperCase(Locale.US);
                        if (upperCase.matches("[A-Z]{3}")) {
                            String strValueOf = String.valueOf(upperCase);
                            String strConcat = strValueOf.length() != 0 ? "_ltv_".concat(strValueOf) : new String("_ltv_");
                            zzaj zzajVar9 = this.zze;
                            zzak(zzajVar9);
                            zzkx zzkxVarZzp = zzajVar9.zzp(str8, strConcat);
                            if (zzkxVarZzp != null) {
                                Object obj = zzkxVarZzp.zze;
                                if (obj instanceof Long) {
                                    str2 = "metadata_fingerprint";
                                    str3 = str;
                                    zzkxVar = new zzkx(str8, zzatVarZza.zzc, strConcat, zzav().currentTimeMillis(), Long.valueOf(((Long) obj).longValue() + jLongValue));
                                    zzajVar2 = this.zze;
                                    zzak(zzajVar2);
                                    if (!zzajVar2.zzN(zzkxVar)) {
                                    }
                                } else {
                                    str4 = str;
                                    zzajVar = this.zze;
                                    zzak(zzajVar);
                                    int iZze = zzg().zze(str8, zzdy.zzD) - 1;
                                    Preconditions.checkNotEmpty(str8);
                                    zzajVar.zzg();
                                    zzajVar.zzY();
                                    try {
                                        SQLiteDatabase sQLiteDatabaseZzh = zzajVar.zzh();
                                        str5 = str4;
                                    } catch (SQLiteException e) {
                                        e = e;
                                        str2 = "metadata_fingerprint";
                                        str5 = str4;
                                    }
                                    try {
                                        String[] strArr = new String[3];
                                        strArr[0] = str8;
                                        strArr[1] = str8;
                                        str2 = "metadata_fingerprint";
                                    } catch (SQLiteException e2) {
                                        e = e2;
                                        str2 = "metadata_fingerprint";
                                        zzajVar.zzs.zzay().zzd().zzc("Error pruning currencies. appId", zzel.zzn(str8), e);
                                        str3 = str5;
                                        zzkxVar = new zzkx(str8, zzatVarZza.zzc, strConcat, zzav().currentTimeMillis(), Long.valueOf(jLongValue));
                                        zzajVar2 = this.zze;
                                        zzak(zzajVar2);
                                        if (!zzajVar2.zzN(zzkxVar)) {
                                        }
                                        boolean zZzah = zzkz.zzah(zzatVarZza.zza);
                                        boolean zEquals = str3.equals(zzatVarZza.zza);
                                        zzv();
                                        zzarVar = zzatVarZza.zzb;
                                        if (zzarVar == null) {
                                        }
                                        zzaj zzajVar10 = this.zze;
                                        zzak(zzajVar10);
                                        zzah zzahVarZzm = zzajVar10.zzm(zza(), str8, length + 1, true, zZzah, false, zEquals, false);
                                        long j3 = zzahVarZzm.zzb;
                                        zzg();
                                        jIntValue = j3 - zzdy.zzj.zza(null).intValue();
                                        if (jIntValue > 0) {
                                        }
                                    }
                                    try {
                                        strArr[2] = String.valueOf(iZze);
                                        sQLiteDatabaseZzh.execSQL("delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);", strArr);
                                    } catch (SQLiteException e3) {
                                        e = e3;
                                        zzajVar.zzs.zzay().zzd().zzc("Error pruning currencies. appId", zzel.zzn(str8), e);
                                        str3 = str5;
                                        zzkxVar = new zzkx(str8, zzatVarZza.zzc, strConcat, zzav().currentTimeMillis(), Long.valueOf(jLongValue));
                                        zzajVar2 = this.zze;
                                        zzak(zzajVar2);
                                        if (!zzajVar2.zzN(zzkxVar)) {
                                        }
                                        boolean zZzah2 = zzkz.zzah(zzatVarZza.zza);
                                        boolean zEquals2 = str3.equals(zzatVarZza.zza);
                                        zzv();
                                        zzarVar = zzatVarZza.zzb;
                                        if (zzarVar == null) {
                                        }
                                        zzaj zzajVar102 = this.zze;
                                        zzak(zzajVar102);
                                        zzah zzahVarZzm2 = zzajVar102.zzm(zza(), str8, length + 1, true, zZzah2, false, zEquals2, false);
                                        long j32 = zzahVarZzm2.zzb;
                                        zzg();
                                        jIntValue = j32 - zzdy.zzj.zza(null).intValue();
                                        if (jIntValue > 0) {
                                        }
                                    }
                                    str3 = str5;
                                    zzkxVar = new zzkx(str8, zzatVarZza.zzc, strConcat, zzav().currentTimeMillis(), Long.valueOf(jLongValue));
                                    zzajVar2 = this.zze;
                                    zzak(zzajVar2);
                                    if (!zzajVar2.zzN(zzkxVar)) {
                                        zzay().zzd().zzd("Too many unique user properties are set. Ignoring user property. appId", zzel.zzn(str8), this.zzn.zzj().zzf(zzkxVar.zzc), zzkxVar.zze);
                                        zzv().zzM(this.zzC, str8, 9, null, null, 0);
                                    }
                                }
                            } else {
                                str4 = str;
                                zzajVar = this.zze;
                                zzak(zzajVar);
                                int iZze2 = zzg().zze(str8, zzdy.zzD) - 1;
                                Preconditions.checkNotEmpty(str8);
                                zzajVar.zzg();
                                zzajVar.zzY();
                                SQLiteDatabase sQLiteDatabaseZzh2 = zzajVar.zzh();
                                str5 = str4;
                                String[] strArr2 = new String[3];
                                strArr2[0] = str8;
                                strArr2[1] = str8;
                                str2 = "metadata_fingerprint";
                                strArr2[2] = String.valueOf(iZze2);
                                sQLiteDatabaseZzh2.execSQL("delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);", strArr2);
                                str3 = str5;
                                zzkxVar = new zzkx(str8, zzatVarZza.zzc, strConcat, zzav().currentTimeMillis(), Long.valueOf(jLongValue));
                                zzajVar2 = this.zze;
                                zzak(zzajVar2);
                                if (!zzajVar2.zzN(zzkxVar)) {
                                }
                            }
                        }
                    }
                    str2 = "metadata_fingerprint";
                    str3 = str;
                } else if (z) {
                    z = true;
                    strZzg = zzatVarZza.zzb.zzg(FirebaseAnalytics.Param.CURRENCY);
                    if (z) {
                    }
                    if (!TextUtils.isEmpty(strZzg)) {
                    }
                    str2 = "metadata_fingerprint";
                    str3 = str;
                } else {
                    str2 = "metadata_fingerprint";
                    str3 = "_err";
                }
                boolean zZzah22 = zzkz.zzah(zzatVarZza.zza);
                boolean zEquals22 = str3.equals(zzatVarZza.zza);
                zzv();
                zzarVar = zzatVarZza.zzb;
                if (zzarVar == null) {
                    length = 0;
                } else {
                    zzaq zzaqVar2 = new zzaq(zzarVar);
                    length = 0;
                    while (zzaqVar2.hasNext()) {
                        if (zzarVar.zzf(zzaqVar2.next()) instanceof Parcelable[]) {
                            length += ((Parcelable[]) r13).length;
                        }
                    }
                }
                zzaj zzajVar1022 = this.zze;
                zzak(zzajVar1022);
                zzah zzahVarZzm22 = zzajVar1022.zzm(zza(), str8, length + 1, true, zZzah22, false, zEquals22, false);
                long j322 = zzahVarZzm22.zzb;
                zzg();
                jIntValue = j322 - zzdy.zzj.zza(null).intValue();
                if (jIntValue > 0) {
                    if (jIntValue % 1000 == 1) {
                        zzay().zzd().zzc("Data loss. Too many events logged. appId, count", zzel.zzn(str8), Long.valueOf(zzahVarZzm22.zzb));
                    }
                    zzaj zzajVar11 = this.zze;
                    zzak(zzajVar11);
                    zzajVar11.zzD();
                    return;
                }
                if (zZzah22) {
                    long j4 = zzahVarZzm22.zza;
                    zzg();
                    long jIntValue2 = j4 - zzdy.zzl.zza(null).intValue();
                    if (jIntValue2 > 0) {
                        if (jIntValue2 % 1000 == 1) {
                            zzay().zzd().zzc("Data loss. Too many public events logged. appId, count", zzel.zzn(str8), Long.valueOf(zzahVarZzm22.zza));
                        }
                        zzv().zzM(this.zzC, str8, 16, "_ev", zzatVarZza.zza, 0);
                        zzaj zzajVar12 = this.zze;
                        zzak(zzajVar12);
                        zzajVar12.zzD();
                        return;
                    }
                }
                if (zEquals22) {
                    long jMax = zzahVarZzm22.zzd - Math.max(0, Math.min(DurationKt.NANOS_IN_MILLIS, zzg().zze(zzpVar.zza, zzdy.zzk)));
                    if (jMax > 0) {
                        if (jMax == 1) {
                            zzay().zzd().zzc("Too many error events logged. appId, count", zzel.zzn(str8), Long.valueOf(zzahVarZzm22.zzd));
                        }
                        zzaj zzajVar13 = this.zze;
                        zzak(zzajVar13);
                        zzajVar13.zzD();
                        return;
                    }
                }
                Bundle bundleZzc = zzatVarZza.zzb.zzc();
                zzv().zzN(bundleZzc, "_o", zzatVarZza.zzc);
                if (zzv().zzad(str8)) {
                    zzv().zzN(bundleZzc, "_dbg", 1L);
                    zzv().zzN(bundleZzc, "_r", 1L);
                }
                if ("_s".equals(zzatVarZza.zza)) {
                    zzaj zzajVar14 = this.zze;
                    zzak(zzajVar14);
                    zzkx zzkxVarZzp2 = zzajVar14.zzp(zzpVar.zza, "_sno");
                    if (zzkxVarZzp2 != null && (zzkxVarZzp2.zze instanceof Long)) {
                        zzv().zzN(bundleZzc, "_sno", zzkxVarZzp2.zze);
                    }
                }
                zzaj zzajVar15 = this.zze;
                zzak(zzajVar15);
                Preconditions.checkNotEmpty(str8);
                zzajVar15.zzg();
                zzajVar15.zzY();
                try {
                    i = 0;
                    try {
                        str6 = "raw_events";
                        try {
                            jDelete = zzajVar15.zzh().delete(str6, "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str8, String.valueOf(Math.max(0, Math.min(DurationKt.NANOS_IN_MILLIS, zzajVar15.zzs.zzf().zze(str8, zzdy.zzo))))});
                        } catch (SQLiteException e4) {
                            e = e4;
                            zzajVar15.zzs.zzay().zzd().zzc("Error deleting over the limit events. appId", zzel.zzn(str8), e);
                            jDelete = 0;
                            if (jDelete > 0) {
                            }
                            int i4 = i;
                            str7 = str6;
                            zzaoVar = new zzao(this.zzn, zzatVarZza.zzc, str8, zzatVarZza.zza, zzatVarZza.zzd, 0L, bundleZzc);
                            zzaj zzajVar16 = this.zze;
                            zzak(zzajVar16);
                            zzapVarZzn = zzajVar16.zzn(str8, zzaoVar.zzb);
                            if (zzapVarZzn != null) {
                            }
                            zzaj zzajVar17 = this.zze;
                            zzak(zzajVar17);
                            zzajVar17.zzF(zzapVarZzc);
                            zzaz().zzg();
                            zzB();
                            Preconditions.checkNotNull(zzaoVar);
                            Preconditions.checkNotNull(zzpVar);
                            Preconditions.checkNotEmpty(zzaoVar.zza);
                            Preconditions.checkArgument(zzaoVar.zza.equals(zzpVar.zza));
                            zzfxVarZzu = com.google.android.gms.internal.measurement.zzfy.zzu();
                            zzfxVarZzu.zzaa(1);
                            zzfxVarZzu.zzW(com.facebook.appevents.codeless.internal.Constants.PLATFORM);
                            if (!TextUtils.isEmpty(zzpVar.zza)) {
                            }
                            if (!TextUtils.isEmpty(zzpVar.zzd)) {
                            }
                            if (!TextUtils.isEmpty(zzpVar.zzc)) {
                            }
                            j = zzpVar.zzj;
                            if (j != -2147483648L) {
                            }
                            zzfxVarZzu.zzS(zzpVar.zze);
                            if (!TextUtils.isEmpty(zzpVar.zzb)) {
                            }
                            zzfxVarZzu.zzI(zzh((String) Preconditions.checkNotNull(zzpVar.zza)).zzc(zzag.zzb(zzpVar.zzv)).zzi());
                            zzom.zzc();
                            if (!zzg().zzs(zzpVar.zza, zzdy.zzac)) {
                            }
                            j2 = zzpVar.zzf;
                            if (j2 != 0) {
                            }
                            zzfxVarZzu.zzM(zzpVar.zzs);
                            zzku zzkuVar = this.zzi;
                            zzak(zzkuVar);
                            mapZzc = zzdy.zzc(zzkuVar.zzf.zzn.zzau());
                            if (mapZzc != null) {
                                arrayList = null;
                            }
                            if (arrayList != null) {
                            }
                            zzagVarZzc = zzh((String) Preconditions.checkNotNull(zzpVar.zza)).zzc(zzag.zzb(zzpVar.zzv));
                            if (zzagVarZzc.zzj()) {
                            }
                            this.zzn.zzg().zzu();
                            zzfxVarZzu.zzK(Build.MODEL);
                            this.zzn.zzg().zzu();
                            zzfxVarZzu.zzV(Build.VERSION.RELEASE);
                            zzfxVarZzu.zzaf((int) this.zzn.zzg().zzb());
                            zzfxVarZzu.zzaj(this.zzn.zzg().zzc());
                            if (!zzg().zzs(null, zzdy.zzam)) {
                            }
                            if (this.zzn.zzJ()) {
                            }
                            zzaj zzajVar18 = this.zze;
                            zzak(zzajVar18);
                            zzgVarZzj = zzajVar18.zzj(zzpVar.zza);
                            if (zzgVarZzj == null) {
                            }
                            if (zzagVarZzc.zzk()) {
                                zzfxVarZzu.zzB((String) Preconditions.checkNotNull(zzgVarZzj.zzu()));
                            }
                            if (!TextUtils.isEmpty(zzgVarZzj.zzx())) {
                            }
                            zzaj zzajVar19 = this.zze;
                            zzak(zzajVar19);
                            listZzu = zzajVar19.zzu(zzpVar.zza);
                            while (i2 < listZzu.size()) {
                            }
                            zzajVar3 = this.zze;
                            zzak(zzajVar3);
                            zzfyVar = (com.google.android.gms.internal.measurement.zzfy) zzfxVarZzu.zzaA();
                            zzajVar3.zzg();
                            zzajVar3.zzY();
                            Preconditions.checkNotNull(zzfyVar);
                            Preconditions.checkNotEmpty(zzfyVar.zzy());
                            byte[] bArrZzbs = zzfyVar.zzbs();
                            zzku zzkuVar2 = zzajVar3.zzf.zzi;
                            zzak(zzkuVar2);
                            long jZzd = zzkuVar2.zzd(bArrZzbs);
                            ContentValues contentValues2 = new ContentValues();
                            contentValues2.put("app_id", zzfyVar.zzy());
                            String str9 = str2;
                            contentValues2.put(str9, Long.valueOf(jZzd));
                            contentValues2.put(MBTilesFileArchive.TABLE_METADATA, bArrZzbs);
                            zzajVar3.zzh().insertWithOnConflict("raw_events_metadata", null, contentValues2, 4);
                            zzajVar4 = this.zze;
                            zzak(zzajVar4);
                            zzaqVar = new zzaq(zzaoVar.zzf);
                            while (true) {
                                if (!zzaqVar.hasNext()) {
                                }
                            }
                            i3 = 1;
                            zzajVar4.zzg();
                            zzajVar4.zzY();
                            Preconditions.checkNotNull(zzaoVar);
                            Preconditions.checkNotEmpty(zzaoVar.zza);
                            zzku zzkuVar3 = zzajVar4.zzf.zzi;
                            zzak(zzkuVar3);
                            byte[] bArrZzbs2 = zzkuVar3.zzj(zzaoVar).zzbs();
                            contentValues = new ContentValues();
                            contentValues.put("app_id", zzaoVar.zza);
                            contentValues.put("name", zzaoVar.zzb);
                            contentValues.put("timestamp", Long.valueOf(zzaoVar.zzd));
                            contentValues.put(str9, Long.valueOf(jZzd));
                            contentValues.put("data", bArrZzbs2);
                            contentValues.put("realtime", Integer.valueOf(i3));
                            try {
                                if (zzajVar4.zzh().insert(str7, null, contentValues) != -1) {
                                }
                            } catch (SQLiteException e5) {
                                zzajVar4.zzs.zzay().zzd().zzc("Error storing raw event. appId", zzel.zzn(zzaoVar.zza), e5);
                            }
                            zzaj zzajVar20 = this.zze;
                            zzak(zzajVar20);
                            zzajVar20.zzD();
                            zzaj zzajVar21 = this.zze;
                            zzak(zzajVar21);
                            zzajVar21.zzy();
                            zzaf();
                            zzay().zzj().zzb("Background event processing time, ms", Long.valueOf(((System.nanoTime() - jNanoTime) + 500000) / 1000000));
                        }
                    } catch (SQLiteException e6) {
                        e = e6;
                        str6 = "raw_events";
                    }
                } catch (SQLiteException e7) {
                    e = e7;
                    str6 = "raw_events";
                    i = 0;
                }
                if (jDelete > 0) {
                    zzay().zzk().zzc("Data lost. Too many events stored on disk, deleted. appId", zzel.zzn(str8), Long.valueOf(jDelete));
                }
                int i42 = i;
                str7 = str6;
                zzaoVar = new zzao(this.zzn, zzatVarZza.zzc, str8, zzatVarZza.zza, zzatVarZza.zzd, 0L, bundleZzc);
                zzaj zzajVar162 = this.zze;
                zzak(zzajVar162);
                zzapVarZzn = zzajVar162.zzn(str8, zzaoVar.zzb);
                if (zzapVarZzn != null) {
                    zzaj zzajVar22 = this.zze;
                    zzak(zzajVar22);
                    if (zzajVar22.zzf(str8) >= zzg().zzb(str8) && zZzah22) {
                        zzay().zzd().zzd("Too many event names used, ignoring event. appId, name, supported count", zzel.zzn(str8), this.zzn.zzj().zzd(zzaoVar.zzb), Integer.valueOf(zzg().zzb(str8)));
                        zzv().zzM(this.zzC, str8, 8, null, null, 0);
                        return;
                    }
                    zzapVarZzc = new zzap(str8, zzaoVar.zzb, 0L, 0L, 0L, zzaoVar.zzd, 0L, null, null, null, null);
                } else {
                    zzaoVar = zzaoVar.zza(this.zzn, zzapVarZzn.zzf);
                    zzapVarZzc = zzapVarZzn.zzc(zzaoVar.zzd);
                }
                zzaj zzajVar172 = this.zze;
                zzak(zzajVar172);
                zzajVar172.zzF(zzapVarZzc);
                zzaz().zzg();
                zzB();
                Preconditions.checkNotNull(zzaoVar);
                Preconditions.checkNotNull(zzpVar);
                Preconditions.checkNotEmpty(zzaoVar.zza);
                Preconditions.checkArgument(zzaoVar.zza.equals(zzpVar.zza));
                zzfxVarZzu = com.google.android.gms.internal.measurement.zzfy.zzu();
                zzfxVarZzu.zzaa(1);
                zzfxVarZzu.zzW(com.facebook.appevents.codeless.internal.Constants.PLATFORM);
                if (!TextUtils.isEmpty(zzpVar.zza)) {
                    zzfxVarZzu.zzA(zzpVar.zza);
                }
                if (!TextUtils.isEmpty(zzpVar.zzd)) {
                    zzfxVarZzu.zzC(zzpVar.zzd);
                }
                if (!TextUtils.isEmpty(zzpVar.zzc)) {
                    zzfxVarZzu.zzD(zzpVar.zzc);
                }
                j = zzpVar.zzj;
                if (j != -2147483648L) {
                    zzfxVarZzu.zzE((int) j);
                }
                zzfxVarZzu.zzS(zzpVar.zze);
                if (!TextUtils.isEmpty(zzpVar.zzb)) {
                    zzfxVarZzu.zzR(zzpVar.zzb);
                }
                zzfxVarZzu.zzI(zzh((String) Preconditions.checkNotNull(zzpVar.zza)).zzc(zzag.zzb(zzpVar.zzv)).zzi());
                zzom.zzc();
                if (!zzg().zzs(zzpVar.zza, zzdy.zzac)) {
                    if (TextUtils.isEmpty(zzfxVarZzu.zzan()) && !TextUtils.isEmpty(zzpVar.zzu)) {
                        zzfxVarZzu.zzQ(zzpVar.zzu);
                    }
                    if (TextUtils.isEmpty(zzfxVarZzu.zzan()) && TextUtils.isEmpty(zzfxVarZzu.zzam()) && !TextUtils.isEmpty(zzpVar.zzq)) {
                        zzfxVarZzu.zzy(zzpVar.zzq);
                    }
                } else if (TextUtils.isEmpty(zzfxVarZzu.zzan()) && !TextUtils.isEmpty(zzpVar.zzq)) {
                    zzfxVarZzu.zzy(zzpVar.zzq);
                }
                j2 = zzpVar.zzf;
                if (j2 != 0) {
                    zzfxVarZzu.zzJ(j2);
                }
                zzfxVarZzu.zzM(zzpVar.zzs);
                zzku zzkuVar4 = this.zzi;
                zzak(zzkuVar4);
                mapZzc = zzdy.zzc(zzkuVar4.zzf.zzn.zzau());
                if (mapZzc != null || mapZzc.size() == 0) {
                    arrayList = null;
                } else {
                    arrayList = new ArrayList();
                    int iIntValue = zzdy.zzO.zza(null).intValue();
                    for (Map.Entry<String, String> entry : mapZzc.entrySet()) {
                        if (entry.getKey().startsWith("measurement.id.")) {
                            try {
                                int i5 = Integer.parseInt(entry.getValue());
                                if (i5 != 0) {
                                    arrayList.add(Integer.valueOf(i5));
                                    if (arrayList.size() >= iIntValue) {
                                        zzkuVar4.zzs.zzay().zzk().zzb("Too many experiment IDs. Number of IDs", Integer.valueOf(arrayList.size()));
                                        break;
                                    }
                                    continue;
                                } else {
                                    continue;
                                }
                            } catch (NumberFormatException e8) {
                                zzkuVar4.zzs.zzay().zzk().zzb("Experiment ID NumberFormatException", e8);
                            }
                        }
                    }
                    if (arrayList.size() == 0) {
                    }
                }
                if (arrayList != null) {
                    zzfxVarZzu.zzh(arrayList);
                }
                zzagVarZzc = zzh((String) Preconditions.checkNotNull(zzpVar.zza)).zzc(zzag.zzb(zzpVar.zzv));
                if (zzagVarZzc.zzj()) {
                    Pair<String, Boolean> pairZzd = this.zzk.zzd(zzpVar.zza, zzagVarZzc);
                    if (!TextUtils.isEmpty((CharSequence) pairZzd.first) && zzpVar.zzo) {
                        zzfxVarZzu.zzab((String) pairZzd.first);
                        if (pairZzd.second != null) {
                            zzfxVarZzu.zzU(((Boolean) pairZzd.second).booleanValue());
                        }
                    }
                }
                this.zzn.zzg().zzu();
                zzfxVarZzu.zzK(Build.MODEL);
                this.zzn.zzg().zzu();
                zzfxVarZzu.zzV(Build.VERSION.RELEASE);
                zzfxVarZzu.zzaf((int) this.zzn.zzg().zzb());
                zzfxVarZzu.zzaj(this.zzn.zzg().zzc());
                if (!zzg().zzs(null, zzdy.zzam)) {
                    zzfxVarZzu.zzz(zzpVar.zzl);
                }
                if (this.zzn.zzJ()) {
                    zzfxVarZzu.zzal();
                    if (!TextUtils.isEmpty(null)) {
                        zzfxVarZzu.zzL(null);
                    }
                }
                zzaj zzajVar182 = this.zze;
                zzak(zzajVar182);
                zzgVarZzj = zzajVar182.zzj(zzpVar.zza);
                if (zzgVarZzj == null) {
                    zzgVarZzj = new zzg(this.zzn, zzpVar.zza);
                    zzgVarZzj.zzI(zzw(zzagVarZzc));
                    zzgVarZzj.zzW(zzpVar.zzk);
                    zzgVarZzj.zzY(zzpVar.zzb);
                    if (zzagVarZzc.zzj()) {
                        zzgVarZzj.zzag(this.zzk.zzf(zzpVar.zza));
                    }
                    zzgVarZzj.zzac(0L);
                    zzgVarZzj.zzad(0L);
                    zzgVarZzj.zzab(0L);
                    zzgVarZzj.zzK(zzpVar.zzc);
                    zzgVarZzj.zzL(zzpVar.zzj);
                    zzgVarZzj.zzJ(zzpVar.zzd);
                    zzgVarZzj.zzZ(zzpVar.zze);
                    zzgVarZzj.zzT(zzpVar.zzf);
                    zzgVarZzj.zzae(zzpVar.zzh);
                    if (!zzg().zzs(null, zzdy.zzam)) {
                        zzgVarZzj.zzH(zzpVar.zzl);
                    }
                    zzgVarZzj.zzU(zzpVar.zzs);
                    zzaj zzajVar23 = this.zze;
                    zzak(zzajVar23);
                    zzajVar23.zzE(zzgVarZzj);
                }
                if (zzagVarZzc.zzk() && !TextUtils.isEmpty(zzgVarZzj.zzu())) {
                    zzfxVarZzu.zzB((String) Preconditions.checkNotNull(zzgVarZzj.zzu()));
                }
                if (!TextUtils.isEmpty(zzgVarZzj.zzx())) {
                    zzfxVarZzu.zzP((String) Preconditions.checkNotNull(zzgVarZzj.zzx()));
                }
                zzaj zzajVar192 = this.zze;
                zzak(zzajVar192);
                listZzu = zzajVar192.zzu(zzpVar.zza);
                for (i2 = i42; i2 < listZzu.size(); i2++) {
                    com.google.android.gms.internal.measurement.zzgg zzggVarZzd = com.google.android.gms.internal.measurement.zzgh.zzd();
                    zzggVarZzd.zzf(listZzu.get(i2).zzc);
                    zzggVarZzd.zzg(listZzu.get(i2).zzd);
                    zzku zzkuVar5 = this.zzi;
                    zzak(zzkuVar5);
                    zzkuVar5.zzv(zzggVarZzd, listZzu.get(i2).zze);
                    zzfxVarZzu.zzk(zzggVarZzd);
                }
                try {
                    zzajVar3 = this.zze;
                    zzak(zzajVar3);
                    zzfyVar = (com.google.android.gms.internal.measurement.zzfy) zzfxVarZzu.zzaA();
                    zzajVar3.zzg();
                    zzajVar3.zzY();
                    Preconditions.checkNotNull(zzfyVar);
                    Preconditions.checkNotEmpty(zzfyVar.zzy());
                    byte[] bArrZzbs3 = zzfyVar.zzbs();
                    zzku zzkuVar22 = zzajVar3.zzf.zzi;
                    zzak(zzkuVar22);
                    long jZzd2 = zzkuVar22.zzd(bArrZzbs3);
                    ContentValues contentValues22 = new ContentValues();
                    contentValues22.put("app_id", zzfyVar.zzy());
                    String str92 = str2;
                    contentValues22.put(str92, Long.valueOf(jZzd2));
                    contentValues22.put(MBTilesFileArchive.TABLE_METADATA, bArrZzbs3);
                } catch (IOException e9) {
                    zzay().zzd().zzc("Data loss. Failed to insert raw event metadata. appId", zzel.zzn(zzfxVarZzu.zzal()), e9);
                }
                try {
                    zzajVar3.zzh().insertWithOnConflict("raw_events_metadata", null, contentValues22, 4);
                    zzajVar4 = this.zze;
                    zzak(zzajVar4);
                    zzaqVar = new zzaq(zzaoVar.zzf);
                    while (true) {
                        if (!zzaqVar.hasNext()) {
                            if ("_r".equals(zzaqVar.next())) {
                                break;
                            }
                        } else {
                            zzfm zzfmVar4 = this.zzc;
                            zzak(zzfmVar4);
                            boolean zZzn = zzfmVar4.zzn(zzaoVar.zza, zzaoVar.zzb);
                            zzaj zzajVar24 = this.zze;
                            zzak(zzajVar24);
                            zzah zzahVarZzl = zzajVar24.zzl(zza(), zzaoVar.zza, false, false, false, false, false);
                            if (!zZzn || zzahVarZzl.zze >= zzg().zze(zzaoVar.zza, zzdy.zzn)) {
                                i3 = i42;
                            }
                        }
                    }
                    i3 = 1;
                    zzajVar4.zzg();
                    zzajVar4.zzY();
                    Preconditions.checkNotNull(zzaoVar);
                    Preconditions.checkNotEmpty(zzaoVar.zza);
                    zzku zzkuVar32 = zzajVar4.zzf.zzi;
                    zzak(zzkuVar32);
                    byte[] bArrZzbs22 = zzkuVar32.zzj(zzaoVar).zzbs();
                    contentValues = new ContentValues();
                    contentValues.put("app_id", zzaoVar.zza);
                    contentValues.put("name", zzaoVar.zzb);
                    contentValues.put("timestamp", Long.valueOf(zzaoVar.zzd));
                    contentValues.put(str92, Long.valueOf(jZzd2));
                    contentValues.put("data", bArrZzbs22);
                    contentValues.put("realtime", Integer.valueOf(i3));
                    if (zzajVar4.zzh().insert(str7, null, contentValues) != -1) {
                        zzajVar4.zzs.zzay().zzd().zzb("Failed to insert raw event (got -1). appId", zzel.zzn(zzaoVar.zza));
                    } else {
                        this.zza = 0L;
                    }
                    zzaj zzajVar202 = this.zze;
                    zzak(zzajVar202);
                    zzajVar202.zzD();
                    zzaj zzajVar212 = this.zze;
                    zzak(zzajVar212);
                    zzajVar212.zzy();
                    zzaf();
                    zzay().zzj().zzb("Background event processing time, ms", Long.valueOf(((System.nanoTime() - jNanoTime) + 500000) / 1000000));
                } catch (SQLiteException e10) {
                    zzajVar3.zzs.zzay().zzd().zzc("Error storing raw event metadata. appId", zzel.zzn(zzfyVar.zzy()), e10);
                    throw e10;
                }
            } finally {
                zzaj zzajVar25 = this.zze;
                zzak(zzajVar25);
                zzajVar25.zzy();
            }
        }
    }

    final boolean zzX() throws IOException {
        zzaz().zzg();
        FileLock fileLock = this.zzw;
        if (fileLock != null && fileLock.isValid()) {
            zzay().zzj().zza("Storage concurrent access okay");
            return true;
        }
        this.zze.zzs.zzf();
        try {
            FileChannel channel = new RandomAccessFile(new File(this.zzn.zzau().getFilesDir(), "google_app_measurement.db"), "rw").getChannel();
            this.zzx = channel;
            FileLock fileLockTryLock = channel.tryLock();
            this.zzw = fileLockTryLock;
            if (fileLockTryLock != null) {
                zzay().zzj().zza("Storage concurrent access okay");
                return true;
            }
            zzay().zzd().zza("Storage concurrent data access panic");
            return false;
        } catch (FileNotFoundException e) {
            zzay().zzd().zzb("Failed to acquire storage lock", e);
            return false;
        } catch (IOException e2) {
            zzay().zzd().zzb("Failed to access storage lock file", e2);
            return false;
        } catch (OverlappingFileLockException e3) {
            zzay().zzk().zzb("Storage lock already acquired", e3);
            return false;
        }
    }

    final long zza() {
        long jCurrentTimeMillis = zzav().currentTimeMillis();
        zzjp zzjpVar = this.zzk;
        zzjpVar.zzY();
        zzjpVar.zzg();
        long jZza = zzjpVar.zze.zza();
        if (jZza == 0) {
            jZza = zzjpVar.zzs.zzv().zzF().nextInt(DateTimeConstants.MILLIS_PER_DAY) + 1;
            zzjpVar.zze.zzb(jZza);
        }
        return ((((jCurrentTimeMillis + jZza) / 1000) / 60) / 60) / 24;
    }

    @Override // com.google.android.gms.measurement.internal.zzgq
    public final Context zzau() {
        return this.zzn.zzau();
    }

    @Override // com.google.android.gms.measurement.internal.zzgq
    public final Clock zzav() {
        return ((zzfv) Preconditions.checkNotNull(this.zzn)).zzav();
    }

    @Override // com.google.android.gms.measurement.internal.zzgq
    public final zzaa zzaw() {
        throw null;
    }

    @Override // com.google.android.gms.measurement.internal.zzgq
    public final zzel zzay() {
        return ((zzfv) Preconditions.checkNotNull(this.zzn)).zzay();
    }

    @Override // com.google.android.gms.measurement.internal.zzgq
    public final zzfs zzaz() {
        return ((zzfv) Preconditions.checkNotNull(this.zzn)).zzaz();
    }

    final zzg zzd(zzp zzpVar) {
        zzaz().zzg();
        zzB();
        Preconditions.checkNotNull(zzpVar);
        Preconditions.checkNotEmpty(zzpVar.zza);
        zzaj zzajVar = this.zze;
        zzak(zzajVar);
        zzg zzgVarZzj = zzajVar.zzj(zzpVar.zza);
        zzag zzagVarZzc = zzh(zzpVar.zza).zzc(zzag.zzb(zzpVar.zzv));
        String strZzf = zzagVarZzc.zzj() ? this.zzk.zzf(zzpVar.zza) : "";
        if (zzgVarZzj == null) {
            zzgVarZzj = new zzg(this.zzn, zzpVar.zza);
            if (zzagVarZzc.zzk()) {
                zzgVarZzj.zzI(zzw(zzagVarZzc));
            }
            if (zzagVarZzc.zzj()) {
                zzgVarZzj.zzag(strZzf);
            }
        } else if (zzagVarZzc.zzj() && strZzf != null && !strZzf.equals(zzgVarZzj.zzB())) {
            zzgVarZzj.zzag(strZzf);
            zzmt.zzc();
            if (!zzg().zzs(null, zzdy.zzav) || !zzg().zzs(null, zzdy.zzaz) || !"00000000-0000-0000-0000-000000000000".equals(this.zzk.zzd(zzpVar.zza, zzagVarZzc).first)) {
                zzgVarZzj.zzI(zzw(zzagVarZzc));
            }
            zzmt.zzc();
            if (zzg().zzs(null, zzdy.zzav) && !"00000000-0000-0000-0000-000000000000".equals(this.zzk.zzd(zzpVar.zza, zzagVarZzc).first)) {
                zzaj zzajVar2 = this.zze;
                zzak(zzajVar2);
                if (zzajVar2.zzp(zzpVar.zza, "_id") != null) {
                    zzaj zzajVar3 = this.zze;
                    zzak(zzajVar3);
                    if (zzajVar3.zzp(zzpVar.zza, "_lair") == null) {
                        zzkx zzkxVar = new zzkx(zzpVar.zza, "auto", "_lair", zzav().currentTimeMillis(), 1L);
                        zzaj zzajVar4 = this.zze;
                        zzak(zzajVar4);
                        zzajVar4.zzN(zzkxVar);
                    }
                }
            }
        } else if (TextUtils.isEmpty(zzgVarZzj.zzu()) && zzagVarZzc.zzk()) {
            zzgVarZzj.zzI(zzw(zzagVarZzc));
        }
        zzgVarZzj.zzY(zzpVar.zzb);
        zzgVarZzj.zzF(zzpVar.zzq);
        zzom.zzc();
        if (zzg().zzs(zzgVarZzj.zzt(), zzdy.zzac)) {
            zzgVarZzj.zzX(zzpVar.zzu);
        }
        if (!TextUtils.isEmpty(zzpVar.zzk)) {
            zzgVarZzj.zzW(zzpVar.zzk);
        }
        long j = zzpVar.zze;
        if (j != 0) {
            zzgVarZzj.zzZ(j);
        }
        if (!TextUtils.isEmpty(zzpVar.zzc)) {
            zzgVarZzj.zzK(zzpVar.zzc);
        }
        zzgVarZzj.zzL(zzpVar.zzj);
        String str = zzpVar.zzd;
        if (str != null) {
            zzgVarZzj.zzJ(str);
        }
        zzgVarZzj.zzT(zzpVar.zzf);
        zzgVarZzj.zzae(zzpVar.zzh);
        if (!TextUtils.isEmpty(zzpVar.zzg)) {
            zzgVarZzj.zzaa(zzpVar.zzg);
        }
        if (!zzg().zzs(null, zzdy.zzam)) {
            zzgVarZzj.zzH(zzpVar.zzl);
        }
        zzgVarZzj.zzG(zzpVar.zzo);
        zzgVarZzj.zzaf(zzpVar.zzr);
        zzgVarZzj.zzU(zzpVar.zzs);
        if (zzgVarZzj.zzak()) {
            zzaj zzajVar5 = this.zze;
            zzak(zzajVar5);
            zzajVar5.zzE(zzgVarZzj);
        }
        return zzgVarZzj;
    }

    public final zzz zzf() {
        zzz zzzVar = this.zzh;
        zzak(zzzVar);
        return zzzVar;
    }

    public final zzaf zzg() {
        return ((zzfv) Preconditions.checkNotNull(this.zzn)).zzf();
    }

    final zzag zzh(String str) {
        String string;
        zzaz().zzg();
        zzB();
        zzag zzagVar = this.zzB.get(str);
        if (zzagVar != null) {
            return zzagVar;
        }
        zzaj zzajVar = this.zze;
        zzak(zzajVar);
        Preconditions.checkNotNull(str);
        zzajVar.zzg();
        zzajVar.zzY();
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = zzajVar.zzh().rawQuery("select consent_state from consent_settings where app_id=? limit 1;", new String[]{str});
                if (cursorRawQuery.moveToFirst()) {
                    string = cursorRawQuery.getString(0);
                } else {
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    string = "G1";
                }
                zzag zzagVarZzb = zzag.zzb(string);
                zzT(str, zzagVarZzb);
                return zzagVarZzb;
            } catch (SQLiteException e) {
                zzajVar.zzs.zzay().zzd().zzc("Database error", "select consent_state from consent_settings where app_id=? limit 1;", e);
                throw e;
            }
        } finally {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        }
    }

    public final zzaj zzi() {
        zzaj zzajVar = this.zze;
        zzak(zzajVar);
        return zzajVar;
    }

    public final zzeg zzj() {
        return this.zzn.zzj();
    }

    public final zzer zzl() {
        zzer zzerVar = this.zzd;
        zzak(zzerVar);
        return zzerVar;
    }

    public final zzet zzm() {
        zzet zzetVar = this.zzf;
        if (zzetVar != null) {
            return zzetVar;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    public final zzfm zzo() {
        zzfm zzfmVar = this.zzc;
        zzak(zzfmVar);
        return zzfmVar;
    }

    final zzfv zzq() {
        return this.zzn;
    }

    public final zzif zzr() {
        zzif zzifVar = this.zzj;
        zzak(zzifVar);
        return zzifVar;
    }

    public final zzjp zzs() {
        return this.zzk;
    }

    public final zzku zzu() {
        zzku zzkuVar = this.zzi;
        zzak(zzkuVar);
        return zzkuVar;
    }

    public final zzkz zzv() {
        return ((zzfv) Preconditions.checkNotNull(this.zzn)).zzv();
    }

    final String zzw(zzag zzagVar) {
        if (!zzagVar.zzk()) {
            return null;
        }
        byte[] bArr = new byte[16];
        zzv().zzF().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new BigInteger(1, bArr));
    }

    final String zzx(zzp zzpVar) throws IllegalStateException {
        try {
            return (String) zzaz().zzh(new zzkn(this, zzpVar)).get(30000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            zzay().zzd().zzc("Failed to get app instance id. appId", zzel.zzn(zzpVar.zza), e);
            return null;
        }
    }

    final void zzz(Runnable runnable) {
        zzaz().zzg();
        if (this.zzq == null) {
            this.zzq = new ArrayList();
        }
        this.zzq.add(runnable);
    }
}
