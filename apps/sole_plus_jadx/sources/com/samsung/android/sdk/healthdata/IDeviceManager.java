package com.samsung.android.sdk.healthdata;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* loaded from: classes5.dex */
public interface IDeviceManager extends IInterface {

    public static abstract class Stub extends Binder implements IDeviceManager {

        private static class a implements IDeviceManager {
            private IBinder a;

            a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // com.samsung.android.sdk.healthdata.IDeviceManager
            public boolean changeDeviceName(String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.samsung.android.sdk.healthdata.IDeviceManager");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.a.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.healthdata.IDeviceManager
            public List<HealthDevice> getAllRegisteredDevices() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.samsung.android.sdk.healthdata.IDeviceManager");
                    this.a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(HealthDevice.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.healthdata.IDeviceManager
            public HealthDevice getDeviceByUuid(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.samsung.android.sdk.healthdata.IDeviceManager");
                    parcelObtain.writeString(str);
                    this.a.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? HealthDevice.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.healthdata.IDeviceManager
            public List<String> getDeviceUuidsBy(String str, int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.samsung.android.sdk.healthdata.IDeviceManager");
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    this.a.transact(8, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.createStringArrayList();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.healthdata.IDeviceManager
            public HealthDevice getLocalDevice() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.samsung.android.sdk.healthdata.IDeviceManager");
                    this.a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? HealthDevice.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.healthdata.IDeviceManager
            public HealthDevice getRegisteredDevice(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.samsung.android.sdk.healthdata.IDeviceManager");
                    parcelObtain.writeString(str);
                    this.a.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? HealthDevice.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.healthdata.IDeviceManager
            public HealthDevice getRegisteredDeviceByUuid(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.samsung.android.sdk.healthdata.IDeviceManager");
                    parcelObtain.writeString(str);
                    this.a.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? HealthDevice.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.healthdata.IDeviceManager
            public String registerDevice(HealthDevice healthDevice) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.samsung.android.sdk.healthdata.IDeviceManager");
                    if (healthDevice != null) {
                        parcelObtain.writeInt(1);
                        healthDevice.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.a.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.samsung.android.sdk.healthdata.IDeviceManager");
        }

        public static IDeviceManager asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.samsung.android.sdk.healthdata.IDeviceManager");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IDeviceManager)) ? new a(iBinder) : (IDeviceManager) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString("com.samsung.android.sdk.healthdata.IDeviceManager");
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.samsung.android.sdk.healthdata.IDeviceManager");
                    HealthDevice localDevice = getLocalDevice();
                    parcel2.writeNoException();
                    if (localDevice != null) {
                        parcel2.writeInt(1);
                        localDevice.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 2:
                    parcel.enforceInterface("com.samsung.android.sdk.healthdata.IDeviceManager");
                    List<HealthDevice> allRegisteredDevices = getAllRegisteredDevices();
                    parcel2.writeNoException();
                    parcel2.writeTypedList(allRegisteredDevices);
                    return true;
                case 3:
                    parcel.enforceInterface("com.samsung.android.sdk.healthdata.IDeviceManager");
                    HealthDevice registeredDevice = getRegisteredDevice(parcel.readString());
                    parcel2.writeNoException();
                    if (registeredDevice != null) {
                        parcel2.writeInt(1);
                        registeredDevice.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 4:
                    parcel.enforceInterface("com.samsung.android.sdk.healthdata.IDeviceManager");
                    HealthDevice registeredDeviceByUuid = getRegisteredDeviceByUuid(parcel.readString());
                    parcel2.writeNoException();
                    if (registeredDeviceByUuid != null) {
                        parcel2.writeInt(1);
                        registeredDeviceByUuid.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 5:
                    parcel.enforceInterface("com.samsung.android.sdk.healthdata.IDeviceManager");
                    String strRegisterDevice = registerDevice(parcel.readInt() != 0 ? HealthDevice.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeString(strRegisterDevice);
                    return true;
                case 6:
                    parcel.enforceInterface("com.samsung.android.sdk.healthdata.IDeviceManager");
                    boolean zChangeDeviceName = changeDeviceName(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zChangeDeviceName ? 1 : 0);
                    return true;
                case 7:
                    parcel.enforceInterface("com.samsung.android.sdk.healthdata.IDeviceManager");
                    HealthDevice deviceByUuid = getDeviceByUuid(parcel.readString());
                    parcel2.writeNoException();
                    if (deviceByUuid != null) {
                        parcel2.writeInt(1);
                        deviceByUuid.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 8:
                    parcel.enforceInterface("com.samsung.android.sdk.healthdata.IDeviceManager");
                    List<String> deviceUuidsBy = getDeviceUuidsBy(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStringList(deviceUuidsBy);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    boolean changeDeviceName(String str, String str2) throws RemoteException;

    List<HealthDevice> getAllRegisteredDevices() throws RemoteException;

    HealthDevice getDeviceByUuid(String str) throws RemoteException;

    List<String> getDeviceUuidsBy(String str, int i) throws RemoteException;

    HealthDevice getLocalDevice() throws RemoteException;

    HealthDevice getRegisteredDevice(String str) throws RemoteException;

    HealthDevice getRegisteredDeviceByUuid(String str) throws RemoteException;

    String registerDevice(HealthDevice healthDevice) throws RemoteException;
}
