package com.samsung.android.sdk.healthdata;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.samsung.android.sdk.healthdata.IDataResolver;
import com.samsung.android.sdk.healthdata.IDataWatcher;
import com.samsung.android.sdk.healthdata.IDeviceManager;
import com.samsung.android.sdk.internal.healthdata.HealthResultReceiver;

/* loaded from: classes5.dex */
public interface IHealth extends IInterface {

    public static abstract class Stub extends Binder implements IHealth {

        private static class a implements IHealth {
            private IBinder a;

            a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // com.samsung.android.sdk.healthdata.IHealth
            public Bundle getConnectionResult(String str, int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.samsung.android.sdk.healthdata.IHealth");
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    this.a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.healthdata.IHealth
            public Bundle getConnectionResult2(Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.samsung.android.sdk.healthdata.IHealth");
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.a.transact(10, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.healthdata.IHealth
            public IDataResolver getIDataResolver() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.samsung.android.sdk.healthdata.IHealth");
                    this.a.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return IDataResolver.Stub.asInterface(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.healthdata.IHealth
            public IDataWatcher getIDataWatcher() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.samsung.android.sdk.healthdata.IHealth");
                    this.a.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return IDataWatcher.Stub.asInterface(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.healthdata.IHealth
            public IDeviceManager getIDeviceManager() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.samsung.android.sdk.healthdata.IHealth");
                    this.a.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return IDeviceManager.Stub.asInterface(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.healthdata.IHealth
            public Bundle getUserProfile() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.samsung.android.sdk.healthdata.IHealth");
                    this.a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.healthdata.IHealth
            public Bundle getUserProfile2(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.samsung.android.sdk.healthdata.IHealth");
                    parcelObtain.writeString(str);
                    this.a.transact(11, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.healthdata.IHealth
            public Bundle isHealthDataPermissionAcquired(Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.samsung.android.sdk.healthdata.IHealth");
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.a.transact(8, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.healthdata.IHealth
            public Bundle isHealthDataPermissionAcquired2(String str, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.samsung.android.sdk.healthdata.IHealth");
                    parcelObtain.writeString(str);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.a.transact(14, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.healthdata.IHealth
            public boolean isKeyAccessible() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.samsung.android.sdk.healthdata.IHealth");
                    this.a.transact(9, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.healthdata.IHealth
            public HealthResultReceiver requestHealthDataPermissions(Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.samsung.android.sdk.healthdata.IHealth");
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.a.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? HealthResultReceiver.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.healthdata.IHealth
            public Intent requestHealthDataPermissions2(String str, HealthResultReceiver healthResultReceiver, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.samsung.android.sdk.healthdata.IHealth");
                    parcelObtain.writeString(str);
                    if (healthResultReceiver != null) {
                        parcelObtain.writeInt(1);
                        healthResultReceiver.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.a.transact(13, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.healthdata.IHealth
            public HealthResultReceiver waitForInit(long j) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.samsung.android.sdk.healthdata.IHealth");
                    parcelObtain.writeLong(j);
                    this.a.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? HealthResultReceiver.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.healthdata.IHealth
            public void waitForInit2(String str, HealthResultReceiver healthResultReceiver, long j) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.samsung.android.sdk.healthdata.IHealth");
                    parcelObtain.writeString(str);
                    if (healthResultReceiver != null) {
                        parcelObtain.writeInt(1);
                        healthResultReceiver.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeLong(j);
                    this.a.transact(12, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.samsung.android.sdk.healthdata.IHealth");
        }

        public static IHealth asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.samsung.android.sdk.healthdata.IHealth");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IHealth)) ? new a(iBinder) : (IHealth) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString("com.samsung.android.sdk.healthdata.IHealth");
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.samsung.android.sdk.healthdata.IHealth");
                    Bundle userProfile = getUserProfile();
                    parcel2.writeNoException();
                    if (userProfile != null) {
                        parcel2.writeInt(1);
                        userProfile.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 2:
                    parcel.enforceInterface("com.samsung.android.sdk.healthdata.IHealth");
                    Bundle connectionResult = getConnectionResult(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    if (connectionResult != null) {
                        parcel2.writeInt(1);
                        connectionResult.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 3:
                    parcel.enforceInterface("com.samsung.android.sdk.healthdata.IHealth");
                    HealthResultReceiver healthResultReceiverWaitForInit = waitForInit(parcel.readLong());
                    parcel2.writeNoException();
                    if (healthResultReceiverWaitForInit != null) {
                        parcel2.writeInt(1);
                        healthResultReceiverWaitForInit.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 4:
                    parcel.enforceInterface("com.samsung.android.sdk.healthdata.IHealth");
                    IDeviceManager iDeviceManager = getIDeviceManager();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(iDeviceManager != null ? iDeviceManager.asBinder() : null);
                    return true;
                case 5:
                    parcel.enforceInterface("com.samsung.android.sdk.healthdata.IHealth");
                    IDataResolver iDataResolver = getIDataResolver();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(iDataResolver != null ? iDataResolver.asBinder() : null);
                    return true;
                case 6:
                    parcel.enforceInterface("com.samsung.android.sdk.healthdata.IHealth");
                    IDataWatcher iDataWatcher = getIDataWatcher();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(iDataWatcher != null ? iDataWatcher.asBinder() : null);
                    return true;
                case 7:
                    parcel.enforceInterface("com.samsung.android.sdk.healthdata.IHealth");
                    HealthResultReceiver healthResultReceiverRequestHealthDataPermissions = requestHealthDataPermissions(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (healthResultReceiverRequestHealthDataPermissions != null) {
                        parcel2.writeInt(1);
                        healthResultReceiverRequestHealthDataPermissions.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 8:
                    parcel.enforceInterface("com.samsung.android.sdk.healthdata.IHealth");
                    Bundle bundleIsHealthDataPermissionAcquired = isHealthDataPermissionAcquired(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (bundleIsHealthDataPermissionAcquired != null) {
                        parcel2.writeInt(1);
                        bundleIsHealthDataPermissionAcquired.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 9:
                    parcel.enforceInterface("com.samsung.android.sdk.healthdata.IHealth");
                    boolean zIsKeyAccessible = isKeyAccessible();
                    parcel2.writeNoException();
                    parcel2.writeInt(zIsKeyAccessible ? 1 : 0);
                    return true;
                case 10:
                    parcel.enforceInterface("com.samsung.android.sdk.healthdata.IHealth");
                    Bundle connectionResult2 = getConnectionResult2(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (connectionResult2 != null) {
                        parcel2.writeInt(1);
                        connectionResult2.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 11:
                    parcel.enforceInterface("com.samsung.android.sdk.healthdata.IHealth");
                    Bundle userProfile2 = getUserProfile2(parcel.readString());
                    parcel2.writeNoException();
                    if (userProfile2 != null) {
                        parcel2.writeInt(1);
                        userProfile2.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 12:
                    parcel.enforceInterface("com.samsung.android.sdk.healthdata.IHealth");
                    waitForInit2(parcel.readString(), parcel.readInt() != 0 ? HealthResultReceiver.CREATOR.createFromParcel(parcel) : null, parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface("com.samsung.android.sdk.healthdata.IHealth");
                    Intent intentRequestHealthDataPermissions2 = requestHealthDataPermissions2(parcel.readString(), parcel.readInt() != 0 ? HealthResultReceiver.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (intentRequestHealthDataPermissions2 != null) {
                        parcel2.writeInt(1);
                        intentRequestHealthDataPermissions2.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 14:
                    parcel.enforceInterface("com.samsung.android.sdk.healthdata.IHealth");
                    Bundle bundleIsHealthDataPermissionAcquired2 = isHealthDataPermissionAcquired2(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (bundleIsHealthDataPermissionAcquired2 != null) {
                        parcel2.writeInt(1);
                        bundleIsHealthDataPermissionAcquired2.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    Bundle getConnectionResult(String str, int i) throws RemoteException;

    Bundle getConnectionResult2(Bundle bundle) throws RemoteException;

    IDataResolver getIDataResolver() throws RemoteException;

    IDataWatcher getIDataWatcher() throws RemoteException;

    IDeviceManager getIDeviceManager() throws RemoteException;

    Bundle getUserProfile() throws RemoteException;

    Bundle getUserProfile2(String str) throws RemoteException;

    Bundle isHealthDataPermissionAcquired(Bundle bundle) throws RemoteException;

    Bundle isHealthDataPermissionAcquired2(String str, Bundle bundle) throws RemoteException;

    boolean isKeyAccessible() throws RemoteException;

    HealthResultReceiver requestHealthDataPermissions(Bundle bundle) throws RemoteException;

    Intent requestHealthDataPermissions2(String str, HealthResultReceiver healthResultReceiver, Bundle bundle) throws RemoteException;

    HealthResultReceiver waitForInit(long j) throws RemoteException;

    void waitForInit2(String str, HealthResultReceiver healthResultReceiver, long j) throws RemoteException;
}
