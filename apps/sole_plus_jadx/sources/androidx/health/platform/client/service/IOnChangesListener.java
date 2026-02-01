package androidx.health.platform.client.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import androidx.health.platform.client.changes.ChangesEvent;

/* loaded from: classes2.dex */
public interface IOnChangesListener extends IInterface {
    public static final String DESCRIPTOR = "androidx.health.platform.client.service.IOnChangesListener";

    public static class Default implements IOnChangesListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // androidx.health.platform.client.service.IOnChangesListener
        public void onChanges(ChangesEvent changesEvent) throws RemoteException {
        }
    }

    void onChanges(ChangesEvent changesEvent) throws RemoteException;

    public static abstract class Stub extends Binder implements IOnChangesListener {
        static final int TRANSACTION_onChanges = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, IOnChangesListener.DESCRIPTOR);
        }

        public static IOnChangesListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IOnChangesListener.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IOnChangesListener)) {
                return (IOnChangesListener) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IOnChangesListener.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IOnChangesListener.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                onChanges((ChangesEvent) _Parcel.readTypedObject(parcel, ChangesEvent.CREATOR));
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        private static class Proxy implements IOnChangesListener {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IOnChangesListener.DESCRIPTOR;
            }

            @Override // androidx.health.platform.client.service.IOnChangesListener
            public void onChanges(ChangesEvent changesEvent) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IOnChangesListener.DESCRIPTOR);
                    _Parcel.writeTypedObject(parcelObtain, changesEvent, 0);
                    this.mRemote.transact(1, parcelObtain, null, 1);
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
