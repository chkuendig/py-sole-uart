package com.google.android.gms.auth.api.accounttransfer;

import android.os.RemoteException;
import com.google.android.gms.internal.auth.zzau;
import com.google.android.gms.internal.auth.zzav;
import com.sun.jna.platform.win32.WinError;

/* compiled from: com.google.android.gms:play-services-auth-base@@18.0.4 */
/* loaded from: classes4.dex */
final class zzi extends zzn {
    final /* synthetic */ zzav zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzi(AccountTransferClient accountTransferClient, int i, zzav zzavVar) {
        super(WinError.ERROR_BAD_CONFIGURATION);
        this.zza = zzavVar;
    }

    @Override // com.google.android.gms.auth.api.accounttransfer.zzl
    protected final void zza(zzau zzauVar) throws RemoteException {
        zzauVar.zzf(this.zzc, this.zza);
    }
}
