package androidx.health.platform.client.impl.sdkservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public interface IGetIsInForegroundCallback extends IInterface {
    public static final String DESCRIPTOR = "androidx.health.platform.client.impl.sdkservice.IGetIsInForegroundCallback";

    public static class Default implements IGetIsInForegroundCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // androidx.health.platform.client.impl.sdkservice.IGetIsInForegroundCallback
        public void onSuccess(boolean z) throws RemoteException {
        }
    }

    void onSuccess(boolean z) throws RemoteException;

    public static abstract class Stub extends Binder implements IGetIsInForegroundCallback {
        static final int TRANSACTION_onSuccess = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, IGetIsInForegroundCallback.DESCRIPTOR);
        }

        public static IGetIsInForegroundCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IGetIsInForegroundCallback.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IGetIsInForegroundCallback)) {
                return (IGetIsInForegroundCallback) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IGetIsInForegroundCallback.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IGetIsInForegroundCallback.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                onSuccess(parcel.readInt() != 0);
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        private static class Proxy implements IGetIsInForegroundCallback {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IGetIsInForegroundCallback.DESCRIPTOR;
            }

            @Override // androidx.health.platform.client.impl.sdkservice.IGetIsInForegroundCallback
            public void onSuccess(boolean z) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IGetIsInForegroundCallback.DESCRIPTOR);
                    parcelObtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }
    }
}
