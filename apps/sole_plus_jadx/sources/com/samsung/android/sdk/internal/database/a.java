package com.samsung.android.sdk.internal.database;

import android.database.CursorWindow;
import android.database.DatabaseUtils;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: BulkCursorNative.java */
/* loaded from: classes5.dex */
final class a implements IBulkCursor {
    private final IBinder a;
    private Bundle b = null;

    public a(IBinder iBinder) {
        this.a = iBinder;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.a;
    }

    @Override // com.samsung.android.sdk.internal.database.IBulkCursor
    public void close() throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(IBulkCursor.descriptor);
            this.a.transact(7, parcelObtain, parcelObtain2, 0);
            DatabaseUtils.readExceptionFromParcel(parcelObtain2);
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }

    @Override // com.samsung.android.sdk.internal.database.IBulkCursor
    public void deactivate() throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(IBulkCursor.descriptor);
            this.a.transact(2, parcelObtain, parcelObtain2, 0);
            DatabaseUtils.readExceptionFromParcel(parcelObtain2);
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }

    @Override // com.samsung.android.sdk.internal.database.IBulkCursor
    public Bundle getExtras() throws RemoteException {
        if (this.b == null) {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken(IBulkCursor.descriptor);
                this.a.transact(5, parcelObtain, parcelObtain2, 0);
                DatabaseUtils.readExceptionFromParcel(parcelObtain2);
                this.b = parcelObtain2.readBundle();
            } finally {
                parcelObtain.recycle();
                parcelObtain2.recycle();
            }
        }
        return this.b;
    }

    @Override // com.samsung.android.sdk.internal.database.IBulkCursor
    public CursorWindow getWindow(int i) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(IBulkCursor.descriptor);
            parcelObtain.writeInt(i);
            this.a.transact(1, parcelObtain, parcelObtain2, 0);
            DatabaseUtils.readExceptionFromParcel(parcelObtain2);
            return parcelObtain2.readInt() == 1 ? CursorWindow.newFromParcel(parcelObtain2) : null;
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }

    @Override // com.samsung.android.sdk.internal.database.IBulkCursor
    public void onMove(int i) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(IBulkCursor.descriptor);
            parcelObtain.writeInt(i);
            this.a.transact(4, parcelObtain, parcelObtain2, 0);
            DatabaseUtils.readExceptionFromParcel(parcelObtain2);
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }

    @Override // com.samsung.android.sdk.internal.database.IBulkCursor
    public int requery() throws RemoteException {
        int i;
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(IBulkCursor.descriptor);
            boolean zTransact = this.a.transact(3, parcelObtain, parcelObtain2, 0);
            DatabaseUtils.readExceptionFromParcel(parcelObtain2);
            if (zTransact) {
                i = parcelObtain2.readInt();
                this.b = parcelObtain2.readBundle();
            } else {
                i = -1;
            }
            return i;
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }

    @Override // com.samsung.android.sdk.internal.database.IBulkCursor
    public Bundle respond(Bundle bundle) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(IBulkCursor.descriptor);
            parcelObtain.writeBundle(bundle);
            this.a.transact(6, parcelObtain, parcelObtain2, 0);
            DatabaseUtils.readExceptionFromParcel(parcelObtain2);
            return parcelObtain2.readBundle();
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }
}
