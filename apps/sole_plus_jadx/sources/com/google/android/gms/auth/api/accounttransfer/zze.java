package com.google.android.gms.auth.api.accounttransfer;

import android.os.RemoteException;
import com.google.android.gms.internal.auth.zzau;
import com.google.android.gms.internal.auth.zzax;
import com.sun.jna.platform.win32.WinError;

/* compiled from: com.google.android.gms:play-services-auth-base@@18.0.4 */
/* loaded from: classes4.dex */
final class zze extends zzl {
    final /* synthetic */ zzax zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zze(AccountTransferClient accountTransferClient, int i, zzax zzaxVar) {
        super(WinError.ERROR_UNKNOWN_COMPONENT, null);
        this.zza = zzaxVar;
    }

    @Override // com.google.android.gms.auth.api.accounttransfer.zzl
    protected final void zza(zzau zzauVar) throws RemoteException {
        zzauVar.zzg(new zzd(this, this), this.zza);
    }
}
