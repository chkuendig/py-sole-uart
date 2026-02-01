package androidx.health.platform.client.impl.ipc;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import androidx.health.platform.client.impl.ipc.internal.BaseQueueOperation;
import androidx.health.platform.client.impl.ipc.internal.ConnectionConfiguration;
import androidx.health.platform.client.impl.ipc.internal.ConnectionManager;
import androidx.health.platform.client.impl.ipc.internal.ExecutionTracker;
import androidx.health.platform.client.impl.ipc.internal.ListenerKey;
import androidx.health.platform.client.impl.ipc.internal.QueueOperation;
import com.google.common.base.Function;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.SettableFuture;

/* loaded from: classes2.dex */
public abstract class Client<S extends IInterface> {
    private static final int UNKNOWN_VERSION = -1;
    protected final ConnectionConfiguration mConnectionConfiguration;
    protected final ConnectionManager mConnectionManager;
    protected volatile int mCurrentVersion = -1;
    private final RemoteOperation<S, Integer> mRemoteVersionGetter;
    private final ServiceGetter<S> mServiceGetter;

    /* JADX INFO: Access modifiers changed from: protected */
    public interface ServiceGetter<S> {
        S getService(IBinder iBinder);
    }

    public Client(ClientConfiguration clientConfiguration, ConnectionManager connectionManager, final ServiceGetter<S> serviceGetter, final RemoteOperation<S, Integer> remoteOperation) {
        this.mConnectionConfiguration = new ConnectionConfiguration(clientConfiguration.getServicePackageName(), clientConfiguration.getApiClientName(), clientConfiguration.getBindAction(), new QueueOperation() { // from class: androidx.health.platform.client.impl.ipc.Client.1
            @Override // androidx.health.platform.client.impl.ipc.internal.QueueOperation
            public void setException(Throwable th) {
            }

            @Override // androidx.health.platform.client.impl.ipc.internal.QueueOperation
            public QueueOperation trackExecution(ExecutionTracker executionTracker) {
                return this;
            }

            @Override // androidx.health.platform.client.impl.ipc.internal.QueueOperation
            public void execute(IBinder iBinder) throws RemoteException {
                Client.this.mCurrentVersion = ((Integer) remoteOperation.execute((IInterface) serviceGetter.getService(iBinder))).intValue();
            }

            @Override // androidx.health.platform.client.impl.ipc.internal.QueueOperation
            public ConnectionConfiguration getConnectionConfiguration() {
                return Client.this.mConnectionConfiguration;
            }
        });
        this.mConnectionManager = connectionManager;
        this.mServiceGetter = serviceGetter;
        this.mRemoteVersionGetter = remoteOperation;
    }

    protected <R> ListenableFuture<R> execute(final RemoteOperation<S, R> remoteOperation) {
        return execute(new RemoteFutureOperation() { // from class: androidx.health.platform.client.impl.ipc.Client$$ExternalSyntheticLambda2
            @Override // androidx.health.platform.client.impl.ipc.RemoteFutureOperation
            public final void execute(Object obj, SettableFuture settableFuture) {
                settableFuture.set(remoteOperation.execute((IInterface) obj));
            }
        });
    }

    protected <R> ListenableFuture<R> execute(RemoteFutureOperation<S, R> remoteFutureOperation) {
        SettableFuture<R> settableFutureCreate = SettableFuture.create();
        this.mConnectionManager.scheduleForExecution(createQueueOperation(remoteFutureOperation, settableFutureCreate));
        return settableFutureCreate;
    }

    protected <R> ListenableFuture<R> executeWithVersionCheck(final int i, final RemoteFutureOperation<S, R> remoteFutureOperation) {
        final SettableFuture settableFutureCreate = SettableFuture.create();
        Futures.addCallback(getCurrentRemoteVersion(false), new FutureCallback<Integer>() { // from class: androidx.health.platform.client.impl.ipc.Client.2
            @Override // com.google.common.util.concurrent.FutureCallback
            public void onSuccess(Integer num) {
                if (num.intValue() < i) {
                    Client.this.mConnectionManager.scheduleForExecution(new BaseQueueOperation(Client.this.mConnectionConfiguration));
                    settableFutureCreate.setException(Client.this.getApiVersionCheckFailureException(num.intValue(), i));
                } else {
                    Client.this.mConnectionManager.scheduleForExecution(Client.this.createQueueOperation(remoteFutureOperation, settableFutureCreate));
                }
            }

            @Override // com.google.common.util.concurrent.FutureCallback
            public void onFailure(Throwable th) {
                settableFutureCreate.setException(th);
            }
        }, MoreExecutors.directExecutor());
        return settableFutureCreate;
    }

