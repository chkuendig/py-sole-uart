package androidx.health.platform.client.impl.sdkservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public interface ISetPermissionTokenCallback extends IInterface {
    public static final String DESCRIPTOR = "androidx.health.platform.client.impl.sdkservice.ISetPermissionTokenCallback";

    public static class Default implements ISetPermissionTokenCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // androidx.health.platform.client.impl.sdkservice.ISetPermissionTokenCallback
        public void onSuccess() throws RemoteException {
        }
    }

    void onSuccess() throws RemoteException;

    public static abstract class Stub extends Binder implements ISetPermissionTokenCallback {
        static final int TRANSACTION_onSuccess = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, ISetPermissionTokenCallback.DESCRIPTOR);
        }

        public static ISetPermissionTokenCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(ISetPermissionTokenCallback.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof ISetPermissionTokenCallback)) {
                return (ISetPermissionTokenCallback) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(ISetPermissionTokenCallback.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(ISetPermissionTokenCallback.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                onSuccess();
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        private static class Proxy implements ISetPermissionTokenCallback {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ISetPermissionTokenCallback.DESCRIPTOR;
            }

            @Override // androidx.health.platform.client.impl.sdkservice.ISetPermissionTokenCallback
            public void onSuccess() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISetPermissionTokenCallback.DESCRIPTOR);
                    this.mRemote.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }
    }
}
