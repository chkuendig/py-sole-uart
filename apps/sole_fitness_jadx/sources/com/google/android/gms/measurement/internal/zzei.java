package com.google.android.gms.measurement.internal;

import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.internal.security.CertificateUtil;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.0.0 */
/* loaded from: classes2.dex */
final class zzei implements Runnable {
    final /* synthetic */ int zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ Object zzc;
    final /* synthetic */ Object zzd;
    final /* synthetic */ Object zze;
    final /* synthetic */ zzel zzf;

    zzei(zzel zzelVar, int i, String str, Object obj, Object obj2, Object obj3) {
        this.zzf = zzelVar;
        this.zza = i;
        this.zzb = str;
        this.zzc = obj;
        this.zzd = obj2;
        this.zze = obj3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfa zzfaVarZzm = this.zzf.zzs.zzm();
        if (!zzfaVarZzm.zzx()) {
            Log.println(6, this.zzf.zzq(), "Persisted config not initialized. Not logging error/warn");
            return;
        }
        if (this.zzf.zza == 0) {
            if (this.zzf.zzs.zzf().zzy()) {
                zzel zzelVar = this.zzf;
                zzelVar.zzs.zzaw();
                zzelVar.zza = 'C';
            } else {
                zzel zzelVar2 = this.zzf;
                zzelVar2.zzs.zzaw();
                zzelVar2.zza = 'c';
            }
        }
        if (this.zzf.zzb < 0) {
            zzel zzelVar3 = this.zzf;
            zzelVar3.zzs.zzf().zzh();
            zzelVar3.zzb = 46000L;
        }
        char cCharAt = "01VDIWEA?".charAt(this.zza);
        char c = this.zzf.zza;
        long j = this.zzf.zzb;
        String strZzo = zzel.zzo(true, this.zzb, this.zzc, this.zzd, this.zze);
        StringBuilder sb = new StringBuilder(strZzo.length() + 24);
        sb.append(ExifInterface.GPS_MEASUREMENT_2D);
        sb.append(cCharAt);
        sb.append(c);
        sb.append(j);
        sb.append(CertificateUtil.DELIMITER);
        sb.append(strZzo);
        String string = sb.toString();
        if (string.length() > 1024) {
            string = this.zzb.substring(0, 1024);
        }
        zzey zzeyVar = zzfaVarZzm.zzb;
        if (zzeyVar != null) {
            zzeyVar.zzb(string, 1L);
        }
    }
}
