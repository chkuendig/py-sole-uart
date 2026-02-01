package androidx.health.platform.client.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import androidx.health.platform.client.error.ErrorStatus;
import androidx.health.platform.client.permission.Permission;
import java.util.List;

/* loaded from: classes2.dex */
public interface IFilterGrantedPermissionsCallback extends IInterface {
    public static final String DESCRIPTOR = "androidx.health.platform.client.service.IFilterGrantedPermissionsCallback";

    public static class Default implements IFilterGrantedPermissionsCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // androidx.health.platform.client.service.IFilterGrantedPermissionsCallback
        public void onError(ErrorStatus errorStatus) throws RemoteException {
        }

        @Override // androidx.health.platform.client.service.IFilterGrantedPermissionsCallback
        public void onSuccess(List<Permission> list) throws RemoteException {
        }
    }

    void onError(ErrorStatus errorStatus) throws RemoteException;

    void onSuccess(List<Permission> list) throws RemoteException;

    public static abstract class Stub extends Binder implements IFilterGrantedPermissionsCallback {
        static final int TRANSACTION_onError = 2;
        static final int TRANSACTION_onSuccess = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, IFilterGrantedPermissionsCallback.DESCRIPTOR);
        }

        public static IFilterGrantedPermissionsCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IFilterGrantedPermissionsCallback.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IFilterGrantedPermissionsCallback)) {
                return (IFilterGrantedPermissionsCallback) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IFilterGrantedPermissionsCallback.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IFilterGrantedPermissionsCallback.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                onSuccess(parcel.createTypedArrayList(Permission.CREATOR));
            } else if (i == 2) {
                onError((ErrorStatus) _Parcel.readTypedObject(parcel, ErrorStatus.CREATOR));
            } else {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            return true;
        }

        private static class Proxy implements IFilterGrantedPermissionsCallback {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IFilterGrantedPermissionsCallback.DESCRIPTOR;
            }

            @Override // androidx.health.platform.client.service.IFilterGrantedPermissionsCallback
            public void onSuccess(List<Permission> list) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IFilterGrantedPermissionsCallback.DESCRIPTOR);
                    _Parcel.writeTypedList(parcelObtain, list, 0);
                    this.mRemote.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.health.platform.client.service.IFilterGrantedPermissionsCallback
            public void onError(ErrorStatus errorStatus) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IFilterGrantedPermissionsCallback.DESCRIPTOR);
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

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void writeTypedList(Parcel parcel, List<T> list, int i) {
            if (list == null) {
                parcel.writeInt(-1);
                return;
            }
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                writeTypedObject(parcel, list.get(i2), i);
            }
        }
    }
}
