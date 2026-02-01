package com.samsung.android.sdk.internal.healthdata;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.samsung.android.sdk.internal.healthdata.IHealthResultReceiver;

/* loaded from: classes5.dex */
public interface ICallbackRegister extends IInterface {

    public static abstract class Stub extends Binder implements ICallbackRegister {

        private static class a implements ICallbackRegister {
            private IBinder a;

            a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // com.samsung.android.sdk.internal.healthdata.ICallbackRegister
            public void cancel(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.samsung.android.sdk.internal.healthdata.ICallbackRegister");
                    parcelObtain.writeInt(i);
                    this.a.transact(2, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.samsung.android.sdk.internal.healthdata.ICallbackRegister
            public void setCallback(int i, IHealthResultReceiver iHealthResultReceiver) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.samsung.android.sdk.internal.healthdata.ICallbackRegister");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeStrongBinder(iHealthResultReceiver != null ? iHealthResultReceiver.asBinder() : null);
                    this.a.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.samsung.android.sdk.internal.healthdata.ICallbackRegister");
        }

        public static ICallbackRegister asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.samsung.android.sdk.internal.healthdata.ICallbackRegister");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ICallbackRegister)) ? new a(iBinder) : (ICallbackRegister) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.samsung.android.sdk.internal.healthdata.ICallbackRegister");
                setCallback(parcel.readInt(), IHealthResultReceiver.Stub.asInterface(parcel.readStrongBinder()));
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface("com.samsung.android.sdk.internal.healthdata.ICallbackRegister");
                cancel(parcel.readInt());
                return true;
            }
            if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel2.writeString("com.samsung.android.sdk.internal.healthdata.ICallbackRegister");
            return true;
        }
    }

    void cancel(int i) throws RemoteException;

    void setCallback(int i, IHealthResultReceiver iHealthResultReceiver) throws RemoteException;
}
