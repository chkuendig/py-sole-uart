package com.samsung.android.sdk.healthdata;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.samsung.android.sdk.internal.healthdata.AggregateRequestImpl;
import com.samsung.android.sdk.internal.healthdata.DeleteRequestImpl;
import com.samsung.android.sdk.internal.healthdata.HealthResultReceiver;
import com.samsung.android.sdk.internal.healthdata.InsertRequestImpl;
import com.samsung.android.sdk.internal.healthdata.ReadRequestImpl;
import com.samsung.android.sdk.internal.healthdata.UpdateRequestImpl;

/* loaded from: classes5.dex */
public interface IDataResolver extends IInterface {

    public static abstract class Stub extends Binder implements IDataResolver {

        private static class a implements IDataResolver {
            private IBinder a;

            a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // com.samsung.android.sdk.healthdata.IDataResolver
            public HealthResultReceiver aggregateData(AggregateRequestImpl aggregateRequestImpl) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.samsung.android.sdk.healthdata.IDataResolver");
                    if (aggregateRequestImpl != null) {
                        parcelObtain.writeInt(1);
                        aggregateRequestImpl.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.a.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? HealthResultReceiver.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.healthdata.IDataResolver
            public void aggregateData2(String str, HealthResultReceiver healthResultReceiver, AggregateRequestImpl aggregateRequestImpl) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.samsung.android.sdk.healthdata.IDataResolver");
                    parcelObtain.writeString(str);
                    if (healthResultReceiver != null) {
                        parcelObtain.writeInt(1);
                        healthResultReceiver.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (aggregateRequestImpl != null) {
                        parcelObtain.writeInt(1);
                        aggregateRequestImpl.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.a.transact(9, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // com.samsung.android.sdk.healthdata.IDataResolver
            public HealthResultReceiver deleteData(DeleteRequestImpl deleteRequestImpl) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.samsung.android.sdk.healthdata.IDataResolver");
                    if (deleteRequestImpl != null) {
                        parcelObtain.writeInt(1);
                        deleteRequestImpl.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.a.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? HealthResultReceiver.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.healthdata.IDataResolver
            public void deleteData2(String str, HealthResultReceiver healthResultReceiver, DeleteRequestImpl deleteRequestImpl) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.samsung.android.sdk.healthdata.IDataResolver");
                    parcelObtain.writeString(str);
                    if (healthResultReceiver != null) {
                        parcelObtain.writeInt(1);
                        healthResultReceiver.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (deleteRequestImpl != null) {
                        parcelObtain.writeInt(1);
                        deleteRequestImpl.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.a.transact(8, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.healthdata.IDataResolver
            public Intent deleteDataWithPermission(String str, HealthResultReceiver healthResultReceiver, DeleteRequestImpl deleteRequestImpl) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.samsung.android.sdk.healthdata.IDataResolver");
                    parcelObtain.writeString(str);
                    if (healthResultReceiver != null) {
                        parcelObtain.writeInt(1);
                        healthResultReceiver.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (deleteRequestImpl != null) {
                        parcelObtain.writeInt(1);
                        deleteRequestImpl.writeToParcel(parcelObtain, 0);
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

            @Override // com.samsung.android.sdk.healthdata.IDataResolver
            public HealthResultReceiver insertData(InsertRequestImpl insertRequestImpl) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.samsung.android.sdk.healthdata.IDataResolver");
                    if (insertRequestImpl != null) {
                        parcelObtain.writeInt(1);
                        insertRequestImpl.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? HealthResultReceiver.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.healthdata.IDataResolver
            public void insertData2(String str, HealthResultReceiver healthResultReceiver, InsertRequestImpl insertRequestImpl) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.samsung.android.sdk.healthdata.IDataResolver");
                    parcelObtain.writeString(str);
                    if (healthResultReceiver != null) {
                        parcelObtain.writeInt(1);
                        healthResultReceiver.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (insertRequestImpl != null) {
                        parcelObtain.writeInt(1);
                        insertRequestImpl.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.a.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.healthdata.IDataResolver
            public Intent insertDataWithPermission(String str, HealthResultReceiver healthResultReceiver, InsertRequestImpl insertRequestImpl) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.samsung.android.sdk.healthdata.IDataResolver");
                    parcelObtain.writeString(str);
                    if (healthResultReceiver != null) {
                        parcelObtain.writeInt(1);
                        healthResultReceiver.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (insertRequestImpl != null) {
                        parcelObtain.writeInt(1);
                        insertRequestImpl.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.a.transact(12, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.healthdata.IDataResolver
            public HealthResultReceiver readData(ReadRequestImpl readRequestImpl) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.samsung.android.sdk.healthdata.IDataResolver");
                    if (readRequestImpl != null) {
                        parcelObtain.writeInt(1);
                        readRequestImpl.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? HealthResultReceiver.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.healthdata.IDataResolver
            public void readData2(String str, HealthResultReceiver healthResultReceiver, ReadRequestImpl readRequestImpl) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.samsung.android.sdk.healthdata.IDataResolver");
                    parcelObtain.writeString(str);
                    if (healthResultReceiver != null) {
                        parcelObtain.writeInt(1);
                        healthResultReceiver.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (readRequestImpl != null) {
                        parcelObtain.writeInt(1);
                        readRequestImpl.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.a.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.healthdata.IDataResolver
            public Intent readDataWithPermission(String str, HealthResultReceiver healthResultReceiver, ReadRequestImpl readRequestImpl) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.samsung.android.sdk.healthdata.IDataResolver");
                    parcelObtain.writeString(str);
                    if (healthResultReceiver != null) {
                        parcelObtain.writeInt(1);
                        healthResultReceiver.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (readRequestImpl != null) {
                        parcelObtain.writeInt(1);
                        readRequestImpl.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.a.transact(11, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.healthdata.IDataResolver
            public ParcelFileDescriptor requestBlobTransferChannel(String str, String str2, String str3, String str4, String str5) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.samsung.android.sdk.healthdata.IDataResolver");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeString(str4);
                    parcelObtain.writeString(str5);
                    this.a.transact(14, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.healthdata.IDataResolver
            public ParcelFileDescriptor requestFileDescriptor(String str, String str2, String str3) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.samsung.android.sdk.healthdata.IDataResolver");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    this.a.transact(15, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.healthdata.IDataResolver
            public HealthResultReceiver updateData(UpdateRequestImpl updateRequestImpl) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.samsung.android.sdk.healthdata.IDataResolver");
                    if (updateRequestImpl != null) {
                        parcelObtain.writeInt(1);
                        updateRequestImpl.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.a.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? HealthResultReceiver.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.healthdata.IDataResolver
            public void updateData2(String str, HealthResultReceiver healthResultReceiver, UpdateRequestImpl updateRequestImpl) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.samsung.android.sdk.healthdata.IDataResolver");
                    parcelObtain.writeString(str);
                    if (healthResultReceiver != null) {
                        parcelObtain.writeInt(1);
                        healthResultReceiver.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (updateRequestImpl != null) {
                        parcelObtain.writeInt(1);
                        updateRequestImpl.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.a.transact(10, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.samsung.android.sdk.healthdata.IDataResolver");
        }

        public static IDataResolver asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.samsung.android.sdk.healthdata.IDataResolver");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IDataResolver)) ? new a(iBinder) : (IDataResolver) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString("com.samsung.android.sdk.healthdata.IDataResolver");
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.samsung.android.sdk.healthdata.IDataResolver");
                    HealthResultReceiver data = readData(parcel.readInt() != 0 ? ReadRequestImpl.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (data != null) {
                        parcel2.writeInt(1);
                        data.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 2:
                    parcel.enforceInterface("com.samsung.android.sdk.healthdata.IDataResolver");
                    HealthResultReceiver healthResultReceiverInsertData = insertData(parcel.readInt() != 0 ? InsertRequestImpl.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (healthResultReceiverInsertData != null) {
                        parcel2.writeInt(1);
                        healthResultReceiverInsertData.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 3:
                    parcel.enforceInterface("com.samsung.android.sdk.healthdata.IDataResolver");
                    HealthResultReceiver healthResultReceiverDeleteData = deleteData(parcel.readInt() != 0 ? DeleteRequestImpl.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (healthResultReceiverDeleteData != null) {
                        parcel2.writeInt(1);
                        healthResultReceiverDeleteData.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 4:
                    parcel.enforceInterface("com.samsung.android.sdk.healthdata.IDataResolver");
                    HealthResultReceiver healthResultReceiverAggregateData = aggregateData(parcel.readInt() != 0 ? AggregateRequestImpl.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (healthResultReceiverAggregateData != null) {
                        parcel2.writeInt(1);
                        healthResultReceiverAggregateData.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 5:
                    parcel.enforceInterface("com.samsung.android.sdk.healthdata.IDataResolver");
                    HealthResultReceiver healthResultReceiverUpdateData = updateData(parcel.readInt() != 0 ? UpdateRequestImpl.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (healthResultReceiverUpdateData != null) {
                        parcel2.writeInt(1);
                        healthResultReceiverUpdateData.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 6:
                    parcel.enforceInterface("com.samsung.android.sdk.healthdata.IDataResolver");
                    readData2(parcel.readString(), parcel.readInt() != 0 ? HealthResultReceiver.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? ReadRequestImpl.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface("com.samsung.android.sdk.healthdata.IDataResolver");
                    insertData2(parcel.readString(), parcel.readInt() != 0 ? HealthResultReceiver.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? InsertRequestImpl.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface("com.samsung.android.sdk.healthdata.IDataResolver");
                    deleteData2(parcel.readString(), parcel.readInt() != 0 ? HealthResultReceiver.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? DeleteRequestImpl.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface("com.samsung.android.sdk.healthdata.IDataResolver");
                    aggregateData2(parcel.readString(), parcel.readInt() != 0 ? HealthResultReceiver.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? AggregateRequestImpl.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface("com.samsung.android.sdk.healthdata.IDataResolver");
                    updateData2(parcel.readString(), parcel.readInt() != 0 ? HealthResultReceiver.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? UpdateRequestImpl.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface("com.samsung.android.sdk.healthdata.IDataResolver");
                    Intent dataWithPermission = readDataWithPermission(parcel.readString(), parcel.readInt() != 0 ? HealthResultReceiver.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? ReadRequestImpl.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (dataWithPermission != null) {
                        parcel2.writeInt(1);
                        dataWithPermission.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 12:
                    parcel.enforceInterface("com.samsung.android.sdk.healthdata.IDataResolver");
                    Intent intentInsertDataWithPermission = insertDataWithPermission(parcel.readString(), parcel.readInt() != 0 ? HealthResultReceiver.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? InsertRequestImpl.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (intentInsertDataWithPermission != null) {
                        parcel2.writeInt(1);
                        intentInsertDataWithPermission.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 13:
                    parcel.enforceInterface("com.samsung.android.sdk.healthdata.IDataResolver");
                    Intent intentDeleteDataWithPermission = deleteDataWithPermission(parcel.readString(), parcel.readInt() != 0 ? HealthResultReceiver.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? DeleteRequestImpl.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (intentDeleteDataWithPermission != null) {
                        parcel2.writeInt(1);
                        intentDeleteDataWithPermission.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 14:
                    parcel.enforceInterface("com.samsung.android.sdk.healthdata.IDataResolver");
                    ParcelFileDescriptor parcelFileDescriptorRequestBlobTransferChannel = requestBlobTransferChannel(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    if (parcelFileDescriptorRequestBlobTransferChannel != null) {
                        parcel2.writeInt(1);
                        parcelFileDescriptorRequestBlobTransferChannel.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 15:
                    parcel.enforceInterface("com.samsung.android.sdk.healthdata.IDataResolver");
                    ParcelFileDescriptor parcelFileDescriptorRequestFileDescriptor = requestFileDescriptor(parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    if (parcelFileDescriptorRequestFileDescriptor != null) {
                        parcel2.writeInt(1);
                        parcelFileDescriptorRequestFileDescriptor.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    HealthResultReceiver aggregateData(AggregateRequestImpl aggregateRequestImpl) throws RemoteException;

    void aggregateData2(String str, HealthResultReceiver healthResultReceiver, AggregateRequestImpl aggregateRequestImpl) throws RemoteException;

    HealthResultReceiver deleteData(DeleteRequestImpl deleteRequestImpl) throws RemoteException;

    void deleteData2(String str, HealthResultReceiver healthResultReceiver, DeleteRequestImpl deleteRequestImpl) throws RemoteException;

    Intent deleteDataWithPermission(String str, HealthResultReceiver healthResultReceiver, DeleteRequestImpl deleteRequestImpl) throws RemoteException;

    HealthResultReceiver insertData(InsertRequestImpl insertRequestImpl) throws RemoteException;

    void insertData2(String str, HealthResultReceiver healthResultReceiver, InsertRequestImpl insertRequestImpl) throws RemoteException;

    Intent insertDataWithPermission(String str, HealthResultReceiver healthResultReceiver, InsertRequestImpl insertRequestImpl) throws RemoteException;

    HealthResultReceiver readData(ReadRequestImpl readRequestImpl) throws RemoteException;

    void readData2(String str, HealthResultReceiver healthResultReceiver, ReadRequestImpl readRequestImpl) throws RemoteException;

    Intent readDataWithPermission(String str, HealthResultReceiver healthResultReceiver, ReadRequestImpl readRequestImpl) throws RemoteException;

    ParcelFileDescriptor requestBlobTransferChannel(String str, String str2, String str3, String str4, String str5) throws RemoteException;

    ParcelFileDescriptor requestFileDescriptor(String str, String str2, String str3) throws RemoteException;

    HealthResultReceiver updateData(UpdateRequestImpl updateRequestImpl) throws RemoteException;

    void updateData2(String str, HealthResultReceiver healthResultReceiver, UpdateRequestImpl updateRequestImpl) throws RemoteException;
}
