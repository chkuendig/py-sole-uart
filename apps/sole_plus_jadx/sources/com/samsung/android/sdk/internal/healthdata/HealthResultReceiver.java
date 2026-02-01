package com.samsung.android.sdk.internal.healthdata;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.samsung.android.sdk.healthdata.HealthDataResolver;
import com.samsung.android.sdk.healthdata.HealthPermissionManager;
import com.samsung.android.sdk.healthdata.HealthResultHolder;
import com.samsung.android.sdk.internal.healthdata.ICallbackRegister;
import com.samsung.android.sdk.internal.healthdata.IHealthResultReceiver;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes5.dex */
public abstract class HealthResultReceiver implements Parcelable {
    public static final Parcelable.Creator<HealthResultReceiver> CREATOR = new a();
    protected final int mVersion;

    public static class Async extends HealthResultReceiver {
        private RemoteResultListener a;
        private ICallbackRegister b;
        private IHealthResultReceiver c;
        private final int d;
        private final int e;
        private Intent f;

        private class a extends ICallbackRegister.Stub {
            private a() {
            }

            @Override // com.samsung.android.sdk.internal.healthdata.ICallbackRegister
            public void cancel(int i) throws RemoteException {
                Async.this.onCancelResult(i);
            }

            @Override // com.samsung.android.sdk.internal.healthdata.ICallbackRegister
            public void setCallback(int i, IHealthResultReceiver iHealthResultReceiver) throws RemoteException {
                Async.this.c = iHealthResultReceiver;
            }

            /* synthetic */ a(Async async, a aVar) {
                this();
            }
        }

        private class b extends IHealthResultReceiver.Stub {
            private b() {
            }

            @Override // com.samsung.android.sdk.internal.healthdata.IHealthResultReceiver
            public void send(int i, Bundle bundle) {
                Async.this.a(i, bundle);
            }

            /* synthetic */ b(Async async, a aVar) {
                this();
            }
        }

        /* synthetic */ Async(Parcel parcel, a aVar) {
            this(parcel);
        }

        public void cancel(int i) throws RemoteException {
            ICallbackRegister iCallbackRegister = this.b;
            if (iCallbackRegister != null) {
                iCallbackRegister.cancel(i);
            }
        }

        public Intent getIntent() {
            return this.f;
        }

        @Override // com.samsung.android.sdk.internal.healthdata.HealthResultReceiver
        public boolean isSync() {
            return false;
        }

        protected void onCancelResult(int i) {
        }

        public <T extends HealthResultHolder.BaseResult> void registerListener(RemoteResultListener<T> remoteResultListener) {
            this.a = remoteResultListener;
        }

        public void send(int i, Bundle bundle) {
            IHealthResultReceiver iHealthResultReceiver = this.c;
            if (iHealthResultReceiver == null) {
                a(i, bundle);
            } else {
                try {
                    iHealthResultReceiver.send(i, bundle);
                } catch (RemoteException unused) {
                }
                this.c = null;
            }
        }

        public void setIntent(Intent intent) {
            this.f = intent;
        }

