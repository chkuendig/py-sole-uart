package com.google.android.gms.internal.playcore_age_signals;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: com.google.android.play:age-signals@@0.0.2 */
/* loaded from: classes4.dex */
public final class zzr {
    private static final zzd zza = new zzd("PhoneskyVerificationUtils");

    public static int zza(Context context) throws PackageManager.NameNotFoundException {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.android.vending", 64);
            if (packageInfo.applicationInfo != null && packageInfo.applicationInfo.enabled && zzc(packageInfo.signatures)) {
                return packageInfo.versionCode;
            }
            return 0;
        } catch (PackageManager.NameNotFoundException unused) {
            return 0;
        }
    }

    public static boolean zzb(Context context) {
        try {
            if (context.getPackageManager().getApplicationInfo("com.android.vending", 0).enabled) {
                try {
                    if (zzc(context.getPackageManager().getPackageInfo("com.android.vending", 64).signatures)) {
                        return true;
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                    zza.zzd("Play Store package is not found.", new Object[0]);
                }
            } else {
                zza.zzd("Play Store package is disabled.", new Object[0]);
            }
        } catch (PackageManager.NameNotFoundException unused2) {
            zza.zzd("Play Store package is not found.", new Object[0]);
        }
        return false;
    }

    private static boolean zzc(Signature[] signatureArr) throws NoSuchAlgorithmException {
        if (signatureArr == null || (signatureArr.length) == 0) {
            zza.zzd("Play Store package is not signed -- possibly self-built package. Could not verify.", new Object[0]);
            return false;
        }
        ArrayList arrayList = new ArrayList();
        for (Signature signature : signatureArr) {
            String strZza = zzq.zza(signature.toByteArray());
            arrayList.add(strZza);
            if ("8P1sW0EPJcslw7UzRsiXL64w-O50Ed-RBICtay1g24M".equals(strZza)) {
                return true;
            }
            if ((Build.TAGS.contains("dev-keys") || Build.TAGS.contains("test-keys")) && "GXWy8XF3vIml3_MfnmSmyuKBpT3B0dWbHRR_4cgq-gA".equals(strZza)) {
                return true;
            }
        }
        zzd zzdVar = zza;
        StringBuilder sb = new StringBuilder();
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            while (true) {
                sb.append((CharSequence) it.next());
                if (!it.hasNext()) {
                    break;
                }
                sb.append((CharSequence) ", ");
            }
        }
        zzdVar.zzd(String.format("Play Store package certs are not valid. Found these sha256 certs: [%s].", sb.toString()), new Object[0]);
        return false;
    }
}
