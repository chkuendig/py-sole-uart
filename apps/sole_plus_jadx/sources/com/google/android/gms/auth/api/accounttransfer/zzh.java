package com.google.android.gms.auth.api.accounttransfer;

import android.os.RemoteException;
import com.google.android.gms.internal.auth.zzau;
import com.google.android.gms.internal.auth.zzbb;
import com.sun.jna.platform.win32.WinError;

/* compiled from: com.google.android.gms:play-services-auth-base@@18.0.4 */
/* loaded from: classes4.dex */
final class zzh extends zzn {
    final /* synthetic */ zzbb zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzh(AccountTransferClient accountTransferClient, int i, zzbb zzbbVar) {
        super(WinError.ERROR_INVALID_HANDLE_STATE);
        this.zza = zzbbVar;
    }

    @Override // com.google.android.gms.auth.api.accounttransfer.zzl
    protected final void zza(zzau zzauVar) throws RemoteException {
        zzauVar.zze(this.zzc, this.zza);
    }
}