        @Override // com.samsung.android.sdk.internal.healthdata.HealthResultReceiver, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            synchronized (this) {
                a aVar = null;
                if (this.b == null) {
                    this.b = new a(this, aVar);
                }
                parcel.writeStrongBinder(this.b.asBinder());
            }
            parcel.writeInt(0);
            parcel.writeInt(this.d);
            parcel.writeInt(this.e);
            parcel.writeBundle(null);
            parcel.writeParcelable(this.f, 0);
        }

        protected Async() {
            super((a) null);
            this.d = 0;
            this.e = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i, Bundle bundle) {
            if (this.a == null) {
                return;
            }
            bundle.setClassLoader(HealthPermissionManager.PermissionResult.class.getClassLoader());
            int i2 = bundle.getInt("type", -1);
            if (i2 == 1) {
                this.a.onReceiveHealthResult(i, (HealthDataResolver.ReadResult) bundle.getParcelable(IpcUtil.KEY_PARCEL));
            } else if (i2 == 2) {
                this.a.onReceiveHealthResult(i, (HealthDataResolver.AggregateResult) bundle.getParcelable(IpcUtil.KEY_PARCEL));
            } else if (i2 != 3) {
                this.a.onReceiveHealthResult(i, (HealthResultHolder.BaseResult) bundle.getParcelable(IpcUtil.KEY_PARCEL));
            } else {
                int i3 = bundle.getInt("PERMISSION_RESULT_COUNT");
                bundle.remove("PERMISSION_RESULT_COUNT");
                bundle.remove("type");
                this.a.onReceiveHealthResult(i, new HealthPermissionManager.PermissionResult(bundle, i3));
            }
            this.a = null;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        private Async(Parcel parcel) {
            a aVar = null;
            super(parcel, aVar);
            this.c = new b(this, aVar);
            this.b = ICallbackRegister.Stub.asInterface(parcel.readStrongBinder());
            parcel.readInt();
            this.d = parcel.readInt();
            int i = parcel.readInt();
            this.e = i;
            parcel.readBundle(HealthResultReceiver.a(i));
            this.f = (Intent) parcel.readParcelable(Intent.class.getClassLoader());
            try {
                this.b.setCallback(0, this.c);
            } catch (RemoteException unused) {
            }
        }
    }

    public static class ForwardAsync extends HealthResultReceiver {
        private IHealthResultReceiver a;
        private RemoteResultListener b;
        private final AtomicBoolean c;
        private String d;

        private class a extends IHealthResultReceiver.Stub {
            private a() {
            }

            @Override // com.samsung.android.sdk.internal.healthdata.IHealthResultReceiver
            public void send(int i, Bundle bundle) {
                ForwardAsync.a(ForwardAsync.this, i, bundle);
            }

            /* synthetic */ a(ForwardAsync forwardAsync, a aVar) {
                this();
            }
        }

        private class b implements IHealthResultReceiver {
            private b() {
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                throw new UnsupportedOperationException();
            }

            @Override // com.samsung.android.sdk.internal.healthdata.IHealthResultReceiver
            public void send(int i, Bundle bundle) {
                ForwardAsync.a(ForwardAsync.this, i, bundle);
            }

            /* synthetic */ b(ForwardAsync forwardAsync, a aVar) {
                this();
            }
        }

        /* synthetic */ ForwardAsync(Parcel parcel, a aVar) {
            this(parcel);
        }

        static /* synthetic */ void a(ForwardAsync forwardAsync, int i, Bundle bundle) {
            if (forwardAsync.c.get() || forwardAsync.b == null) {
                return;
            }
            bundle.setClassLoader(HealthPermissionManager.PermissionResult.class.getClassLoader());
            int i2 = bundle.getInt("type", -1);
            if (i2 == 1) {
                HealthDataResolver.ReadResult readResult = (HealthDataResolver.ReadResult) bundle.getParcelable(IpcUtil.KEY_PARCEL);
                if (readResult != null) {
                    readResult.setResultId(bundle.getString(IpcUtil.KEY_RESULT_IDENTIFIER));
                }
                forwardAsync.b.onReceiveHealthResult(i, readResult);
            } else if (i2 == 2) {
                forwardAsync.b.onReceiveHealthResult(i, (HealthDataResolver.AggregateResult) bundle.getParcelable(IpcUtil.KEY_PARCEL));
            } else if (i2 != 3) {
                forwardAsync.b.onReceiveHealthResult(i, (HealthResultHolder.BaseResult) bundle.getParcelable(IpcUtil.KEY_PARCEL));
            } else {
                int i3 = bundle.getInt("PERMISSION_RESULT_COUNT");
                bundle.remove("PERMISSION_RESULT_COUNT");
                bundle.remove("type");
                forwardAsync.b.onReceiveHealthResult(i, new HealthPermissionManager.PermissionResult(bundle, i3));
            }
            forwardAsync.b = null;
        }

        public void cancel() throws RemoteException {
            this.c.set(true);
        }

        public String getReceiverId() {
            return this.d;
        }

        @Override // com.samsung.android.sdk.internal.healthdata.HealthResultReceiver
        public boolean isSync() {
            return false;
        }

        public <T extends HealthResultHolder.BaseResult> void registerListener(RemoteResultListener<T> remoteResultListener) {
            this.b = remoteResultListener;
        }

        public void send(int i, Bundle bundle) {
            try {
                this.a.send(i, bundle);
            } catch (RemoteException unused) {
            }
        }

        @Override // com.samsung.android.sdk.internal.healthdata.HealthResultReceiver, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            if (!(this.a instanceof a)) {
                this.a = new a(this, null);
            }
            parcel.writeStrongBinder(this.a.asBinder());
            parcel.writeInt(2);
            parcel.writeString(this.d);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public ForwardAsync() {
            a aVar = null;
            super(aVar);
            this.a = new b(this, aVar);
            this.c = new AtomicBoolean(false);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public ForwardAsync(String str) {
            a aVar = null;
            super(aVar);
            this.a = new b(this, aVar);
            this.c = new AtomicBoolean(false);
            this.d = str;
        }

        private ForwardAsync(Parcel parcel) {
            super(parcel, null);
            this.a = IHealthResultReceiver.Stub.asInterface(parcel.readStrongBinder());
            parcel.readInt();
            this.c = new AtomicBoolean(false);
            if (this.mVersion != 1) {
                return;
            }
            this.d = parcel.readString();
        }
    }

    public static class Sync extends HealthResultReceiver {
        private final int a;
        private final int b;
        private final Bundle c;

        /* synthetic */ Sync(int i, int i2, Bundle bundle, a aVar) {
            this(i, i2, bundle);
        }

        public Bundle getBundle() {
            return this.c;
        }

        @Override // com.samsung.android.sdk.internal.healthdata.HealthResultReceiver
        public boolean isSync() {
            return true;
        }

        @Override // com.samsung.android.sdk.internal.healthdata.HealthResultReceiver, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeStrongBinder(null);
            parcel.writeInt(1);
            parcel.writeInt(this.a);
            parcel.writeInt(this.b);
            parcel.writeBundle(this.c);
            parcel.writeParcelable(null, 0);
        }

        /* synthetic */ Sync(Parcel parcel, a aVar) {
            this(parcel);
        }

        private Sync(int i, int i2, Bundle bundle) {
            super((a) null);
            this.a = i;
            this.b = i2;
            this.c = bundle;
        }

        private Sync(Parcel parcel) {
            super(parcel, null);
            parcel.readStrongBinder();
            parcel.readInt();
            this.a = parcel.readInt();
            int i = parcel.readInt();
            this.b = i;
            this.c = parcel.readBundle(HealthResultReceiver.a(i));
        }
    }

    static class a implements Parcelable.Creator<HealthResultReceiver> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        public HealthResultReceiver createFromParcel(Parcel parcel) {
            int iDataPosition = parcel.dataPosition();
            parcel.readInt();
            parcel.readStrongBinder();
            int i = parcel.readInt();
            parcel.setDataPosition(iDataPosition);
            a aVar = null;
            if (i == 0) {
                return new Async(parcel, aVar);
            }
            if (i == 1) {
                return new Sync(parcel, aVar);
            }
            if (i == 2) {
                return new ForwardAsync(parcel, aVar);
            }
            throw new IllegalArgumentException("Invalid result parcel type : " + i);
        }

        @Override // android.os.Parcelable.Creator
        public HealthResultReceiver[] newArray(int i) {
            return new HealthResultReceiver[i];
        }
    }

    /* synthetic */ HealthResultReceiver(Parcel parcel, a aVar) {
        this(parcel);
    }

    static /* synthetic */ ClassLoader a(int i) {
        return i != 1 ? i != 2 ? i != 3 ? HealthResultHolder.BaseResult.class.getClassLoader() : HealthPermissionManager.PermissionResult.class.getClassLoader() : HealthDataResolver.AggregateResult.class.getClassLoader() : HealthDataResolver.ReadResult.class.getClassLoader();
    }

    public static HealthResultReceiver createSyncResult(int i, int i2, Bundle bundle) {
        return new Sync(i, i2, bundle, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public abstract boolean isSync();

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mVersion);
    }

    /* synthetic */ HealthResultReceiver(a aVar) {
        this();
    }

    private HealthResultReceiver() {
        this.mVersion = 1;
    }

    private HealthResultReceiver(Parcel parcel) {
        this.mVersion = parcel.readInt();
    }
}
