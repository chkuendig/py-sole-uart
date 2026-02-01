package com.google.android.play.agesignals.protocol;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.playcore_age_signals.zza;
import com.google.android.gms.internal.playcore_age_signals.zzb;
import com.google.android.gms.internal.playcore_age_signals.zzc;
import com.google.android.play.agesignals.protocol.IAgeSignalsServiceCallback;

/* compiled from: com.google.android.play:age-signals@@0.0.2 */
/* loaded from: classes4.dex */
public interface IAgeSignalsService extends IInterface {

    /* compiled from: com.google.android.play:age-signals@@0.0.2 */
    public static abstract class Stub extends zzb implements IAgeSignalsService {

        /* compiled from: com.google.android.play:age-signals@@0.0.2 */
        public static class Proxy extends zza implements IAgeSignalsService {
            Proxy(IBinder iBinder) {
                super(iBinder, "com.google.android.play.agesignals.protocol.IAgeSignalsService");
            }

            @Override // com.google.android.play.agesignals.protocol.IAgeSignalsService
            public void checkAgeRange(String str, Bundle bundle, IAgeSignalsServiceCallback iAgeSignalsServiceCallback) throws RemoteException {
                Parcel parcelZza = zza();
                parcelZza.writeString(str);
                zzc.zzc(parcelZza, bundle);
                if (iAgeSignalsServiceCallback == null) {
                    parcelZza.writeStrongBinder(null);
                } else {
                    parcelZza.writeStrongBinder(iAgeSignalsServiceCallback.asBinder());
                }
                zzb(1, parcelZza);
            }
        }

        public Stub() {
            super("com.google.android.play.agesignals.protocol.IAgeSignalsService");
        }

        public static IAgeSignalsService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.play.agesignals.protocol.IAgeSignalsService");
            return iInterfaceQueryLocalInterface instanceof IAgeSignalsService ? (IAgeSignalsService) iInterfaceQueryLocalInterface : new Proxy(iBinder);
        }

        @Override // com.google.android.gms.internal.playcore_age_signals.zzb
        protected boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                return false;
            }
            String string = parcel.readString();
            Bundle bundle = (Bundle) zzc.zza(parcel, Bundle.CREATOR);
            IAgeSignalsServiceCallback iAgeSignalsServiceCallbackAsInterface = IAgeSignalsServiceCallback.Stub.asInterface(parcel.readStrongBinder());
            zzc.zzb(parcel);
            checkAgeRange(string, bundle, iAgeSignalsServiceCallbackAsInterface);
            return true;
        }
    }

    void checkAgeRange(String str, Bundle bundle, IAgeSignalsServiceCallback iAgeSignalsServiceCallback) throws RemoteException;
}
