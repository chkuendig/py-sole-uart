package com.google.android.gms.auth.api.accounttransfer;

import android.os.RemoteException;
import com.google.android.gms.internal.auth.zzaq;
import com.google.android.gms.internal.auth.zzau;
import com.sun.jna.platform.win32.WinError;

/* compiled from: com.google.android.gms:play-services-auth-base@@18.0.4 */
/* loaded from: classes4.dex */
final class zzg extends zzl {
    final /* synthetic */ zzaq zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzg(AccountTransferClient accountTransferClient, int i, zzaq zzaqVar) {
        super(WinError.ERROR_UNKNOWN_PROPERTY, null);
        this.zza = zzaqVar;
    }

    @Override // com.google.android.gms.auth.api.accounttransfer.zzl
    protected final void zza(zzau zzauVar) throws RemoteException {
        zzauVar.zzd(new zzf(this, this), this.zza);
    }
}
