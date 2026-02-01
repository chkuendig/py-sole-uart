package com.samsung.android.sdk.healthdata;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes5.dex */
public interface IHealthDataObserver extends IInterface {

    public static abstract class Stub extends Binder implements IHealthDataObserver {

        private static class a implements IHealthDataObserver {
            private IBinder a;

            a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // com.samsung.android.sdk.healthdata.IHealthDataObserver
            public void onChange(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.samsung.android.sdk.healthdata.IHealthDataObserver");
                    parcelObtain.writeString(str);
                    this.a.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.samsung.android.sdk.healthdata.IHealthDataObserver");
        }

        public static IHealthDataObserver asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.samsung.android.sdk.healthdata.IHealthDataObserver");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IHealthDataObserver)) ? new a(iBinder) : (IHealthDataObserver) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.samsung.android.sdk.healthdata.IHealthDataObserver");
                onChange(parcel.readString());
                return true;
            }
            if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel2.writeString("com.samsung.android.sdk.healthdata.IHealthDataObserver");
            return true;
        }
    }

    void onChange(String str) throws RemoteException;
}
