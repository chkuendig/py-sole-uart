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
final class zzjh implements Runnable {
    final /* synthetic */ Uri zza;
    final /* synthetic */ BaseImplementation.ResultHolder zzb;
    final /* synthetic */ boolean zzc;
    final /* synthetic */ String zzd;
    final /* synthetic */ zzjj zze;

    zzjh(zzjj zzjjVar, Uri uri, BaseImplementation.ResultHolder resultHolder, boolean z, String str) {
        this.zze = zzjjVar;
        this.zza = uri;
        this.zzb = resultHolder;
        this.zzc = z;
        this.zzd = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() throws IOException {
        if (Log.isLoggable("WearableClient", 2)) {
            Log.v("WearableClient", "Executing receiveFileFromChannelTask");
        }
        String scheme = this.zza.getScheme();
        if (scheme != "file" && (scheme == null || !scheme.equals("file"))) {
            Log.w("WearableClient", "Channel.receiveFile used with non-file URI");
            this.zzb.setFailedResult(new Status(10, "Channel.receiveFile used with non-file URI"));
            return;
        }
        File file = new File(this.zza.getPath());
        try {
            ParcelFileDescriptor parcelFileDescriptorOpen = ParcelFileDescriptor.open(file, (true != this.zzc ? 0 : 33554432) | 671088640);
            try {
                try {
                    ((zzft) this.zze.getService()).zzC(new zzje(this.zzb), this.zzd, parcelFileDescriptorOpen);
                } catch (RemoteException e) {
                    Log.w("WearableClient", "Channel.receiveFile failed.", e);
                    this.zzb.setFailedResult(new Status(8));
                    try {
                        parcelFileDescriptorOpen.close();
                    } catch (IOException e2) {
                        Log.w("WearableClient", "Failed to close targetFd", e2);
                    }
                }
            } finally {
                try {
                    parcelFileDescriptorOpen.close();
                } catch (IOException e3) {
                    Log.w("WearableClient", "Failed to close targetFd", e3);
                }
            }
        } catch (FileNotFoundException unused) {
            Log.w("WearableClient", "File couldn't be opened for Channel.receiveFile: ".concat(file.toString()));
            this.zzb.setFailedResult(new Status(13));
        }
    }
}