    protected ListenableFuture<Integer> getCurrentRemoteVersion(boolean z) {
        if (this.mCurrentVersion == -1 || z) {
            return Futures.transform(execute(this.mRemoteVersionGetter), new Function() { // from class: androidx.health.platform.client.impl.ipc.Client$$ExternalSyntheticLambda1
                @Override // com.google.common.base.Function
                public final Object apply(Object obj) {
                    return this.f$0.m7580x4bf610cf((Integer) obj);
                }
            }, MoreExecutors.directExecutor());
        }
        return Futures.immediateFuture(Integer.valueOf(this.mCurrentVersion));
    }

    /* renamed from: lambda$getCurrentRemoteVersion$1$androidx-health-platform-client-impl-ipc-Client, reason: not valid java name */
    /* synthetic */ Integer m7580x4bf610cf(Integer num) {
        this.mCurrentVersion = num.intValue();
        return Integer.valueOf(this.mCurrentVersion);
    }

    protected <R> ListenableFuture<R> registerListener(ListenerKey listenerKey, final RemoteOperation<S, R> remoteOperation) {
        return registerListener(listenerKey, new RemoteFutureOperation() { // from class: androidx.health.platform.client.impl.ipc.Client$$ExternalSyntheticLambda0
            @Override // androidx.health.platform.client.impl.ipc.RemoteFutureOperation
            public final void execute(Object obj, SettableFuture settableFuture) {
                settableFuture.set(remoteOperation.execute((IInterface) obj));
            }
        });
    }

    protected <R> ListenableFuture<R> registerListener(ListenerKey listenerKey, RemoteFutureOperation<S, R> remoteFutureOperation) {
        SettableFuture<R> settableFutureCreate = SettableFuture.create();
        this.mConnectionManager.registerListener(listenerKey, createQueueOperation(remoteFutureOperation, settableFutureCreate));
        return settableFutureCreate;
    }

    protected <R> ListenableFuture<R> unregisterListener(ListenerKey listenerKey, final RemoteOperation<S, R> remoteOperation) {
        return unregisterListener(listenerKey, new RemoteFutureOperation() { // from class: androidx.health.platform.client.impl.ipc.Client$$ExternalSyntheticLambda3
            @Override // androidx.health.platform.client.impl.ipc.RemoteFutureOperation
            public final void execute(Object obj, SettableFuture settableFuture) {
                settableFuture.set(remoteOperation.execute((IInterface) obj));
            }
        });
    }

    protected <R> ListenableFuture<R> unregisterListener(ListenerKey listenerKey, RemoteFutureOperation<S, R> remoteFutureOperation) {
        SettableFuture<R> settableFutureCreate = SettableFuture.create();
        this.mConnectionManager.unregisterListener(listenerKey, createQueueOperation(remoteFutureOperation, settableFutureCreate));
        return settableFutureCreate;
    }

    protected Exception getApiVersionCheckFailureException(int i, int i2) {
        return new ApiVersionException(i, i2);
    }

    ConnectionConfiguration getConnectionConfiguration() {
        return this.mConnectionConfiguration;
    }

    ConnectionManager getConnectionManager() {
        return this.mConnectionManager;
    }

    <R> QueueOperation createQueueOperation(final RemoteFutureOperation<S, R> remoteFutureOperation, final SettableFuture<R> settableFuture) {
        return new BaseQueueOperation(this.mConnectionConfiguration) { // from class: androidx.health.platform.client.impl.ipc.Client.3
            @Override // androidx.health.platform.client.impl.ipc.internal.BaseQueueOperation, androidx.health.platform.client.impl.ipc.internal.QueueOperation
            public void execute(IBinder iBinder) throws RemoteException {
                remoteFutureOperation.execute(Client.this.getService(iBinder), settableFuture);
            }

            @Override // androidx.health.platform.client.impl.ipc.internal.BaseQueueOperation, androidx.health.platform.client.impl.ipc.internal.QueueOperation
            public void setException(Throwable th) {
                settableFuture.setException(th);
            }

            @Override // androidx.health.platform.client.impl.ipc.internal.BaseQueueOperation, androidx.health.platform.client.impl.ipc.internal.QueueOperation
            public QueueOperation trackExecution(ExecutionTracker executionTracker) {
                executionTracker.track(settableFuture);
                return this;
            }
        };
    }

    S getService(IBinder iBinder) {
        return this.mServiceGetter.getService(iBinder);
    }
}
