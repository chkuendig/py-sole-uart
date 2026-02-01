package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-wearable@@18.1.0 */
/* loaded from: classes4.dex */
final class zzji implements Runnable {
    final /* synthetic */ Uri zza;
    final /* synthetic */ BaseImplementation.ResultHolder zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ long zzd;
    final /* synthetic */ long zze;
    final /* synthetic */ zzjj zzf;

    zzji(zzjj zzjjVar, Uri uri, BaseImplementation.ResultHolder resultHolder, String str, long j, long j2) {
        this.zzf = zzjjVar;
        this.zza = uri;
        this.zzb = resultHolder;
        this.zzc = str;
        this.zzd = j;
        this.zze = j2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10, types: [android.os.ParcelFileDescriptor] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.File, java.lang.Object] */
    @Override // java.lang.Runnable
    public final void run() throws IOException {
        if (Log.isLoggable("WearableClient", 2)) {
            Log.v("WearableClient", "Executing sendFileToChannelTask");
        }
        String scheme = this.zza.getScheme();
        if (scheme != "file" && (scheme == null || !scheme.equals("file"))) {
            Log.w("WearableClient", "Channel.sendFile used with non-file URI");
            this.zzb.setFailedResult(new Status(10, "Channel.sendFile used with non-file URI"));
            return;
        }
        ParcelFileDescriptor file = new File(this.zza.getPath());
        try {
            try {
                file = ParcelFileDescriptor.open(file, 268435456);
                try {
                    ((zzft) this.zzf.getService()).zzw(new zzja(this.zzb), this.zzc, file, this.zzd, this.zze);
                } catch (RemoteException e) {
                    Log.w("WearableClient", "Channel.sendFile failed.", e);
                    this.zzb.setFailedResult(new Status(8));
                    try {
                        file.close();
                    } catch (IOException e2) {
                        Log.w("WearableClient", "Failed to close sourceFd", e2);
                    }
                }
            } catch (FileNotFoundException unused) {
                Log.w("WearableClient", "File couldn't be opened for Channel.sendFile: ".concat(file.toString()));
                this.zzb.setFailedResult(new Status(13));
            }
        } finally {
            try {
                file.close();
            } catch (IOException e3) {
                Log.w("WearableClient", "Failed to close sourceFd", e3);
            }
        }
    }
}
