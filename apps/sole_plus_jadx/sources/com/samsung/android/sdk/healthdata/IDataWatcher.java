package com.samsung.android.sdk.healthdata;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.samsung.android.sdk.healthdata.IHealthDataObserver;

/* loaded from: classes5.dex */
public interface IDataWatcher extends IInterface {

    public static abstract class Stub extends Binder implements IDataWatcher {

        private static class a implements IDataWatcher {
            private IBinder a;

            a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // com.samsung.android.sdk.healthdata.IDataWatcher
            public void registerDataObserver(String str, IHealthDataObserver iHealthDataObserver) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.samsung.android.sdk.healthdata.IDataWatcher");
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(iHealthDataObserver != null ? iHealthDataObserver.asBinder() : null);
                    this.a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.healthdata.IDataWatcher
            public void registerDataObserver2(String str, String str2, IHealthDataObserver iHealthDataObserver) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.samsung.android.sdk.healthdata.IDataWatcher");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStrongBinder(iHealthDataObserver != null ? iHealthDataObserver.asBinder() : null);
                    this.a.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.healthdata.IDataWatcher
            public void unregisterDataObserver(IHealthDataObserver iHealthDataObserver) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.samsung.android.sdk.healthdata.IDataWatcher");
                    parcelObtain.writeStrongBinder(iHealthDataObserver != null ? iHealthDataObserver.asBinder() : null);
                    this.a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.healthdata.IDataWatcher
            public void unregisterDataObserver2(String str, IHealthDataObserver iHealthDataObserver) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.samsung.android.sdk.healthdata.IDataWatcher");
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(iHealthDataObserver != null ? iHealthDataObserver.asBinder() : null);
                    this.a.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.samsung.android.sdk.healthdata.IDataWatcher");
        }

        public static IDataWatcher asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.samsung.android.sdk.healthdata.IDataWatcher");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IDataWatcher)) ? new a(iBinder) : (IDataWatcher) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString("com.samsung.android.sdk.healthdata.IDataWatcher");
                return true;
            }
            if (i == 1) {
                parcel.enforceInterface("com.samsung.android.sdk.healthdata.IDataWatcher");
                registerDataObserver(parcel.readString(), IHealthDataObserver.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface("com.samsung.android.sdk.healthdata.IDataWatcher");
                unregisterDataObserver(IHealthDataObserver.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            if (i == 3) {
                parcel.enforceInterface("com.samsung.android.sdk.healthdata.IDataWatcher");
                registerDataObserver2(parcel.readString(), parcel.readString(), IHealthDataObserver.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            if (i != 4) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.samsung.android.sdk.healthdata.IDataWatcher");
            unregisterDataObserver2(parcel.readString(), IHealthDataObserver.Stub.asInterface(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }
    }

    void registerDataObserver(String str, IHealthDataObserver iHealthDataObserver) throws RemoteException;

    void registerDataObserver2(String str, String str2, IHealthDataObserver iHealthDataObserver) throws RemoteException;

    void unregisterDataObserver(IHealthDataObserver iHealthDataObserver) throws RemoteException;

    void unregisterDataObserver2(String str, IHealthDataObserver iHealthDataObserver) throws RemoteException;
}
