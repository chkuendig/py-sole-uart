package com.samsung.android.sdk.internal.healthdata;

import android.os.Looper;
import android.os.RemoteException;
import com.samsung.android.sdk.healthdata.HealthDataResolver;
import com.samsung.android.sdk.healthdata.HealthResultHolder;
import com.samsung.android.sdk.healthdata.IDataResolver;
import com.samsung.android.sdk.internal.healthdata.HealthResultReceiver;

/* loaded from: classes5.dex */
public final class IpcUtil {
    public static final String KEY_CODE = "key";
    public static final String KEY_COUNT = "count";
    public static final String KEY_PARCEL = "parcel";
    public static final String KEY_RESULT_IDENTIFIER = "result_identifier";
    public static final String KEY_TYPE = "type";
    public static final int TYPE_AGGREGATE = 2;
    public static final int TYPE_NONE = 0;
    public static final int TYPE_PERMISSION = 3;
    public static final int TYPE_READ = 1;

    /* JADX INFO: Add missing generic type declarations: [T] */
    static class a<T> extends HealthResultHolderImpl<T> {
        final /* synthetic */ HealthResultReceiver.ForwardAsync i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Looper looper, HealthResultReceiver.ForwardAsync forwardAsync) {
            super(looper);
            this.i = forwardAsync;
        }

        @Override // com.samsung.android.sdk.internal.healthdata.HealthResultHolderImpl
        protected void cancelResult() throws RemoteException {
            this.i.cancel();
        }
    }

    static class b extends HealthResultHolderImpl<HealthDataResolver.ReadResult> {
        final /* synthetic */ HealthResultReceiver.ForwardAsync i;
        final /* synthetic */ IDataResolver j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Looper looper, HealthResultReceiver.ForwardAsync forwardAsync, IDataResolver iDataResolver) {
            super(looper);
            this.i = forwardAsync;
            this.j = iDataResolver;
        }

        @Override // com.samsung.android.sdk.internal.healthdata.HealthResultHolderImpl
        protected HealthResultHolder.BaseResult acquireResult() {
            return ((HealthDataResolver.ReadResult) super.acquireResult()).setResolver(this.j);
        }

        @Override // com.samsung.android.sdk.internal.healthdata.HealthResultHolderImpl
        protected void cancelResult() throws RemoteException {
            this.i.cancel();
        }
    }

    public static HealthResultHolder<HealthResultHolder.BaseResult> createAndSetResult(HealthResultHolder.BaseResult baseResult, Looper looper) {
        HealthResultHolderImpl healthResultHolderImpl = new HealthResultHolderImpl(looper);
        healthResultHolderImpl.setResult(baseResult);
        return healthResultHolderImpl;
    }

    public static HealthResultHolder<HealthDataResolver.ReadResult> makeReadResultHolder(HealthResultReceiver.ForwardAsync forwardAsync, Looper looper, IDataResolver iDataResolver) {
        b bVar = new b(looper, forwardAsync, iDataResolver);
        forwardAsync.registerListener(bVar);
        return bVar;
    }

    public static <T extends HealthResultHolder.BaseResult> HealthResultHolder<T> makeResultHolder(HealthResultReceiver.ForwardAsync forwardAsync, Looper looper) {
        a aVar = new a(looper, forwardAsync);
        forwardAsync.registerListener(aVar);
        return aVar;
    }
}
