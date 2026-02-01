package androidx.health.platform.client.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import androidx.health.platform.client.error.ErrorStatus;

/* loaded from: classes2.dex */
public interface IDeleteDataRangeCallback extends IInterface {
    public static final String DESCRIPTOR = "androidx.health.platform.client.service.IDeleteDataRangeCallback";

    public static class Default implements IDeleteDataRangeCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // androidx.health.platform.client.service.IDeleteDataRangeCallback
        public void onError(ErrorStatus errorStatus) throws RemoteException {
        }

        @Override // androidx.health.platform.client.service.IDeleteDataRangeCallback
        public void onSuccess() throws RemoteException {
        }
    }

    void onError(ErrorStatus errorStatus) throws RemoteException;

    void onSuccess() throws RemoteException;

    public static abstract class Stub extends Binder implements IDeleteDataRangeCallback {
        static final int TRANSACTION_onError = 2;
        static final int TRANSACTION_onSuccess = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, IDeleteDataRangeCallback.DESCRIPTOR);
        }

        public static IDeleteDataRangeCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IDeleteDataRangeCallback.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IDeleteDataRangeCallback)) {
                return (IDeleteDataRangeCallback) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IDeleteDataRangeCallback.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IDeleteDataRangeCallback.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                onSuccess();
            } else if (i == 2) {
                onError((ErrorStatus) _Parcel.readTypedObject(parcel, ErrorStatus.CREATOR));
            } else {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            return true;
        }

        private static class Proxy implements IDeleteDataRangeCallback {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IDeleteDataRangeCallback.DESCRIPTOR;
            }

            @Override // androidx.health.platform.client.service.IDeleteDataRangeCallback
            public void onSuccess() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDeleteDataRangeCallback.DESCRIPTOR);
                    this.mRemote.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.health.platform.client.service.IDeleteDataRangeCallback
            public void onError(ErrorStatus errorStatus) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDeleteDataRangeCallback.DESCRIPTOR);
                    _Parcel.writeTypedObject(parcelObtain, errorStatus, 0);
                    this.mRemote.transact(2, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }
    }

    public static class _Parcel {
        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T readTypedObject(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void writeTypedObject(Parcel parcel, T t, int i) {
            if (t != null) {
                parcel.writeInt(1);
                t.writeToParcel(parcel, i);
            } else {
                parcel.writeInt(0);
            }
        }
    }
}
