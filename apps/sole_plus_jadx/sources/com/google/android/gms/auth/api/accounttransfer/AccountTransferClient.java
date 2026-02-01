package com.google.android.gms.auth.api.accounttransfer;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.auth.zzaq;
import com.google.android.gms.internal.auth.zzav;
import com.google.android.gms.internal.auth.zzax;
import com.google.android.gms.internal.auth.zzaz;
import com.google.android.gms.internal.auth.zzbb;
import com.google.android.gms.tasks.Task;
import com.sun.jna.platform.win32.WinError;

/* compiled from: com.google.android.gms:play-services-auth-base@@18.0.4 */
/* loaded from: classes4.dex */
public class AccountTransferClient extends GoogleApi<zzr> {
    public static final /* synthetic */ int zza = 0;
    private static final Api.ClientKey zzb;
    private static final Api.AbstractClientBuilder zzc;
    private static final Api zzd;

    static {
        Api.ClientKey clientKey = new Api.ClientKey();
        zzb = clientKey;
        zzb zzbVar = new zzb();
        zzc = zzbVar;
        zzd = new Api("AccountTransfer.ACCOUNT_TRANSFER_API", zzbVar, clientKey);
    }

    AccountTransferClient(Activity activity, zzr zzrVar) {
        super(activity, (Api<zzr>) zzd, zzr.zza, new GoogleApi.Settings.Builder().setMapper(new ApiExceptionMapper()).build());
    }

    public Task<DeviceMetaData> getDeviceMetaData(String str) {
        Preconditions.checkNotNull(str);
        return doRead(new zzg(this, WinError.ERROR_UNKNOWN_PROPERTY, new zzaq(str)));
    }

    public Task<Void> notifyCompletion(String str, int i) {
        Preconditions.checkNotNull(str);
        return doWrite(new zzi(this, WinError.ERROR_BAD_CONFIGURATION, new zzav(str, i)));
    }

    public Task<byte[]> retrieveData(String str) {
        Preconditions.checkNotNull(str);
        return doRead(new zze(this, WinError.ERROR_UNKNOWN_COMPONENT, new zzax(str)));
    }

    public Task<Void> sendData(String str, byte[] bArr) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(bArr);
        return doWrite(new zzc(this, WinError.ERROR_UNKNOWN_FEATURE, new zzaz(str, bArr)));
    }

    public Task<Void> showUserChallenge(String str, PendingIntent pendingIntent) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(pendingIntent);
        return doWrite(new zzh(this, WinError.ERROR_INVALID_HANDLE_STATE, new zzbb(str, pendingIntent)));
    }

    AccountTransferClient(Context context, zzr zzrVar) {
        super(context, (Api<zzr>) zzd, zzr.zza, new GoogleApi.Settings.Builder().setMapper(new ApiExceptionMapper()).build());
    }
}
